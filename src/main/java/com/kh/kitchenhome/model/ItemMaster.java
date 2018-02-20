package com.kh.kitchenhome.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_itemmaster")
public class ItemMaster implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(name="id",strategy="increment")
	@GeneratedValue(generator="id")
	
	@Column(name="id")
	private Long Id;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="HSN")
	private String HSN;
	
	@Column(name="mfr")
	private String mfr;
	
	@Column(name="sgst")
	private String sgst;
	
	@Column(name="cgst")
	private String cgst;
	
	public String getMfr() {
		return mfr;
	}

	public void setMfr(String mfr) {
		this.mfr = mfr;
	}

	public String getSgst() {
		return sgst;
	}

	public void setSgst(String sgst) {
		this.sgst = sgst;
	}

	public String getCgst() {
		return cgst;
	}

	public void setCgst(String cgst) {
		this.cgst = cgst;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getHSN() {
		return HSN;
	}

	public void setHSN(String hSN) {
		HSN = hSN;
	}

	
	
	
}
