package frgp.utn.edu.ar.TPINT_GRUPO_11_LAB5;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Horario;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Turno;
import frgp.utn.edu.ar.entidad.Usuario;
import frgp.utn.edu.ar.negocioImpl.EspecialidadNegocio;
import frgp.utn.edu.ar.negocioImpl.HorarioNegocio;
import frgp.utn.edu.ar.negocioImpl.MedicoNegocio;
import frgp.utn.edu.ar.negocioImpl.PacienteNegocio;
import frgp.utn.edu.ar.negocioImpl.TurnoNegocio;
import frgp.utn.edu.ar.negocioImpl.UsuarioNegocio;
import frgp.utn.edu.ar.resources.Config;

public class App {
	private final static String MENSAJE_AGREGADO = "AGREGADO CORRECTAMENTE";
	private final static String MENSAJE_YA_EXISTE = "YA EXISTE EN LA BASE DE DATOS";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
		boolean estado = false;

		/** Carga de datos */
		// Paciente
		PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("PacienteNegocioBean");
		Paciente paciente = (Paciente) appContext.getBean("PacienteBean");
		paciente.setDni(11111111);
		try {
			estado = pacienteNegocio.add(paciente);
			// System.out.println(MENSAJE_AGREGADO);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			System.out.println(paciente.toString());
			System.out.println(MENSAJE_YA_EXISTE);
		}

		// Especialidad
		EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("EspecialidadNegocioBean");
		Especialidad especialidad = (Especialidad) appContext.getBean("EspecialidadBean");
		try {
			estado = especialidadNegocio.add(especialidad);
			// System.out.println(MENSAJE_AGREGADO);
		} catch (Exception e) {
			// TODO: handle exception
			// System.err.println(MENSAJE_YA_EXISTE);
			e.printStackTrace();
		} finally {
			System.out.println(especialidad.toString());
			System.out.println(MENSAJE_YA_EXISTE);
		}

		// Usuario
		UsuarioNegocio usuarioNegocio = (UsuarioNegocio) appContext.getBean("UsuarioNegocioBean");
		Usuario usuario = (Usuario) appContext.getBean("UsuarioBean");
		try {
			estado = usuarioNegocio.add(usuario);
			// System.out.println(MENSAJE_AGREGADO);
		} catch (Exception e) {
			// TODO: handle exception
			// System.err.println(MENSAJE_YA_EXISTE);
			e.printStackTrace();
		} finally {
			System.out.println(usuario.toString());
			System.out.println(MENSAJE_YA_EXISTE);
		}

		// Horario
		HorarioNegocio horarioNegocio = (HorarioNegocio) appContext.getBean("HorarioNegocioBean");
		Horario horario = (Horario) appContext.getBean("HorarioBean");
		Set<Horario> setHorario = new HashSet<Horario>();
		setHorario.add(horario);
		try {
			estado = horarioNegocio.add(horario);
			// System.out.println(MENSAJE_AGREGADO);
		} catch (Exception e) {
			// TODO: handle exception
			// System.err.println(MENSAJE_YA_EXISTE);
			e.printStackTrace();
		} finally {
			for (Horario horario2 : setHorario) {
				System.out.println(horario2.toString());
			}
			System.out.println(MENSAJE_YA_EXISTE);
		}

		// Medico
		MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("MedicoNegocioBean");
		Medico medico = (Medico) appContext.getBean("MedicoBean");
		medico.setUsuario(usuario);
		medico.setEspecialidad(especialidad);
		medico.setHorarios(setHorario);
		try {
			estado = medicoNegocio.add(medico);
			// System.out.println(MENSAJE_AGREGADO);
		} catch (Exception e) {
			// TODO: handle exception
			// System.err.println(MENSAJE_YA_EXISTE);
			e.printStackTrace();
		} finally {
			System.out.println(medico.toString());
			System.out.println(MENSAJE_YA_EXISTE);
		}

		// Turno
		TurnoNegocio turnoNegocio = (TurnoNegocio) appContext.getBean("TurnoNegocioBean");
		Turno turno = (Turno) appContext.getBean("TurnoBean");
		medico = medicoNegocio.readOne(1L);
		paciente = pacienteNegocio.readOne(1);
		System.err.println("datos para el turno");
		System.out.println(medico);
		System.out.println(paciente);
		turno.setMedico(medico);
		turno.setPaciente(paciente);
		try {
			estado = turnoNegocio.add(turno);
			// System.out.println(MENSAJE_AGREGADO);
		} catch (Exception e) {
			// TODO: handle exception
			// System.err.println(MENSAJE_YA_EXISTE);
			e.printStackTrace();
		} finally {
			System.out.println(turno.toString());
			System.out.println(MENSAJE_YA_EXISTE);
		}
		
		// Usuario ADMIN
		usuario = (Usuario) appContext.getBean("UsuarioBean");
		usuario.setUsuario("Admin");
		usuario.setContraseña("Clave1234");
		try {
			estado = usuarioNegocio.add(usuario);
			// System.out.println(MENSAJE_AGREGADO);
		} catch (Exception e) {
			// TODO: handle exception
			// System.err.println(MENSAJE_YA_EXISTE);
			e.printStackTrace();
		} finally {
			System.out.println(usuario.toString());
			System.out.println(MENSAJE_YA_EXISTE);
		}

	}

}
