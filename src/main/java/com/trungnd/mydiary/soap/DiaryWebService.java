package com.trungnd.mydiary.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
//import javax.jws.soap.SOAPBinding.Use;

// Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)
// @SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL) // optional
public interface DiaryWebService {
	@WebMethod
	String getAllRecord();
}
