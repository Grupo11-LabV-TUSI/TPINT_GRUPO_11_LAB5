<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio</title>
<style type="text/css">
	<jsp:include page="../css/StyleSheet.css"></jsp:include>
</style>

<!-- //cdn.datatables.net/2.0.8/css/dataTables.dataTables.min.css -->
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<!-- //cdn.datatables.net/2.0.8/js/dataTables.min.js -->
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>

<!-- let table = new DataTable('#myTable'); -->
<script type="text/javascript">

	$(document).ready(function() {
	    $('#table_id_pacientes_admin').DataTable();
	    $('#table_id_medicos_admin').DataTable();
	    $('#table_id_turnos_admin').DataTable();
	    $('#table_id_estadisticasTurno_admin').DataTable();
	    $('#table_id_turnos_medic').DataTable();
	    $('.close').click(function() {
	        $('#detalleTurnoModal').modal('hide');
	    });
	    $('.estadoTurnoSelect').change(function() {
	        $(this).closest('form').submit();
	    });
	    
	    $('#detalleTurnoModal .btn-secondary[data-dismiss="modal"]').click(function() {
	        $('#detalleTurnoModal').modal('hide');
	    });
	});
	function mostrarDetalleTurno(id, medico, paciente, fecha, hora, observacion, direccion, localidad, provincia, email, telefono) {
	    $('#turnoId').text(id);
	    $('#turnoMedico').text(medico);
	    $('#turnoPaciente').text(paciente);
	    $('#turnoFecha').text(fecha);
	    $('#turnoHora').text(hora);
	    $('#turnoObservacion').text(observacion);
	    $('#pacienteDireccion').text(direccion);
	    $('#pacienteLocalidad').text(localidad);
	    $('#pacienteProvincia').text(provincia);
	    $('#pacienteEmail').text(email);
	    $('#pacienteTelefono').text(telefono);
	    $('#detalleTurnoModal').modal('show');
	}
	
	
</script>

</head>
<body>

<header class="text-center">
	<h1>TP INTEGRADOR LABORATORIO V</h1>
</header>

<jsp:include page="Menu.jsp"></jsp:include>


