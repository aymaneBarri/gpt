<%@page import="model.PrioriteTache"%>
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
			<!-- <div class="d-flex justify-content-end">
				<button id="setCurrentProjectId" type="button" class="btn btn-primary me-2 btn btn-success"
					data-bs-toggle="modal" data-bs-target="#myModal">
					<i class="fa-solid fa-plus "></i> Créer un nouveau projet
				</button>
			</div> -->

			<%
			List<Projet> listeProjets = (List<Projet>) request.getAttribute("listeProjets");
			if (listeProjets != null && !listeProjets.isEmpty()) {
				List<Double> listeProgres = (List<Double>) request.getAttribute("listeProgres");
			%>

			<table id="table1" data-show-multi-sort="true" class="table-responsive">
				<thead>
					<tr>
						<th data-sortable="true">Nom</th>
						<th data-sortable="true">Membres</th>
						<th data-sortable="true">Date de fin</th>
						<th data-sortable="true">Progrès</th>
						<th>Options</th>
					</tr>
				</thead>
				<tbody>
					<%
					int i = 0;
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
						<td><%=t.getDateFin().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))%></td>
						<td>
							<div class="progress" role="progressbar"
								aria-label="Success example"
								aria-valuenow="<%=listeProgres.get(i)%>" aria-valuemin="0"
								aria-valuemax="100">
								<div class="progress-bar bg-success"
									style="width: <%=listeProgres.get(i)%>%"><%=listeProgres.get(i)%>%
								</div>
							</div>
						</td>
						<td><div class="dropdown">
								<button class="btn" type="button" data-bs-toggle="dropdown"
									aria-expanded="false">
									<i class="fa-solid fa-ellipsis"></i>
								</button>
								<ul class="dropdown-menu dropdown-menu-end">
									<li class="dropdown-item">
										<button type="button"
											class="btn me-2 btn btn-success setCurrentProjectId w-100"
											data-bs-toggle="modal" data-bs-target="#myModal"
											value="<%=t.getIdProjet()%>">
											<i class="fa-solid fa-plus "></i> Créer une nouvelle tâche
										</button>
									</li>
									<li class="dropdown-item"><button class="modifierProjet btn btn-warning w-100"
											value="<%=t.getIdProjet()%>">Modifier</button></li>
									<li class="dropdown-item">
										<button class="supprimerProjet btn btn-danger w-100"
											data-bs-toggle="offcanvas"
											data-bs-target="#offcanvas-comments"
											aria-controls="offcanvas-comments"
											value="<%=t.getIdProjet()%>">Supprimer</button>
									</li>
								</ul>
							</div></td>
					</tr>
					<%
					i++;
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
				});
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
				<h4 class="modal-title">Créer une nouvelle tache</h4>
				<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
			</div>

			<!-- Modal body -->
			<div class="modal-body">
				<div class="wra">

					<div class=".form-box l">
						<h2></h2>
						<form action="chef" method="post">
							<div class="input-box  ">

								<!--  <label>Nom de projet</label> -->
								<input type="text" name="nomTache" class="form-control"
									placeholder="Nom du tache">

							</div>

							<label for="exampleDataList" class="form-label mt-4">Utilisateur</label> <input class="form-control" list="datalistOptions"
								id="exampleDataList" name="utilisateur">
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

							<label for="endDate" class="mt-4">Date fin</label> <input
								id="endDate" class="form-control" type="datetime-local"
								name="dateFin" />

							<div class="mt-4">
								<p>Priorité:</p>
								<div class="form-check">
									<input class="form-check-input" type="radio"
										name="prioriteTache" id="flexRadioDefault1" value="h">
									<label class="form-check-label" for="flexRadioDefault1">
										Haute </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio"
										name="prioriteTache" id="flexRadioDefault2" value="m">
									<label class="form-check-label" for="flexRadioDefault2">
										Moyenne </label>
								</div>

								<div class="form-check">
									<input class="form-check-input" type="radio"
										name="prioriteTache" id="flexRadioDefault2" value="f" checked>
									<label class="form-check-label" for="flexRadioDefault2">
										Faible </label>
								</div>

								<input id="currentProjectId" type="hidden" name="idProjet"
									value="">


							</div>


							<div class="modal-footer">
								<button type="submit" class="btn btn-primary"
									data-bs-dismiss="modal">Créer une nouvelle tache</button>
							</div>


						</form>
					</div>
				</div>



			</div>
		</div>
	</div>
	</div>
	</body>

	</html>