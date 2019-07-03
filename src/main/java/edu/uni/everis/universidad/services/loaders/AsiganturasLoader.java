package edu.uni.everis.universidad.services.loaders;

import java.util.ArrayList;
import java.util.List;

import edu.uni.everis.universidad.domain.Alumno;
import edu.uni.everis.universidad.domain.Asignatura;
import edu.uni.everis.universidad.repositories.AlumnoRepository;
import edu.uni.everis.universidad.repositories.AsignaturaRepository;
import edu.uni.everis.universidad.repositories.ProfesorRepository;

public class AsiganturasLoader {
	
	private AsignaturaRepository asignaturaRepository;
	private ProfesorRepository profesorRepository;
	private AlumnoRepository alumnoRepository;

	public AsiganturasLoader(AsignaturaRepository asignaturaRepository,ProfesorRepository profesorRepository,
			AlumnoRepository alumnoRepository) {
		super();
		this.asignaturaRepository = asignaturaRepository;
		this.profesorRepository = profesorRepository;
		this.alumnoRepository = alumnoRepository;
	}
	
	public void load() {
		if (asignaturaRepository.count() > 0 ) {
			return;
		}
		
		Asignatura asignatura = new Asignatura();
		
		List<Asignatura> listaAsignaturas = new ArrayList<> ();
		List<Alumno> listaAlumnos	 = new ArrayList<>();
		
		asignatura.setNombre("Chorrología");
		asignatura.setProfesor(profesorRepository.getOne("92308096B"));
		listaAlumnos.add(alumnoRepository.getOne("00000000A"));
		listaAlumnos.add(alumnoRepository.getOne("00000001B"));
		asignatura.setAlumnos(listaAlumnos);

		listaAsignaturas.add(asignatura);
		
		asignatura.setNombre("Zurrir mierdas con palo");
		asignatura.setProfesor(profesorRepository.getOne("80283126Q"));
		listaAlumnos.add(alumnoRepository.getOne("00000000A"));
		listaAlumnos.add(alumnoRepository.getOne("00000001B"));
		asignatura.setAlumnos(listaAlumnos);

		listaAsignaturas.add(asignatura);
		
		asignaturaRepository.saveAll(listaAsignaturas);
	}
	
}
