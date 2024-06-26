<%@ page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz4fnFO9gyb5u7eJp6Su9e/d7f9EXeLhOHVPxjn0x4q2n02Pp/u1p65kMf" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-QH5iYY8r0AUt56+mXq63jaGGZNB3LqGAkvgxa1SOWJYjH/ZE1rEJEQG5g8E4Unf/" crossorigin="anonymous"></script>
<script>
    $(document).ready(function(){
        $("#userModal").modal('show');
    });
</script>
</head>
<body>
    <jsp:include page="Menu.jsp"></jsp:include>
    
    <div class="container">
        <h2>Gestión de Usuarios</h2>
        
        <div class="container">
            <div class="row">
                <div class="col-sm"></div>
                <div class="col-sm"></div>
                <div class="col-sm">
               
                    </button>
                </div>
            </div>
        </div>

       

    </div>

    <!-- El Modal -->
    <div class="modal fade" id="userModal" tabindex="-1" aria-labelledby="userModalLabel" aria-hidden="true" data-bs-backdrop="static" data-bs-keyboard="false">
    
   
                        <form action="ABML_paciente.html" method="get">
    
        <div class="modal-dialog">
            <div class="modal-content">
                <!-- Cabecera del Modal -->
                <div class="modal-header">
                    <h4 class="modal-title">Detalle de Paciente</h4>
                    
                    
                    <input type="submit"  class="btn-close" name="btnCerrar" value=" " > 
                  
                </div>
                <!-- Cuerpo del Modal -->
                <div class="modal-body">
                    <form action="ServletClientes" method="post">
                        <table>
                          
                            <tr> 
                                <td>Nombre: </td>
                                <td style="height: 0px;"><input type="text" name="txtNOMBRE" readonly value="${detalles_paci.getNombre()}" style="text-transform:uppercase"/> </td>
                            </tr>    
                            
                              <tr> 
                                <td style="width: 139px;">DNI</td>
                                <td style="height: 0px;"><input type="Number" name="txtDNI"  readonly value="${detalles_paci.getDni()}" /></td>
                            </tr>
                            
                            <tr>
                                <td>Apellido: </td>
                                <td style="height: 0px;"><input type="text" name="txtAPELLIDO" readonly style="text-transform:uppercase" value="${detalles_paci.getApellido()}"/></td>
                            </tr>
                            <tr> 
                                <td>Fecha de Nacimiento: </td>
                                <td style="height: 0px;"><input type="date" name="txtFECHA_NAC"   readonly value="${detalles_paci.getFecha_nacimiento()}"/><br></td>        
                            </tr>    
                           
                            <tr>
                                <td>Domicilio: </td>
                                <td style="height: 0px;"><input type="text" name="txtDIRECCION" readonly style="text-transform:uppercase" value="${detalles_paci.getDireccion()}"/><br></td>    
                            </tr>
                            <tr>
                                <td>Correo Electrónico: </td>
                                <td style="height: 0px;"><input type="text" name="textEMAIL" readonly value="${detalles_paci.getEmail()}"/> </td>    
                            </tr>
                            <tr> 
                                <td>Teléfono: </td>
                                <td style="height: 0px;"><input type="tel" name="txtTELEFONO"  readonly value="${detalles_paci.getTelefono()}"/></td>
                            </tr>
                             
                            <tr>
                                <td>Localidad: </td>
                                <td style="height: 0px;"><input type="text" name="txtLocalidad" readonly value="${detalles_paci.getLocalidad()}"/></td>
                            </tr>
                            <tr>
                            	<td>Provincia: </td>
                                <td style="height: 0px;"><input type="text" name="txtProvincia" readonly value="${detalles_paci.getProvincia()}"/></td>
                                
                            </tr>
                            
                           
                        </table>
                        </br>
                    </form>
                </div>
                <!-- Pie del Modal -->
                <div class="modal-footer">
                	
                    	<input type="submit" name="abml_paciente" value="Cerrar" class="btn btn-danger"> 
                    	
               		     
               	    </form>
                </div>
            </div>
        </div>
    </div>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>
