package com.ms.boot.Currencyms.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name="conversionms" , url="http://192.168.56.104:8081/conversion/")
public interface Currencyserviceproxy {
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public double getConversionFactorControl(@PathVariable String id);
}
