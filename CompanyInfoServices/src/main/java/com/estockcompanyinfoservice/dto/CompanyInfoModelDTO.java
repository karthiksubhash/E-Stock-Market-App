package com.estockcompanyinfoservice.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;


@Component
public class CompanyInfoModelDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long code;
	
	public CompanyInfoModelDTO() {
		super();
	}

	@NotBlank(message = "Company Name is mandatory to fill !!")
	private String name;
	@NotBlank(message = "Company CEO Name is mandatory to fill !!")
	private String ceo;
	@NotBlank(message = "Company turnover Name is mandatory to fill !!")
	private String turnover;
	@NotBlank(message = "Company website Name is mandatory to fill !!")
	private String website;
	@NotBlank(message = "Company stock Exchange Enlisted Name is mandatory to fill !!")
	private String stockexchangeenlisted;
	private String dateTime;

	
	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public String getTurnover() {
		return turnover;
	}
	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getStockexchangeenlisted() {
		return stockexchangeenlisted;
	}
	public void setStockexchangeenlisted(String stockexchangeenlisted) {
		this.stockexchangeenlisted = stockexchangeenlisted;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "CompanyInfoModelDTO [code=" + code + ", name=" + name + ", ceo=" + ceo + ", turnover=" + turnover
				+ ", website=" + website + ", stockexchangeenlisted=" + stockexchangeenlisted + ", dateTime=" + dateTime
				+ "]";
	}

	public CompanyInfoModelDTO(Long code, @NotBlank(message = "Company Name is mandatory to fill !!") String name,
			@NotBlank(message = "Company CEO Name is mandatory to fill !!") String ceo,
			@NotBlank(message = "Company turnover Name is mandatory to fill !!") String turnover,
			@NotBlank(message = "Company website Name is mandatory to fill !!") String website,
			@NotBlank(message = "Company stock Exchange Enlisted Name is mandatory to fill !!") String stockexchangeenlisted,
			String dateTime) {
		super();
		this.code = code;
		this.name = name;
		this.ceo = ceo;
		this.turnover = turnover;
		this.website = website;
		this.stockexchangeenlisted = stockexchangeenlisted;
		
	}

	/**
	 * 
	 */

	
}
