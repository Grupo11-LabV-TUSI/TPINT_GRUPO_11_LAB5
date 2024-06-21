package frgp.utn.edu.ar.entidad;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

import org.springframework.stereotype.Component;

@NamedQueries({
		@NamedQuery(name = "findMedicoByMatricula", query = "SELECT m FROM Medico m WHERE matricula=:matricula"),
		@NamedQuery(name = "findAllMedicos", query = "SELECT m FROM Medico m"),
		@NamedQuery(name = "findAllMedicosOrderByMatricula", query = "FROM Medico m ORDER BY m.matricula ASC"),
		@NamedQuery(name = "findAllMedicoLegajos", query = "SELECT m.matricula FROM Medico m") })

@Component
@Entity
@Table(name = "Medico")
public class Medico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "matricula")
	private Long matricula;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "email")
	private String email;

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "fecha_nacimiento")
	private LocalDate fechaNacimiento;

	@OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "especialidad_id")
	private Especialidad especialidad;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "medico_x_horario", joinColumns = { @JoinColumn(name = "matricula_id") }, inverseJoinColumns = {
			@JoinColumn(name = "horario_id") })
	private Set<Horario> horarios;

	@Column(name = "estado")
	private boolean estado;

	// Bidireccion
	@OneToMany(mappedBy = "medico", fetch = FetchType.LAZY)
	private List<Turno> turnos;

	// Constructor vacío para Hibernate
	public Medico() {
	}

	public Medico(String nombre, String apellido, String email, String telefono, LocalDate fechaNacimiento,
			Usuario usuario, Especialidad especialidad, Set<Horario> horarios, boolean estado) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.usuario = usuario;
		this.especialidad = especialidad;
		this.horarios = horarios;
		this.estado = estado;
	}

	public Medico(Long matricula, String nombre, String apellido, String email, String telefono,
			LocalDate fechaNacimiento, Usuario usuario, Especialidad especialidad, Set<Horario> horarios,
			boolean estado) {
		this.matricula = matricula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.usuario = usuario;
		this.especialidad = especialidad;
		this.horarios = horarios;
		this.estado = estado;
	}

	// Getters y setters
	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public Set<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(Set<Horario> horarios) {
		this.horarios = horarios;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	// Bidireccion
	public List<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}

	@Override
	public String toString() {
		String mensaje = "Medico [matricula=" + matricula + ", nombre=" + nombre + ", apellido=" + apellido + ", email="
				+ email + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", usuario=" + usuario
				+ ", especialidad=" + especialidad + ", horarios=" + horarios + ", estado=" + estado + ", turnos=";
		String auxMensaje = "{";
		if (turnos != null) {
			for (Turno turno : turnos) {
				auxMensaje += turno.getId() + " " + "Medico=" + "{" + turno.getMedico().getMatricula() + " - "
						+ turno.getMedico().getNombre() + " - " + turno.getMedico().getApellido() + " - "
						+ turno.getMedico().getEmail() + " - " + turno.getMedico().getTelefono() + " - "
						+ turno.getMedico().getFechaNacimiento() + " - " + turno.getMedico().getEstado() + "}" + " "
						+ turno.getFecha() + " " + turno.getHora() + " " + turno.getObservacion() + " "
						+ turno.getEstadoTurno() + " " + turno.getEstado() + " - ";
			}
		}
		auxMensaje += "}";
		return mensaje + auxMensaje + "]";
	}

}
