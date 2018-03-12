package com.kat.model;

public class BasketItem extends Item{
	
	private int quantity;
	private double finalPrice;
	
	public BasketItem(Item item){
		this.id = item.getId();
		this.name = item.getName();
		this.price = item.getPrice();
		this.category = item.getCategory();
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getFinalPrice() {
		return finalPrice;
	}
	
	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}
	
	@Override
	public String toString() {
		return "BasketItem [quantity=" + quantity + ", finalPrice=" + finalPrice + "]";
	}
	
}
