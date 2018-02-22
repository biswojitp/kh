package com.kh.kitchenhome.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.kh.kitchenhome.model.AppUser;
import com.kh.kitchenhome.model.EditAppUser;
import com.kh.kitchenhome.model.Login;
import com.kh.kitchenhome.repository.AppUserRepository;
import com.kh.kitchenhome.repository.EditAppUserRepository;

@Controller
public class EditAppUserController {
	@Autowired
    EditAppUserRepository editAppUserRepository;
	@RequestMapping("/editAppUser.htm")
	public String editAppUser(@RequestParam("userId") String userId, Map<String, Object> model) {
		Optional<AppUser> editAppUser=editAppUserRepository.findById(Long.valueOf(userId));
		
		if(editAppUser.isPresent()) {
			model.put("appUser", editAppUser.get());
		}

		return "editAppUser";
	}
	
    @RequestMapping(value="/updateAppUser",method=RequestMethod.POST)
	public String saveAppUser(@ModelAttribute("editAppUser") EditAppUser editAppUser,
			RedirectAttributes attributes,HttpSession session ,Principal principal) {
		
		editAppUserRepository.save(editAppUser);

		return  "editAppUser";
	
	}
	
}