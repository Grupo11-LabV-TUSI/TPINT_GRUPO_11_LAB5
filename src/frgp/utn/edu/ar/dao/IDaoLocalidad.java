package frgp.utn.edu.ar.dao;

import java.util.List;

import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Localidad;

public interface IDaoLocalidad {
	
	
	public boolean add(Localidad provincia);
	public Localidad readOne(int idProvincia);
	public List<Localidad> readAll();
	

}
