package com.trungnd.mydiary;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.trungnd.mydiary.model.Record;

public class AppTest {
	private static final String PERSISTENCE_UNIT_NAME = "psunit1";
	private static EntityManagerFactory factory;

	public static void main(String[] args) {
		// fix location: META-INF/persistence.xml
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		Record record = new Record();
		record.setCashIn(30);
		record.setCashOut(0);
		record.setDay(new Date());
		record.setIsTransaction(true);
		record.setLabel("lunch");
		record.setNote("lunch");

		em.persist(record);
		em.getTransaction().commit();
		em.close();
	}
}
