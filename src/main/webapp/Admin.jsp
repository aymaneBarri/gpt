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
	<style>
		
.user {
    position: relative;
    width: 40px;
    height: 40px;
    border-radius: 50%;
    overflow: hidden;
    cursor: pointer;
    margin-inline-start: auto;

}
.user img {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    object-fit: cover;
    right: 0;
}

img {
     
    border-radius: 50%;
    cursor: pointer;
    position: absolute;
    top: 9px;
    right: 0;
    object-fit: cover;
    margin-left: 0;

}

.details table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 10px;
}

.details table thead td {
    font-weight: 600;
    color:var(--black1);
    border-bottom: 1px solid rgba(0,0,0, 0.1);
}

.details .GS table tr {
    color:var(--black1);
    border-bottom: 1px solid rgba(0,0,0, 0.1);

}

.details .GS table tr:last-child {
    border-bottom: none;

}

.details .GS table tbody tr:hover {
    background: var(--blue);
    color: var(--white);

}

.details .GS table tr td {
    padding: 20px;
    
}

.details .GS table tr td:last-child{
    /* text-align: end; */
    text-align: center;

}

.details .GS table tr td:nth-child(2){
    /* text-align: end; */
    text-align: center;
    display: inline-flex;
}

.details .GS table tr td:nth-child(3){
    text-align: center;
}
.details .GS table tr td:nth-child(4){
    text-align: center;
}
.details .GS table tr td:nth-child(5){
    text-align: center;
}



@media (max-width: 991px) {
    .navigation {
        left: -300px;
    }
    .main {
        width: 100%;
        left: 0;

    }
    .navigation.active {
        width: 300px;
        left: 0;
    }
    .main.active {
        left: 300px;

    }
}

@media (max-width: 768px) {
    .details {
        grid-template-columns: repeat(1,1fr);
    }

    .GS {
        overflow-x: auto;

    }

    .status.des,
    .status.indes{
        white-space: nowrap;
    }
}
@media (max-width: 480px) {
    .cardBox {
        grid-template-columns: repeat(1,1fr);
    }
    .cardHeader h2{
        font-size: 20px;
    }
    
    .user {
        min-width: 40px;
    }
    .navigation {
        width: 100%;
        left: -100%;
        z-index: 1000;
    }
    .navigation.active {
        width: 100%;
        left: 0;

    }
    .toggle {
        z-index: 10001;
    }
    .main.active .toggle {
        position: fixed;
        right: 0;
        left: initial;
        color: var(--white);
    }
    

}



.details {
    position: relative;
    width: 100%;
    padding: 20px;
    display: grid;
    /* grid-template-columns: 2fr 1fr; */
    /* grid-gap: 30px; */
    margin-top: 50px;

}

.details .GS {
    position: relative;
    display: grid;
    min-height: 300px;
    background: var(--white);
    padding: 20px;
    box-shadow: 0 7px 25px rgba(0,0,0, 08);
    border-radius: 20px;
}

.cardHeader {
    display: flex;
    justify-content: space-evenly;
    align-items: center;
    background-color: aqua;
    
}



.input-box {
    position: relative;
    width: 100%;
    height: 50px;
    border-bottom: 2px solid #162938;
    margin: 30px 0;
}

.input-box label {
    position: absolute;
    top: 50%;
    left: 5px;
    transform: translateY(-50%);
    font-size: 1em;
    color: #162938;
    font-weight: 500;
    pointer-events: none;
    transition: .5s;
}

.input-box input:focus~label,
.input-box input:valid~label{
    top: -5px;
}


.input-box input:focus~label,
.input-box input:valid~label{
    top: -5px;
}

