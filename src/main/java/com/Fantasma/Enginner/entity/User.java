package com.Fantasma.Enginner.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
//implements => inplementos Serializable
public class User implements Serializable {
	
	/**
	 * 
	 */
	//add id
	private static final long serialVersionUID = 2756885038352427050L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column( name = "name",length = 50)
	private String name;
	
	@Column(name = "surname", length = 50 )
	private String surname;
	
	@Column(name = "email",length = 100,nullable = false, unique = true)
	private String email;
	
	private Boolean enabled;
	
	// constructor
	public User () {
		
	}
	
	//inisiarlizar-constructor
    public User (String name, String surname, String email, Boolean enabled) {
    	
    	this.name = name;
    	this.surname = surname;
    	this.email = email;
    	this.enabled = enabled;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
    
    

}
