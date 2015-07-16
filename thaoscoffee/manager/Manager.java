package com.thaoscoffee.manager;

import com.thaoscoffee.item.Coffee;
import com.thaoscoffee.item.Item;
import com.thaoscoffee.store.Store;

public class Manager {
	public static void add(Item item) {
		if (item instanceof Coffee) {
			Store.getListcoffee().put(item.getId(), item);
		} else {
			Store.getListspices().put(item.getId(), item);
		}
	}
}
