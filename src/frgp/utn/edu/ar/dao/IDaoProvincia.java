package frgp.utn.edu.ar.dao;

import java.util.List;

import frgp.utn.edu.ar.entidad.Provincia;

public interface IDaoProvincia {


	public boolean add(Provincia provincia);
	public Provincia readOne(int idProvincia);
	public List<Provincia> readAll();

	
	
}
