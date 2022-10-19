package com.EStockMarketApp.EStockMarketInfoReader.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EStockMarketApp.EStockMarketInfoReader.dto.EstockInfoModelDTO;
import com.EStockMarketApp.EStockMarketInfoReader.model.EstockInfoModel;
import com.EStockMarketApp.EStockMarketInfoReader.repository.CompanyStockInfoRepository;


@Service
public class CompanyStockInfoService {

	@Autowired
	CompanyStockInfoRepository companyStockInfoRepository;
	
	public EstockInfoModelDTO findInfoById(Long id) {
		
		Optional<EstockInfoModel> estockInfoModel= companyStockInfoRepository.findById(id);
		
		if(estockInfoModel.isPresent()) {
			EstockInfoModelDTO estockInfoModelDTO = new EstockInfoModelDTO();
			EstockInfoModel estockInfo = estockInfoModel.get();
			estockInfoModelDTO.mapperToDTO(estockInfo, estockInfoModelDTO);
			if(null != estockInfoModelDTO.getId()) {
				return estockInfoModelDTO;
			}
		}
		return null;	
	}
}
