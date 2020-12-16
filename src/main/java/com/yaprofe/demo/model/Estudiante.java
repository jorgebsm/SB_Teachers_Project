package com.yaprofe.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Estudiante")
public class Estudiante implements Serializable {
	private static final long serialVersionUID= -1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@Lob
	private String rut;
	@Lob
	private String nombres;
	@Lob
	private String apellidos;
	@Lob
	private String email;
	@Column(name="nro_telefono")
	private int telefono;
	@Lob
	
	@OneToOne(mappedBy="estudiante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Usuario usuario;
	
	public Estudiante() {}

	public Estudiante(int id, String rut, String nombres, String apellidos, String email, int telefono) {		
		this.id = id;
		this.rut = rut;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.telefono = telefono;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
