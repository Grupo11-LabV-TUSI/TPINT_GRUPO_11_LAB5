package frgp.utn.edu.ar.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import frgp.utn.edu.ar.dao.IDaoLocalidad;
import frgp.utn.edu.ar.entidad.Localidad;

public class DaoLocalidad implements IDaoLocalidad {
	
	

	private Conexion conexion;
	
	 public DaoLocalidad() {}
	 
	 
	 public void setConexion(Conexion conexion) {
			this.conexion = conexion;
		}	 
	 
	 @Override	 
	public boolean add(Localidad localidad) {
		 
			boolean estado = true;
			Session session = conexion.abrirConexion();
			Transaction tx = session.beginTransaction();
			
			try {
				// Guardar el objeto
				session.save(localidad);
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
	 
	 public DaoLocalidad(Conexion conexion) {
		 	this.conexion = conexion;
			// TODO Auto-generated constructor stub
		}


	@Override
	public Localidad readOne (int idLocalidad) {
		
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		Localidad localidad = (Localidad) session.get(Localidad.class, idLocalidad);
		tx = session.getTransaction();
		tx.commit();
		session.close();
		
		
		
		return localidad;
	}

	@Override
	public List<Localidad> readAll() {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		List<Localidad> provincias = session.createQuery("FROM Localidad").list();
		tx = session.getTransaction();
		tx.commit();
		session.close();
		return provincias;
	}
		
	
	 

	

}
