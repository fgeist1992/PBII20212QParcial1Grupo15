package ar.edu.unlam.pb2.gimnasio;

public class Alumno extends Persona{

	private Abono tipoDeAbono;
	private Double saldo=0.0;
	private Integer clasesInscriptas=0;
	private Integer CANTIDAD_CLASE_BRONCE=1;
	private Integer CANTIDAD_CLASE_PLATA=2;
	public Alumno(String nombre, String apellido, Integer dni, Genero genero, Abono tipoDeAbono) {
		super(nombre, apellido, dni, genero);
		this.tipoDeAbono=tipoDeAbono;
	}

	public Abono getTipoDeAbono() {
		return tipoDeAbono;
	}

	public void setTipoDeAbono(Abono tipoDeAbono) {
		this.tipoDeAbono = tipoDeAbono;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Integer getClasesInscriptas() {
		return clasesInscriptas;
	}
	
	public void sumarClase() {
		if(this.validarClase()) {
			this.clasesInscriptas++;
		}
	}

	private Boolean validarClase() {
	Boolean validar=false;
	   if(this.tipoDeAbono == Abono.BRONCE && this.clasesInscriptas <= this.CANTIDAD_CLASE_BRONCE) {
			validar=true;			
		}else if(this.tipoDeAbono == Abono.PLATA && this.clasesInscriptas <= this.CANTIDAD_CLASE_PLATA){
			validar=true;			
		}else if(this.tipoDeAbono == Abono.ORO) {
			validar=true;
		}
	   return validar;		
	}
	
	

}
