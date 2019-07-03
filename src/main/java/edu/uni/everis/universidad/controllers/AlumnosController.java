package edu.uni.everis.universidad.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uni.everis.universidad.domain.Alumno;
import edu.uni.everis.universidad.services.AlumnoService;

@RestController
@RequestMapping("/alumnos")
public class AlumnosController {

	private AlumnoService service;

	public AlumnosController(AlumnoService service) {
		this.service = service;
	}

	@GetMapping
	public List<Alumno> findAll() {
		return service.findAll();
	}

	@GetMapping("/{dni}")
	public Alumno findById(@PathVariable String dni) {
		return service.findById(dni);
	}

	@PostMapping
	public Alumno create(@RequestBody Alumno alumno) {
		return service.create(alumno);
	}

	@DeleteMapping("/{dni}")
	public Alumno delete(@PathVariable String dni) {
		return service.delete(dni);
	}
	
	@PutMapping("/{dni}")
	public Alumno update(@PathVariable String dni, @RequestBody Alumno alumnoDto) {
		return service.update(dni, alumnoDto);
	}
	
	
	
	
	
	
	
	
	
	
	

}
