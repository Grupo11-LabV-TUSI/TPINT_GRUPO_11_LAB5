<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Paciente</title>
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
        
            Detalle paciente Paciente
        </button>
         
    </div>
  </div>
</div>

										${detalles_paci}
							
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
                        <h4 class="modal-title">Detalle de Paciente</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <!-- Cuerpo del Modal -->
                    <div class="modal-body">
                       <form action="ServletClientes" method="post">
						<table>
							<tr> 
								<td style="width: 139px; ">DNI</td>
								<td style="height: 0px; "><input type="Number" name="txtDNI" min="1" max="99999999" value= "${detalles_paci.getDni()}" /></td>
							</tr>
								<tr> 
								<td>Nombre: </td>
								<td style="height: 0px; "><input type="text" name="txtNOMBRE" value= "${detalles_paci.getNombre()}"style="text-transform:uppercase"/> </td>
								<td></td>
							</tr>	 
							<tr>
							<td>Apellido: </td>
								<td style="height: 0px; "><input type="text" name="txtAPELLIDO" style="text-transform:uppercase"value= "${detalles_paci.getApellido()}"/></td>
							</tr>
							<tr> 
								<td>Fecha de Nacimiento: </td>
								<td style="height: 0px; "><input type="date" name="txtFECHA_NAC" value="DD/MM/AAAA" value= "${detalles_paci.getFecha_nacimiento()}"/><br></td>		
							</tr>	
							<tr>
								<td>Domicilio: </td>
								<td style="height: 0px; "><input type="text" name="txtDIRECCION" required  maxlength="40" autocomplete="off" style="text-transform:uppercase" value= "${detalles_paci.getDireccion()}"/><br></td>	
							</tr>
							<tr>
								<td>Correo Electrónico: </td>
								<td style="height: 0px; ">  <input type="email" name="textEMAIL" required value= "${detalles_paci.getEmail()}"/> </td>	
							</tr>
							<tr> 
								<td>Teléfono: </td>
								<td style="height: 0px; "><input type="tel" name="txtTELEFONO" value= "${detalles_paci.getTelefono()}"/></td>
							</tr>
						<tr>
					
							<td>Localidad: </td>
							<td style="height: 0px; "><input type="text" name="txtLocalidad" value= "${detalles_paci.getLocalidad()}"/></td>

							<!-- 
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
					%>
										<!-- ACA DESARROLLO LAS OPCIONES -->									 				
				
										<!--				
					 </select>	
							</td> -->
						</tr>
							
							
							<tr>
							
							</tr>
							<br />
							<tr>
								<td style="height: 0px; "><input type="submit" name="btnAceptar" value="Alta"/></td>
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
     </tr>

    </div>
 
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>