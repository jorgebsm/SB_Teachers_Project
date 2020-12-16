package com.yaprofe.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class YaProfeApplication implements CommandLineRunner{

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(YaProfeApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		String password= "1234";
		String bencryptPassword = bCryptPasswordEncoder.encode(password);
		System.out.println(bencryptPassword);
	}

}
