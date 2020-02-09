package com.cg.capacfe.dto;

import java.util.Set;

/**
 * Entity class for storing cafe details.
 * @author Akash Verma
 *
 */
public class Cafe {

	private int cafeId;
	
	private String name;
	
	private String location;
	
	private String owner;
	
	private double account;
	
	private double avgRating;
	
	private int avgPrice;
	
	
	private Set<Review> reviews;
	
	
	private Set<FoodItem> menu;

	
	public Cafe() {}
	
	public Cafe(int cafeId, String name, String location, String owner, double account,
			double avgRating, int avgPrice, Set<Review> reviews, Set<FoodItem> menu) {
		super();
		this.cafeId = cafeId;
		this.name = name;
		this.location = location;
		this.owner = owner;
		this.account = account;
		this.avgRating = avgRating;
		this.avgPrice = avgPrice;
		this.reviews = reviews;
		this.menu = menu;
	}

	public int getCafeId() {
		return cafeId;
	}

	public void setCafeId(int cafeId) {
		this.cafeId = cafeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public double getAccount() {
		return account;
	}

	public void setAccount(double account) {
		this.account = account;
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

	public int getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(int avgPrice) {
		this.avgPrice = avgPrice;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	public Set<FoodItem> getMenu() {
		return menu;
	}

	public void setMenu(Set<FoodItem> menu) {
		this.menu = menu;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cafeId;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
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
		Cafe other = (Cafe) obj;
		if (cafeId != other.cafeId)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cafe [cafeId=" + cafeId + ", name=" + name + ", location=" + location + ", owner=" + owner
				+ ", account=" + account + ", avgRating=" + avgRating + ", avgPrice="
				+ avgPrice + ", reviews=" + reviews + ", menu=" + menu + "]";
	}
	
	
	
	
}
