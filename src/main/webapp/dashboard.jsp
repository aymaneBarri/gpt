<%@page import="model.Tache" %>
  <%@page import="java.util.List" %>
    <%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach" %>
      <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
          <meta charset="UTF-8" />
          <meta name="viewport" content="width=device-width, initial-scale=1.0" />
          <title>Document</title>
          <link rel="stylesheet" href="assets/bootstrap-5.3.3-dist/css/bootstrap.css" />
          <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
          <script src="assets/bootstrap-5.3.3-dist/js/bootstrap.js"></script>
          <link rel="stylesheet" href="assets/fontawesome-free-6.5.2-web/css/all.css" />
          <link rel="stylesheet" href="assets/style.css" />
          <link href="assets/fonts/Inter/Inter-VariableFont_slnt,wght.ttf" rel="stylesheet" />
        </head>

        <body>
          <div class="top-bar container-fluid">
            <a href="#" class="my-auto me-2" style="color: white"><i class="fa-solid fa-house fa-xl"></i></a>
            <div class="d-inline">GPT</div>
            <div class="float-end d-inline">
              <i class="fa-light fa-circle-user"></i>
            </div>
          </div>

          <div class="control-bar row align-items-center justify-content-between p-2">
            <form class="col-12 col-sm-6 col-md-4 mb-2 mb-sm-0 " role="search">
              <input class="form-control search-bar" type="search" placeholder="Search" aria-label="Search" />
            </form>
            <div class="row col col-sm-6 col-md-4">
              <button type="button" class="btn btn-primary col-7 me-2">
                <i class="fa-solid fa-plus"></i> Créer un nouveau projet</button><button type="button"
                class="btn btn-primary col-4">
                Mes projets
              </button>
            </div>
          </div>

          <div class="container-fluid p-3 px-lg-4 px-xl-5 px-xxl-6">
            <span class="h6">Mes Tâches</span>
            <div class="row mt-2">
              <div class="col-md-4 mb-2">
                <div class="card tache-list">
                <div class="d-flex justify-content-between align-items-center">
                	<span class="card-title text-danger"><i class="fa-solid fa-clock"></i> En attente</span>
                	<button class="btn"><i class="fa-solid fa-up-right-and-down-left-from-center"></i></button>
                </div>  
                  <% List<Tache> listeTachesEnAttente = (List<Tache>)request.getAttribute("listeTachesEnAttente");
                      if (!listeTachesEnAttente.isEmpty()){
                      for(Tache t : listeTachesEnAttente){
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
              <li><a class="dropdown-item" href="#">Action</a></li>
              <li><a class="dropdown-item" href="#">Another action</a></li>
              <li><a class="dropdown-item" href="#">Something else here</a></li>
            </ul>
          </div>
                      </div>


                      <% } } else { %>
                        <span>Aucune tâche en attente</span>
                        <% } %>
                </div>
              </div>

              <div class="col-md-4 mb-2">
                <div class="card tache-list">
                  <span class="card-title text-warning"><i class="fa-solid fa-hourglass-half"></i> En cours</span>
                  <% List<Tache> listeTachesEnCours = (List<Tache>)request.getAttribute("listeTachesEnCours");
                      if (!listeTachesEnCours.isEmpty()){
                      for(Tache t : listeTachesEnCours){
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
              <li><a class="dropdown-item" href="#">Action</a></li>
              <li><a class="dropdown-item" href="#">Another action</a></li>
              <li><a class="dropdown-item" href="#">Something else here</a></li>
            </ul>
          </div>
                      </div>
                      <% } } else { %>
                        <span>Aucune tâche en cours</span>
                        <% } %>
                </div>
              </div>

              <div class="col-md-4 mb-2">
                <div class="card tache-list">
                  <span class="card-title text-success"><i class="fa-solid fa-circle-check"></i> Terminé</span>
                  <% List<Tache> listeTachesTermine = (List<Tache>)request.getAttribute("listeTachesTermine");
                      if (!listeTachesTermine.isEmpty()){
                      for(Tache t : listeTachesTermine){
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
				              <li><a class="dropdown-item" href="#">Action</a></li>
				              <li><a class="dropdown-item" href="#">Another action</a></li>
				              <li><a class="dropdown-item" href="#">Something else here</a></li>
				            </ul>
				        </div>
                      </div>
                      <% } } else { %>
                        <span>Aucune tâche terminé</span>
                        <% } %>
                </div>
              </div>
            </div>
          </div>
        </body>

        </html>