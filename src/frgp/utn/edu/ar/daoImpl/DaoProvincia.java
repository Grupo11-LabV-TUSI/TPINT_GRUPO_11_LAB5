package frgp.utn.edu.ar.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import frgp.utn.edu.ar.dao.IDaoProvincia;
import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Provincia;

public class DaoProvincia implements IDaoProvincia
{
	
	private Conexion conexion;
	
	 public DaoProvincia() {}
	 
	 
	 public void setConexion(Conexion conexion) {
			this.conexion = conexion;
		}	 
	 
		 
	public boolean add(Provincia provincia) {
		 
			boolean estado = true;
			Session session = conexion.abrirConexion();
			Transaction tx = session.beginTransaction();
			
			try {
				// Guardar el objeto
				session.save(provincia);
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
	 
	 public DaoProvincia(Conexion conexion) {
		 	this.conexion = conexion;
			// TODO Auto-generated constructor stub
		}


	@Override
	public Provincia readOne(int idProvincia) {
		
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		Provincia provincia = (Provincia) session.get(Provincia.class, idProvincia);
		tx = session.getTransaction();
		tx.commit();
		session.close();
		
		
		
		return provincia;
	}

	@Override
	public List<Provincia> readAll() {
		Session session = conexion.abrirConexion();
		Transaction tx = session.beginTransaction();
		List<Provincia> provincias = session.createQuery("FROM Provincia").list();
		tx = session.getTransaction();
		tx.commit();
		session.close();
		return provincias;
	}
		
	
	 

	

}
