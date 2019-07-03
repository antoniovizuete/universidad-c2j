package edu.uni.everis.universidad.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uni.everis.universidad.domain.Profesor;
import edu.uni.everis.universidad.repositories.ProfesorRepository;

@Service
@Transactional
public class ProfesorServiceImpl implements ProfesorService {

	private ProfesorRepository repository;

	public ProfesorServiceImpl(ProfesorRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<Profesor> findAll() {
		return repository.findAll();
	}

	@Override
	public Profesor findById(String dni) {
		return repository.findById(dni)
				.orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
	}

	@Override
	public Profesor create(Profesor alumno) {
		repository.findById(alumno.getDni()).ifPresent(a -> {
			throw new RuntimeException("Alumno " + a.getDni() + " ya existente");
		});
		return repository.save(alumno);
	}

	@Override
	public Profesor delete(String dni) {
		Profesor alumno = findById(dni);
		repository.delete(alumno);
		return alumno;
	}
	
	@Override
	public Profesor update(String dni, Profesor alumnoDto) {
		Profesor alumno = findById(dni);
		//BeanUtils.copyProperties(alumnoDto, alumno, "dni");
		alumno.setNombre(alumnoDto.getNombre());
		alumno.setApellidos(alumnoDto.getApellidos());
		return repository.save(alumno);
	}
}
