<%@page import="model.Tache"%>
<%@page import="model.PrioriteTache"%>
<%@page import="java.util.List"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<div id="todo-card" class="col-md mb-4">
	<div class="card tache-list shadow-sm">
		<div class="mb-3 d-flex justify-content-between align-items-center">
			<span class="card-title text-danger"><i
				class="fa-solid fa-clock"></i> En attente</span>
		</div>

		<%
		List<Tache> listeTachesEnAttente = (List<Tache>) request.getAttribute("listeTachesEnAttente");
		if (listeTachesEnAttente != null && !listeTachesEnAttente.isEmpty()) {
		%>

		<table id="table1" data-show-multi-sort="true" class="table-responsive"
			>
			<thead>
				<tr>
					<th data-sortable="true">Priorite</th>
					<th data-sortable="true">Titre</th>
					<th data-sortable="true">Delai</th>
					<th>Options</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Tache t : listeTachesEnAttente) {
				%>
				<tr>
					<td><i
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
					</td>
					<td><%=t.getNomTache()%></td>
					<td><%=t.getDateEcheance().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))%></td>
					<td>
						<div class="dropdown">
							<button class="btn" type="button" data-bs-toggle="dropdown"
								aria-expanded="false">
								<i class="fa-solid fa-ellipsis"></i>
							</button>
							<ul class="dropdown-menu dropdown-menu-end">
								<li><button class="start-task dropdown-item"
										value="<%=t.getIdTache()%>">Commencer la tâche</button></li>
								<li>
									<button class="show-comments dropdown-item"
										data-bs-toggle="offcanvas"
										data-bs-target="#offcanvas-comments"
										aria-controls="offcanvas-comments" value="<%=t.getIdTache()%>">Ajouter
										un commentaire</button>
								</li>
								<li><hr class="dropdown-divider"></li>
								<li><button class="dropdown-item">Plus de détails</button></li>
							</ul>
						</div>
					</td>
				</tr>
				<%
				}
				%>

			</tbody>
		</table>
		<%
		} else {
		%>
		<span>Aucune tâche en attente</span>
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

		<%-- <%
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
		%> --%>
		
	</div>
</div>