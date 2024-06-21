package frgp.utn.edu.ar.daoImpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.dao.IDaoHorario;
import frgp.utn.edu.ar.entidad.Horario;

@Repository
public class DaoHorario implements IDaoHorario {

    private Conexion conexion;

    public DaoHorario() {}

    public DaoHorario(Conexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public boolean add(Horario horario) {
    	boolean estado = true;
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
        try {
        	// Guardar el objeto
            session.save(horario);
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
    public Horario readOne(int idHorario) {
    	Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
        Horario horario = (Horario) session.get(Horario.class, idHorario);
        tx = session.getTransaction();
		tx.commit();
		session.close();
        return horario;
    }

    @Override
    public boolean exist(int idHorario) {
    	Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
        Horario horario = (Horario) session.get(Horario.class, idHorario);
        boolean exists = (horario != null);
        tx = session.getTransaction();
		tx.commit();
		session.close();
        return exists;
    }

    @Override
    public boolean update(Horario horario) {
    	boolean estado = true;
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
        try {
        	// Actualizar el objeto
            session.update(horario);
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
    public boolean delete(Horario horario) {
    	boolean estado = true;
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
        try {
        	// Borrar el objeto
            session.delete(horario);
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
    public List<Horario> readAll() {
    	Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
        List<Horario> horarios = session.createQuery("FROM Horario").list();
        tx = session.getTransaction();
		tx.commit();
		session.close();
        return horarios;
    }

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }
}
