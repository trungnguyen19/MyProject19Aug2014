package com.trungnd.mydiary.soap;

import javax.xml.ws.Endpoint;

public class DiaryWebServicePublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/ws/hello",
				new DiaryWebServiceImpl());
	}
}
