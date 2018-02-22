package com.kh.kitchenhome.controller;

import java.security.Principal;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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

import com.kh.kitchenhome.model.AppUser;
import com.kh.kitchenhome.model.Login;
import com.kh.kitchenhome.repository.AppUserRepository;

@Controller
public class AppUserController {
	@Autowired
    AppUserRepository appUserRepository;
	
	@RequestMapping("/registration.htm")
	public String welcome(Map<String, Object> model) {
		return "appUser";
	}
	
	@RequestMapping(value="/saveAppUser",method=RequestMethod.POST)
	public RedirectView saveRegistration(@ModelAttribute("appUser") AppUser appUser,
			RedirectAttributes attributes,HttpSession session ,Principal principal) {
		
		appUserRepository.save(appUser);

		return new RedirectView("registration.htm", true);
	
	}
	@RequestMapping(value="/getAppUser",method=RequestMethod.GET)
	public RedirectView getUserList(@ModelAttribute("appUser") AppUser appUser,
			RedirectAttributes attributes,HttpSession session ,Principal principal, Iterable<Long> ids) {
		appUserRepository.findAllById(ids);
	         return new RedirectView("appUser.htm",true);

		}


	
	@RequestMapping("/getAppUser.htm")
	public String getUserList(Map<String, Object> model) {
		List<AppUser> userList=appUserRepository.findAll();
		//userList.sort(Comparator.comparingLong(AppUser::getUserId));
		Collections.sort(userList, new Comparator<Object>() {

		    @Override
		    public int compare(Object A1, Object A2) {

		        return ((AppUser) A1).getUserId().compareTo(((AppUser) A2).getUserId());

		    }
		});
		model.put("regUserList",userList);
		return "userList";
	}
}