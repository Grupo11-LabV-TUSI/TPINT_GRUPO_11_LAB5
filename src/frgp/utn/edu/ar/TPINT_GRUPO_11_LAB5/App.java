package frgp.utn.edu.ar.TPINT_GRUPO_11_LAB5;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Horario;
import frgp.utn.edu.ar.entidad.Localidad;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Provincia;
import frgp.utn.edu.ar.entidad.Turno;
import frgp.utn.edu.ar.entidad.Usuario;
import frgp.utn.edu.ar.enums.EDiaHorario;
import frgp.utn.edu.ar.negocioImpl.EspecialidadNegocio;
import frgp.utn.edu.ar.negocioImpl.HorarioNegocio;
import frgp.utn.edu.ar.negocioImpl.LocalidadNegocio;
import frgp.utn.edu.ar.negocioImpl.MedicoNegocio;
import frgp.utn.edu.ar.negocioImpl.PacienteNegocio;
import frgp.utn.edu.ar.negocioImpl.ProvinciaNegocio;
import frgp.utn.edu.ar.negocioImpl.TurnoNegocio;
import frgp.utn.edu.ar.negocioImpl.UsuarioNegocio;
import frgp.utn.edu.ar.resources.Config;

public class App {
	private final static String MENSAJE_AGREGADO = "AGREGADO CORRECTAMENTE";
	private final static String MENSAJE_YA_EXISTE = "YA EXISTE EN LA BASE DE DATOS";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
		boolean estado = false;

		/** Carga de datos */
		
		// Paciente
		PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("PacienteNegocioBean");
		Paciente paciente = (Paciente) appContext.getBean("PacienteBean");
		for (int i = 0; i < 15; i++) {
			paciente.setDni(10000000+(i+1));
			try {
				estado = pacienteNegocio.add(paciente);
				// System.out.println(MENSAJE_AGREGADO);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				System.out.println(paciente.toString());
				System.out.println(MENSAJE_YA_EXISTE);
			}
		}

		// Especialidad
		EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("EspecialidadNegocioBean");
		Especialidad especialidad = (Especialidad) appContext.getBean("EspecialidadBean");
		for (int i = 0; i < 15; i++) {
			especialidad.setNombre("Especialidad"+(i+1));
			try {
				estado = especialidadNegocio.add(especialidad);
				// System.out.println(MENSAJE_AGREGADO);
			} catch (Exception e) {
				// TODO: handle exception
				// System.err.println(MENSAJE_YA_EXISTE);
				e.printStackTrace();
			} finally {
				System.out.println(especialidad.toString());
				System.out.println(MENSAJE_YA_EXISTE);
			}
		}

		// Usuario
		UsuarioNegocio usuarioNegocio = (UsuarioNegocio) appContext.getBean("UsuarioNegocioBean");
		Usuario usuario = (Usuario) appContext.getBean("UsuarioBean");
		for (int i = 0; i < 15; i++) {
			usuario.setUsuario("Usuario"+(i+1));
			usuario.setContraseña("Clave1234");			
			try {
				estado = usuarioNegocio.add(usuario);
				// System.out.println(MENSAJE_AGREGADO);
			} catch (Exception e) {
				// TODO: handle exception
				// System.err.println(MENSAJE_YA_EXISTE);
				e.printStackTrace();
			} finally {
				System.out.println(usuario.toString());
				System.out.println(MENSAJE_YA_EXISTE);
			}
		}

