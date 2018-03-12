package com.kat.services;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.springframework.stereotype.Service;

import com.kat.services.interfaces.IDateService;

@Service
public class DateService implements IDateService {

	@Override
	public void printElapsedTime(Instant t1, Instant t2) {
		
		Duration duration = Duration.between(t1, t2);
		System.out.println("\nPrinting Duration\n");
		System.out.print("DEFAULT(ISO):");
		System.out.println(duration);
		System.out.print("IN MILLIS:");
		System.out.println(duration.toMillis());
		System.out.print("IN MINUTES:");
		System.out.println(duration.toMinutes());
		System.out.print("IN DAYS:");
		System.out.println(duration.toDays());
		System.out.print("IN HOURS:");
		System.out.println(duration.toHours());
		System.out.print("IN NANOS:");
		System.out.println(duration.toNanos());
		System.out.print("STRING REPRESENTATION:");
		System.out.println(duration.toString());
		
		System.out.print("IS NEGATIVE:");
		System.out.println(duration.isNegative());
		
	}

	@Override
	public void printLocalDate(LocalDate localDate) {
		
		System.out.println("\nPrinting LocalDate\n");
		DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
		System.out.print("DEFAULT:");
		System.out.println(localDate);
		System.out.print("ISO DATE:");
		System.out.println(dtf.format(localDate));
		dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		System.out.print("LONG:");
		System.out.println(dtf.format(localDate));
		dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		System.out.print("FULL:");
		System.out.println(dtf.format(localDate));
		dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		System.out.print("MEDIUM:");
		System.out.println(dtf.format(localDate));
		dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.print("SHORT:");
		System.out.println(dtf.format(localDate));
		
	}
	

}
