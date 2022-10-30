package com.estockcompanyinfoservice.api;

import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.estockcompanyinfoservice.CompanyInfoServicesApplication;
import com.estockcompanyinfoservice.dto.CompanyInfoModelDTO;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= CompanyInfoServicesApplication.class,webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompanyInfoAPIIT {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test 
	public void testSaveCompany() throws Exception {

		CompanyInfoModelDTO stubCompanyInfo=   new CompanyInfoModelDTO(7L,"ITC","Yogesh","1000000","https://www.itcportal.com/","BSE","2022-10-19T22:41");
		
		HttpEntity<CompanyInfoModelDTO> entity = new HttpEntity<>(stubCompanyInfo,headers);

		ResponseEntity<String> response= restTemplate.exchange(
				createURLWithPort("/company/register"),
				HttpMethod.POST,entity, String.class);

		assertEquals(HttpStatus.CREATED.value(), response.getStatusCodeValue());
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:"+ port + uri;
	}
}
