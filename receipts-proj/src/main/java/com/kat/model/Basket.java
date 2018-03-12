package com.kat.model;

import java.util.List;

public class Basket {
	
	private List<BasketItem> basketItems;

	public List<BasketItem> getBasketItems() {
		return basketItems;
	}

	public void setBasketItems(List<BasketItem> basketItems) {
		this.basketItems = basketItems;
	}

	@Override
	public String toString() {
		return "Basket [basketItems=" + basketItems + "]";
	}
	
}
