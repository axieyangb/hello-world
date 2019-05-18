package com.nowtoshare.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
  @RequestMapping("hello")
  public String hello() {
    return "Hello World";
  }

  @RequestMapping("alive")
  public String alive() {
    return "OK";
  }
}
