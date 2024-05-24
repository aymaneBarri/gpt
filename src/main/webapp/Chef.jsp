<%@page import="model.Projet"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<jsp:include page="assets/components/header.jsp" />

<div
	class="control-bar row align-items-center justify-content-between p-2">
	<form class="col-12 col-sm-6 col-md-4 mb-2 mb-sm-0 " role="search">
		<input class="form-control search-bar" type="search"
			placeholder="Search" aria-label="Search" />
	</form>

</div>

<div class="details">
	<div class="GS">

		<table>
			<thead>
				<tr>
					<td>Nom du projet</td>
					<td>Membres</td>
					<td>Date de création</td>
					<td>Progress</td>



				</tr>
			</thead>
			<tbody>
				<%
				// Boucle pour parcourir la liste des utilisateurs et les afficher dans un tableau
				ArrayList<Projet> listeProjets = (ArrayList<Projet>) request.getAttribute("projets");
				if (listeProjets != null && !listeProjets.isEmpty())
					for (Projet projet : listeProjets) {
				%>
				<tr>

					<td><%=projet.getNomProjet()%></td>
					<td><%=projet.getNbrMax()%></td>
					<td><%=projet.getDateDebut()%></td>
					<td></td>

					<td>
						<button type="button" class="btn btn-success"
							data-bs-toggle="modal" data-bs-target="#myModal">créer
							tache</button>
					</td>
					<td>
						<button type="button" class="btn btn-warning dropdown-toggle"
							data-bs-toggle="dropdown">Modifier</button>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">Ajouter membre</a> <a
								class="dropdown-item" href="#">Supprimer membre</a>
						</div>
					</td>
					<td>
						<button type="button" class="btn btn-danger">Supprimer</button>
					</td>
				</tr>
				<%
				}
				else {
				%>
				<span>Aucun Projet</span>
				<%
				}
				%>
				<tr>
					<td>Projet 2</td>
					<td>&</td>
					<td>&</td>
					<td>&</td>
					<td>
						<button type="button" class="btn btn-success"
							data-bs-toggle="modal" data-bs-target="#myModal">créer
							tache</button>
					</td>
					<td>w
						<button type="button" class="btn btn-warning dropdown-toggle"
							data-bs-toggle="dropdown">Modifier</button>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">Ajouter membre</a> <a
								class="dropdown-item" href="#">Supprimer membre</a>
						</div>
					</td>
					<td>
						<button type="button" class="btn btn-danger">Supprimer</button>
					</td>

				</tr>
				<tr>
					<td>Projet 3</td>
					<td>&</td>
					<td>&</td>
					<td>&</td>

					<td>
						<button type="button" class="btn btn-success"
							data-bs-toggle="modal" data-bs-target="#myModal">créer
							tache</button>
					</td>
					<td>
						<button type="button" class="btn btn-warning dropdown-toggle"
							data-bs-toggle="dropdown">Modifier</button>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">Ajouter membre</a> <a
								class="dropdown-item" href="#">Supprimer membre</a>
						</div>
					</td>
					<td>
						<button type="button" class="btn btn-danger">Supprimer</button>
					</td>
				</tr>
				<tr>
					<td>Projet 4</td>
					<td>&</td>
					<td>&</td>
					<td>&</td>
					<td>
						<button type="button" class="btn btn-success"
							data-bs-toggle="modal" data-bs-target="#myModal">créer
							tache</button>
					</td>
					<td>
						<button type="button" class="btn btn-warning dropdown-toggle"
							data-bs-toggle="dropdown">Modifier</button>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#">Ajouter membre</a> <a
								class="dropdown-item" href="#">Supprimer membre</a>
						</div>
					</td>
					<td>
						<button type="button" class="btn btn-danger">Supprimer</button>
					</td>

				</tr>

			</tbody>
		</table>
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
						<form action="AddTache" method="post">
							<div class="input-box  ">

								<!--  <label>Nom de projet</label> -->
								<input type="text" name="nameT" class="form-control"
									placeholder="Nom du tache">

							</div>
							<div class="input-box ">

								<!--  <label>chef de projet</label> -->
								<input type="text" name="nameUser" class="form-control"
									placeholder="Nom d'utilisteur">

							</div>

							<div>
								<p>Priorité:</p>
								<div class="form-check">
									<input class="form-check-input" type="radio"
										name="flexRadioDefault" id="flexRadioDefault1"> <label
										class="form-check-label" for="flexRadioDefault1">
										Forte </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio"
										name="flexRadioDefault" id="flexRadioDefault2" checked>
									<label class="form-check-label" for="flexRadioDefault2">
										Moyenne </label>
								</div>

								<div class="form-check">
									<input class="form-check-input" type="radio"
										name="flexRadioDefault" id="flexRadioDefault2" checked>
									<label class="form-check-label" for="flexRadioDefault2">
										Faible </label>
								</div>



							</div>


							<div class="modal-footer">
								<button type="button" class="btn btn-primary"
									data-bs-dismiss="modal">Créer une nouvelle tache</button>
							</div>


						</form>
					</div>
				</div>



			</div>
		</div>
	</div>
	</body>

	</html>