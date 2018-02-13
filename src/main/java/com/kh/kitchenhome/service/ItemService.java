package com.kh.kitchenhome.service;

import java.security.Principal;
import java.util.List;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.kitchenhome.model.ItemMaster;

public interface ItemService {

	RedirectAttributes saveItemMaster(ItemMaster itemMaster, RedirectAttributes attributes, Principal principal);

	List<ItemMaster> findAll();

}
