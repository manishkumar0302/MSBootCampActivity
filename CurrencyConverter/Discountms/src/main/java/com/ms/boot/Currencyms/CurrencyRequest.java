package com.ms.boot.Currencyms;

public class CurrencyRequest {
	private String countrycode;
	private double amount;
//	private double factor;
	
	
	
	public CurrencyRequest(String countrycode,double amount,double factor) {
		super();
		this.countrycode = countrycode;
		this.amount = amount;
		//this.factor = factor;
	}
	public CurrencyRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CurrencyRequest [countrycode=" + countrycode + ", amount=" + amount +  "]";
	}
	public String getCountryCode() {
		return countrycode;
	}
	public void getCountryCode(String countrycode) {
		this.countrycode = countrycode;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/*
	 * public double getFactor() { return factor; } public void setFactor(double
	 * factor) { this.factor = factor; }
	 */
}
