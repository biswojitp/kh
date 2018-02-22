package com.kh.kitchenhome.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "app_user")
public class EditAppUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;

    @NotBlank
    @Column(name = "first_name")
    private String firstName;
    
    @NotBlank
    @Column(name = "last_name")
    private String lastName;
    
    @NotBlank
    @Column(name = "gender")
    private String gender;

    @NotBlank
    @Column(name = "password")
    private String password;
    
    @NotBlank
    @Column(name = "email")
    private String email;
    
    @NotBlank
    @Column(name = "phone")
    private String phone;
    
    public String getFirstName() {
       return firstName;
    }
    public void setFirstName(String firstName) {
       this.firstName=firstName;
    }
    public Long getUserId() {
    	return userId;
    }
    public void setUserId(Long userId) {
    	this.userId=userId;
    }
    public String getLastName() {
    	return lastName;
    }
    public void setLastName(String lastName) {
    	this.lastName=lastName;
    }
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
    
    
}

