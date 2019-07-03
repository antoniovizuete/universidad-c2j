package edu.uni.everis.universidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uni.everis.universidad.domain.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, String>{

}
