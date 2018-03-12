package com.kat.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kat.model.Basket;
import com.kat.model.BasketItem;
import com.kat.model.Item;
import com.kat.model.QuantityValue;
import com.kat.model.Receipt;
import com.kat.service.ItemService;

@Component
public class BasketUtil {
	
	@Autowired
	private ItemService itemService;
	
	private Basket buildBasket(int basketNumber){
		
		List<QuantityValue> quantityValues = new ArrayList<QuantityValue>();
		
		switch(basketNumber){
		
			case 1:
				quantityValues.add(new QuantityValue(1,1));
				quantityValues.add(new QuantityValue(2,1));
				quantityValues.add(new QuantityValue(3,1));
				return populateBasket(quantityValues);
			case 2:
				quantityValues.add(new QuantityValue(4,1));
				quantityValues.add(new QuantityValue(5,1));
				return populateBasket(quantityValues);
			case 3:
				quantityValues.add(new QuantityValue(6,1));
				quantityValues.add(new QuantityValue(7,1));
				quantityValues.add(new QuantityValue(8,1));
				quantityValues.add(new QuantityValue(9,1));
				return populateBasket(quantityValues);
			default:
				return null;
		}
	};
	
	public Receipt getReceipt(int basketNumber){
		
		Basket basket = buildBasket(basketNumber);
		Receipt receipt = new Receipt();
		receipt.setBasket(basket);
		double salesTaxes = 0.00;
		double total = 0.0;
		for(BasketItem basketItem:basket.getBasketItems()){
			boolean imported = basketItem.getName().contains("imported");
			boolean exempt = basketItem.getCategory().equals("FOOD")
					|| basketItem.getCategory().equals("BOOK")
					|| basketItem.getCategory().equals("MEDICAL PRODUCT");
			
			double delta = 0.00;
			if(imported){
				delta += basketItem.getPrice()*0.05;
				delta = Math.ceil(delta*20.0)/20.0;
			}
			if(!exempt){
				delta += basketItem.getPrice()*0.1;
				delta = Math.ceil(delta*20.0)/20.0;
			}
			
			double finalPrice = basketItem.getQuantity() *(basketItem.getPrice() 
					+ delta);
			basketItem.setFinalPrice(finalPrice);
			
			salesTaxes += delta;
			total += finalPrice;
		}
		
		BigDecimal salesTaxesB = new BigDecimal(Double.toString(salesTaxes));
		salesTaxesB = salesTaxesB.setScale(2, RoundingMode.HALF_UP);
		receipt.setSalesTaxes(salesTaxesB.doubleValue());
		BigDecimal totalB = new BigDecimal(Double.toString(total));
		totalB = totalB.setScale(2, RoundingMode.HALF_UP);
		receipt.setTotal(totalB.doubleValue());
		return receipt;
	}

	private Basket populateBasket(List<QuantityValue> quantityValues){
		
		Basket basket = new Basket();
		List<BasketItem> basketItems = new ArrayList<BasketItem>();
		
		for(QuantityValue qv:quantityValues){
			Item item = itemService.getItemByID(qv.getId());
			BasketItem basketItem = new BasketItem(item);
			basketItem.setQuantity(qv.getQuantity());
			basketItems.add(basketItem);
		}
		
		basket.setBasketItems(basketItems);
		
		return basket;
	}
}
