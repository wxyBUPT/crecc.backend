package com.crecc.sale;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class SoftWareSaleApplication {
	static Logger logger = Logger.getLogger(SoftWareSaleApplication.class.getName());

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SoftWareSaleApplication.class, args);
	}
}
