package com.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.account.service.RibbonConfiguration;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(value={"com.account.controller","com.account.service"})
@EnableJpaRepositories("com.account.repository")
@EntityScan("com.account.model")
@RibbonClient(name = "card", configuration = RibbonConfiguration.class)
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

}
