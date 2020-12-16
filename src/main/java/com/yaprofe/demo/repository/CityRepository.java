package com.yaprofe.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.yaprofe.demo.model.Ciudad;

@Repository
public interface CityRepository extends JpaRepository<Ciudad,Integer>{

}
