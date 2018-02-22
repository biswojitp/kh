package com.kh.kitchenhome.repository;


	

import com.kh.kitchenhome.model.AppUser;
import com.kh.kitchenhome.model.Kitchen;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Repository;

	@Repository
	public interface AppUserRepository extends JpaRepository<AppUser, Long> {


	}


