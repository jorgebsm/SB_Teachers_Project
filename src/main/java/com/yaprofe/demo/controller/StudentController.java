package com.yaprofe.demo.controller;

import java.security.Principal;
import java.sql.Date;
import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yaprofe.demo.model.Estudiante;
import com.yaprofe.demo.model.Rol;
import com.yaprofe.demo.model.Usuario;
import com.yaprofe.demo.repository.RolRepository;
import com.yaprofe.demo.service.StudentService;
import com.yaprofe.demo.service.UserService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private UserService userService;
	@Autowired
	private RolRepository rolRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@GetMapping("/studentForm")
	public String studentForm(Model model) {
		Estudiante student = new Estudiante();
		model.addAttribute("student", student);
		return ("studentForm");
	}
	
	@PostMapping("/save")
	public String saveCustomer(@Valid Estudiante estudiante, Model model, @RequestParam("password")String pass) {
		studentService.save(estudiante);
		Usuario usuario = new Usuario();
		usuario.setUsername(estudiante.getEmail());
		String passEncode = bCryptPasswordEncoder.encode(pass);
		usuario.setPassword(passEncode);
		usuario.setEstudiante(estudiante);
		userService.save(usuario);
		Rol rol = new Rol();
		rol.setNombre("ROLE_ESTUDIANTE");
		rol.setUsuario(usuario);
		rolRepository.save(rol);
		return "redirect:/student/studentList";
	}

	@GetMapping("/studentList")
	public String form(Model model) {
		model.addAttribute("students", studentService.listAll());
		return "studentList";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable(name = "id") int id) {
		System.out.println(id);
	    studentService.delete(id);
	    return "redirect:/student/studentList";     
	}
	
	@GetMapping("/studentForm/{id}")
	public String Showsave(@PathVariable("id") Integer id, Model model) {
		if(id != null && id != 0) {
			model.addAttribute("student", studentService.getId(id));
		}else {
			model.addAttribute("student", new Estudiante());
		}
		return "studentForm";
	}

	@ModelAttribute(value = "name")
	public Model getUserName(Model model, Principal principal) {
		if(principal != null) {
			Usuario usuario = userService.getUserByUsername(principal.getName());
			if(usuario.getEstudiante() == null) {
			String nombre = usuario.getProfesor().getNombres();
			model.addAttribute("name", nombre);
			return model;
			}
		model.addAttribute("name", usuario.getEstudiante().getNombres());
		return model;	
		}
		return model;
	}
}
