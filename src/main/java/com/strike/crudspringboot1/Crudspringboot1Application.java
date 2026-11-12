package com.strike.crudspringboot1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication
public class Crudspringboot1Application {

	public static void main(String[] args) {

		SpringApplication.run(Crudspringboot1Application.class, args);
		System.out.println("hello sairam!!!!");
	}

}
