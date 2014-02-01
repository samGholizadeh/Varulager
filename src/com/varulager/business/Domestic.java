package com.varulager.business;

import java.util.*;

public class Domestic extends Commodity{
	public static ArrayList<Domestic> DomesticItems;
	//Constructor
	public Domestic(String Name, double price, int amount, String stockLocation){
		super(Name, price, amount, stockLocation);
	}
	
}
