package com.trungnd.mydiary.onlyhibernate;

import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.trungnd.mydiary.model.Record;

public class HibernateSessionFactory {
	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;

	public static void main(String[] args) {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("META-INF/hibernate.cfg.xml")
					.setProperty("hibernate.show_sql", "false");
			serviceRegistry = new ServiceRegistryBuilder().applySettings(
					configuration.getProperties()).buildServiceRegistry();
			factory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		System.out.println("**Example : Hibernate 4 SessionFactory**");
		System.out.println("----------------------------------------");
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List records = session.createQuery("FROM Record").list();
			System.out.println("size: "+records.size());
			for (Iterator iterator = records.iterator(); iterator.hasNext();) {
				Record record = (Record) iterator.next();
				System.out.println("Id: " + record.getId());
				System.out.println("CashIn: " + record.getCashIn());
				System.out.println("CashOut: " + record.getCashOut());
				System.out.println("Label: " + record.getLabel());
				System.out.println("Note: " + record.getNote());
				System.out.println("Day: " + record.getDay());
				System.out.println("IsTransaction: "
						+ record.getIsTransaction());
				System.out.println("----------------------------------------");
			}
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
