package com.kat.services.interfaces;

import java.time.Instant;
import java.time.LocalDate;

public interface IDateService {
	
	public void printElapsedTime(Instant t1, Instant t2);
	public void printLocalDate(LocalDate localDate);
	
	

}
