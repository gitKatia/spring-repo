package com.kat.services;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kat.model.Person;
import com.kat.services.interfaces.IPersonService;

@Service
public class PersonService implements IPersonService {
	
	@Override
	public void sort(List<Person> people, Comparator<Person> comparator) {
		people.sort(comparator);
	}

	@Override
	public List<Person> filter(List<Person> people, Predicate<Person> predicate) {
		List<Person> peopleFilteredByPredicate = people.stream().filter(predicate).collect(Collectors.toList());
		return peopleFilteredByPredicate;
	}

	@Override
	public Person findAny(List<Person> people, Predicate<Person> predicate) {
		return people.stream().filter(predicate).findAny().orElse(null);
	}

	

}
