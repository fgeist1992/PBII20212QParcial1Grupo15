package ar.edu.unlam.pb2.gimnasio;

public class Salsa extends Clase {

	public Salsa(Salon salon, Profesor profesor) {
		super(salon, profesor);
		this.setTipoClase(TipoClase.SALSA);
	}
	
	@Override
	public Double comisionar() {
		// No se comisiona. Se deja vacío por si en un futuro cambia
		return 0.0;
	}


}
