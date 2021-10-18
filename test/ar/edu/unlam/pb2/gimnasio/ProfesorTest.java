package ar.edu.unlam.pb2.gimnasio;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProfesorTest {

	@Test
	public void queSePuedanCrearUnProfesorYSusAtributos() {
		Profesor profesor = new Profesor("Martin", "Fernandez", 10000000, Genero.MASCULINO, TipoClase.FUNCIONAL);
		
		assertNotNull(profesor);
	}
	
	@Test
	public void queSePuedanAgregarEspecialidades() {
		Profesor profesor = new Profesor("Martin", "Fernandez", 10000000, Genero.MASCULINO, TipoClase.FUNCIONAL);
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido;
		
		profesor.setEspecialidades(TipoClase.MUSCULACION);
		valorObtenido = profesor.yaEsEspecialista(TipoClase.MUSCULACION);
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedanModificarElImporteADepositar() {
		Profesor profesor = new Profesor("Martin", "Fernandez", 10000000, Genero.MASCULINO, TipoClase.FUNCIONAL);
		Double valorEsperado = 1000.0;
		Double valorObtenido;
		
		profesor.setImporteADepositar(1000.0);
		
		valorObtenido = profesor.getImporteADepositar();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedanObtenerCorrectamenteLaCantidadDeEspecialidades() {
		Profesor profesor = new Profesor("Martin", "Fernandez", 10000000, Genero.MASCULINO, TipoClase.FUNCIONAL);
		Integer valorEsperado = 3;
		Integer valorObtenido;
		
		profesor.setEspecialidades(TipoClase.MUSCULACION);
		profesor.setEspecialidades(TipoClase.MUSCULACION);
		profesor.setEspecialidades(TipoClase.MUSCULACION);
		profesor.setEspecialidades(TipoClase.SALSA);
		profesor.setEspecialidades(TipoClase.SALSA);
		profesor.setEspecialidades(TipoClase.SALSA);
		
		valorObtenido = profesor.getCantidadEspecialidades();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedanObtenerLaEspecialidadDelProfesor() {
		Profesor profesor = new Profesor("Martin", "Fernandez", 10000000, Genero.MASCULINO, TipoClase.FUNCIONAL);
		TipoClase valorEsperado = (TipoClase.FUNCIONAL);
		TipoClase[] valorObtenido;
		
		valorObtenido = profesor.getEspecialidades();
		
		assertEquals(valorEsperado, valorObtenido[0]);
	}

}
