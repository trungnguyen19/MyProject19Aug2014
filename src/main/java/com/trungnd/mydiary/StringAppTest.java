package com.trungnd.mydiary;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trungnd.mydiary.dao.RecordDaoImpl;
import com.trungnd.mydiary.model.Record;

public class StringAppTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"com/trungnd/mydiary/applicationContext.xml");
		RecordDaoImpl dao = (RecordDaoImpl) context.getBean("recordDao");

		Record record1 = new Record(30, 0, new Date(), true, "lunch", "lunch");
		Record record2 = new Record(100, 0, new Date(), true, "lend",
				"who lend");

		dao.save(record1);
		dao.save(record2);

		List<Record> records = dao.getAll();
		for (Record record : records) {
			System.out.println(record);
		}
		context.close();
	}
}
