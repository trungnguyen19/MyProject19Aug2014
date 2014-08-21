package com.trungnd.mydiary.rest.jersey;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.trungnd.mydiary.model.Record;
import com.trungnd.mydiary.model.RecordXml;

@Path("/jerseyDiary")
public class DiaryRestService {
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
		return new RecordXml(15000, 0, new Date(), true,
				"salary", "=)))))");
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
