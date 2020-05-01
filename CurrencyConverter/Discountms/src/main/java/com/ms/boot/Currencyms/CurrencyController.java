package com.ms.boot.Currencyms;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ms.boot.Currencyms.service.CurrencyService;


@RestController
@RefreshScope
public class CurrencyController {

	private static Logger log = LoggerFactory.getLogger(CurrencyController.class);
    
	@Autowired
	CurrencyService currService;

	@PostConstruct
	public void initBean() {
		/*
		 * discountMap.put(ProductCategory.FURNISHING, 1.0);
		 * discountMap.put(ProductCategory.KITCHENELECTRONIC, 3.0);
		 * discountMap.put(ProductCategory.MEDICALEQUIPMENT, 7.0);
		 * discountMap.put(ProductCategory.MOBILEPHONE, 5.0);
		 * discountMap.put(ProductCategory.MUSICINSTRUMENT, 9.0);
		 * discountMap.put(ProductCategory.TOY, 2.0);
		 */
	}

	@RequestMapping(path = "/calcurrency", method = RequestMethod.GET)
	public double calculateCurrency(@RequestBody CurrencyRequest request) {
		log.info(request.toString());
		String countryCode= request.getCountryCode();
		double amount = request.getAmount();
		double convertedAmount = currService.convertCurrency(countryCode,amount);
		return convertedAmount;
	}
  
   
	@RequestMapping(path="/", method=RequestMethod.GET)
    public String returValueHello() {
    	return "Hello World";
    }
	


}
