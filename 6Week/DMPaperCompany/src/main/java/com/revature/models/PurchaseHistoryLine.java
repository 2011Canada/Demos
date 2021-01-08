package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class PurchaseHistoryLine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lineId;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "purchaseHistoryId")
	@JsonBackReference//the other half gets the json info, I don't
	private PurchaseHistory history;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "paperId")
	private PaperOption option;
	
	private int amount;

	public PurchaseHistoryLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PurchaseHistoryLine(int lineId, PurchaseHistory history, PaperOption option, int amount) {
		super();
		this.lineId = lineId;
		this.history = history;
		this.option = option;
		this.amount = amount;
	}

	public int getLineId() {
		return lineId;
	}

	public void setLineId(int lineId) {
		this.lineId = lineId;
	}

	public PurchaseHistory getHistory() {
		return history;
	}

	public void setHistory(PurchaseHistory history) {
		this.history = history;
	}

	public PaperOption getOption() {
		return option;
	}

	public void setOption(PaperOption option) {
		this.option = option;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PurchaseHistoryLine [lineId=" + lineId + ", history=" + history + ", option=" + option + ", amount="
				+ amount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((history == null) ? 0 : history.hashCode());
		result = prime * result + lineId;
		result = prime * result + ((option == null) ? 0 : option.hashCode());
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
		PurchaseHistoryLine other = (PurchaseHistoryLine) obj;
		if (amount != other.amount)
			return false;
		if (history == null) {
			if (other.history != null)
				return false;
		} else if (!history.equals(other.history))
			return false;
		if (lineId != other.lineId)
			return false;
		if (option == null) {
			if (other.option != null)
				return false;
		} else if (!option.equals(other.option))
			return false;
		return true;
	}
	
	
	
	
}
