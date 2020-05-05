package com.ms.boot.conversionMS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ms.boot.conversionMS.model.Factor;
import com.ms.boot.conversionMS.repo.ConversionRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
@Component
@RibbonClient(name = "currencyms")
public class ConversionFactorService {
	@Autowired
	private ConversionRepository prepo;

	@Autowired
	LoadBalancerClient lbClient;

	
	@LoadBalanced
	RestTemplate createRestTemplate() {
		RestTemplateBuilder b = new RestTemplateBuilder();
		return b.build();
	}

	@Autowired
	@Lazy
	RestTemplate lbrestTemplate;
	/*
	 * @Autowired private EurekaClient discoveryClient;
	 */


	 
	public double getConversionFactorFallback(String id) {
		
		return 1.00;
    
	}
	
	@HystrixCommand(fallbackMethod = "getConversionFactorFallback")
	public double getConversionFactor(String id) {
		Optional<Factor> oFactor = prepo.findByCountryCode(id);
		if (oFactor.isPresent())
			return oFactor.get().getconvFactor();
		else
			return 0.00;
    }
	
	

	
	public Factor saveNewConversion(Factor factor) {
		
		Factor saveConversion = prepo.save(factor);
		return saveConversion;

    }
	
	public  ResponseEntity<Object> saveUpdateConversion(Factor conversionfact,int id){
		
		Optional<Factor> convFactorOptional = prepo.findById(id);

		if (!convFactorOptional.isPresent())
			return ResponseEntity.notFound().build();

		conversionfact.setId(id);
		prepo.save(conversionfact);
		return ResponseEntity.noContent().build();
	}
	
	
	public List<Factor> getAllConversionValue() {
		
		return  prepo.findAll();
		
	}
	
}
