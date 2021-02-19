package dev.qwett.services;

import dev.qwett.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonService {

    private List<Person> personList;

    public List<Person> findAll() {
        personList = new ArrayList<Person>() {{
            add(new Person("Ivan", "Ivanov"));
            add(new Person("Petya", "Ivanov"));
            add(new Person("Ivan", "Petrov"));
            add(new Person("Petya", "Petrov"));
        }};
        return personList;
    }

    public void add(Person person) {
        personList.add(person);
    }


}
