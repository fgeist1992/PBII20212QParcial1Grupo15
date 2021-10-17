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

}
