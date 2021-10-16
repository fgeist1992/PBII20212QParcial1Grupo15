package ar.edu.unlam.pb2.gimnasio;

public class Musculacion extends Clase{

	public Musculacion(Salon salon, Profesor profesor) {
		super(salon, profesor);
	}
	
	public Alumno sortearMesGratis() {
		Alumno ganador=null;
		Alumno [] alumnosClase= this.getAlumnos();
		Integer cantidadDeAlumnos=alumnosClase.length;
		Integer min = 0;
		Integer rango = cantidadDeAlumnos - min + 1;
		do {
			int posicion = (int)(Math.random() * rango) + min;
			if(alumnosClase[posicion].getSaldo() == 0) {
				ganador=alumnosClase[posicion];
			}
		}while(ganador == null);
		return ganador;
	}


}
