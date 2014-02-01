package com.varulager.business;

import org.joda.time.*;

import java.util.*;

public class Food extends Commodity {
	public static ArrayList<Food> FoodItems;
	protected final long bestBefore;
	
	//Constructor
	public Food(long bestBefore){
		this.bestBefore = bestBefore;
	}
	public Food(String name, double price, int amount, long bestBefore, String stockLocation){
		super(name, price, amount, stockLocation);
		this.bestBefore = bestBefore;
	}
	
	public boolean isFresh(long bestBefore, DateTime date){
		return true;
	}
	
	public long getBestBefore() {
		return bestBefore;
	}
}
