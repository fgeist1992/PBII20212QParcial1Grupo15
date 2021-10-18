package ar.edu.unlam.pb2.gimnasio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MusculacionTest {

	private Profesor profesor;
	private Alumno alumnoUno;
	private Alumno alumnoDos;
	private Alumno alumnoTres;
	private Alumno alumnoCuatro;
	
	private Musculacion claseDeMusculacion;
	
	@Before
	public void inicializarTests() {
		profesor = new Profesor("Martin", "Fernandez", 10000000, Genero.MASCULINO, TipoClase.ZUMBA);
		alumnoUno = new Alumno("Manuel", "Fernandez", 10000000, Genero.MASCULINO, Abono.BRONCE);
		alumnoDos = new Alumno("Erica", "Fernandez", 10000000, Genero.FEMENINO, Abono.PLATA);
		alumnoTres = new Alumno("Juan", "Fernandez", 10000000, Genero.FEMENINO, Abono.ORO);		
		alumnoCuatro = new Alumno("Titi", "Fernandez", 10000000, Genero.MASCULINO, Abono.NINGUNO);
	}
	
	@Test
	public void queSePuedaCrearUnaClaseDeZumba() {
		claseDeMusculacion = new Musculacion(Salon.B, profesor);
		
		assertNotNull(claseDeMusculacion);
	}
	
	@Test
	public void queSePuedaAgregarUnAlumno() {
		claseDeMusculacion = new Musculacion(Salon.B, profesor);
		Integer valorEsperado = 1;
		Integer valorObtenido;
		
		claseDeMusculacion.agregarAlumnos(alumnoUno);
		
		valorObtenido = claseDeMusculacion.getCantidadAlumnos();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaAgregarVariosAlumnos() {
		claseDeMusculacion = new Musculacion(Salon.B, profesor);
		Integer valorEsperado = 3; // El cuarto no se agrega porque no tiene abono
		Integer valorObtenido;
		
		claseDeMusculacion.agregarAlumnos(alumnoUno);
		claseDeMusculacion.agregarAlumnos(alumnoDos);
		claseDeMusculacion.agregarAlumnos(alumnoTres);
		claseDeMusculacion.agregarAlumnos(alumnoCuatro);
		
		valorObtenido = claseDeMusculacion.getCantidadAlumnos();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaSortearUnMesGratisEntreLosAlumnos() {
		claseDeMusculacion = new Musculacion(Salon.B, profesor);
		Double valorEsperado = 0.0; // Que se le devuelva el importe pagado
		Double valorObtenido;
		
		claseDeMusculacion.agregarAlumnos(alumnoUno);
		
		// Como hay un unico alumno inscripto al realizar el sorteo el es el ganador siempre
		Alumno ganadorSorteo = claseDeMusculacion.sortearMesGratis();
		
		valorObtenido = ganadorSorteo.getSaldo();
		
		assertEquals(valorEsperado, valorObtenido);
	}


}
