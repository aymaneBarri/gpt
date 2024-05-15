<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Register</title>
	<link rel="stylesheet" href="https://unpkg.com/bootstrap@5.3.3/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://unpkg.com/bs-brain@2.0.4/components/logins/login-5/assets/css/login-5.css">
</head>
<body>

<section class="p-3 p-md-4 p-xl-5">
  <div class="container">
    <div class="card border-light-subtle shadow-sm">
      <div class="row g-0">
        <div class="col-12 col-md-6 text-bg-primary">
          <div class="d-flex align-items-center justify-content-center h-100">
           <div class="col-10 col-xl-8 py-3">
			  <h2 class="h1 mb-4">Notre plateforme permet aux projets de se démarquer.</h2>
			  <hr class="border-primary-subtle mb-4">
			  <p class="lead m-0">Nous facilitons la collaboration, gérons les tâches, suivons les progrès.</p>
			</div>
          </div>
        </div>
        <div class="col-12 col-md-6">
          <div class="card-body p-3 p-md-4 p-xl-5">
            <div class="row">
              <div class="col-12">
                <div class="mb-3">
                  <h3>Inscription</h3>
                </div>
              </div>
            </div>
            <form action="register" method="post">
              <div class="row gy-3 gy-md-4 overflow-hidden">
                <div class="col-12">
                  <label for="email" class="form-label">Identifiant <span class="text-danger">*</span></label>
                  <input type="text" class="form-control" name="identifiant" id="identifiant" placeholder="" required>
                </div>
                <div class="col-12">
                  <label for="email" class="form-label">Email<span class="text-danger">*</span></label>
                  <input type="email" class="form-control" name="email" id="email" placeholder="must@gmail.com" required>
                </div>
                <div class="col-12">
                  <label for="password" class="form-label">Mot de passe <span class="text-danger">*</span></label>
                  <input type="password" class="form-control" name="password" id="password" value="" required>
                </div>
                <div class="col-12">
                  <div class="d-grid">
                    <button type="submit" class="btn bsb-btn-xl btn-primary" type="submit">Register</button>
                  </div>
                </div>
              </div>
            </form>
            <div class="row">
              <div class="col-12">
                <hr class="mt-5 border-secondary-subtle">
                <div class="d-flex gap-2 gap-md-4 flex-column flex-md-row justify-content-md-end">
                 	<a href="Login.jsp" class="link-secondary text-decoration-none">Connexion</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

</body>
</html>