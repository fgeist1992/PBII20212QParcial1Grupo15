package ar.edu.unlam.pb2.gimnasio;

public class Musculacion extends Clase {

	private final Double COMISION_POR_ALUMNO = 150.0;
	
	public Musculacion(Salon salon, Profesor profesor) {
		super(salon, profesor);
		this.setTipoClase(TipoClase.MUSCULACION);
	}
	
	/*
	 * Se sortea un mes gratis entre todos los alumnos
	 * El que gana se le devuelve el importe del abono que pago
	 * Porque para estar inscripto en la clase debio pagar un 
	 * abono previamente
	 */
	public Alumno sortearMesGratis() {
		Alumno ganador=null;
		Alumno [] alumnosClase= this.getAlumnos();
		Integer cantidadDeAlumnos=this.getCantidadAlumnos();
		Integer rango = cantidadDeAlumnos;
		
		int posicion = (int)(Math.random() * rango);
		ganador=alumnosClase[posicion];
		
		// Se le devuelve el importe del abono. Queda con saldo 0 de deuda al 
		// gimnasio
		ganador.setSaldo(0.0);


		return ganador;
	}
	
	@Override
	public Double comisionar() {
		Integer cantidadAlumnos= this.getCantidadAlumnos();
		Double importePagadoAProfesor = cantidadAlumnos * COMISION_POR_ALUMNO;
		this.getProfesorEncargado().setImporteADepositar(importePagadoAProfesor);
		
		return importePagadoAProfesor;
	}


}
