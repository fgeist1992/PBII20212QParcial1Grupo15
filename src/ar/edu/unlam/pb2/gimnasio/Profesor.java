package ar.edu.unlam.pb2.gimnasio;

public class Profesor extends Persona{
	
	private TipoClase[] especialidades;
	private Integer cantidadEspecialidades=0;
	private Double importeADepositar=0.0;
	
	public Profesor(String nombre, String apellido, Integer dni, Genero genero, TipoClase especialidad) {
		super(nombre, apellido, dni, genero);
		this.especialidades = new TipoClase[4]; // Maximo las 4 especialidades
		this.especialidades[cantidadEspecialidades++]=especialidad;
	}
	
	public TipoClase[] getEspecialidades() {
		return especialidades;
	}
	
	/*
	 * Agrega una nueva especialidad al profesor, si todavia no la tiene
	 */
	public void setEspecialidades(TipoClase especialidad) {
		Boolean yaExiste = yaEsEspecialista(especialidad);
		
		if(!yaExiste) {
			this.especialidades[this.cantidadEspecialidades++] = especialidad;			
		}
		
	}

	/*
	 * Determina si ya es especialista en un determinado campo
	 */
	public Boolean yaEsEspecialista(TipoClase especialidad) {
		Boolean yaExiste = Boolean.FALSE;
		
		for (int i = 0; i < especialidades.length; i++) {
			if(this.especialidades[i] != null && especialidad == this.especialidades[i]) {
				yaExiste = Boolean.TRUE;
			}
		}
		return yaExiste;
	}
	
	public int getCantidadEspecialidades() {
		return cantidadEspecialidades;
	}
	
	public Double getImporteADepositar() {
		return importeADepositar;
	}
	
	public void setImporteADepositar(Double importeADepositar) {
		this.importeADepositar = importeADepositar;
	}
	
}
