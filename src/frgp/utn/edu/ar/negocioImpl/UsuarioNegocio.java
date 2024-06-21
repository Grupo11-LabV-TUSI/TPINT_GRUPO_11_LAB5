package frgp.utn.edu.ar.negocioImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import frgp.utn.edu.ar.dao.IDaoUsuario;
import frgp.utn.edu.ar.entidad.Usuario;
import frgp.utn.edu.ar.negocio.IUsuarioNegocio;

@Service
public class UsuarioNegocio implements IUsuarioNegocio {

	// Necesario para spring core
	private IDaoUsuario daoUsuario;

	public UsuarioNegocio() {
	}

	public UsuarioNegocio(IDaoUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}

	public IDaoUsuario getDaoUsuario() {
		return daoUsuario;
	}

	public void setDaoUsuario(IDaoUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}

	// Hasta aquí: Necesario para spring core

	@Override
	public boolean add(Usuario usuario) {
		return daoUsuario.add(usuario);
	}

	@Override
	public Usuario readOne(Long idUsuario) {
		return daoUsuario.readOne(idUsuario);
	}

	@Override
	public boolean exist(Long idUsuario) {
		return daoUsuario.exist(idUsuario);
	}

	@Override
	public boolean update(Usuario usuario) {
		return daoUsuario.update(usuario);
	}

	@Override
	public boolean delete(Usuario usuario) {
		return daoUsuario.delete(usuario);
	}

	@Override
	public List<Usuario> readAll() {
		return daoUsuario.readAll();
	}

	@Override
	public Usuario readByUserAndPass(String usuario, String contraseña) {
		return daoUsuario.readByUserAndPass(usuario, contraseña);
	}

}
