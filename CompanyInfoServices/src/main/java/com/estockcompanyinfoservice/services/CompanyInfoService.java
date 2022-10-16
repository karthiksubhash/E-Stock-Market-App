package com.estockcompanyinfoservice.services;

import org.springframework.transaction.annotation.Transactional;

import com.estockcompanyinfoservice.dto.CompanyInfoModelDTO;
import com.estockcompanyinfoservice.mapper.CompanyInfoModelMapper;
import com.estockcompanyinfoservice.model.CompanyInfoModel;
import com.estockcompanyinfoservice.repository.CompanyInfoRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CompanyInfoService {

	@Autowired
	private CompanyInfoRepository companyInfoRepository;

	@Autowired
	MessageService messageService;

	@Autowired
	CompanyInfoModel companyInfoModel;

	@Autowired
	CompanyInfoModelDTO companyInfo;

	private static final Logger LOGGER=LoggerFactory.getLogger(CompanyInfoService.class);

	public CompanyInfoModelDTO save(CompanyInfoModelDTO companyInfo) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");  
		LocalDateTime now = LocalDateTime.now(); 

		companyInfo.setDateTime(dtf.format(now));
		try {
			CompanyInfoModelMapper.mapperDTOToModel(companyInfo,companyInfoModel);
		} catch (Exception e) {
			LOGGER.error(e.toString());
		}

		companyInfoRepository.save(companyInfoModel);

		CompanyInfoModelDTO companyInfoModelDTO = getCompanyInfo(companyInfoModel.getCode());
		if(null != companyInfoModelDTO.getCode()) {
			messageService.sendCreateRequestToEStockMarketApp(companyInfoModelDTO); 
		}
		return companyInfoModelDTO;
	}

	public boolean delete(Long code) {
		if(null !=  code && null !=companyInfoRepository.getById(code)) {
			companyInfoRepository.deleteById(code);
			messageService.sendDeleteRequestToEStockMarketApp(code); 
			messageService.sendDeleteRequestToStockInfo(code);
			return true;
		}
		return false;
	}

	public CompanyInfoModelDTO getCompanyInfo(Long id) {

		CompanyInfoModel companyInfoMode=  companyInfoRepository.getById(id);  
		CompanyInfoModelMapper.mapperModelToDTO(companyInfoMode, companyInfo);
		return companyInfo;
	}

	public CompanyInfoModel demoCompanyinfo() {
		try {
			CompanyInfoModel com = new CompanyInfoModel();
			com.setName("ITC");
			com.setCeo("Yogesh");
			com.setTurnover("1000000");
			com.setWebsite("https://www.itcportal.com/");
			com.setStockexchangeenlisted("BSE");
			return com;

		} catch(Exception ex) {
			LOGGER.error(ex.toString());
		}
		return null;
	}

		

}
