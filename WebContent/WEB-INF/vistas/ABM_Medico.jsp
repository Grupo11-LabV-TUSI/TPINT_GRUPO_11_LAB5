<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Medico</title>
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
        <h2>Gesti�n de Usuarios</h2>
        
        <div class="container">
  <div class="row">
    <div class="col-sm">

    </div>
    <div class="col-sm">

    </div>
    <div class="col-sm">
        <!-- Bot�n para abrir el modal -->
        <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#userModal">
            A�adir Medico
        </button>
    </div>
  </div>
</div>

  <!--//////////////////Inicio de tabla////////////////////////////-->


<section class="row justify-content-center pt-1 px-1">
						<fieldset>
							<legend>ABML Medicos</legend>
							<div class="table-responsive">
							<table summary="Los medicos registrados en la Clinica">
								<caption>
		    						Un listado de los medicos registrados en la Clinica
		  						</caption>
							    <thead>
							        <tr>
							 
							            <th>MATRICULA</th>
							            <th>NOMBRE</th>
							            <th>APELLIDO</th>
							            <th>EMAIL</th>
							            <th>TELEFONO</th>
							            <th>FECHA NACIMIENTO</th>
							            <th>USUARIO</th>
							            <th>ESPECIALIDAD</th>
							            <th>HORARIO</th>
							            <th>ESTADO</th>
							             <th>ACCION</th>
							        </tr>
							    </thead>
							    <tbody>
							    	<c:forEach items="${listaMedicos}" var="medico">
								        <tr>
								        	<form action="ver_medico.html" method="get">
								        		<td> <input type="submit" name="btnVerMedico" value="Ver" class="bg-warning"> </td>
									            <td> ${medico.getMatricula()} <input type="hidden" name="medico" value="${medico}"> </td>
									            <td> ${medico.getNombre()} </td>
									            <td> ${medico.getApellido()} </td>
									            <td> ${medico.getEmail()} </td>
									            <td> ${medico.getTelefono()} </td>
									            <td> ${medico.getFechaNacimiento()} </td>
									            <td> ${medico.getUsuario().getUsuario()} </td>
									            <td> ${medico.getEspecialidad().getNombre()} </td>
									            <td> 
									            	<select name="miDropdown">
												        <option value="">Mira Los horarios</option>
												        <c:forEach items="${medico.getHorarios()}" var="opcion">
												            <option value="${opcion.getId()}">${opcion.getDia()}</option>
												        </c:forEach>
												    </select>
									            </td>
									            <td> ${medico.getEstado()} </td>
								        	</form>
								        </tr>
							        </c:forEach>
							    </tbody>					    
							</table>
							</div>
						</fieldset>			
					</section>



  <!--//////////////////FIN TABLA//////////////////////////////////-->


        <!-- El Modal -->
        <div class="modal fade" id="userModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <!-- Cabecera del Modal -->
                    <div class="modal-header">
                        <h4 class="modal-title">Formulario de Carga de Usuario</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <!-- Cuerpo del Modal -->
                    <div class="modal-body">
                       <form action="ServletClientes" method="post">
						<table>
							<tr> 
								<td style="width: 139px; ">Matricula</td>
								<td style="height: 0px; "><input type="Number" name="txtDNI" min="1" max="99999999"
								required  maxlength="10" autocomplete="off" onkeypress="return((event.charCode >= 48 && event.charCode <= 57))"
								value="00.000.000" /><br></td>
							</tr>
								<tr> 
								<td>Nombre: </td>
								<td style="height: 0px; "><input type="text" name="txtNOMBRE" style="text-transform:uppercase"/></td>
								<td></td>
							</tr>	 
							<tr>
							<td>Apellido: </td>
								<td style="height: 0px; "><input type="text" name="txtAPELLIDO" style="text-transform:uppercase"/></td>
							</tr>
							<tr> 
								<td>Fecha de Nacimiento: </td>
								<td style="height: 0px; "><input type="date" name="txtFECHA_NAC" value="DD/MM/AAAA" required/><br></td>		
							</tr>	
							<tr>
								<td>Domicilio: </td>
								<td style="height: 0px; "><input type="text" name="txtDIRECCION" required  maxlength="40" autocomplete="off" style="text-transform:uppercase"/><br></td>	
							</tr>
							<tr>
								<td>Correo Electr�nico: </td>
								<td style="height: 0px; ">  <input type="email" name="textEMAIL" required /> </td>	
							</tr>
							<tr> 
								<td>Tel�fono: </td>
								<td style="height: 0px; "><input type="tel" name="txtTELEFONO"/></td>
							</tr>
						<tr>
							<td>Especialidad: </td>
						<td style="height: 0px; ">
								<select name="txtLOCALIDAD" >
								<option value="1" >Seleccione: </option>
								
									<%
									//if(list_Especialidad!=null)
										//for (Especialidad loc : list_Especialidad) {
									%>
									
									<%
										//}
										%>
										<!-- ACA DESARROLLO LAS OPCIONES -->									 				
								 </select>	
							</td>
						</tr>
							
							
							<tr>
							
							</tr>
							<br />
							<tr>
								<td style="height: 0px; "><input type="submit" name="btnAceptar" value="Agregar"/></td>
							</tr>
						
						</table>
						</form>
                    </div>
                    <!-- Pie del Modal -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>