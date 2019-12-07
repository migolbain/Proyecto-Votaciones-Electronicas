<%-- 
    Document   : perfil
    Created on : 8/08/2019, 01:01:01 PM
    Author     : APRENDIZ
--%>
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
                            <a class="collapse-item" href="GestionPropuestas.jsp">Gestión propuestas</a>
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
                            <a class="collapse-item" href="GestionPropuestas.jsp">Gestión propuestas</a>
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
                    <div class="container-fluid" style="width: 50%;">

                        <!-- Page Heading -->
                        <h1 class="h3 mb-4 text-gray-800">Configuracion del perfil</h1>

                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Configuracion del perfil</h6>
                            </div>
                            <form method="post" action="Perfil">
                                <div class="card-body">

                                    <!-- Circle Buttons (Default) -->
                                    <div class="mb-2">
                                        <label for="">Nombres</label>
                                    </div>
                                    <input name="textnombres_persona" type="text" class="form-control" value="<%= usuVO.getNombres_persona()%>" readonly>
                                    <div class="mb-2">
                                        <label for="">Primer apellido</label>
                                    </div>
                                    <input name="textprimerapellido_persona" type="text" class="form-control" value="<%= usuVO.getPrimerapellido_persona()%>" readonly>
                                    <div class="mb-2">
                                        <label for="">Segundo apellido</label>
                                    </div>
                                    <input name="textsegundoapellido_persona" type="text" class="form-control" value="<%= usuVO.getSegundoapellido_persona()%>" readonly>
                                    <div class="mb-2">
                                        <label for="">Genero</label>
                                    </div>
                                    <select name="textgenero_persona" id="" class="form-control">
                                        <option value="<%= usuVO.getGenero_persona()%>"><%= usuVO.getGenero_persona()%></option>
                                        <option value="Masculino">Masculino</option>
                                        <option value="Femenino">Femenino</option>
                                    </select>
                                    <div class="mb-2">
                                        <label for="">Tipo de documento</label>
                                        <select name="texttipoid_persona" id="" class="form-control" readonly>
                                            <option value="<%=usuVO.getTipoid_persona()%>"><%=usuVO.getTipoid_persona()%></option>
                                            <option value="Cédula de Ciudadanía">Cédula de Ciudadanía</option>
                                            <option value="Tarjeta de Identidad">Tarjeta de Identidad</option>
                                            <option value="Cédula de Extranjería">Cédula de Extranjería</option>
                                            <option value="Número ciego SENA">Número ciego SENA</option>
                                            <option value="Pasaporte">Pasaporte</option>
                                            <option value="Documento Nacional de Identificación">Documento Nacional de Identificación</option>
                                            <option value="Número de Identificación Tributaría">Número de Identificación Tributaría</option>
                                            <option value="PEP - RAMV">PEP - RAMV</option>
                                        </select>
                                    </div>
                                    <div class="mb-2">
                                        <label for="">Numero de documento</label>
                                    </div>
                                    <input name="textdocumento_persona" type="number" class="form-control" value="<%= usuVO.getDocumento_persona()%>"readonly>
                                    <div class="mb-2">
                                        <label for="">Correo electronico</label>
                                    </div>
                                    <input name="textcorreo" type="email" class="form-control" value="<%= usuVO.getCorreo_persona()%>">
                                    <div class="mb-2">
                                        <label for="">Estado de formación</label>
                                    </div>
                                    <select name="textestado_formacion" id="" class="form-control" readonly>
                                        <option value="<%=usuVO.getEstado_formacion()%>"><%=usuVO.getEstado_formacion()%></option>
                                    </select>
                                    <div class="mb-2">
                                        <label for="">Estado del voto</label>
                                    </div>
                                    <select name="textestado_voto" id="" class="form-control" readonly>
                                        <option value="<%=usuVO.getEstado_voto()%>"><%=usuVO.getEstado_voto()%></option>
                                    </select>
                                    <div class="mb-2">
                                        <label for="">Estado de candidatura</label>
                                    </div>
                                    <select name="textestado_candidato" id="" class="form-control" readonly>
                                        <option value="<%=usuVO.getEstado_candidato()%>"><%=usuVO.getEstado_candidato()%></option>
                                    </select>
                                    <div class="mb-2">
                                        <label for="">Jornada</label>
                                    </div>
                                    <select name="textidjornada" id="" class="form-control" readonly>
                                        <option value="<%=usuVO.getId_jornada()%>"><%=usuVO.getJornada()%></option>
                                    </select>
                                    <div class="mb-2">
                                        <label for="">Rol</label>
                                    </div>
                                    <input name="textrol" type="text" class="form-control" value="<%=usuVO.getRol()%>" readonly>
                                    <div class="mb-2">
                                        <label for="">Cargo</label>
                                    </div>
                                    <input name="textcargo" type="text" class="form-control" value="<%=usuVO.getCargo()%>" readonly>

                                    <input name="textidusuario" type="hidden" class="form-control" value="<%=usuVO.getId_usuario()%>" readonly>
                                    <div class="mb-2">
                                        <label for="">Usuario</label>
                                    </div>
                                    <input name="textUsuLogin" type="text" class="form-control" value="<%=usuVO.getUsuLogin()%>" required>


                                    <div class="mb-2"><br>
                                        <button class="btn btn-warning">Guardar Configuracion</button><br>
                                    </div>
                                    <input type="hidden" value="<%=usuVO.getUsuId()%>" name="textUsuId">
                                    <input type="hidden" value="<%=usuVO.getUsuRol()%>" name="textUsuRol_persona">
                                    <input type="hidden" value="<%=usuVO.getId_persona()%>" name="textidpersona">



                                </div>
                            </form>
                            <div class="mb-2"><br>
                                <button class="btn btn-warning" data-toggle="modal" data-target="#cambiarcontrasena">Cambiar Contraseña</button><br>
                            </div>
                        </div>


                    </div>
                    <!-- /.container-fluid -->

                </div>
                <!-- End of Main Content -->
                <form method="post" action="Perfil">

                    <input name="textnombres_persona" type="hidden" class="form-control" value="<%= usuVO.getNombres_persona()%>" readonly>                
                    <input name="textprimerapellido_persona" type="hidden" class="form-control" value="<%= usuVO.getPrimerapellido_persona()%>" readonly>                   
                    <input name="textsegundoapellido_persona" type="hidden" class="form-control" value="<%= usuVO.getSegundoapellido_persona()%>" readonly>




                    <input name="textdocumento_persona" type="hidden" class="form-control" value="<%= usuVO.getDocumento_persona()%>"readonly>

                    <input name="textcorreo" type="hidden" class="form-control" value="<%= usuVO.getCorreo_persona()%>">

                    <input name="textgenero_persona" type="hidden" value="<%= usuVO.getGenero_persona()%>">
                    <input name="texttipoid_persona" type="hidden" value="<%=usuVO.getTipoid_persona()%>">
                    <input name="textestado_formacion" type="hidden" value="<%=usuVO.getEstado_formacion()%>">
                    <input name="textestado_voto" type="hidden" value="<%= usuVO.getEstado_voto()%>">
                    <input name="textestado_candidato" type="hidden" value="<%=usuVO.getEstado_candidato()%>">
                    <input name="textidjornada" type="hidden" value="<%=usuVO.getId_jornada()%>">


                    <input name="textrol" type="hidden" class="form-control" value="<%=usuVO.getRol()%>" readonly>

                    <input name="textcargo" type="hidden" class="form-control" value="<%=usuVO.getCargo()%>" readonly>
                    <input name="textidusuario" type="hidden" class="form-control" value="<%=usuVO.getId_usuario()%>" readonly>
                    <input name="textUsuLogin" type="hidden" class="form-control" value="<%=usuVO.getUsuLogin()%>" required>
                    <!-- End of Main Content -->
                    <div class="modal fade" id="cambiarcontrasena" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <input name="textidusuario" type="hidden" class="form-control" value="<%=usuVO.getId_usuario()%>" readonly>
                                <input type="hidden" value="<%=usuVO.getUsuRol()%>" name="textUsuRol_persona">
                                <input type="hidden" value="<%=usuVO.getId_persona()%>" name="textidpersona">
                                <input type="hidden" value="<%=usuVO.getUsuLogin()%>" name="textUsuLogin" >
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">¿Estas seguro de cambiar tu contraseña?</h5>
                                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">×</span>
                                    </button>
                                </div>
                                <div class="modal-body"><div class="mb-2">
                                        <label for="">Nueva Contraseña</label>
                                    </div>
                                    <input name="textUsuPassword" type="password" class="form-control" required>
                                </div>
                                <div class="modal-footer">
                                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
                                    <button class="btn btn-warning">Guardar Contraseña</button>
                                    <input type="hidden" name="opcion" value="2">

                                </div>

                            </div>
                        </div>
                    </div>
                </form>
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
                </div
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
