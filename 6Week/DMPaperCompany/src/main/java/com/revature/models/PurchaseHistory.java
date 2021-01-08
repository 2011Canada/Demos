package com.revature.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class PurchaseHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int purchaseHistoryId;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "customerId")
	private Customer purchaser;
	
	@OneToMany(mappedBy = "history", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference//hey jackson if you are turning this field into json and you ever run into this field again, stop
	private List<PurchaseHistoryLine> totalPurchase;

	public PurchaseHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PurchaseHistory(int purchaseHistoryId, Customer purchaser, List<PurchaseHistoryLine> totalPurchase) {
		super();
		this.purchaseHistoryId = purchaseHistoryId;
		this.purchaser = purchaser;
		this.totalPurchase = totalPurchase;
	}

	public int getPurchaseHistoryId() {
		return purchaseHistoryId;
	}

	public void setPurchaseHistoryId(int purchaseHistoryId) {
		this.purchaseHistoryId = purchaseHistoryId;
	}

	public Customer getPurchaser() {
		return purchaser;
	}

	public void setPurchaser(Customer purchaser) {
		this.purchaser = purchaser;
	}

	public List<PurchaseHistoryLine> getTotalPurchase() {
		return totalPurchase;
	}

	public void setTotalPurchase(List<PurchaseHistoryLine> totalPurchase) {
		this.totalPurchase = totalPurchase;
	}

	@Override
	public String toString() {
		return "PurchaseHistory [purchaseHistoryId=" + purchaseHistoryId + ", purchaser=" + purchaser
				+ ", totalPurchase=" + totalPurchase + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + purchaseHistoryId;
		result = prime * result + ((purchaser == null) ? 0 : purchaser.hashCode());
		result = prime * result + ((totalPurchase == null) ? 0 : totalPurchase.hashCode());
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
		PurchaseHistory other = (PurchaseHistory) obj;
		if (purchaseHistoryId != other.purchaseHistoryId)
			return false;
		if (purchaser == null) {
			if (other.purchaser != null)
				return false;
		} else if (!purchaser.equals(other.purchaser))
			return false;
		if (totalPurchase == null) {
			if (other.totalPurchase != null)
				return false;
		} else if (!totalPurchase.equals(other.totalPurchase))
			return false;
		return true;
	}
	
	
	
}
