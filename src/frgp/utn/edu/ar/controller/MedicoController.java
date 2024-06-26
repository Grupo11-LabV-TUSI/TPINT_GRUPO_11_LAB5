package frgp.utn.edu.ar.controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.negocioImpl.MedicoNegocio;
import frgp.utn.edu.ar.negocioImpl.PacienteNegocio;
import frgp.utn.edu.ar.resources.Config;

@Controller
public class MedicoController {
	/** Importacion de Servicios */
	ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);

	/* Paciente */
	MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("MedicoNegocioBean");
	Medico medico = (Medico) appContext.getBean("MedicoBean");



    @RequestMapping(value = "ABM_medico.html", method = RequestMethod.GET)
    public ModelAndView ABM_medico() {
        ModelAndView MV = new ModelAndView();
        MV.addObject("listaMedicos", medicoNegocio.readAll());

        System.out.println("LLEGO AL ABM MEDICO");

        MV.setViewName("ABM_Medico");
        return MV;
    }
}
