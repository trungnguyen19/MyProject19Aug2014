package com.trungnd.mydiary.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.trungnd.mydiary.model.Record;

@Transactional
public class RecordDaoImpl implements RecordDao {
	@PersistenceContext
	private EntityManager entityManager;

	public Long save(Record record) {
		entityManager.persist(record);
		return record.getId();
	}

	public List<Record> getAll() {
		return entityManager
				.createQuery("SELECT r FROM Record r", Record.class)
				.getResultList();
	}

	public Long createRecord(Record record) {
		entityManager.persist(record);
		entityManager.flush(); // force insert to receive the id of the record
		return record.getId();
	}
}
