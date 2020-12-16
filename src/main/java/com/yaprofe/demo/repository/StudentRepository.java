package com.yaprofe.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yaprofe.demo.model.Estudiante;

@Repository
public interface StudentRepository extends JpaRepository<Estudiante,Integer> {

}
