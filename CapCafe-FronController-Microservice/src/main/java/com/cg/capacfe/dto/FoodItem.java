package com.cg.capacfe.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity class for storing food item details.
 * @author akasverm
 *
 */

public class FoodItem {
	
	private int itemId;
	
	private ItemType itemType;
	
	private String name;
	
	private double price;
	
	private Set<Order> orders = new HashSet<Order>();
	
	private Set<Cafe> cafe;
	
	public FoodItem(int itemId, ItemType itemType, String name, double price, Set<Order> orders, Set<Cafe> cafe) {
		super();
		this.itemId = itemId;
		this.itemType = itemType;
		this.name = name;
		this.price = price;
		this.orders = orders;
		this.cafe = cafe;
	}

	public FoodItem() {}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Set<Cafe> getCafe() {
		return cafe;
	}

	public void setCafe(Set<Cafe> cafe) {
		this.cafe = cafe;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cafe == null) ? 0 : cafe.hashCode());
		result = prime * result + itemId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		FoodItem other = (FoodItem) obj;
		if (cafe == null) {
			if (other.cafe != null)
				return false;
		} else if (!cafe.equals(other.cafe))
			return false;
		if (itemId != other.itemId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FoodItem [itemId=" + itemId + ", itemType=" + itemType + ", name=" + name + ", price=" + price
				+ ", orders=" + orders + ", cafe=" + cafe + "]";
	}
	
	
}
