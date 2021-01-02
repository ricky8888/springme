package com.ron.producer;

import com.ron.producer.integration.Analyzer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableBinding(Analyzer.class)
public class ProducerApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

}
