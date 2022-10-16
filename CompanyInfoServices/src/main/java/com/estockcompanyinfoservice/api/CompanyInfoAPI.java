package com.estockcompanyinfoservice.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.estockcompanyinfoservice.dto.CompanyInfoModelDTO;
import com.estockcompanyinfoservice.model.CompanyInfoModel;
import com.estockcompanyinfoservice.services.CompanyInfoService;

@RestController
public class CompanyInfoAPI {

	@Autowired 
	CompanyInfoService companyInfoService;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(CompanyInfoAPI.class);

	@GetMapping("/demoCompInfo")
	public CompanyInfoModel getCompanyinfo() {
		return companyInfoService.demoCompanyinfo();
	}

	@PostMapping("/company/register")
	public ResponseEntity<CompanyInfoModelDTO> saveCompany(@RequestBody CompanyInfoModelDTO companyInfo) {
		ResponseEntity<CompanyInfoModelDTO> responseEntity = null;
		try {
			CompanyInfoModelDTO companyInfoDTO = companyInfoService.save(companyInfo);
			if(null != companyInfoDTO.getCode()) {
				responseEntity= ResponseEntity.status(HttpStatus.CREATED).body(companyInfoDTO);
			}else {
			responseEntity= ResponseEntity.status(HttpStatus.BAD_REQUEST).body(companyInfo);
			}
		}
		catch (Exception ex) {
			responseEntity= ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(companyInfo);
			LOGGER.error(ex.toString());
		}
		return responseEntity;
	}

	@GetMapping("/company/info/{companycode}")
	public CompanyInfoModelDTO getCompanyinfo(@PathVariable Long companycode) { 
		return companyInfoService.getCompanyInfo(companycode);
	}

	@DeleteMapping("/company/delete/{companycode}")
	public void deleteCompany(@PathVariable Long companycode) {
		companyInfoService.delete(companycode);
	}

}
