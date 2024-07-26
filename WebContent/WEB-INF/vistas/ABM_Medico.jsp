<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Medicos</title>
		<style type="text/css">
			<jsp:include page="../css/StyleSheet.css"></jsp:include>
		</style>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
		
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/v/bs4-4.1.1/jq-3.3.1/dt-1.10.18/sl-1.2.6/datatables.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.7/css/jquery.dataTables.css" />

	    <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
	    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	    <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
    
        <script type="text/javascript" src="https://cdn.datatables.net/2.0.8/js/dataTables.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/buttons/3.0.2/js/dataTables.buttons.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/buttons/3.0.2/js/buttons.dataTables.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/searchbuilder/1.7.1/js/dataTables.searchBuilder.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/searchbuilder/1.7.1/js/searchBuilder.dataTables.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/datetime/1.5.2/js/dataTables.dateTime.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.10.1/jszip.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.2.7/pdfmake.min.js"></script>        
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.2.7/vfs_fonts.js"></script>
		 <script type="text/javascript" src="https://cdn.datatables.net/buttons/3.0.2/js/buttons.html5.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/buttons/3.0.2/js/buttons.print.min.js"></script>        
        
  <link href="https://cdn.datatables.net/2.0.8/css/dataTables.dataTables.css" rel="stylesheet" />
  	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
    <link href="https://cdn.datatables.net/buttons/3.0.2/css/buttons.dataTables.css" rel="stylesheet" />
      <link href="https://cdn.datatables.net/searchbuilder/1.7.1/css/searchBuilder.dataTables.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
	</head>
	<body>
		<jsp:include page="Menu.jsp"></jsp:include>

	<script>

	  // Setup - add a text input to each footer cell
  //  $('#tabla_Medicos thead tr')
    
		$(document).ready(function() {
		$('#tabla_Medicos').DataTable();
	});
 

	</script>	
