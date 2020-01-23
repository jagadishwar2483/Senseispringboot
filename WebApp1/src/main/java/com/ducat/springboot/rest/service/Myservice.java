package com.ducat.springboot.rest.service;

import java.util.List;
import java.util.Optional;

import com.ducat.springboot.rest.model.Teacher;

public interface Myservice 
{

	java.util.List<Teacher> getteacher();

	Optional<Teacher> getById(int id);

	Teacher addNewTeacher(Teacher newteach);

	Optional<Teacher> getTeacherById(int id);

	Teacher updateTeacher(Teacher updteach);


	void deletetTeacherById(int id);

	void deleteAllTeacher();

	List<Teacher> getTeacher();

	void deleteTeacherById(int teachid);

	
}
