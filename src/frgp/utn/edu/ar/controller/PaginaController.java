package frgp.utn.edu.ar.controller;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("PacienteNegocioBean");
	Especialidad especialidad = (Especialidad) appContext.getBean("PacienteBean");
	
	/** INICIO */
	// al lanzar la aplicacion redirecciona a inicio
	@RequestMapping("cargar_inicio.html")
	public ModelAndView eventoRedireccionarInicio() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Inicio");
		System.out.println("LLego al MEDICO INSTANCIA AGREGAR 554444");
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
					//MV.addObject("listaPacientes", pacienteNegocio.readAll());
					//MV.addObject("listaMedicos", medicoNegocio.readAll());
					//MV.addObject("listaTurnos", turnoNegocio.leerTodos());
					break;
	
				default:
					//MV.addObject("listaTurnos", turnoNegocio.leerTodos());
					break;
			}
			MV.setViewName("ABM_Medico");
			MV.addObject("usuarioIngresado", usuarioIngresado);
		} else {
			MV.setViewName("Ingreso");
			MV.addObject("MensajeError","Algo salio mal intente de nuevo, el usaurio no esta registrado");
			
		}
		return MV;
	}
	
	/*
	// Agregar nuevo Medico
		@RequestMapping("agregar_medico.html")
		public ModelAndView eventoAgregarMedico(String txtMATRICULA, String txtNOMBRE,String txtAPELLIDO,String txtEmail, String Fec_Nac,String txTELEFONO, int txtEspecialidad_id,int usuario_id ) {
			ModelAndView MV = new ModelAndView();
			
			Medico agregarMedico = agregarMedico(txtMATRICULA,txtNOMBRE,txtAPELLIDO,txtEmail,Fec_Nac,txTELEFONO,txtEspecialidad_id,usuario_id);
			
			System.out.println(agregarMedico);
			
			if( agregarMedico != null) {
				
				switch (agregarMedico.getApellido()) {
					case "Admin":
						//MV.addObject("listaPacientes", pacienteNegocio.readAll());
						//MV.addObject("listaMedicos", medicoNegocio.readAll());
						//MV.addObject("listaTurnos", turnoNegocio.leerTodos());
						break;
		
					default:
						//MV.addObject("listaTurnos", turnoNegocio.leerTodos());
						break;
				}
				MV.setViewName("ABM_Medico");
				MV.addObject("usuarioIngresado", agregarMedico);
			} else {
				MV.setViewName("Ingreso");
				MV.addObject("MensajeError","Algo salio mal intente de nuevo, el usaurio no esta registrado");
				
			}
			return MV;
		}
		*/
	

    
		// Agregar nuevo Medico V2
				@RequestMapping("agregar_medicoV2.html")
				public String agregar3(@Validated @ModelAttribute("medico") Medico medico, BindingResult result, Map<String, Object> model) {
					   
					System.out.println("LLego al MEDICO INSTANCIA AGREGAR 554466" + medico);
					Boolean b = true;
					if (result.hasErrors()) {
				        // El formulario contiene errores de validaci n, manejarlos apropiadamente
				        // ...
				    	return "medicoForm";
				    	
				    } else {
				    	b = medicoNegocio.add(medico);
				    	
				   	model.put("validacion", b);
				    	return "ABM_Medico";
				    }
					
				}
				
				@RequestMapping("agregar_medicoOLD.html")
				public String agregar2(@Validated @ModelAttribute("medico") Medico medico, 

                        BindingResult result, 
                        Map<String, Object> model) {
					   
					
					Boolean b = true;
					if (result.hasErrors()) {
				        // El formulario contiene errores de validaci n, manejarlos apropiadamente
				        // ...
				    	return "medicoForm";
				    	
				    } else {				    	
				    	b = medicoNegocio.add(medico);				    	
				   	    model.put("validacion", b);
				    	return "ABM_Medico";
				    }
					
				}
				
			    @RequestMapping(value = "agregar_medico.html", method = RequestMethod.GET)
			    public String showForm(Map<String, Object> model) {
			        Medico medico = new Medico();
			        model.put("medico", medico);
			        return "agregar_medico";
			    }
				
				@RequestMapping("agregar_medico2.html")
				public String eventoAgregarMedico2(String txtusuario, String txtclave,String txtmatricula,String txtfechaNacimiento,String txtespecialidad,String txtnombre,String txtapellido,String txtemail,String txttelefono ) {
					ModelAndView MV = new ModelAndView();
					Medico medico = new Medico();
			        medico.setMatricula(Long.parseLong(txtmatricula));
			        medico.setNombre(txtnombre);
			        medico.setApellido(txtapellido);
			        medico.setEmail(txtemail);
			        medico.setTelefono(txttelefono);
			        Especialidad especialidad = new Especialidad();
			        especialidad.setEspecialidad_id(Integer.parseInt(txtespecialidad));
			        medico.setEspecialidad(especialidad);
			        System.out.println(especialidad);
			       // medico.setFechaNacimiento(LocalDate.parse(txtfechaNacimiento));
					System.out.println("Prueba 1111 - USUARIO : " +txtusuario+ " CLAVE : "+ txtclave+ " NOMBRE "+ txtnombre+ " APELLIDO "+ txtapellido +" MATRICULA : " +txtmatricula + " Especialidad : " + txtespecialidad + " FECHA : " +txtfechaNacimiento);
					Boolean b = true;
				    b = medicoNegocio.add(medico);
			        	return "ABM_Medico";
				    
				
				}
				
				
				@RequestMapping("agregar_medico.html")
			    public String agregar(@Validated @ModelAttribute("medico") Medico medico,
                       // @RequestParam("usuario") String usuario, 
                        //@RequestParam("clave") String clave, 
			    		
                        BindingResult result, 
                        Map<String, Object> model) {
					   
					System.out.println("LLego al MEDICO INSTANCIA AGREGAR 554466" + medico  );
					Boolean b = true;
					if (result.hasErrors()) {
				        // El formulario contiene errores de validaci n, manejarlos apropiadamente
				        // ...
						System.out.println("ERROR" + result  );
				    	return "medicoForm";
				    	
				    } else {
				    	
				    	Usuario nuevoUsuario = new Usuario();
			            //nuevoUsuario.setUsuario(usuario);
			          //  nuevoUsuario.setContraseña(clave);
			            usuarioNegocio.add(nuevoUsuario);

			            b = medicoNegocio.add(medico);
			            model.put("validacion", b);
			            return "ABM_Medico";
				    }
					
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
	//@RequestMapping("agregar_medico.html")
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
