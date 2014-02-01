package com.varulager.business;

public class Tomatoes extends Food implements Fresh, Stock {
	
	//Constructor
	public Tomatoes(long bestBefore){
		super(bestBefore);
	}
	public Tomatoes(String Name, double price, int amount, long bestBefore, String stockLocation){
		super(Name, price, amount, bestBefore, stockLocation);
	}
}
