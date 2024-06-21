package frgp.utn.edu.ar.negocio;

import java.util.List;

import frgp.utn.edu.ar.entidad.Especialidad;

public interface IEspecialidadNegocio {
	public boolean add(Especialidad especialidad);
	public Especialidad readOne(int idEspecialidad);
	public boolean exist(int idEspecialidad);
	public boolean update(Especialidad especialidad);
	public boolean delete(Especialidad especialidad);
	public List<Especialidad> readAll();
}
