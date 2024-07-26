package frgp.utn.edu.ar.negocioImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.dao.IDaoTurno;
import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Horario;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Turno;
import frgp.utn.edu.ar.enums.EDiaHorario;
import frgp.utn.edu.ar.enums.EEstadoTurno;
import frgp.utn.edu.ar.negocio.ITurnoNegocio;

@Service
public class TurnoNegocio implements ITurnoNegocio {

	private IDaoTurno daoTurno;

	public TurnoNegocio() {
	}

	public TurnoNegocio(IDaoTurno daoTurno) {
		this.daoTurno = daoTurno;
	}

	public IDaoTurno getDaoTurno() {
		return daoTurno;
	}

	public void setDaoTurno(IDaoTurno daoTurno) {
		this.daoTurno = daoTurno;
	}

	@Override
	public boolean add(Turno turno) {
		return daoTurno.add(turno);
	}

	@Override
	public Turno leer(Long id) {
		return daoTurno.leer(id);
	}

	@Override
	public boolean existe(Long id) {
		return daoTurno.existe(id);
	}

	@Override
	public boolean actualizar(Turno turno) {
		return daoTurno.actualizar(turno);
	}

	@Override
	public boolean borrar(Turno turno) {
		return daoTurno.borrar(turno);
	}

	@Override
	public List<Turno> leerTodos() {
		return daoTurno.leerTodos();
	}

	@Override
	public long contarTurnosPresenteEntreFechas(Date startDate, Date endDate) {
		return daoTurno.contarTurnosPresenteEntreFechas(startDate, endDate);
	}

	@Override
	public long contarTurnosAusenteEntreFechas(Date startDate, Date endDate) {
		return daoTurno.contarTurnosAusenteEntreFechas(startDate, endDate);
	}

	@Override
	public boolean existeTurno(LocalDate fecha, LocalTime hora, Long medicoId) {
		List<Turno> turnos = daoTurno.buscarTurnosPorFechaHoraYMedico(fecha, hora, medicoId);
		return !turnos.isEmpty();
	}

	@Override
	public List<Turno> buscarTurnosPorMedico(Medico medico) {
		return daoTurno.buscarTurnosPorMedico(medico);
	}

	@Override
	public long contarTurnosEspecialidadEntreFechas(Especialidad especialidad, LocalDate fechaInicio,
			LocalDate fechaFin) {
		return daoTurno.contarTurnosEspecialidadEntreFechas(especialidad, fechaInicio, fechaFin);
	}

	@Override
	public long contarTurnosMedicoFechaEstado(Medico medico, LocalDate fechaInicio, LocalDate fechaFin,
			EEstadoTurno estadoTurno) {
		return daoTurno.contarTurnosMedicoFechaEstado(medico, fechaInicio, fechaFin, estadoTurno);
	}
	
	@Override
	public List<LocalTime> buscarHorasDeTurnosPorFechaYMedico(LocalDate fecha, Long matricula){
		return daoTurno.buscarHorasDeTurnosPorFechaYMedico(fecha, matricula);
	}
	
	@Override
	public List<Horario> buscarHorarioPorMedicoYDia(Long medicoId, EDiaHorario dia){
		return daoTurno.buscarHorarioPorMedicoYDia(medicoId, dia);
	}

}
