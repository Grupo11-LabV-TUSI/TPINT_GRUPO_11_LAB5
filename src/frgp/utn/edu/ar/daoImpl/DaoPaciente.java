package frgp.utn.edu.ar.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.dao.IDaoPaciente;
import frgp.utn.edu.ar.entidad.Paciente;

@Repository
public class DaoPaciente implements IDaoPaciente {

	private Conexion conexion;

	public DaoPaciente() {
	}

	public DaoPaciente(Conexion conexion) {
		this.conexion = conexion;
	}

	@Override
	public boolean add(Paciente paciente) {
		boolean estado = true;
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		try {
			// Guardar el objeto
			session.save(paciente);
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
	public Paciente readOne(int dniPaciente) {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		Paciente paciente = (Paciente) session.get(Paciente.class, dniPaciente);
		paciente.toString();
		tx = session.getTransaction();
		tx.commit();
		session.close();
		return paciente;
	}

	@Override
	public boolean exist(int dniPaciente) {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		Paciente paciente = (Paciente) session.get(Paciente.class, dniPaciente);
		boolean existe = paciente != null;
		tx = session.getTransaction();
		tx.commit();
		session.close();
		return existe;
	}

	@Override
	public boolean update(Paciente paciente) {
		boolean estado = true;
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		try {
			// Actualizar el objeto
			session.update(paciente);
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
	public boolean delete(Paciente paciente) {
		boolean estado = true;
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		try {
			// Borrar el objeto
			session.delete(paciente);
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
	public List<Paciente> readAll() {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		List<Paciente> pacientes = session.createQuery("FROM Paciente").list();
		for (Paciente paciente : pacientes) {
			paciente.toString();
		}
		tx = session.getTransaction();
		tx.commit();
		session.close();
		return pacientes;
	}

	// Agrego los gettes y setters para Spring Core

	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}

}
