package ar.edu.unlam.pb2.gimnasio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class GimnasioTest {
	private Profesor profesor;
	private Profesor profesorInvitado;
	private Alumno alumnoUno;
	private Alumno alumnoDos;
	private Alumno alumnoTres;
	private Alumno alumnoCuatro;
	private Gimnasio gimnasio;
	private Zumba claseDeZumba;
	private Integer licenciaZumba; 
	
	@Before
	public void inicializarTests() {
		gimnasio= new Gimnasio("El Porvenir");
		profesor = new Profesor("Martin", "Fernandez", 10000005, Genero.MASCULINO, TipoClase.ZUMBA);
		profesorInvitado = new Profesor("Daniela", "Fernandez", 10000006, Genero.FEMENINO, TipoClase.ZUMBA);
		licenciaZumba = 111111111;
		alumnoUno = new Alumno("Manuel", "Fernandez", 10000001, Genero.MASCULINO, Abono.BRONCE);
		alumnoDos = new Alumno("Erica", "Fernandez", 10000002, Genero.FEMENINO, Abono.PLATA);
		alumnoTres = new Alumno("Juan", "Fernandez", 10000003, Genero.FEMENINO, Abono.ORO);		
		alumnoCuatro = new Alumno("Titi", "Fernandez", 10000004, Genero.MASCULINO, Abono.NINGUNO);
	}
	@Test
	public void queSePuedaCrearUnGimnasio() {
		assertNotNull(gimnasio);
	}
	@Test
	public void queSePuedaAgergarUnAlumno() {	
		//SI SE EJECUTA DOS VECES EL MIMSO DNI, DA ERROR YA QUE SERA TOMARO COMO UNIQUE EN EL PROCESO
		//gimnasio.agregarAlumno(alumnoUno);
		Boolean valorObtenido = gimnasio.agregarAlumno(alumnoUno);
		Boolean valorEsperado= true;		
		assertEquals(valorEsperado,valorObtenido);
	}
	//COMENTAMOS ESTE TEST, YA QUE SE REALIZO A MODO DE DEBUG, SIN TENER EN CUENTA LA RESTRICCION DEL DNI DEL ALUMNO COMO UNIQUE
	/*@Test
	public void queSePuedanAgergarSoloMilAlumnos() {	
		for(int i=0; i < 1005;i++) {
			gimnasio.agregarAlumno(alumnoUno);
		}
		Integer valorObtenido = gimnasio.getCantidadDeAlumnos();
		Integer valorEsperado= 1000;		
		assertEquals(valorEsperado,valorObtenido);
	}	*/
	@Test
	public void queSePuedanAgergarProfesoresYsoloDiez() {
		for(int i=0; i < 1005;i++) {
			gimnasio.agregarProfesor(profesor);
		}
		Integer valorObtenido = gimnasio.getCantidadDeProfesores();
		Integer valorEsperado= 10;		
		assertEquals(valorEsperado,valorObtenido);
	}
	@Test
	public void queSePuedanAgergarUnaClaseDeZumba() {	
		gimnasio.agregarProfesor(profesor);//Sin profesor retorna FALSE; ya que en el gimansio no hay un profesor que sea instructor de zuma
		Boolean valorObtenido = gimnasio.agergarClaseZumba(Salon.A, licenciaZumba);
		Boolean valorEsperado= true;		
		assertEquals(valorEsperado,valorObtenido);
	}
	@Test
	public void queSePuedanAgergarUnaClaseDeMusculacion() {	
		Profesor profesorMusculacion= new Profesor("Arnold","Perez",123456,Genero.MASCULINO, TipoClase.MUSCULACION);
		gimnasio.agregarProfesor(profesorMusculacion);//Sin profesor retorna FALSE; ya que en el gimansio no hay un profesor que sea instructor de zuma
		Boolean valorObtenido = gimnasio.agergarClaseMusculacion(Salon.B);
		Boolean valorEsperado= true;		
		assertEquals(valorEsperado,valorObtenido);
	}
	@Test
	public void queSePuedanAgergarAlumnoAUnaClase() {	
		gimnasio.agregarProfesor(profesor);
		gimnasio.agergarClaseZumba(Salon.A, licenciaZumba);
		gimnasio.agregarAlumno(alumnoUno);//Si no se agrega esta linea, el alumno no puede agregarse a una clase, por no estar en el array alumnos del gimnasio.
		/*SI SE AGREGA EL ALUMNO CUATRO, TAMPOCO SE EJECUTARA, YA QUE NO POSEE ABONO*/
		/*SI INTENTO AGREGAR NUEVAMENTE A ALUMNO UNO, DA ERROR POR LIMITE DE ALCANCE DEL ABONO BRONCE*/
		//gimnasio.agregarAlumno(TipoClase.ZUMBA, 10000001);		
		Boolean valorObtenido = gimnasio.agregarAlumno(TipoClase.ZUMBA, 10000001);
		Boolean valorEsperado= true;		
		assertEquals(valorEsperado,valorObtenido);
	}
	@Test
	public void queLaRecaudacionDelGimnsaioSeaLaSumaDeLosAbonosDeAlumnosInscriptos() {	
		gimnasio.agregarAlumno(alumnoUno);
		gimnasio.agregarAlumno(alumnoDos);
		gimnasio.agregarAlumno(alumnoTres);
		 gimnasio.obtenerRecaudacion();
		Double valorEsperado = 5300.0;
		Double valorObtenido= gimnasio.getRecaudacionActual();		
		assertEquals(valorEsperado,valorObtenido);
	}
	@Test
	public void queLaComisionDelProfesorDeMusculacionSea150PorAlumno() {	
		gimnasio.agregarAlumno(alumnoUno);
		gimnasio.agregarAlumno(alumnoDos);
		gimnasio.agregarAlumno(alumnoTres);
		Profesor profesorMusculacion= new Profesor("Arnold","Perez",123456,Genero.MASCULINO, TipoClase.MUSCULACION);
		gimnasio.agregarProfesor(profesorMusculacion);
		gimnasio.agregarProfesor(profesor);
		gimnasio.agergarClaseMusculacion(Salon.C);
		gimnasio.agergarClaseZumba(Salon.A,121321213);
		gimnasio.agregarAlumno(TipoClase.MUSCULACION, 10000001);
		gimnasio.agregarAlumno(TipoClase.MUSCULACION, 10000002);
		gimnasio.agregarAlumno(TipoClase.MUSCULACION, 10000003);	
		gimnasio.agregarAlumno(TipoClase.ZUMBA, 10000002);
		gimnasio.obtenerRecaudacion();
		gimnasio.pagarALosProfesores();
		Double valorEsperado=450.0;		
		Double valorObtenido = profesorMusculacion.getImporteADepositar();
		assertEquals(valorEsperado,valorObtenido);
	}
	@Test
	public void queEnLaMismaSituacionDeArribaLaComisionDelProfesorDeZumbaSea200PorAlumno() {	
		gimnasio.agregarAlumno(alumnoUno);
		gimnasio.agregarAlumno(alumnoDos);
		gimnasio.agregarAlumno(alumnoTres);
		Profesor profesorMusculacion= new Profesor("Arnold","Perez",123456,Genero.MASCULINO, TipoClase.MUSCULACION);
		gimnasio.agregarProfesor(profesorMusculacion);
		gimnasio.agregarProfesor(profesor);
		gimnasio.agergarClaseMusculacion(Salon.C);
		gimnasio.agergarClaseZumba(Salon.A,121321213);
		gimnasio.agregarAlumno(TipoClase.MUSCULACION, 10000001);
		gimnasio.agregarAlumno(TipoClase.MUSCULACION, 10000002);
		gimnasio.agregarAlumno(TipoClase.MUSCULACION, 10000003);	
		gimnasio.agregarAlumno(TipoClase.ZUMBA, 10000002);
		gimnasio.obtenerRecaudacion();
		gimnasio.pagarALosProfesores();
		Double valorEsperado=200.0;		
		Double valorObtenido = profesor.getImporteADepositar();
		assertEquals(valorEsperado,valorObtenido);
	}
	
}
