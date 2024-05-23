<%@page import="model.Tache"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<div class="col-md mb-2">
	<div class="card tache-list shadow-sm">
		<div class="mb-3 d-flex justify-content-between align-items-center">
			<span class="card-title text-warning"><i
				class="fa-solid fa-hourglass-half"></i> En cours</span>
		</div>
		<%
		List<Tache> listeTachesEnCours = (List<Tache>) request.getAttribute("listeTachesEnCours");
		if (listeTachesEnCours != null && !listeTachesEnCours.isEmpty()) {
			for (Tache t : listeTachesEnCours) {
		%>
		<div
			class="tache-item mb-3 d-flex justify-content-between px-3 shadow-sm">

			<div>
				<%=t.getNomTache()%>
			</div>
			<div class="dropdown">
				<button class="btn" type="button" data-bs-toggle="dropdown"
					aria-expanded="false">
					<i class="fa-solid fa-ellipsis"></i>
				</button>
				<ul class="dropdown-menu dropdown-menu-end">
					<li><a class="dropdown-item" href="#">Action</a></li>
					<li><a class="dropdown-item" href="#">Another action</a></li>
					<li><hr class="dropdown-divider"></li>
					<li><a class="dropdown-item" href="#">Something else here</a></li>
				</ul>
			</div>
		</div>
		<%
		}
		} else {
		%>
		<span>Aucune tâche en cours</span>
		<%
		}
		%>
	</div>
</div>