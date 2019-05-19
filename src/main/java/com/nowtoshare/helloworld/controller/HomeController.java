package com.nowtoshare.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
  @RequestMapping("/hello")
  public String hello() {
    return "Hello World, yangyang xie & luye";
  }

  @RequestMapping("/alive")
  public String alive() {
    return "OK";
  }
}