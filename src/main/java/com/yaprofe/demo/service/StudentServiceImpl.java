package com.yaprofe.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaprofe.demo.model.Estudiante;
import com.yaprofe.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Estudiante> listAll() {
		return studentRepository.findAll();
	}

	@Override
	public void save(Estudiante estudiante) {
		studentRepository.save(estudiante);
		
	}

	@Override
	public void delete(int id) {
		studentRepository.deleteById(id);
	}

	@Override
	public Estudiante getId(int id) {
		return studentRepository.findById(id).get();
	}
}
