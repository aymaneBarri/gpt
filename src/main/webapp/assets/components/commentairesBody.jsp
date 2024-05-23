<%@page import="model.Commentaire"%>
<%@page import="java.util.List"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<div class="d-flex flex-align-start flex-column h-100">
	<ul class="mb-3 h-100 overflow-y-auto list-group">
		<%
		List<Commentaire> listeCommentaires = (List<Commentaire>) session.getAttribute("listeCommentaires");
		if (listeCommentaires != null && !listeCommentaires.isEmpty()) {
			for (Commentaire c : listeCommentaires) {
		%>
		<li class="list-group-item h-auto mb-2">
			<div class="d-flex w-100 justify-content-between">
				<h6 class="mb-1"><%=c.getCommentateur()%></h6>
				<small class="text-body-secondary"><%=c.getDateCommentaire() == null ? "Unknown date"
		: c.getDateCommentaire().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))%></small>
			</div>
			<p class="mb-1"><%=c.getCommentaire()%></p>
		</li>
		<%-- <jsp:include page="commentaire.jsp"></jsp:include> --%>
		<%
		}
		} else {
		%>
		<span>Pas de commentaires.</span>
		<%
		}
		%>
	</ul>

	<form id="add-comment-form" class="row" action="resources/commentaires/ajouter" method="POST">
		<input type="hidden" id="idTache" name="idTache" value="" />
		<div class="col-10">
			<input class="form-control"
				placeholder="Ecrivez un commentaire ici..." id="floatingTextarea" name="commentaire"></input>
		</div>
		<div class="col-2">
			<button type="submit" class="add-comment btn btn-primary mb-3"><i class="fa-solid fa-paper-plane"></i></button>
		</div>
	</form>
</div>