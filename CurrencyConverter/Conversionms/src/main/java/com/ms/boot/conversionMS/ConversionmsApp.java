package com.ms.boot.conversionMS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.ms.boot.conversionMS.model.Factor;
import com.ms.boot.conversionMS.repo.ConversionRepository;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrix
@EnableHystrixDashboard

public class ConversionmsApp {

	@Autowired
	private ConversionRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(ConversionmsApp.class, args);
	}

	@Bean
	CommandLineRunner inspect(ApplicationContext ctx) {
		return (r) -> {
			
			// List<Factor> factors = new ArrayList<Factor>();
			repo.save(new Factor(1, "Ind", 900.76));
			repo.save(new Factor(2, "UK", 90.76));
			repo.save(new Factor(3, "Canada", 9.76));
			repo.save(new Factor(4, "USA", 100.76));

			System.out.println("Saved ");

		};
	}

	/*
	 * public void generateData() { seedItUp(); }
	 * 
	 * @Transactional public void seedItUp() { Factor p = new
	 * Factor(1,"India",70.87); prepo.save(p); p = new Factor(2,"UK",7.87);
	 * 
	 * prepo.save(p); p = new Factor(3,"Canada",1.87);
	 * 
	 * prepo.save(p);
	 * 
	 * 
	 * ptrepo.save(new ProductTag(3, "plastic")); ptrepo.save(new ProductTag(3,
	 * "blocks")); ptrepo.save(new ProductTag(3, "shapes")); ptrepo.save(new
	 * ProductTag(2, "wool")); ptrepo.save(new ProductTag(2, "royal"));
	 * ptrepo.save(new ProductTag(2, "living")); ptrepo.save(new ProductTag(1,
	 * "kitchen")); ptrepo.save(new ProductTag(1, "fresh")); ptrepo.save(new
	 * ProductTag(1, "carbon"));
	 * 
	 * }
	 */

}
