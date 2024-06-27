<%@page import="java.time.LocalDateTime"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Calendar"%>
<%@ page buffer="64kb"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reporte Calendario</title>

</head>
<style>
.center {
	margin: auto;
	width: 25%;
	padding: 15px;
}

.tablaCalendario table {
	background-color: #f4ffe5;
}

.tablaCalendario tr, .tablaCalendario td {
	border: 1px solid black;
	border-collapse: collapse;
	text-align: center;
}

.tablaCalendario th {
	width: 1%;
	border: 1px solid black;
	border-collapse: collapse;
}
.hover-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
    z-index: 1;
    padding: 10px;
}

li:hover .hover-content {
    display: block;
}
</style>

</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
			<div class="table-responsive">
				<div class="table-wrapper">
				<div>
					<h1>Calendario de Medicos y Pacientes</h1><br>
				<%-- Obtiene el año y el mes actual --%>
					<%
					int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
					%>
					<%
					int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH) + 1;
					%>

					<%-- Verifica si hay parámetros para cambiar el año y el mes --%>
					<%
					if (request.getParameter("year") != null && request.getParameter("month") != null) {
						year = Integer.parseInt(request.getParameter("year"));
						month = Integer.parseInt(request.getParameter("month"));
					}
					%>

					<%-- Calcula el número de días en el mes y el día de la semana del primer día --%>
					<%
					java.util.Calendar calendar = java.util.Calendar.getInstance();
					calendar.set(year, month - 1, 1);
					int daysInMonth = calendar.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
					int firstDayOfWeek = calendar.get(java.util.Calendar.DAY_OF_WEEK);
					// Obtiene la descripción del mes
					java.text.DateFormatSymbols dfs = new java.text.DateFormatSymbols();
					String monthDescription = dfs.getMonths()[month - 1];
					%>

					<h2 style="text-align: center"><%=year%>
						-
						<%=monthDescription.toUpperCase()%></h2>

					<table class="tablaCalendario" style="background-color: #cdd2ff;">
						<tr>
							<th>Domingo</th>
							<th>Lunes</th>
							<th>Martes</th>
							<th>Miércoles</th>
							<th>Jueves</th>
							<th>Viernes</th>
							<th>Sábado</th>
						</tr>

						<tr>
							<%-- Rellena los espacios vacíos antes del primer día --%>
							<%
							for (int i = 1; i < firstDayOfWeek; i++) {
							%>
							<td></td>
							<%
							}
							%>

							<%-- Genera los días del mes --%>
							<%
							int day = 1;
							while (day <= daysInMonth) {
							%>
							<td>
							<form action="ServletCalendario" method="get">						
							  <span style="text-align: center"><%= day %></span>
							<input type="hidden" name="dia" value="<%=day%>"> 
							<input type="hidden" name="mes" value="<%=month%>" >
							<input type="hidden" name="anio" value="<%=year %>">
							<input type="submit" value="Informacion del dia" name="infoMed" class="btn btn-dark" style="width: 100%" >
							</form>
							</td>
					
							<%-- Salto de línea después de cada sábado --%>
							<%
							if (calendar.get(java.util.Calendar.DAY_OF_WEEK) == java.util.Calendar.SATURDAY) {
							%>
						</tr>
						<tr>
							<%
							}

							calendar.add(java.util.Calendar.DAY_OF_MONTH, 1);
							day++;
							}
							%>

							<%-- Rellena los espacios vacíos después del último día --%>
							<%
							while (calendar.get(java.util.Calendar.DAY_OF_WEEK) != java.util.Calendar.SUNDAY) {
							%>
							<td></td>
							<%
							calendar.add(java.util.Calendar.DAY_OF_MONTH, 1);
							%>
							<%
							}
							%>
						</tr>
					</table>

					<%-- Genera los enlaces para cambiar al mes anterior y siguiente --%>
						<%
						boolean mesB = false;
						%>
						<%
						if (month == 12) {
							year++;
							month = 1;
						}
						%>
						<div> <br>
						<a style="font-size: 150%; margin: auto; width: 25%; padding: 15px;" href="ReporteCalendario.jsp?year=<%=year%>&month=<%=month - 1%>">Mes anterior </a> | 
						<a style="font-size: 150%; margin: auto; width: 25%; padding: 15px;" href="ReporteCalendario.jsp?year=<%=year%>&month=<%=month + 1%>">Mes siguiente</a> | 
						<a style="font-size: 150%; margin: auto; width: 25%; padding: 15px;" href="ReporteCalendario.jsp?year=<%=year + 1%>&month=1">Año siguiente</a>
						</div>
						<% Boolean estado = (Boolean) request.getAttribute("estado");
						if (estado!=null){ 
							if (estado== true){ %>
					<table class="tablaCalendario" >
					<tr>
					<th>Fecha</th>
					<th>Nombre Medico</th>
					<th>Descripcion</th>
					<th>Nombre Paciente</th>
					<th>Dni Paciente</th>
					<th>Estado Turno</th>
					<th>Cantidad de Turnos</th>
					</tr>
					<tr>
					<%ArrayList<String>lista = (ArrayList<String>) request.getAttribute("lista");
						if(lista != null){
							for(String i : lista ){
						%>
					       <td><%= i.split("\\|")[0].trim() %></td>
					       <td><%= i.split("\\|")[1].trim() %></td>
					       <td><%= i.split("\\|")[2].trim() %></td>
					       <td><%= i.split("\\|")[3].trim() %></td>
					       <td><%= i.split("\\|")[4].trim() %></td>
					       <td><%= i.split("\\|")[5].trim() %></td>
					       <td><%= i.split("\\|")[6].trim() %></td>
					</tr>
						<%		
							}
						}
					%>
					
					</table>
					<%} else {
						%>
					<h2>No se encontraron valores en ese dia </h2>
					<% }}%>
					<script>
						function changeMonth(year, month) {
							var form = document.getElementById("reporteForm");
							var queryString = new URLSearchParams(new FormData(
									form)).toString();

							var url = "ServletReporte?year=" + year + "&month="
									+ month + "&" + queryString;
							location.href = url;
						}

						function showHoverContent(element) {
							var hoverContent = element
									.querySelector('.hover-content');
							hoverContent.style.display = 'block';
						}

						function hideHoverContent(element) {
							var hoverContent = element
									.querySelector('.hover-content');
							hoverContent.style.display = 'none';
						}
					</script>
					</div>
					</div>
					</div>
			</main>
		</div>
	</div>
</body>
</html>