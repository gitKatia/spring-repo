package com.kat.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.kat.services.interfaces.IDateService;

@Service
public class DateService implements IDateService {

	@Override
	public void printDate(String date, DateTimeFormatter dateTimeFormatter) {

		LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
		System.out.println(dateTimeFormatter.format(localDate));
	}

}
