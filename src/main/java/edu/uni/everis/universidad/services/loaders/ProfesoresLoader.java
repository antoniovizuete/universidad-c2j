package edu.uni.everis.universidad.services.loaders;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uni.everis.universidad.domain.Profesor;
import edu.uni.everis.universidad.repositories.ProfesorRepository;

@Service
public class ProfesoresLoader {
	
	private static Logger logger = LoggerFactory.getLogger(ProfesoresLoader.class);
	
	private ProfesorRepository repository;

	@Autowired
	public ProfesoresLoader(ProfesorRepository repository) {
		this.repository = repository;
	}
	
	public void load() {
		if(repository.count() > 0) {
			logger.info("Ya existen alumnos");
			return;
		}
		
		List<Profesor> profesores = new ArrayList<>();
		
		Profesor profesor = new Profesor();
		profesor.setDni("544544545H");
		profesor.setNombre("Jero");
		profesor.setApellidos("Izquierdo");
		
		profesores.add(profesor);
		
		profesor = new Profesor();
		profesor.setDni("544644545Q");
		profesor.setNombre("Ruben");
		profesor.setApellidos("Navarro");
		
		profesores.add(profesor);
		
		logger.info("Cargando profesores: {}", profesores);
		repository.saveAll(profesores);
	}
}
