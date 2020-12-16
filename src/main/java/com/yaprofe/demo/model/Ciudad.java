package com.yaprofe.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Ciudad")
public class Ciudad {
	private static final long serialVersionUID= -1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="ciudad_id")
	private int id;
	@Lob
	private String nombre_ciudad;
	
	@OneToMany(mappedBy="ciudad", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Profesor> profesores;

	
	public Ciudad() {}

	public Ciudad(int id, String nombre_ciudad) {
		super();
		this.id = id;
		this.nombre_ciudad = nombre_ciudad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getNombre_ciudad() {
		return nombre_ciudad;
	}
	
	public void setNombre_ciudad(String nombre_ciudad) {
		this.nombre_ciudad = nombre_ciudad;
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
