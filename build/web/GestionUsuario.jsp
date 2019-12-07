<%-- 
    Document   : GestionUsuario
    Created on : 27-ago-2019, 23:51:59
    Author     : MigolBain
--%>
<%@page import="java.security.SecureRandom"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modeloDAO.PerfilDAO"%>
<%@page import="modeloVO.UsuarioVO"%>
<%@page import="modeloVO.PerfilVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <%

        HttpSession miSesion = (HttpSession) request.getSession();
        UsuarioVO usuVO = (UsuarioVO) miSesion.getAttribute("usuario");

        if (usuVO == null) {
            miSesion.getAttribute("mensajeError");
            request.getRequestDispatcher("CerrarSesion").forward(request, response);
        } else if (usuVO.getUsuRol().equals("1")) {%>
    <%@include file="WEB-INF/Sesiones/sesion-validate.jspf"%>
    <%@include file="WEB-INF/Sesiones/sesion.jspf"%>
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>ELECCIONPLUS - Tablas</title>
        <link rel="icon" type="icon/png" href="img/logop.png">
        <!-- Custom fonts for this template -->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

        <!-- Custom styles for this page -->
        <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">


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
                                        Configuración del perfil
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
                    <div class="container-fluid">

                        <!-- Page Heading -->
                        <h1 class="h3 mb-2 text-gray-800">Gestión usuario</h1>
                        <p class="mb-4">Tabla del contenido de las gestiones de usuarios</p>

                        <!-- DataTales Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Gestión usuarios</h6>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th># Persona</th>
                                                <th>Tipo Identificación</th>
                                                <th>Documento</th>
                                                <th>Nombres</th>
                                                <th>Primer Apellido</th>
                                                <th>Segundo Apellido</th>
                                                <th>Genero</th>
                                                <th>Correo electronico</th>
                                                <th>Estado Formacion</th>
                                                <th>Estado Voto</th>
                                                <th>Estado Candidato</th>
                                                <th>Usuario</th>
                                                <th>Jornada</th>
                                                <th>Rol</th>
                                                <th>Cargo</th>
                                                <th>Editar</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%                                                    PerfilVO perfilVO = new PerfilVO();
                                                PerfilDAO perfilDAO = new PerfilDAO(perfilVO);
                                                ArrayList<PerfilVO> listaUsuarios = perfilDAO.listarUsuarios();
                                                for (int i = 0; i < listaUsuarios.size(); i++) {
                                                    perfilVO = listaUsuarios.get(i);
                                            %>

                                            <tr>

                                                <td>
                                                    <%= perfilVO.getId_persona()%>
                                                </td>
                                                <td>
                                                    <%= perfilVO.getTipoid_persona()%>
                                                </td>
                                                <td>
                                                    <%= perfilVO.getDocumento_persona()%>
                                                </td>
                                                <td>
                                                    <%= perfilVO.getNombres_persona()%>
                                                </td>
                                                <td>
                                                    <%= perfilVO.getPrimerapellido_persona()%>
                                                </td>

                                                <td>
                                                    <%= perfilVO.getSegundoapellido_persona()%>
                                                </td>
                                                <td>
                                                    <%= perfilVO.getGenero_persona()%>
                                                </td>
                                                <td>
                                                    <%= perfilVO.getCorreo_persona()%>
                                                </td>
                                                <td>
                                                    <%= perfilVO.getEstado_formacion()%>
                                                </td>
                                                <td>
                                                    <%= perfilVO.getEstado_voto()%>
                                                </td>
                                                <td>
                                                    <%= perfilVO.getEstado_candidato()%>
                                                </td>
                                                <td>
                                                    <%= perfilVO.getId_usuario()%>
                                                </td>
                                                <td>
                                                    <%= perfilVO.getJornada()%>
                                                </td>                            
                                                <td>
                                                    <%= perfilVO.getRol()%>
                                                </td>
                                                <td>
                                                    <%= perfilVO.getCargo()%>
                                                </td>

                                                <td style="text-align: center;">
                                                    <a href="GestionUsuarioActualizar.jsp?id=<%=perfilVO.getId_persona()%>" title="Modificar Usuario"><i class="far fa-hand-pointer"></i></a>
                                                </td>

                                            </tr>
                                            <%}%>

                                        </tbody>
                                    </table>


                                    <button type="button" class="btn btn-secondary btn-lg" data-toggle="modal" data-target="#myModal">Insertar usuario 
                                        <i class="far fa-hand-pointer"></i>
                                    </button>


                                    <!-- Modal -->
                                    <%

                                        ArrayList<PerfilVO> consultaultimaID = perfilDAO.consultarultimaid();
                                        for (int i = 0; i < consultaultimaID.size(); i++) {
                                            perfilVO = consultaultimaID.get(i);
                                        }
                                        String num1 = perfilVO.getId_persona();
                                        int numero = Integer.parseInt(num1);
                                        int num_incre = numero + 1;
                                        String numero_completo = Integer.toString(num_incre);

                                        SecureRandom numeroRandom = SecureRandom.getInstance("SHA1PRNG");
                                        int numRandom = numeroRandom.nextInt(1000000);


                                    %>

                                    <form method="post" action="Usuario">

                                        <div class="modal fullscreen-modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                            <div class="modal-dialog" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h4 class="modal-title" id="myModalLabel">Insertar usuario</h4><button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <%-- <label for=""># [ID] Persona</label> --%><input type="hidden" name="textidpersona" class="form-control" value="<%=numero_completo%>" readonly>
                                                        <label for="">Tipo identificación</label><select id="txttipodoc" name="texttipoid_persona"  class="form-control" required>
                                                            <option value ="">Elija una opcion...</option>
                                                            <option value="Cedula de Ciudadania">Cédula de Ciudadanía</option>
                                                            <option value="Tarjeta de Identidad">Tarjeta de Identidad</option>
                                                            <option value="Cedula de extranjeria">Cédula de Extranjería</option>
                                                            <option value="Numero ciego SENA">Número ciego SENA</option>
                                                            <option value="Pasaporte">Pasaporte</option>
                                                            <option value="Documento Nacional de Identificacion">Documento Nacional de Identificación</option>
                                                            <option value="Numero de Identificacion Tributaria">Número de Identificación Tributaría</option>
                                                            <option value="PEP - RAMV">PEP - RAMV</option>
                                                        </select>
                                                        <label for="">Documento</label><input type="number" onkeypress="return event.target.value.length < 13" name="textdocumento_persona" class="form-control"  required=»required» pattern="[0-9]+">
                                                        <label for="">Nombres</label><input type="text" id="name" name="textnombres_persona" class="form-control" required=»required» maxlength="50" required=»required» pattern="[A-Za-z,ZñÑáéíóúÁÉÍÓÚ\s ]+">
                                                        <label for="">Primer apellido</label><input type="text" name="textprimerapellido_persona" class="form-control" maxlength="25" required=»required» pattern="[A-Za-z,ZñÑáéíóúÁÉÍÓÚ\s  ]+">
                                                        <label for="">Segundo apellido</label><input type="text" name="textsegundoapellido_persona" class="form-control" maxlength="20" required=»required» pattern="[A-Za-z,ZñÑáéíóúÁÉÍÓÚ\s ]+">
                                                        <label for="">Genero</label><select id="selectgenero" name="textgenero_persona"  class="form-control" required=»required»>
                                                            <option value ="">Elija una opcion...</option>
                                                            <option value="Masculino">Masculino</option>
                                                            <option value="Femenino">Femenino</option>
                                                        </select>
                                                        <label for="">Correo electronico</label><input type="email" name="textcorreo" placeholder="My@example.com" class="form-control" required>
                                                        <label for="">Estado de formación</label><select id="txtestado" name="textestado_formacion" class="form-control" required>
                                                            <option value="">Elija una opcion...</option>
                                                            <option value="Activo">Activo</option>
                                                            <option value="Inactivo">Inactivo</option>
                                                        </select>  
                                                        <label for="">Estado de voto</label><select id="txtvoto" name="textestado_voto" class="form-control" required=»required»>
                                                            <option value="">Elija una opcion...</option>
                                                            <option value="No voto" required>No voto</option>
                                                            <option value="Voto" required>Voto</option>
                                                        </select>      
                                                        <label for="">Estado de candidato</label><select id="txtestadoca" name="textestado_candidato" class="form-control" required>
                                                            <option value="">Elija una opcion...</option>
                                                            <option value="Pendiente">Pendiente</option>
                                                            <option value="Aprobado">Aprobado</option>
                                                            <option value="No apto">No apto</option>    
                                                        </select>  

                                                        <label for="">Jornada</label><select name="textidjornada" class="form-control" required>
                                                            <option value="">Elija una opcion...</option>
                                                            <option value="1">Diurna</option>
                                                            <option value="2">Nocturna</option>
                                                            <option value="3">24 Horas</option>
                                                        </select>
                                                        <label for="">Rol</label><select name="textUsuRol_persona" class="form-control" required>
                                                            <option value="">Elija una opcion...</option>
                                                            <option value="1">Administrador</option>
                                                            <option value="2">Candidato</option>
                                                            <option value="3">Votante</option>
                                                        </select>

                                                        <%-- <label for="">ID Usuario</label>--%> <input type="hidden" name="textidusuario" value="<%=numero_completo%>" class="form-control" readonly>
                                                        <%--  <label for="">Usuario</label><input type="hidden" name="textUsuLogin" class="form-control" required> --%>


                                                        <%-- <label for="">Contraseña</label> --%><input type="hidden" name="textUsuPassword" class="form-control" value="<%= numRandom%>" required>

                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                                            <button class="btn btn-warning">Registrar</button><br>
                                                            <input type="hidden" name="opcion" value="1">
                                                        </div>
                                                        <input type="hidden" value="eleccionplus@gmail.com" name="de">
                                                        <input type="hidden" value="eleccionplus2019" name="clave">
                                                        <input type="hidden" value="Cordial saludo aprendiz, aqui se envia la contrasena para ingresar a las votaciones electronicas <%= numRandom%>" name="mensaje">
                                                        <input type="hidden" value="ELECCIONPLUS - Contrasena" name="asunto">
                                                    </div>

                                                </div>
                                            </div>

                                        </div>
                                    </form>
                                </div>
                            </div>

                        </div>
                        <div style="color: blue; ">
                            <% if (request.getAttribute("mensajeExito") != null) {%>   
                            ${mensajeExito}    
                            <%}%>  
                        </div>  
                    </div>
                    <!-- /.container-fluid -->

                </div>
                <!-- End of Main Content -->

                <!-- Footer -->
                <footer class="sticky-footer bg-white">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>Copyright &copy; Eleccionplus 2019</span>
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

        <!-- Page level plugins -->
        <script src="//cdn.datatables.net/plug-ins/1.10.20/i18n/Spanish.json"></script>
        <script src="vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="js/demo/datatables-demo.js"></script>
        <%}%>
    </body>

</html>