		// Horario
		HorarioNegocio horarioNegocio = (HorarioNegocio) appContext.getBean("HorarioNegocioBean");
		Horario horario = (Horario) appContext.getBean("HorarioBean");
		for (int i = 1; i <= 5; i++) {
			Set<Horario> setHorario = new HashSet<Horario>();
			horario.setDia(EDiaHorario.getByIndex(i));
			horario.setHoraInicio(LocalTime.of(8, 0));
			horario.setHoraFin(LocalTime.of(16, 0));
			setHorario.add(horario);
			try {
				estado = horarioNegocio.add(horario);
				// System.out.println(MENSAJE_AGREGADO);
			} catch (Exception e) {
				// TODO: handle exception
				// System.err.println(MENSAJE_YA_EXISTE);
				e.printStackTrace();
			} finally {
				for (Horario horario2 : setHorario) {
					System.out.println(horario2.toString());
				}
				System.out.println(MENSAJE_YA_EXISTE);
			}
		}
		for (int i = 1; i <= 5; i++) {
			Set<Horario> setHorario = new HashSet<Horario>();
			horario.setDia(EDiaHorario.getByIndex(i));
			horario.setHoraInicio(LocalTime.of(8, 0));
			horario.setHoraFin(LocalTime.of(12, 0));
			setHorario.add(horario);
			try {
				estado = horarioNegocio.add(horario);
				// System.out.println(MENSAJE_AGREGADO);
			} catch (Exception e) {
				// TODO: handle exception
				// System.err.println(MENSAJE_YA_EXISTE);
				e.printStackTrace();
			} finally {
				for (Horario horario2 : setHorario) {
					System.out.println(horario2.toString());
				}
				System.out.println(MENSAJE_YA_EXISTE);
			}
		}
		for (int i = 1; i <= 5; i++) {
			Set<Horario> setHorario = new HashSet<Horario>();
			horario.setDia(EDiaHorario.getByIndex(i));
			horario.setHoraInicio(LocalTime.of(12, 0));
			horario.setHoraFin(LocalTime.of(16, 0));
			setHorario.add(horario);
			try {
				estado = horarioNegocio.add(horario);
				// System.out.println(MENSAJE_AGREGADO);
			} catch (Exception e) {
				// TODO: handle exception
				// System.err.println(MENSAJE_YA_EXISTE);
				e.printStackTrace();
			} finally {
				for (Horario horario2 : setHorario) {
					System.out.println(horario2.toString());
				}
				System.out.println(MENSAJE_YA_EXISTE);
			}
		}

		// Medico
		MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("MedicoNegocioBean");
		Medico medico = (Medico) appContext.getBean("MedicoBean");
		for (int i = 0; i < 15; i++) {
			medico.setNombre("nombreMedico"+(i+1));
			medico.setUsuario(usuarioNegocio.readOne(i+1L));
			medico.setEspecialidad(especialidadNegocio.readOne(i+1));
			Set<Horario> setHorario = new HashSet<Horario>();
			setHorario.add(horarioNegocio.readOne(i+1));
			medico.setHorarios(setHorario);
			try {
				estado = medicoNegocio.add(medico);
				// System.out.println(MENSAJE_AGREGADO);
			} catch (Exception e) {
				// TODO: handle exception
				// System.err.println(MENSAJE_YA_EXISTE);
				e.printStackTrace();
			} finally {
				System.out.println(medico.toString());
				System.out.println(MENSAJE_YA_EXISTE);
			}
		}

		// Turno
		TurnoNegocio turnoNegocio = (TurnoNegocio) appContext.getBean("TurnoNegocioBean");
		Turno turno = (Turno) appContext.getBean("TurnoBean");
		for (int i = 0; i < 15; i++) {
			medico = medicoNegocio.readOne(i+1L);
			paciente = pacienteNegocio.readOne(10000000+(i+1));
			turno.setMedico(medico);
			turno.setPaciente(paciente);
			try {
				estado = turnoNegocio.add(turno);
				// System.out.println(MENSAJE_AGREGADO);
			} catch (Exception e) {
				// TODO: handle exception
				// System.err.println(MENSAJE_YA_EXISTE);
				e.printStackTrace();
			} finally {
				System.out.println(turno.toString());
				System.out.println(MENSAJE_YA_EXISTE);
			}
		}		
		
