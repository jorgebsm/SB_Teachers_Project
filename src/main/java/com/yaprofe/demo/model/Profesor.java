package com.yaprofe.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Profesor")
public class Profesor implements Serializable {
	private static final long serialVersionUID= -1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@Lob
	private String nombres;
	@Lob
	private String apellidos;
	private String rut;

	@Column(name="email")
	private String email;
	@Column(name="nro_telefono")
	private int telefono;
	private String descripcion;
	private String modalidad;
	private int tarifa;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="ciudad_id")
	private Ciudad ciudad;

	@Column(name="nivel_educacional")
	private String nivelEducacional;
	
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(name= "especialidad_profesor",
	joinColumns = @JoinColumn(name="profesor_id", referencedColumnName="id"),
	inverseJoinColumns= @JoinColumn(name="especialidad_id", referencedColumnName="id"))
	@JsonManagedReference
	private List<Especialidad> especialidades;
	
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(name= "mensaje",
	joinColumns = @JoinColumn(name="profesor_id", referencedColumnName="id"),
	inverseJoinColumns= @JoinColumn(name="estudiante_id", referencedColumnName="id"))
	private List<Estudiante> estudiantes;
	
	@OneToOne(mappedBy="profesor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Usuario usuario;
	
	public Profesor() {
		this.especialidades= new ArrayList<>();
	}

	public Profesor(int id, String nombres, String apellidos,String rut, String email, int telefono,
			String descripcion, String modalidad, int tarifa, Ciudad ciudad, String nivelEducacional) {

		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.rut = rut;
		this.email = email;
		this.telefono = telefono;
		this.descripcion = descripcion;
		this.modalidad = modalidad;
		this.tarifa = tarifa;
		this.ciudad = ciudad;
		this.nivelEducacional = nivelEducacional;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public int getTarifa() {
		return tarifa;
	}

	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}


	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad= ciudad;
	}

	public String getNivelEducacional() {
		return nivelEducacional;
	}

	public void setNivelEducacional(String nivelEducacional) {
		this.nivelEducacional = nivelEducacional;
	}
	public List<Especialidad> getEspecialidades(){
		return especialidades;
	}
	public void setEspecialidades(List<Especialidad>especialidades) {
		this.especialidades=especialidades;
	}
	public void addEspecialidad(Especialidad esp) {
		this.especialidades.add(esp);
	}
	public void removeEspecialidad(Especialidad esp) {
		this.especialidades.remove(esp);
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
