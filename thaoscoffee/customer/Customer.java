package com.thaoscoffee.customer;

import java.util.ArrayList;

import com.thaoscoffee.item.Item;
import com.thaoscoffee.store.Store;

public class Customer {
	private String name;
	private String idTable;
	private ArrayList<Item> listOder = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdTable() {
		return idTable;
	}

	public void setIdTable(String idTable) {
		this.idTable = idTable;
	}

	public Customer(String name, String idTable) {
		this.name = name;
		this.idTable = idTable;
	}

	public ArrayList<Item> getListOder() {
		return listOder;
	}

	public void setListOder(ArrayList<Item> listOder) {
		this.listOder = listOder;
	}

	public void oder(String idCoffee) {
		listOder.add(Store.getListcoffee().get(idCoffee));
	}

	public void oder(String idCoffee, String idSpices) {
		listOder.add(Store.getListcoffee().get(idCoffee));
		listOder.add(Store.getListspices().get(idSpices));
	}

	public void printBill() {
		double sum = 0;
		System.out.println(name + " ----  " + idTable);
		for (Item item : listOder) {
			System.out.println(item.getId() + " - " + item.getName() + " - " + item.getPrice() + "USD");
			sum += item.getPrice();
		}
		System.out.println("Total: " + sum + " USD");
	}
}
