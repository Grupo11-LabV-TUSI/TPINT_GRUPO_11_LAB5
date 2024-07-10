<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDateTime" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
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
    <style type="text/css">
        <jsp:include page="../css/StyleSheet.css"></jsp:include>
    </style>

    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function() {
            $('#btnObtenerReporte').click(function() {
                enviarFormulario();
            });
        });
    	$(document).ready(function() {
    		$('#tabla_Medicos').DataTable();
    	});
        function enviarFormulario() {
            var especialidadId = parseInt(document.getElementById('especialidad').value, 10);
            var fechaInicio = document.getElementById('fechaInicio').value;
            var fechaFin = document.getElementById('fechaFin').value;

            // Verificar si el valor de especialidad es un número válido
            if (isNaN(especialidadId) || especialidadId <= 0) {
                alert("Por favor, seleccione una especialidad válida.");
                return;
            }

            // Asignar valores a los campos del formulario antes de enviarlo
            document.getElementById('especialidadId').value = especialidadId;
            document.getElementById('fechaInicioId').value = fechaInicio;
            document.getElementById('fechaFinId').value = fechaFin;

            // Enviar el formulario
            document.getElementById('informesForm1').submit();
        }
    </script>
</head>
<body>
    <jsp:include page="Menu.jsp"></jsp:include>

    <h2>Gestión de Usuarios</h2>

    <div class="container">
        <div class="row">
            <button id="btnAbrirModal" type="button" class="btn btn-secondary">Reportes</button>
        </div>
    </div>

    <div class="container">
        <h4>1. Obtener la cantidad de turnos por especialidad entre una determinada fecha.</h4>
        <form id="informesForm1" action="Reporte1.html" method="post">
            <table class="formulario">
                <tr>
                    <td><a style="font-family: Arial; font-size: 150%">Especialidad</a></td>
                    <td>
                        <select id="especialidad" name="especialidad" class="form-select" aria-label="Default select example">
                            <option value="">Seleccione especialidad</option>
                            <c:forEach var="especialidad" items="${listaEspecialidades}">
                                <option value="${especialidad.especialidad_id}"> ${especialidad.nombre} </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><a style="font-family: Arial; font-size: 150%">Fecha Inicio</a></td>
                    <td><input type="date" class="inputForm" id="fechaInicio" name="fechaInicio" style="width: 100%; text-align: center;"></td>
                </tr>
                <tr>
                    <td><a style="font-family: Arial; font-size: 150%">Fecha Fin</a></td>
                    <td><input class="inputForm" type="date" id="fechaFin" name="fechaFin" value="<%=LocalDateTime.now().toLocalDate()%>" style="width: 100%; text-align: center;"></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <div class="center">
                            <!-- Botón para obtener el reporte -->
                            <button id="btnObtenerReporte" type="button" class="btn btn-dark">Obtener Reporte</button>
                        </div>
                    </td>
                </tr>
            </table>
            <!-- Campos ocultos para enviar los datos al controlador -->
            <input type="hidden" id="especialidadId" name="especialidad" value="">
            <input type="hidden" id="fechaInicioId" name="fechaInicio" value="">
            <input type="hidden" id="fechaFinId" name="fechaFin" value="">
        </form>
    </div>
			<form id="informesForm2" action="Reporte2.html" method="post">
	<div class="container">
	<h4>2. Obtener la cantidad de turnos por mes y año que tuvo un
		medico.</h4>
		<table class="formulario">
			<tr>
				<td><a style="font-family: Arial; font-size: 150%">Medicos</a></td>
				<td>
                      <select id="medico" name="medico" class="form-select" aria-label="Default select example">
                            <option value="">Seleccione Medico</option>
                            <c:forEach var="medico" items="${listaMedicos}">
                                <option value="${medico.getMatricula()}"> ${medico.getNombre()}, ${medico.getApellido()} </option>
                            </c:forEach>
                        </select>
				</td>
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
						<input class="btn btn-dark" type="submit" value="Obtener Reporte"
							name="btnReporte2">
					</div>
				</td>
			</tr>
		</table>
	</div>
	</form>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
