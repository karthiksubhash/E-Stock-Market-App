package com.estockcompanyinfoservice.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="company_info")
@Component 
public class CompanyInfoModel  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	private String name;
	private String ceo;
	private String turnover;
	private String website;
	private String stockexchangeenlisted;
	private LocalDateTime dateTime;



	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}


	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public CompanyInfoModel() {
		super();
	}
	public CompanyInfoModel(Long code, String name, String ceo, String turnover, String website,
			String stockexchangeenlisted,LocalDateTime dateTime) {
		super();
		this.code = code;
		this.name = name;
		this.ceo = ceo;
		this.turnover = turnover;
		this.website = website;
		this.stockexchangeenlisted = stockexchangeenlisted;
		this.dateTime= dateTime;
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
	@Override
	public String toString() {
		return "CompanyInfoModel [code=" + code + ", name=" + name + ", ceo=" + ceo + ", turnover=" + turnover
				+ ", website=" + website + ", stockexchangeenlisted=" + stockexchangeenlisted + ", dateTime=" + dateTime
				+ "]";
	}




}
