package com.yaprofe.demo.service;

import java.util.List;
import com.yaprofe.demo.model.Mensaje;

public interface MessageService {
	List <Mensaje> listAll();
	void save (Mensaje mensaje);
	void delete (int id);
	Mensaje getId (int id);
}
