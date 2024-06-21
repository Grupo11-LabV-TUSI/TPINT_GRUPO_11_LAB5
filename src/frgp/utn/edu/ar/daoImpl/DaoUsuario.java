package frgp.utn.edu.ar.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import frgp.utn.edu.ar.dao.IDaoUsuario;
import frgp.utn.edu.ar.entidad.Usuario;

import java.util.List;

@Repository
public class DaoUsuario implements IDaoUsuario {

	private Conexion conexion;

	public DaoUsuario() {
	}

	public DaoUsuario(Conexion conexion) {
		this.conexion = conexion;
	}

	@Override
	public boolean add(Usuario usuario) {
		boolean estado = true;
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		try {
			// Guardar el objeto;
			session.save(usuario);
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
	public Usuario readOne(Long idUsuario) {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		Usuario usuario = (Usuario) session.get(Usuario.class, idUsuario);
		tx = session.getTransaction();
		tx.commit();
		session.close();
		return usuario;
	}

	@Override
	public boolean exist(Long idUsuario) {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		Usuario usuario = (Usuario) session.get(Usuario.class, idUsuario);
		boolean existe = usuario != null;
		tx = session.getTransaction();
		tx.commit();
		session.close();
		return existe;
	}

	@Override
	public boolean update(Usuario usuario) {
		boolean estado = true;
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		try {
			// Actualizar el objeto
			session.update(usuario);
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
	public boolean delete(Usuario usuario) {
		boolean estado = true;
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		try {
			// Borrar el objeto
			session.delete(usuario);
			//
			tx = session.getTransaction();
			// Confirmar la transacción
			tx.commit();
		} catch (Exception e) {
			estado = false;
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return estado;
	}

	@Override
	public List<Usuario> readAll() {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		List<Usuario> usuarios = session.createQuery("from Usuario").list();
		tx = session.getTransaction();
		tx.commit();
		session.close();
		return usuarios;
	}
	
	@Override
	public Usuario readByUserAndPass(String usuario, String contraseña) {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		Query query = session.getNamedQuery("findUsuarioByUsuarioAndContrasena");
		query.setParameter("usuario", usuario);
		query.setParameter("contraseña", contraseña);
		Usuario user = (Usuario) query.uniqueResult();
		tx = session.getTransaction();
		tx.commit();
		session.close();
		return user;
	}
	
	// Agrego los gettes y setters para Spring Core

	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}

}
