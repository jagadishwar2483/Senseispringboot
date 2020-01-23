package com.ducat.springboot.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

@Component


//Spring jpa jars
@Entity
@Table(name= "teacher")

//To increase speed and save sql statement execution time.
@DynamicInsert
@DynamicUpdate
public class Teacher 
{
	@Id 
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	private  String name;
	private String subject;
	
	public Teacher() {
		
	}

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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", subject=" + subject + "]";
	}
	
	
}
