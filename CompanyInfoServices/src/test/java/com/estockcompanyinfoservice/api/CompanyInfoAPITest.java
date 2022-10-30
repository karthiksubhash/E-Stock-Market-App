package com.estockcompanyinfoservice.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.estockcompanyinfoservice.dto.CompanyInfoModelDTO;
import com.estockcompanyinfoservice.services.CompanyInfoService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value= CompanyInfoAPI.class)
@WithMockUser
public class CompanyInfoAPITest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CompanyInfoService companyInfoService; 

	private String stubCompanyInfo="{\r\n"
			+ "    \"code\": 7,\r\n"
			+ "    \"name\": \"ITC\",\r\n"
			+ "    \"ceo\": \"Yogesh\",\r\n"
			+ "    \"turnover\": \"1000000\",\r\n"
			+ "    \"website\": \"https://www.itcportal.com/\",\r\n"
			+ "    \"stockexchangeenlisted\": \"BSE\",\r\n"
			+ "    \"dateTime\": \"2022-10-08T16:25:37.862431\"\r\n"
			+ "}";


	@Test
	public void saveCompanyTest() throws Exception {

		CompanyInfoModelDTO companyInfoModelDTO =  new CompanyInfoModelDTO(7L,"ITC","Yogesh","1000000","https://www.itcportal.com/","BSE","2022-10-19T22:41");

		Mockito.when(companyInfoService.save(Mockito.any(CompanyInfoModelDTO.class))).thenReturn(companyInfoModelDTO);

		RequestBuilder requestBuilder= MockMvcRequestBuilders
				.post("/company/register")
				.accept(MediaType.APPLICATION_JSON)
				.content(stubCompanyInfo)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

	}

	@Test
	public void deleteCompanyTest() throws Exception {

		String path="/company/delete/7";

		Mockito.when(companyInfoService.delete(Mockito.anyLong())).thenReturn(true);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.delete(path)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

}
