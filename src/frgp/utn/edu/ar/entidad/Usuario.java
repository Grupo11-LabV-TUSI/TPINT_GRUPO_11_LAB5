package frgp.utn.edu.ar.entidad;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/* Querys definidas por notacion */
@NamedQueries({
	@NamedQuery(name = "findAllUsuarios", query = "SELECT u FROM Usuario u"),
	@NamedQuery(name = "findUsuarioByUsuarioAndContrasena", query = "SELECT u FROM Usuario u WHERE u.usuario=:usuario AND u.contraseña=:contraseña"),})

@Component
@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
	// Implementar serializable
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "usuario", nullable = false, unique = true)
	private String usuario;

	private String contraseña;

	private boolean estado;

	@OneToOne(mappedBy = "usuario", fetch = FetchType.EAGER)
	private Medico medico;

	// Constructor por defecto
	public Usuario() {
	}

	// Constructor con parámetros
	public Usuario(Long id, String usuario, String contraseña, boolean estado) {
		this.id = id;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.estado = estado;
	}

	// Getters y Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	// Bidireccion Medico
	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	@Override
	public String toString() {
		String mensaje = "Usuario [id=" + id + ", usuario=" + usuario + ", contraseña=" + contraseña + ", estado="
				+ estado + ", medico=";
		if (medico != null) {
			mensaje += medico.getMatricula() + " " + medico.getNombre() + " " + medico.getApellido() + " "
					+ medico.getEmail() + " " + medico.getTelefono() + " " + medico.getFechaNacimiento() + " "
					+ medico.getEstado() + "]";
		}
		return mensaje;
	}

}
