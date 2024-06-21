package frgp.utn.edu.ar.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Usuario;
import frgp.utn.edu.ar.negocioImpl.UsuarioNegocio;
import frgp.utn.edu.ar.resources.Config;

@Controller
public class PaginaController {
	/** Importacion de Servicios */
	ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
	/* Usuario */
	UsuarioNegocio usuarioNegocio = (UsuarioNegocio) appContext.getBean("UsuarioNegocioBean");
	Usuario usuario = (Usuario) appContext.getBean("UsuarioBean");
	/*  */
	
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
			MV.addObject("usuario", "HOLA");
			MV.addObject("password", "MUNDO");
			MV.setViewName("Inicio");
			MV.addObject("usuarioIngresado", usuarioIngresado);
		} else {
			MV.setViewName("Ingreso");	
		}
		return MV;
	}
	
	/** OTRA VISTA */
	// 
	
	/** OTRA VISTA */
	// 
	
	/** FUNCIONES AUXILIARES */
	/* Inicio */
	private Usuario verificarUsuario(String usuario, String contrasena) {
		return (Usuario)usuarioNegocio.readByUserAndPass(usuario, contrasena);
	}
}
