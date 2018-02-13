package com.kh.kitchenhome.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.kitchenhome.model.ItemMaster;

public interface ItemRepository extends JpaRepository<ItemMaster, Long>{

}
