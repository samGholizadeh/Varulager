package com.varulager.business;

public class Commodity {
	
	private String name;
	private double price;
	private int amount;
	protected String stockLocation;
	
	//Default Constructor
	public Commodity(){}
	
	//Overloaded Constructor
	public Commodity(String name, double price, int amount, String stockLocation){
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.stockLocation = stockLocation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getStockLocation() {
		return stockLocation;
	}

	public void setStockLocation(String stockLocation) {
		this.stockLocation = stockLocation;
	}
}
