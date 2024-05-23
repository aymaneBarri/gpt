<%@page import="model.Tache"%>
<%@page import="model.PrioriteTache"%>
<%@page import="java.util.List"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<div class="col-md mb-2">
	<div class="card tache-list shadow-sm">
		<div class="mb-3 d-flex justify-content-between align-items-center">
			<span class="card-title text-success"><i
				class="fa-solid fa-circle-check"></i> Termin�</span>
		</div>
		
		<%
		List<Tache> listeTachesTermine = (List<Tache>) request.getAttribute("listeTachesTermine");
		if (listeTachesTermine != null && !listeTachesTermine.isEmpty()) {
		%>

		<table id="table3" data-show-multi-sort="true"
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
				for (Tache t : listeTachesTermine) {
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
								<li>
									<button class="show-comments dropdown-item"
										data-bs-toggle="offcanvas"
										data-bs-target="#offcanvas-comments"
										aria-controls="offcanvas-comments" value="<%=t.getIdTache()%>">Ajouter
										un commentaire</button>
								</li>
								<li><hr class="dropdown-divider"></li>
								<li><button class="dropdown-item">Plus de d�tails</button></li>
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
		<span>Aucune t�che en attente</span>
		<%
		}
		%>
		<script>
			$(function() {
				$('#table3').bootstrapTable();
				$('#table3').removeClass("table-bordered");
				$('#table3').removeClass("table-hover");
			})
		</script>
		
		<%-- <%
		List<Tache> listeTachesTermine = (List<Tache>) request.getAttribute("listeTachesTermine");
		if (listeTachesTermine != null && !listeTachesTermine.isEmpty()) {
			for (Tache t : listeTachesTermine) {
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
		<span>Aucune t�che termin�</span>
		<%
		}
		%> --%>
		
	</div>
</div>