.input-box input {
    width: 100%;
    height: 100%;
    background: transparent;
    border: none;
    outline: none;
    font-size: 1em;
    color:#162938;
    font-weight: 600;
    padding: 0 35px 0 5px ;
}

	</style>
        <body>
          <div class="top-bar container-fluid">
            <a href="#" class="my-auto me-2" style="color: white"><i class="fa-solid fa-house fa-xl"></i></a>
            <div class="d-inline">
            
            GPT</div>
           
               
                                        <img src="Image2/7.jpg" alt=""  height="44px" width="44px">
                                    
            </div>
           
         

          <div class="control-bar row align-items-center justify-content-between p-2">
            <form class="col-12 col-sm-6 col-md-4 mb-2 mb-sm-0 " role="search">
              <input class="form-control search-bar" type="search" placeholder="Search" aria-label="Search" />
            </form>
            <div class="row col col-sm-6 col-md-4">
              <button type="button" class="btn btn-primary col-7 me-2  btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">
                <i class="fa-solid fa-plus "></i> Créer un nouveau projet</button>
            </div>
          </div>

<div class="details">
        <div class="GS">
               
                <table >
                    <thead>
                        <tr>
                            <td>Nom du projet</td>
                            <td>Membres</td>
                            <td>chef de projet</td>
                            <td>Echeance</td>
                            
                           
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Projet 1</td>
                            <td>
                                <div class="user">
                                    <img src="Image2/7.jpg" alt=""  height="94px" width="94px">
                            
                                     </div>
                                     <div class="user">
                                        <img src="Image2/7.jpg" alt=""  height="94px" width="94px">
                                    
                                         </div>
                            </td>
                            <td>
                                <div class="user">
                                    <img src="Image2/7.jpg" alt=""  height="94px" width="94px">
                                
                                     </div>
                            </td>
                            <td>&</td>
                            
                           
                        </tr>
                        <tr>
                            <td>Projet 2</td>
                            <td>
                                <div class="user">
                                    <img src="Image2/7.jpg" alt=""  height="94px" width="94px">
                                
                                     </div>
                            </td>
                            <td>
                                <div class="user">
                                    <img src="Image2/7.jpg" alt=""  height="94px" width="94px">
                                
                                     </div>
                            </td>
                            <td>&</td>
                            
                           
                        </tr>
                        <tr>
                            <td>Projet 3</td>
                            <td>
                                <div class="user">
                                    <img src="Image2/7.jpg" alt=""  height="94px" width="94px">
                                
                                     </div>
                            </td>
                            <td>
                                <div class="user">
                                    <img src="Image2/7.jpg" alt=""  height="94px" width="94px">
                                
                                     </div>
                            </td>
                            <td>&</td>
                            
                            
                        </tr>
                        <tr>
                            <td>Projet 4</td>
                            <td>
                                <div class="user">
                                    <img src="Image2/7.jpg" alt=""  height="94px" width="94px">
                                
                                     </div>

                            </td>
                            <td>
                                <div class="user">
                                    <img src="Image2/7.jpg" alt=""  height="94px" width="94px">
                                
                                     </div>
                            </td>
                            <td>&</td>
                            
                            
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
        <h4 class="modal-title">Créer un nouneau projet</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       <div class="wra">
   
    <div class=".form-box l">
        <h2></h2>
            <form action="#" method="post">
                <div class="input-box  ">
                
                 <!--  <label>Nom de projet</label> -->
                        <input type="text" name="nameP" class="form-control" placeholder="Nom de projet">
                      
                </div>
                <div class="input-box ">
                
                 <!--  <label>chef de projet</label> -->
                        <input type="text" name="namechaef" class="form-control" placeholder="chef de projet">
                      
                </div>
                
                 <div class="input-box ">
                
               
                        <input type="text" name="namechaef" class="form-control" placeholder="Nombre max">
                      
                </div>

                   
      <div class="modal-footer">
        <button type="button" class="btn btn-success" data-bs-dismiss="modal">OK</button>
      </div>
                   
               
            </form>
    </div>
      </div>

      

    </div>
  </div>
</div>
         
        </body>

        </html>