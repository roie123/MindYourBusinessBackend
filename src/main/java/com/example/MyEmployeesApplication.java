package com.example;

import com.example.CONTROLLERS.RANDOMIZE.RandomPositions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Random;

@SpringBootApplication
public class MyEmployeesApplication {

	public static void main(String[] args) {
		ApplicationContext c = SpringApplication.run(MyEmployeesApplication.class, args);
	}

}
