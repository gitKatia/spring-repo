package com.kat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kat.model.Person;

@Component
public class PersonUtil {
	
	public List<Person> getPeople() {
		
		List<Person> people = new ArrayList<Person>();
		people.add(new Person("Robert","White", 25));
		people.add(new Person("Mike","Jordan", 28));
		people.add(new Person("Claude","Monet", 21));
		people.add(new Person("Frank","Kinder", 28));
		people.add(new Person("Daniel","Johnson", 45));
		people.add(new Person("Laura","Sand", 35));
		people.add(new Person("Robert","Black", 24));
		people.add(new Person("Daniel","Connolly", 25));
		people.add(new Person("Daniel","Jordan", 23));
		people.add(new Person("Simon","Connolly", 45));
		people.add(new Person("Henry","Jordan", 41));
		return people;
	}

}
