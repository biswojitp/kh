package com.kh.kitchenhome.controller;



import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class KHController {

	@RequestMapping("/hello")
	public String mehi() {
		return "hi";
	}
	@RequestMapping("/")
    public String home(Map<String, Object> model) {
        model.put("message", "HowToDoInJava Reader !!");
        return "index";
    }
	
		
	@RequestMapping("/testjsp")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", "testjsp");
		return "testjsp";
	}
}


