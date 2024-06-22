package frgp.utn.edu.ar.negocioImpl;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.dao.IDaoTurno;
import frgp.utn.edu.ar.entidad.Turno;
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

}