package edu.uni.everis.universidad.services;

import java.util.List;

import edu.uni.everis.universidad.domain.Alumno;

public interface AlumnoService {

	List<Alumno> findAll();

	Alumno findById(String dni);

	Alumno create(Alumno alumno);

	Alumno delete(String dni);

	Alumno update(String dni, Alumno alumnoDto);

}