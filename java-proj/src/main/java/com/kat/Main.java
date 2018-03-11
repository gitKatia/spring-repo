package com.kat;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kat.model.Person;
import com.kat.services.interfaces.IPersonService;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		PersonUtil personUtil = (PersonUtil) context.getBean("personUtil");
		IPersonService personService = (IPersonService)context.getBean("personService");
		
		Comparator<Person> peopleByName = (p1,p2) -> p1.getFirstName().compareTo(p2.getFirstName());
		Comparator<Person> peopleByAge = (p1,p2) -> p1.getAge() - p2.getAge();
		Predicate<Person> findGeorge = p-> "George".equals(p.getFirstName());
		Predicate<Person> findDaniel = p-> "Daniel".equals(p.getFirstName());
		
		sortPeopleByName(personService, personUtil, peopleByName);
		sortPeopleByAge(personService, personUtil, peopleByAge);
		sortPeopleByAgeReversed(personService, personUtil, peopleByAge);
		System.out.println("\nFind George");
		findAny(personService, personUtil, findGeorge);
		System.out.println("\nFind Daniel");
		findAny(personService, personUtil, findDaniel);
		

	}
	
	public static void sortPeopleByName(IPersonService personService, PersonUtil personUtil, Comparator<Person> peopleByName) {
		List<Person> people = personUtil.getPeople();
		personService.sort(people, peopleByName);
		System.out.println("\nPeople sorted by name:\n");
		people.forEach(p -> System.out.println(p));
	}
	
	public static void sortPeopleByAge(IPersonService personService, PersonUtil personUtil, Comparator<Person> peopleByAge) {
		List<Person> people = personUtil.getPeople();
		personService.sort(people, peopleByAge);
		System.out.println("\nPeople sorted by age:\n");
		people.forEach(p -> System.out.println(p));
	}
	
	public static void sortPeopleByAgeReversed(IPersonService personService, PersonUtil personUtil, Comparator<Person> peopleByAge) {
		List<Person> people = personUtil.getPeople();
		personService.sort(people, peopleByAge.reversed());
		System.out.println("\nPeople sorted by age reversed:\n");
		people.forEach(p -> System.out.println(p));
	}
	
	public static Person findAny(IPersonService personService, PersonUtil personUtil, Predicate<Person> predicate){
		List<Person> people = personUtil.getPeople();
		Person person = personService.findAny(people, predicate);
		if(person != null){
			System.out.println("\nFound at least one element for the predicate!\n");
			System.out.println(person);
		} else {
			System.out.println("\nCould not found any match for the predicate.\n");
		}
		return person;
	}

}
