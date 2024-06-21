package frgp.utn.edu.ar.negocio;

import java.util.List;

import frgp.utn.edu.ar.entidad.Paciente;

public interface IPacienteNegocio {
	public boolean add(Paciente paciente);
	public Paciente readOne(int dniPaciente);
	public boolean exist(int dniPaciente);
	public boolean update(Paciente paciente);
	public boolean delete(Paciente paciente);
	public List<Paciente> readAll();
}
