<%@page import="model.Projet"%>
<%@page import="model.Utilisateur"%>
<%@page import="java.util.List"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="assets/components/header.jsp" />

<div class="container-fluid p-3 px-lg-4 px-xl-5 px-xxl-6">
	<span class="h5">Mes Projets</span>
	<div class="details">
		<div class="tache-list">
			<div class="d-flex justify-content-end">
				<button type="button" class="btn btn-primary me-2 btn btn-success"
					data-bs-toggle="modal" data-bs-target="#myModal">
					<i class="fa-solid fa-plus "></i> Créer un nouveau projet
				</button>
			</div>

			<%
			List<Projet> listeProjets = (List<Projet>) request.getAttribute("listeProjets");
			if (listeProjets != null && !listeProjets.isEmpty()) {
			%>

			<table id="table1" data-show-multi-sort="true">
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
					<tr>
						<td><%=t.getNomProjet()%></td>
						<td>
							<div class="dropdown">
								<button class="btn" type="button" data-bs-toggle="dropdown"
									aria-expanded="false">
									<%=t.getMembres().size()%>
									membres
								</button>
								<%
								if (t.getMembres().size() > 0) {
								%>
								<ul class="dropdown-menu">
									<%
									for (Utilisateur u : t.getMembres()) {
									%>
									<li class="dropdown-item disabled"><%=u.getNomUtilisateur()%>
									</li>
									<%
									}
									%>
								</ul>
								<%
								}
								%>
							</div>
						</td>
						<td><%=t.getChef().getNomUtilisateur()%></td>
						<td><%=t.getDateFin().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))%></td>
						<td><div class="dropdown">
								<button class="btn" type="button" data-bs-toggle="dropdown"
									aria-expanded="false">
									<i class="fa-solid fa-ellipsis"></i>
								</button>
								<ul class="dropdown-menu dropdown-menu-end">
									<li><button class="start-task dropdown-item"
											value="<%=t.getIdProjet()%>">Modifier</button></li>
									<li>
										<button class="show-comments dropdown-item"
											data-bs-toggle="offcanvas"
											data-bs-target="#offcanvas-comments"
											aria-controls="offcanvas-comments"
											value="<%=t.getIdProjet()%>">Supprimer</button>
									</li>
								</ul>
							</div></td>
					</tr>
					<%
					}
					%>

				</tbody>
			</table>
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
			</script>
		</div>
	</div>
</div>

<!-- The Modal -->
<div class="modal" id="myModal">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">Créer un nouneau projet</h4>
				<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
			</div>

			<!-- Modal body -->
			<div class="modal-body">
				<div class="wra">

					<div class=".form-box l">
						<h2></h2>
						<form action="admin" method="post">
							<!-- <div class="input-box  ">

								 <label>Nom de projet</label>
								<input type="text" name="nameP" class="form-control"
									placeholde="Nom de projet">

							</div> -->
							<label for="exampleFormControlInput1" class="form-label mt-4">Nom
								du projet</label> <input type="text" class="form-control"
								name="nomProjet" id="exampleFormControlInput1">

							<!-- <div class="input-box "> -->

							<!-- <label>chef de projet</label> -->
							<!-- <input type="text" name="namechaef" class="form-control"
									placeholder="chef de projet">  -->
							<label for="exampleDataList" class="form-label mt-4">Chef
								du projet</label> <input class="form-control" list="datalistOptions"
								id="exampleDataList" name="chef">
							<datalist id="datalistOptions">
								<%
								List<Utilisateur> listeUtilisateurNonAdmin = (List<Utilisateur>) request.getAttribute("listeUtilisateurNonAdmin");
								if (listeUtilisateurNonAdmin != null && !listeUtilisateurNonAdmin.isEmpty())
									for (Utilisateur u : listeUtilisateurNonAdmin) {
								%>
								<option value="<%=u.getNomUtilisateur()%>">
									<%
									}
									%>
								
							</datalist>

							<!-- </div> -->

							<!-- <div class="input-box ">


								<input type="text" name="namechaef" class="form-control"
									placeholder="Nombre max">

							</div> -->
							<label for="exampleFormControlInput1" class="form-label mt-4">Nombre
								maximale des membres</label> <input type="number" class="form-control"
								id="exampleFormControlInput1" name="nbrMax"> 
								
								<label
								for="startDate" class="mt-4">Date debut</label> <input id="startDate"
								class="form-control" type="datetime-local" name="dateDebut"/> <label
								for="endDate" class="mt-4">Date fin</label> <input id="endDate"
								class="form-control" type="datetime-local" name="dateFin"/>


							<div class="modal-footer">
								<button type="submit" class="btn btn-success"
									data-bs-dismiss="modal">Créer</button>
							</div>


						</form>
					</div>
				</div>



			</div>
		</div>
	</div>
</div>

<jsp:include page="assets/components/profile.jsp" />
<jsp:include page="assets/components/notifications.jsp" />
</body>
</html>
