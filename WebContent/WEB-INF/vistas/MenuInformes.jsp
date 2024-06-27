<%@page import="java.util.Calendar"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Informes</title>
<style> 
#myDIV {
  border: 1px solid black;
  background-color: lightblue;
  width: 300px;
  height: 300px;
  position: relative;
  top: 20px;
}
</style>
</head>
<body>
	<jsp:include page="Menu.jsp"></jsp:include>

		<h2>Gestión de Usuarios</h2>

		<div class="container">
			<div class="row">

					<!-- Botón para abrir el modal -->
					<button id="btn" type="button" class="btn btn-secondary" data-toggle="modal"
						data-target="#userModal">Reportes</button>
				</div>
			</div>
		<div>
			<h4>1. Obtener la cantidad de turnos por especialidad entre una
				determinada fecha.</h4>
				<div>
											<table class="formulario">

								<tr>
									<td><a style="font-family: Arial; font-size: 150%">Especialidad</a></td>
									<td><select name="especialidad" class="form-select"
										aria-label="Default select example">

											<option>Seleccione especialidad</option>

									</select></td>
								<tr>
									<td><a style="font-family: Arial; font-size: 150%">Fecha
											Inicio</a></td>
									<td><input type="date" class="inputForm"
										name="fechaInicio" style="width: 100%; text-align: center;"></td>
								</tr>
								<tr>
									<td><a style="font-family: Arial; font-size: 150%">Fecha
											Fin</a></td>
									<%
									LocalDateTime localDateTime = LocalDateTime.now();
									%>
									<td><input class="inputForm" type="date" name="fechaFin"
										value="<%=localDateTime.toLocalDate()%>"
										style="width: 100%; text-align: center;"></td>
								</tr>
								<tr>
									<td></td>
									<td>
										<div class="center">
											<input class="btn btn-dark" type="submit"
												value="Obtener Reporte" name="btnObtenerReporte">
										</div>
									</td>

								</tr>
							</table>
				</div>
			<h4>2. Obtener la cantidad de turnos por mes y año que tuvo un
				medico.</h4>
				<div>
				<table class="formulario">
								<tr>
									<td><a style="font-family: Arial; font-size: 150%">Medicos</a></td>
									<td><select name="slcmedico" class="form-select">

											<option value="">Seleccione un medico</option>

									</select></td>
								</tr>
								<tr>
									<td><a style="font-family: Arial; font-size: 150%">Mes</a></td>
									<td><select name="mes" class="form-select">
											<option value="1">Enero</option>
											<option value="2">Febrero</option>
											<option value="3">Marzo</option>
											<option value="4">Abril</option>
											<option value="5">Mayo</option>
											<option value="6">Junio</option>
											<option value="7">Julio</option>
											<option value="8">Agosto</option>
											<option value="9">Septiembre</option>
											<option value="10">Octubre</option>
											<option value="11">Noviembre</option>
											<option value="12">Diciembre</option>
									</select></td>
								</tr>
								<tr>
									<td><a style="font-family: Arial; font-size: 150%">Año</a></td>
									<td><select name="anio" class="form-select">
											<%
											int currentYear = Calendar.getInstance().get(Calendar.YEAR);
											int startYear = currentYear - 3;
											int endYear = currentYear + 0;
											for (int year = startYear; year <= endYear; year++) {
											%>
											<option value="<%=year%>"><%=year%></option>
											<%
											}
											%>
									</select></td>
								</tr>
								<tr>
									<td><a style="font-family: Arial; font-size: 150%">Estado</a></td>
									<td><select name="idEstado" class="form-select">
											<option value="1">Libre</option>
											<option value="2">Ocupado</option>
											<option value="3">Ausente</option>
											<option value="4">Presente</option>
									</select></td>
								</tr>
								<tr>
									<td></td>
									<td>
										<div class="center">
											<input class="btn btn-dark" type="submit"
												value="Obtener Reporte" name="btnReporte2">
										</div>
									</td>
								</tr>
							</table>
							<div>

				</div>
			<h4>3. Calendario de Medicos y Pacientes</h4>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>