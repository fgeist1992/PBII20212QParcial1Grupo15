package ar.edu.unlam.pb2.gimnasio;

public class Funcional extends Clase {

	private final Double COMISION_POR_ALUMNO = 300.0;
	
	public Funcional(Salon salon, Profesor profesor) {
		super(salon, profesor);
		this.setTipoClase(TipoClase.ZUMBA);
	}
	
	@Override
	public Double comisionar() {
		Integer cantidadAlumnos= this.getCantidadAlumnos();
		Double importePagadoAProfesor = cantidadAlumnos * COMISION_POR_ALUMNO;
		this.getProfesorEncargado().setImporteADepositar(importePagadoAProfesor);
		
		return importePagadoAProfesor;
	}
	
}
