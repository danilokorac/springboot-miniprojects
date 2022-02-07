package com.springboot.demo;

import com.springboot.demo.sub1.SpringComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootDemoApplication.class, args);
		SpringComponent component = applicationContext.getBean(SpringComponent.class);
		System.out.println(component.getMessage());
	}

}
