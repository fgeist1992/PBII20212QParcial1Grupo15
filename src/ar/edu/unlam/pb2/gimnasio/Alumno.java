package ar.edu.unlam.pb2.gimnasio;

public class Alumno extends Persona{

	private Abono tipoDeAbono;
	private Double saldo=0.0;
	private Integer clasesInscriptas=0;
	private Integer CANTIDAD_CLASE_BRONCE=1;
	private Integer CANTIDAD_CLASE_PLATA=2;
	private Double IMPORTE_ABONO_BRONCE=1000.0;
	private Double IMPORTE_ABONO_PLATA=1800.0;
	private Double IMPORTE_ABONO_ORO=2500.0;
	
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
		/*PARA PODER SUMAR A UN CLASE, DEBEMOS VALIDAR QUE SU ABONO SE LO PERMITA*/
		if(this.validarClase() == true) {
			this.clasesInscriptas++;
		}
	}

	public Boolean validarClase() {
	Boolean validar=false;
	   if(this.tipoDeAbono == Abono.BRONCE && this.clasesInscriptas < this.CANTIDAD_CLASE_BRONCE) {
			validar=true;			
		}else if(this.tipoDeAbono == Abono.PLATA && this.clasesInscriptas < this.CANTIDAD_CLASE_PLATA){
			validar=true;			
		}else if(this.tipoDeAbono == Abono.ORO) {
			validar=true;
		}
	   return validar;		
	}
	
	/*
	 * Se modifica el saldo que se le debe al gimnasio
	 * en funcion del abono contratado
	 */
	public void facturarMes() {
		/*FACTURAMOS, SUMANDO A SU SALDO EL VALOR DEL ABONO CONTRATADO*/
		Double saldo=0.0;
		switch(this.tipoDeAbono) {
		case BRONCE:
			saldo=IMPORTE_ABONO_BRONCE;
			break;
		case PLATA:
			saldo=IMPORTE_ABONO_PLATA;
			break;	
		default:
			saldo=IMPORTE_ABONO_ORO;			
		}
		this.setSaldo(saldo);
	}
}
