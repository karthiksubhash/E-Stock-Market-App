package com.estockcompanyinfoservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.estockcompanyinfoservice.model.CompanyInfoModel;

public interface CompanyInfoRepository extends JpaRepository<CompanyInfoModel, Long>  {

}
