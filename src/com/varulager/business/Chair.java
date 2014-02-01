package com.varulager.business;

public class Chair extends Domestic implements Stock {
	
	public Chair(String Name, double price, int amount, String stockLocation){
		super(Name, price, amount, stockLocation);
	}
	
}
