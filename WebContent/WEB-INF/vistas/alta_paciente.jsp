<%@ page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<!-- jQuery and Bootstrap JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<title>Paciente</title>
</head>
<body>

<script>
    $(document).ready(function() {
        $("#userModal2").modal('show'); // Mostrar el modal automáticamente al cargar la página
    });
</script>


<script>
    $(document).ready(function() {
        $("#userModal2").modal('show'); // Mostrar el modal automáticamente al cargar la página
        
        var localidades = [];
        <c:forEach var="localidad" items="${listaLocalidades}">
            localidades.push({idLocalidad: ${localidad.idLocalidad}, descripcion: '${localidad.descripcion}', idProvincia: ${localidad.provincia.idProvincia}});
        </c:forEach>

        // Seleccionar la primera provincia por defecto y mostrar sus localidades
        var primeraProvinciaId = $('#provincias').val();
        cargarLocalidades(primeraProvinciaId);

        $('#provincias').change(function() {
            var provinciaId = $(this).val();
            cargarLocalidades(provinciaId);
        });

        function cargarLocalidades(provinciaId) {
            $('#localidades').empty(); // Limpiar el select de localidades
            
            
            // Filtrar localidades por idProvincia seleccionado
            localidades.forEach(function(localidad) {
                if (localidad.idProvincia == provinciaId) {
                    $('#localidades').append('<option value="' + localidad.idLocalidad + '">' + localidad.descripcion + '</option>');
                }
            });
        }
    });
</script>

<jsp:include page="Menu.jsp"></jsp:include>

<div class="container">
    <h2>ABML PACIENTES</h2>

    <!-- Modal -->
    <div class="modal fade" id="userModal2" tabindex="-1" aria-labelledby="userModalLabel" aria-hidden="true" data-bs-backdrop="static" data-bs-keyboard="false">
        <div class="modal-dialog">
            <div class="modal-content">
                <!-- Cabecera del Modal -->
                <div class="modal-header">
                    <h4 class="modal-title">Formulario de Alta de Paciente</h4>
                   
                </div>
                <!-- Cuerpo del Modal -->
                <div class="modal-body">
                    <form action="alta_paciente.html" method="post">
                        <table class="table table-striped">
                            <tr>
                                <td style="width: 139px;">DNI</td>
                                <td style="height: 0px;"><input type="Number" name="txtDNI" min="1" max="99999999" required maxlength="10" autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))" value="00.000.000"  class="form-control"/><br></td>
                            </tr>
                            <tr>
                                <td>Nombre:</td>
                                <td style="height: 0px;"><input type="text" name="txtNOMBRE" style="text-transform: uppercase"  class="form-control"/></td>
                            </tr>
                            <tr>
                                <td>Apellido:</td>
                                <td style="height: 0px;"><input type="text" name="txtAPELLIDO" style="text-transform: uppercase" class="form-control"/></td>
                            </tr>
                            <tr>
                                <td>Fecha de Nacimiento:</td>
                                <td style="height: 0px;"><input type="date" name="txtFECHA_NAC" value="DD/MM/AAAA" class="form-control" required max="${LocalDate.now()}" /><br></td>
                            </tr>
                            <tr>
                                <td>Domicilio:</td>
                                <td style="height: 0px;"><input type="text" name="txtDIRECCION" required maxlength="40" autocomplete="off" style="text-transform: uppercase" class="form-control" /><br></td>
                            </tr>
                            <tr>
                                <td>E-Mail:</td>
                                <td style="height: 0px;"><input type="email" name="textEMAIL" required class="form-control" /></td>
                            </tr>
                            <tr>
                                <td>Telefono:</td>
                                <td style="height: 0px;"><input type="Number" required name="txtTELEFONO" min="1" max="99999999"  maxlength="10" class="form-control"/></td>
                            </tr>
                            
                            
                            
                            <tr>
                                <td>Provincia:</td>
                                <td>
                                    <select id="provincias" name="provinciasTXT"  class="form-select" class="form-control" required>
                                        <c:forEach var="provincia" items="${listaProvincias}">
                                            <option value="${provincia.idProvincia}">${provincia.descripcion}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Localidad:</td>
                                <td>
                                    <select id="localidades" name="localidades" class="form-select" required>
                                        <option value="">Seleccione una localidad</option>
                                    </select>
                                </td>
                            </tr>
                            
                            
                            
                        </table>
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
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
