package ar.edu.unlam.pb2.gimnasio;

public class Zumba extends Clase{
	private Integer licenciaZumba;
	
	private Profesor profesorInvitado;
	public Zumba(Salon salon, Profesor profesor, Integer licenciaZumba) {
		super(salon, profesor);
		this.setLicenciaZumba(licenciaZumba);
	}
	
	public void comisionar() {
		Integer cantidadAlumnos= this.getCantidadAlumnos();
		Double importePagadoAProfesor =(double) cantidadAlumnos * 200;
		Double importePagadoAProfesorInvitado=(importePagadoAProfesor*0.1);
		this.getProfesorEncargado().setImporteADepositar(importePagadoAProfesor);
		if(profesorInvitado != null) {
			this.profesorInvitado.setImporteADepositar(importePagadoAProfesorInvitado);
		}		
	}

	public Profesor getProfesorInvitado() {
		return profesorInvitado;
	}

	public void setProfesorInvitado(Profesor profesorInvitado) {
		this.profesorInvitado = profesorInvitado;
	}

	public Integer getLicenciaZumba() {
		return licenciaZumba;
	}

	public void setLicenciaZumba(Integer licenciaZumba) {
		this.licenciaZumba = licenciaZumba;
	}
		
	
}
