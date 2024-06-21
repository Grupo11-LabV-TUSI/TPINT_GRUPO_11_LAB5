package frgp.utn.edu.ar.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "Especialidad")
public class Especialidad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int especialidad_id;

	@Column(name = "Nombre_Especialidad", nullable = false, unique = true)
	private String nombre;

	@OneToMany(mappedBy = "especialidad", fetch = FetchType.EAGER)
	private List<Medico> medico;

	public Especialidad() {
	}

	public Especialidad(int especialidad_id, String nombre) {
		this.especialidad_id = especialidad_id;
		this.nombre = nombre;
	}

	public int getEspecialidad_id() {
		return especialidad_id;
	}

	public void setEspecialidad_id(int especialidad_id) {
		this.especialidad_id = especialidad_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Medico> getMedico() {
		return medico;
	}

	public void setMedico(List<Medico> medico) {
		this.medico = medico;
	}

	@Override
	public String toString() {
		String mensaje = "Especialidad [especialidad_id=" + especialidad_id + ", nombre=" + nombre + ", medico=";
		String auxMnesaje = "{";
		if (medico != null) {
			for (Medico medico2 : medico) {
				auxMnesaje += medico2.getMatricula() + " " + medico2.getNombre() + " " + medico2.getApellido() + " "
						+ medico2.getEmail() + " " + medico2.getTelefono() + " " + medico2.getFechaNacimiento() + " "
						+ medico2.getEstado() + " - ";
			}
		}
		auxMnesaje += "}";
		return mensaje + auxMnesaje + "]";
	}

}