<div class="container">
        <h2>Gestión de Medicos</h2>
        
        <div class="container">
  <div class="row">
    <div class="col-sm">
	<!-- Botï¿½n de Inicio -->
				<form class="form-inline mr-auto" action="cargar_inicio.html"
					method="get">
					<button class="btn btn-primary" type="submit" name="btnNavIrInicio">Inicio</button>
				</form>
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
            <table id="tabla_Medicos"  class="table table-striped" summary="Los medicos registrados en la Clinica">
                <caption>
                    Un listado de los medicos registrados en la Clinica
                </caption>
                <thead>
                    <tr>
                        <th></th>
                        <th>MATRICULA</th>
                        <th>NOMBRE</th>
                        <th>EMAIL</th>
                        <th>TELEFONO</th>

                        <th>USUARIO</th>
                        <th>ESPECIALIDAD</th>
  
                        
                        <th></th>
                        
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
	                            <td> ${medico.getNombre()} ${medico.getApellido()}</td>
	                           
	                            <td> ${medico.getEmail()} </td>
	                            <td> ${medico.getTelefono()} </td>
	    
	                            <td> ${medico.getUsuario().getUsuario()} </td>
	                            <td> ${medico.getEspecialidad().getNombre()} </td>
	                            
	                      
	                            
                                  <td>
                                      
                                            <input type="hidden" name="dni" value="${medico.getMatricula()}" >
                                            <c:choose>
                                                <c:when test="${medico.getEstado()}">
                                                    <input type="submit" name="btnEstado" value="Baja"
                                                        class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#confirmDeleteModal" data-matricula="${medico.matricula}">
                                                </c:when>
                                                
                                                <c:otherwise>
                                                	 <input type="submit" name="btnEstado" value="Alta"
                                                        class="btn btn-success" data-bs-toggle="modal" data-bs-target="#confirmAltaModal" data-matricula="${medico.matricula}">
                                                   
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
        <div class="modal fade" id="userModal"  tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
             
                    <!-- Cabecera del Modal -->
                    <div class="modal-header">
                        <h4 class="modal-title">Alta de Medico</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                      <form id="myForm" action="alta_medico.html" method="post">
                    <!-- Cuerpo del Modal -->
                    <div class="modal-body">   
                          <!-- COMIENZO USARIO -->                          
                           <div class="card w-100" >
							  <h5 class="card-header">Usuario</h5>
							  <div class="card-body">
						   <div class="form-group row">
						   <div class="col-sm-6">	
						   <div class="form-group row">
						   	<div class="col-sm-4">	
						   		<label for="email">Usuario:</label>	
						   	</div>	
						    <div class="col-sm-4">
						    <input type="text" id="txtNOMBRE" name="txtUSERID">					    	
						    </div>
						   </div>
						   </div>					
							    <div class="form-group row">
							        <label class="col-sm-4 col-form-label">Clave:</label>
							        <div class="col-sm-4">
							            <input type="password" class="form-control" id="txtCLAVE" name="txtCLAVE" required>
							        </div>
							    </div>							    
							    <div class="form-group row">
							        <label class="col-sm-4 col-form-label">Confirmar Clave:</label>
							        <div class="col-sm-4">
							            <input type="password" class="form-control" id="txtCLAVE2" name="txtCLAVE2" required>
							        </div>
							    </div>				
							     <span id="message" style="color:red;"></span>			
						   </div>
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
		                     <input type="text" class="form-control" id="txtTELEFONO" name="txtTELEFONO" placeholder="+1234567890" value="${medico.telefono}" required>
		                    <!--<input type="phone" id="txtTELEFONO" name="txtTELEFONO">-->
		                    <!--  <input type="text" class="form-control" name="nombre" value="${medico.telefono}"/> -->
		                    </div>
		                </div>
		                <div class="form-group row">
		                    <label class="col-sm-2 col-form-label">Fecha Nacimiento:</label>
		                    <div class="col-sm-6">
		              			<input type="date" id="txtFECHA_NAC" name="txtFECHA_NAC" value="2000-07-22" min="1980-01-01" max="2004-12-31" />		            
		                      <!-- <input type="text" class="form-control" name="nombre" value="${medico.fechaNacimiento}"/> -->  
		                    </div>
		                </div>		                
		                 <div class="form-group row">
		                    <label class="col-sm-2 col-form-label">Email:</label>
		                    <div class="col-sm-6">		                    
		                    <input type="email" class="form-control" id="txtemail" name="txtemail" value="${medico.email}" required />
						      <div class="invalid-feedback">
						        Debe ingresar un correo
						      </div>
		                    <!-- <input type="email" id="textEMAIL" name="textEMAIL">-->
		                    <!-- <input type="text" class="form-control" name="nombre" value="${medico.email}"/> -->  
		                    </div>
		                </div>
		                <div class="form-group row">
                       <div class="col-sm-3">	
                            <label for="especialidad">Especialidad:</label>
                            </div>
                            <div class="col-sm-7">
                            <select class="form-control" id="txtESPECIALIDAD" name="txtESPECIALIDAD" required>
 				               <c:forEach var="especialidad" items="${listaEspecialidades}">
                                    <option value="${especialidad.especialidad_id}" <c:if test="${especialidad.especialidad_id eq medico.especialidad.especialidad_id}">selected</c:if>>${especialidad.nombre}</option>
                                </c:forEach>
                            </select>
                            </div>
                        </div>
		                    
		                <div class="form-group row">
					    <label class="col-sm-2 col-form-label">Horarios:</label>
					        <div class="col-sm-6">

					                <select class="js-example-basic-multiple js-states form-control" id="horario" name="horario" multiple="multiple" required>
								 <c:forEach var="horario" items="${listaHorarios}">
                                    <option value="${horario.id}">${horario.dia}-${horario.horaInicio}-${horario.horaFin}</option>
                                </c:forEach>
									</select>						        								
		                    </div>		 
		                </div>		          
                                            <script> 
                                            	$(".js-example-basic-multiple").select2({
                                                    placeholder: {
	                                                    id: 0,
	                                                    text: "Seleccione un Horario"
                                                    },
                                                    dropdownParent: $('#userModal')
													});
                                             </script>
						
		              

                    </div>
                    <!-- Pie del Modal -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                       <div class="form-group row">
		                    <div class="col-sm-10">
		                        <input type="submit" name="btnAgregarMedico" class="btn btn-primary" />
		                    </div>
		                </div>
		          
                    </div>
                   </form>
                </div>
            </div>
        </div>
    </div>
		

  
  <!-- Modal EDITAR MEDICO -->
    <div class="modal fade" id="medicoModal" tabindex="-1" role="dialog" aria-hidden="true" >
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                        <h4 class="modal-title">Modificar Medico</h4>
                        <button type="button" class="close" data-bs-dismiss="modal">&times;</button>
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
						    <input type="text" class="form-control" id="nombre" name="nombre" value="${medico.nombre}" required />
						 				    	
						    </div>
						   </div>
						   
						    <div class="form-group row">
						   	<div class="col-sm-3">	
						   		<label for="email">Apellido:</label>	
						   	</div>	
						    <div class="col-sm-7">
						     <input type="text" class="form-control" id="apellido" name="apellido" value="${medico.apellido}" required />
					    	
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

                        	                <div class="form-group row">
					    <label class="col-sm-2 col-form-label">Horarios:</label>
					    
					        <div class="col-sm-4">
					        <label class="col-sm-2 col-form-label">Actuales:</label>
					        <ul class="list-group">
					        <c:forEach var="horario" items="${listaHorarios}">
					        <li class="list-group-item">${horario.dia}-${horario.horaInicio}-${horario.horaFin}</li>
					        </c:forEach>
					        </ul>
							</div>
							
							<div class="col-sm-4">
							<label class="col-sm-2 col-form-label">Asignar:</label>
        <select class="js-example-basic-multiple" id="horario" Style="width: 100%" name="horario" multiple="multiple" required>
            <c:forEach var="horario" items="${listatodosHorarios}">
                <option value="${horario.id}" >${horario.dia}-${horario.horaInicio}-${horario.horaFin}</option>
            </c:forEach>
        </select>					        								
		                    </div>		 
		                </div>		          

     		                <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/js/select2.min.js"></script>
	
                                            <script> 
                                            	$(".js-example-basic-multiple").select2({
                                                    placeholder: {
	                                                    id: 0,
	                                                    text: "Seleccione un Horario"
                                                    },
                                                    dropdownParent: $('#medicoModal')
													});
                                             </script>
						
						
						
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
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cerrar</button>
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
                <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                ¿Está seguro que desea eliminar este médico?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                <form id="deleteMedicoForm" action="eliminar_medico.html" method="post" style="display:inline;">
                    <input type="hidden" name="matricula" id="deleteMedicoMatricula">
                    <button type="submit" class="btn btn-danger">Eliminar</button>
                </form>
            </div>
        </div>
    </div>
