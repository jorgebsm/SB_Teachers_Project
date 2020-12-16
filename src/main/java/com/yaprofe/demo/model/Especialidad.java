package com.yaprofe.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Especialidad")
public class Especialidad implements Serializable{
	private static final long serialVersionUID= -1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@Lob
	private String nombre;
	@Lob
	private String descripcion;
	@ManyToMany(mappedBy="especialidades")
	@JsonBackReference
	private List<Profesor> profesores;
	
	public Especialidad() {}


	public Especialidad(int id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Profesor>getProfesores(){
		return this.profesores;
	}
	public void setProfesores(List<Profesor>profesores) {
		this.profesores=profesores;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
