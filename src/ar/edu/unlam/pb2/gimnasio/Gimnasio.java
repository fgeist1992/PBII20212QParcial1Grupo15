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
	private final Integer CAPACIDAD_MAXIMA_DE_ALUMNOS_POR_CLASE = 20;
	
	public Gimnasio(String nombre) {
		this.nombre = nombre;
		this.profesores = new Profesor[CAPACIDAD_MAXIMA_DE_PROFESORES];
		this.alumnos = new Alumno[CAPACIDAD_MAXIMA_DE_ALUMNOS];
		this.clasesDisponibles = new Clase[CANTIDAD_MAXIMA_DE_CLASES];
		this.cantidadDeAlumnos = 0;
		this.cantidadDeProfesores = 0;
		this.cantidadDeClases = 0;
	}
	
	/*
	 * Se agrega un nuevo alumno al gimnasio
	 * SE AGREGA VALIDACION POR DNI UNICO
	 */
	public Boolean agregarAlumno(Alumno nuevoAlumno) {
		Boolean sePudoAgregar = Boolean.FALSE;
		Boolean existe=false;
		for(int i=0;i < this.cantidadDeAlumnos;i++) {
			if(this.alumnos[i].getDni().equals(nuevoAlumno.getDni())) {
				existe=true;
			}
		}
		if(this.cantidadDeAlumnos < CAPACIDAD_MAXIMA_DE_ALUMNOS && existe==false) {
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
		
		if(this.cantidadDeProfesores < CAPACIDAD_MAXIMA_DE_PROFESORES) {
			profesores[cantidadDeProfesores++] = nuevoProfesor;
			sePudoAgregar = Boolean.TRUE;
		}
		
		return sePudoAgregar;
	}
	
	public Integer getCantidadDeAlumnos() {
		return cantidadDeAlumnos;
	}

	public Integer getCantidadDeProfesores() {
		return cantidadDeProfesores;
	}


	public Integer getCantidadDeClases() {
		return cantidadDeClases;
	}

	public void setCantidadDeClases(Integer cantidadDeClases) {
		this.cantidadDeClases = cantidadDeClases;
	}

	/*
	 * Se agrega un nuevo tipo de clase al gimnasio de zumba
	 * - Sólo se podrá agregar si existe un profesor especialista en la disciplina
	 */
	public Boolean agergarClaseZumba(Salon salon, Integer licenciaZumba, Profesor profesorInvitado) {
		Boolean sePudoAgregar = Boolean.FALSE;
		TipoClase tipoDeClase = TipoClase.ZUMBA;
		Profesor profesorACargoDeLaClase = this.buscarEspecialista(tipoDeClase);
		
		Zumba nuevaClaseDeZumba = new Zumba(salon, profesorACargoDeLaClase, licenciaZumba, profesorInvitado);
		
		if(this.cantidadDeClases < CANTIDAD_MAXIMA_DE_CLASES && profesorACargoDeLaClase != null) {
			clasesDisponibles[cantidadDeClases++] = nuevaClaseDeZumba;
			sePudoAgregar = Boolean.TRUE;
		}
		
		return sePudoAgregar;
	}
	
	/*
	 * Se agrega una nueva clase de Musculacion al gimnasio
	 * - Sólo se podrá agregar si existe un profesor especialista en la disciplina
	 */
	public Boolean agergarClaseMusculacion(Salon salon) {
		Boolean sePudoAgregar = Boolean.FALSE;
		TipoClase tipoDeClase = TipoClase.MUSCULACION;
		Profesor profesorACargoDeLaClase = this.buscarEspecialista(tipoDeClase);
		
		Musculacion nuevaClaseDeMusculacion = new Musculacion(salon, profesorACargoDeLaClase);
		
		if(this.cantidadDeClases < CANTIDAD_MAXIMA_DE_CLASES && profesorACargoDeLaClase != null) {
			
			clasesDisponibles[cantidadDeClases++] = nuevaClaseDeMusculacion;

			sePudoAgregar = Boolean.TRUE;
		}
		
		return sePudoAgregar;
	}
	
	/*
	 * Se agrega una nueva clase de Salsa al gimnasio
	 * - Sólo se podrá agregar si existe un profesor especialista en la disciplina
	 */
	public Boolean agergarClaseSalsa(Salon salon) {
		Boolean sePudoAgregar = Boolean.FALSE;
		TipoClase tipoDeClase = TipoClase.SALSA;
		Profesor profesorACargoDeLaClase = this.buscarEspecialista(tipoDeClase);
		
		Salsa nuevaClaseDeSalsa = new Salsa(salon, profesorACargoDeLaClase);
		
		if(this.cantidadDeClases < CANTIDAD_MAXIMA_DE_CLASES && profesorACargoDeLaClase != null) {
			
			clasesDisponibles[cantidadDeClases++] = nuevaClaseDeSalsa;

			sePudoAgregar = Boolean.TRUE;
		}
		
		return sePudoAgregar;
	}
	
	/*
	 * Se agrega una nueva clase de Funcional al gimnasio
	 * - Sólo se podrá agregar si existe un profesor especialista en la disciplina
	 */
	public Boolean agergarClaseFuncional(Salon salon) {
		Boolean sePudoAgregar = Boolean.FALSE;
		TipoClase tipoDeClase = TipoClase.FUNCIONAL;
		Profesor profesorACargoDeLaClase = this.buscarEspecialista(tipoDeClase);
		
		Funcional nuevaClaseDeFuncional = new Funcional(salon, profesorACargoDeLaClase);
		
		if(this.cantidadDeClases < CANTIDAD_MAXIMA_DE_CLASES && profesorACargoDeLaClase != null) {
			
			clasesDisponibles[cantidadDeClases++] = nuevaClaseDeFuncional;

			sePudoAgregar = Boolean.TRUE;
		}
		
		return sePudoAgregar;
	}
	
	/*
	 * Agrega alumnos a una de las clases disponibles
	 * Se pasa por parametro un dni de un alumno valido del gimnasio
	 * Debe tener clases disponibles segun su abono
	 */
	public Boolean agregarAlumno(TipoClase tipoDeClase, Integer dni) {
		Boolean sePudoAgregar = Boolean.FALSE;
		Alumno alumnoAAgregar = this.buscarAlumnoPorDni(dni);
		Clase claseAAgregar = this.buscarUnaClaseActiva(tipoDeClase);
		
		if(alumnoAAgregar != null && claseAAgregar != null && claseAAgregar.getCantidadAlumnos() < CAPACIDAD_MAXIMA_DE_ALUMNOS_POR_CLASE && alumnoAAgregar.validarClase()) {
			claseAAgregar.agregarAlumnos(alumnoAAgregar);
			sePudoAgregar = Boolean.TRUE;
		}
		
		return sePudoAgregar;
	}
	
	/*
	 * Al final del mes se recauda el saldo pendiente de los abonos 
	 * de todos los alumnos.
	 * Luego en la interfaz debería simularse que se reinician las clases
	 * y se volvería a registrar a los alumnos con el abono que seleccionen
	 */
	public void obtenerRecaudacion() {
		Double recaudacion = 0.0;
		
		for (int i = 0; i < alumnos.length; i++) {
			if(this.alumnos[i] != null) {
				this.alumnos[i].facturarMes();
				recaudacion += this.alumnos[i].getSaldo();
				this.alumnos[i].setSaldo(0.0); // Para que no se pueda volver a obtener la recuadacion erroneamente
			}
		}
		
		this.recaudacionActual = recaudacion;
	}
	
	/*
	 * Luego de obtener la recaudacion se liquidan las comisiones a los profesores
	 * y se actualiza el saldo del gimnasio
	 */
	public void pagarALosProfesores() {
		Double importeADescontar = 0.0;
		// Primero se obtiene la recaudacion total
		this.obtenerRecaudacion();
		
		for (int i = 0; i < this.clasesDisponibles.length; i++) {
			if(this.clasesDisponibles[i] != null) {
				importeADescontar += clasesDisponibles[i].comisionar();
			}
		}
		
		this.recaudacionActual -= importeADescontar;
	}
	
	/*
	 * Busca un profesor en una especialidad para asignarlo a una clase
	 * Quedo public por los test, en realidad tal vez seria mejor que sea private el metodo
	 */
	public Profesor buscarEspecialista(TipoClase tipoDeClase) {
		Profesor especialista = null;
		Boolean seEncontro = Boolean.FALSE;
		
		for (int i = 0; i < profesores.length; i++) {
			if(this.profesores[i] != null && this.profesores[i].yaEsEspecialista(tipoDeClase) && !seEncontro) {
				especialista = this.profesores[i];
				seEncontro = Boolean.TRUE;
			}
		} 
		
		return especialista;
	}
	
	/*
	 * Busca a un alumno registrado en el gimnasio por su dni
	 * Se considera como identificador unico el dni, no existen 2 alumnos con igual dni
	 * Igual al anterior se dejo public
	 */
	public Alumno buscarAlumnoPorDni(Integer dni) {
		Alumno alumnoABuscar = null;
		
		for (int i = 0; i < alumnos.length; i++) {
			if(this.alumnos[i] != null && this.alumnos[i].getDni().equals(dni)) {
				alumnoABuscar = this.alumnos[i];
			}
		}
		
		return alumnoABuscar;
	}
	
	/*
	 * Busca dentro de las clases disponibles en el gimnasio 
	 * si hay alguna clase disponible
	 * Va a ir llenando primero las últimas clases creadas
	 * Igual que en las anteriores se dejo public
	 */
	public Clase buscarUnaClaseActiva(TipoClase tipoDeClase) {
		Clase claseABuscar = null;
	
		for (int i = 0; i < clasesDisponibles.length; i++) {
			if(this.clasesDisponibles[i] != null && this.clasesDisponibles[i].getTipoClase() == tipoDeClase) {
				claseABuscar = this.clasesDisponibles[i];
			}
		}
		
		return claseABuscar;
	}
	
	public Double getRecaudacionActual() {
		return recaudacionActual;
	}
	
}
