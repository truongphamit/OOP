package org.coffeeshop.store;

import java.util.Iterator;
import java.util.List;

import org.coffeeshop.entity.Coffee;
import org.coffeeshop.entity.Spices;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Store {
	private static Database database = new Database();

	public static List<Coffee> getListCoffee() {
		return database.<Coffee> getData("from Coffee");
	}

	public static List<Spices> getListSpices() {
		return database.<Spices> getData("from Spices");
	}

	public static void showMenu() {
		System.out.println();
		System.out.println("---------------------------");
		System.out.println("--------COFFEE SHOP--------");
		System.out.println("|*********Coffee***********");
		database.<Coffee> showData("from Coffee");
		System.out.println("|*********Spices***********");
		database.<Spices> showData("from Spices");
		System.out.println("---------------------------");
		System.out.println();
	}

	public static Coffee searchCoffee(String name) {
		Coffee coffee = null;
		List<Coffee> list = getListCoffee();
		for (Iterator<Coffee> iterator = list.iterator(); iterator.hasNext();) {
			Coffee c = iterator.next();
			if (c.getName().equals(name)) {
				coffee = c;
				break;
			}
		}
		return coffee;
	}

	public static Spices searchSpices(String name) {
		Spices spices = null;
		List<Spices> list = getListSpices();
		for (Iterator<Spices> iterator = list.iterator(); iterator.hasNext();) {
			Spices s = iterator.next();
			if (s.getName().equals(name)) {
				spices = s;
				break;
			}
		}

		return spices;
	}

	public static void addCoffee(String name, double price) {
		if (searchCoffee(name) == null) {
			database.<Coffee> add(new Coffee(name, price));
		} else {
			System.out.println("Coffee " + name + " da ton tai!");
		}
	}

	public static void addSpices(String name, double price) {
		if (searchSpices(name) == null) {
			database.<Spices> add(new Spices(name, price));
		} else {
			System.out.println("Spices " + name + " da ton tai!");
		}
	}

	public static void updateCoffee(String name, double price) {
		Coffee coffee = searchCoffee(name);
		if (coffee == null) {
			System.out.println("Coffee " + name + " khong ton tai!");
		} else {
			Session session = database.getFactory().openSession();
			Transaction tx = null;

			try {
				tx = session.beginTransaction();
				coffee.setPrice(price);
				session.update(coffee);
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
	}

	public static void updateSpices(String name, double price) {
		Spices spices = searchSpices(name);
		if (spices == null) {
			System.out.println("Spices " + name + " khong ton tai!");
		} else {
			Session session = database.getFactory().openSession();
			Transaction tx = null;

			try {
				tx = session.beginTransaction();
				spices.setPrice(price);
				session.update(spices);
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
	}

	public static void deleteCoffee(String name) {
		Coffee coffee = searchCoffee(name);
		if (coffee == null) {
			System.out.println("Coffee " + name + " khong ton tai!");
		} else {
			Session session = database.getFactory().openSession();
			Transaction tx = null;

			try {
				tx = session.beginTransaction();
				session.delete(coffee);
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
	}

	public static void deleteSpices(String name) {
		Spices spices = searchSpices(name);
		if (spices == null) {
			System.out.println("Coffee " + name + " khong ton tai!");
		} else {
			Session session = database.getFactory().openSession();
			Transaction tx = null;

			try {
				tx = session.beginTransaction();
				session.delete(spices);
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
	}
}
