package frgp.utn.edu.ar.daoImpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import frgp.utn.edu.ar.dao.IDaoMedico;
import frgp.utn.edu.ar.entidad.Medico;

public class DaoMedico implements IDaoMedico {

	private Conexion conexion;

	public DaoMedico() {
	}

	public DaoMedico(Conexion conexion) {
		this.conexion = conexion;
	}

	@Override
	public boolean add(Medico medico) {
		boolean estado = true;
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		try {
			// Guardar el objeto
			session.save(medico);
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

	@Override
	public Medico readOne(Long matriculaMedico) {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();;
		Medico medico = (Medico) session.get(Medico.class, matriculaMedico);
		//medico.getHorarios().size();
		medico.getTurnos().size();
		tx = session.getTransaction();
		tx.commit();
		session.close();
		return medico;
	}

	@Override
	public boolean exist(Long matriculaMedico) {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		Medico medico = (Medico) session.get(Medico.class, matriculaMedico);
		tx = session.getTransaction();
		tx.commit();
		session.close();
		return medico != null;
	}

	@Override
	public boolean update(Medico medico) {
		boolean estado = true;
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		try {
			// Actualizar el objeto
			session.update(medico);
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

	@Override
	public boolean delete(Medico medico) {
		boolean estado = true;
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		try {
			// Borrar el objeto
			session.delete(medico);
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

	@Override
	public List<Medico> readAll() {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		List<Medico> medicos = (List<Medico>) session.createQuery("FROM Medico").list();
		// Evadiendo LAZY Turnos 
		for (Medico medico : medicos) {
			//medico.getHorarios().size();
			medico.getTurnos().size();
		}
		tx = session.getTransaction();
		tx.commit();
		session.close();
		return medicos;
	}

	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}
}