		// Usuario ADMIN
		usuario = (Usuario) appContext.getBean("UsuarioBean");
		usuario.setUsuario("Admin");
		usuario.setContraseña("Clave1234");
		try {
			estado = usuarioNegocio.add(usuario);
			// System.out.println(MENSAJE_AGREGADO);
		} catch (Exception e) {
			// TODO: handle exception
			// System.err.println(MENSAJE_YA_EXISTE);
			e.printStackTrace();
		} finally {
			System.out.println(usuario.toString());
			System.out.println(MENSAJE_YA_EXISTE);
		}

		

		// Provincia
		ProvinciaNegocio provinciaNegocio = (ProvinciaNegocio) appContext.getBean("ProvinciaNegocioBean");
		Provincia provincia = (Provincia) appContext.getBean("ProvinciaBean");
		int idProvincia; 
		String descripcion;
		idProvincia = 1;
        descripcion = "Buenos Aires";
        provincia.setIdProvincia(idProvincia);
        provincia.setDescripcion(descripcion);
        provinciaNegocio.add(provincia);

        idProvincia = 2;
        descripcion = "Buenos Aires-GBA";
        provincia.setIdProvincia(idProvincia);
        provincia.setDescripcion(descripcion);
        provinciaNegocio.add(provincia);

        idProvincia = 3;
        descripcion = "Capital Federal";
        provincia.setIdProvincia(idProvincia);
        provincia.setDescripcion(descripcion);
        provinciaNegocio.add(provincia);

        idProvincia = 4;
        descripcion = "Catamarca";
        provincia.setIdProvincia(idProvincia);
        provincia.setDescripcion(descripcion);
        provinciaNegocio.add(provincia);

        idProvincia = 5;
        descripcion = "Chaco";
        provincia.setIdProvincia(idProvincia);
        provincia.setDescripcion(descripcion);
        provinciaNegocio.add(provincia);

        idProvincia = 6;
        descripcion = "Chubut";
        provincia.setIdProvincia(idProvincia);
        provincia.setDescripcion(descripcion);
        provinciaNegocio.add(provincia);

        idProvincia = 7;
        descripcion = "Córdoba";
        provincia.setIdProvincia(idProvincia);
        provincia.setDescripcion(descripcion);
        provinciaNegocio.add(provincia);

        idProvincia = 8;
        descripcion = "Corrientes";
        provincia.setIdProvincia(idProvincia);
        provincia.setDescripcion(descripcion);
        provinciaNegocio.add(provincia);

        idProvincia = 9;
        descripcion = "Entre Ríos";
        provincia.setIdProvincia(idProvincia);
        provincia.setDescripcion(descripcion);
        provinciaNegocio.add(provincia);

        idProvincia = 10;
        descripcion = "Formosa";
        provincia.setIdProvincia(idProvincia);
        provincia.setDescripcion(descripcion);
        provinciaNegocio.add(provincia);

        idProvincia = 11;
        descripcion = "Jujuy";
        provincia.setIdProvincia(idProvincia);
        provincia.setDescripcion(descripcion);
        provinciaNegocio.add(provincia);

        idProvincia = 12;
        descripcion = "La Pampa";
        provincia.setIdProvincia(idProvincia);
        provincia.setDescripcion(descripcion);
        provinciaNegocio.add(provincia);

        idProvincia = 13;
        descripcion = "La Rioja";
        provincia.setIdProvincia(idProvincia);
        provincia.setDescripcion(descripcion);
        provinciaNegocio.add(provincia);

        idProvincia = 14;
        descripcion = "Mendoza";
        provincia.setIdProvincia(idProvincia);
        provincia.setDescripcion(descripcion);
        provinciaNegocio.add(provincia);

        idProvincia = 15;
        descripcion = "Misiones";
        provincia.setIdProvincia(idProvincia);
        provincia.setDescripcion(descripcion);
        provinciaNegocio.add(provincia);

