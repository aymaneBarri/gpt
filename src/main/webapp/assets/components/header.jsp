<%@page import="model.Utilisateur"%>
<%@page import="model.Tache"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
Utilisateur user = null;
if (session.getAttribute("login") != null || session.getAttribute("login") != "") {
	user = (Utilisateur) session.getAttribute("login");
} else {
	response.sendRedirect("Login.jsp");
}
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<link rel="stylesheet"
	href="assets/bootstrap-5.3.3-dist/css/bootstrap.css" />
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script src="assets/bootstrap-5.3.3-dist/js/bootstrap.js"></script>
<script src="assets/jquery-3.7.1.min.js"></script>
<script src="assets/script.js"></script>
<link rel="stylesheet"
	href="assets/fontawesome-free-6.5.2-web/css/all.css" />
<link rel="stylesheet" href="assets/style.css" />
<link href="assets/fonts/Inter/Inter-VariableFont_slnt,wght.ttf"
	rel="stylesheet" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-table@1.22.6/dist/bootstrap-table.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap-table@1.22.6/dist/bootstrap-table.min.js"></script>
</head>

<body>
	<nav class="navbar navbar-expand-sm top-bar">
		<div class="container-fluid">
			<a class="navbar-brand text-light" href="#">GPT</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active text-light"
						aria-current="page" href="dashboard">Dashboard</a></li>
					<li class="nav-item"><a class="nav-link active text-light"
						aria-current="page" href="projets">Mes Projets</a></li>
				</ul>
				<div class="float-end d-inline dropdown">
					<button class="btn text-light" data-bs-toggle="dropdown"
						aria-expanded="false">
						<%=user.getNomUtilisateur()%>
						<i class="fa-solid fa-user"></i>
					</button>
					<ul class="dropdown-menu dropdown-menu-end">
						<li><button class="show-profile dropdown-item"
								data-bs-toggle="offcanvas" data-bs-target="#offcanvas-profile"
								aria-controls="offcanvas-profile">Profile</button></li>
						<li><button class="show-notifications dropdown-item"
								data-bs-toggle="offcanvas"
								data-bs-target="#offcanvas-notifications"
								aria-controls="show-notifications" disabled>Notifications</button></li>

						<li><button class="dropdown-item" href="#" disabled>Parametres</button></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item btn-danger text-danger"
							href="logout">Se deconnecter</a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>