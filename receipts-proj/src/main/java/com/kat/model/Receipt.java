package com.kat.model;

public class Receipt {
	
	private Basket basket;
	private double salesTaxes;
	private double total;
	
	public Basket getBasket() {
		return basket;
	}
	
	public void setBasket(Basket basket) {
		this.basket = basket;
	}
	
	public double getSalesTaxes() {
		return salesTaxes;
	}
	
	public void setSalesTaxes(double salesTaxes) {
		this.salesTaxes = salesTaxes;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		for(BasketItem basketItem:basket.getBasketItems()){
			sb.append(basketItem.getQuantity()); 
			sb.append(" ");
			sb.append(basketItem.getName());
			sb.append(":");
			sb.append(String.format("%.2f", basketItem.getFinalPrice()));
			sb.append("\n");
		}
		sb.append("Sales Taxes:");
		sb.append(String.format("%.2f", this.getSalesTaxes()));
		sb.append("\nTotal:");
		sb.append(String.format("%.2f", this.getTotal()));
		sb.append("\n");
		return sb.toString();
	}
	
}
