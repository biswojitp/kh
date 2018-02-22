package com.kh.kitchenhome.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="t_item_subcategory")

public class ItemSubCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="id",strategy="increment")
	@GeneratedValue(generator="id")
	
	@Column(name="subCategory_id")
	private Long SubCategoryId;

	@Column(name="subCategory_name")
	private String subCategoryName;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private ItemCategory itemCategory;
	
	
	@Column(name="subCategory_code")
	private String subCategoryCode;
	
	@Column(name="description")
	private String description;

	public Long getSubCategoryId() {
		return SubCategoryId;
	}

	public void setSubCategoryId(Long subCategoryId) {
		SubCategoryId = subCategoryId;
	}

	
	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public ItemCategory getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(ItemCategory itemCategory) {
		this.itemCategory = itemCategory;
	}

	
	public String getSubCategoryCode() {
		return subCategoryCode;
	}

	public void setSubCategoryCode(String subCategoryCode) {
		this.subCategoryCode = subCategoryCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
