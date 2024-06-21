package frgp.utn.edu.ar.entidad;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import frgp.utn.edu.ar.enums.EDiaHorario;

@Component
@Entity
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "dia")
	@Enumerated(EnumType.STRING)
	private EDiaHorario dia;

	@Column(name = "hora_inicio")
	private LocalTime horaInicio;

	@Column(name = "hora_fin")
	private LocalTime horaFin;

	@ManyToMany(mappedBy = "horarios", fetch = FetchType.EAGER)
	private Set<Medico> medicos;

	public Horario() {
	}

	public Horario(EDiaHorario dia, LocalTime horaInicio, LocalTime horaFin) {
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}

	public Horario(int id, EDiaHorario dia, LocalTime horaInicio, LocalTime horaFin, Set<Medico> medicos) {
		this.id = id;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.medicos = medicos;
	}

	// Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EDiaHorario getDia() {
		return dia;
	}

	public void setDia(EDiaHorario dia) {
		this.dia = dia;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	// Bidireccion Medico Set
	public Set<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(Set<Medico> medicos) {
		this.medicos = medicos;
	}

	@Override
	public String toString() {
		String mensaje = "Horario [id=" + id + ", dia=" + dia + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin
				+ ", medicos=";
		String auxMensaje = "{";
		if (medicos != null) {
			for (Medico medico2 : medicos) {
				auxMensaje += medico2.getMatricula() + " " + medico2.getNombre() + " " + medico2.getApellido() + " "
						+ medico2.getEmail() + " " + medico2.getTelefono() + " " + medico2.getFechaNacimiento() + " "
						+ medico2.getNombre() + " - ";
			}
		}
		auxMensaje += "}";
		return mensaje + auxMensaje + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Horario other = (Horario) obj;
		if (id == 0) {
			if (other.id != 0) {
				return false;
			} else if (!(id == other.id)) {
				return false;
			}
		}
		if (dia == null) {
			if (other.dia != null) {
				return false;
			} else if (!dia.equals(other.dia)) {
				return false;
			}
		}
		if (horaInicio == null) {
			if (other.horaInicio != null) {
				return false;
			} else if (!horaInicio.equals(other.horaInicio)) {
				return false;
			}
		}
		if (horaFin == null) {
			if (other.horaFin != null) {
				return false;
			} else if (!horaFin.equals(other.horaFin)) {
				return false;
			}
		}
		return true;
	}

}
