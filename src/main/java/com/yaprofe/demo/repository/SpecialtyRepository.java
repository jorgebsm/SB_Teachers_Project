package com.yaprofe.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yaprofe.demo.model.Especialidad;

@Repository
public interface SpecialtyRepository extends JpaRepository<Especialidad,Integer>{

}
