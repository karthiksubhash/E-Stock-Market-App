package com.EStockMarketApp.EStockMarketInfoReader.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.EStockMarketApp.EStockMarketInfoReader.model.EstockInfoModel;

public interface CompanyStockInfoRepository  extends MongoRepository<EstockInfoModel, Long> {

}
