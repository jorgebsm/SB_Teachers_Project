package com.yaprofe.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "usuario")
public class Usuario implements Serializable{
	private static final long serialVersionUID= -1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	private String username;
	
	private String password;
	
	@OneToOne
	@JoinColumn(name="profesor_id", referencedColumnName="id")
	private Profesor profesor;
	
	@OneToOne
	@JoinColumn(name="estudiante_id", referencedColumnName="id")
	private Estudiante estudiante;
	
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName="id")
    private List<Rol> roles;
	
	public Usuario() {
		roles = new ArrayList<>();
	}
	
	public Usuario(int id, String username, String password, Profesor profesor, Estudiante estudiante, Rol rol) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.profesor = profesor;
		this.estudiante = estudiante;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	public List<Rol> getRoles() {
		return roles;
	}
	public void setRoles(List<Rol>roles) {
		this.roles = roles;
	}
	public void addRol(Rol rol) {
		this.roles.add(rol);
	}
	public void removeRol(Rol rol) {
		this.roles.remove(rol);
	}
}