        idProvincia = 16;
        descripcion = "Neuquén";
        provincia.setIdProvincia(idProvincia);
        provincia.setDescripcion(descripcion);
        provinciaNegocio.add(provincia);

        idProvincia = 17;
        descripcion = "Río Negro";
        provincia.setIdProvincia(idProvincia);
        provincia.setDescripcion(descripcion);
        provinciaNegocio.add(provincia);

        idProvincia = 18;
        descripcion = "Salta";
        provincia.setIdProvincia(idProvincia);
        provincia.setDescripcion(descripcion);
        provinciaNegocio.add(provincia);

        idProvincia = 19;
        descripcion = "San Juan";
        provincia.setIdProvincia(idProvincia);
        provincia.setDescripcion(descripcion);
        provinciaNegocio.add(provincia);

        idProvincia = 20;
        descripcion = "San Luis";
        provincia.setIdProvincia(idProvincia);
        provincia.setDescripcion(descripcion);
        provinciaNegocio.add(provincia);

        idProvincia = 21;
        descripcion = "Santa Cruz";
        provincia.setIdProvincia(idProvincia);
        provincia.setDescripcion(descripcion);
        provinciaNegocio.add(provincia);

        idProvincia = 22;
        descripcion = "Santa Fe";
        provincia.setIdProvincia(idProvincia);
        provincia.setDescripcion(descripcion);
        provinciaNegocio.add(provincia);

        idProvincia = 23;
        descripcion = "Santiago del Estero";
        provincia.setIdProvincia(idProvincia);
        provincia.setDescripcion(descripcion);
        provinciaNegocio.add(provincia);

        idProvincia = 24;
        descripcion = "Tierra del Fuego";
        provincia.setIdProvincia(idProvincia);
        provincia.setDescripcion(descripcion);
        provinciaNegocio.add(provincia);

        idProvincia = 25;
        descripcion = "Tucumán";
        provincia.setIdProvincia(idProvincia);
        provincia.setDescripcion(descripcion);
        provinciaNegocio.add(provincia);
    
     // Localidades
     		LocalidadNegocio localidadNegocio = (LocalidadNegocio) appContext.getBean("LocalidadNegocioBean");
     		Localidad localidad = (Localidad) appContext.getBean("LocalidadBean");
     		int idLocalidad;
     		
     		
     		
     		
     	

