<%@page import="model.Tache"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<div id="todo-card" class="col-md mb-4">
	<div class="card tache-list">
		<div class="d-flex justify-content-between align-items-center">
			<span class="card-title text-danger"><i
				class="fa-solid fa-clock"></i> En attente</span>
			<button id="expand-todo-button" class="btn">
				<i class="fa-solid fa-up-right-and-down-left-from-center"></i>
			</button>
		</div>
		<%
		List<Tache> listeTachesEnAttente = (List<Tache>) request.getAttribute("listeTachesEnAttente");
		if (listeTachesEnAttente != null && !listeTachesEnAttente.isEmpty()) {
			for (Tache t : listeTachesEnAttente) {
		%>
		<div class="tache-item mb-3 d-flex justify-content-between px-3">
			<div>
				<%= t.getNomTache() %>
			</div>
			<div class="dropdown">
				<button class="btn" type="button" data-bs-toggle="dropdown"
					aria-expanded="false">
					<i class="fa-solid fa-ellipsis"></i>
				</button>
				<ul class="dropdown-menu dropdown-menu-end">
					<li><button class="start-task dropdown-item"
							value="<%= t.getIdTache() %>">Commencer la tâche</button></li>
					<li>
						<button class="show-comments dropdown-item"
							data-bs-toggle="offcanvas" data-bs-target="#offcanvas-comments"
							aria-controls="offcanvas-comments" value="<%= t.getIdTache() %>">Ajouter un commentaire</button>
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