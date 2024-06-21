package frgp.utn.edu.ar.negocioImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.dao.IDaoPaciente;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.negocio.IPacienteNegocio;

@Service
public class PacienteNegocio implements IPacienteNegocio {
	
	private IDaoPaciente daoPaciente;
	
	public PacienteNegocio() {
	}

	public PacienteNegocio(IDaoPaciente daoPaciente) {
		this.daoPaciente = daoPaciente;
	}

	public IDaoPaciente getDaoPaciente() {
		return daoPaciente;
	}

	public void setDaoPaciente(IDaoPaciente daoPaciente) {
		this.daoPaciente = daoPaciente;
	}

	// Hasta aquí: Necesario para spring core

	@Override
	public boolean add(Paciente paciente) {
		return daoPaciente.add(paciente);
	}

	@Override
	public Paciente readOne(int dniPaciente) {
		return daoPaciente.readOne(dniPaciente);
	}

	@Override
	public boolean exist(int dniPaciente) {
		return daoPaciente.exist(dniPaciente);
	}

	@Override
	public boolean update(Paciente paciente) {
		return daoPaciente.update(paciente);
	}

	@Override
	public boolean delete(Paciente paciente) {
		return daoPaciente.delete(paciente);
	}

	@Override
	public List<Paciente> readAll() {
		return daoPaciente.readAll();
	}

}
