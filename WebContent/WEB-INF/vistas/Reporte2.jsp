<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reporte 2</title>
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

<link rel="stylesheet" type="text/css"
    href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script type="text/javascript" charset="utf8"
    src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $('#table_id_pacientes_admin').DataTable();
        $('#table_id_medicos_admin').DataTable();
        $('#table_id_turnos_admin').DataTable();
        $('#table_id_estadisticasTurno_admin').DataTable();
        $('#table_id_turnos_medic').DataTable();

        $('.close').click(function() {
            $('#detalleTurnoModal').modal('hide');
        });

        $('.estadoTurnoSelect').change(function() {
            $(this).closest('form').submit();
        });

        $('#detalleTurnoModal .btn-secondary[data-dismiss="modal"]').click(function() {
            $('#detalleTurnoModal').modal('hide');
        });

        $('#tabla_Medicos').DataTable();

        // Al hacer click en el botón de Reportes, mostrar el modal de resultado
        $('#btnAbrirModal').click(function() {
            $('#resultadoModal').modal('show');
        });

        // Función para enviar el formulario de reporte
        $('#btnObtenerReporte').click(function() {
            enviarFormulario();
        });
    });

    // Función para enviar el formulario
    function enviarFormulario() {
        var especialidad = document.getElementById('especialidad').value;
        var fechaInicio = document.getElementById('fechaInicio').value;
        var fechaFin = document.getElementById('fechaFin').value;

        // Asignar valores a los campos del formulario antes de enviarlo
        document.getElementById('especialidadId').value = especialidad;
        document.getElementById('fechaInicioId').value = fechaInicio;
        document.getElementById('fechaFinId').value = fechaFin;

        // Enviar el formulario
        document.getElementById('informesForm1').submit();
    }
</script>
</head>
<body>
 <jsp:include page="Menu.jsp"></jsp:include>
    <!--  -->
    <h2>Reporte 2</h2>
    <br>
    <div>
	<form action="MenuInformes.html" method="post">       
		<button type="submit" class="btn btn-secondary">Reportes</button>    
    </form>
    </div>
    <div class="container">
           <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="resultadoModalLabel">Resultado del Reporte</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <table class="formulario">
                        <tr>
                            <td><b style="font-size: 160%;"> - Resultado -</b></td>
                        </tr>
                        <tr>
                            <td><b style="font-size: 160%;">Medico: </b> <span style="font-family: courier; font-size: 180%;">${nombreMedico}</span></td>
                        </tr>
                        <tr>
                            <td><b style="font-size: 160%;">Cantidad de pacientes:</b><span style="font-size: 180%;">${cantidadTurnos} </span></td>
                        </tr>
                        <tr>
                            <td><b style="font-size: 160%;">MES:</b><span style="font-size: 180%;">  </span></td>
                            <td><b style="font-size: 160%;">AÑO:</b><span style="font-size: 180%;">  </span></td>
                        </tr>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                </div>
            </div>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>