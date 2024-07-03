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

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<!-- //cdn.datatables.net/2.0.8/js/dataTables.min.js -->
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>

<!-- let table = new DataTable('#myTable'); -->
<script type="text/javascript">

		$(document).ready(function() {
			$('#table_id_pacientes_admin').DataTable();
		});
		
		$(document).ready(function() {
			$('#table_id_medicos_admin').DataTable();
		});
		
		$(document).ready(function() {
			$('#table_id_turnos_admin').DataTable();
		});
		
		$(document).ready(function() {
			$('#table_id_estadisticasTurno_admin').DataTable();
		});
		
		$(document).ready(function() {
			$('#table_id_turnos_medic').DataTable();
		});
		/*$(document).ready(function() {
	        $('.estadoTurnoSelect').change(function() {
	            $(this).closest('form').submit();
	        });*/
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
								        		<td> <input type="submit" name="btnVerPaciente" value="Ver" class="bg-warning"> </td>
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
												            <option value="${opcion.getId()}">${opcion.getDia()}</option>
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
									            <td> ${turno.getId()} <input type="hidden" name="turno" value="${turno}"> </td>
									            <td> ${turno.getMedico().getNombre()} - ${turno.getMedico().getApellido()} </td>
									            <td> ${turno.getPaciente().getNombre()} </td>
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
							<table id="table_id_turnos_medic" class="display" summary="Los medicos registrados en la Clinica">
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
									            <td> ${turno.getPaciente().getNombre()} </td>
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