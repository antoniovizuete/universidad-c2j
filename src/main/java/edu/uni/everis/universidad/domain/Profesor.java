package edu.uni.everis.universidad.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Profesor extends AbstractPersona {

	@OneToOne(mappedBy = "profesor")
	private Asignatura asignatura;

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	
	
}
