package com.trungnd.mydiary.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.trungnd.mydiary.model.Record;

public class RecordDaoImpl {
	private EntityManager em;

	public Long save(Record record) {
		em.persist(record);
		return record.getId();
	}

	public List<Record> getAll() {
		return em.createQuery("SELECT r FROM Record r", Record.class)
				.getResultList();
	}
}
