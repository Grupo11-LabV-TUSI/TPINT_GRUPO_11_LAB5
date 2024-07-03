<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.time.LocalDate"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Turnos</title>
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


<section class="row justify-content-center pt-2 px-1">
    <fieldset>
        <legend>ABM Medicos</legend>
        <div class="table-responsive">
            <table summary="Los medicos registrados en la Clinica">
                <caption>
                    Un listado de los medicos registrados en la Clinica
                </caption>
                <thead>
                    <tr>
                        <th style="width:70px"></th>
                        <th style="width:110px">MATRICULA</th>
                        <th style="width:130px">NOMBRE</th>
                        <th>APELLIDO</th>
                        <th style="width:250px">EMAIL</th>
                        <th>TELEFONO</th>
                        <th style="width:130px">FECHA NACIMIENTO</th>
                        <th>USUARIO</th>
                        <th style="width:140px">ESPECIALIDAD</th>
                        <th style="width:80px">ESTADO</th>
                        <th style="width:100px"></th>
                        
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaMedicos}" var="medico">
                        <tr>
                        		<td>
                       				<form action="ABM_Medico.html" method="get">
		                            	 <input type="hidden" name="matricula" value="${medico.getMatricula()}">
		                                 <input type="submit" class="btn btn-warning" name="btnVerMedico" value="Ver" class="bg-warning">
                                     </form>
                                </td>                                     
	                            <td> ${medico.getMatricula()} </td>
	                            <td> ${medico.getNombre()} </td>
	                            <td> ${medico.getApellido()} </td>
	                            <td> ${medico.getEmail()} </td>
	                            <td> ${medico.getTelefono()} </td>
	                            <td> ${medico.getFechaNacimiento()} </td>
	                            <td> ${medico.getUsuario().getUsuario()} </td>
	                            <td> ${medico.getEspecialidad().getNombre()} </td>
	                            <td> ${medico.getEstado()} </td>
	                            
                                  <td>
                                      
                                            <input type="hidden" name="dni" value="${medico.getMatricula()}" >
                                            <c:choose>
                                                <c:when test="${medico.getEstado()}">
                                                    <input type="submit" name="btnEstado" value="Baja"
                                                        class="btn btn-danger" data-toggle="modal" data-target="#confirmDeleteModal" data-matricula="${medico.matricula}">
                                                </c:when>
                                                
                                                <c:otherwise>
                                                	 <input type="submit" name="btnEstado" value="Alta"
                                                        class="btn btn-success" data-toggle="modal" data-target="#confirmAltaModal" data-matricula="${medico.matricula}">
                                                   
                                                </c:otherwise>
                                            </c:choose>
                                
                                    </td>
                         
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
                       <form action="alta_medico.html" method="post">
                          <!-- COMIENZO USARIO -->
                       <div class="form-group row">
		                    <label class="col-sm-2 col-form-label">Userid:</label>
		                    <div class="col-sm-6">
		                        <!-- <input type="text" class="form-control" name="nombre" value="${medico.nombre}"/> -->
		                        <input type="text" id="txtNOMBRE" name="txtUSERID">
		                    </div>
		                </div>
		                
		                <div class="form-group row">
		                    <label class="col-sm-2 col-form-label">Clave:</label>
		                    <div class="col-sm-6">
		                     <input type="password" id="txtAPELLIDO" name="txtCLAVE">
		                    <!--  <input type="text" class="form-control" name="nombre" value="${medico.apellido}"/> -->
		                       
		                    </div>
		                </div>
		                
		                <!-- FIN USARIO -->
		                <div class="form-group row">
		                    <label class="col-sm-2 col-form-label">Nombre:</label>
		                    <div class="col-sm-6">
		                        <!-- <input type="text" class="form-control" name="nombre" value="${medico.nombre}"/> -->
		                        <input type="text" id="txtNOMBRE" name="txtNOMBRE">
		                    </div>
		                </div>
		                
		                <div class="form-group row">
		                    <label class="col-sm-2 col-form-label">Apellido:</label>
		                    <div class="col-sm-6">
		                     <input type="text" id="txtAPELLIDO" name="txtAPELLIDO">
		                    <!--  <input type="text" class="form-control" name="nombre" value="${medico.apellido}"/> -->
		                       
		                    </div>
		                </div>
		                
		                <div class="form-group row">
		                    <label class="col-sm-2 col-form-label">Telefono:</label>
		                    <div class="col-sm-6">
		                    <input type="phone" id="txtTELEFONO" name="txtTELEFONO">
		                    <!--  <input type="text" class="form-control" name="nombre" value="${medico.telefono}"/> -->
		                       
		                    </div>
		                </div>
		                
		                <div class="form-group row">
		                    <label class="col-sm-2 col-form-label">Fecha Nacimiento:</label>
		                    <div class="col-sm-6">
		              			<input type="date" id="txtFECHA_NAC" name="txtFECHA_NAC" value="2018-07-22" min="2018-01-01" max="2018-12-31" />

		            
		                      <!-- <input type="text" class="form-control" name="nombre" value="${medico.fechaNacimiento}"/> -->  
		                    </div>
		                </div>
		                
		                 <div class="form-group row">
		                    <label class="col-sm-2 col-form-label">Email:</label>
		                    <div class="col-sm-6">
		                    <input type="email" id="textEMAIL" name="textEMAIL">
		                    <!-- <input type="text" class="form-control" name="nombre" value="${medico.email}"/> -->  
		                        
		                    </div>
		                </div>

						 <div class="form-group row">
						            <label class="col-sm-2 col-form-label">Especialidad:</label>
						            <div class="col-sm-6">
						                <select class="form-control" id="textESPECIALIDAD" name="textESPECIALIDAD">
						                    <option value="1">Odontología</option>
						                    <option value="2">Pediatría</option>
						                </select>
						            </div>
						        </div>

		              
 
                    </div>
                    <!-- Pie del Modal -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                       <div class="form-group row">
		                    <div class="col-sm-10">
		                        <input type="submit" name="btnAgregarMedico" class="btn btn-primary" />
		                    </div>
		                </div>
		           </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
		

  
  <!-- Modal EDITAR MEDICO -->
    <div class="modal fade" id="medicoModal" >
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                        <h4 class="modal-title">Modificar Medico</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <form action="actualizar_medico.html" method="post">
                <div class="modal-body">
                    <c:if test="${not empty medico}">
                     		<div class="form-group row">
						   	<div class="col-sm-3">	
						   		<label for="email">Matrícula:</label>	
						   	</div>	
						    <div class="col-sm-7">
						    <input type="hidden" name="matricula" value="${medico.matricula}" />
						    <label for="email">${medico.matricula}</label>						    	
						    </div>
						   </div>
						   
						 
                        
                            <div class="form-group row">
						   	<div class="col-sm-3">	
						   		<label for="email">Nombre:</label>	
						   	</div>	
						    <div class="col-sm-7">
						    <label for="email">${medico.nombre}</label>						    	
						    </div>
						   </div>
						   
						    <div class="form-group row">
						   	<div class="col-sm-3">	
						   		<label for="email">Apellido:</label>	
						   	</div>	
						    <div class="col-sm-7">
						    <label for="email">${medico.apellido}</label>						    	
						    </div>
						   </div>
						   
						   <div class="form-group row">
						   	<div class="col-sm-3">	
						   <label for="validationCustom03">Email:</label>
						   	</div>	
						    <div class="col-sm-7">
						     <input type="email" class="form-control" id="email" name="email" value="${medico.email}" required />
						      <div class="invalid-feedback">
						        Debe ingresar un correo
						      </div>
						        </div>
						          </div>
            
 			          
						   
						   <div class="form-group row">
						   	<div class="col-sm-3">	
						   		<label for="email">Teléfono:</label>	
						   	</div>	
						    <div class="col-sm-7">
						    <input type="text" class="form-control" id="telefono" name="telefono" placeholder="+1234567890" value="${medico.telefono}" required>
						    
						    </div>
						   </div>
                      
						   <div class="form-group row">
						   	<div class="col-sm-3">	
						   		<label for="email">Fecha de Nacimiento:</label>	
						   	</div>	
						    <div class="col-sm-7">
						    	<input type="date" class="form-control" id="email" name="fechaNacimiento" value="${medico.fechaNacimiento}" required />
						    </div>
						   </div>                      

                       <div class="form-group row">
                       <div class="col-sm-3">	
                            <label for="especialidad">Especialidad:</label>
                            </div>
                            <div class="col-sm-7">
                            <select class="form-control" id="especialidad" name="especialidad" required>
 				               <c:forEach var="especialidad" items="${listaEspecialidades}">
                                    <option value="${especialidad.especialidad_id}" <c:if test="${especialidad.especialidad_id eq medico.especialidad.especialidad_id}">selected</c:if>>${especialidad.nombre}</option>
                                </c:forEach>
                            </select>
                            </div>
                        </div>
                          <div class="card w-100" >
							  <h5 class="card-header">Usuario</h5>
							  <div class="card-body">
							    

						   <div class="form-group row">
						   <div class="col-sm-6">	
						   <div class="form-group row">
						   	<div class="col-sm-3">	
						   		<label for="email">Usuario:</label>	
						   	</div>	
						    <div class="col-sm-5">
						    <label for="email">${usuario.usuario}</label>						    	
						    </div>
						   </div>
						   </div>
						   <div class="col-sm-6">	
						   						   <div class="form-group row">
						   	<div class="col-sm-3">	
						   		<label for="email">Clave:</label>	
						   	</div>	
						    <div class="col-sm-8">
						    <input type="password" class="form-control" id="contraseña" name="contraseña" value="${usuario.contraseña}" required />
						 					    	
						    </div>
						   </div>
						   </div>
						   </div>
						   							  </div>
							</div>
                    </c:if>
                    <c:if test="${not empty mensaje}">
                        <p>${mensaje}</p>
                    </c:if>
                </div>
				<div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                   <button type="submit" class="btn btn-primary">Guardar cambios</button>
                </div>
                 </form>
            </div>
        </div>
    </div>


