<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.time.LocalDate"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/v/bs4-4.1.1/jq-3.3.1/dt-1.10.18/sl-1.2.6/datatables.min.js"></script>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.7/css/jquery.dataTables.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <title>Turnos</title>
    <style type="text/css">
        <jsp:include page="../css/StyleSheet.css"></jsp:include>
    </style>

    <script type="text/javascript">
	    $(document).ready(function() {
	        function toggleMedicoSelect() {
	            var especialidadSelected = $('#especialidad').val();
	            $('#medico').prop('disabled', !especialidadSelected);
	        }
	
	        $('#especialidad').change(function() {
	            $('#especialidadForm').submit();
	            toggleMedicoSelect();
	        });
	
	        toggleMedicoSelect();
	    }); 
	    $(document).ready(function() {
	        <c:if test="${not empty error}">
	            alert('${error}');
	        </c:if>
	    });
    </script>
</head>
<body>
    <jsp:include page="Menu.jsp"></jsp:include>

    <div class="container">
        <h2>Gestión de Turnos</h2>

        <section class="row justify-content-center pt-3 px-3">
            <fieldset>
                <legend>Asignacion de Turnos</legend>
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container">
                        <!-- Botón de Inicio -->
                        <form class="form-inline mr-auto" action="cargar_inicio.html" method="get">
                            <button class="btn btn-primary" type="submit" name="btnNavIrInicio">Inicio</button>
                        </form>
                    </div>
                </nav>

                <div class="container">
                    <form action="ABML_turno.html" method="get" id="especialidadForm">
                        <div class="form-group">
                            <label for="especialidad">Especialidad</label>
                            <select class="form-control" id="especialidad" name="especialidad" required>
                                <option value="">Seleccione una especialidad</option>
                                <c:forEach items="${listaEspecialidades}" var="especialidad">
                                    <option value="${especialidad.getEspecialidad_id()}" <c:if test="${param.especialidad eq especialidad.getEspecialidad_id()}">selected</c:if>>${especialidad.getNombre()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </form>
                    <form action="guardar_turno.html" method="post" id="assignTurnForm">
                        <div class="form-group">
                            <label for="medico">Médico</label>
                            <select class="form-control" id="medico" name="medico" required>
							    <option value="">Seleccione un médico</option>
							    <c:forEach items="${listaMedicosFiltrados}" var="medico">
							        <option value="${medico.getMatricula()}">${medico.getNombre()} ${medico.getApellido()}</option>
							    </c:forEach>
							</select>
                        </div>
                        <div class="form-group">
                            <label for="fecha">Día</label>
    						<input type="date" class="form-control" id="fecha" name="fecha" required min="${LocalDate.now()}" max="${LocalDate.now().plusMonths(1)}">
                        </div>
                        <div class="form-group">
						    <label for="hora">Horario</label>
						    <select class="form-control" id="hora" name="hora" required>
						        <option value="">Seleccione un horario</option>
						        <option value="09:00">09:00 AM</option>
						        <option value="10:00">10:00 AM</option>
						        <option value="11:00">11:00 AM</option>
						        <option value="12:00">12:00 PM</option>
						        <option value="13:00">01:00 PM</option>
						        <option value="14:00">02:00 PM</option>
						        <option value="15:00">03:00 PM</option>
						        <option value="16:00">04:00 PM</option>
						        <option value="17:00">05:00 PM</option>
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
                        <button type="submit" class="btn btn-primary">Guardar</button>
                    </form>
                </div>

                <div class="table-responsive">
                    <table summary="Los turnos registrados en la Clinica">
                        <legend>Listado de Turnos</legend>
                        <thead>
                            <tr>
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
                                        <td>${turno.getId()}<input type="hidden" name="turno" value="${turno}"></td>
                                        <td>${turno.getMedico().getNombre()} ${turno.getMedico().getApellido()}</td>
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

    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