</div>


<!-- Confirm Alta Modal -->
<div class="modal fade" id="confirmAltaModal" tabindex="-1" role="dialog" aria-labelledby="confirmAltaModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="confirmAltaModalLabel">Confirmar Alta </h5>
                <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                ¿Está seguro que desea dar de alta a este médico?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                <form id="altaMedicoForm" action="habilitar_medico.html" method="post" style="display:inline;">
                    <input type="hidden" name="matricula" id="altaMedicoMatricula">
                    <button type="submit" class="btn btn-success">Alta</button>
                </form>
            </div>
        </div>
    </div>
</div>


    <script type="text/javascript">

    document.getElementById('txtCLAVE2').addEventListener('blur', function() {
        var txtCLAVE = document.getElementById('txtCLAVE').value;
        var txtCLAVE2 = this.value;
        var message = document.getElementById('message');

        if (txtCLAVE2 !== txtCLAVE) {
            message.textContent = 'Las claves no son iguales';
        } else {
            message.textContent = '';
        }
    });

    document.getElementById('myForm').addEventListener('submit', function(event) {
        var txtCLAVE = document.getElementById('txtCLAVE').value;
        var txtCLAVE2 = document.getElementById('txtCLAVE2').value;
        var message = document.getElementById('message');

        if (txtCLAVE2 !== txtCLAVE) {
            event.preventDefault();
            message.textContent = 'Las claves no son iguales';
        }
    });
	
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

        document.getElementById('myForm').addEventListener('submit', (event) => {
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