<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingreso</title>
</head>
<body>
	Esta es la página Ingreso
	<form action="validar_ingreso.html" method="get">
		Ingrese su usuario: <input type="text"
			name="txtUsuario"><br />
		Ingrese su clave: <input type="password"
			name="txtPassword"><br/>
		<input type="submit" value="Ingresar"
			name="btnIngresar">
	</form>

</body>
</html>