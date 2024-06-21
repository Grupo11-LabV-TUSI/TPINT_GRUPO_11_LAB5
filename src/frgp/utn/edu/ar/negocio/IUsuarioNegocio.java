package frgp.utn.edu.ar.negocio;
import java.util.List;

import frgp.utn.edu.ar.entidad.Usuario;

public interface IUsuarioNegocio {
	public boolean add(Usuario usuario);
	public Usuario readOne(Long idUsuario);
	public boolean exist(Long idUsuario);
	public boolean update(Usuario usuario);
	public boolean delete(Usuario usuario);
	public List<Usuario> readAll();
	public Usuario readByUserAndPass(String usuario, String contraseña);
}
