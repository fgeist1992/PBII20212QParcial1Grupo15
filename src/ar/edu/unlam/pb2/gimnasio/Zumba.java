package ar.edu.unlam.pb2.gimnasio;

public class Zumba extends Clase {
	private Integer licenciaZumba;
	
	private Profesor profesorInvitado;
	public Zumba(Salon salon, Profesor profesor, Integer licenciaZumba,Profesor profesorInvitado) {
		super(salon, profesor);
		this.setLicenciaZumba(licenciaZumba);
		this.setTipoClase(TipoClase.ZUMBA);
		this.profesorInvitado=profesorInvitado;
	}
	
	@Override
	public Double comisionar() {
		Integer cantidadAlumnos= this.getCantidadAlumnos();
		Double importePagadoAProfesor =(double) cantidadAlumnos * 200;
		Double importePagadoAProfesorInvitado=0.0;
		this.getProfesorEncargado().setImporteADepositar(importePagadoAProfesor);
		if(profesorInvitado != null) {
			importePagadoAProfesorInvitado=(importePagadoAProfesor*0.1);
			this.profesorInvitado.setImporteADepositar(importePagadoAProfesorInvitado);
		}
		
		return importePagadoAProfesor + importePagadoAProfesorInvitado;
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
