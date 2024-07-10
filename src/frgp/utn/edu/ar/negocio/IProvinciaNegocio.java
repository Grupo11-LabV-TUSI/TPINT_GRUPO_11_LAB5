package frgp.utn.edu.ar.negocio;

import java.util.List;

import frgp.utn.edu.ar.entidad.Provincia;

public interface IProvinciaNegocio {
	
	
	public boolean add(Provincia provincia);
	public Provincia readOne(int idProvincia);
	public List<Provincia> readAll();

}