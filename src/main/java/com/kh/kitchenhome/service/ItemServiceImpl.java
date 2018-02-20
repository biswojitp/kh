package com.kh.kitchenhome.service;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.kitchenhome.model.ItemCategory;
import com.kh.kitchenhome.model.ItemMaster;
import com.kh.kitchenhome.model.ItemSubCategory;
import com.kh.kitchenhome.repository.CategoryRepository;
import com.kh.kitchenhome.repository.ItemRepository;
import com.kh.kitchenhome.repository.SubCategoryRepository;


@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	SubCategoryRepository subCategoryRepository;
	

	@Override
	public RedirectAttributes saveItemMaster(ItemMaster itemMaster, RedirectAttributes attributes,
			Principal principal) {
		itemRepository.save(itemMaster);
		return null;
	}


	@Override
	public List<ItemMaster> findAll() {
		List<ItemMaster> itemlist=itemRepository.findAll();
 		return itemlist;
	}


	@Override
	public RedirectAttributes saveItemCategory(ItemCategory itemCategory, RedirectAttributes attributes,
			Principal principal) {
		categoryRepository.save(itemCategory);
		return null;
	}


	@Override
	public List<ItemCategory> findAllItemtCategory() {
		
		return categoryRepository.findAll();
	}


	@Override
	public List<ItemSubCategory> findAllItemtSubCategory() {
		
		return subCategoryRepository.findAll();
	}

}
