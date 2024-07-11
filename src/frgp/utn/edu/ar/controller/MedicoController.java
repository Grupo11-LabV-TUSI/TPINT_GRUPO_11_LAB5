package frgp.utn.edu.ar.controller;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Horario;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Usuario;
import frgp.utn.edu.ar.negocioImpl.UsuarioNegocio;
import frgp.utn.edu.ar.negocioImpl.EspecialidadNegocio;
import frgp.utn.edu.ar.negocioImpl.HorarioNegocio;
import frgp.utn.edu.ar.negocioImpl.MedicoNegocio;
import frgp.utn.edu.ar.resources.Config;

@Controller
public class MedicoController {
	/** Importacion de Servicios */
	ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);

	/* Paciente */
	MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("MedicoNegocioBean");
	Medico medico = (Medico) appContext.getBean("MedicoBean");
	/* Especialidad */
	EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("EspecialidadNegocioBean");
	Especialidad especialidad = (Especialidad) appContext.getBean("EspecialidadBean");
	/* Usuario */
	UsuarioNegocio usuarioNegocio = (UsuarioNegocio) appContext.getBean("UsuarioNegocioBean");
	Usuario usuario = (Usuario) appContext.getBean("UsuarioBean");
	/* Turnos */
	HorarioNegocio horarioNegocio = (HorarioNegocio) appContext.getBean("HorarioNegocioBean");
	Horario horario = (Horario) appContext.getBean("HorarioBean");

	/** abml */
	@RequestMapping("ABM_medico.html")
	public ModelAndView ABM_medico() {
		ModelAndView MV = new ModelAndView();
        MV.addObject("listaMedicos", medicoNegocio.readAll());
		//System.out.println("LLEGO AL ABML MEDICOOOOOOOOO");		
		MV.setViewName("ABM_Medico");
		MV.addObject("listaEspecialidades", especialidadNegocio.readAll());
		MV.addObject("listaHorarios", horarioNegocio.readAll());
         
		
		return MV;
	}
	@RequestMapping(value = "eliminar_medico.html", method = RequestMethod.POST)
	public ModelAndView eliminarMedico(@RequestParam("matricula") Long matricula) {
	    ModelAndView MV = new ModelAndView("ABM_Medico");
	    System.out.println("Matricula llegando" + matricula);
	    Medico medico = medicoNegocio.readOne(matricula);
	    
	    if (medico != null) {
	        medico.setEstado(false); // Baja lógica
	        medicoNegocio.update(medico);
	        
	        MV.addObject("mensaje", "Médico eliminado correctamente.");
	    } else {
	        MV.addObject("mensaje", "Médico no encontrado.");
	    }

	    List<Medico> listaMedicos = medicoNegocio.readAll();
	    MV.setViewName("ABM_Medico");
	    MV.addObject("listaMedicos", listaMedicos);
	    return MV;
	}
	
	
	@RequestMapping(value = "habilitar_medico.html", method = RequestMethod.POST)
	public ModelAndView altaMedico(@RequestParam("matricula") Long matricula) {
	    ModelAndView MV = new ModelAndView("ABM_Medico");
	    Medico medico = medicoNegocio.readOne(matricula);
	    
	    if (medico != null) {
	        medico.setEstado(true); // Alta lógica
	        medicoNegocio.update(medico);
	        
	        MV.addObject("mensaje", "Médico dado de alta correctamente.");
	    } else {
	        MV.addObject("mensaje", "Médico no encontrado.");
	    }

	    List<Medico> listaMedicos = medicoNegocio.readAll();
	    MV.setViewName("ABM_Medico");
	    MV.addObject("listaMedicos", listaMedicos);
	    return MV;
	}

	
	
	
	

	@RequestMapping(value = "actualizar_medico.html", method = RequestMethod.POST)
    public ModelAndView actualizarMedico(
    		@RequestParam("nombre") String nombre ,
    		@RequestParam("apellido") String apellido,
            @RequestParam("matricula") Long matricula,
            @RequestParam("email") String email,
            @RequestParam("telefono") String telefono,
            @RequestParam("especialidad") int especialidad) {
        
        ModelAndView MV = new ModelAndView("ABM_Medico");
        Medico medico = medicoNegocio.readOne(matricula);
        
        if (medico != null) {
        	medico.setNombre(nombre);
        	medico.setApellido(apellido);
            medico.setEmail(email);
            medico.setTelefono(telefono);
          
            List<Especialidad> listaespecialidad2 = especialidadNegocio.readAll();
            //System.out.println("LA SELECCION DE LA ESPECIALIDAD SELECCIONADA ESSSSSSSSS" + especialidad);
    		for (Especialidad especialidad3 : listaespecialidad2) {
    			if (especialidad3.getEspecialidad_id() == especialidad) {
                	System.out.println(especialidad3 + "ESPECIALIDAD COMPARACIO - Agregue el ESPE" + especialidad);
                	medico.setEspecialidad(especialidad3);
                	//System.out.println("LA SELECCION DE LA ESPECIALIDAD SELECCIONADA ESSSSSSSSS" + especialidad3);
                }
    		}          

            medicoNegocio.update(medico);
            
            System.out.println("LOS DATOS A MODIFICAR SONNNNNN" + medico);
            MV.addObject("mensaje", "Datos actualizados correctamente.");
        } else {
            MV.addObject("mensaje", "Médico no encontrado.");
        }

        MV.addObject("listaMedicos", medicoNegocio.readAll());
        MV.addObject("listaEspecialidades", especialidadNegocio.readAll());
        return MV;
    }
	@RequestMapping("ABM_Medico.html")
	public ModelAndView eventoVerMedico(@RequestParam("matricula") Long matricula) {
		ModelAndView MV = new ModelAndView();
		System.out.println("LLEGO A VER detalle Medico");
		
		medico = medicoNegocio.readOne(matricula);		
		if (medico != null) {
            MV.addObject("medico", medico);
            List<Usuario> listaUsuarios2 = usuarioNegocio.readAll();
            for (Usuario usuario2 : listaUsuarios2) {
                if (usuario2.getUsuario().equals(medico.getUsuario().getUsuario())) {
                	System.out.println(usuario2 + "USUAAAAAAAAAAAAAAAAAAAAAAAAARIO COMPARACIO - Agregue el Usuario" + usuario);
                	 MV.addObject("usuario", usuario2);
                }
            }	          
            MV.addObject("mostrarModal", true);
        } else {
            MV.addObject("mensaje", "Médico no encontrado");
            MV.addObject("mostrarModal", false);
        }
        MV.addObject("listaMedicos", medicoNegocio.readAll());
        MV.addObject("listaEspecialidades", especialidadNegocio.readAll());
        return MV;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("alta_medico.html")
	public ModelAndView eventoAltaPaciente(		
		@RequestParam("txtUSERID") String userid,
		@RequestParam("txtCLAVE")String clave,		
		@RequestParam("txtCLAVE2")String clave2,	
		@RequestParam("txtNOMBRE") String nombre,
		@RequestParam("txtAPELLIDO")String apellido,
		@RequestParam("txtFECHA_NAC")String fechaNac,
		@RequestParam("email")String email,
		@RequestParam("especialidad")String especialidadID,
		@RequestParam("telefono")String telefono,
		@RequestParam("horario")String horarioid
			
			) {
		ModelAndView MV = new ModelAndView();
		String mensaje = null;
		
		usuario.setUsuario(userid);
		usuario.setContraseña(clave);
		List<Usuario> listaUsuarios = usuarioNegocio.readAll();
		  for (Usuario usuario : listaUsuarios) {
			  System.out.println(usuario.getUsuario() + userid);
	            if (usuario.getUsuario().equals(userid)) {
	            	
	            	//MV.addObject("mensaje", "DNI repetido - No se puede dar de Alta modifique registro en BD");
	            	MV.setViewName("redirect:/ABM_medico.html");
	            	MV.addObject("listaMedicos", medicoNegocio.readAll());
	            	System.out.println("DNI repetido - No se puede dar de Alta modifique registro en BD");
	
	            	return MV;
	            }
	  
	        }		
		if(mensaje==null)
		{
		usuarioNegocio.add(usuario);
				System.out.println("Agregue el Usuario");
				
				System.out.println("Todos los usuarios : " + listaUsuarios);
				// Buscar el usuario en la lista
				
		        for (Usuario usuario : listaUsuarios) {
		            if (usuario.getUsuario().equals(userid)) {
		            	System.out.println(userid + "USUARIO COMPARACIO - Agregue el Usuario" + usuario);
		            	medico.setUsuario(usuario);
		            }
		        }		
				medico.setNombre(nombre);
				medico.setApellido(apellido);
					LocalDate fecha = LocalDate.parse(fechaNac);
					medico.setFechaNacimiento(fecha);
					medico.setEmail(email);
				medico.setTelefono(telefono);
				//Especialidad objespec = new Especialidad();
				List<Especialidad> listaespecialidad = especialidadNegocio.readAll();
				for (Especialidad especialidad2 : listaespecialidad) {
					if (especialidad2.getEspecialidad_id() == Integer.parseInt(especialidadID)) {
		            	System.out.println(especialidad2 + "ESPECIALIDAD COMPARACIO - Agregue el ESPE" + especialidadID);
		            	medico.setEspecialidad(especialidad2);
		            }
				}
				
				
				
				medico.setEstado(true);
				System.out.println("LLEGO A alta  medicooooooo" + medico);
		
					medicoNegocio.add(medico);
					
					List<Medico> listaMedicos = medicoNegocio.readAll();
					 for (Medico medico : listaMedicos) {
				            if (medico.getUsuario().equals(userid)) {
				            	//Horarios
								List<Horario> listahorarios = horarioNegocio.readAll();
								for (Horario horario : listahorarios) {
									if (horario.getId() == Integer.parseInt(horarioid)) {
						            	System.out.println(horario + "HORARIOS COMPARACIO - Agregue el ESPE" + horarioid);
						            	medico.setHorarios((Set<Horario>) horario);
						            }
								}
								medicoNegocio.update(medico);
				            }
				        }		
					
					
					
				
				//medicoNegocio.add(medico);
				//MV.addObject("listaPacientes", medicoNegocio.readAll());
				MV.setViewName("redirect:/ABM_medico.html");
				return MV;
		}
		else
		{
			return MV;
		}
		
	
	}
}
