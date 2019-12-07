<%-- 
    Document   : CandidatosElectos
    Created on : 10-sep-2019, 0:55:21
    Author     : migol
--%>

<%@page import="modeloDAO.CandidatoDAO"%>
<%@page import="modeloVO.CandidatoVO"%>
<%@page import="modeloDAO.UsuarioDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%

        HttpSession miSesion = (HttpSession) request.getSession();
        UsuarioVO usuVO = (UsuarioVO) miSesion.getAttribute("usuario");

        if (usuVO == null) {
            miSesion.getAttribute("mensajeError");
            request.getRequestDispatcher("CerrarSesion").forward(request, response);
        } else {%>
    <%@include file="WEB-INF/Sesiones/sesion-validate.jspf"%>
    <%@include file="WEB-INF/Sesiones/sesion.jspf"%>
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>ELECCIÓNPLUS - Perfil</title>
        <link rel="icon" type="icon/png" href="img/logop.png">
        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

    </head>

    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-success sidebar sidebar-dark accordion" id="accordionSidebar">

                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="menuAdmin.jsp" ><!--style="background-color: #005CC2"-->
                    <div class="sidebar-brand-icon">
                        <img src="img/logo.png" class="img-fluid">
                    </div>
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">

                <!-- Nav Item - Dashboard -->
                <li class="nav-item active">
                    <a class="nav-link" href="menuAdmin.jsp">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Menú</span></a>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->
                <div class="sidebar-heading">
                    Interfaz
                </div>


                <%  if (usuVO.getUsuRol().equals("1")) { %>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
                        <i class="fas fa-fw fa-cog"></i>
                        <span>Gestiones</span>
                    </a>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Gestiones</h6>
                            <a class="collapse-item" href="GestionUsuario.jsp">Gestion usuarios</a> 
                            <a class="collapse-item" href="GestionCandidato.jsp">Gestion candidatos</a>
                            <a class="collapse-item" href="Propuesta.jsp">Ver Propuestas</a>
                            <a class="collapse-item" href="ConteoVotos.jsp">Conteo Votos</a>
                            <a class="collapse-item" href="JornadaVotacion.jsp">Jornada Electoral</a>
                        </div>
                    </div>
                </li>


                <!-- Nav Item - Utilities Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                        <i class="fas fa-fw fa-wrench"></i>
                        <span>Utilidades</span>
                    </a>
                    <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Candidatura</h6>
                            <a class="collapse-item" href="CandidatosElectos.jsp">Candidatos a elegir</a>
                            <h6 class="collapse-header">Votación</h6>
                            <a class="collapse-item" href="Reporte.jsp">Reporte Votos</a>
                            <a class="collapse-item" href="ReporteNoVotos.jsp">Reporte de Aprendices <br>sin Votos</a>
                            <a class="collapse-item" href="ReporteJornadaElectoral.jsp">Reporte de votos <br>Jornada Electoral</a>
                        </div>
                    </div>
                </li>
                <% }%>

                <%  if (usuVO.getUsuRol().equals("2") && (usuVO.getEstado_voto().equals("No voto"))) {%>
                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
                        <i class="fas fa-fw fa-cog"></i>
                        <span>Gestiones</span>
                    </a>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Gestiones</h6>
                            <a class="collapse-item" href="GestionPropuestas.jsp">Gestion propuestas</a>
                        </div>
                    </div>
                </li>


                <!-- Nav Item - Utilities Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                        <i class="fas fa-fw fa-wrench"></i>
                        <span>Utilidades</span>
                    </a>
                    <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Candidatura</h6>
                            <a class="collapse-item" href="CandidatosElectos.jsp">Candidatos a elegir</a>
                            <h6 class="collapse-header">Votación</h6>
                            <a class="collapse-item" href="Voto.jsp">Votar</a>
                        </div>
                    </div>
                </li>
                <%}%>

                <%if (usuVO.getUsuRol().equals("2") && (usuVO.getEstado_voto().equals("Voto"))) {%>

                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
                        <i class="fas fa-fw fa-cog"></i>
                        <span>Gestiones</span>
                    </a>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Gestiones</h6>
                            <a class="collapse-item" href="GestionPropuestas.jsp">Gestion propuestas</a>
                        </div>
                    </div>
                </li>


                <!-- Nav Item - Utilities Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                        <i class="fas fa-fw fa-wrench"></i>
                        <span>Utilidades</span>
                    </a>
                    <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Candidatura</h6>
                            <a class="collapse-item" href="CandidatosElectos.jsp">Candidatos a elegir</a>
                        </div>
                    </div>
                </li>
                <%}%>

                <%  if (usuVO.getUsuRol().equals("3") && (usuVO.getEstado_voto().equals("No voto"))) {%>

                <!-- Nav Item - Utilities Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                        <i class="fas fa-fw fa-wrench"></i>
                        <span>Utilidades</span>
                    </a>
                    <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Candidatura</h6>
                            <a class="collapse-item" href="CandidatosElectos.jsp">Candidatos a elegir</a>
                            <a class="collapse-item" href="LanzarseCandidato.jsp">Lanzarse candidato</a>
                            <h6 class="collapse-header">Votación</h6>
                            <a class="collapse-item" href="Voto.jsp">Votar</a>
                        </div>
                    </div>
                </li>
                <%}%>

                <%  if (usuVO.getUsuRol().equals("3") && (usuVO.getEstado_voto().equals("Voto"))) {%>

                <!-- Nav Item - Utilities Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                        <i class="fas fa-fw fa-wrench"></i>
                        <span>Utilidades</span>
                    </a>
                    <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Candidatura</h6>
                            <a class="collapse-item" href="CandidatosElectos.jsp">Candidatos a elegir</a>
                            <a class="collapse-item" href="LanzarseCandidato.jsp">Lanzarse candidato</a>
                        </div>
                    </div>
                </li>
                <%}%>



                <!-- Divider -->
                <hr class="sidebar-divider d-none d-md-block">

                <!-- Sidebar Toggler (Sidebar) -->
                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>

            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>

                        <!-- Topbar Search -->
                        <!--<form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                          <div class="input-group">
                            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                            <div class="input-group-append">
                              <button class="btn btn-primary" type="button">
                                <i class="fas fa-search fa-sm"></i>
                              </button>
                            </div>
                          </div>
                        </form>-->

                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">

                            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                            <li class="nav-item dropdown no-arrow d-sm-none">
                                <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-search fa-fw"></i>
                                </a>
                                <!-- Dropdown - Messages -->
                                <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                                    <form class="form-inline mr-auto w-100 navbar-search">
                                        <div class="input-group">
                                            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                                            <div class="input-group-append">
                                                <button class="btn btn-primary" type="button">
                                                    <i class="fas fa-search fa-sm"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </li>


                            <div class="topbar-divider d-none d-sm-block"></div>

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%=usuVO.getNombres_persona()%> <%=usuVO.getPrimerapellido_persona()%> <%=usuVO.getSegundoapellido_persona()%></span>
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                                    <a class="dropdown-item" href="perfil.jsp">
                                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Configuracion del perfil
                                    </a>

                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Cerrar Sesión
                                    </a>
                                </div>
                            </li>

                        </ul>

                    </nav>
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid" style="width: 40%">

                        <!-- Page Heading -->

                        <h1 class="h3 mb-4 text-gray-800">Candidatos electos</h1>


                        <!-- Custom Text Color Utilities -->
                        <%

                            CandidatoVO candidatoVO = new CandidatoVO();
                            CandidatoDAO candidatoDAO = new CandidatoDAO();

                            ArrayList<CandidatoVO> listaCandidatosElectos = candidatoDAO.listarCandidatosElectos();

                            for (int i = 0; i < listaCandidatosElectos.size(); i++) {
                                candidatoVO = listaCandidatosElectos.get(i);
                                int id_candidato = Integer.parseInt(candidatoVO.getId_candidato());
                                ArrayList<CandidatoVO> listaCandidatosElectospropuestas = candidatoDAO.listarCandidatosElectosPropuestas(id_candidato);
                                ArrayList<CandidatoVO> VIDEO = candidatoDAO.listarcandidatoelectovideo(id_candidato);
                               // ArrayList<CandidatoVO> listacandidatovideo = candidatoDAO.listarImagenes(id_candidato); 
                               
                                
                               
                        %>
                        <form action="candidatose.html" class="form-inline">
                            <style>
                                .form-inline {
                                    display: flex;
                                    flex-flow: row wrap;
                                    align-items: center;
                                }
                                .form-inline select {
                                    vertical-align: middle;
                                    margin: 5px 10px 5px 0;
                                    padding: 10px;
                                    background-color: #fff;
                                    border: 1px solid #ddd;
                                }

                                @media (max-width: 800px) {
                                    .form-inline select {
                                        margin: 10px 0;
                                    }
                                    .form-inline {
                                        flex-direction: column;
                                        align-items: stretch;
                                    }
                                </style>

                                <div class="card shadow mb-4" style="width: 70%;">
                                    <div class="card-header py-3">
                                        <h6 class="m-0 font-weight-bold text-primary">Candidato</h6>
                                    </div>
                                    <div class="card-body">
                                        <div class="card-body" style="text-align: center">
                                            <style>
                                                .responsive {
                                                    width: 100%;
                                                    max-width: 300px;
                                                    height: auto;
                                                </style>
                                                <img src="CargaImagen?id=<%=candidatoVO.getId_candidato()%>" style="width: 250px; height: 300px;" alt="" class="responsive img-thumbnail"><br><br>
                                                <label for="" id="nom1" style="font-size: 20px"><%=candidatoVO.getNombres_candidato()%> <%= candidatoVO.getPrimerapellido_candidato()%></label><br>
                                                <label for="" id="nom1" style="font-size: 20px">Jornada <%= candidatoVO.getJornada()%></label>
                                                </div>
                                            </div>
                                            <center>
                                                <div class="card shadow mb-4">
                                                    <%
                                                        for (int b = 0; b < listaCandidatosElectospropuestas.size(); b++) {
                                                            candidatoVO = listaCandidatosElectospropuestas.get(b);%>
                                                    <!-- Card Header - Accordion -->
                                                    <a href="#collapseCardExample" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseCardExample">
                                                        <h6 class="m-0 font-weight-bold text-primary">No Propuesta <%=candidatoVO.getNo_propuesta()%></h6>
                                                    </a>
                                                    <!-- Card Content - Collapse -->
                                                    <div class="collapse show" id="collapseCardExample" >
                                                        <div class="card-body">
                                                            <%=candidatoVO.getDescripcion_propuesta()%>
                                                        </div>
                                                    </div>
                                                    <% }%>
                                                </div>
                                            </center>

                                            <div class="card shadow mb-4" style="margin-left: 10px">
                                                <div class="card-header py-3">
                                                    <h6 class="m-0 font-weight-bold text-primary">Video propuesta</h6>
                                                </div>
                                                <%

                                                    for (int hj = 0; hj < VIDEO.size(); hj++) {
                                                        candidatoVO = VIDEO.get(hj);%>
                                                <div class="card-body">
                                                    <!-- Card Content - Collapse -->

                                                    <div class="collapse show" id="collapseCardVideo" style="padding-bottom: 40px">

                                                        <div class="card-body" style="text-align: center; " >

                                                        <a href="<%= candidatoVO.getVideourl()%>" class="form-control" style="margin-bottom: 8px">Video de las propuestas</a><br>


                                                        </div>

                                                    </div>

                                                </div>
                                                <% }%>
                                            </div>
                                        </div>
                                        <% }%>

                                    </form>
                                </div>
                                <!-- /.container-fluid -->

                            </div>

                            <!-- End of Main Content -->

                            <!-- Footer -->
                            <footer class="sticky-footer bg-white">
                                <div class="container my-auto">
                                    <div class="copyright text-center my-auto">
                                        <span>Copyright &copy; Elecciónplus 2019</span>
                                    </div>
                                </div>
                            </footer>
                            <!-- End of Footer -->

                        </div>
                        <!-- End of Content Wrapper -->

                    </div>
                    <!-- End of Page Wrapper -->

                    <!-- Scroll to Top Button-->
                    <a class="scroll-to-top rounded" href="#page-top">
                        <i class="fas fa-angle-up"></i>
                    </a>

                    <!-- Logout Modal-->
                    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">¿Estas seguro?</h5>
                                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">×</span>
                                    </button>
                                </div>
                                <div class="modal-body">Oprime "Cerrar Sesion" si estas de acuerdo con cerrar la sesion actual.</div>
                                <div class="modal-footer">
                                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
                                    <a class="btn btn-warning" href="CerrarSesion">Cerrar sesion</a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Bootstrap core JavaScript-->
                    <script src="vendor/jquery/jquery.min.js"></script>
                    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

                    <!-- Core plugin JavaScript-->
                    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

                    <!-- Custom scripts for all pages-->
                    <script src="js/sb-admin-2.min.js"></script>

                </body>
                <% }%>
            </html>
