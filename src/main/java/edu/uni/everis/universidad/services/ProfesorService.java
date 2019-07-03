package edu.uni.everis.universidad.services;

import java.util.List;

import edu.uni.everis.universidad.domain.Profesor;

public interface ProfesorService {

	List<Profesor> findAll();

	Profesor findById(String dni);

	Profesor create(Profesor alumno);

	Profesor delete(String dni);

	Profesor update(String dni, Profesor alumnoDto);

}