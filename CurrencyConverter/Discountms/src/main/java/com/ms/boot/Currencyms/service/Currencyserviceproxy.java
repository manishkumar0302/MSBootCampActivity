package com.ms.boot.Currencyms.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "conversionms")
public interface Currencyserviceproxy {
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public double getConversionFactorControl(@PathVariable String id);
}
