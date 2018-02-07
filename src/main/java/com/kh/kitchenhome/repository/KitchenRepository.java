package com.kh.kitchenhome.repository;


	

import com.kh.kitchenhome.model.Kitchen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Repository;

	@Repository
	public interface KitchenRepository extends JpaRepository<Kitchen, Long> {

	}


