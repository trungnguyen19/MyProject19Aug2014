package com.trungnd.mydiary.rest.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// config
// web.xml
// applicationContext.xml

// link
// http://localhost:8080/trungndwebapp/service/greeting/Trung

@RestController
@RequestMapping("/service/greeting")
public class DiaryController {
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String getGreeting(@PathVariable String name) {
		String result = "Hello " + name;
		return result;
	}
}
