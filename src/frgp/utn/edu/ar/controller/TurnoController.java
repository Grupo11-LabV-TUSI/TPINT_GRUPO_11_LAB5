package frgp.utn.edu.ar.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Turno;
import frgp.utn.edu.ar.negocioImpl.TurnoNegocio;
import frgp.utn.edu.ar.resources.Config;

@Controller
public class TurnoController {

	ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);

	TurnoNegocio turnoNegocio = (TurnoNegocio) appContext.getBean("TurnoNegocioBean");
	Turno turno = (Turno) appContext.getBean("TurnoBean");
	
	
	@RequestMapping("ABML_turno.html")
	public ModelAndView ABML_turno() {
		ModelAndView MV = new ModelAndView();
		MV.addObject("listaTurnos", turnoNegocio.leerTodos());
		
		System.out.println("LLEGO AL ABML TURNO");
		
		MV.setViewName("ABML_Turno");
		return MV;
	}
	
	
}
