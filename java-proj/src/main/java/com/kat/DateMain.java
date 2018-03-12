package com.kat;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kat.services.interfaces.IDateService;

public class DateMain {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		IDateService dateService = (IDateService)context.getBean("dateService");
		
		LocalDate localDateNow = LocalDate.now();
		
	    dateService.printLocalDate(localDateNow);
	    Instant t1 = Instant.now();
	    int day = 24*3600;
	    Instant t2 = t1.plusSeconds(day);
		
		dateService.printElapsedTime(t1, t2);
	}
	

}
