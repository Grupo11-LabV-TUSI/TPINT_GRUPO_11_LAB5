package frgp.utn.edu.ar.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Horario;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Turno;
import frgp.utn.edu.ar.enums.EDiaHorario;
import frgp.utn.edu.ar.enums.EEstadoTurno;

public interface IDaoTurno {
	// crear
	public boolean add(Turno turno);

	// leer
	public Turno leer(Long id);

	// existe
	public boolean existe(Long id);

	// actualizar
	public boolean actualizar(Turno turno);

	// borrar
	public boolean borrar(Turno turno);

	// listar
	public List<Turno> leerTodos();

	public long contarTurnosPresenteEntreFechas(Date startDate, Date endDate);

	public long contarTurnosAusenteEntreFechas(Date startDate, Date endDate);

	// listar turnos medico fecha y hora
	public List<Turno> buscarTurnosPorFechaHoraYMedico(LocalDate fecha, LocalTime hora, Long medicoId);

	// listar turnos por medico
	public List<Turno> buscarTurnosPorMedico(Medico medico);

	// listar cuenta turnos por especialidad entre fechas
	public long contarTurnosEspecialidadEntreFechas(Especialidad especialidad, LocalDate fechaInicio,
			LocalDate fechaFin);

	// listar cuenta turnos por medico en fecha mes año y estado
	public long contarTurnosMedicoFechaEstado(Medico medico, LocalDate fechaInicio, LocalDate fechaFin,
			EEstadoTurno estadoTurno);

	
	//Metodos para Cargar Horarios Turnos
	public List<LocalTime> buscarHorasDeTurnosPorFechaYMedico(LocalDate fecha, Long medicoId);

	public List<Horario> buscarHorarioPorMedicoYDia(Long medicoId, EDiaHorario dia);

}
