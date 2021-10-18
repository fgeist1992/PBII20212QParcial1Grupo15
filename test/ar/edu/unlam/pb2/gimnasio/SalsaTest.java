package ar.edu.unlam.pb2.gimnasio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SalsaTest {

	private Profesor profesor;
	private Alumno alumnoUno;
	private Alumno alumnoDos;
	private Alumno alumnoTres;
	
	private Salsa claseDeSalsa; 
	
	@Before
	public void inicializarTests() {
		profesor = new Profesor("Martin", "Fernandez", 10000000, Genero.MASCULINO, TipoClase.SALSA);
		alumnoUno = new Alumno("Manuel", "Fernandez", 10000000, Genero.MASCULINO, Abono.BRONCE);
		alumnoDos = new Alumno("Erica", "Fernandez", 10000000, Genero.FEMENINO, Abono.PLATA);
		alumnoTres = new Alumno("Juan", "Fernandez", 10000000, Genero.FEMENINO, Abono.ORO);		
	}
	
	@Test
	public void queSePuedaCrearUnaClaseDeSalsa() {
		claseDeSalsa = new Salsa(Salon.B, profesor);
		
		assertNotNull(claseDeSalsa);
	}
	
	@Test
	public void queSePuedaObtenerElSalonDeSalsa() {
		claseDeSalsa = new Salsa(Salon.B, profesor);
		Salon valorEsperado = Salon.B;
		Salon valorObtenido = claseDeSalsa.getSalon();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaCambiarElSalonDeSalsaPorOtroSalon() {
		claseDeSalsa = new Salsa(Salon.B, profesor);
		claseDeSalsa.setSalon(Salon.C);
		
		Salon valorEsperado = Salon.C;
		Salon valorObtenido = claseDeSalsa.getSalon();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaAgregarUnAlumnoAlaClaseDeSalsa() {
		claseDeSalsa = new Salsa(Salon.B, profesor);
		Integer valorEsperado = 1;
		Integer valorObtenido;
		
		claseDeSalsa.agregarAlumnos(alumnoUno);
		
		valorObtenido = claseDeSalsa.getCantidadAlumnos();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaAgregarVariosAlumnosAlaClaseDeSalsa() {
		claseDeSalsa = new Salsa(Salon.B, profesor);
		Integer valorEsperado = 3;
		Integer valorObtenido;
		
		claseDeSalsa.agregarAlumnos(alumnoUno);
		claseDeSalsa.agregarAlumnos(alumnoDos);
		claseDeSalsa.agregarAlumnos(alumnoTres);
		
		valorObtenido = claseDeSalsa.getCantidadAlumnos();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queNoSeDepositeComisionEnElProfesorEncargadoDeLaClaseSalsaPorqueNoHayComision() {
		claseDeSalsa = new Salsa(Salon.B, profesor);
		Double valorEsperado = 0.0;
		Double valorObtenido;
		
		claseDeSalsa.agregarAlumnos(alumnoUno);
		claseDeSalsa.agregarAlumnos(alumnoDos);
		claseDeSalsa.agregarAlumnos(alumnoTres);
		claseDeSalsa.comisionar();
		
		valorObtenido = profesor.getImporteADepositar();

		assertEquals(valorEsperado, valorObtenido);
	}
}
