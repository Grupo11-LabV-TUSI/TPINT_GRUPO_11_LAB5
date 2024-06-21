<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio</title>
</head>
<body>
<p>Esta es la página Inicio Bienvenido ${usuarioIngresado.getUsuario() }</p> 
<h1>Hola ${usuario}, ${password}</h1>

<form action="redireccionar_ingreso.html" method="get">
		<input type="submit" value="Redireccion a pagina Ingresar"
			name="btnRedirigir">
</form>

</body>
</html>