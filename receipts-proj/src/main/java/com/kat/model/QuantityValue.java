package com.kat.model;

public class QuantityValue {
	
	private int id;
	private int quantity;
	
	public QuantityValue() {}
	
	public QuantityValue(int id, int quantity) {
		this.id = id;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "QuantityValue [id=" + id + ", quantity=" + quantity + "]";
	}
	
}
