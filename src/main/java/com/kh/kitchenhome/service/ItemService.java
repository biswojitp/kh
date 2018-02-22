package com.kh.kitchenhome.service;

import java.security.Principal;
import java.util.List;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.kitchenhome.model.ItemCategory;
import com.kh.kitchenhome.model.ItemMaster;
import com.kh.kitchenhome.model.ItemSubCategory;

public interface ItemService {

	RedirectAttributes saveItemMaster(ItemMaster itemMaster, RedirectAttributes attributes, Principal principal);

	List<ItemMaster> findAll();

	RedirectAttributes saveItemCategory(ItemCategory itemCategory, RedirectAttributes attributes, Principal principal);

	List<ItemCategory> findAllItemtCategory();

	List<ItemSubCategory> findAllItemtSubCategory();

	ItemCategory findOneItemtCategory(Long categoryId);

}
