package ar.edu.unlam.pb2.gimnasio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FuncionalTest {

	private Profesor profesor;
	private Alumno alumnoUno;
	private Alumno alumnoDos;
	private Alumno alumnoTres;
	
	private Funcional claseDeFuncional; 
	
	@Before
	public void inicializarTests() {
		profesor = new Profesor("Martin", "Fernandez", 10000000, Genero.MASCULINO, TipoClase.FUNCIONAL);
		alumnoUno = new Alumno("Manuel", "Fernandez", 10000000, Genero.MASCULINO, Abono.BRONCE);
		alumnoDos = new Alumno("Erica", "Fernandez", 10000000, Genero.FEMENINO, Abono.PLATA);
		alumnoTres = new Alumno("Juan", "Fernandez", 10000000, Genero.FEMENINO, Abono.ORO);		
	}
	
	@Test
	public void queSePuedaCrearUnaClaseFuncional() {
		claseDeFuncional = new Funcional(Salon.B, profesor);
		
		assertNotNull(claseDeFuncional);
	}
	
	@Test
	public void queSePuedaAgregarUnAlumnoAlaClaseFuncional() {
		claseDeFuncional = new Funcional(Salon.B, profesor);
		Integer valorEsperado = 1;
		Integer valorObtenido;
		
		claseDeFuncional.agregarAlumnos(alumnoUno);
		
		valorObtenido = claseDeFuncional.getCantidadAlumnos();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaAgregarVariosAlumnosAlaClaseFuncional() {
		claseDeFuncional = new Funcional(Salon.B, profesor);
		Integer valorEsperado = 3;
		Integer valorObtenido;
		
		claseDeFuncional.agregarAlumnos(alumnoUno);
		claseDeFuncional.agregarAlumnos(alumnoDos);
		claseDeFuncional.agregarAlumnos(alumnoTres);
		
		valorObtenido = claseDeFuncional.getCantidadAlumnos();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSeDepositeLaComisionEnElProfesorEncargadoDeLaClaseFuncional() {
		claseDeFuncional = new Funcional(Salon.B, profesor);
		Double valorEsperado = 300.0 * 3.0;
		Double valorObtenido;
		
		claseDeFuncional.agregarAlumnos(alumnoUno);
		claseDeFuncional.agregarAlumnos(alumnoDos);
		claseDeFuncional.agregarAlumnos(alumnoTres);
		claseDeFuncional.comisionar();
		
		valorObtenido = profesor.getImporteADepositar();

		assertEquals(valorEsperado, valorObtenido);
	}
	
}
