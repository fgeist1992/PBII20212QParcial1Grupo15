package ar.edu.unlam.pb2.gimnasio;

public class Profesor extends Persona{
	
	private TipoClase[] especialidades;
	private Integer cantidadEspecialidades=0;
	private Double importeADepositar=0.0;
	public Profesor(String nombre, String apellido, Integer dni, Genero genero, TipoClase especialidad) {
		super(nombre, apellido, dni, genero);
		this.especialidades[cantidadEspecialidades]=especialidad;
		this.cantidadEspecialidades++;
	}
	public TipoClase[] getEspecialidades() {
		return especialidades;
	}
	public void setEspecialidades(TipoClase especialidad) {
		this.especialidades[this.cantidadEspecialidades] = especialidad;
		this.cantidadEspecialidades++;
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
