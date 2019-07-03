package edu.uni.everis.universidad;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.uni.everis.universidad.UniversidadApplication;
import edu.uni.everis.universidad.controllers.AlumnosController;
import edu.uni.everis.universidad.domain.Alumno;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UniversidadApplication.class)
public class UniversidadApplicationTests {

	@Autowired
	private AlumnosController controller;

	@Before
	public void setUp() {
		Alumno alumno = new Alumno();
		alumno.setDni("12656566K");
		alumno.setNombre("sajlkdasjklsdakjl");
		alumno.setApellidos("dsajlkdsajkl");
		controller.create(alumno);
		
		alumno = new Alumno();
		alumno.setDni("32656566K");
		alumno.setNombre("erwerewerew");
		alumno.setApellidos("nvnbvbvnb");
		controller.create(alumno);
	}
	
	@After
	public void tearDown() {
		controller.delete("12656566K");
		controller.delete("32656566K");
	}

	@Test
	public void testCrearAlumno() {
		// Arrange
		Alumno alumno = new Alumno();
		alumno.setDni("dasjklioueqiouweiowq");
		alumno.setNombre("sajlkdasjklsdakjl");
		alumno.setApellidos("dsajlkdsajkl");

		// Act
		Alumno resultado = controller.create(alumno);

		// Assert
		assertNotNull("Null no esperado", resultado);
		assertEquals("Dni diferente", alumno.getDni(), resultado.getDni());
	}

	@Test
	public void testBuscarAlumno() {
		// Arrange
		String dni = "12656566K";

		// Act
		Alumno resultado = controller.findById(dni);

		// Assert
		assertNotNull("Null no esperado", resultado);
		assertEquals("Dni diferente", dni, resultado.getDni());
	}
}
