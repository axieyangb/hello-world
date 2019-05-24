package com.nowtoshare.helloworld.controller;

import com.nowtoshare.helloworld.domain.Person;
import com.nowtoshare.helloworld.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

  private final PersonService personService;

  @Autowired
  public HomeController(PersonService personService) {
    this.personService = personService;
  }
  @RequestMapping("/hello")
  public String hello() {
    return "Hello World, PANDB 3.0";
  }

  @RequestMapping("/alive")
  public String alive() {
    return "OK";
  }


  @RequestMapping("/add")

  public Person add(@RequestParam("lastname") String lastname, @RequestParam("firstname") String firstname, @RequestParam("age") int age) {
    Person person = new Person(firstname, lastname, age);
    this.personService.savePerson(person);
    return person;
  }

  @RequestMapping("find")
  public List<Person> find(@RequestParam("firstname") String firtname) {
    return this.personService.findPersonByFirstName(firtname);
  }
}
