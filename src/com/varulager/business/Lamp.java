package com.varulager.business;

public class Lamp extends Domestic implements Stock {
	
	public Lamp(String Name, double price, int amount, String stockLocation){
		super(Name, price, amount, stockLocation);
	}
	
}
