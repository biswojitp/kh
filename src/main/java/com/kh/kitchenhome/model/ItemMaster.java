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
	private Long itemName;
	
	@Column(name="HSN")
	private String HSN;
	
	@Column(name="mfr")
	private String mfr;
	
	@Column(name="sgst")
	private float sgst;
	
	@Column(name="cgst")
	private float cgst;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getItemName() {
		return itemName;
	}

	public void setItemName(Long itemName) {
		this.itemName = itemName;
	}

	public String getHSN() {
		return HSN;
	}

	public void setHSN(String hSN) {
		HSN = hSN;
	}

	public String getMfr() {
		return mfr;
	}

	public void setMfr(String mfr) {
		this.mfr = mfr;
	}

	public float getSgst() {
		return sgst;
	}

	public void setSgst(float sgst) {
		this.sgst = sgst;
	}

	public float getCgst() {
		return cgst;
	}
	
	public void setCgst(float cgst) {
		this.cgst = cgst;
	}
	
	
}
