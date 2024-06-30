package frgp.utn.edu.ar.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Turno;

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

}
