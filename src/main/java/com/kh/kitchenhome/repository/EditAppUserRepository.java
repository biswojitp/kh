package com.kh.kitchenhome.repository;


	

import com.kh.kitchenhome.model.AppUser;
import com.kh.kitchenhome.model.EditAppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Repository;

	@Repository
	public interface EditAppUserRepository extends JpaRepository<AppUser, Long> {

		void save(EditAppUser editAppUser);


	}


