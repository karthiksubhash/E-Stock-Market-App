package com.EStockMarketApp.EStockMarketInfoReader.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.EStockMarketApp.EStockMarketInfoReader.model.StockModel;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString 
public class StockInfoModelDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long companyCode;
	private String stockPrice;
	private String dateTime;
	private Boolean isDeleted;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(StockInfoModelDTO.class);
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(Long companyCode) {
		this.companyCode = companyCode;
	}
	public String getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(String stockPrice) {
		this.stockPrice = stockPrice;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public void mapperToModel(StockModel stockModel, StockInfoModelDTO stockModelDTO) {
		stockModel.setCompanyCode(stockModelDTO.getCompanyCode());
		stockModel.setId(stockModelDTO.getId());
		stockModel.setStockPrice(stockModelDTO.getStockPrice());
		stockModel.setIsDeleted(stockModelDTO.getIsDeleted());
		try {
			DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm", Locale.ENGLISH);
			LocalDateTime dateTime = LocalDateTime.parse(stockModelDTO.getDateTime(), inputFormatter);
			stockModel.setDateTime(dateTime);
		}catch (Exception ex) {
			LOGGER.error(ex.toString());
		}
	}
	
	public void mapperToDTO(StockModel stockModel, StockInfoModelDTO stockModelDTO) {
		stockModelDTO.setCompanyCode(stockModel.getCompanyCode());
		stockModelDTO.setId(stockModel.getId());
		stockModelDTO.setStockPrice(stockModel.getStockPrice());
		stockModelDTO.setDateTime(stockModel.getDateTime().toString());
		stockModelDTO.setIsDeleted(stockModel.getIsDeleted());
	}
	
	public List<StockInfoModelDTO> mapperToDTOList(List<StockModel> stockModelList) {
		List<StockInfoModelDTO> stockInfoModelDTOList = new ArrayList<StockInfoModelDTO>();
		if(null != stockModelList && !stockModelList.isEmpty()) {
			for(StockModel stockModel: stockModelList) {
				StockInfoModelDTO stockInfoModelDTO = new StockInfoModelDTO();
				stockInfoModelDTO.mapperToDTO(stockModel, stockInfoModelDTO);
				stockInfoModelDTOList.add(stockInfoModelDTO);
			}
		}
		return stockInfoModelDTOList; 
	}
	
	public List<StockModel> mapperToModelList(List<StockInfoModelDTO> stockInfoModelDTOList) {
		List<StockModel> stockModelList = new ArrayList<StockModel>();
		StockInfoModelDTO stockInfoModelDTO = new StockInfoModelDTO();
		
		if(null != stockInfoModelDTOList && !stockInfoModelDTOList.isEmpty()) {
			for(StockInfoModelDTO stockInfoDTO: stockInfoModelDTOList) {
				StockModel stockModel= new StockModel();
				stockInfoModelDTO.mapperToModel(stockModel, stockInfoDTO);
				stockModelList.add(stockModel);
			}
		}
		return stockModelList; 
	}
}
