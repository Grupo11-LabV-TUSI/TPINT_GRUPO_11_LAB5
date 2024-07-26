package frgp.utn.edu.ar.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
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
import frgp.utn.edu.ar.enums.EEstadoTurno;
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
			@RequestParam("fechaInicio") String fechaInicio, @RequestParam("fechaFin") String fechaFin) {
		ModelAndView modelAndView = new ModelAndView();
		Especialidad esp = especialidadNegocio.readOne(especialidadId);
		// Imprimir los datos recibidos
		System.out.println("Especialidad ID: " + especialidadId);
		System.out.println("Fecha Inicio: " + fechaInicio);
		System.out.println(fechaInicio.substring(0, 10));
		System.out.println(LocalDate.parse(fechaInicio.substring(0, 10), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		System.out.println("Fecha Fin: " + fechaFin.substring(0, 10));

		// Obtener cantidad de turnos y nombre de especialidad
		int cantidadTurnos = obtenerCantidadTurnosPorEspecialidadYFechas(especialidadId, fechaInicio.substring(0, 10),
				fechaFin.substring(0, 10));
		String nombreEspecialidad = esp.getNombre();
		// obtenerNombreEspecialidad(especialidadId);
		System.out.println("Nombre Especialidad: " + nombreEspecialidad);

		// Agregar datos al modelo
		modelAndView.addObject("cantidadTurnos", cantidadTurnos);
		// especialidadNegocio.obtenerCantidadTurnosPorEspecialidadYFechas(especialidadId,
		// fechaInicio, fechaFin));
		modelAndView.addObject("nombreEspecialidad", nombreEspecialidad);
		modelAndView.addObject("listaMedicos", medicoNegocio.readAll());
		modelAndView.addObject("listaEspecialidades", especialidadNegocio.readAll());

		// Vista a la que se redirige después de procesar el formulario
		modelAndView.setViewName("Reporte1");
		return modelAndView;
	}

	@RequestMapping(value = "/Reporte2.html", method = RequestMethod.POST)
	public ModelAndView obtenerReporte2(long medicoId, int mes, int anio, int idEstado) {
		System.out.println("MedicoId: " + medicoId);
		System.out.println("Medico: " + medicoNegocio.readOne(medicoId));
		System.out.println("mes: " + mes);
		System.out.println("anio: " + anio);
		System.out.println("idEstado: " + idEstado);
		System.out.println(EEstadoTurno.getByIndex(idEstado));

		// primer dia del mes
		System.out.println("Primer dia del mes: " + LocalDate.of(anio, mes, 1).minusMonths(1L).with(TemporalAdjusters.firstDayOfNextMonth()));
		// ultimo dia del mes
		System.out.println("Ultimo dia del mes: " + LocalDate.of(anio, mes, 1).with(TemporalAdjusters.lastDayOfMonth()));

		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("medico",medicoNegocio.readOne(medicoId));
		modelAndView.addObject(
				"cantTurno",
				turnoNegocio.contarTurnosMedicoFechaEstado(
						medicoNegocio.readOne(medicoId),
						LocalDate.of(anio, mes, 1).minusMonths(1L).with(TemporalAdjusters.firstDayOfNextMonth()),
						LocalDate.of(anio, mes, 1).with(TemporalAdjusters.lastDayOfMonth()),
						EEstadoTurno.getByIndex(idEstado)));
		modelAndView.addObject("estadoTurno", EEstadoTurno.getByIndex(idEstado));
		modelAndView.addObject("mes", mes);
		modelAndView.addObject("anio", anio);
		
		System.out.println("Medico: " + medicoNegocio.readOne(medicoId));
		System.out.println("CONTADOR");
		System.out.println(turnoNegocio.contarTurnosMedicoFechaEstado(
				medicoNegocio.readOne(medicoId),
						LocalDate.of(anio, mes, 1).minusMonths(1L).with(TemporalAdjusters.firstDayOfNextMonth()),
						LocalDate.of(anio, mes, 1).with(TemporalAdjusters.lastDayOfMonth()),
						EEstadoTurno.getByIndex(idEstado)));

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
	private int obtenerCantidadTurnosPorEspecialidadYFechas(int especialidadId, String fechaInicio, String fechaFin) {
		// Implementa la lógica para obtener la cantidad de turnos
		// Aquí puedes acceder a tu capa de servicio o persistencia de datos
		// Este es solo un ejemplo simulado
		// Long cont =
		// turnoNegocio.contarTurnosEspecialidadEntreFechas(especialidadNegocio.readOne(especialidadId),
		// LocalDate.parse(fechaInicio), LocalDate.parse(fechaFin));
		return Integer.parseInt(String
				.valueOf(turnoNegocio.contarTurnosEspecialidadEntreFechas(especialidadNegocio.readOne(especialidadId),
						LocalDate.parse(fechaInicio, DateTimeFormatter.ofPattern("yyyy-MM-dd")),
						LocalDate.parse(fechaFin, DateTimeFormatter.ofPattern("yyyy-MM-dd"))))); // Ejemplo de cantidad
																									// de turnos
	}

	// Método simulado para obtener el nombre de la especialidad
	private String obtenerNombreEspecialidad(int especialidadId) {
		// Implementa la lógica para obtener el nombre de la especialidad
		// Este es solo un ejemplo simulado
		return "Cardiología"; // Ejemplo de nombre de especialidad
	}
}
