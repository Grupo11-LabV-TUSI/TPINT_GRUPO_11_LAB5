package frgp.utn.edu.ar.controller;

import java.time.LocalDate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Localidad;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Provincia;
import frgp.utn.edu.ar.entidad.Turno;
import frgp.utn.edu.ar.entidad.Usuario;
import frgp.utn.edu.ar.negocioImpl.LocalidadNegocio;
import frgp.utn.edu.ar.negocioImpl.MedicoNegocio;
import frgp.utn.edu.ar.negocioImpl.PacienteNegocio;
import frgp.utn.edu.ar.negocioImpl.ProvinciaNegocio;
import frgp.utn.edu.ar.negocioImpl.TurnoNegocio;
import frgp.utn.edu.ar.negocioImpl.UsuarioNegocio;
import frgp.utn.edu.ar.resources.Config;

@Controller
public class PacienteController {
	
	
	
	/** Importacion de Servicios */
	ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);

	/* Paciente */
	PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("PacienteNegocioBean");
	Paciente paciente = (Paciente) appContext.getBean("PacienteBean");
	
	
	ProvinciaNegocio provinciaNegocio = (ProvinciaNegocio)appContext.getBean("ProvinciaNegocioBean");
	Provincia provincia = (Provincia)appContext.getBean("ProvinciaBean");
	
	LocalidadNegocio localidadNegocio = (LocalidadNegocio)appContext.getBean("LocalidadNegocioBean");
	Localidad localidad = (Localidad)appContext.getBean("LocalidadBean");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/** abml */
	// Ver paciente
	@RequestMapping("ABML_paciente.html")
	public ModelAndView ABML_paciente() {
		ModelAndView MV = new ModelAndView();
		MV.addObject("listaPacientes", pacienteNegocio.readAll());
		
		System.out.println("LLEGO AL ABML PACIENTE");
		
		MV.setViewName("ABML_Paciente");
		return MV;
	}
	
	@RequestMapping("actualizar_estado_paciente.html")
	public ModelAndView eventoActualizarEstado(@RequestParam("dni") int dni, @RequestParam("btnEstado") String btnEstado)
	{
		ModelAndView MV = new ModelAndView();
		paciente = pacienteNegocio.readOne(dni);

		String mensaje = "No se puedo actualizar paciente inexistente";
		System.out.println("LLLLLLLLLLLLLLLEEEEEGo0 a actualizar paciente");
		System.out.println(paciente.toString()); 
		
		
		
			
			MV.addObject("estadoUpdatePaciente", mensaje);
			
		
		if(btnEstado.equals("Alta")) {
			
			paciente.setEstado(false);
		}
		else{
			
			paciente.setEstado(true);

		}
		pacienteNegocio.update(paciente);
		mensaje = "Actualizado correctamente";
		
		MV.addObject("estadoUpdatePaciente", mensaje);
	
		MV.addObject("listaPacientes", pacienteNegocio.readAll());

		MV.setViewName("ABML_Paciente");
		
		System.out.println("actualiceeeeeeeeeeeeeeeeeeeeeeeeee");
		
		System.out.println(paciente.toString()); 
		
		return MV;
	}
	
	
	@RequestMapping("ver_detalle_paciente.html")
	public ModelAndView eventoVerPaciente(@RequestParam("dni") int dni) {
		ModelAndView MV = new ModelAndView();
		System.out.println("LLEGO A VER detalle paciente");
		paciente = pacienteNegocio.readOne(dni);
		
		MV.addObject("detalles_paci",paciente);
		
		System.out.println(paciente);
		MV.setViewName("detalle_paciente");
		return MV;
	}
	
	
	@RequestMapping("alta_paciente.html")
	public ModelAndView eventoAltaPaciente(
		@RequestParam("txtDNI") int dni,
		@RequestParam("txtNOMBRE") String nombre,
		@RequestParam("txtAPELLIDO")String apellido,
		@RequestParam("txtFECHA_NAC")String fechaNac,
		@RequestParam("txtDIRECCION")String direccion,
		@RequestParam("textEMAIL")String email,
		@RequestParam("txtTELEFONO")String telefono,
		@RequestParam("txtLocalidad")String localidad
			
			) {
		ModelAndView MV = new ModelAndView();
		
		System.out.println("LLEGO A alta  paciente");
		paciente.setDni(dni);
		paciente.setNombre(nombre);
		paciente.setApellido(apellido);
			LocalDate fecha = LocalDate.parse(fechaNac);
		paciente.setFecha_nacimiento(fecha);
		paciente.setDireccion(direccion);
		paciente.setEmail(email);
		paciente.setTelefono(telefono);
		paciente.setLocalidad(localidad);
		pacienteNegocio.add(paciente);
		MV.addObject("listaPacientes", pacienteNegocio.readAll());
		MV.setViewName("ABML_Paciente");
		
		
		return MV;
	}
	
	
	
	
	@RequestMapping("modificar_paciente.html")
	public ModelAndView eventoModificarPaciente(@RequestParam("dni") int dni)
	{
		ModelAndView MV = new ModelAndView();
		System.out.println("LLEGO A VER captura paciente paciente");
		paciente = pacienteNegocio.readOne(dni);
		
		MV.addObject("paciente",paciente);
		
		System.out.println(paciente);
		MV.setViewName("modificar_paciente");
		return MV;
	}
	
	@RequestMapping("actualizar_paciente.html")
	public ModelAndView eventoActualizarPaciente(
			@RequestParam("txtDNI") int dni,
			@RequestParam("txtNOMBRE") String nombre,
			@RequestParam("txtAPELLIDO")String apellido,
			@RequestParam("txtFECHA_NAC")String fechaNac,
			@RequestParam("txtDIRECCION")String direccion,
			@RequestParam("textEMAIL")String email,
			@RequestParam("txtTELEFONO")String telefono,
			@RequestParam("txtLocalidad")String localidad,
			@RequestParam("txtProvincia") String provincia
				
	)
	{
	ModelAndView MV = new ModelAndView();
	
	System.out.println("LLEGO A alta  paciente");
	paciente.setDni(dni);
	paciente.setNombre(nombre);
	paciente.setApellido(apellido);
		LocalDate fecha = LocalDate.parse(fechaNac);
	paciente.setFecha_nacimiento(fecha);
	paciente.setDireccion(direccion);
	paciente.setEmail(email);
	paciente.setTelefono(telefono);
	paciente.setLocalidad(localidad);
	paciente.setProvincia(provincia);
	pacienteNegocio.update(paciente);
	
	MV.addObject("listaPacientes", pacienteNegocio.readAll());
	MV.setViewName("ABML_Paciente");
	
	return MV;
	}
	/*
	@RequestMapping("alta_paciente.html")
	public ModelAndView eventoAltaPaciente(
		@RequestParam("txtDNI") int dni,
		@RequestParam("txtNOMBRE") String nombre,
		@RequestParam("txtAPELLIDO")String apellido,
		@RequestParam("txtFECHA_NAC")String fechaNac,
		@RequestParam("txtDIRECCION")String direccion,
		@RequestParam("textEMAIL")String email,
		@RequestParam("txtTELEFONO")String telefono,
		@RequestParam("txtLocalidad")String localidad
			
			) {
		ModelAndView MV = new ModelAndView();
		
		System.out.println("LLEGO A alta  paciente");
		paciente.setDni(dni);
		paciente.setNombre(nombre);
		paciente.setApellido(apellido);
			LocalDate fecha = LocalDate.parse(fechaNac);
		paciente.setFecha_nacimiento(fecha);
		paciente.setDireccion(direccion);
		paciente.setEmail(email);
		paciente.setTelefono(telefono);
		paciente.setLocalidad(localidad);
		pacienteNegocio.add(paciente);
		MV.addObject("listaPacientes", pacienteNegocio.readAll());
		MV.setViewName("ABML_Paciente");
		
		
		return MV;
	}
	
	
	*/
	
	
}
