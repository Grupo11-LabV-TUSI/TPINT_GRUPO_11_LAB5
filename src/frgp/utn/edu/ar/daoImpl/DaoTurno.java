package frgp.utn.edu.ar.daoImpl;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.dao.IDaoTurno;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Turno;

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

}
