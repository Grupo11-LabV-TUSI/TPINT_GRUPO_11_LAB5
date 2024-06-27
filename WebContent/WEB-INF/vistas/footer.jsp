<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>footer</title>
</head>
<body>
<footer class="bg-dark-subtle footer">
    <div class="container-fluid m-0 py-5">
        <div class="row text-center">
	        <p class="font-weight-bold">Laboratorio de computacion V</p>
    	</div>
	    <div class="row text-center">
	        <small>&copy; Copyright <%= LocalDate.now().getYear() %> <b>UTN FRGP</b> - Todos los Derechos Reservados</small>
	    </div>
    </div>
</footer>

</body>
</html>