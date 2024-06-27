<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.time.LocalDate"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<script type="text/javascript" charset="utf8"src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/v/bs4-4.1.1/jq-3.3.1/dt-1.10.18/sl-1.2.6/datatables.min.js"></script>
	<link rel="stylesheet" href="https://cdn.datatables.net/1.13.7/css/jquery.dataTables.css" />



	<title>Turnos</title>
	<style type="text/css">
		<jsp:include page="../css/StyleSheet.css"></jsp:include>
	</style>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

	<script type="text/javascript" charset="utf8"src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/v/bs4-4.1.1/jq-3.3.1/dt-1.10.18/sl-1.2.6/datatables.min.js"></script>
	<link rel="stylesheet" href="https://cdn.datatables.net/1.13.7/css/jquery.dataTables.css" />




</head>
	<body>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('#tabla_paciente').DataTable( {
			  "searching": false,
			  "info": false	  
			  
			});
		});
		
	</script>
		<jsp:include page="Menu.jsp"></jsp:include>

		<div class="container">
			<h2>Gestión de Turnos</h2>
	
			<div class="container">
				<div class="row">
					<div class="col-sm"></div>
					<div class="col-sm"></div>
				</div>
			</div>
				<section class="row justify-content-center pt-3 px-3">
				<fieldset>
					<legend>ABML Turnos</legend>
					<nav class="navbar navbar-expand-lg navbar-light bg-light">
					<div class="container">
						<!-- Botón de Inicio -->
						<form class="form-inline mr-auto" action="cargar_inicio.html"
							method="get">
							<button class="btn btn-primary" type="submit" name="btnNavIrInicio">Inicio</button>
						</form>
						<!-- Botón de Alta Paciente -->
						<button class="btn btn-success" type="button" data-toggle="modal" data-target="#assignTurnModal">Asignar Turno</button>

					</div>
					</nav>
					<div class="table-responsive">
						<table summary="Los turnos registrados en la Clinica">
							<caption>Un listado de los turnos registrados en la
								Clinica</caption>
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
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listaTurnos}" var="turno">
									<tr>
										<form action="ver_detalle_turno.html" method="get">
											<td><input type="submit" name="btnVerTurno" value="Ver"
												class="btn bg-warning">
												</td>
											<td>${turno.getId()}<input type="hidden" name="turno"
												value="${turno}"></td>
											<td>${turno.getMedico().getNombre()}-
												${turno.getMedico().getApellido()}</td>
											<td>${turno.getPaciente().getNombre()}</td>
											<td>${turno.getFecha()}</td>
											<td>${turno.getHora()}</td>
											<td>${turno.getObservacion()}</td>
											<td>${turno.getEstadoTurno()}</td>
										</form>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</fieldset>
				</section>
			</div>
			<div class="modal fade" id="assignTurnModal" tabindex="-1" role="dialog" aria-labelledby="assignTurnModalLabel" aria-hidden="true">
			    <div class="modal-dialog" role="document">
			        <div class="modal-content">
			            <form action="asignar_turno.html" method="post">
			                <div class="modal-header">
			                    <h5 class="modal-title" id="assignTurnModalLabel">Asignar Turno</h5>
			                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			                        <span aria-hidden="true">&times;</span>
			                    </button>
			                </div>
			                <div class="modal-body">
			                    <div class="form-group">
			                        <label for="especialidad">Especialidad</label>
			                        <select class="form-control" id="especialidad" name="especialidad" required>
			                            <option value="">Seleccione una especialidad</option>
			                            <c:forEach items="${listaEspecialidades}" var="especialidad">
			                                <option value="${especialidad.getEspecialidad_id()}">${especialidad.getNombre()}</option>
			                            </c:forEach>
			                        </select>
			                    </div>
			                    <div class="form-group">
			                        <label for="medico">Médico</label>
			                        <select class="form-control" id="medico" name="medico" required>
			                            <option value="">Seleccione un médico</option>
			                            <!-- Los médicos se cargarán dinámicamente según la especialidad seleccionada -->
			                        </select>
			                    </div>
			                    <div class="form-group">
			                        <label for="horario">Horario</label>
			                        <select class="form-control" id="horario" name="horario" required>
			                            <option value="">Seleccione un horario</option>
			                            <!-- Los horarios se cargarán dinámicamente según el médico seleccionado -->
			                        </select>
			                    </div>
			                    <div class="form-group">
			                        <label for="paciente">Paciente</label>
			                        <select class="form-control" id="paciente" name="paciente" required>
			                            <option value="">Seleccione un paciente</option>
			                            <c:forEach items="${listaPacientes}" var="paciente">
			                                <option value="${paciente.getDni()}">${paciente.getNombre()}</option>
			                            </c:forEach>
			                        </select>
			                    </div>
			                </div>
			                <div class="modal-footer">
			                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
			                    <button type="submit" class="btn btn-primary">Guardar</button>
			                </div>
			            </form>
			        </div>
			    </div>
			</div>
</body>
	<jsp:include page="footer.jsp"></jsp:include>
</html>