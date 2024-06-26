<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.time.LocalDate"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Turnos</title>
		<style type="text/css">
			<jsp:include page="../css/StyleSheet.css"></jsp:include>
		</style>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

	</head>
	<body>
		<jsp:include page="Menu.jsp"></jsp:include>

		<div class="container">
			<h2>Gestión de Turnos</h2>
	
			<div class="container">
				<div class="row">
					<div class="col-sm"></div>
					<div class="col-sm"></div>
					<div class="col-sm">
						<button type="button" class="btn btn-secondary" data-toggle="modal"
							data-target="#userModal">Alta Turno</button>
					</div>
				</div>
			</div>
		</div>




	<section class="row justify-content-center pt-3 px-3">
	<fieldset>
		<legend>ABML Turnos</legend>
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
						<th>ESTADO</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listaTurnos}" var="turno">
						<tr>
							<form action="ver_detalle_turno.html" method="get">
								<td><input type="submit" name="btnVerTurno" value="Ver"
									class="bg-warning">
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
							<td>
								<form action="actualizar_estado_turno.html" method="get">
									<input type="hidden" name="id" value="${turno.getId()}">
									<c:choose>
										<c:when test="${turno.getEstado()}">
											<input type="submit" name="btnEstado" value="Alta"
												class="btn btn-success">
										</c:when>
										<c:otherwise>
											<input type="submit" name="btnEstado" value="Baja"
												class="btn btn-danger">
										</c:otherwise>
									</c:choose>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			${estadoUpdateTurno}
		</div>
	</fieldset>
	</section>


	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>