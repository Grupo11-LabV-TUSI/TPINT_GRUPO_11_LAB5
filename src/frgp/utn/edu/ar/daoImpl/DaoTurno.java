package frgp.utn.edu.ar.daoImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.dao.IDaoTurno;
import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Horario;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Turno;
import frgp.utn.edu.ar.enums.EDiaHorario;
import frgp.utn.edu.ar.enums.EEstadoTurno;

@Repository
public class DaoTurno implements IDaoTurno {

	private Conexion conexion;

	public DaoTurno(Conexion conexion) {
		this.conexion = conexion;
	}

	public DaoTurno() {
	}

	@Override
	public boolean add(Turno turno) {
		boolean estado = true;
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		try {
			// Guardar el objeto
			session.save(turno);
			//
			tx = session.getTransaction();
			// Confirmar la transacción
			tx.commit();
		} catch (Exception e) {
			estado = false;
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return estado;
	}

	// leer
	@Override
	public Turno leer(Long idTurno) {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		Turno turno = (Turno) session.get(Turno.class, idTurno);
		// Sortear LZY en Medico.turnos
		turno.getMedico().getTurnos().size();
		tx = session.getTransaction();
		tx.commit();
		session.close();
		return turno;
	}

	// existe
	@Override
	public boolean existe(Long idTurno) {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		Turno turno = (Turno) session.get(Turno.class, idTurno);
		boolean existe = turno != null;
		tx = session.getTransaction();
		tx.commit();
		session.close();
		return existe;
	}

	// actualizar
	@Override
	public boolean actualizar(Turno turno) {
		boolean estado = true;
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		try {
			// Actualizar el objeto
			session.update(turno);
			//
			tx = session.getTransaction();
			// Confirmar la transacción
			tx.commit();
		} catch (Exception e) {
			estado = false;
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return estado;
	}

	// borrar
	@Override
	public boolean borrar(Turno turno) { // Este turno tiene que venir cargado el id de turno que se quiere eliminar
		boolean estado = true;
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		try {
			// Borrar el objeto
			session.delete(turno);
			//
			tx = session.getTransaction();
			// Confirmar la transacción
			tx.commit();
		} catch (Exception e) {
			estado = false;
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return estado;
	}

	// listar
	@Override
	public List<Turno> leerTodos() {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		List<Turno> lista = session.getNamedQuery("findAllTurnos").list();
		// Sortear LZY en Medico.turnos
		for (Turno turno : lista) {
			turno.getMedico().getTurnos().size();
		}
		tx = session.getTransaction();
		tx.commit();
		session.close();
		return lista;
	}

	@Override
	public long contarTurnosPresenteEntreFechas(Date startDate, Date endDate) {

		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();

		String hql = "SELECT COUNT(*) FROM Turno WHERE estado = 'Presente' AND fecha BETWEEN :startDate AND :endDate";
		Query query = session.createQuery(hql);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		long count = (Long) query.uniqueResult();

		tx = session.getTransaction();
		tx.commit();
		session.close();
		return count;
	}

	@Override
	public long contarTurnosAusenteEntreFechas(Date startDate, Date endDate) {

		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();

		String hql = "SELECT COUNT(*) FROM Turno WHERE estado = 'Ausente' AND fecha BETWEEN :startDate AND :endDate";
		Query query = session.createQuery(hql);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		long count = (Long) query.uniqueResult();

		tx = session.getTransaction();
		tx.commit();
		session.close();
		return count;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}

	public Conexion getConexion() {
		return conexion;
	}

	@Override
	public List<Turno> buscarTurnosPorMedico(Medico medico) {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		Query query = session.getNamedQuery("findTurnosByMedico");
		query.setParameter("medico", medico);
		List<Turno> lista = query.list();
		// Sortear LZY en Medico.turnos
		for (Turno turno : lista) {
			turno.getMedico().getTurnos().size();
		}
		tx = session.getTransaction();
		tx.commit();
		session.close();
		return lista;
	}

	@Override
	public List<Turno> buscarTurnosPorFechaHoraYMedico(LocalDate fecha, LocalTime hora, Long medicoId) {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		try {
			Query query = session
					.createQuery("FROM Turno t WHERE t.fecha = :fecha AND t.hora = :hora AND t.medico.id = :medicoId");
			query.setParameter("fecha", fecha);
			query.setParameter("hora", hora);
			query.setParameter("medicoId", medicoId);
			List<Turno> turnos = query.list();
			tx.commit();
			return turnos;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public long contarTurnosEspecialidadEntreFechas(Especialidad especialidad, LocalDate fechaInicio,
			LocalDate fechaFin) {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		try {
			Query query = session.getNamedQuery("contarTurnosPorEspecilidadYFechas");
			query.setParameter("especialidad", especialidad);
			query.setParameter("fi", fechaInicio);
			query.setParameter("ff", fechaFin);
			Long cantTurnos = (Long) query.uniqueResult();
			tx.commit();
			return cantTurnos;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return -1;
		} finally {
			session.close();
		}
	}

	@Override
	public long contarTurnosMedicoFechaEstado(Medico medico, LocalDate fechaInicio, LocalDate fechaFin, EEstadoTurno estadoTurno) {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		try {
			Query query = session.getNamedQuery("contarTurnosPorMedicoYFechaYEstado");
			query.setParameter("medico", medico);
			query.setParameter("fi", fechaInicio);
			query.setParameter("ff", fechaFin);
			query.setParameter("estadoTurno", estadoTurno);
			Long cantTurnos = (Long) query.uniqueResult();
			tx.commit();
			return cantTurnos;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return -1;
		} finally {
			session.close();
		}
	}
	
	@Override
	public List<LocalTime> buscarHorasDeTurnosPorFechaYMedico(LocalDate fecha, Long medicoId) {
	    Session session = conexion.abrirConexion();
	    Transaction tx = null;
	    List<LocalTime> horas = new ArrayList<>();
	    try {
	        tx = session.beginTransaction();
	        Query query = session.createQuery("SELECT t.hora FROM Turno t WHERE t.fecha = :fecha AND t.medico.id = :medicoId");
	        query.setParameter("fecha", fecha);
	        query.setParameter("medicoId", medicoId);
	        horas = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) tx.rollback();
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return horas;
	}
	
	
	@Override
	public List<Horario> buscarHorarioPorMedicoYDia(Long medicoId, EDiaHorario dia) {
	    Session session = conexion.abrirConexion();
	    Transaction tx = null;
	    List<Horario> horarios = new ArrayList<>();
	    try {
	        tx = session.beginTransaction();
	        String hql = "SELECT h FROM Horario h JOIN h.medicos m WHERE m.matricula = :medicoId AND h.dia = :dia";
	        Query query = session.createQuery(hql);
	        query.setParameter("medicoId", medicoId);
	        query.setParameter("dia", dia);
	        horarios = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) tx.rollback();
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return horarios;
	}

}
