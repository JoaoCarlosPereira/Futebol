<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="<c:url value="/resources/assets/img/apple-icon.png"/>">
  <link rel="icon" type="image/png" href="<c:url value="/resources/assets/img/favicon.png"/>">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    Futebol
  </title>
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- CSS Files -->
  <link href="<c:url value="/resources/assets/css/material-dashboard.css?v=2.1.0"/>" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="<c:url value="/resources/assets/demo/demo.css"/>" rel="stylesheet" />
</head>

<body class="">
  <div class="wrapper ">
    <div class="sidebar" data-color="green" data-background-color="white" data-image="<c:url value="/resources/assets/img/sidebar-1.jpg"/>">
      <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

        Tip 2: you can also add an image using data-image tag
    -->
      <div class="logo">
        <a href="http://www.creative-tim.com" class="simple-text logo-normal">
          Futebol
        </a>
      </div>
      <div class="sidebar-wrapper">
        <ul class="nav">
          <li class="nav-item active ">
            <a class="nav-link" href="/futebol/jogador">
              <i class="material-icons">person</i>
              <p>Cadastro de Jogadores</p>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/futebol/time">
              <i class="material-icons">control_point</i>
              <p>Cadastro de Times</p>
            </a>
          </li>  
		  <li class="nav-item">
            <a class="nav-link" href="/futebol/escalacao">
              <i class="material-icons">group</i>
              <p>Escalação</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="/futebol/listar">
              <i class="material-icons">content_paste</i>
              <p>Listar Times</p>
            </a>
          </li>
        </ul>
      </div>
    </div>
    <div class="main-panel">
      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <a class="navbar-brand" href="#pablo">Jogadores</a>
          </div>
          <button class="navbar-toggler" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
            <span class="sr-only">Toggle navigation</span>
            <span class="navbar-toggler-icon icon-bar"></span>
            <span class="navbar-toggler-icon icon-bar"></span>
            <span class="navbar-toggler-icon icon-bar"></span>
          </button>
        </div>
      </nav>
      <!-- End Navbar -->
      <div class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-md-8">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">Perfil</h4>
                  <p class="card-category">complete o perfil do jogador</p>
                </div>
                <div class="card-body">
				 <c:set var="selecionado" value="hidden" />
				 <c:if test="${jogador.codigo > 0}">
				   <c:set var="selecionado" value="button" />
				 </c:if>					
                  <form action="/futebol/jogador/salvar" method="post">
				    <input type="hidden" name="codigo" value="${jogador.codigo}" />
                    <div class="row">
                      <div class="col-md-12">
                        <div class="form-group">
                          <label class="bmd-label-floating" for="nome">Nome</label>
                          <input type="text" name="nome"  id="nome" class="form-control" value="${jogador.nome}" required="">
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-4">
                        <div class="form-group">
                          <label class="bmd-label-floating" for="idade">Idade</label>
                          <input type="numer" name="idade" id="idade" class="form-control" value="${jogador.idade}" required="">
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-12">
                        <div class="form-group">
                          <label class="bmd-label-floating" for="posicao">Posição</label>
                          <input type="text" name="posicao" id="posicao" class="form-control" value="${jogador.posicao}" required="">
                        </div>
                      </div>
                    </div>
					<a href="/futebol/jogador"><input type="${selecionado}" class="btn btn-primary pull-right CorVerde" value="Cancelar"></a>	
                    <a href="/futebol/jogador/deletar/${jogador.codigo}"><input type="${selecionado}" class="btn btn-primary pull-right CorVerde" value="Excluir"></a>					
                    <button type="submit" class="btn btn-primary pull-right CorVerde">Salvar</button>
                    <div class="clearfix"></div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!--   Core JS Files   -->
  <script src="<c:url value="/resources/assets/js/core/jquery.min.js" />"></script>
  <script src="<c:url value="/resources/assets/js/core/popper.min.js" />" type="text/javascript"></script>
  <script src="<c:url value="/resources/assets/js/core/bootstrap-material-design.min.js" />" type="text/javascript"></script>
  <script src="<c:url value="/resources/assets/js/plugins/perfect-scrollbar.jquery.min.js" />"></script>
  <!--  Google Maps Plugin    -->
  <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
  <!-- Chartist JS -->
  <script src="<c:url value="/resources/assets/js/plugins/chartist.min.js" />"></script>
  <!--  Notifications Plugin    -->
  <script src="<c:url value="/resources/assets/js/plugins/bootstrap-notify.js" />"></script>
  <!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="<c:url value="/resources/assets/js/material-dashboard.min.js?v=2.1.0" />" type="text/javascript"></script>
  <!-- Material Dashboard DEMO methods, don't include it in your project! -->
  <script src="<c:url value="/resources/assets/demo/demo.js" />"></script>
</body>

</html>