package org.coffeeshop.store;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class Database {
	private SessionFactory factory;

	public Database() {
		try {
			Configuration configuration = new AnnotationConfiguration().configure();
			configuration.addAnnotatedClass(org.coffeeshop.entity.Coffee.class);
			configuration.addAnnotatedClass(org.coffeeshop.entity.Spices.class);
			factory = configuration.buildSessionFactory();
		} catch (Throwable e) {
			System.err.println("Failed to create sessionFactory object." + e);
			throw new ExceptionInInitializerError();
		}
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getData(String query) {
		Session session = factory.openSession();
		Transaction tx = null;
		List<T> list = null;

		try {
			tx = session.beginTransaction();
			list = session.createQuery(query).list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	public <T> void showData(String query) {
		List<T> list = getData(query);
		for (Iterator<T> iterator = list.iterator(); iterator.hasNext();) {
			T t = iterator.next();
			System.out.println("|" + t.toString());
		}
	}

	public <T> void add(T t) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.persist(t);
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
