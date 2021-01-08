package com.revature.models;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.proxy.HibernateProxy;



@Entity
@Table(name = "bear_table")
public class Bear {
	
	@Id
	@Column(name = "bear_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bearId;
	
	private String name;
	
	private String species;
	
	private String colour;
	
	private BigDecimal weight;
	
	@Column(name = "number_of_legs")
	private int numberOfLegs;
	
	@Column(name = "favorite_food")
	private String favoriteFood;

	
	//name refers to the name of the column on our table
	//referenced column name refers to the name of the column on their table
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(referencedColumnName = "den_id")
	private Den home;
	
	
	
	public Bear() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Bear(int bearId, String name, String species, String colour, BigDecimal weight, int numberOfLegs,
			String favoriteFood, Den home) {
		super();
		this.bearId = bearId;
		this.name = name;
		this.species = species;
		this.colour = colour;
		this.weight = weight;
		this.numberOfLegs = numberOfLegs;
		this.favoriteFood = favoriteFood;
		this.home = home;
	}



	public int getBearId() {
		return bearId;
	}



	public void setBearId(int bearId) {
		this.bearId = bearId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSpecies() {
		return species;
	}



	public void setSpecies(String species) {
		this.species = species;
	}



	public String getColour() {
		return colour;
	}



	public void setColour(String colour) {
		this.colour = colour;
	}



	public BigDecimal getWeight() {
		return weight;
	}



	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}



	public int getNumberOfLegs() {
		return numberOfLegs;
	}



	public void setNumberOfLegs(int numberOfLegs) {
		this.numberOfLegs = numberOfLegs;
	}



	public String getFavoriteFood() {
		return favoriteFood;
	}



	public void setFavoriteFood(String favoriteFood) {
		this.favoriteFood = favoriteFood;
	}



	public Den getHome() {
		return home;
	}



	public void setHome(Den home) {
		this.home = home;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bearId;
		result = prime * result + ((colour == null) ? 0 : colour.hashCode());
		result = prime * result + ((favoriteFood == null) ? 0 : favoriteFood.hashCode());
		result = prime * result + ((home == null) ? 0 : home.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numberOfLegs;
		result = prime * result + ((species == null) ? 0 : species.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		Bear other = (Bear) obj;
		if (bearId != other.bearId)
			return false;
		if (colour == null) {
			if (other.colour != null)
				return false;
		} else if (!colour.equals(other.colour))
			return false;
		if (favoriteFood == null) {
			if (other.favoriteFood != null)
				return false;
		} else if (!favoriteFood.equals(other.favoriteFood))
			return false;
		if (home == null) {
			if (other.home != null)
				return false;
		} else if (!home.equals(other.home))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numberOfLegs != other.numberOfLegs)
			return false;
		if (species == null) {
			if (other.species != null)
				return false;
		} else if (!species.equals(other.species))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}



	@Override
	public String toString() {
		String home = "";
		if(this.home instanceof HibernateProxy) {
			home = "{}";
		}else if(this.home == null){
			home = null;
		}else {
			
			home = this.home.toString();
		}
		return "Bear [bearId=" + bearId + ", name=" + name + ", species=" + species + ", colour=" + colour + ", weight="
				+ weight + ", numberOfLegs=" + numberOfLegs + ", favoriteFood=" + favoriteFood + ", home=" + home + "]";
	}
	
}
