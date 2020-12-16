package com.yaprofe.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yaprofe.demo.model.Mensaje;

public interface MessageRepository extends JpaRepository<Mensaje,Integer>{

}
