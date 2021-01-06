package com.revature.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.collection.internal.PersistentBag;
import org.hibernate.proxy.HibernateProxy;

@Entity
public class Den {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "den_id")
	private int denId;

	@Column(name = "den_name")
	private String denName;

	private String material;
	
	@Column(name = "max_capacity")
	private int maxCapacity;
	
	@Column(name = "current_capacity")
	private int currentCapacity;
	
	private String beauty;
	
	private BigDecimal size;

	@OneToMany(mappedBy = "home", fetch = FetchType.LAZY)
	private List<Bear> inhabitants;
	
	
	
	public Den() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Den(int denId, String denName, String material, int maxCapacity, int currentCapacity, String beauty,
			BigDecimal size, List<Bear> inhabitants) {
		super();
		this.denId = denId;
		this.denName = denName;
		this.material = material;
		this.maxCapacity = maxCapacity;
		this.currentCapacity = currentCapacity;
		this.beauty = beauty;
		this.size = size;
		this.inhabitants = inhabitants;
	}



	public int getDenId() {
		return denId;
	}



	public void setDenId(int denId) {
		this.denId = denId;
	}



	public String getDenName() {
		return denName;
	}



	public void setDenName(String denName) {
		this.denName = denName;
	}



	public String getMaterial() {
		return material;
	}



	public void setMaterial(String material) {
		this.material = material;
	}



	public int getMaxCapacity() {
		return maxCapacity;
	}



	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}



	public int getCurrentCapacity() {
		return currentCapacity;
	}



	public void setCurrentCapacity(int currentCapacity) {
		this.currentCapacity = currentCapacity;
	}



	public String getBeauty() {
		return beauty;
	}



	public void setBeauty(String beauty) {
		this.beauty = beauty;
	}



	public BigDecimal getSize() {
		return size;
	}



	public void setSize(BigDecimal size) {
		this.size = size;
	}



	public List<Bear> getInhabitants() {
		return inhabitants;
	}



	public void setInhabitants(List<Bear> inhabitants) {
		this.inhabitants = inhabitants;
	}



	@Override
	public String toString() {
		String inhabitants = "";
		if(this.inhabitants instanceof HibernateProxy) {
			inhabitants = "{}";
		}else if(this.inhabitants instanceof PersistentBag){
			inhabitants = "[]";
		}else{
			inhabitants = this.inhabitants.toString();
		}
		return "Den [denId=" + denId + ", denName=" + denName + ", material=" + material + ", maxCapacity="
				+ maxCapacity + ", currentCapacity=" + currentCapacity + ", beauty=" + beauty + ", size=" + size
				+ ", inhabitants=" + inhabitants + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beauty == null) ? 0 : beauty.hashCode());
		result = prime * result + currentCapacity;
		result = prime * result + denId;
		result = prime * result + ((denName == null) ? 0 : denName.hashCode());
		result = prime * result + ((inhabitants == null) ? 0 : inhabitants.hashCode());
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		result = prime * result + maxCapacity;
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		Den other = (Den) obj;
		if (beauty == null) {
			if (other.beauty != null)
				return false;
		} else if (!beauty.equals(other.beauty))
			return false;
		if (currentCapacity != other.currentCapacity)
			return false;
		if (denId != other.denId)
			return false;
		if (denName == null) {
			if (other.denName != null)
				return false;
		} else if (!denName.equals(other.denName))
			return false;
		if (inhabitants == null) {
			if (other.inhabitants != null)
				return false;
		} else if (!inhabitants.equals(other.inhabitants))
			return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		if (maxCapacity != other.maxCapacity)
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}

	
	
}
