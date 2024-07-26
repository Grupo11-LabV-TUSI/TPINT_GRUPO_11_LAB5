<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.time.LocalDate"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/v/bs4-4.1.1/jq-3.3.1/dt-1.10.18/sl-1.2.6/datatables.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.7/css/jquery.dataTables.css" />
</head>
<body>
   
<script type="text/javascript">
		$(document).ready(function() {
			$('#tabla_turnos').DataTable({});
		});
	</script>
    <div class="container">
    
    
      

                <div class="table-responsive">
                    <table id="tabla_turnos" summary="Los turnos registrados en la Clinica" class="table table-striped" >
                        <legend>Listado de Turnos</legend>
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
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listaTurnos}" var="turno">
                                <tr>
                                    <form action="ver_detalle_turno.html" method="get">
                                        <td>${turno.getId()}<input type="hidden" name="turno" value="${turno}"></td>
                                        <td>${turno.getMedico().getNombre()} ${turno.getMedico().getApellido()}</td>
                                        <td>${turno.getPaciente().getDni()}</td>
                                        <td>${turno.getPaciente().getNombre()}</td>
                                        <td>${turno.getPaciente().getApellido()}</td>
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

</body>
</html>
