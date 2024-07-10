package frgp.utn.edu.ar.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.daoImpl.DaoEspecialidad;
import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Turno;
import frgp.utn.edu.ar.entidad.Usuario;
import frgp.utn.edu.ar.negocioImpl.EspecialidadNegocio;
import frgp.utn.edu.ar.negocioImpl.MedicoNegocio;
import frgp.utn.edu.ar.negocioImpl.PacienteNegocio;
import frgp.utn.edu.ar.negocioImpl.TurnoNegocio;
import frgp.utn.edu.ar.negocioImpl.UsuarioNegocio;
import frgp.utn.edu.ar.resources.Config;

@Controller
public class ReporteController {
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

	/** Vista Informes */

	@RequestMapping(value = "/Reporte1.html", method = RequestMethod.POST)
	public ModelAndView obtenerReporte(@RequestParam("especialidad") int especialidadId,
	                                    @RequestParam("fechaInicio") String fechaInicio,
	                                    @RequestParam("fechaFin") String fechaFin) {
	    ModelAndView modelAndView = new ModelAndView();
	    Especialidad esp = especialidadNegocio.readOne(especialidadId);
	    // Imprimir los datos recibidos
	    System.out.println("Especialidad ID: " + especialidadId);
	    System.out.println("Fecha Inicio: " + fechaInicio);
	    System.out.println("Fecha Fin: " + fechaFin);

	    // Obtener cantidad de turnos y nombre de especialidad
	    int cantidadTurnos = 
	    		obtenerCantidadTurnosPorEspecialidadYFechas(especialidadId, fechaInicio, fechaFin);
	    String nombreEspecialidad = esp.getNombre();
	    		//obtenerNombreEspecialidad(especialidadId);
	    System.out.println("Nombre Especialidad: " + nombreEspecialidad);

	    // Agregar datos al modelo
	    modelAndView.addObject("cantidadTurnos",  cantidadTurnos);
	    		//especialidadNegocio.obtenerCantidadTurnosPorEspecialidadYFechas(especialidadId, fechaInicio, fechaFin));
	    modelAndView.addObject("nombreEspecialidad", nombreEspecialidad);
	    modelAndView.addObject("listaMedicos", medicoNegocio.readAll());
	    modelAndView.addObject("listaEspecialidades", especialidadNegocio.readAll());

	    // Vista a la que se redirige después de procesar el formulario
	    modelAndView.setViewName("Reporte1");
	    return modelAndView;
	}
	@RequestMapping(value = "/Reporte2.html", method = RequestMethod.POST)
	public ModelAndView obtenerReporte2() {
	    ModelAndView modelAndView = new ModelAndView();

	    // Vista a la que se redirige después de procesar el formulario
	    modelAndView.setViewName("Reporte2");
	    return modelAndView;
	}

	@RequestMapping(value = "/MenuInformes.html", method = RequestMethod.POST)
	public ModelAndView eventoVerInformes(HttpServletRequest request) {
		ModelAndView MV = new ModelAndView();       
		MV.addObject("listaMedicos", medicoNegocio.readAll());
		MV.addObject("listaEspecialidades", especialidadNegocio.readAll());
		System.out.println(medicoNegocio.readAll());
		System.out.println("MOD JOAC");
		MV.setViewName("MenuInformes");
		return MV;
	}

	// Método simulado para obtener la cantidad de turnos por especialidad y fechas
	private int obtenerCantidadTurnosPorEspecialidadYFechas(int especialidadId, String fechaInicio,
			String fechaFin) {
		// Implementa la lógica para obtener la cantidad de turnos
		// Aquí puedes acceder a tu capa de servicio o persistencia de datos
		// Este es solo un ejemplo simulado
		return 10; // Ejemplo de cantidad de turnos
	}

	// Método simulado para obtener el nombre de la especialidad
	private String obtenerNombreEspecialidad(int especialidadId) {
		// Implementa la lógica para obtener el nombre de la especialidad
		// Este es solo un ejemplo simulado
		return "Cardiología"; // Ejemplo de nombre de especialidad
	}
}
