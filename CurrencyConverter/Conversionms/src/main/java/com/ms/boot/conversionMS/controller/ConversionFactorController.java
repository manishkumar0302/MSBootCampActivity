package com.ms.boot.conversionMS.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ms.boot.conversionMS.model.Factor;
import com.ms.boot.conversionMS.service.ConversionFactorService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping(path = "/conversion")
public class ConversionFactorController {

	@Autowired
	ConversionFactorService convService;

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public double getConversionFactorControl(@PathVariable String id) {

		double p = convService.getConversionFactor(id);
		if (p == 0.00) {
			return 0.00;
		} else {
			return p;

		}
	}
	
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public List<Factor> getAllConversionFactor() {
	
		return  convService.getAllConversionValue();
		
	}
	
	@PostMapping("/newconversion")
	public ResponseEntity<Object> addConversion(@RequestBody Factor factor) {
		
		Factor savedConversion = convService.saveNewConversion(factor);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedConversion.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/updateconversion/{id}")
	public ResponseEntity<Object> updateConversionFactor(@RequestBody Factor conversionfact, @PathVariable int id) {
		ResponseEntity<Object> result = convService.saveUpdateConversion(conversionfact,id);
	    return result;
	}

}
