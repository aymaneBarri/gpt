<%@page import="model.Utilisateur"%>
<%@page import="model.Commentaire"%>
<%@page import="java.util.List"%>

<%
	Utilisateur user = null;
	if(session.getAttribute("login") != null  || session.getAttribute("login") != "") {
		user = (Utilisateur) session.getAttribute("login");
	}else {
		response.sendRedirect("Login.jsp");
	}
%>
<div>
	<div class="offcanvas offcanvas-end" tabindex="-1"
		id="offcanvas-profile" aria-labelledby="offcanvasRightLabel">
		<div class="offcanvas-header">
			<h5 class="offcanvas-title" id="offcanvasRightLabel">Profile</h5>
			<button type="button" class="btn-close"
				data-bs-dismiss="offcanvas-profile" aria-label="Close"></button>
		</div>
		<div class="offcanvas-body">
			<div class="d-flex flex-align-start flex-column h-100">
				<form class="row g-3" action="edit" method="post">
					<div class="col-12">
						<label for="inputUsername" class="form-label">Nom d'utilisateur</label> <input
							type=text class="form-control" id="inputUsername"  name="name" value="<%=user.getNomUtilisateur() %>">
					</div>
					<div class="col-12">
						<label for="inputEmail" class="form-label">Adresse email</label> <input
							type="email" class="form-control" id="inputEmail" name="email" value="<%=user.getEmail() %>">
					</div>
					
					 <a href="#" id="changePasswordBtn" class="col-12 btn btn-primary mt-4">Change Password</a>
					
					<div id="changePasswordForm" class="col-12 mt-3" style="display: none;">
						<div class="col-12">
							<label for="inputPassword" class="form-label">Mot de passe</label> <input
								type="password" class="form-control" id="inputPassword" name="password" value="<%=user.getMotDePasse() %>">
						</div>
						<div class="col-12">
							<label for="inputConfirmPassword" class="form-label">Confirmer mot de passe</label> <input
								type="password" class="form-control" id="inputConfirmPassword4" value="<%=user.getMotDePasse() %>">
						</div>
					</div>
					<div class="col-12">
						<label for="inputUserType" class="form-label">Type du compte</label> <input
							type="text" class="form-control" id="inputUserType" value="utilisateur" disabled>
					</div>
					<div class="col-12">
						<button type="submit" class="btn btn-primary">Mettre à jour</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76A8fkpD6pdt94a4N6bJuqyX4hnFEaEjt8ub78J8CuKxY0hNrEapXIszA3FLxi6" crossorigin="anonymous"></script>
   <script>
        document.getElementById('changePasswordBtn').addEventListener('click', function() {
            var form = document.getElementById('changePasswordForm');
            if (form.style.display === 'none') {
                form.style.display = 'block';
            } else {
                form.style.display = 'none';
            }
        });
    </script>
