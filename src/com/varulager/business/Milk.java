package com.varulager.business;

public class Milk extends Food implements Fresh, Stock {
	
	//Constructors
	public Milk(long bestBefore){
		super(bestBefore);
	}
	public Milk(String name, double price, int amount, long bestBefore, String stockLocation){
		super(name, price, amount, bestBefore, stockLocation);
	}
}
