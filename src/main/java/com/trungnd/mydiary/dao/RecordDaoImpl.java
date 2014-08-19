package com.trungnd.mydiary.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.trungnd.mydiary.model.Record;

@Transactional
public class RecordDaoImpl {
	@PersistenceContext
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
