package com.yaprofe.demo.model;

public enum NivelEducacional {
Básica("Básica"),
Media("Media"),
Superior("Superior");
	
private String nombre;

	private NivelEducacional() {}

	NivelEducacional(String nombre)	{
		this.nombre = nombre;
	}
}
