package frgp.utn.edu.ar.resources;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import frgp.utn.edu.ar.daoImpl.Conexion;
import frgp.utn.edu.ar.daoImpl.DaoEspecialidad;
import frgp.utn.edu.ar.daoImpl.DaoHorario;
import frgp.utn.edu.ar.daoImpl.DaoLocalidad;
import frgp.utn.edu.ar.daoImpl.DaoMedico;
import frgp.utn.edu.ar.daoImpl.DaoPaciente;
import frgp.utn.edu.ar.daoImpl.DaoProvincia;
import frgp.utn.edu.ar.daoImpl.DaoTurno;
import frgp.utn.edu.ar.daoImpl.DaoUsuario;
import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Horario;
import frgp.utn.edu.ar.entidad.Localidad;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Provincia;
import frgp.utn.edu.ar.entidad.Turno;
import frgp.utn.edu.ar.entidad.Usuario;
import frgp.utn.edu.ar.enums.EDiaHorario;
import frgp.utn.edu.ar.enums.EEstadoTurno;
import frgp.utn.edu.ar.negocioImpl.EspecialidadNegocio;
import frgp.utn.edu.ar.negocioImpl.HorarioNegocio;
import frgp.utn.edu.ar.negocioImpl.LocalidadNegocio;
import frgp.utn.edu.ar.negocioImpl.MedicoNegocio;
import frgp.utn.edu.ar.negocioImpl.PacienteNegocio;
import frgp.utn.edu.ar.negocioImpl.ProvinciaNegocio;
import frgp.utn.edu.ar.negocioImpl.TurnoNegocio;
import frgp.utn.edu.ar.negocioImpl.UsuarioNegocio;

@Configuration
@ComponentScan(basePackages = "utnfrgp")
public class Config {
	private static final Provincia Provincia = null;

	/** BEANS CAPAS */
	/* Bean Conexion */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public Conexion ConexionBean() {
		return new Conexion();
	}

	/** BEANS DAO */
	/* Bean DaoPaciente */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DaoPaciente DaoPacienteBean() {
		DaoPaciente daoPaciente = new DaoPaciente();
		daoPaciente.setConexion(ConexionBean());
		return daoPaciente;
	}

	/* Bean DaoEspecialidad */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DaoEspecialidad DaoEspecialidadBean() {
		DaoEspecialidad daoEspecialidad = new DaoEspecialidad();
		daoEspecialidad.setConexion(ConexionBean());
		return daoEspecialidad;
	}

	/* Bean DaoUsuario */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DaoUsuario DaoUsuarioBean() {
		DaoUsuario daoUsuario = new DaoUsuario();
		daoUsuario.setConexion(ConexionBean());
		return daoUsuario;
	}

	/* Bean DaoHorario */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DaoHorario DaoHorarioBean() {
		DaoHorario daoHorario = new DaoHorario();
		daoHorario.setConexion(ConexionBean());
		return daoHorario;
	}

	/* Bean DaoMedico */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DaoMedico DaoMedicoBean() {
		DaoMedico daoMedico = new DaoMedico();
		daoMedico.setConexion(ConexionBean());
		return daoMedico;
	}

	/* Bean DaoTurno */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DaoTurno DaoTurnoBean() {
		DaoTurno daoTurno = new DaoTurno();
		daoTurno.setConexion(ConexionBean());
		return daoTurno;
	}
	
	/* Bean DaoProvincia*/
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DaoProvincia DaoProvinciaBean() {
		DaoProvincia daoProvincia = new DaoProvincia();
		daoProvincia.setConexion(ConexionBean());
		return daoProvincia;
	}
	
	/* Bean DaoProvincia*/
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DaoLocalidad DaoLocalidadBean() {
		DaoLocalidad daoLocalidad = new DaoLocalidad();
		daoLocalidad.setConexion(ConexionBean());
		return daoLocalidad;
	}
	

