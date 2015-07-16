package com.thaoscoffee.store;

import java.util.HashMap;

import com.thaoscoffee.item.Item;

public class Store {
	private static final HashMap<String, Item> listCoffee = new HashMap<>();
	private static final HashMap<String, Item> listSpices = new HashMap<>();
	
	public static HashMap<String, Item> getListcoffee() {
		return listCoffee;
	}

	public static HashMap<String, Item> getListspices() {
		return listSpices;
	}
	
	
}
