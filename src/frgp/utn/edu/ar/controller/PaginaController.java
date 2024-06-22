package frgp.utn.edu.ar.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Turno;
import frgp.utn.edu.ar.entidad.Usuario;
import frgp.utn.edu.ar.negocioImpl.MedicoNegocio;
import frgp.utn.edu.ar.negocioImpl.PacienteNegocio;
import frgp.utn.edu.ar.negocioImpl.TurnoNegocio;
import frgp.utn.edu.ar.negocioImpl.UsuarioNegocio;
import frgp.utn.edu.ar.resources.Config;

@Controller
public class PaginaController {
	/** Importacion de Servicios */
	ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
	/* Usuario */
	UsuarioNegocio usuarioNegocio = (UsuarioNegocio) appContext.getBean("UsuarioNegocioBean");
	Usuario usuario = (Usuario) appContext.getBean("UsuarioBean");
	/* Paciente */
	PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("PacienteNegocioBean");
	Paciente paciente = (Paciente) appContext.getBean("PacienteBean");
	/* Medico */
	MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("MedicoNegocioBean");
	Medico medico = (Medico) appContext.getBean("MedicoBean");
	/* Turno */
	TurnoNegocio turnoNegocio = (TurnoNegocio) appContext.getBean("TurnoNegocioBean");
	Turno turno = (Turno) appContext.getBean("TurnoBean");
	
	/** INICIO */
	// al lanzar la aplicacion redirecciona a inicio
	@RequestMapping("cargar_inicio.html")
	public ModelAndView eventoRedireccionarInicio() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Inicio");
		return MV;
	}
	/** INGRESO */
	// Redirige a ingreso
	@RequestMapping("redireccionar_ingreso.html")
	public ModelAndView eventoRedireccionarIngreso() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Ingreso");
		return MV;
	}
	// Redirige a inicio si ingreso correctamente
	@RequestMapping("validar_ingreso.html")
	public ModelAndView eventoValidarIngreso(String txtUsuario, String txtPassword) {
		ModelAndView MV = new ModelAndView();
		
		Usuario usuarioIngresado = verificarUsuario(txtUsuario,txtPassword);
		
		System.out.println(usuarioIngresado);
		
		if( usuarioIngresado != null) {
			
			switch (usuarioIngresado.getUsuario()) {
				case "Admin":
					MV.addObject("listaPacientes", pacienteNegocio.readAll());
					MV.addObject("listaMedicos", medicoNegocio.readAll());
					MV.addObject("listaTurnos", turnoNegocio.leerTodos());
					break;
	
				default:
					MV.addObject("listaTurnos", turnoNegocio.leerTodos());
					break;
			}
			MV.setViewName("Inicio");
			MV.addObject("usuarioIngresado", usuarioIngresado);
		} else {
			MV.setViewName("Ingreso");
			MV.addObject("MensajeError","Algo salio mal intente de nuevo, el usaurio no esta registrado");
			
		}
		return MV;
	}
	
	/** OTRA VISTA */
	// Ver paciente
	@RequestMapping("ver_paciente.html")
	public ModelAndView eventoVerPaciente(String paciente) {
		ModelAndView MV = new ModelAndView();
		System.out.println("LLEGO A VER PACIENTE");
		System.out.println(paciente);
		MV.setViewName("Ingreso");
		return MV;
	}
	/** OTRA VISTA */
	// Ver medico
	@RequestMapping("ver_medico.html")
	public ModelAndView eventoVerMedico(String medico) {
		ModelAndView MV = new ModelAndView();
		System.out.println("LLEGO A VER MEDICO");
		System.out.println(medico);
		MV.setViewName("Ingreso");
		return MV;
	}
	/** OTRA VISTA */
	// Ver turno
	@RequestMapping("ver_turno.html")
	public ModelAndView eventoVerTurno(String turno) {
		ModelAndView MV = new ModelAndView();
		System.out.println("LLEGO A VER TURNO");
		System.out.println(turno);
		MV.setViewName("Ingreso");
		return MV;
	}
	
	/** FUNCIONES AUXILIARES */
	/* Inicio */
	private Usuario verificarUsuario(String usuario, String contrasena) {
		return (Usuario)usuarioNegocio.readByUserAndPass(usuario, contrasena);
	}
}
