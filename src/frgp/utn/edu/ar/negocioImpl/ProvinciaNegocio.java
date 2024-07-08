package frgp.utn.edu.ar.negocioImpl;



import java.util.List;

import frgp.utn.edu.ar.dao.IDaoEspecialidad;
import frgp.utn.edu.ar.dao.IDaoProvincia;
import frgp.utn.edu.ar.dao.IDaoTurno;
import frgp.utn.edu.ar.entidad.Provincia;
import frgp.utn.edu.ar.negocio.IProvinciaNegocio;

public class ProvinciaNegocio implements IProvinciaNegocio {

	private IDaoProvincia daoProvincia;
	
	public ProvinciaNegocio() {}
	
	public ProvinciaNegocio(IDaoProvincia daoProvincia) {
		
		this.daoProvincia=daoProvincia;
		
	}
	
	
	@Override
	public boolean add(Provincia provincia) {
		
		return daoProvincia.add(provincia);

	}

	@Override
	public Provincia readOne(int idProvincia) {
			return daoProvincia.readOne(idProvincia);
	}

	@Override
	public List<Provincia> readAll() {
		return daoProvincia.readAll();
	}
	

	public void setDaoProvincia(IDaoProvincia daoProvincia) {
		this.daoProvincia = daoProvincia;
	}
	
	
	
	
}