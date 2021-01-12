package com.revature.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PaperOption {

	private String standardSize;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paperId;
	
	private int packageAmount;
	
	private BigDecimal price;
	
	private String type;

	public PaperOption() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaperOption(String standardSize, int paperId, int packageAmount, BigDecimal price, String type) {
		super();
		this.standardSize = standardSize;
		this.paperId = paperId;
		this.packageAmount = packageAmount;
		this.price = price;
		this.type = type;
	}

	public String getStandardSize() {
		return standardSize;
	}

	public void setStandardSize(String standardSize) {
		this.standardSize = standardSize;
	}

	public int getPaperId() {
		return paperId;
	}

	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}

	public int getPackageAmount() {
		return packageAmount;
	}

	public void setPackageAmount(int packageAmount) {
		this.packageAmount = packageAmount;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + packageAmount;
		result = prime * result + paperId;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((standardSize == null) ? 0 : standardSize.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaperOption other = (PaperOption) obj;
		if (packageAmount != other.packageAmount)
			return false;
		if (paperId != other.paperId)
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (standardSize == null) {
			if (other.standardSize != null)
				return false;
		} else if (!standardSize.equals(other.standardSize))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PaperOption [standardSize=" + standardSize + ", paperId=" + paperId + ", packageAmount=" + packageAmount
				+ ", price=" + price + ", type=" + type + "]";
	}
	
	
	
}
