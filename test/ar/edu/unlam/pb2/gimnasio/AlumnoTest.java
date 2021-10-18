package ar.edu.unlam.pb2.gimnasio;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlumnoTest {

	@Test
	public void queSePuedanCrearUnAlumnoYSusAtributos() {
		Alumno alumno = new Alumno("Martin", "Fernandez", 10000000, Genero.MASCULINO, Abono.BRONCE);
		
		assertNotNull(alumno);
	}
	
	@Test 
	public void queSePuedaCambiarElTipoDeAbono() {
		Alumno alumno = new Alumno("Martin", "Fernandez", 10000000, Genero.MASCULINO, Abono.BRONCE);
		Abono valorEsperado = Abono.ORO;
		Abono valorObtenido;
		
		alumno.setTipoDeAbono(Abono.ORO);
		
		valorObtenido = alumno.getTipoDeAbono();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test 
	public void queSePuedaCambiarElSaldo() {
		Alumno alumno = new Alumno("Martin", "Fernandez", 10000000, Genero.MASCULINO, Abono.BRONCE);
		Double valorEsperado = 1000.0;
		Double valorObtenido;
		
		alumno.setSaldo(1000.0);
		
		valorObtenido = alumno.getSaldo();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test 
	public void queSeSumarUnaClase() {
		Alumno alumno = new Alumno("Martin", "Fernandez", 10000000, Genero.MASCULINO, Abono.BRONCE);
		Integer valorEsperado = 1;
		Integer valorObtenido;
		
		alumno.sumarClase();
		
		valorObtenido = alumno.getClasesInscriptas();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test 
	public void siTieneAbonoBronceQueSoloPuedaSumarUnaClase() {
		Alumno alumno = new Alumno("Martin", "Fernandez", 10000000, Genero.MASCULINO, Abono.BRONCE);
		Integer valorEsperado = 1;
		Integer valorObtenido;
		
		alumno.sumarClase();
		alumno.sumarClase();
		alumno.sumarClase();
		
		valorObtenido = alumno.getClasesInscriptas();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test 
	public void siTieneAbonoPlataQueSoloPuedaSumarDosClases() {
		Alumno alumno = new Alumno("Martin", "Fernandez", 10000000, Genero.MASCULINO, Abono.PLATA);
		Integer valorEsperado = 2;
		Integer valorObtenido;
		
		alumno.sumarClase();
		alumno.sumarClase();
		alumno.sumarClase();
		
		valorObtenido = alumno.getClasesInscriptas();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test 
	public void siTieneAbonoOroQueSoloPuedaSumarMasDeDosClases() {
		Alumno alumno = new Alumno("Martin", "Fernandez", 10000000, Genero.MASCULINO, Abono.ORO);
		Integer valorEsperado = 7;
		Integer valorObtenido;
		
		alumno.sumarClase();
		alumno.sumarClase();
		alumno.sumarClase();
		alumno.sumarClase();
		alumno.sumarClase();
		alumno.sumarClase();
		alumno.sumarClase();
		
		valorObtenido = alumno.getClasesInscriptas();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test 
	public void siSeSacaAbonoBronceQuedePendienteElSaldoDeBronce() {
		Alumno alumno = new Alumno("Martin", "Fernandez", 10000000, Genero.MASCULINO, Abono.BRONCE);
		Double IMPORTE_ABONO_BRONCE=1000.0;
		Double valorObtenido;
		
		alumno.facturarMes();
		
		valorObtenido = alumno.getSaldo();
		
		assertEquals(IMPORTE_ABONO_BRONCE, valorObtenido);
	}
	
	@Test 
	public void siSeSacaAbonoPlataQuedePendienteElSaldoDePlata() {
		Alumno alumno = new Alumno("Martin", "Fernandez", 10000000, Genero.MASCULINO, Abono.PLATA);
		Double IMPORTE_ABONO_PLATA=1800.0;
		Double valorObtenido;
		
		alumno.facturarMes();
		
		valorObtenido = alumno.getSaldo();
		
		assertEquals(IMPORTE_ABONO_PLATA, valorObtenido);
	}
	
	@Test 
	public void siSeSacaAbonoOroQuedePendienteElSaldoDeOro() {
		Alumno alumno = new Alumno("Martin", "Fernandez", 10000000, Genero.MASCULINO, Abono.ORO);
		Double IMPORTE_ABONO_ORO=2500.0;
		Double valorObtenido;
		
		alumno.facturarMes();
		
		valorObtenido = alumno.getSaldo();
		
		assertEquals(IMPORTE_ABONO_ORO, valorObtenido);
	}
	
	@Test 
	public void siSeCreaAlumnoConDatosErroneosSeCorrige() {
		Alumno alumno = new Alumno("Martin", "Fernandez", 10000000, Genero.MASCULINO, Abono.ORO);
		String valorEsperadoNombre = "Martino";
		String valorEsperadoApellido = "Fernandes";
		Integer valorEsperadoDNI = 10000001;
		Genero valorEsperadoGenero = Genero.INDEFINIDO;
		
		alumno.setNombre("Martino");
		alumno.setApellido("Fernandes");
		alumno.setDni(10000001);
		alumno.setGenero(Genero.INDEFINIDO);
		
		String valorObtenidoNombre = "Martino";
		String valorObtenidoApellido = "Fernandes";
		Integer valorObtenidoDNI = 10000001;
		Genero valorObtenidoGenero = Genero.INDEFINIDO;


		assertEquals(valorEsperadoNombre, valorObtenidoNombre);
		assertEquals(valorEsperadoApellido, valorObtenidoApellido);
		assertEquals(valorEsperadoDNI, valorObtenidoDNI);
		assertEquals(valorEsperadoGenero, valorObtenidoGenero);
	}
	
	@Test 
	public void queSePuedaConsultarLosDatosDelAlumno() {
		Alumno alumno = new Alumno("Martin", "Fernandez", 10000000, Genero.MASCULINO, Abono.ORO);
		String valorEsperadoNombre = "Martin";
		String valorEsperadoApellido = "Fernandez";
		Integer valorEsperadoDNI = 10000000;
		Genero valorEsperadoGenero = Genero.MASCULINO;
				
		String valorObtenidoNombre = alumno.getNombre();
		String valorObtenidoApellido = alumno.getApellido();
		Integer valorObtenidoDNI = alumno.getDni();
		Genero valorObtenidoGenero = alumno.getGenero();


		assertEquals(valorEsperadoNombre, valorObtenidoNombre);
		assertEquals(valorEsperadoApellido, valorObtenidoApellido);
		assertEquals(valorEsperadoDNI, valorObtenidoDNI);
		assertEquals(valorEsperadoGenero, valorObtenidoGenero);
	}

}
