package edu.uni.everis.universidad.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uni.everis.universidad.domain.Alumno;
import edu.uni.everis.universidad.repositories.AlumnoRepository;

@Service
@Transactional
public class AlumnoServiceImpl implements AlumnoService {

	private AlumnoRepository repository;

	public AlumnoServiceImpl(AlumnoRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<Alumno> findAll() {
		return repository.findAll();
	}

	@Override
	public Alumno findById(String dni) {
		return repository.findById(dni)
				.orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
	}

	@Override
	public Alumno create(Alumno alumno) {
		repository.findById(alumno.getDni()).ifPresent(a -> {
			throw new RuntimeException("Alumno " + a.getDni() + " ya existente");
		});
		return repository.save(alumno);
	}

	@Override
	public Alumno delete(String dni) {
		Alumno alumno = findById(dni);
		repository.delete(alumno);
		return alumno;
	}
	
	@Override
	public Alumno update(String dni, Alumno alumnoDto) {
		Alumno alumno = findById(dni);
		//BeanUtils.copyProperties(alumnoDto, alumno, "dni");
		alumno.setNombre(alumnoDto.getNombre());
		alumno.setApellidos(alumnoDto.getApellidos());
		return repository.save(alumno);
	}
}
