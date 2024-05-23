package com.yuzee.app.quick.box;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.yuzee.local.config.MessageTranslator;

@SpringBootApplication
public class YuzeeAppQuickBoxApplication {

	public static void main(String[] args) {
		SpringApplication.run(YuzeeAppQuickBoxApplication.class, args);
	}
	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
    @Bean
    public MessageTranslator messageTranslator() {
        return new MessageTranslator();
    }

}
