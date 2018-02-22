package com.kh.kitchenhome.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.kh.kitchenhome.model.Login;
import com.kh.kitchenhome.repository.LoginRepository;


@Controller
public class LoginController {
	@Autowired
    LoginRepository loginRepository;
	
	@RequestMapping("/login.htm")
	public String welcome(Map<String, Object> model) {
		return "login";
	} 
	
	@RequestMapping(value="/getLogin",method=RequestMethod.GET)
	public RedirectView getLogin(@ModelAttribute("login") Login uiLogin,
			RedirectAttributes attributes,HttpSession session ,Principal principal) {
		boolean matchSuccessful=false;
		List<Login> loginList=loginRepository.findAll();
	    for (Login login : loginList) {
	    	if((uiLogin.getEmail().equals(login.getEmail())) && (uiLogin.getPassword().equals(login.getPassword()))){
			//System.out.println(login.getEmail()+ " "+ login.getPassword());
			matchSuccessful=true;
			}
	    }
	    if(matchSuccessful) {
			return new RedirectView("loginSuccess.htm",true);
	    }else {
		 return new RedirectView("loginFailed.htm",true);
		 }
	
	    }
	@RequestMapping("/loginSuccess.htm")
	public String loginSuccess(Map<String, Object> model) {
		return "loginSuccess";
	}
	@RequestMapping("/loginFailed.htm")
	public String loginFailed(Map<String, Object> model) {
		return "loginFailed";
	}
}
