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
								aria-controls="show-notifications">Notifications</button></li>

						<li><a class="dropdown-item" href="#">Parametres</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item btn-danger text-danger"
							href="logout">Se deconnecter</a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>

	<!-- <div class="control-bar d-flex justify-content-end">
		<form class="col-12 col-sm-6 col-md-4 mb-2 mb-sm-0 " role="search">
			<input class="form-control search-bar" type="search"
				placeholder="Search" aria-label="Search" />
		</form>
		<button type="button" class="btn btn-primary">Mes projets</button>
	</div> -->

	<div class="container-fluid p-3 px-lg-4 px-xl-5 px-xxl-6">
	<span class="h5">Mes Projets</span>
	
	<div id="projects" class="row mt-4">
		<%@page import="model.Tache"%>
		<%@page import="model.PrioriteTache"%>
		<%@page import="java.util.List"%>
		<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
		<%@ taglib prefix="c" uri="jakarta.tags.core"%>
		<%@page import="com.google.gson.*"%>
		<div id="todo-card">
			<div class="card tache-list shadow-sm">
				<div class="mb-3 d-flex justify-content-between align-items-center">
					<span class="card-title text-danger"><i
						class="fa-solid fa-clock"></i> En attente</span>
				</div>
				<%
				List<Tache> listeTachesEnAttente = (List<Tache>) request.getAttribute("listeTachesEnAttente");
				if (listeTachesEnAttente != null && !listeTachesEnAttente.isEmpty()) {
				%>

				<div class="mb-3 d-flex justify-content-center align-items-center">
					<div class="col-2">
						<span id="priorite-header" value="<%=listeTachesEnAttente%>">Priorite</span>
					</div>
					<div class="col-4">
						<span id="titre-header">Titre</span>
					</div>
					<div class="col-4">
						<span id="delai-header">Delai</span>
					</div>
					<div class="col-2">Options</div>
				</div>

				<%
				for (Tache t : listeTachesEnAttente) {
				%>
				<div
					class="tache-item mb-3 d-flex shadow-sm justify-content-center align-items-center">
					<div class="col-2">
						<i
							class="fa-solid fa-circle 
					<c:choose>
					    <c:when test="<%=t.getPrioriteTache() == PrioriteTache.Haute%>">
					        text-danger
					    </c:when>
					    <c:when test="<%=t.getPrioriteTache() == PrioriteTache.Moyenne%>">
					        text-warning
					    </c:when>
					    <c:when test="<%=t.getPrioriteTache() == PrioriteTache.Faible%>">
					        text-success
					    </c:when>    
					    <c:otherwise>
					        text-primary
					    </c:otherwise>
					</c:choose>
				"></i>
					</div>
					<div class="col-4">
						<%=t.getNomTache()%>
					</div>
					<div class="col-4">
						<%=t.getDateEcheance()%>
					</div>
					<div class="col-2 dropdown">
						<button class="btn" type="button" data-bs-toggle="dropdown"
							aria-expanded="false">
							<i class="fa-solid fa-ellipsis"></i>
						</button>
						<ul class="dropdown-menu dropdown-menu-end">
							<li><button class="start-task dropdown-item"
									value="<%=t.getIdTache()%>">Commencer la tâche</button></li>
							<li>
								<button class="show-comments dropdown-item"
									data-bs-toggle="offcanvas" data-bs-target="#offcanvas-comments"
									aria-controls="offcanvas-comments" value="<%=t.getIdTache()%>">Ajouter
									un commentaire</button>
							</li>
							<li><hr class="dropdown-divider"></li>
							<li><button class="dropdown-item">Plus de détails</button></li>
						</ul>
					</div>
				</div>
				<%
				}
				} else {
				%>
				<span>Aucune tâche en attente</span>
				<%
				}
				%>
			</div>
		</div>

		<script>
			$("#priorite-header").click(function() {
				console.log('priorite-header clicked' + this.data);
				var arr =
		<%=listeTachesEnAttente%>
			;
				$.each(arr, function(i, l) {
					console.log("Index #" + i + ": " + l);
					<!--
					$.ajax({
						url : 'dashboard',
						success : function(response) {

							console.log('priorite-header clicked' + this.data);
						},
					});
					-->
				});
			});
		</script>
	</div>
</div>
	<jsp:include page="assets/components/profile.jsp" />
	<jsp:include page="assets/components/notifications.jsp" />

</body>

</html>