package frgp.utn.edu.ar.dao;

import java.util.List;

import frgp.utn.edu.ar.entidad.Medico;

public interface IDaoMedico {
    public boolean add(Medico medico);
    public Medico readOne(Long matriculaMedico);
    public boolean exist(Long matriculaMedico);
    public boolean update(Medico medico);
    public boolean delete(Medico medico);
    public List<Medico> readAll();
}
