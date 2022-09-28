package com.rjaguirrem.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {
	public static void main(final String[] args) {
		new SpringbootApplication().run(args);
	}

	private void run(final String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}