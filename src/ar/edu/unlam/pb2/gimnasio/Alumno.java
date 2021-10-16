package ar.edu.unlam.pb2.gimnasio;

public class Alumno extends Persona{

	private Abono tipoDeAbono;
	
	public Alumno(String nombre, String apellido, Integer dni, Genero genero) {
		super(nombre, apellido, dni, genero);
	}

}
