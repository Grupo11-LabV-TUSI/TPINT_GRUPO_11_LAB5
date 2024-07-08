<%@ page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>Paciente</title>
<style type="text/css">
<
jsp




:include


 


page




="../
css
/StyleSheet




.css




"
>
</
jsp




:include
>
</style>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/v/bs4-4.1.1/jq-3.3.1/dt-1.10.18/sl-1.2.6/datatables.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.7/css/jquery.dataTables.css" />
</head>
<body>

<% %>
${mensaje};



<script type="text/javascript">
    $(document).ready(function() {
        var mensaje = "${mensaje}";

        if (mensaje !== null && mensaje.trim() !== "") {
            alert(mensaje);
        }
    });
</script>

	<script type="text/javascript">
    // Preparar las listas de provincias y localidades para JavaScript
    var provincias = [];
    <c:forEach var="provincia" items="${listaProvincias}">
        provincias.push({idProvincia: ${provincia.idProvincia}, descripcion: '${provincia.descripcion}'});
    </c:forEach>

    var localidades = [];
    <c:forEach var="localidad" items="${listaLocalidades}">
        localidades.push({idLocalidad: ${localidad.idLocalidad}, descripcion: '${localidad.descripcion}', idProvincia: ${localidad.provincia.idProvincia}});
    </c:forEach>

    $(document).ready(function() {
        // Manejar el cambio en el selector de provincias
        $('#provincias').change(function() {
            var provinciaId = $(this).val();
            $('#localidades').empty(); // Limpiar el select de localidades
            $('#localidades').append('<option value="">Seleccione una localidad</option>');

            // Filtrar localidades por idProvincia seleccionado
            localidades.forEach(function(localidad) {
                if (localidad.idProvincia == provinciaId) {
                    $('#localidades').append('<option value="' + localidad.idLocalidad + '">' + localidad.descripcion + '</option>');
                }
            });
        });
    });
</script>

	
	
	

	<script type="text/javascript">
		$(document).ready(function() {
			$('#tabla_paciente').DataTable({});
		});
	</script>

	<jsp:include page="Menu.jsp"></jsp:include>

	<div class="container">
		<h2>ABML PACIENTES</h2>

		<div class="container">
			<div class="row">
				<div class="col-sm"></div>
				<div class="col-sm"></div>
			</div>
		</div>

		<!--//////////////////Inicio de tabla////////////////////////////-->


		<section class="row justify-content-center pt-1 px-1"
			style="width: calc(100% + 20px); margin-left: -10px;">
		<fieldset>
			<legend>ABML Pacientes</legend>

			<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container">
				<!-- Bot�n de Inicio -->
				<form class="form-inline mr-auto" action="cargar_inicio.html"
					method="get">
					<button class="btn btn-primary" type="submit" name="btnNavIrInicio">Inicio</button>
				</form>
				<!-- Bot�n de Alta Paciente -->
				<button class="btn btn-success" type="button" data-toggle="modal"
					data-target="#userModal" style="margin-right: 10px">Alta
					Paciente</button>
				<!-- Bot�n de Update Paciente -->

			</div>
			</nav>

			</br>

		


			<div class="table-responsive" style="width: calc(100% - 20px);">
				</form>
				<table id="tabla_paciente" class="display">
					<thead>
						<tr>
							<th>MODIFICAR</th>
							<th>DETALLES</th>

							<th>DNI</th>
							<th>NOMBRE</th>
							<th>APELLIDO</th>
							<th>FECHA NACIMIENTO</th>
							<th>ESTADO</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaPacientes}" var="paciente">
							<tr>
								<td>
									<form type="submit" action="modificar_paciente.html"
										metodo="Post">

										<input type="submit" name="btnModificarPaciente"
											value="Modificar Paciente" class="btn btn-info"> <input
											type="hidden" name="dni" value="${paciente.getDni()}">
									</form>
								</td>

								<form action="ver_detalle_paciente.html" method="get">
									<td><input type="submit" name="btnVerPaciente" value="Ver"
										class="btn btn-warning"></td>
									<td>${paciente.getDni()}</td> <input type="hidden"
										name="paciente" value="${paciente}"> <input
										type="hidden" name="dni" value="${paciente.getDni()}">
									<td>${paciente.getNombre()}</td>
									<td>${paciente.getApellido()}</td>
									<td>${paciente.getFecha_nacimiento()}</td>
								</form>

								<td>
									<form action="actualizar_estado_paciente.html" method="get">
										<input type="hidden" name="dni" value="${paciente.getDni()}">
										<c:choose>
											<c:when test="${paciente.getEstado()}">
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
			</div>
		</fieldset>
		</section>

		<!--//////////////////FIN TABLA//////////////////////////////////-->

		<!--//////////////////MODAL DETALLE PACIENTE //////////////////////////////////-->
	</div>
	<form action="alta_paciente.html" method="post">
		<div class="modal fade" id="userModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<!-- Cabecera del Modal -->
					<div class="modal-header">
						<h4 class="modal-title">Formulario de Carga de Paciente</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<!-- Cuerpo del Modal -->
					<div class="modal-body">
						<form action="ServletClientes" method="post">
							<table>
								<tr>
									<td style="width: 139px;">DNI</td>
									<td style="height: 0px;"><input type="Number"
										name="txtDNI" min="1" max="99999999" required maxlength="10"
										autocomplete="off"
										onkeypress="return((event.charCode >= 48 && event.charCode <= 57))"
										value="00.000.000" /><br></td>
								</tr>
								<tr>
									<td>Nombre:</td>
									<td style="height: 0px;"><input type="text"
										name="txtNOMBRE" style="text-transform: uppercase" /></td>
									<td></td>
								</tr>
								<tr>
									<td>Apellido:</td>
									<td style="height: 0px;"><input type="text"
										name="txtAPELLIDO" style="text-transform: uppercase" /></td>
								</tr>
								<tr>
									<td>Fecha de Nacimiento:</td>
									<td style="height: 0px;"><input type="date"
										name="txtFECHA_NAC" value="DD/MM/AAAA" required /><br></td>
								</tr>
								<tr>
									<td>Domicilio:</td>
									<td style="height: 0px;"><input type="text"
										name="txtDIRECCION" required maxlength="40" autocomplete="off"
										style="text-transform: uppercase" /><br></td>
								</tr>
								<tr>
									<td>Correo Electr�nico:</td>
									<td style="height: 0px;"><input type="email"
										name="textEMAIL" required /></td>
								</tr>
								<tr>
									<td>Telefono:</td>
									<td style="height: 0px;"><input type="tel"
										 required name="txtTELEFONO" /></td>
								</tr>

								

				
								<tr>

								<td>Provincia:</td>
								<td>
								<select id="provincias" name="provinciasTXT" required>
									<c:forEach var="provincia" items="${listaProvincias}">
										<option value="${provincia.idProvincia}">${provincia.descripcion}</option>
									</c:forEach>
								</select>
								</td>

								</tr>
								<td>Localidad:</td>
								  <td>
     	  							 <select  id="localidades" name="localidades" required>
       							     <option value="">Seleccione una localidad</option>
       								 </select>
      								  </td>

								</tr>




								<br />
							</table>
						</form>
					</div>
					<!-- Pie del Modal -->
					<div class="modal-footer">
						<input type="submit" name="bntAltaEnviar" value="Alta"
							class="btn btn-success">
	</form>
	<form action="ABML_paciente.html" method="post">
		<input type="submit" name="bntCancelar" value="Cancelar"
			class="btn btn-danger">
	</form>



</div>
	
</div></div>




<jsp:include page="footer.jsp"></jsp:include>


</body>

</html>
