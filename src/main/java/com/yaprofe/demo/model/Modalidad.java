package com.yaprofe.demo.model;

public enum Modalidad {
Presencial("Presencial"),
Online("Online");
	
private String nombre;

	private Modalidad() {}

	Modalidad(String nombre)	{
		this.nombre = nombre;
	}
}
