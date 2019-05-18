package com.nowtoshare.helloworld;

import ch.sbb.esta.openshift.gracefullshutdown.GracefulshutdownSpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldApplication {

  public static void main(String[] args) {
    GracefulshutdownSpringApplication.run(HelloWorldApplication.class, args);
  }
}
