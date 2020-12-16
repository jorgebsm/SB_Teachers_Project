package com.yaprofe.demo.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yaprofe.demo.model.Estudiante;
import com.yaprofe.demo.model.Mensaje;
import com.yaprofe.demo.model.Profesor;
import com.yaprofe.demo.model.Usuario;
import com.yaprofe.demo.service.MessageService;
import com.yaprofe.demo.service.StudentService;
import com.yaprofe.demo.service.TeacherService;
import com.yaprofe.demo.service.UserService;

@Controller
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private UserService userService;
	@GetMapping("/messageForm")
	public String messageForm(Model model) {
		Mensaje mensaje = new Mensaje();
		model.addAttribute("message", mensaje);
		return ("messageForm");
	}
	
	@PostMapping("/save")
	public String Showesave(@Valid Mensaje mensaje, Model model) {
		messageService.save(mensaje);
		return "redirect:/message/messageList/";
	}
	
	@PostMapping("/saveP/{idProfe},{idEstudiante}")
	public String ShowesaveP(@Valid Mensaje mensaje, Model model, @PathVariable(name = "idProfe") int idProfe, @PathVariable(name = "idEstudiante") int idEstudiante) {
		messageService.save(mensaje);
		int id1 = teacherService.getId(idProfe).getId();
		int id2 = studentService.getId(idEstudiante).getId();
		return "redirect:/message/messageP/"+id1+","+id2;
	}
	
	@PostMapping("/saveE/{idProfe},{idEstudiante}")
	public String ShowesaveE(@Valid Mensaje mensaje, Model model, @PathVariable(name = "idProfe") int idProfe, @PathVariable(name = "idEstudiante") int idEstudiante) {
		messageService.save(mensaje);
		int id1 = teacherService.getId(idProfe).getId();
		int id2 = studentService.getId(idEstudiante).getId();
		return "redirect:/message/messageE/"+id1+","+id2;
	}

	
	@GetMapping("/messageList")
	public String messageList(Model model) {
		model.addAttribute("teachers", teacherService.listAll());
		model.addAttribute("students", studentService.listAll());
		Mensaje mensaje = new Mensaje();
		model.addAttribute("message", mensaje);
		model.addAttribute("messages", messageService.listAll());
		return "messageList";
	}
	
	@GetMapping("/messagesP")
	public String messagesP(Model model, Principal principal) {
		
		int idSesion = userService.getUserByUsername(principal.getName()).getProfesor().getId();
		
		List<Mensaje> messageList = messageService.listAll();
		List<Mensaje> messageList2 = new ArrayList<Mensaje>();
		List<Integer> messageList3 = new ArrayList<Integer>();
		List<Estudiante> studentList = studentService.listAll();
		List<Estudiante> studentList2 = new ArrayList<Estudiante>();
		Set<Integer> hs = new HashSet<>();
		
		for(int i=1;i<=messageList.size();i++) {
 			if(messageService.getId(i).getProfesor().getId() == idSesion) {
 				messageList2.add(messageService.getId(i));
 				hs.add(messageService.getId(i).getEstudiante().getId());	
 			}
		}
		messageList3.addAll(hs);

		int var=0;
		for(int i=0;i<studentList.size();i++) {
			for(int j=0;j<messageList3.size();j++) {
				if(studentList.get(i).getId()==messageList3.get(j)) {
					var=messageList3.get(j);
					studentList2.add(studentService.getId(var));
				}
			}
		}
		
		model.addAttribute("students", studentList2);
		model.addAttribute("messages", messageList2);
		return "messagesP";
	}
	
	@GetMapping("/messagesE")
	public String messagesE(Model model, Principal principal) {
		
		int idSesion = userService.getUserByUsername(principal.getName()).getEstudiante().getId();
		
		List<Mensaje> messageList = messageService.listAll();
		List<Mensaje> messageList2 = new ArrayList<Mensaje>();
		List<Integer> messageList3 = new ArrayList<Integer>();
		List<Profesor> teacherList = teacherService.listAll();
		List<Profesor> teacherList2 = new ArrayList<Profesor>();
		Set<Integer> hs = new HashSet<>();
		
		for(int i=1;i<=messageList.size();i++) {
 			if(messageService.getId(i).getEstudiante().getId() == idSesion) {
 				messageList2.add(messageService.getId(i));
 				hs.add(messageService.getId(i).getProfesor().getId());	
 			}
		}
		messageList3.addAll(hs);
		System.out.println(messageList3);

		int var=0;
		for(int i=0;i<teacherList.size();i++) {
			for(int j=0;j<messageList3.size();j++) {
				if(teacherList.get(i).getId()==messageList3.get(j)) {
					var=messageList3.get(j);
					teacherList2.add(teacherService.getId(var));
				}
			}
		}
		
		model.addAttribute("teachers", teacherList2);
		model.addAttribute("messages", messageList2);
		return "messagesE";
	}
	
	@GetMapping("/messageP/{idProfe},{idEstudiante}")
	public String messageP(Model model, @PathVariable(name = "idProfe") int idProfe, @PathVariable(name = "idEstudiante") int idEstudiante, Principal principal) {
		
		Mensaje mensaje = new Mensaje();
		model.addAttribute("message", mensaje);
		
		int idSesion = userService.getUserByUsername(principal.getName()).getProfesor().getId();
		List<Mensaje> messageList = messageService.listAll();
		List<Mensaje> messageList2 = new ArrayList<Mensaje>();
		List<Profesor> teacherList = new ArrayList<Profesor>();
		List<Estudiante> studentList = new ArrayList<Estudiante>();
		
		if(idSesion == idProfe){
			for(int i=1;i<=messageList.size();i++) {
				if(messageService.getId(i).getProfesor().getId() == idProfe) {
					if(messageService.getId(i).getEstudiante().getId() == idEstudiante) {
						messageList2.add(messageService.getId(i));
					}
				}
			}
			teacherList.add(teacherService.getId(idProfe)); //guardamos ese profe
			studentList.add(studentService.getId(idEstudiante)); //Guardamos ese estudiante
		}
		
		model.addAttribute("teachers", teacherList);
		model.addAttribute("students", studentList);
		model.addAttribute("messages", messageList2);
		
		return "messageP";
	}
	
	@GetMapping("/messageE/{idProfe},{idEstudiante}")
	public String messageE(Model model, @PathVariable(name = "idProfe") int idProfe, @PathVariable(name = "idEstudiante") int idEstudiante, Principal principal) {
		
		Mensaje mensaje = new Mensaje();
		model.addAttribute("message", mensaje);
		int idSesion = userService.getUserByUsername(principal.getName()).getEstudiante().getId();
		List<Mensaje> messageList = messageService.listAll();
		List<Mensaje> messageList2 = new ArrayList<Mensaje>();
		List<Profesor> teacherList = new ArrayList<Profesor>();
		List<Estudiante> studentList = new ArrayList<Estudiante>();
		
		if(idSesion == idEstudiante){
			for(int i=1;i<=messageList.size();i++) {
				if(messageService.getId(i).getProfesor().getId() == idProfe) {
					if(messageService.getId(i).getEstudiante().getId() == idEstudiante) {
						messageList2.add(messageService.getId(i));
					}
				}
			}
			teacherList.add(teacherService.getId(idProfe)); //guardamos ese profe
			studentList.add(studentService.getId(idEstudiante)); //Guardamos ese estudiante
		}
		
		model.addAttribute("teachers", teacherList);
		model.addAttribute("students", studentList);
		model.addAttribute("messages", messageList2);
		
		return "messageE";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteMessage(@PathVariable(name = "id") int id) {
		System.out.println(id);
	    messageService.delete(id);
	    return "redirect:/message/messageList";     
	}
	
	@GetMapping("/messageForm/{id}")
	public String Showsave(@PathVariable("id") Integer id, Model model) {
		if(id != null && id != 0) {
			model.addAttribute("message", messageService.getId(id));
		}else {
			model.addAttribute("message", new Mensaje());
		}
		return "messageForm";
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