	/** BEANS NEGOCIO */
	/* Bean PacienteNegocio */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public PacienteNegocio PacienteNegocioBean() {
		PacienteNegocio pacienteNegocio = new PacienteNegocio();
		pacienteNegocio.setDaoPaciente(DaoPacienteBean());
		return pacienteNegocio;
	}

	/* Bean EspecialidadNegocio */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public EspecialidadNegocio EspecialidadNegocioBean() {
		EspecialidadNegocio especialidadNegocio = new EspecialidadNegocio();
		especialidadNegocio.setDaoEspecialidad(DaoEspecialidadBean());
		return especialidadNegocio;
	}

	/* Bean UsuarioNegocio */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public UsuarioNegocio UsuarioNegocioBean() {
		UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
		usuarioNegocio.setDaoUsuario(DaoUsuarioBean());
		return usuarioNegocio;
	}

	/* Bean HorarioNegocio */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public HorarioNegocio HorarioNegocioBean() {
		HorarioNegocio horarioNegocio = new HorarioNegocio();
		horarioNegocio.setDaoHorario(DaoHorarioBean());
		return horarioNegocio;
	}

	/* Bean MedicoNegocio */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public MedicoNegocio MedicoNegocioBean() {
		MedicoNegocio medicoNegocio = new MedicoNegocio();
		medicoNegocio.setDaoMedico(DaoMedicoBean());
		return medicoNegocio;
	}

	/* Bean TurnoNegocio */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public TurnoNegocio TurnoNegocioBean() {
		TurnoNegocio turnoNegocio = new TurnoNegocio();
		turnoNegocio.setDaoTurno(DaoTurnoBean());
		return turnoNegocio;
	}
	
	/* Bean Provincia Negocio */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public ProvinciaNegocio ProvinciaNegocioBean() {
		ProvinciaNegocio provinciaNegocio = new ProvinciaNegocio();
		provinciaNegocio.setDaoProvincia(DaoProvinciaBean());
		return provinciaNegocio;
	}
	
	/* Bean Localidad Negocio */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public LocalidadNegocio LocalidadNegocioBean() {
		LocalidadNegocio localidadNegocio = new LocalidadNegocio();
		localidadNegocio.setDaoLocalidad(DaoLocalidadBean());
		return localidadNegocio;
	}
	

	/** BEANS ENTIDADES */
	/* Los Beans de Pacientes */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Paciente PacienteBean() {
		return new Paciente(0, "sinNombre", "sinApellido", "sinEmail", "sinTelefono", LocalDate.now(), "sinDireccion",
				"sinLocalidad", "sinProvincia", true);
	}

	/* Los Beans de Especialidad */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Especialidad EspecialidadBean() {
		return new Especialidad(0, "SinNombre");
	}

	/* Los Beans de Usuario */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Usuario UsuarioBean() {
		return new Usuario(0L, "SinUsuario", "SinContrasena", true);
	}

	/* Los Beans de Horario */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Horario HorarioBean() {
		return new Horario(EDiaHorario.Lunes, LocalTime.now(), LocalTime.now().plusHours(1L));
	}

	/* Los Beans de Medico */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Medico MedicoBean() {
		Set<Horario> setEHorarios = new HashSet<Horario>();
		setEHorarios.add(new Horario(EDiaHorario.Lunes, LocalTime.now(), LocalTime.now().plusHours(1L)));
		return new Medico(0L, "SinNommbre", "SinApellido", "SinEmail", "SinTelefono", LocalDate.now(), UsuarioBean(),
				EspecialidadBean(), setEHorarios, true);
	}

	/* Bean Turno */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Turno TurnoBean() {
		return new Turno(MedicoBean(), PacienteBean(), LocalDate.now(), LocalTime.now(), "SinObservacion",
				EEstadoTurno.Pendiente, true);
	}
	
	/* Los Beans de provincia */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Provincia ProvinciaBean() {
		
		return new Provincia(0, "SinNombre");
	}
	
	/* Los Beans de provincia */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Localidad LocalidadBean() {
		
		return new Localidad(0, "SinNombre", ProvinciaBean());
	}
	
	
	
}
