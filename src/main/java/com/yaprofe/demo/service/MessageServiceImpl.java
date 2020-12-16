package com.yaprofe.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaprofe.demo.model.Mensaje;
import com.yaprofe.demo.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageRepository messageRepository;
	
	@Override
	public List<Mensaje> listAll() {
		return messageRepository.findAll();
	}

	@Override
	public void save(Mensaje mensaje) {
		messageRepository.save(mensaje);
	}

	@Override
	public void delete(int id) {
		messageRepository.deleteById(id);
		
	}

	@Override
	public Mensaje getId(int id) {
		// TODO Auto-generated method stub
		return messageRepository.findById(id).get();
	}
}
