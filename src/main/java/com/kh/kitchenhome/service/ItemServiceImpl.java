package com.kh.kitchenhome.service;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.kitchenhome.model.ItemMaster;
import com.kh.kitchenhome.repository.ItemRepository;


@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	ItemRepository itemRepository;
	

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

}
