package frgp.utn.edu.ar.dao;

import java.util.ArrayList;

public interface IDaoReporte {
	public int obtenerCantPacientesXEspecialidad(String especialidad, String fechaInicio, String fechaFin);
	
	public ArrayList<String> obtenerListado(int dia, int mes, int anio);
	public int obtenerTurnosXMedicoXfecha(int idMedico, String mes, String anio, int estado);
	

}
