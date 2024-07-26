package frgp.utn.edu.ar.TPINT_GRUPO_11_LAB5;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Horario;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.entidad.Turno;
import frgp.utn.edu.ar.entidad.Usuario;
import frgp.utn.edu.ar.enums.EDiaHorario;
import frgp.utn.edu.ar.negocioImpl.EspecialidadNegocio;
import frgp.utn.edu.ar.negocioImpl.HorarioNegocio;
import frgp.utn.edu.ar.negocioImpl.MedicoNegocio;
import frgp.utn.edu.ar.negocioImpl.PacienteNegocio;
import frgp.utn.edu.ar.negocioImpl.TurnoNegocio;
import frgp.utn.edu.ar.negocioImpl.UsuarioNegocio;
import frgp.utn.edu.ar.negocioImpl.LocalidadNegocio;
import frgp.utn.edu.ar.negocioImpl.ProvinciaNegocio;
import frgp.utn.edu.ar.entidad.Localidad;
import frgp.utn.edu.ar.entidad.Provincia;




import frgp.utn.edu.ar.resources.Config;

public class App4 {
	private final static String MENSAJE_AGREGADO = "AGREGADO CORRECTAMENTE";
	private final static String MENSAJE_YA_EXISTE = "YA EXISTE EN LA BASE DE DATOS";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
		
		
		
		boolean estado = false;

		
		PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("PacienteNegocioBean");
		Paciente paciente = (Paciente) appContext.getBean("PacienteBean");
	
		/** Carga de datos */
	
		// Pacientes
		
		
		// Paciente 1
		paciente.setDni(10000001);
		paciente.setNombre("Maria");
		paciente.setApellido("Perez");
		paciente.setEmail("mariaPerez@gmail.com");
		paciente.setTelefono("78451654");
		paciente.setFecha_nacimiento(LocalDate.parse("1995-02-15"));
		paciente.setDireccion("Calle Azul 789");
		paciente.setLocalidad("Los Cardales");
		paciente.setProvincia("Catamarca");
		pacienteNegocio.add(paciente);

		// Paciente 2
		paciente.setDni(10000002);
		paciente.setNombre("Juan");
		paciente.setApellido("Lopez");
		paciente.setEmail("juanLopez@gmail.com");
		paciente.setTelefono("66451654");
		paciente.setFecha_nacimiento(LocalDate.parse("1988-05-10"));
		paciente.setDireccion("Avenida Libertad 123");
		paciente.setLocalidad("Mar Chiquita");
		paciente.setProvincia("Chaco");
		pacienteNegocio.add(paciente);

		// Paciente 3
		paciente.setDni(10000003);
		paciente.setNombre("Lucia");
		paciente.setApellido("Gonzalez");
		paciente.setEmail("luciaGonzalez@gmail.com");
		paciente.setTelefono("55451654");
		paciente.setFecha_nacimiento(LocalDate.parse("2000-03-25"));
		paciente.setDireccion("Calle Rivadavia 456");
		paciente.setLocalidad("Monte");
		paciente.setProvincia("Chubut");
		pacienteNegocio.add(paciente);

		// Paciente 4
		paciente.setDni(10000004);
		paciente.setNombre("Carlos");
		paciente.setApellido("Martinez");
		paciente.setEmail("carlosMartinez@gmail.com");
		paciente.setTelefono("44451654");
		paciente.setFecha_nacimiento(LocalDate.parse("1977-12-30"));
		paciente.setDireccion("Calle San Martin 789");
		paciente.setLocalidad("Córdoba");
		paciente.setProvincia("Navarro");
		pacienteNegocio.add(paciente);

		// Paciente 5
		paciente.setDni(10000005);
		paciente.setNombre("Ana");
		paciente.setApellido("Fernandez");
		paciente.setEmail("anaFernandez@gmail.com");
		paciente.setTelefono("33451654");
		paciente.setFecha_nacimiento(LocalDate.parse("1990-06-20"));
		paciente.setDireccion("Avenida Corrientes 123");
		paciente.setLocalidad("Corrientes");
		paciente.setProvincia("Pellegrini");
		pacienteNegocio.add(paciente);

