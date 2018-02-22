package com.kh.kitchenhome.repository;


	

import com.kh.kitchenhome.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Repository;

	@Repository
	public interface LoginRepository extends JpaRepository<Login,Long> {


	}


