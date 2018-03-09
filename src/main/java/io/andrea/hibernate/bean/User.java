package io.andrea.hibernate.bean;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User implements Serializable{

	private static final long serialVersionUID = 8981031703822764032L;

	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	
	
}
