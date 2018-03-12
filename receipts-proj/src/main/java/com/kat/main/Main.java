package com.kat.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kat.model.Receipt;
import com.kat.util.BasketUtil;

public class Main {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("spring-config.xml");
		BasketUtil util = 
				(BasketUtil) context.getBean("basketUtil");
		System.out.println("Output 1:");
		Receipt receipt1 = util.getReceipt(1);
		System.out.println(receipt1);
		System.out.println("Output 2:");
		Receipt receipt2 = util.getReceipt(2);
		System.out.println(receipt2);
		System.out.println("Output 3:");
		Receipt receipt3 = util.getReceipt(3);
		System.out.println(receipt3);
		
	}
	
}
