package com.kat;

import java.time.format.DateTimeFormatter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kat.services.interfaces.IDateService;

public class DateMain {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		IDateService dateService = (IDateService)context.getBean("dateService");
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		//ISO_LOCAL_DATE
		String date = "11/03/2018";
		printDate(dateService, date, dateTimeFormatter);
		
		//dateTimeFormatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
		//date = "16-Aug-2016";
		//printDate(dateService, date, dateTimeFormatter);
		
	}
	
	public static void printDate(IDateService dateService, String date, DateTimeFormatter dateTimeFormatter){
		
		dateService.printDate(date, dateTimeFormatter);
	}

}
