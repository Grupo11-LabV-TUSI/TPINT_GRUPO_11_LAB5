package frgp.utn.edu.ar.negocioImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.dao.IDaoEspecialidad;
import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.negocio.IEspecialidadNegocio;

@Service
public class EspecialidadNegocio implements IEspecialidadNegocio {

	private IDaoEspecialidad daoEspecialidad;

	public EspecialidadNegocio() {

	}

	public EspecialidadNegocio(IDaoEspecialidad daoEspecialidad) {
		this.daoEspecialidad = daoEspecialidad;
	}

	public IDaoEspecialidad getDaoEspecialidad() {
		return daoEspecialidad;
	}

	public void setDaoEspecialidad(IDaoEspecialidad daoEspecialidad) {
		this.daoEspecialidad = daoEspecialidad;
	}

	@Override
	public boolean add(Especialidad especialidad) {
		return daoEspecialidad.add(especialidad);
	}

	@Override
	public Especialidad readOne(int idEspecialidad) {
		return daoEspecialidad.readOne(idEspecialidad);
	}

	@Override
	public boolean exist(int idEspecialidad) {
		return daoEspecialidad.exist(idEspecialidad);
	}

	@Override
	public boolean update(Especialidad especialidad) {
		return daoEspecialidad.update(especialidad);
	}

	@Override
	public boolean delete(Especialidad especialidad) {
		return daoEspecialidad.delete(especialidad);
	}

	@Override
	public List<Especialidad> readAll() {
		return daoEspecialidad.readAll();
	}

	@Override
	public int obtenerCantidadTurnosPorEspecialidadYFechas(int idEspecialidad, String fechaInicio, String fechaFin) {
		// TODO Auto-generated method stub
		return daoEspecialidad.obtenerCantidadTurnosPorEspecialidadYFechas(idEspecialidad, fechaInicio, fechaFin);
	}

}
