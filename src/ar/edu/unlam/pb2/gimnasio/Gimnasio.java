package ar.edu.unlam.pb2.gimnasio;

/*
 * Representa el establecimiento donde se imparten diferentes tipos
 * de clases a los alumnos.
 * - Se pueden agregar nuevas clases a la lista del gimnasio.
 * - Se agregan profesores a la lista de profesores del gimnasio.
 * - Se registran los alumnos en cada clase.
 * 
 */
public class Gimnasio {
	
	private String nombre;
	private Profesor[] profesores;
	private Alumno[] alumnos;
	private Clase[] clasesDisponibles;
	private Double recaudacionActual;
	
	private Integer cantidadDeAlumnos;
	private Integer cantidadDeProfesores;
	private Integer cantidadDeClases;
	
	private final Integer CAPACIDAD_MAXIMA_DE_ALUMNOS = 1000;
	private final Integer CAPACIDAD_MAXIMA_DE_PROFESORES = 10;
	private final Integer CANTIDAD_MAXIMA_DE_CLASES = 20; // Se toma que cada profesor puede llegar a dictar 2 clases
	
	public Gimnasio(String nombre) {
		this.nombre = nombre;
		this.profesores = new Profesor[CAPACIDAD_MAXIMA_DE_PROFESORES];
		this.alumnos = new Alumno[CAPACIDAD_MAXIMA_DE_ALUMNOS];
		this.clasesDisponibles = new Clase[CANTIDAD_MAXIMA_DE_CLASES];
	}
	
	/*
	 * Se agrega un nuevo alumno al gimnasio
	 */
	public Boolean agregarAlumno(Alumno nuevoAlumno) {
		Boolean sePudoAgregar = Boolean.FALSE;
		
		if(this.cantidadDeAlumnos < CAPACIDAD_MAXIMA_DE_ALUMNOS) {
			alumnos[cantidadDeAlumnos++] = nuevoAlumno;
			sePudoAgregar = Boolean.TRUE;
		}
		
		return sePudoAgregar;
	}
	
	/*
	 * Se agrega un nuevo profesor al gimnasio
	 */
	public Boolean agregarProfesor(Profesor nuevoProfesor) {
		Boolean sePudoAgregar = Boolean.FALSE;
		
		if(this.cantidadDeAlumnos < CAPACIDAD_MAXIMA_DE_PROFESORES) {
			profesores[cantidadDeProfesores++] = nuevoProfesor;
			sePudoAgregar = Boolean.TRUE;
		}
		
		return sePudoAgregar;
	}
	
	/*
	 * Se agrega un nuevo tipo de clase al gimnasio
	 */
	public Boolean agergarClase(Clase nuevaClase) {
		Boolean sePudoAgregar = Boolean.FALSE;
		
		if(this.cantidadDeClases < CANTIDAD_MAXIMA_DE_CLASES) {
			clasesDisponibles[cantidadDeClases++] = nuevaClase;
			sePudoAgregar = Boolean.TRUE;
		}
		
		return sePudoAgregar;
	}
	
	
	/*
	 * Se paga la comision a los profesores
	 */
	public Double comisionarUnaClase(Clase clase) {
		Double recaudacion = 0.0;
		
		// TODO Utilizando la interfaz de facturar
		// clase.comisionar();
		
		return recaudacion;
	}
	
}
