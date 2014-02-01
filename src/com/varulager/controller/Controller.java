
package com.varulager.controller;

import org.joda.time.*;
import com.varulager.business.*;

import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Koden är inte optimal vad gäller algorithm då jag ville experimentera med olika verktyg som finns inom Java/Programmering
 * T.ex. så har jag skapat en metod på 152 när det egentligen inte behövs någon. Jag har även använt mig av ett
 * populärt bibliotek för datum hantering som heter Joda Time som tydligen ska vara jätte bra.
 * */

public class Controller {
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		Food.FoodItems = new ArrayList<Food>();
		Domestic.DomesticItems = new ArrayList<Domestic>();
		int choice = 0;
		int amount = 0;
		double price = 0;
		long expireDateMilli = 0;
		String brandName;
		DateTime time = new DateTime(2013, 10, 26, 12, 0, 0, 0);
		
		for(int i = 0; i < 9; i++){
			if(i % 2 == 0){
				Milk milk = new Milk("Arla", 7.90, 50, time.getMillis(), "E" + i);
				Food.FoodItems.add(milk);
			} else {
				Tomatoes tomatoe = new Tomatoes("someBrand", 2,25, time.getMillis(), "E" + i);
				Food.FoodItems.add(tomatoe);
			}
		}
		
		for(int i = 0; i < 9; i++){
			if(i % 2 == 0){
				Lamp lamp = new Lamp("IKEA Generic Lamp", 49.90, 200, "D" + i);
				Domestic.DomesticItems.add(lamp);
			} else {
				Chair chair = new Chair("IKEA Generic chair", 99.99, 25, "D" + i);
				Domestic.DomesticItems.add(chair);
			}
		}
		
		System.out.println("Hej och välkommen till " +
				"mitt varulager program. Det finns " +
				"redan lite varor i lagret men du " +
				"kommer att ha möjligheten att lägga " +
				"till varor. \n\n");
		System.out.println("Ditt lager är instantierad. Välj ett av alternativen");
		
		while(true){
			System.out.println("1 = Visa lista med färskvaror");
			System.out.println("2 = Visa lista med lagervaror");
			System.out.println("3 = Lägg till en vara");
			System.out.println("4 = Ta bort en vara");
			System.out.println("5 = Avsluta programmet");
			
			choice = input.nextInt();
			if(choice == 1){
				try{
					for(int i = 0; i < Food.FoodItems.size(); i++){
						System.out.println("Name: " + Food.FoodItems.get(i).getName());
						System.out.println("Price: " + Food.FoodItems.get(i).getPrice());
						System.out.println("Amount: " + Food.FoodItems.get(i).getAmount());
						System.out.println("Location: " + Food.FoodItems.get(i).getStockLocation());
						long bestBefore = Food.FoodItems.get(i).getBestBefore();
						System.out.println("Best before: " + new Date(bestBefore) + "\n");
					}
					System.out.println("Number of items in stock: " + Food.FoodItems.size());
					System.out.println();
				} catch(IndexOutOfBoundsException e){
					System.out.println("There are no products in this category.");
					continue;
				}
			}
			else if(choice == 2)
			{
				try{
					for(int i = 0; i < Domestic.DomesticItems.size(); i++){
						System.out.println("Name: " + Domestic.DomesticItems.get(i).getName());
						System.out.println("Price: " + Domestic.DomesticItems.get(i).getPrice());
						System.out.println("Amount: " + Domestic.DomesticItems.get(i).getAmount());
						System.out.println("Location: " + Domestic.DomesticItems.get(i).getStockLocation() + "\n");
					}
				} catch(IndexOutOfBoundsException e){
					System.out.println("There are no products in this category.");
					continue;
				}
			}
			else if(choice == 3)
			{
				System.out.println("What kind of item do you want to add: 1 = Milk, 2 = Tomatoe, 3 = Lamp, 4 = Chair");
				System.out.println("0 = Main menu");
				choice = input.nextInt();
				switch(choice){
					case 1:
						System.out.print("Input brand name: "); brandName = input.next();
						brandName += input.nextLine();
						System.out.print("\n Input price: "); price = input.nextDouble();
						System.out.print("\n Input amount: "); amount = input.nextInt();
						expireDateMilli = time.getMillis();
						Milk milk = new Milk(brandName, price, amount, expireDateMilli, "E" + (Food.FoodItems.size()));
						Food.FoodItems.add(milk);
						break;
					case 2:
						System.out.print("Input brand name: "); brandName = input.next();
						brandName += input.nextLine();
						System.out.print("\n Input price: "); price = input.nextDouble();
						System.out.print("\n Input amount: "); amount = input.nextInt();
						expireDateMilli = time.getMillis();
						Tomatoes t = new Tomatoes(brandName, price, amount, expireDateMilli, "E" + (Food.FoodItems.size()));
						Food.FoodItems.add(t);
						break;
					case 3:
						System.out.print("Input brand name: "); brandName = input.next();
						brandName += input.nextLine();
						System.out.print("\n Input price: "); price = input.nextDouble();
						System.out.print("\n Input amount: "); amount = input.nextInt();
						Lamp lamp = new Lamp(brandName, price, amount, "D" + (Domestic.DomesticItems.size()));
						Domestic.DomesticItems.add(lamp);
						break;
					case 4:
						System.out.print("Input brand name: "); brandName = input.next();
						brandName += input.nextLine();
						System.out.print("\n Input price: "); price = input.nextDouble();
						System.out.print("\n Input amount: "); amount = input.nextInt();
						Chair chair = new Chair(brandName, price, amount, "D" + (Domestic.DomesticItems.size()));
						Domestic.DomesticItems.add(chair);
						break;
					default:
						continue;
				}
				System.out.println("Your item has been added to the inventory list");
			}
			else if(choice == 4)
			{
				System.out.println("Från vilken kategori vill du ta bort en vara? 1 = Food, 2 = Domestic, 0 = Main menu");
				choice = input.nextInt();
				if(removeItem(choice, input)){
					continue;
				}
			}
			continue;
		}
	}
	
	static boolean removeItem(int choice, Scanner input){
		if(choice == 1){
			try{
				for(int i = 0; i < Food.FoodItems.size(); i++){
					System.out.println((i + 1) + ". " + Food.FoodItems.get(i).getName());
				}
				System.out.println("Pick one of the items you would like to delete by input the number next to it.\n");
				choice = input.nextInt();
				Food.FoodItems.remove(choice - 1);
			} catch (IndexOutOfBoundsException e){
				System.out.println("There is nothing in this list to remove.");
			}
		} else if(choice == 2){
			try{
				for(int i = 0; i < Domestic.DomesticItems.size(); i ++){
					System.out.println((i + 1) + ". " + Domestic.DomesticItems.get(i).getName());
				}
				System.out.println("There is either no items to remove or the number you've entered does not exist in the list.\n");
				choice = input.nextInt();
				Domestic.DomesticItems.remove(choice - 1);
			} catch (IndexOutOfBoundsException e){
				System.out.println("There is either no items to remove or the number you've entered does not exist in the list.\n");
			}
		} else if(choice == 0){
			return true;
		}
		System.out.println("The item has been deleted from the stock.");
		return false;
	}
}