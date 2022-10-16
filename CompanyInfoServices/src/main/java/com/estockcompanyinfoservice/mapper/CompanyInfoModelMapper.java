package com.estockcompanyinfoservice.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.estockcompanyinfoservice.dto.CompanyInfoModelDTO;
import com.estockcompanyinfoservice.model.CompanyInfoModel;

public interface CompanyInfoModelMapper {


	public static void mapperDTOToModel(CompanyInfoModelDTO companyInfoFrom, CompanyInfoModel companyInfoModelTo) throws Exception  {
		companyInfoModelTo.setCeo(companyInfoFrom.getCeo());

		companyInfoModelTo.setName(companyInfoFrom.getName());
		companyInfoModelTo.setStockexchangeenlisted(companyInfoFrom.getStockexchangeenlisted());
		companyInfoModelTo.setTurnover(companyInfoFrom.getTurnover());
		companyInfoModelTo.setWebsite(companyInfoFrom.getWebsite());

		try {
			DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm", Locale.ENGLISH);
			LocalDateTime dateTime = LocalDateTime.parse(companyInfoFrom.getDateTime(), inputFormatter);
			companyInfoModelTo.setDateTime(dateTime);
		}catch (Exception ex) {
			throw(ex); 
		}
	}

	public static void mapperModelToDTO(CompanyInfoModel companyInfoMode, CompanyInfoModelDTO companyInfoDTO) {
		companyInfoDTO.setCeo(companyInfoMode.getCeo());
		companyInfoDTO.setDateTime(companyInfoMode.getDateTime().toString());
		companyInfoDTO.setName(companyInfoMode.getName());
		companyInfoDTO.setStockexchangeenlisted(companyInfoMode.getStockexchangeenlisted());
		companyInfoDTO.setTurnover(companyInfoMode.getTurnover());
		companyInfoDTO.setWebsite(companyInfoMode.getWebsite());
		companyInfoDTO.setCode(companyInfoMode.getCode());
	}

}
