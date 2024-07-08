package frgp.utn.edu.ar.negocioImpl;




import java.util.List;

import frgp.utn.edu.ar.dao.IDaoLocalidad;
import frgp.utn.edu.ar.entidad.Localidad;
import frgp.utn.edu.ar.negocio.ILocalidadNegocio;

public class LocalidadNegocio implements ILocalidadNegocio{

	private IDaoLocalidad daoLocalidad;

	
	public LocalidadNegocio() {}
	
	public LocalidadNegocio(IDaoLocalidad daoLocalidad) {
		
		this.daoLocalidad=daoLocalidad;
		
	}
	
	
	@Override
	public boolean add(Localidad localidad) {
		
		return daoLocalidad.add(localidad);

	}

	@Override
	public Localidad readOne(int idLocalidad) {
			return daoLocalidad.readOne(idLocalidad);
	}

	@Override
	public List<Localidad> readAll() {
		return daoLocalidad.readAll();
	}
	
	public void setDaoLocalidad(IDaoLocalidad daoLocalidad) {
		this.daoLocalidad = daoLocalidad;
	}
	
}
