package com.kh.kitchenhome.controller;



import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.kitchenhome.model.Kitchen;
import com.kh.kitchenhome.repository.KitchenRepository;

@Controller
public class KHController {
	
	@Autowired
    KitchenRepository kitchenRepository;
	
	@RequestMapping("/")
	String home() {
		return "app.welcome";
	}

	@RequestMapping("/login")
	String login() {
	  return "app.login";
	}
	
	@RequestMapping("/signup.htm")
	String signup() {
	  return "app.signup";
	}

	@RequestMapping(value = "/findlist")
    public String home(Map<String, Object> model) {
        model.put("message", "HowToDoInJava Reader !!");
        List<Kitchen> klist= kitchenRepository.findAll();
        return "testjsp";
    }
	
	@RequestMapping("/testjsp")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", "testjsp");
		return "testjsp";
	}

}


