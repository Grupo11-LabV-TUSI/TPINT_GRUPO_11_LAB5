package frgp.utn.edu.ar.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.dao.IDaoEspecialidad;
import frgp.utn.edu.ar.entidad.Especialidad;

@Repository
public class DaoEspecialidad implements IDaoEspecialidad {
	private Conexion conexion;

	public DaoEspecialidad() {
	}

	public DaoEspecialidad(Conexion conexion) {
		this.conexion = conexion;
	}
	
	@Override
	public boolean add(Especialidad especialidad) {
		boolean estado = true;
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		try {
			// Guardar el objeto
			session.save(especialidad);
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
	public Especialidad readOne(int idEspecialidad) {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		Especialidad especialidad = (Especialidad) session.get(Especialidad.class, idEspecialidad);
		tx = session.getTransaction();
		tx.commit();
		session.close();
		return especialidad;
	}
	@Override
	public boolean exist(int idEspecialidad) {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		Especialidad especialidad = (Especialidad) session.get(Especialidad.class, idEspecialidad);
		boolean existe = especialidad != null;
		tx = session.getTransaction();
		tx.commit();
		session.close();
		return existe;
	}

	@Override
	public boolean update(Especialidad especialidad) {
		boolean estado = true;
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		try {
			// Actualizar el objeto
			session.update(especialidad);
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
	public boolean delete(Especialidad especialidad) {
		boolean estado = true;
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		try {
			// Borrar el objeto
			session.delete(especialidad);
			//
			tx = session.getTransaction();
			// Confirmar la transacción
			tx.commit();;
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
	public List<Especialidad> readAll() {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		List<Especialidad> especialidades = session.createQuery("FROM Especialidad").list();
		tx = session.getTransaction();
		tx.commit();
		session.close();
		return especialidades;
	}
    public int obtenerCantidadTurnosPorEspecialidadYFechas(int idEspecialidad, String fechaInicio, String fechaFin) {
        Session session = conexion.abrirConexion();
        Transaction tx = session.beginTransaction();
        String hql = "SELECT COUNT(t) FROM Turno t WHERE t.especialidad.especialidad_id = :idEspecialidad " +
                     "AND t.fecha BETWEEN :fechaInicio AND :fechaFin";
        Query query = session.createQuery(hql);
        query.setParameter("idEspecialidad", idEspecialidad);
        query.setParameter("fechaInicio", fechaInicio);
        query.setParameter("fechaFin", fechaFin);
        Long count = (Long) query.uniqueResult();
        tx.commit();
        session.close();
        return count != null ? count.intValue() : 0;
    }
	// Agrego los gettes y setters para Spring Core

	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}
}
