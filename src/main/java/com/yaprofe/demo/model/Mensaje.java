package com.yaprofe.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="mensaje")
public class Mensaje {
	private static final long serialVersionUID= -1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@Lob
	private String contenido;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="Profesor_id")
	private Profesor profesor;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="Estudiante_id")
	private Estudiante estudiante;
	
	@Lob
	private String emisor_Profesor;
	
	public Mensaje() {}


	public Mensaje(int id, String nombre, String contenido, Profesor profesor, Estudiante estudiante, String emisor_Profesor) {
		this.id = id;
		this.contenido = contenido;
		this.profesor = profesor;
		this.estudiante = estudiante;
		this.emisor_Profesor = emisor_Profesor;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getContenido() {
		return contenido;
	}
	
	public Profesor getProfesor() {
		return profesor;
	}
	
	public Estudiante getEstudiante() {
		return estudiante;
	}
	

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	public void setProfesor(Profesor profesor) {
		this.profesor= profesor;
	}
	
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante= estudiante;
	}


	public String getEmisor_Profesor() {
		return emisor_Profesor;
	}


	public void setEmisor_Profesor(String emisor_Profesor) {
		this.emisor_Profesor = emisor_Profesor;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
