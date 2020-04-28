package com.ms.boot.conversionMS.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "factor")
public class Factor {

	/*
	 * @Autowired
	 * 
	 * @Transient private ConversionRepository repo;
	 */

	@Id
   @GeneratedValue
	private Integer id;
	@Column(name = "CountryCode", table = "conversion")
	private String countryCode;
	@Column(name = "ConversionFactor", table = "conversion")
	private double convFactor;

	/*
	 * public void saveProduct() { repo.save(this); }
	 */
	public Factor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Factor(int id, String countryCode, double convFactor) {
		super();
		this.id = id;
		this.countryCode = countryCode;
		this.convFactor = convFactor;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setcountryCode(String code) {
		this.countryCode = code;
	}

	public double getconvFactor() {
		return convFactor;
	}

	public void setShortDescription(double factorValue) {
		this.convFactor = factorValue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