		// Paciente 6
		paciente.setDni(10000006);
		paciente.setNombre("Luis");
		paciente.setApellido("Diaz");
		paciente.setEmail("luisDiaz@gmail.com");
		paciente.setTelefono("22451654");
		paciente.setFecha_nacimiento(LocalDate.parse("1985-09-15"));
		paciente.setDireccion("Calle Belgrano 456");
		paciente.setLocalidad("Pila");
		paciente.setProvincia("Entre Ríos");
		pacienteNegocio.add(paciente);

		// Paciente 7
		paciente.setDni(10000007);
		paciente.setNombre("Sofia");
		paciente.setApellido("Rodriguez");
		paciente.setEmail("sofiaRodriguez@gmail.com");
		paciente.setTelefono("11451654");
		paciente.setFecha_nacimiento(LocalDate.parse("1998-11-05"));
		paciente.setDireccion("Calle Independencia 789");
		paciente.setLocalidad("20 de Junio");
		paciente.setProvincia("Formosa");
		pacienteNegocio.add(paciente);

		// Paciente 8
		paciente.setDni(10000008);
		paciente.setNombre("Jorge");
		paciente.setApellido("Ramirez");
		paciente.setEmail("jorgeRamirez@gmail.com");
		paciente.setTelefono("02451654");
		paciente.setFecha_nacimiento(LocalDate.parse("2002-07-23"));
		paciente.setDireccion("Avenida San Juan 123");
		paciente.setLocalidad("Crucecita");
		paciente.setProvincia("San Juan");
		pacienteNegocio.add(paciente);

		// Paciente 9
		paciente.setDni(10000009);
		paciente.setNombre("Laura");
		paciente.setApellido("Sanchez");
		paciente.setEmail("lauraSanchez@gmail.com");
		paciente.setTelefono("12345678");
		paciente.setFecha_nacimiento(LocalDate.parse("1993-04-14"));
		paciente.setDireccion("Calle Las Heras 456");
		paciente.setLocalidad("Avellaneda");
		paciente.setProvincia("La Pampa");
		pacienteNegocio.add(paciente);

		// Paciente 10
		paciente.setDni(10000010);
		paciente.setNombre("Marta");
		paciente.setApellido("Silva");
		paciente.setEmail("martaSilva@gmail.com");
		paciente.setTelefono("87654321");
		paciente.setFecha_nacimiento(LocalDate.parse("1980-08-09"));
		paciente.setDireccion("Avenida Colon 789");
		paciente.setLocalidad("Churruca");
		paciente.setProvincia("Río Negro");
		pacienteNegocio.add(paciente);

		// Paciente 11
		paciente.setDni(10000011);
		paciente.setNombre("Gustavo");
		paciente.setApellido("Mendoza");
		paciente.setEmail("gustavoMendoza@gmail.com");
		paciente.setTelefono("23456789");
		paciente.setFecha_nacimiento(LocalDate.parse("1972-10-02"));
		paciente.setDireccion("Calle Sarmiento 123");
		paciente.setLocalidad("Bella Vista");
		paciente.setProvincia("Mendoza");
		pacienteNegocio.add(paciente);

		// Paciente 12
		paciente.setDni(10000012);
		paciente.setNombre("Clara");
		paciente.setApellido("Ortiz");
		paciente.setEmail("claraOrtiz@gmail.com");
		paciente.setTelefono("34567890");
		paciente.setFecha_nacimiento(LocalDate.parse("1999-05-12"));
		paciente.setDireccion("Avenida San Martin 456");
		paciente.setLocalidad("La Reja");
		paciente.setProvincia("Tierra del Fuego");
		pacienteNegocio.add(paciente);

