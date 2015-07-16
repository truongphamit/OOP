package com.thaoscoffee.main;

import com.thaoscoffee.customer.Customer;
import com.thaoscoffee.item.Coffee;
import com.thaoscoffee.item.Item;
import com.thaoscoffee.item.Spices;
import com.thaoscoffee.manager.Manager;
import com.thaoscoffee.store.Store;

public class Main {
	public static void main(String[] args) {
		Manager.add(new Coffee("001", "Cappucino", 5));
		Manager.add(new Spices("001", "Sugar", 0));
		Manager.add(new Coffee("002", "BlackEye", 4));

		System.out.println("Menu: ");
		System.out.println("Coffee: ");

		for (Item coffee : Store.getListcoffee().values()) {
			System.out.println(coffee.getId() + " - " + coffee.getName() + " - " + coffee.getPrice() + "USD");
		}

		System.out.println("Spices: ");
		for (Item spices : Store.getListspices().values()) {
			System.out.println(spices.getId() + " - " + spices.getName() + " - " + spices.getPrice() + "USD");
		}
		
		Customer truong = new Customer("Truong", "1");
		truong.oder("003", "001");
		truong.printBill();
	}
}
