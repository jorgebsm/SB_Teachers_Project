package com.yaprofe.demo.service;

import java.util.List;

import com.yaprofe.demo.model.Usuario;

public interface UserService {
	List <Usuario> listAll();
	void save (Usuario user);
	void delete (int id);
	Usuario getUserById(int id);
	Usuario getUserByUsername(String username);
}
