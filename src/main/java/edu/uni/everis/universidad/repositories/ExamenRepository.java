package edu.uni.everis.universidad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uni.everis.universidad.domain.Examen;

public interface ExamenRepository extends JpaRepository<Examen, Integer> {

}
