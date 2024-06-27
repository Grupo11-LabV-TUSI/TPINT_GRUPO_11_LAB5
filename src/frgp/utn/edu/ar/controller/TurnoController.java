package frgp.utn.edu.ar.controller;

import java.util.List;
import java.util.stream.Collectors;

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
import frgp.utn.edu.ar.negocioImpl.EspecialidadNegocio;
import frgp.utn.edu.ar.negocioImpl.MedicoNegocio;
import frgp.utn.edu.ar.negocioImpl.PacienteNegocio;
import frgp.utn.edu.ar.negocioImpl.TurnoNegocio;
import frgp.utn.edu.ar.resources.Config;

@Controller
public class TurnoController {

	ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);

	TurnoNegocio turnoNegocio = (TurnoNegocio) appContext.getBean("TurnoNegocioBean");
	Turno turno = (Turno) appContext.getBean("TurnoBean");
	
	EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("EspecialidadNegocioBean");
	Especialidad especialidad = (Especialidad) appContext.getBean("EspecialidadBean");
	
	MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("MedicoNegocioBean");
	Medico medico = (Medico) appContext.getBean("MedicoBean");
	
	PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("PacienteNegocioBean");
	Paciente paciente = (Paciente) appContext.getBean("PacienteBean");
	
	
	@RequestMapping("ABML_turno.html")
	public ModelAndView ABML_turno(@RequestParam(required = false) Integer especialidad) {
	    ModelAndView MV = new ModelAndView("ABML_Turno");
	    MV.addObject("listaTurnos", turnoNegocio.leerTodos());
	    MV.addObject("listaEspecialidades", especialidadNegocio.readAll());
	    MV.addObject("listaPacientes", pacienteNegocio.readAll());

	    if (especialidad != null) {
	        List<Medico> listaMedicosFiltrados = medicoNegocio.readAll().stream()
	                .filter(m -> m.getEspecialidad().getEspecialidad_id() == especialidad)
	                .collect(Collectors.toList());
	        MV.addObject("listaMedicosFiltrados", listaMedicosFiltrados);
	    } else {
	        MV.addObject("listaMedicosFiltrados", medicoNegocio.readAll());
	    }

	    return MV;
	}
	
	
}
