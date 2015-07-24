package org.coffeeshop.custommer;

import java.util.ArrayList;
import java.util.List;

import org.coffeeshop.entity.Coffee;
import org.coffeeshop.entity.Spices;
import org.coffeeshop.store.Store;

public class Custommer {
	public static void main(String[] args) {
		Custommer truong = new Custommer("Truong", "t1");
		truong.seeMenu();
		truong.oderCoffee("Cappucino");
		truong.oderSpices("Milk");
		truong.oderSpices("Ice");
		truong.printBill();
	}
	
	private String name;
	private String table;
	Coffee coffeeOder;
	private List<Spices> listSpices;
	
	public Custommer(){}
	
	public Custommer(String name, String table) {
		this.name = name;	
		this.table = table;
		listSpices = new ArrayList<>();
	}
	
	public void seeMenu() {
		Store.showMenu();
	}
	
	public void oderCoffee(String name) {
		Coffee coffee = Store.searchCoffee(name);
		if (coffee == null) {
			System.out.println("Coffee " + name + " khong ton tai!");
		} else {
			coffeeOder = coffee;
		}
	}
	
	public void oderSpices(String name) {
		Spices spices = Store.searchSpices(name);
		if (spices == null) {
			System.out.println("Coffee " + name + " khong ton tai!");
		} else {
			listSpices.add(spices);
		}
	}
	
	public double bill() {
		double sum = 0;
		sum += coffeeOder.getPrice();
		for (Spices spices : listSpices) {
			sum += spices.getPrice();
		}
		return sum;
	}
	
	public void printBill() {
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println("***********bill*************" );
		System.out.println("Name: " + name);
		System.out.println("Table: " + table);
		System.out.println("Coffee: ");
		System.out.println(coffeeOder);
		System.out.println("Spices:");
		for (Spices spices : listSpices) {
			System.out.println(spices);
		}
		System.out.println("Total: " + bill());
		System.out.println();
	}
}
