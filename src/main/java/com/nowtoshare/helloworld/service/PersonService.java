package com.nowtoshare.helloworld.service;

import com.nowtoshare.helloworld.domain.Person;
import com.nowtoshare.helloworld.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public void savePerson(Person person) {
        this.personRepository.save(person);
    }

    public List<Person> findPersonByFirstName(String firstName) {
        return this.personRepository.findByFirstName(firstName);
    }
}
