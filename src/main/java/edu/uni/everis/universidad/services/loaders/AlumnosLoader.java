package edu.uni.everis.universidad.services.loaders;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uni.everis.universidad.domain.Alumno;
import edu.uni.everis.universidad.repositories.AlumnoRepository;

@Service
public class AlumnosLoader {
	
	private static Logger logger = LoggerFactory.getLogger(AlumnosLoader.class);
	
	private AlumnoRepository repository;

	@Autowired
	public AlumnosLoader(AlumnoRepository repository) {
		this.repository = repository;
	}
	
	public void load() {
		if(repository.count() > 0) {
			logger.info("Ya existen alumnos");
			return;
		}
		
		List<Alumno> alumnos = new ArrayList<>();
		
		Alumno alumno = new Alumno();
		alumno.setDni("00000005K");
		alumno.setNombre("Juan Carlos");
		alumno.setApellidos("Borbon");
		
		alumnos.add(alumno);
		
		alumno = new Alumno();
		alumno.setDni("00000006H");
		alumno.setNombre("Sofia");
		alumno.setApellidos("De Grecia");
		
		alumnos.add(alumno);
		
		logger.info("Cargando alumnos: {}", alumnos);
		repository.saveAll(alumnos);
	}
}