		// Paciente 13
		paciente.setDni(10000013);
		paciente.setNombre("Roberto");
		paciente.setApellido("Alvarez");
		paciente.setEmail("robertoAlvarez@gmail.com");
		paciente.setTelefono("45678901");
		paciente.setFecha_nacimiento(LocalDate.parse("1983-01-19"));
		paciente.setDireccion("Calle Mitre 789");
		paciente.setLocalidad("Caseros");
		paciente.setProvincia("Neuquén");
		pacienteNegocio.add(paciente);

		// Paciente 14
		paciente.setDni(10000014);
		paciente.setNombre("Elena");
		paciente.setApellido("Medina");
		paciente.setEmail("elenaMedina@gmail.com");
		paciente.setTelefono("56789012");
		paciente.setFecha_nacimiento(LocalDate.parse("2001-12-25"));
		paciente.setDireccion("Avenida Roca 123");
		paciente.setLocalidad("El Tala");
		paciente.setProvincia("Santa Cruz");
		pacienteNegocio.add(paciente);
		
		// Paciente 15
				paciente.setDni(10000015);
				paciente.setNombre("Felipe");
				paciente.setApellido("Gomez");
				paciente.setEmail("felipeGomez@gmail.com");
				paciente.setTelefono("89431654");
				paciente.setFecha_nacimiento(LocalDate.parse("2023-01-20"));
				paciente.setDireccion("Calle Verde 456");
				paciente.setLocalidad("25 de Mayo");
				paciente.setProvincia("Buenos Aires");
				pacienteNegocio.add(paciente);

		
		


