package ar.edu.unlam.pb2.gimnasio;

public abstract class Clase implements Comisionable{
	private Alumno[] alumnos = new Alumno[20];
	private Profesor profesorEncargado;
	private Double importe;
	private Integer cantidadAlumnos=0;
	private TipoClase tipoClase;
	private Salon salon;

	public Clase(Salon salon, Profesor profesor) {
		this.setProfesorEncargado(profesor);
		this.salon=salon;
	}

	public Profesor getProfesorEncargado() {
		return profesorEncargado;
	}

	public Alumno[] getAlumnos() {
		return alumnos;
	}

	/*
	 * Se agrega un alumno a la clase
	 * No se agrega si llegó al limite de clases según el tipo de abono 
	 */
	public void agregarAlumnos(Alumno alumno) {
		if(this.cantidadAlumnos<alumnos.length) {
			if (alumno.validarClase()) {
				this.alumnos[cantidadAlumnos]=alumno;
				alumno.sumarClase();
				this.cantidadAlumnos++;				
			}
		}
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public TipoClase getTipoClase() {
		return tipoClase;
	}

	public void setTipoClase(TipoClase tipoClase) {
		this.tipoClase = tipoClase;
	}

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

	public void setProfesorEncargado(Profesor profesorEncargado) {
		this.profesorEncargado = profesorEncargado;
	}
	
	public Integer getCantidadAlumnos() {
		return cantidadAlumnos;
	}

}
