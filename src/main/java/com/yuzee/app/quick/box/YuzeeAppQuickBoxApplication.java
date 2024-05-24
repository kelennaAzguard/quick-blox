package com.yuzee.app.quick.box;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.yuzee")
@SpringBootApplication
@org.springframework.cloud.netflix.eureka.EnableEurekaClient
public class YuzeeAppQuickBoxApplication {

	public static void main(String[] args) {
		SpringApplication.run(YuzeeAppQuickBoxApplication.class, args);
	}


}
