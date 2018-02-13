package com.kh.kitchenhome.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.kh.kitchenhome.model.ItemMaster;
import com.kh.kitchenhome.service.ItemService;


@Controller
public class ItemController {
	private final Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
    ItemService itemService;
	
	
	@RequestMapping(value = "/itemList.htm", method = RequestMethod.GET)
	public ModelAndView getItemList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("itemMaster");
		return mav;
		
	}
	@RequestMapping(value = "/saveItemList.htm", method = RequestMethod.POST)
	public RedirectView saveItemDetails(@ModelAttribute("itemMaster") ItemMaster itemMaster,
			RedirectAttributes attributes,HttpSession session ,Principal principal) {
		System.out.println("item name "+itemMaster.getItemName());
		attributes = itemService.saveItemMaster(itemMaster, attributes, principal);
		return new RedirectView("itemList.htm", true);
	}
	
	@RequestMapping(value = "/findItemList")
    public String home(Map<String, Object> model) {
        List<ItemMaster> Itemlist= itemService.findAll();
        System.out.println("**********************************"+Itemlist.get(0).getItemName());
       // return "index";
        
        return "itemMaster";
    }
}
