package com.example.rest.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class RestServerApplication
{
  @Autowired
  private AutowireCapableBeanFactory beanFactory;
  
  public static void main( String[] args )
  {
    SpringApplication.run( RestServerApplication.class, args );
  }

}
