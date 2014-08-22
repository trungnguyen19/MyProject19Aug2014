package com.trungnd.mydiary.dao;

import java.util.List;

import com.trungnd.mydiary.model.Record;

public interface RecordDao {
	public Long save(Record record);

	public List<Record> getAll();

	public Long createRecord(Record record);

}
