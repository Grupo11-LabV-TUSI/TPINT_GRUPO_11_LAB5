package frgp.utn.edu.ar.negocio;

import java.util.List;

import frgp.utn.edu.ar.entidad.Localidad;

public interface ILocalidadNegocio {
	
	public boolean add(Localidad localidad);
	public Localidad readOne(int idProvincia);
	public List<Localidad> readAll();

}
