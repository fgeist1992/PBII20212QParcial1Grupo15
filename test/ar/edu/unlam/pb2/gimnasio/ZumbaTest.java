package ar.edu.unlam.pb2.gimnasio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ZumbaTest {

	private Profesor profesor;
	private Profesor profesorInvitado;
	private Alumno alumnoUno;
	private Alumno alumnoDos;
	private Alumno alumnoTres;
	private Alumno alumnoCuatro;
	
	private Zumba claseDeZumba;
	private Integer licenciaZumba; 
	
	@Before
	public void inicializarTests() {
		profesor = new Profesor("Martin", "Fernandez", 10000000, Genero.MASCULINO, TipoClase.ZUMBA);
		profesorInvitado = new Profesor("Daniela", "Fernandez", 10000000, Genero.FEMENINO, TipoClase.ZUMBA);
		licenciaZumba = 111111111;
		alumnoUno = new Alumno("Manuel", "Fernandez", 10000000, Genero.MASCULINO, Abono.BRONCE);
		alumnoDos = new Alumno("Erica", "Fernandez", 10000000, Genero.FEMENINO, Abono.PLATA);
		alumnoTres = new Alumno("Juan", "Fernandez", 10000000, Genero.FEMENINO, Abono.ORO);		
		alumnoCuatro = new Alumno("Titi", "Fernandez", 10000000, Genero.MASCULINO, Abono.NINGUNO);
	}
	
	@Test
	public void queSePuedaCrearUnaClaseDeZumba() {
		claseDeZumba = new Zumba(Salon.B, profesor, licenciaZumba);
		
		assertNotNull(claseDeZumba);
	}
	
	@Test 
	public void queSePuedaAgregarUnProfesorInvitado() {
		claseDeZumba = new Zumba(Salon.B, profesor, licenciaZumba);
		Profesor valorEsperado = profesorInvitado;
		Profesor valorObtenido;
		
		claseDeZumba.setProfesorInvitado(profesorInvitado);
		
		valorObtenido = claseDeZumba.getProfesorInvitado();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaAgregarUnAlumno() {
		claseDeZumba = new Zumba(Salon.B, profesor, licenciaZumba);
		Integer valorEsperado = 1;
		Integer valorObtenido;
		
		claseDeZumba.agregarAlumnos(alumnoUno);
		
		valorObtenido = claseDeZumba.getCantidadAlumnos();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaAgregarVariosAlumnos() {
		claseDeZumba = new Zumba(Salon.B, profesor, licenciaZumba);
		Integer valorEsperado = 3;
		Integer valorObtenido;
		
		claseDeZumba.agregarAlumnos(alumnoUno);
		claseDeZumba.agregarAlumnos(alumnoDos);
		claseDeZumba.agregarAlumnos(alumnoTres);
		claseDeZumba.agregarAlumnos(alumnoCuatro);
		
		valorObtenido = claseDeZumba.getCantidadAlumnos();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queNoSePuedaAgregarAlumnosSiLaClaseEstaLlena() {
		claseDeZumba = new Zumba(Salon.B, profesor, licenciaZumba);
		Integer valorEsperado = 20;
		Integer valorObtenido;
		
		// Si le intento agregar 25 alumnos, sólo debería sumar los primeros 20 a la clase
		// Se prueba con el alumnoTres, poque tiene abono oro y no tiene límite de clases
		for (int i = 0; i < 25; i++) {
			claseDeZumba.agregarAlumnos(alumnoTres);
		}

		valorObtenido = claseDeZumba.getCantidadAlumnos();

		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSeDepositeLaComisionEnElProfesorEncargadoDeLaClase() {
		claseDeZumba = new Zumba(Salon.B, profesor, licenciaZumba);
		Double valorEsperado = 200.0 * 3.0; // Se supone que hay 3 alumnos inscriptos. El cuarto no tiene abono
		Double valorObtenido;
		
		claseDeZumba.agregarAlumnos(alumnoUno);
		claseDeZumba.agregarAlumnos(alumnoDos);
		claseDeZumba.agregarAlumnos(alumnoTres);
		claseDeZumba.agregarAlumnos(alumnoCuatro);
		claseDeZumba.comisionar();
		
		valorObtenido = profesor.getImporteADepositar();

		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSeDepositeLaComisionEnElProfesorEncargadoDeLaClaseYEnElProfesorInvitado() {
		claseDeZumba = new Zumba(Salon.B, profesor, licenciaZumba);
		Double valorEsperadoProfesor = 200.0 * 3.0; // Se supone que hay 3 alumnos inscriptos. El cuarto no tiene abono
		Double valorObtenidoProfesor;
		Double valorEsperadoProfesorInvitado = 200.0 * 3.0 * 0.1; // El invitado se lleva un 10%
		Double valorObtenidoProfesorInvitado;
		
		claseDeZumba.setProfesorInvitado(profesorInvitado);
		claseDeZumba.agregarAlumnos(alumnoUno);
		claseDeZumba.agregarAlumnos(alumnoDos);
		claseDeZumba.agregarAlumnos(alumnoTres);
		claseDeZumba.agregarAlumnos(alumnoCuatro);
		claseDeZumba.comisionar();
		
		valorObtenidoProfesor = profesor.getImporteADepositar();
		valorObtenidoProfesorInvitado = profesorInvitado.getImporteADepositar();

		assertEquals(valorEsperadoProfesor, valorObtenidoProfesor);
		assertEquals(valorEsperadoProfesorInvitado, valorObtenidoProfesorInvitado);
	}
	

}
