package frgp.utn.edu.ar.controller;

import java.time.LocalDate;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
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
		
		List<Provincia> listaProvincias = provinciaNegocio.readAll();
		List<Localidad> listaLocalidades = localidadNegocio.readAll();
		
		MV.addObject("listaProvincias", listaProvincias);
		MV.addObject("listaLocalidades", listaLocalidades);
	
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
		
		
		
			
		
			
		
		if(btnEstado.equals("Alta")) {
			
			paciente.setEstado(false);
		}
		else{
			
			paciente.setEstado(true);

		}
		if(pacienteNegocio.update(paciente)) {
		mensaje = "Actualizado correctamente";
		}
		MV.addObject("mensaje", mensaje);
	
		MV.addObject("listaPacientes", pacienteNegocio.readAll());

		MV.setViewName("ABML_Paciente");
		
		
		
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
		@RequestParam("provinciasTXT")  String provinciasTXT, 
		@RequestParam("localidades") String localidades
			
			) {
		ModelAndView MV = new ModelAndView();
		
		
		System.out.println("LLEGO A alta  paciente");
		paciente.setDni(dni);
		
		System.out.println(dni);
		paciente.setNombre(nombre);
		paciente.setApellido(apellido);
			LocalDate fecha = LocalDate.parse(fechaNac);
		paciente.setFecha_nacimiento(fecha);
		paciente.setDireccion(direccion);
		paciente.setEmail(email);
		paciente.setTelefono(telefono);
		
		
		System.out.println("llego al alta paciente");
		System.out.println(paciente.toString());
		
		paciente.setLocalidad(localidadNegocio.readOne(Integer.parseInt(localidades)).getDescripcion());
		paciente.setProvincia(provinciaNegocio.readOne(Integer.parseInt(provinciasTXT)).getDescripcion());
		

		System.out.println("segunda");
		System.out.println(paciente.toString());
		boolean resultado = false;
		String mensaje = "No Se pudo agregar";
		
		if (pacienteNegocio.readOne(paciente.getDni()) == null){
		
			System.out.println("llegue aca despues del rea 1 ?");
		
		if (resultado = pacienteNegocio.add(paciente)){
			
			mensaje ="Paciente agregado con exito";
			
			
		}
		else  { System.out.println("algo paso aca");}
		}
		else {
			mensaje = "DNI repetido - No se puede dar de Alta modifique registro en BD";
		}
		MV.addObject("mensaje", mensaje);
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
		 int idLocalidadVieja = 0;
		
		List<Provincia> listaProvincias = provinciaNegocio.readAll();
		List<Localidad> listaLocalidades = localidadNegocio.readAll();
		
		for (Localidad localidad : listaLocalidades) {
	        if (localidad.getDescripcion().equals(paciente.getLocalidad())) {
	           
	           idLocalidadVieja = 	localidad.getIdLocalidad(); 
	        }
	    }
		
		MV.addObject("listaProvincias", listaProvincias);
		MV.addObject("listaLocalidades", listaLocalidades);
		MV.addObject("idLocalidadVieja", idLocalidadVieja);
			
		
		
		
		
		MV.addObject("paciente",paciente);
		
		System.out.println(paciente);
		MV.setViewName("modificar_paciente");
		return MV;
	}
	
	
	
	

	
	
	@RequestMapping("formularioAlta_paciente.html")
	public ModelAndView eventoFormularioAltaPaciente()
	{
		ModelAndView MV = new ModelAndView();
		System.out.println("LLEGO A VER captura paciente paciente");
		
		
		
		List<Provincia> listaProvincias = provinciaNegocio.readAll();
		List<Localidad> listaLocalidades = localidadNegocio.readAll();
		
	
		
		MV.addObject("listaProvincias", listaProvincias);
		MV.addObject("listaLocalidades", listaLocalidades);

			

		MV.setViewName("alta_paciente");
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
			@RequestParam("provinciasTXT")  String provinciasTXT, 
			@RequestParam("localidades") String localidades
				
	)
	{
	ModelAndView MV = new ModelAndView();
	
	
	paciente.setDni(dni);
	paciente.setNombre(nombre);
	paciente.setApellido(apellido);
		LocalDate fecha = LocalDate.parse(fechaNac);
	paciente.setFecha_nacimiento(fecha);
	paciente.setDireccion(direccion);
	paciente.setEmail(email);
	paciente.setTelefono(telefono);
	

	System.out.println("llego al alta paciente");
	
	
	paciente.setLocalidad(localidadNegocio.readOne(Integer.parseInt(localidades)).getDescripcion());
	paciente.setProvincia(provinciaNegocio.readOne(Integer.parseInt(provinciasTXT)).getDescripcion());
	
	
	
	String mensaje = "No Se pudo modificar ";
	
	if (pacienteNegocio.update(paciente)){
		
		mensaje ="Paciente modificado con exito";
		
		
	}

	MV.addObject("mensaje", mensaje);

	MV.addObject("listaPacientes", pacienteNegocio.readAll());
	MV.setViewName("ABML_Paciente");
	
	return MV;
	}
	

	
	
	
	
	
}
