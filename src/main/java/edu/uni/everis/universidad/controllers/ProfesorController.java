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

import edu.uni.everis.universidad.domain.Profesor;
import edu.uni.everis.universidad.services.ProfesorService;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

	private ProfesorService service;

	public ProfesorController(ProfesorService service) {
		this.service = service;
	}

	@GetMapping
	public List<Profesor> findAll() {
		return service.findAll();
	}

	@GetMapping("/{dni}")
	public Profesor findById(@PathVariable String dni) {
		return service.findById(dni);
	}

	@PostMapping
	public Profesor create(@RequestBody Profesor alumno) {
		return service.create(alumno);
	}

	@DeleteMapping("/{dni}")
	public Profesor delete(@PathVariable String dni) {
		return service.delete(dni);
	}
	
	@PutMapping("/{dni}")
	public Profesor update(@PathVariable String dni, @RequestBody Profesor alumnoDto) {
		return service.update(dni, alumnoDto);
	}
	
	
	
	
	
	
	
	
	
	
	

}
