package com.ducat.springboot.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducat.springboot.rest.dao.Mydaorepository;
import com.ducat.springboot.rest.model.Teacher;

@Service
public class Myserviceimpl implements Myservice
{
	
	 @Autowired
	  Mydaorepository dao;

	@Override
	public List<Teacher> getteacher() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Teacher> getById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Teacher addNewTeacher(Teacher newteach) {
		// TODO Auto-generated method stub
		return dao.save(newteach);
	}

	@Override
	public Optional<Teacher> getTeacherById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Teacher updateTeacher(Teacher updteach) {
		// TODO Auto-generated method stub
		return dao.save(updteach);
	}

	@Override
	public void deletetTeacherById(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public void deleteAllTeacher() {
		// TODO Auto-generated method stub
		dao.deleteAll();
		
	}

	@Override
	public List<Teacher> getTeacher() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTeacherById(int teachid) {
		// TODO Auto-generated method stub
		
	}
	 
}
