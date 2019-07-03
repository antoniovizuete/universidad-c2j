package edu.uni.everis.universidad.domain;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractPersona {

	@Id
	private String dni;
	private String nombre;
	private String apellidos;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	@Override
	public String toString() {
		return this.getClass().getName()+" [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	
	
}
