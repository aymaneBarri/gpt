<%@page import="model.Commentaire"%>
<%@page import="java.util.List"%>
<div>
	<div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvas-comments"
		aria-labelledby="offcanvasRightLabel">
		<div class="offcanvas-header">
			<h5 class="offcanvas-title" id="offcanvasRightLabel">Commentaires</h5>
			<button type="button" class="btn-close" data-bs-dismiss="offcanvas-comments"
				aria-label="Close"></button>
		</div>
		<div id="comments" class="offcanvas-body">
			<jsp:include page="commentairesBody.jsp" />
		</div>
	</div>
</div>
