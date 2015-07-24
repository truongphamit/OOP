package org.coffeeshop.manager;

import org.coffeeshop.entity.Coffee;
import org.coffeeshop.entity.Spices;
import org.coffeeshop.store.Store;

public class Manager {
	public static void main(String[] args) {
		Manager.showMenu();
	}
	
	public static void showMenu() {
		Store.showMenu();
	}
	
	public static void searchCoffee(String name) {
		Coffee coffee = Store.searchCoffee(name);
		if (coffee == null) {
			System.out.println("Coffee " + name + " khong ton tai!");
		}
	}
	
	public static void searchSpices(String name) {
		Spices spices = Store.searchSpices(name);
		if (spices == null) {
			System.out.println("Spices " + name + " khong ton tai!");
		}
	}
	
	public static void addCoffee(String name, double price) {
		Store.addCoffee(name, price);
	}
	
	public static void addSpices(String name, double price) {
		Store.addSpices(name, price);
	}

	public static void updateCoffee(String name, double price) {
		Store.updateCoffee(name, price);
	}
	
	public static void updateSpices(String name, double price) {
		Store.updateSpices(name, price);
	}
	
	public static void deleteCoffee(String name) {
		Store.deleteCoffee(name);
	}
	
	public static void deleteSpices(String name) {
		Store.deleteSpices(name);
	}
}
