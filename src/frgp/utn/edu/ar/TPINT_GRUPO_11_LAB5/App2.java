package frgp.utn.edu.ar.TPINT_GRUPO_11_LAB5;

import java.util.List;

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

public class App2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
		/** Lecturas */
		// Paciente

		PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("PacienteNegocioBean");
		Paciente paciente = (Paciente) appContext.getBean("PacienteBean");		
		List<Paciente> listaPaciente = pacienteNegocio.readAll();
		System.err.println("Listado de tabla Paciente");
		for (Paciente aux : listaPaciente) {
			System.out.println(aux.toString());
		}
		
		// Especialidad

		EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("EspecialidadNegocioBean");
		Especialidad especialidad = (Especialidad) appContext.getBean("EspecialidadBean");
		List<Especialidad> listaEspecialidad = especialidadNegocio.readAll();
		System.err.println("Listado de tabla Especialidad");
		for (Especialidad aux : listaEspecialidad) {
			System.out.println(aux.toString());
		}

		// Usuario

		UsuarioNegocio usuarioNegocio = (UsuarioNegocio) appContext.getBean("UsuarioNegocioBean");
		Usuario usuario = (Usuario) appContext.getBean("UsuarioBean");
		List<Usuario> listaUsuario = usuarioNegocio.readAll();
		System.err.println("Listado de tabla Usuario");
		for (Usuario aux : listaUsuario) {
			System.out.println(aux.toString());
		}
		System.out.println(usuarioNegocio.readByUserAndPass("SinUsuario", "SinContrasena"));

		// Horario

		HorarioNegocio horarioNegocio = (HorarioNegocio) appContext.getBean("HorarioNegocioBean");
		Horario horario = (Horario) appContext.getBean("HorarioBean");
		List<Horario> listaHorario = horarioNegocio.readAll();
		System.err.println("Listado de tabla Horario");
		for (Horario aux : listaHorario) {
			System.out.println(aux.toString());
		}

		// Medico

		MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("MedicoNegocioBean");
		Medico medico = (Medico) appContext.getBean("MedicoBean");
		System.err.println("Listado de tabla Medico");
		System.out.println(medicoNegocio.readOne(1L));
		List<Medico> listaMedico = medicoNegocio.readAll();
		for (Medico aux : listaMedico) {
			System.out.println(aux.toString());
		}

		// Turno
		
		TurnoNegocio turnoNegocio = (TurnoNegocio) appContext.getBean("TurnoNegocioBean");
		Turno turno = (Turno) appContext.getBean("TurnoBean");
		List<Turno> listaTurno = turnoNegocio.leerTodos();
		System.err.println("Listando Turno");
		for (Turno aux : listaTurno) {
			System.out.println(aux.toString());
		}

	}

}
