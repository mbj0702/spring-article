package com.bmin.springarticle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringArticleApplication {

	public static void main(String[] args) {
		System.out.println("Spring has started?");
		SpringApplication.run(SpringArticleApplication.class, args);
		System.out.println("Spring has ended?");
	}

}
