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
        <h2>Gestión de Usuarios</h2>
        
        <div class="container">
  <div class="row">
    <div class="col-sm">

    </div>
    <div class="col-sm">

    </div>
    <div class="col-sm">
        <!-- Botón para abrir el modal -->
        <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#userModal">
            Añadir Medico
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
                       <form action="agregar_medico.html" method="post">
		                <div class="form-group row">
		                    <label class="col-sm-2 col-form-label">Nombre:</label>
		                    <div class="col-sm-6">
		                        <!-- <input type="text" class="form-control" name="nombre" value="${medico.nombre}"/> -->
		                        <input type="text" id="txtnombre" name="txtnombre">
		                    </div>
		                </div>
		                
		                <div class="form-group row">
		                    <label class="col-sm-2 col-form-label">Apellido:</label>
		                    <div class="col-sm-6">
		                     <input type="text" id="txtapellido" name="txtapellido">
		                    <!--  <input type="text" class="form-control" name="nombre" value="${medico.apellido}"/> -->
		                       
		                    </div>
		                </div>
		                
		                <div class="form-group row">
		                    <label class="col-sm-2 col-form-label">Telefono:</label>
		                    <div class="col-sm-6">
		                    <input type="phone" id="txttelefono" name="txttelefono">
		                    <!--  <input type="text" class="form-control" name="nombre" value="${medico.telefono}"/> -->
		                       
		                    </div>
		                </div>
		                
		                <div class="form-group row">
		                    <label class="col-sm-2 col-form-label">Fecha Nacimiento:</label>
		                    <div class="col-sm-6">
		              			<input type="date" id="txtfechaNacimiento" name="txtfechaNacimiento" value="2018-07-22" min="2018-01-01" max="2018-12-31" />

		            
		                      <!-- <input type="text" class="form-control" name="nombre" value="${medico.fechaNacimiento}"/> -->  
		                    </div>
		                </div>
		                
		                 <div class="form-group row">
		                    <label class="col-sm-2 col-form-label">Email:</label>
		                    <div class="col-sm-6">
		                    <input type="email" id="txtemail" name="txtemail">
		                    <!-- <input type="text" class="form-control" name="nombre" value="${medico.email}"/> -->  
		                        
		                    </div>
		                </div>

						 <div class="form-group row">
						            <label class="col-sm-2 col-form-label">Especialidad:</label>
						            <div class="col-sm-6">
						                <select class="form-control" name="txtespecialidad">
						                    <option value="1">Odontología</option>
						                    <option value="2">Pediatría</option>
						                </select>
						            </div>
						        </div>

		                 <br />
		                <div class="form-group row">
		                    <div class="col-sm-10">
		                        <input type="submit" name="btnAgregarMedico" class="btn btn-primary" />
		                    </div>
		                </div>
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