     		idLocalidad = 1;
     		idProvincia = 1;
     		descripcion = "25 de Mayo";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 2;
     		idProvincia = 1;
     		descripcion = "3 de febrero";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 3;
     		idProvincia = 1;
     		descripcion = "A. Alsina";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 4;
     		idProvincia = 1;
     		descripcion = "A. Gonzáles Cháves";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 5;
     		idProvincia = 1;
     		descripcion = "Aguas Verdes";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 6;
     		idProvincia = 1;
     		descripcion = "Alberti";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 7;
     		idProvincia = 1;
     		descripcion = "Arrecifes";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 8;
     		idProvincia = 1;
     		descripcion = "Ayacucho";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 9;
     		idProvincia = 1;
     		descripcion = "Azul";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 10;
     		idProvincia = 1;
     		descripcion = "Bahía Blanca";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 11;
     		idProvincia = 1;
     		descripcion = "Balcarce";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 12;
     		idProvincia = 1;
     		descripcion = "Baradero";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 13;
     		idProvincia = 1;
     		descripcion = "Benito Juárez";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 14;
     		idProvincia = 1;
     		descripcion = "Berisso";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 15;
     		idProvincia = 1;
     		descripcion = "Bolívar";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 16;
     		idProvincia = 1;
     		descripcion = "Bragado";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 17;
     		idProvincia = 1;
     		descripcion = "Brandsen";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 18;
     		idProvincia = 1;
     		descripcion = "Campana";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 19;
     		idProvincia = 1;
     		descripcion = "Cañuelas";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 20;
     		idProvincia = 1;
     		descripcion = "Capilla del Señor";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 21;
     		idProvincia = 1;
     		descripcion = "Capitán Sarmiento";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 22;
     		idProvincia = 1;
     		descripcion = "Carapachay";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 23;
     		idProvincia = 1;
     		descripcion = "Carhue";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 24;
     		idProvincia = 1;
     		descripcion = "Cariló";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 25;
     		idProvincia = 1;
     		descripcion = "Carlos Casares";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 26;
     		idProvincia = 1;
     		descripcion = "Carlos Tejedor";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 27;
     		idProvincia = 1;
     		descripcion = "Carmen de Areco";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 28;
     		idProvincia = 1;
     		descripcion = "Carmen de Patagones";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 29;
     		idProvincia = 1;
     		descripcion = "Castelli";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 30;
     		idProvincia = 1;
     		descripcion = "Chacabuco";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 31;
     		idProvincia = 1;
     		descripcion = "Chascomús";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 32;
     		idProvincia = 1;
     		descripcion = "Chivilcoy";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 33;
     		idProvincia = 1;
     		descripcion = "Colón";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 34;
     		idProvincia = 1;
     		descripcion = "Coronel Dorrego";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 35;
     		idProvincia = 1;
     		descripcion = "Coronel Pringles";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 36;
     		idProvincia = 1;
     		descripcion = "Coronel Rosales";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 37;
     		idProvincia = 1;
     		descripcion = "Coronel Suarez";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 38;
     		idProvincia = 1;
     		descripcion = "Costa Azul";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 39;
     		idProvincia = 1;
     		descripcion = "Costa Chica";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 40;
     		idProvincia = 1;
     		descripcion = "Costa del Este";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 41;
     		idProvincia = 1;
     		descripcion = "Costa Esmeralda";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 42;
     		idProvincia = 1;
     		descripcion = "Daireaux";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 43;
     		idProvincia = 1;
     		descripcion = "Darregueira";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 44;
     		idProvincia = 1;
     		descripcion = "Del Viso";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 45;
     		idProvincia = 1;
     		descripcion = "Dolores";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 46;
     		idProvincia = 1;
     		descripcion = "Don Torcuato";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 47;
     		idProvincia = 1;
     		descripcion = "Ensenada";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 48;
     		idProvincia = 1;
     		descripcion = "Escobar";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 49;
     		idProvincia = 1;
     		descripcion = "Exaltación de la Cruz";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 50;
     		idProvincia = 1;
     		descripcion = "Florentino Ameghino";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 51;
     		idProvincia = 1;
     		descripcion = "Garín";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 52;
     		idProvincia = 1;
     		descripcion = "Gral. Alvarado";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 53;
     		idProvincia = 1;
     		descripcion = "Gral. Alvear";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 54;
     		idProvincia = 1;
     		descripcion = "Gral. Arenales";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 55;
     		idProvincia = 1;
     		descripcion = "Gral. Belgrano";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 56;
     		idProvincia = 1;
     		descripcion = "Gral. Guido";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 57;
     		idProvincia = 1;
     		descripcion = "Gral. Lamadrid";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 58;
     		idProvincia = 1;
     		descripcion = "Gral. Las Heras";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 59;
     		idProvincia = 1;
     		descripcion = "Gral. Lavalle";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 60;
     		idProvincia = 1;
     		descripcion = "Gral. Madariaga";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 61;
     		idProvincia = 1;
     		descripcion = "Gral. Pacheco";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 62;
     		idProvincia = 1;
     		descripcion = "Gral. Paz";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 63;
     		idProvincia = 1;
     		descripcion = "Gral. Pinto";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 64;
     		idProvincia = 1;
     		descripcion = "Gral. Pueyrredón";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 65;
     		idProvincia = 1;
     		descripcion = "Gral. Rodríguez";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);


     		idLocalidad = 74;
     		idProvincia = 11;
     		descripcion = "Laprida";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 75;
     		idProvincia = 16;
     		descripcion = "Las Flores";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 76;
     		idProvincia = 20;
     		descripcion = "Las Toninas";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 77;
     		idProvincia = 24;
     		descripcion = "Leandro N. Alem";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 78;
     		idProvincia = 23;
     		descripcion = "Lincoln";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);













     		idLocalidad = 79;
     		idProvincia = 25;
     		descripcion = "Loberia";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 80;
     		idProvincia = 23;
     		descripcion = "Lobos";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 81;
     		idProvincia = 5;
     		descripcion = "Los Cardales";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 82;
     		idProvincia = 7;
     		descripcion = "Los Toldos";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 83;
     		idProvincia = 23;
     		descripcion = "Lucila del Mar";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 84;
     		idProvincia = 14;
     		descripcion = "Luján";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 85;
     		idProvincia = 12;
     		descripcion = "Magdalena";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 86;
     		idProvincia = 6;
     		descripcion = "Maipú";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 87;
     		idProvincia = 18;
     		descripcion = "Mar Chiquita";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 88;
     		idProvincia = 15;
     		descripcion = "Mar de Ajó";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 89;
     		idProvincia = 12;
     		descripcion = "Mar de las Pampas";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 90;
     		idProvincia = 22;
     		descripcion = "Mar del Plata";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 91;
     		idProvincia = 23;
     		descripcion = "Mar del Tuyú";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 92;
     		idProvincia = 5;
     		descripcion = "Marcos Paz";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 93;
     		idProvincia = 7;
     		descripcion = "Mercedes";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 94;
     		idProvincia = 11;
     		descripcion = "Miramar";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 95;
     		idProvincia = 15;
     		descripcion = "Monte";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 96;
     		idProvincia = 23;
     		descripcion = "Monte Hermoso";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 97;
     		idProvincia = 6;
     		descripcion = "Munro";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 98;
     		idProvincia = 18;
     		descripcion = "Navarro";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 99;
     		idProvincia = 13;
     		descripcion = "Necochea";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 100;
     		idProvincia = 6;
     		descripcion = "Olavarría";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 101;
     		idProvincia = 16;
     		descripcion = "Partido de la Costa";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 102;
     		idProvincia = 24;
     		descripcion = "Pehuajó";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 103;
     		idProvincia = 16;
     		descripcion = "Pellegrini";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 104;
     		idProvincia = 5;
     		descripcion = "Pergamino";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 105;
     		idProvincia = 14;
     		descripcion = "Pigüé";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 106;
     		idProvincia = 12;
     		descripcion = "Pila";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 107;
     		idProvincia = 24;
     		descripcion = "Pilar";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 108;
     		idProvincia = 5;
     		descripcion = "Pinamar";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 109;
     		idProvincia = 4;
     		descripcion = "Pinar del Sol";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 110;
     		idProvincia = 14;
     		descripcion = "Polvorines";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 111;
     		idProvincia = 7;
     		descripcion = "Pte. Perón";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 112;
     		idProvincia = 20;
     		descripcion = "Puán";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 113;
     		idProvincia = 23;
     		descripcion = "Punta Indio";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 114;
     		idProvincia = 9;
     		descripcion = "Ramallo";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 115;
     		idProvincia = 3;
     		descripcion = "Rauch";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 116;
     		idProvincia = 18;
     		descripcion = "Rivadavia";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 117;
     		idProvincia = 13;
     		descripcion = "Rojas";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 118;
     		idProvincia = 4;
     		descripcion = "Roque Pérez";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 119;
     		idProvincia = 23;
     		descripcion = "Saavedra";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 120;
     		idProvincia = 3;
     		descripcion = "Saladillo";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 121;
     		idProvincia = 20;
     		descripcion = "Salliqueló";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 122;
     		idProvincia = 18;
     		descripcion = "Salto";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 123;
     		idProvincia = 12;
     		descripcion = "San Andrés de Giles";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 124;
     		idProvincia = 22;
     		descripcion = "San Antonio de Areco";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 125;
     		idProvincia = 22;
     		descripcion = "San Antonio de Padua";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 126;
     		idProvincia = 3;
     		descripcion = "San Bernardo";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 127;
     		idProvincia = 13;
     		descripcion = "San Cayetano";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 128;
     		idProvincia = 9;
     		descripcion = "San Clemente del Tuyú";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 129;
     		idProvincia = 3;
     		descripcion = "San Nicolás";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 130;
     		idProvincia = 23;
     		descripcion = "San Pedro";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 131;
     		idProvincia = 4;
     		descripcion = "San Vicente";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 132;
     		idProvincia = 24;
     		descripcion = "Santa Teresita";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 133;
     		idProvincia = 4;
     		descripcion = "Suipacha";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 134;
     		idProvincia = 15;
     		descripcion = "Tandil";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 135;
     		idProvincia = 9;
     		descripcion = "Tapalqué";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 136;
     		idProvincia = 21;
     		descripcion = "Tordillo";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 137;
     		idProvincia = 24;
     		descripcion = "Tornquist";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 138;
     		idProvincia = 23;
     		descripcion = "Trenque Lauquen";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 139;
     		idProvincia = 24;
     		descripcion = "Tres Lomas";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 140;
     		idProvincia = 15;
     		descripcion = "Villa Gesell";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 141;
     		idProvincia = 4;
     		descripcion = "Villarino";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 142;
     		idProvincia = 13;
     		descripcion = "Zárate";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 143;
     		idProvincia = 19;
     		descripcion = "11 de Septiembre";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 144;
     		idProvincia = 5;
     		descripcion = "20 de Junio";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 145;
     		idProvincia = 22;
     		descripcion = "25 de Mayo";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 146;
     		idProvincia = 8;
     		descripcion = "Acassuso";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 147;
     		idProvincia = 18;
     		descripcion = "Adrogué";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 148;
     		idProvincia = 4;
     		descripcion = "Aldo Bonzi";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 149;
     		idProvincia = 17;
     		descripcion = "Área Reserva Cinturón Ecológico";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 150;
     		idProvincia = 21;
     		descripcion = "Avellaneda";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 151;
     		idProvincia = 11;
     		descripcion = "Banfield";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 152;
     		idProvincia = 14;
     		descripcion = "Barrio Parque";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 153;
     		idProvincia = 22;
     		descripcion = "Barrio Santa Teresita";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 154;
     		idProvincia = 23;
     		descripcion = "Beccar";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 155;
     		idProvincia = 20;
     		descripcion = "Bella Vista";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 156;
     		idProvincia = 22;
     		descripcion = "Berazategui";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 157;
     		idProvincia = 7;
     		descripcion = "Bernal Este";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 158;
     		idProvincia = 8;
     		descripcion = "Bernal Oeste";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 159;
     		idProvincia = 11;
     		descripcion = "Billinghurst";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 160;
     		idProvincia = 5;
     		descripcion = "Boulogne";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 161;
     		idProvincia = 22;
     		descripcion = "Burzaco";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 162;
     		idProvincia = 12;
     		descripcion = "Carapachay";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 163;
     		idProvincia = 11;
     		descripcion = "Caseros";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 164;
     		idProvincia = 4;
     		descripcion = "Castelar";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 165;
     		idProvincia = 5;
     		descripcion = "Churruca";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 166;
     		idProvincia = 3;
     		descripcion = "Ciudad Evita";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);

     		idLocalidad = 167;
     		idProvincia = 4;
     		descripcion = "Ciudad Madero";
     		localidad.setDescripcion(descripcion);
     		localidad.setIdLocalidad(idLocalidad);
     		provincia.setIdProvincia(idProvincia);
     		localidad.setProvincia(provincia);
     		localidadNegocio.add(localidad);


		
		
	}

}
