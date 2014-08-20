package com.trungnd.mydiary.export.soap;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class SOAPClient {

	public static void main(String[] args) throws Exception {

		URL url = new URL("http://localhost:9999/ws/hello?wsdl");

		// 1st argument service URI, refer to wsdl document above
		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://soap.export.mydiary.trungnd.com/",
				"DiaryWebServiceImplService");

		Service service = Service.create(url, qname);

		DiaryWebService hello = service.getPort(DiaryWebService.class);

		System.out.println(hello.getAllRecord());

	}

}
