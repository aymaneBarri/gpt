<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Date"%>
<%@page import="model.Projet"%>
<%@page import="java.time.format.DateTimeFormatter"%>
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
	<span class="h5 ms-3">Mes Projets</span>
	
	<div class="details">
		<div class="tache-list">
			
			<%
			List<Projet> listeProjets = (List<Projet>) session.getAttribute("listeProjets");
			LocalDate currentDate = LocalDate.now();
	        
	        // Define a formatter
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        
	        // Format the current date
	        String formattedDate = currentDate.format(formatter);
	        
			if (listeProjets != null && !listeProjets.isEmpty()) {
			%>

			 <table id="table1" class="table table-striped table-bordered table-hover" data-toggle="table" data-sortable="true">
    <thead>
        <tr>
            <th data-sortable="true">Nom</th>
            <th data-sortable="true">Membres</th>
            <th data-sortable="true">Chef du projet</th>
            <th data-sortable="true">Date de fin</th>
            <th>Options</th>
        </tr>
    </thead>
    <tbody>
        <%
        for (Projet t : listeProjets) {
        %>
        <tr data-project-id="<%= t.getIdProjet() %>">
            <td><%= t.getNomProjet() %></td>
            <td>
                <div class="dropdown">
                    <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <%= t.getMembres().size() %> membres
                    </button>
                    <%
                    if (t.getMembres().size() > 0) {
                    %>
                    <ul class="dropdown-menu">
                        <%
                        for (Utilisateur u : t.getMembres()) {
                        %>
                        <li class="dropdown-item disabled"><%= u.getNomUtilisateur() %></li>
                        <%
                        }
                        %>
                    </ul>
                    <%
                    }
                    %>
                </div>
            </td>
            <td><%= t.getChef().getNomUtilisateur() %></td>
            <td><%= t.getDateFin() != null ? t.getDateFin().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")) : formattedDate %></td>
            <td>
                <div class="dropdown">
                    <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <i class="fa-solid fa-ellipsis"></i>
                    </button>
                    <ul class="dropdown-menu dropdown-menu-end">
                        <li><button class="dropdown-item" onclick="editProject(<%= t.getIdProjet() %>)">Modifier</button></li>
                        <li><button class="dropdown-item" onclick="deleteProject(<%= t.getIdProjet() %>)">Supprimer</button></li>
                    </ul>
                </div>
            </td>
        </tr>
        <%
        }
        %>
    </tbody>
</table>

                
                <!-- Modal for editing project details -->
						<form method="post" action="updateProject" class="modal fade" id="editProjectModal" tabindex="-1" aria-labelledby="editProjectModalLabel" aria-hidden="true">
						  <div class="modal-dialog">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h5 class="modal-title" id="editProjectModalLabel">Modifier Projet</h5>
						        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						      </div>
						      <div class="modal-body">
						        <form id="editProjectForm">
						          <div class="mb-3">
						            <label for="projectName" class="form-label">Nom du Projet</label>
						            <input type="text" class="form-control" id="projectName" name="projectName" required>
						          </div>
						          <div class="mb-3">
						            <label for="projectMembers" class="form-label">Membres</label>
						            <input type="text" class="form-control" id="projectMembers" name="projectMembers" required>
						          </div>
						          <div class="mb-3">
						            <label for="projectLeader" class="form-label">Chef du Projet</label>
						            <input type="text" class="form-control" id="projectLeader" name="projectLeader" required>
						          </div>
						          <div class="mb-3">
						            <label for="projectEndDate" class="form-label">Date de Fin</label>
						            <input type="date" class="form-control" id="projectEndDate" name="projectEndDate" required>
						          </div>
						          <input type="hidden" id="projectId" name="projectId">
						          <button type="submit" class="btn btn-primary">Sauvegarder</button>
						        </form>
						      </div>
						    </div>
						  </div>
						</form>
						
						
						<!-- Modal for delete confirmation -->
					<div class="modal fade" id="deleteProjectModal" tabindex="-1" aria-labelledby="deleteProjectModalLabel" aria-hidden="true">
					  <div class="modal-dialog">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="deleteProjectModalLabel">Supprimer Projet</h5>
					        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					      </div>
					      <div class="modal-body">
					        Êtes-vous sûr de vouloir supprimer ce projet?
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Annuler</button>
					        <button type="button" class="btn btn-danger" id="confirmDeleteButton">Supprimer</button>
					      </div>
					    </div>
					  </div>
					</div>

						                
			<%
			} else {
			%>
			<span>Vous n'avez créé aucun projet</span>
			<%
			}
			%>
			<script>
				$(function() {
					$('#table1').bootstrapTable();
					$('#table1').removeClass("table-bordered");
					$('#table1').removeClass("table-hover");
				})
				
				function editProject(projectId) {
				    // Fetch project details based on projectId (could be from the server or a data structure in your script)
				    var project = getProjectById(projectId); // Replace with actual logic to get project details
				
				    // Populate the modal form fields with project details
				    $('#projectId').val(project.id);
				    $('#projectName').val(project.name);
				    $('#projectMembers').val(project.members.join(', '));
				    $('#projectLeader').val(project.leader);
				    $('#projectEndDate').val(project.endDate);
				
				    // Show the modal
				    $('#editProjectModal').modal('show');
				}
				
				function getProjectById(projectId) {
				    // This function should return project details based on projectId
				    // For demonstration, let's use dummy data
				    return {
				        id: projectId,
				        name: "mustapha",
				        members: ["mustapha", "aymane"],
				        leader: "mustapha",
				        endDate: "2023-12-31"
				    };
				}
				
				$(document).ready(function() {
				    $('#editProjectForm').submit(function(event) {
				        event.preventDefault();
				        // Logic to save the project details
				        var projectData = $(this).serialize();
				        console.log(projectData);
				
				        // After saving, hide the modal
				        $('#editProjectModal').modal('hide');
				    });
				});
				
				var projectIdToDelete = null;

				function deleteProject(projectId) {
				    // Store the projectId to delete
				    projectIdToDelete = projectId;
				    
				    // Show the delete confirmation modal
				    $('#deleteProjectModal').modal('show');
				}

				$(document).ready(function() {
				    $('#confirmDeleteButton').click(function() {
				        if (projectIdToDelete) {
				            // Remove the project row from the table
				            $('tr[data-project-id="' + projectIdToDelete + '"]').remove();

				            // Hide the modal
				            $('#deleteProjectModal').modal('hide');
				        }
				    });
				});

			</script>
		</div>
	</div>
</div>
	<jsp:include page="assets/components/profile.jsp" />
	<jsp:include page="assets/components/notifications.jsp" />

</body>

</html>