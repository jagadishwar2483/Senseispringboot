package com.ducat.springboot.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ducat.springboot.rest.model.Teacher;
import com.ducat.springboot.rest.service.Myservice;

@RestController
public class Mycontroller 
{
	@Autowired
    Myservice service;
	
	 @RequestMapping(value= "/teacher/all", method= RequestMethod.GET)
	    public List<Teacher> getteacher()
	 	{
	        System.out.println(this.getClass().getSimpleName() + " - Get all teachers service is invoked.");
	        return service.getteacher();
	    }
	 

	    @RequestMapping(value= "/teacher/{id}", method= RequestMethod.GET)
	    public Teacher getTeacherById(@PathVariable int id) throws Exception {
	        System.out.println(this.getClass().getSimpleName() + " - Get teacher details by id is invoked.");
	 
	        Optional<Teacher> teach =  service.getById(id);
	        if(!teach.isPresent())
	            throw new Exception("Could not find teacher with id- " + id);
	 
	        return teach.get();
	    }
	    
	    @RequestMapping(value= "/teacher/add", method= RequestMethod.POST)
	    public Teacher createTeacher(@RequestBody Teacher newteach) {
	        System.out.println(this.getClass().getSimpleName() + " - Create new employee method is invoked.");
	        return service.addNewTeacher(newteach);
	    }
	 
	    @RequestMapping(value= "/teacher/update/{id}", method= RequestMethod.PUT)
	    public Teacher updateTeacher(@RequestBody Teacher updteach, @PathVariable int id) throws Exception {
	        System.out.println(this.getClass().getSimpleName() + " - Update teacher details by id is invoked.");
	 
	        Optional<Teacher> teach =  service.getTeacherById(id);
	        if (!teach.isPresent())
	            throw new Exception("Could not find employee with id- " + id);
	 
	        /* IMPORTANT - To prevent the overriding of the existing value of the variables in the database, 
	         * if that variable is not coming in the @RequestBody annotation object. */    
	        if(updteach.getName() == null || updteach.getName().isEmpty())
	            updteach.setName(teach.get().getName());
	        if(updteach.getSubject() == null || updteach.getSubject().isEmpty())
	            updteach.setSubject(teach.get().getSubject());
	        
	 
	        // Required for the "where" clause in the sql query template.
	        updteach.setId(id);
	        return service.updateTeacher(updteach);
	    }
	    @RequestMapping(value= "/teacher/delete/{id}", method= RequestMethod.DELETE)
	    public void deleteTeacherById(@PathVariable int id) throws Exception {
	        System.out.println(this.getClass().getSimpleName() + " - Delete teacher by id is invoked.");
	 
	        Optional<Teacher> emp =  service.getTeacherById(id);
	        if(!emp.isPresent())
	            throw new Exception("Could not find employee with id- " + id);
	 
	        service.deletetTeacherById(id);
	    }
	    @RequestMapping(value= "/teacher/deleteall", method= RequestMethod.DELETE)
	    public void deleteAll() {
	        System.out.println(this.getClass().getSimpleName() + " - Delete all teacher is invoked.");
	        service.deleteAllTeacher();
	    }
}
