package com.ron.handler;

import com.ron.handler.integration.Producer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(Producer.class)
public class SpringmeHandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmeHandlerApplication.class, args);
	}

}
