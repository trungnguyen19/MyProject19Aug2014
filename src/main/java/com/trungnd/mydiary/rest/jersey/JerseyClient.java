package com.trungnd.mydiary.rest.jersey;

import java.util.Date;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.trungnd.mydiary.model.RecordXml;

public class JerseyClient {
	public static void main(String[] args) {
		try {
			RecordXml rx = new RecordXml(15000, 0, new Date(), true, "salary",
					"=)))))");
			ClientConfig clientConfig = new DefaultClientConfig();
			clientConfig.getFeatures().put(
					JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			Client client = Client.create(clientConfig);
			WebResource webResource = client
					.resource("http://localhost:8080/trungndwebapp/rest/jersey/jerseyDiary/getJsonByTime/2014/8/12");
			ClientResponse response = webResource.accept("application/json")
					.type("application/json").post(ClientResponse.class, rx);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}
			String output = response.getEntity(String.class);
			System.out.println("Server response .... \n");
			System.out.println(output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
