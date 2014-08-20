package com.trungnd.mydiary.soap;

import javax.jws.WebService;

//Service Implementation
@WebService(endpointInterface = "com.trungnd.mydiary.soap.DiaryWebService")
public class DiaryWebServiceImpl implements DiaryWebService {
	public String getAllRecord() {
		return "Hello World JAX-WS ";
	}
}