<main class="container-fluid m-0 px-3">
	<article class="row">
		<div class="col-12">
			<c:choose>
				<c:when test="${usuarioIngresado.getUsuario().equals('Admin')}">
					<p>Bienvenido administrador ${usuarioIngresado.getUsuario() }</p>
					<section class="row justify-content-center pt-3 px-3">
						<fieldset>
							<legend>ABML Pacientes</legend>
							<form action="ABML_paciente.html" method="get">
							
							
							
							<input type="submit" name="btnVerPaciente" value="IR" class="btn btn-success"> 
							</form>
							<table id="table_id_pacientes_admin" class="display" summary="Los pacientes registrados en la Clinica">
								<caption>
		    						Un listado de los pacientes registrados en la Clinica
		  						</caption>
							    <thead>
							        <tr>
							        	<th></th>
							            <th>DNI</th>
							            <th>NOMBRE</th>
							            <th>APELLIDO</th>
							            <th>EMAIL</th>
							            <th>TELEFONO</th>
							            <th>FECHA NACIMIENTO</th>
							            <th>DIRECCION</th>
							            <th>LOCALIDAD</th>
							            <th>PROVINCIA</th>
							            <th>ESTADO</th>
							        </tr>
							    </thead>
							    <tbody>
							    	<c:forEach items="${listaPacientes}" var="paciente">
								        <tr>
								        	<form action="ver_paciente.html" method="get">
								        		<td></td>
								        		<!-- <td> <input type="submit" name="btnVerPaciente" value="Ver" class="bg-warning"> </td>  -->
									            <td> ${paciente.getDni()} <input type="hidden" name="paciente" value="${paciente}"> </td>
									            <td> ${paciente.getNombre()} </td>
									            <td> ${paciente.getApellido()} </td>
									            <td> ${paciente.getEmail()} </td>
									            <td> ${paciente.getTelefono()} </td>
									            <td> ${paciente.getFecha_nacimiento()} </td>
									            <td> ${paciente.getDireccion()} </td>
									            <td> ${paciente.getLocalidad()} </td>
									            <td> ${paciente.getProvincia()} </td>
									            <td> ${paciente.getEstado()} </td>
								        	</form>
								        </tr>
							        </c:forEach>
							    </tbody>					    
							</table>
						</fieldset>			
					</section>
					<hr class="my-5">
					<section class="row justify-content-center pt-3 px-3">
						<fieldset>
							<legend>ABML Medicos</legend>
											<form action="ABM_medico.html" method="get">
												<input type="submit" name="btnVerTurno" value="IR" class="btn btn-success"> 
											</form>
							<table id="table_id_medicos_admin" class="display" summary="Los medicos registrados en la Clinica">
								<caption>
		    						Un listado de los medicos registrados en la Clinica
		  						</caption>
							    <thead>
							        <tr>
							        	<th></th>
							            <th>MATRICULA</th>
							            <th>NOMBRE</th>
							            <th>APELLIDO</th>
							            <th>EMAIL</th>
							            <th>TELEFONO</th>
							            <th>FECHA NACIMIENTO</th>
							            <th>USUARIO</th>
							            <th>ESPECIALIDAD</th>
							            <th>HORARIO</th>
							            <th>ESTADO</th>
							        </tr>
							    </thead>
							    <tbody>
							    	<c:forEach items="${listaMedicos}" var="medico">
								        <tr>
								        	<form action="ver_medico.html" method="get">
								        		<td> <input type="submit" name="btnVerMedico" value="Ver" class="bg-warning"> </td>
									            <td> ${medico.getMatricula()} <input type="hidden" name="medico" value="${medico}"> </td>
									            <td> ${medico.getNombre()} </td>
									            <td> ${medico.getApellido()} </td>
									            <td> ${medico.getEmail()} </td>
									            <td> ${medico.getTelefono()} </td>
									            <td> ${medico.getFechaNacimiento()} </td>
									            <td> ${medico.getUsuario().getUsuario()} </td>
									            <td> ${medico.getEspecialidad().getNombre()} </td>
									            <td> 
									            	<select name="miDropdown">
												        <option value="">Mira Los horarios</option>
												        <c:forEach items="${medico.getHorarios()}" var="opcion">
												            <option value="${opcion.getId()}">${opcion.getDia()} - ${opcion.getHoraInicio()} - ${opcion.getHoraFin()}</option>
												        </c:forEach>
												    </select>
									            </td>
									            <td> ${medico.getEstado()} </td>
								        	</form>
								        </tr>
							        </c:forEach>
							    </tbody>					    
							</table>
						</fieldset>			
					</section>
					<hr class="my-5">
					
					
					<section class="row justify-content-center pt-3 px-3">
						<fieldset>
							<legend>ABML Turnos</legend>
							<form action="ABML_turno.html" method="get">
							
							
							
							<input type="submit" name="btnVerTurno" value="IR" class="btn btn-success"> 
							</form>
							<table id="table_id_turnos_admin" class="display"s summary="Los medicos registrados en la Clinica">
								<caption>
		    						Un listado de los turnos registrados en la Clinica
		  						</caption>
							    <thead>
							        <tr>
							            <th>ID</th>
							            <th>MEDICO</th>
							            <th>DNI PACIENTE</th>
							            <th>NOMBRE PACIENTE</th>
							            <th>APELLIDO PACIENTE</th>
							            <th>FECHA</th>
							            <th>HORA</th>
							            <th>OBSERVACION</th>
							            <th>ESTADO TURNO</th>
							            <th>ESTADO</th>
							        </tr>
							    </thead>
							    <tbody>
							    	<c:forEach items="${listaTurnos}" var="turno">
								        <tr>
								        	<form action="ver_turno.html" method="get">
									            <td> ${turno.getId()} <input type="hidden" name="turno" value="${turno}"> </td>
									            <td> ${turno.getMedico().getNombre()} - ${turno.getMedico().getApellido()} </td>
									            <td> ${turno.getPaciente().getDni()} </td>
									            <td> ${turno.getPaciente().getNombre()} </td>
									            <td> ${turno.getPaciente().getApellido()} </td>
									            <td> ${turno.getFecha()} </td>
									            <td> ${turno.getHora()} </td>
									            <td> ${turno.getObservacion()} </td>
									            <td> ${turno.getEstadoTurno()} </td>
									            <td> ${turno.getEstado()} </td>
								        	</form>
								        </tr>
							        </c:forEach>
							    </tbody>					    
							</table>
						</fieldset>			
					</section>
					<hr class="my-5">
					<section class="row justify-content-center pt-3 px-3">
						<fieldset>
							<legend>REPORTE/ESTADISTICA/INFORME Turnos</legend>
							<table id="table_id_estadisticasTurno_admin" class="display" summary="Los medicos registrados en la Clinica">
								<caption>
		    						Un listado de los turnos registrados en la Clinica
		  						</caption>
							    <thead>
							        <tr>
							        	<th></th>
							            <th>ID</th>
							            <th>MEDICO</th>
							            <th>PACIENTE</th>
							            <th>FECHA</th>
							            <th>HORA</th>
							            <th>OBSERVACION</th>
							            <th>ESTADO TURNO</th>
							            <th>ESTADO</th>
							        </tr>
							    </thead>
							    <tbody>
							    	<c:forEach items="${listaTurnos}" var="turno">
								        <tr>
								        	<form action="ver_turno.html" method="get">
								        		<td> <input type="submit" name="btnVerTurno" value="Ver" class="bg-warning"> </td>
									            <td> ${turno.getId()} <input type="hidden" name="turno" value="${turno}"> </td>
									            <td> ${turno.getMedico().getNombre()} - ${turno.getMedico().getApellido()} </td>
									            <td> ${turno.getPaciente().getApellido()} </td>
									            <td> ${turno.getFecha()} </td>
									            <td> ${turno.getHora()} </td>
									            <td> ${turno.getObservacion()} </td>
									            <td> ${turno.getEstadoTurno()} </td>
									            <td> ${turno.getEstado()} </td>
								        	</form>
								        </tr>
							        </c:forEach>
							    </tbody>					    
							</table>
						</fieldset>			
					</section>
				</c:when>
				<c:when test="${not empty usuarioIngresado.getUsuario()}">
					<section class="row justify-content-center pt-3 px-3">
						<p>Bienvenido doctor</p>
						<fieldset>
					        <legend>ABML Turnos</legend>
					        <table id="table_id_turnos_medic" class="display" summary="Los turnos registrados en la Clínica">
					            <caption>Un listado de los turnos registrados en la Clínica</caption>
					            <thead>
					                <tr>
					                    <th></th>
					                    <th>ID</th>
					                    <th>MÉDICO</th>
					                    <th>DNI PACIENTE</th>
					                    <th>PACIENTE</th>
					                    <th>FECHA</th>
					                    <th>HORA</th>
					                    <th>OBSERVACIÓN</th>
					                    <th>EDITAR</th>
					                    <th>ESTADO TURNO</th>
					                </tr>
					            </thead>
					            <tbody>
					                <c:choose>
					                    <c:when test="${usuarioIngresado.usuario == 'Admin'}">
					                        <c:forEach items="${listaTurnos}" var="turno">
					                            <tr>
					                                <form action="ver_turno.html" method="get">
					                                    <td><input type="submit" name="btnVerTurno" value="Ver" class="btn bg-warning"></td>
					                                    <td>${turno.getId()}</td>
					                                    <td>${turno.getMedico().getNombre()} - ${turno.getMedico().getApellido()}</td>
					                                    <td>${turno.getPaciente().getDni()}</td>
					                                    <td>${turno.getPaciente().getNombre()} - ${turno.getPaciente().getApellido()}</td>
					                                    <td>${turno.getFecha()}</td>
					                                    <td>${turno.getHora()}</td>
					                                    <td>${turno.getObservacion()}</td>
					                                    <td>${turno.getEstado()}</td>
					                                    <td>${turno.getEstadoTurno()}</td>
					                                </form>
					                            </tr>
					                        </c:forEach>
					                    </c:when>
					                    <c:otherwise>
					                        <c:forEach items="${listaTurnos}" var="turno">
					                            <c:if test="${turno.getMedico().getUsuario().getId() == usuarioIngresado.id}">
					                                <tr>
					                                    <form action="actualizar_estado_turno.html" method="get">
					                                        <td><button type="button" onclick="mostrarDetalleTurno('${turno.id}', '${turno.medico.nombre} ${turno.medico.apellido}', '${turno.paciente.nombre} ${turno.paciente.apellido}', '${turno.fecha}', '${turno.hora}', '${turno.observacion}', '${turno.paciente.direccion}', '${turno.paciente.localidad}', '${turno.paciente.provincia}', '${turno.paciente.email}', '${turno.paciente.telefono}')" class="btn bg-warning">Ver</button></td>
					                                        <td>${turno.getId()}</td>
					                                        <td>${turno.getMedico().getNombre()} - ${turno.getMedico().getApellido()}</td>
					                                        <td>${turno.getPaciente().getDni()}</td>
					                                        <td>${turno.getPaciente().getNombre()} - ${turno.getPaciente().getApellido()}</td>
					                                        <td>${turno.getFecha()}</td>
					                                        <td>${turno.getHora()}</td>
					                                        <td>
										                        <textarea name="observacion" 
										                        <c:if test="${turno.getEstadoTurno() != 'Pendiente'}">disabled</c:if>>${turno.getObservacion()}</textarea>
										                    </td>
					                                        <td>
										                        <button type="submit" name="guardarComentario" class="btn btn-primary" 
										                        <c:if test="${turno.getEstadoTurno() != 'Pendiente'}">disabled</c:if>>Guardar</button>
										                    </td>
					                                        <td>
										                        <c:if test="${turno.getEstadoTurno() == 'Pendiente'}">
										                            <input type="hidden" name="turnoId" value="${turno.getId()}">
										                            <button type="submit" name="estadoTurno" value="Presente" class="btn btn-success">Presente</button>
										                            <button type="submit" name="estadoTurno" value="Ausente" class="btn btn-danger">Ausente</button>
										                        </c:if>
										                        <c:if test="${turno.getEstadoTurno() != 'Pendiente'}">
										                            ${turno.getEstadoTurno()}
										                        </c:if>
										                    </td>
					                                    </form>
					                                </tr>
					                            </c:if>
					                        </c:forEach>
					                    </c:otherwise>
					                </c:choose>
					            </tbody>
					        </table>
					    </fieldset>
					</section>
					
					<!-- Modal para Detalles del Turno -->
					<div class="modal fade" id="detalleTurnoModal" tabindex="-1" role="dialog" aria-labelledby="detalleTurnoModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="detalleTurnoModalLabel">Detalles del Turno y Paciente</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					        <p><strong>ID:</strong> <span id="turnoId"></span></p>
						    <p><strong>Médico:</strong> <span id="turnoMedico"></span></p>
						    <p><strong>Paciente:</strong> <span id="turnoPaciente"></span></p>
						    <p><strong>Fecha:</strong> <span id="turnoFecha"></span></p>
						    <p><strong>Hora:</strong> <span id="turnoHora"></span></p>
						    <p><strong>Email:</strong> <span id="pacienteEmail"></span></p>
						    <p><strong>Teléfono:</strong> <span id="pacienteTelefono"></span></p>
						    <p><strong>Dirección:</strong> <span id="pacienteDireccion"></span></p>
						    <p><strong>Localidad:</strong> <span id="pacienteLocalidad"></span></p>
						    <p><strong>Provincia:</strong> <span id="pacienteProvincia"></span></p>
					        <p><strong>Observación:</strong> <span id="turnoObservacion" ></span></p>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
					      </div>
					    </div>
					  </div>
					</div>
				</c:when>
				<c:otherwise>
					<section class="row justify-content-center pt-3 px-3">
						<h>Bienvenido vistante</h>
						<div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
						  <div class="carousel-inner">
						    <div class="carousel-item active">
						      <img src="https://img.freepik.com/psd-gratis/pasillo-sala-emergencias-ia-generativa_587448-2157.jpg?size=626&ext=jpg" class="d-block w-100" alt="...">
						    </div>
						    <div class="carousel-item">
						      <img src="https://img.freepik.com/foto-gratis/fondo-pasillo-vacio_23-2149408808.jpg?size=626&ext=jpg" class="d-block w-100" alt="...">
						    </div>
						    <div class="carousel-item">
						      <img src="https://img.freepik.com/foto-gratis/recepcion-clinica-sala-espera-vestibulo-instalaciones-mostrador-registro-utilizado-pacientes-citas-medicas-mostrador-recepcion-vacio-centro-salud-visitas-control_482257-51247.jpg?size=626&ext=jpg&ga=GA1.2.1929211811.1719061359&semt=sph" class="d-block w-100" alt="...">
						    </div>
						  </div>
						</div>		
					</section>
				</c:otherwise>
			</c:choose>
		</div>
	</article>
</main>
<br>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>