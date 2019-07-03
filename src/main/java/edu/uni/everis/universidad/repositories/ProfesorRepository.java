package edu.uni.everis.universidad.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.uni.everis.universidad.domain.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, String>{

	@Query(value = "SELECT DISTINCT DNI, NOMBRE, APELLIDOS FROM PROFESOR", 
			nativeQuery = true)
	public List<Profesor> findAll();
}
