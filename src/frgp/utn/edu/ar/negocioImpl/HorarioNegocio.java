package frgp.utn.edu.ar.negocioImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.dao.IDaoHorario;
import frgp.utn.edu.ar.entidad.Horario;
import frgp.utn.edu.ar.negocio.IHorarioNegocio;

@Service
public class HorarioNegocio implements IHorarioNegocio {

    private IDaoHorario daoHorario;

    public HorarioNegocio() {}

    public HorarioNegocio(IDaoHorario daoHorario) {
        this.daoHorario = daoHorario;
    }

    public IDaoHorario getDaoHorario() {
        return daoHorario;
    }

    public void setDaoHorario(IDaoHorario daoHorario) {
        this.daoHorario = daoHorario;
    }

    @Override
    public boolean add(Horario horario) {
        return daoHorario.add(horario);
    }

    @Override
    public Horario readOne(int idHorario) {
        return daoHorario.readOne(idHorario);
    }

    @Override
    public boolean exist(int idHorario) {
        return daoHorario.exist(idHorario);
    }

    @Override
    public boolean update(Horario horario) {
        return daoHorario.update(horario);
    }

    @Override
    public boolean delete(Horario horario) {
        return daoHorario.delete(horario);
    }

    @Override
    public List<Horario> readAll() {
        return daoHorario.readAll();
    }
}
