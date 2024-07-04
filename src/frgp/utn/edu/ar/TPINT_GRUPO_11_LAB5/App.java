package frgp.utn.edu.ar.TPINT_GRUPO_11_LAB5;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Horario;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Turno;
import frgp.utn.edu.ar.entidad.Usuario;
import frgp.utn.edu.ar.enums.EDiaHorario;
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
		for (int i = 0; i < 15; i++) {
			paciente.setDni(10000000+(i+1));
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
		}

		// Especialidad
		EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("EspecialidadNegocioBean");
		Especialidad especialidad = (Especialidad) appContext.getBean("EspecialidadBean");
		for (int i = 0; i < 15; i++) {
			especialidad.setNombre("Especialidad"+(i+1));
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
		}

		// Usuario
		UsuarioNegocio usuarioNegocio = (UsuarioNegocio) appContext.getBean("UsuarioNegocioBean");
		Usuario usuario = (Usuario) appContext.getBean("UsuarioBean");
		for (int i = 0; i < 15; i++) {
			usuario.setUsuario("Usuario"+(i+1));
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

		// Horario
		HorarioNegocio horarioNegocio = (HorarioNegocio) appContext.getBean("HorarioNegocioBean");
		Horario horario = (Horario) appContext.getBean("HorarioBean");
		for (int i = 1; i <= 5; i++) {
			Set<Horario> setHorario = new HashSet<Horario>();
			horario.setDia(EDiaHorario.getByIndex(i));
			horario.setHoraInicio(LocalTime.of(8, 0));
			horario.setHoraFin(LocalTime.of(16, 0));
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
		}
		for (int i = 1; i <= 5; i++) {
			Set<Horario> setHorario = new HashSet<Horario>();
			horario.setDia(EDiaHorario.getByIndex(i));
			horario.setHoraInicio(LocalTime.of(8, 0));
			horario.setHoraFin(LocalTime.of(12, 0));
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
		}
		for (int i = 1; i <= 5; i++) {
			Set<Horario> setHorario = new HashSet<Horario>();
			horario.setDia(EDiaHorario.getByIndex(i));
			horario.setHoraInicio(LocalTime.of(12, 0));
			horario.setHoraFin(LocalTime.of(16, 0));
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
		}

		// Medico
		MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("MedicoNegocioBean");
		Medico medico = (Medico) appContext.getBean("MedicoBean");
		for (int i = 0; i < 15; i++) {
			medico.setNombre("nombreMedico"+(i+1));
			medico.setUsuario(usuarioNegocio.readOne(i+1L));
			medico.setEspecialidad(especialidadNegocio.readOne(i+1));
			Set<Horario> setHorario = new HashSet<Horario>();
			setHorario.add(horarioNegocio.readOne(i+1));
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
		}

		// Turno
		TurnoNegocio turnoNegocio = (TurnoNegocio) appContext.getBean("TurnoNegocioBean");
		Turno turno = (Turno) appContext.getBean("TurnoBean");
		for (int i = 0; i < 15; i++) {
			medico = medicoNegocio.readOne(i+1L);
			paciente = pacienteNegocio.readOne(10000000+(i+1));
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
