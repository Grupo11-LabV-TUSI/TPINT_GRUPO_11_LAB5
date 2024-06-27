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

<jsp:include page="Menu.jsp"></jsp:include>

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

<jsp:include page="footer.jsp"></jsp:include>

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

</body>
</html>