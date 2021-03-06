package com.kat.services.interfaces;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import com.kat.model.Person;

public interface IPersonService {
	
	public void sort(List<Person> people, Comparator<Person> comparator);
	public List<Person> filter(List<Person> people,Predicate<Person> predicate);
	public Person findAny(List<Person> people,Predicate<Person> predicate);
	public Map<String,Long> groupByName(List<Person> people);
	public Map<String,Integer> totalAgeByName(List<Person> people);
	

}
