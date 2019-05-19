package com.nowtoshare.helloworld.repository;

import com.nowtoshare.helloworld.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
     List<Person> findByFirstName(String firstName);
}
