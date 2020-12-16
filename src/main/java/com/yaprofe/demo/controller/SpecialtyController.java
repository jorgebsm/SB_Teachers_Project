package com.yaprofe.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yaprofe.demo.model.Especialidad;
import com.yaprofe.demo.model.Estudiante;
import com.yaprofe.demo.service.SpecialtyService;

@Controller
@RequestMapping("/specialty")
public class SpecialtyController {
	
	@Autowired
	private SpecialtyService specialtyService;
	
	@GetMapping("/specialtyForm")
	public String specialtyForm(Model model) {
		Especialidad especialidad = new Especialidad();
		model.addAttribute("specialty", especialidad);
		return ("specialtyForm");
	}
	
	@PostMapping("/save")
	public String Showesave(@Valid Especialidad especialidad, Model model) {
		specialtyService.save(especialidad);
		return "redirect:/specialty/specialtyList";
	}
	
	@GetMapping("/specialtyList")
	public String list(Model model) {
		model.addAttribute("specialties", specialtyService.listAll());
		return "specialtyList";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteSpecialty(@PathVariable(name = "id") int id) {
		System.out.println(id);
	    specialtyService.delete(id);
	    return "redirect:/specialty/specialtyList";     
	}
	
	@GetMapping("/specialtyForm/{id}")
	public String Showsave(@PathVariable("id") Integer id, Model model) {
		if(id != null && id != 0) {
			model.addAttribute("specialty", specialtyService.getId(id));
		}else {
			model.addAttribute("specialty", new Estudiante());
		}
		return "specialtyForm";
	}
}
