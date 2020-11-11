package com.hungerbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.hungerbox.config.RibbonConfiguration;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@RibbonClient(value = "mybank-service", configuration = RibbonConfiguration.class)
public class HungerBoxAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HungerBoxAppApplication.class, args);
	}

}
