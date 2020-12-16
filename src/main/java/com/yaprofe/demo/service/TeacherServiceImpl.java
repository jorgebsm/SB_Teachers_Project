package com.yaprofe.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaprofe.demo.model.Profesor;
import com.yaprofe.demo.repository.TeacherRepository;

 @Service    
public class TeacherServiceImpl implements TeacherService {
	 
	 @Autowired
	 private TeacherRepository teacherRepository;

	@Override
	public List<Profesor> listAll() {
		return teacherRepository.findAll();
	}

	@Override
	public void save(Profesor profesor) {
		teacherRepository.save(profesor);
		
	}

	@Override
	public void delete(int id) {
		teacherRepository.deleteById(id);
	}

	@Override
	public Profesor getId(int id) {
		return teacherRepository.findById(id).get();
	}
	@Override
	public Profesor findByEmail(String email) {
		return teacherRepository.findByEmail(email);
	}
	
	@Override
	public Profesor findByNombres(String nombres) {
		return teacherRepository.findByNombres(nombres);
	}

}
