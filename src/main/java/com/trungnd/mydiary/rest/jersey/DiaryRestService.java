package com.trungnd.mydiary.rest.jersey;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.trungnd.mydiary.dao.RecordDao;
import com.trungnd.mydiary.model.Record;
import com.trungnd.mydiary.model.RecordXml;

@Path("/jerseyDiary")
public class DiaryRestService {
	@Autowired
	private RecordDao recordDao;

	//http://www.codingpedia.org/ama/java-persistence-example-with-spring-jpa2-and-hibernate/
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	@Transactional
	public Response createRecord(Record record) {
		Long id = recordDao.createRecord(record);
		return Response
				.status(201)
				.entity("A new Record/Resource (id=" + id
						+ ") has been created").build();
	}

	@GET
	@Path("/getJsonByTime/{year}/{month}/{day}")
	@Produces(MediaType.APPLICATION_JSON)
	public Record getJsonByTime(@PathParam("year") int year,
			@PathParam("month") int month, @PathParam("day") int day) {
		return new Record();
	}

	@GET
	@Path("/getXmlByTime/{year}/{month}/{day}")
	@Produces(MediaType.APPLICATION_XML)
	public RecordXml getXmlByTime(@PathParam("year") int year,
			@PathParam("month") int month, @PathParam("day") int day) {
		return new RecordXml(15000, 0, new Date(), true, "salary", "=)))))");
	}

	@GET
	@Path("/getResponseByTime/{year}/{month}/{day}")
	public Response getResponseByTime(@PathParam("year") int year,
			@PathParam("month") int month, @PathParam("day") int day) {
		return Response
				.status(200)
				.entity("getResponseByTime is called, year/month/day : " + year
						+ "/" + month + "/" + day).build();
	}
}
