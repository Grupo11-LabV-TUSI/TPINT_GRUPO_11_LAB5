package frgp.utn.edu.ar.dao;

import java.sql.Date;
import java.util.List;

import frgp.utn.edu.ar.entidad.Turno;

public interface IDaoTurno {
	// crear
	public boolean add(Turno turno);

	// leer
	public Turno leer(Long id);
	
	// existe
	public boolean existe(Long id);

	// actualizar
	public boolean actualizar(Turno turno);

	// borrar
	public boolean borrar(Turno turno);

	// listar
	public List<Turno> leerTodos();

	public long contarTurnosPresenteEntreFechas(Date startDate, Date endDate);

	public long contarTurnosAusenteEntreFechas(Date startDate, Date endDate);

}
