package ar.edu.unlam.pb2.gimnasio;

public abstract class Persona {
	private String nombre;
	private String apellido;
	private Integer dni;
	private Genero genero;
	

	public Persona(String nombre, String apellido, Integer dni, Genero genero) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.genero = genero;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Genero getGenero() {
		return genero;
	}
	
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
}