<!-- Confirm Delete Modal -->
<div class="modal fade" id="confirmDeleteModal" tabindex="-1" role="dialog" aria-labelledby="confirmDeleteModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="confirmDeleteModalLabel">Confirmar Eliminación</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                ¿Está seguro que desea eliminar este médico?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <form id="deleteMedicoForm" action="eliminar_medico.html" method="post" style="display:inline;">
                    <input type="hidden" name="matricula" id="deleteMedicoMatricula">
                    <button type="submit" class="btn btn-danger">Eliminar</button>
                </form>
            </div>
        </div>
    </div>
</div>


<!-- Confirm Delete Modal -->
<div class="modal fade" id="confirmAltaModal" tabindex="-1" role="dialog" aria-labelledby="confirmAltaModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="confirmAltaModalLabel">Confirmar Alta </h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                ¿Está seguro que desea dar de alta a este médico?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <form id="altaMedicoForm" action="habilitar_medico.html" method="post" style="display:inline;">
                    <input type="hidden" name="matricula" id="altaMedicoMatricula">
                    <button type="submit" class="btn btn-success">Alta</button>
                </form>
            </div>
        </div>
    </div>
</div>




    <script type="text/javascript">
        $(document).ready(function(){
            <c:if test="${mostrarModal}">
                $('#medicoModal').modal('show');
            </c:if>
        });

    $('#confirmDeleteModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget);
        var matricula = button.data('matricula');
        var modal = $(this);
        modal.find('#deleteMedicoMatricula').val(matricula);
    });
    

    $('#confirmAltaModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget);
        var matricula = button.data('matricula');
        var modal = $(this);
        modal.find('#altaMedicoMatricula').val(matricula);
    });
    
    (function() {
    	  'use strict';
    	  window.addEventListener('load', function() {
    	    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    	    var forms = document.getElementsByClassName('needs-validation');
    	    // Loop over them and prevent submission
    	    var validation = Array.prototype.filter.call(forms, function(form) {
    	      form.addEventListener('submit', function(event) {
    	        if (form.checkValidity() === false) {
    	          event.preventDefault();
    	          event.stopPropagation();
    	        }
    	        form.classList.add('was-validated');
    	      }, false);
    	    });
    	  }, false);
    	})();
    
    document.addEventListener('DOMContentLoaded', (event) => {
        const telefonoInput = document.getElementById('telefono');
        
        telefonoInput.addEventListener('input', () => {
            let value = telefonoInput.value;
            
            // Permitir sólo números y el símbolo '+'
            value = value.replace(/[^0-9+]/g, '');
            
            // Asegurarse de que empiece con '+'
            if (value[0] !== '+') {
                value = '+' + value.replace(/\+/g, '');
            }
            
            // Limitar a un máximo de 10 dígitos después del '+'
            const digits = value.substring(1).replace(/\D/g, '').substring(0, 10);
            telefonoInput.value = '+' + digits;
        });

        document.querySelector('form').addEventListener('submit', (event) => {
            const telefonoValue = telefonoInput.value;

            if (!/^\+\d{10}$/.test(telefonoValue)) {
                event.preventDefault();
                alert('El número de teléfono debe comenzar con "+" y tener exactamente 10 dígitos.');
            }
        });
    });
    
    
    

</script>



		<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>