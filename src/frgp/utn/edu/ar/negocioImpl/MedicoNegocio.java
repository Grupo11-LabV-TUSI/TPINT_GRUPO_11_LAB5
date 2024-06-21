package frgp.utn.edu.ar.negocioImpl;

import java.util.List;

import frgp.utn.edu.ar.dao.IDaoMedico;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.negocio.IMedicoNegocio;

public class MedicoNegocio implements IMedicoNegocio {

    private IDaoMedico daoMedico;

    public MedicoNegocio() {
    }

    public MedicoNegocio(IDaoMedico daoMedico) {
        this.daoMedico = daoMedico;
    }

    public IDaoMedico getDaoMedico() {
        return daoMedico;
    }

    public void setDaoMedico(IDaoMedico daoMedico) {
        this.daoMedico = daoMedico;
    }

    @Override
    public boolean add(Medico medico) {
        return daoMedico.add(medico);
    }

    @Override
    public Medico readOne(Long id) {
        return daoMedico.readOne(id);
    }

    @Override
    public boolean exist(Long id) {
        return daoMedico.exist(id);
    }

    @Override
    public boolean update(Medico medico) {
        return daoMedico.update(medico);
    }

    @Override
    public boolean delete(Medico medico) {
        return daoMedico.delete(medico);
    }

    @Override
    public List<Medico> readAll() {
        return daoMedico.readAll();
    }
}