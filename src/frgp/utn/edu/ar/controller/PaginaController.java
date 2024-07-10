package frgp.utn.edu.ar.controller;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Turno;
import frgp.utn.edu.ar.entidad.Usuario;
import frgp.utn.edu.ar.enums.EEstadoTurno;
import frgp.utn.edu.ar.negocioImpl.EspecialidadNegocio;
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
	/* Especialidad */
	EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("EspecialidadNegocioBean");
	Especialidad especialidad = (Especialidad) appContext.getBean("EspecialidadBean");
		
	/** INICIO */
	// al lanzar la aplicacion redirecciona a inicio
	@RequestMapping("cargar_inicio.html")
	public ModelAndView eventoRedireccionarInicio(HttpSession session) {
		ModelAndView MV = new ModelAndView();
		
		if(session.getAttribute("rol") != null) {
			switch ((String)session.getAttribute("rol")) {
            case "Admin":
                session.setAttribute("rol", "Admin");
                MV.addObject("listaPacientes", pacienteNegocio.readAll());
                MV.addObject("listaMedicos", medicoNegocio.readAll());
                MV.addObject("listaTurnos", turnoNegocio.leerTodos());
                break;

            default:
                session.setAttribute("rol", "Medic");
                MV.addObject("listaTurnos", turnoNegocio.buscarTurnosPorMedico(((Usuario)session.getAttribute("usuarioIngresado")).getMedico()));
                break;
			
			}		
		}
		MV.setViewName("Inicio");
		return MV;
	}
	/** INGRESO */
	// Redirige a ingreso
	@RequestMapping("redireccionar_ingreso.html")
	public ModelAndView eventoRedireccionarIngreso(HttpSession session) {
		ModelAndView MV = new ModelAndView();
	    session.invalidate();
		MV.setViewName("Ingreso");
		return MV;
	}
	// Redirige a inicio si ingreso correctamente
	@RequestMapping("validar_ingreso.html")
	public ModelAndView eventoValidarIngreso(String txtUsuario, String txtPassword, HttpSession session) {
	    ModelAndView MV = new ModelAndView();

	    Usuario usuarioIngresado = verificarUsuario(txtUsuario, txtPassword);

	    if (usuarioIngresado != null) {
	        session.setAttribute("usuarioIngresado", usuarioIngresado);
	        session.setAttribute("txtUsuario", txtUsuario);
	        session.setAttribute("txtPassword", txtPassword);

	        switch (usuarioIngresado.getUsuario()) {
	            case "Admin":
	                session.setAttribute("rol", "Admin");
	                MV.addObject("listaPacientes", pacienteNegocio.readAll());
	                MV.addObject("listaMedicos", medicoNegocio.readAll());
	                MV.addObject("listaTurnos", turnoNegocio.leerTodos());
	                break;

	            default:
	                session.setAttribute("rol", "Medic");
	                MV.addObject("listaTurnos", turnoNegocio.buscarTurnosPorMedico(usuarioIngresado.getMedico()));
	                break;
	        }
	        MV.setViewName("Inicio");
	    } else {
	        MV.setViewName("Ingreso");
	        MV.addObject("MensajeError", "Algo salió mal, intente de nuevo, el usuario no está registrado");
	    }
	    return MV;
	}
	
	@RequestMapping("actualizar_estado_turno.html")
	public ModelAndView eventoActualizarEstadoTurno(@RequestParam("turnoId") Long id, 
	                                                @RequestParam(value = "estadoTurno", required = false) String estadoTurno,
	                                                @RequestParam(value = "observacion", required = false) String observacion,
	                                                HttpSession session) {
	    System.out.println("ESTOY PARA ACTUALIZAR EL ESTADO DEL TURNO");
	    ModelAndView MV = new ModelAndView();
	    Turno turno = turnoNegocio.leer(id);

	    String mensaje = "No se pudo actualizar: turno inexistente";

	    if (turno != null) {
	        if (estadoTurno != null) {
	            if (estadoTurno.equals("Presente")) {
	                turno.setEstadoTurno(EEstadoTurno.Presente);
	            } else if (estadoTurno.equals("Ausente")) {
	                turno.setEstadoTurno(EEstadoTurno.Ausente);
	            }
	        }

	        if (observacion != null && !observacion.trim().isEmpty()) {
	            turno.setObservacion(observacion);
	        }

	        boolean actualizado = turnoNegocio.actualizar(turno);
	        if (actualizado) {
	            mensaje = "Actualizado correctamente";
	        } else {
	            mensaje = "No se pudo actualizar el turno.";
	        }
	    }

	    String txtUsuario = (String) session.getAttribute("txtUsuario");
	    String txtPassword = (String) session.getAttribute("txtPassword");

	    return eventoValidarIngreso(txtUsuario, txtPassword, session);
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
	/**Vista Informes*/
//	@RequestMapping("MenuInformes.html")
//	public ModelAndView eventoVerInformes(String informe) {
//		ModelAndView MV = new ModelAndView();
//		MV.addObject("listaEspecialidades", especialidadNegocio.readAll());
//
//		MV.setViewName("MenuInformes");
//		return MV;
//	}
	
	@RequestMapping("ReporteCalendario.html")
	public ModelAndView eventoVerCalendario(String informe) {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("ReporteCalendario");
		return MV;
	}
	/** FUNCIONES AUXILIARES */
	/* Inicio */
	private Usuario verificarUsuario(String usuario, String contrasena) {
		return (Usuario)usuarioNegocio.readByUserAndPass(usuario, contrasena);
	}
}