		// Especialidad
		EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("EspecialidadNegocioBean");
		Especialidad especialidad = (Especialidad) appContext.getBean("EspecialidadBean");
		
		
		String[] especialidades = {
		    "Cardiología", "Dermatología", "Ginecología", "Neurología", "Oftalmología",
		    "Pediatría", "Psiquiatría", "Reumatología", "Traumatología", "Urología",
		    "Oncología", "Endocrinología", "Gastroenterología", "Hematología", "Inmunología"
		};

		
		for (String nombre : especialidades) {
		 
		    especialidad.setNombre(nombre);
		    especialidadNegocio.add(especialidad);
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
		// Usuario ADMIN
			
				usuario.setUsuario("Admin");
				usuario.setContraseña("Clave1234");
				usuarioNegocio.add(usuario);
				
				
				
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
		
		
			String[] nombres = {
				    "Juan", "María", "Carlos", "Ana", "Luis",
				    "Sofía", "Pedro", "Laura", "Jorge", "Lucía",
				    "Miguel", "Elena", "Andrés", "Patricia", "Ricardo"
				};
			String[] apellidos = {
				    "García", "Martínez", "Rodríguez", "López", "González",
				    "Pérez", "Sánchez", "Ramírez", "Torres", "Flores",
				    "Rivera", "Gómez", "Díaz", "Hernández", "Vargas"
				};
			String[] correos = {
				    "juan.g@example.com", "maria.m@example.com", "carlos.r@example.com", "ana.l@example.com", "luis.g@example.com",
				    "sofia.p@example.com", "pedro.s@example.com", "laura.r@example.com", "jorge.t@example.com", "lucia.f@example.com",
				    "miguel.r@example.com", "elena.g@example.com", "andres.d@example.com", "patricia.h@example.com", "ricardo.v@example.com"
				};
			String[] fechasNacimiento = {
				    "1983-01-19", "1984-02-25", "1985-03-10", "1986-04-15", "1987-05-20",
				    "1988-06-30", "1989-07-14", "1990-08-22", "1991-09-11", "1992-10-05",
				    "1993-11-17", "1994-12-23", "1995-01-09", "1996-02-28", "1997-03-16"
				};
			
			String[] telefonos = {
				    "12345678", "23456789", "34567890", "45678901", "56789012",
				    "67890123", "78901234", "89012345", "90123456", "01234567",
				    "12345678", "23456789", "34567890", "45678901", "56789012"
				};
			
		
		for (int i = 0; i < 15; i++) {
			
			medico.setNombre(nombres[i]);
			medico.setApellido(apellidos[i]);
			medico.setEmail(correos[i]);
			medico.setFechaNacimiento(LocalDate.parse(fechasNacimiento[i]));
			medico.setTelefono(telefonos[i]);
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
		
		
		
		
		//LISTADO PROVINCIAS okkkkkkk

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
	descripcion = "Catamarca";
	provincia.setIdProvincia(idProvincia);
	provincia.setDescripcion(descripcion);
	provinciaNegocio.add(provincia);

	idProvincia = 3;
	descripcion = "Chaco";
	provincia.setIdProvincia(idProvincia);
	provincia.setDescripcion(descripcion);
	provinciaNegocio.add(provincia);

	idProvincia = 4;
	descripcion = "Chubut";
	provincia.setIdProvincia(idProvincia);
	provincia.setDescripcion(descripcion);
	provinciaNegocio.add(provincia);

	idProvincia = 5;
	descripcion = "Córdoba";
	provincia.setIdProvincia(idProvincia);
	provincia.setDescripcion(descripcion);
	provinciaNegocio.add(provincia);

	idProvincia = 6;
	descripcion = "Corrientes";
	provincia.setIdProvincia(idProvincia);
	provincia.setDescripcion(descripcion);
	provinciaNegocio.add(provincia);

	idProvincia = 7;
	descripcion = "Entre Ríos";
	provincia.setIdProvincia(idProvincia);
	provincia.setDescripcion(descripcion);
	provinciaNegocio.add(provincia);

	idProvincia = 8;
	descripcion = "Formosa";
	provincia.setIdProvincia(idProvincia);
	provincia.setDescripcion(descripcion);
	provinciaNegocio.add(provincia);

	idProvincia = 9;
	descripcion = "Jujuy";
	provincia.setIdProvincia(idProvincia);
	provincia.setDescripcion(descripcion);
	provinciaNegocio.add(provincia);

	idProvincia = 10;
	descripcion = "La Pampa";
	provincia.setIdProvincia(idProvincia);
	provincia.setDescripcion(descripcion);
	provinciaNegocio.add(provincia);

	idProvincia = 11;
	descripcion = "La Rioja";
	provincia.setIdProvincia(idProvincia);
	provincia.setDescripcion(descripcion);
	provinciaNegocio.add(provincia);

	idProvincia = 12;
	descripcion = "Mendoza";
	provincia.setIdProvincia(idProvincia);
	provincia.setDescripcion(descripcion);
	provinciaNegocio.add(provincia);

	idProvincia = 13;
	descripcion = "Misiones";
	provincia.setIdProvincia(idProvincia);
	provincia.setDescripcion(descripcion);
	provinciaNegocio.add(provincia);

	idProvincia = 14;
	descripcion = "Neuquén";
	provincia.setIdProvincia(idProvincia);
	provincia.setDescripcion(descripcion);
	provinciaNegocio.add(provincia);

	idProvincia = 15;
	descripcion = "Río Negro";
	provincia.setIdProvincia(idProvincia);
	provincia.setDescripcion(descripcion);
	provinciaNegocio.add(provincia);

	idProvincia = 16;
	descripcion = "Salta";
	provincia.setIdProvincia(idProvincia);
	provincia.setDescripcion(descripcion);
	provinciaNegocio.add(provincia);

	idProvincia = 17;
	descripcion = "San Juan";
	provincia.setIdProvincia(idProvincia);
	provincia.setDescripcion(descripcion);
	provinciaNegocio.add(provincia);

	idProvincia = 18;
	descripcion = "San Luis";
	provincia.setIdProvincia(idProvincia);
	provincia.setDescripcion(descripcion);
	provinciaNegocio.add(provincia);

	idProvincia = 19;
	descripcion = "Santa Cruz";
	provincia.setIdProvincia(idProvincia);
	provincia.setDescripcion(descripcion);
	provinciaNegocio.add(provincia);

	idProvincia = 20;
	descripcion = "Santa Fe";
	provincia.setIdProvincia(idProvincia);
	provincia.setDescripcion(descripcion);
	provinciaNegocio.add(provincia);

	idProvincia = 21;
	descripcion = "Santiago del Estero";
	provincia.setIdProvincia(idProvincia);
	provincia.setDescripcion(descripcion);
	provinciaNegocio.add(provincia);

	idProvincia = 22;
	descripcion = "Tierra del Fuego";
	provincia.setIdProvincia(idProvincia);
	provincia.setDescripcion(descripcion);
	provinciaNegocio.add(provincia);

	idProvincia = 23;
	descripcion = "Tucumán";
	provincia.setIdProvincia(idProvincia);
	provincia.setDescripcion(descripcion);
	provinciaNegocio.add(provincia);


	        ///LOCALIDADES
	        
	    
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

	idLocalidad = 66;
	idProvincia = 1;
	descripcion = "Gral. Viamonte";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	idLocalidad = 67;
	idProvincia = 1;
	descripcion = "Gral. Villegas";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	idLocalidad = 68;
	idProvincia = 1;
	descripcion = "Guaminí";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	idLocalidad = 69;
	idProvincia = 1;
	descripcion = "Guernica";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	idLocalidad = 70;
	idProvincia = 1;
	descripcion = "Henderson";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	idLocalidad = 71;
	idProvincia = 1;
	descripcion = "Hurlingham";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	idLocalidad = 72;
	idProvincia = 1;
	descripcion = "Ituzaingó";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	idLocalidad = 73;
	idProvincia = 1;
	descripcion = "José C. Paz";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	idLocalidad = 74;
	idProvincia = 1;
	descripcion = "Junín";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	idLocalidad = 75;
	idProvincia = 1;
	descripcion = "La Plata";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	idLocalidad = 76;
	idProvincia = 1;
	descripcion = "Lanús";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	idLocalidad = 77;
	idProvincia = 1;
	descripcion = "Laprida";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	idLocalidad = 78;
	idProvincia = 1;
	descripcion = "Las Flores";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	idLocalidad = 79;
	idProvincia = 1;
	descripcion = "Las Toninas";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	idLocalidad = 80;
	idProvincia = 1;
	descripcion = "Leandro N. Alem";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 81
	idLocalidad = 81;
	idProvincia = 2;
	descripcion = "Los Cardales";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 82
	idLocalidad = 82;
	idProvincia = 2;
	descripcion = "Los Toldos";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 83
	idLocalidad = 83;
	idProvincia = 2;
	descripcion = "Lucila del Mar";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 84
	idLocalidad = 84;
	idProvincia = 2;
	descripcion = "Luján";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 85
	idLocalidad = 85;
	idProvincia = 2;
	descripcion = "Magdalena";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 86
	idLocalidad = 86;
	idProvincia = 3;
	descripcion = "Maipú";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 87
	idLocalidad = 87;
	idProvincia = 3;
	descripcion = "Mar Chiquita";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 88
	idLocalidad = 88;
	idProvincia = 3;
	descripcion = "Mar de Ajó";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 89
	idLocalidad = 89;
	idProvincia = 3;
	descripcion = "Mar de las Pampas";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 90
	idLocalidad = 90;
	idProvincia = 3;
	descripcion = "Mar del Plata";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 91
	idLocalidad = 91;
	idProvincia = 4;
	descripcion = "Mar del Tuyú";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 92
	idLocalidad = 92;
	idProvincia = 4;
	descripcion = "Marcos Paz";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 93
	idLocalidad = 93;
	idProvincia = 4;
	descripcion = "Mercedes";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 94
	idLocalidad = 94;
	idProvincia = 4;
	descripcion = "Miramar";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 95
	idLocalidad = 95;
	idProvincia = 4;
	descripcion = "Monte";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 96
	idLocalidad = 96;
	idProvincia = 5;
	descripcion = "Monte Hermoso";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 97
	idLocalidad = 97;
	idProvincia = 5;
	descripcion = "Munro";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 98
	idLocalidad = 98;
	idProvincia = 5;
	descripcion = "Navarro";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 99
	idLocalidad = 99;
	idProvincia = 5;
	descripcion = "Necochea";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 100
	idLocalidad = 100;
	idProvincia = 5;
	descripcion = "Olavarría";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 101
	idLocalidad = 101;
	idProvincia = 6;
	descripcion = "Partido de la Costa";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 102
	idLocalidad = 102;
	idProvincia = 6;
	descripcion = "Pehuajó";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 103
	idLocalidad = 103;
	idProvincia = 6;
	descripcion = "Pellegrini";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 104
	idLocalidad = 104;
	idProvincia = 6;
	descripcion = "Pergamino";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 105
	idLocalidad = 105;
	idProvincia = 6;
	descripcion = "Pigüé";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 106
	idLocalidad = 106;
	idProvincia = 7;
	descripcion = "Pila";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 107
	idLocalidad = 107;
	idProvincia = 7;
	descripcion = "Pilar";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 108
	idLocalidad = 108;
	idProvincia = 7;
	descripcion = "Pinamar";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 109
	idLocalidad = 109;
	idProvincia = 7;
	descripcion = "Pinar del Sol";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 110
	idLocalidad = 110;
	idProvincia = 7;
	descripcion = "Polvorines";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 111
	idLocalidad = 111;
	idProvincia = 8;
	descripcion = "Pte. Perón";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 143
	idLocalidad = 143;
	idProvincia = 8;
	descripcion = "11 de Septiembre";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 144
	idLocalidad = 144;
	idProvincia = 8;
	descripcion = "20 de Junio";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 145
	idLocalidad = 145;
	idProvincia = 8;
	descripcion = "25 de Mayo";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 146
	idLocalidad = 146;
	idProvincia = 9;
	descripcion = "Acassuso";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 147
	idLocalidad = 147;
	idProvincia = 9;
	descripcion = "Adrogué";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 148
	idLocalidad = 148;
	idProvincia = 9;
	descripcion = "Aldo Bonzi";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 149
	idLocalidad = 149;
	idProvincia = 10;
	descripcion = "Área Reserva Cinturón Ecológico";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 150
	idLocalidad = 150;
	idProvincia = 10;
	descripcion = "Avellaneda";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 151
	idLocalidad = 151;
	idProvincia = 10;
	descripcion = "Banfield";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 152
	idLocalidad = 152;
	idProvincia = 11;
	descripcion = "Barrio Parque";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 153
	idLocalidad = 153;
	idProvincia = 11;
	descripcion = "Barrio Santa Teresita";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 154
	idLocalidad = 154;
	idProvincia = 11;
	descripcion = "Beccar";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 155
	idLocalidad = 155;
	idProvincia = 12;
	descripcion = "Bella Vista";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 156
	idLocalidad = 156;
	idProvincia = 12;
	descripcion = "Berazategui";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 157
	idLocalidad = 157;
	idProvincia = 12;
	descripcion = "Bernal Este";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 158
	idLocalidad = 158;
	idProvincia = 13;
	descripcion = "Bernal Oeste";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 159
	idLocalidad = 159;
	idProvincia = 13;
	descripcion = "Billinghurst";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 160
	idLocalidad = 160;
	idProvincia = 13;
	descripcion = "Boulogne";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 161
	idLocalidad = 161;
	idProvincia = 14;
	descripcion = "Burzaco";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 162
	idLocalidad = 162;
	idProvincia = 14;
	descripcion = "Carapachay";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 163
	idLocalidad = 163;
	idProvincia = 14;
	descripcion = "Caseros";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 164
	idLocalidad = 164;
	idProvincia = 15;
	descripcion = "Castelar";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 165
	idLocalidad = 165;
	idProvincia = 15;
	descripcion = "Churruca";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 166
	idLocalidad = 166;
	idProvincia = 15;
	descripcion = "Ciudad Evita";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 167
	idLocalidad = 167;
	idProvincia = 16;
	descripcion = "Ciudad Madero";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 168
	idLocalidad = 168;
	idProvincia = 16;
	descripcion = "Ciudadela";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 169
	idLocalidad = 169;
	idProvincia = 16;
	descripcion = "Claypole";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 170
	idLocalidad = 170;
	idProvincia = 17;
	descripcion = "Crucecita";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 171
	idLocalidad = 171;
	idProvincia = 17;
	descripcion = "Dock Sud";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 172
	idLocalidad = 172;
	idProvincia = 17;
	descripcion = "Don Bosco";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 173
	idLocalidad = 173;
	idProvincia = 18;
	descripcion = "Don Orione";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 174
	idLocalidad = 174;
	idProvincia = 18;
	descripcion = "El Jagüel";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 175
	idLocalidad = 175;
	idProvincia = 18;
	descripcion = "El Libertador";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 176
	idLocalidad = 176;
	idProvincia = 19;
	descripcion = "El Palomar";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 177
	idLocalidad = 177;
	idProvincia = 19;
	descripcion = "El Tala";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 178
	idLocalidad = 178;
	idProvincia = 19;
	descripcion = "El Trébol";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 179
	idLocalidad = 179;
	idProvincia = 20;
	descripcion = "Ezeiza";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 180
	idLocalidad = 180;
	idProvincia = 20;
	descripcion = "Ezpeleta";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 181
	idLocalidad = 181;
	idProvincia = 20;
	descripcion = "Florencio Varela";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 182
	idLocalidad = 182;
	idProvincia = 21;
	descripcion = "Florida";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 183
	idLocalidad = 183;
	idProvincia = 21;
	descripcion = "Francisco Álvarez";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 184
	idLocalidad = 184;
	idProvincia = 21;
	descripcion = "Gerli";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 185
	idLocalidad = 185;
	idProvincia = 22;
	descripcion = "Glew";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 186
	idLocalidad = 186;
	idProvincia = 22;
	descripcion = "González Catán";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 187
	idLocalidad = 187;
	idProvincia = 22;
	descripcion = "Gral. Lamadrid";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 188
	idLocalidad = 188;
	idProvincia = 23;
	descripcion = "Grand Bourg";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 189
	idLocalidad = 189;
	idProvincia = 23;
	descripcion = "Gregorio de Laferrere";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 190
	idLocalidad = 190;
	idProvincia = 23;
	descripcion = "Guillermo Enrique Hudson";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 191
	idLocalidad = 191;
	idProvincia = 13;
	descripcion = "Haedo";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 192
	idLocalidad = 192;
	idProvincia = 13;
	descripcion = "Hurlingham";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 193
	idLocalidad = 193;
	idProvincia = 11;
	descripcion = "Ing. Sourdeaux";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 194
	idLocalidad = 194;
	idProvincia = 10;
	descripcion = "Isidro Casanova";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 195
	idLocalidad = 195;
	idProvincia = 5;
	descripcion = "Ituzaingó";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 196
	idLocalidad = 196;
	idProvincia = 9;
	descripcion = "José C. Paz";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 197
	idLocalidad = 197;
	idProvincia = 9;
	descripcion = "José Ingenieros";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 198
	idLocalidad = 198;
	idProvincia = 9;
	descripcion = "José Marmol";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 199
	idLocalidad = 199;
	idProvincia = 8;
	descripcion = "La Lucila";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

	// Localidad 200
	idLocalidad = 200;
	idProvincia = 22;
	descripcion = "La Reja";
	localidad.setDescripcion(descripcion);
	localidad.setIdLocalidad(idLocalidad);
	provincia.setIdProvincia(idProvincia);
	localidad.setProvincia(provincia);
	localidadNegocio.add(localidad);

		
		
	}

}
