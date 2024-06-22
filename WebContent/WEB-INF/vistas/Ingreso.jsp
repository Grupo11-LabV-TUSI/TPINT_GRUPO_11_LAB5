<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingreso</title>
<style type="text/css">
	<jsp:include page="../css/StyleSheet.css"></jsp:include>
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<header class="text-center">
	<h1>TP INTEGRADOR LABORATORIO V</h1>
</header>

<nav class="navbar bg-body-tertiary sticky-top">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">${usuarioIngresado.getUsuario()}</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
      <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasNavbarLabel">TP Integardor LAB V</h5>
        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <div class="offcanvas-body">
        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
          <li class="nav-item">
            <form class="d-flex mt-3" action="cargar_inicio.html" method="get">
          		<input class="btn btn-outline-primary" type="submit" value="Inicio" name="btnNavIrInicio">
        	</form>
          </li>
          <li class="nav-item dropdown">
          	<form class="d-flex mt-3">
          		<button class="btn btn-outline-primary" type="submit">Nosotros</button>
        	</form>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Usuario
            </a>
            <ul class="dropdown-menu">
              <c:if test="${empty usuarioIngresado.getUsuario()}">
              <li>
              	<form class="d-flex mt-3" action=redireccionar_ingreso.html method="get">
          			<input class="btn btn-outline-success" type="submit" value="Ingresar" name="btnNavIngresar">
        		</form>
              </li>
              </c:if>
              <li>
                <hr class="dropdown-divider">
              </li>
              <c:if test="${not empty usuarioIngresado.getUsuario()}">
              <li>
              	<form class="d-flex mt-3" action="redireccionar_ingreso.html" method="get">
          			<button class="btn btn-outline-danger" type="submit">Salir</button>
        		</form>
              </li>
              </c:if>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </div>
</nav>

<main class="container-fluid m-0 px-3 py-3">
	<article class="row">
		<section class="col-12">
			<div class="coontainer mt-5">
				<form class="row g-3 needs-validation" novalidate action="validar_ingreso.html" method="get">
            		<div class="row justify-content-center pt-3">
              			<!-- usuario -->
              			<div class="col-md-4">
                			<label for="txtUsuario" class="form-label">Usuario</label>
               				<input
			                  type="text"
			                  class="form-control"
			                  id="txtUsuario"
			                  name="txtUsuario"
			                  value=""
			                  required
			                  pattern="^[a-zA-Z0-9\sñÑáéíóúÁÉÍÓÚ]{5,30}$"
			                />
                			<div class="valid-feedback">Looks good!</div>
                			<div class="invalid-feedback">
                  				Por favor, ingrese un usuario válido. Solo se permiten letras y numero y debe tener entre 5 y 30 caracteres inclusives.
                			</div>
              			</div>
            		</div>
            		<!-- contraseña -->
		            <div class="row justify-content-center pt-3">
		              <div class="col-md-4">
		                <label for="txtPassword" class="form-label">Contraseña</label>
		                <input
		                  type="password"
		                  class="form-control"
		                  id="txtPassword"
		                  name="txtPassword"
		                  value=""
		                  required
		                  pattern=".{8,}"
		                  maxlength="30"
		                />
		                <div class="valid-feedback">Bien!</div>
		                <div class="invalid-feedback">
		                  Por favor, ingrese un clave válida. Minimo 8 caracteres.
		                </div>
		              </div>
		            </div>
		            <!-- enviar -->
		            <div class="row justify-content-center pt-3">
			            <div class="col-4">
			              <input type="submit" value="Ingresar"name="btnIngresar" class="btn btn-primary">
		            	</div>
		            </div>
		            <div class="row justify-content-center pt-3">
			            <div class="col-4">
			          		<small class="text-danger">${MensajeError}</small>
		            	</div>
		            </div>
          		</form>
			</div>
		</section>
	</article>
</main>

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

<script>
  // Example starter JavaScript for disabling form submissions if there are invalid fields
  (() => {
    "use strict";

    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    const forms = document.querySelectorAll(".needs-validation");

    // Loop over them and prevent submission
    Array.from(forms).forEach((form) => {
      form.addEventListener(
        "submit",
        (event) => {
          if (!form.checkValidity()) {
            event.preventDefault();
            event.stopPropagation();
          }

          form.classList.add("was-validated");
        },
        false
      );
    });
  })();
</script>

<script
  src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
  integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
  crossorigin="anonymous"
></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>