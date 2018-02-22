package com.kh.kitchenhome.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kh.kitchenhome.model.ItemCategory;

public interface CategoryRepository extends JpaRepository<ItemCategory, Long>{

	@Query("FROM ItemCategory WHERE categoryId=:categoryId")
	ItemCategory findOne(@Param("categoryId") Long categoryId);

	/*@Query("FROM PropertyMngmntUnit ORDER BY id DESC")
	List<PropertyMngmntUnit> findAllDesc();*/

}
