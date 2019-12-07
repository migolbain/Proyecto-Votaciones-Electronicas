package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modeloVO.UsuarioVO;
import modeloVO.CandidatoVO;
import modeloDAO.VotoDAO;
import java.util.ArrayList;
import modeloVO.VotoVO;
import java.util.*;
import java.text.SimpleDateFormat;

public final class Voto_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/WEB-INF/Sesiones/sesion-validate.jspf");
    _jspx_dependants.add("/WEB-INF/Sesiones/sesion.jspf");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    ");


        HttpSession miSesion = (HttpSession) request.getSession();
        UsuarioVO usuVO = (UsuarioVO) miSesion.getAttribute("usuario");

        if (usuVO == null) {
            miSesion.getAttribute("mensajeError");
            request.getRequestDispatcher("CerrarSesion").forward(request, response);
        } else {
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
    
    if (miSesion.getAttribute("usuario") == null) {

        miSesion.removeAttribute("usuario");
        miSesion.invalidate();

        request.getRequestDispatcher("Index.jsp").forward(request, response);
    }

      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');

    response.setHeader("Pragma", "no-cache");
    response.addHeader("Cache-control", "must-revalidate");
    response.addHeader("Cache-control", "no-cache");
    response.addHeader("Cache-control", "no-store");
    response.setDateHeader("Expires", 0);
    

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("        <title>ELECCIONPLUS - Votar</title>\n");
      out.write("        <link rel=\"icon\" type=\"icon/png\" href=\"img/logop.png\">\n");
      out.write("        <!-- Custom fonts for this template-->\n");
      out.write("        <link href=\"vendor/fontawesome-free/css/all.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Custom styles for this template-->\n");
      out.write("        <link href=\"css/sb-admin-2.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body id=\"page-top\">\n");
      out.write("\n");
      out.write("        <!-- Page Wrapper -->\n");
      out.write("        <div id=\"wrapper\">\n");
      out.write("\n");
      out.write("            <!-- Sidebar -->\n");
      out.write("            <ul class=\"navbar-nav bg-gradient-success sidebar sidebar-dark accordion\" id=\"accordionSidebar\">\n");
      out.write("\n");
      out.write("                <!-- Sidebar - Brand -->\n");
      out.write("                <a class=\"sidebar-brand d-flex align-items-center justify-content-center\" href=\"menuAdmin.jsp\" ><!--style=\"background-color: #005CC2\"-->\n");
      out.write("                    <div class=\"sidebar-brand-icon\">\n");
      out.write("                        <img src=\"img/LogoLado.png\" class=\"img-fluid\">\n");
      out.write("                    </div>\n");
      out.write("                \n");
      out.write("                </a>\n");
      out.write("\n");
      out.write("                <!-- Divider -->\n");
      out.write("                <hr class=\"sidebar-divider my-0\">\n");
      out.write("\n");
      out.write("                <!-- Nav Item - Dashboard -->\n");
      out.write("                <li class=\"nav-item active\">\n");
      out.write("                    <a class=\"nav-link\" href=\"menuAdmin.jsp\">\n");
      out.write("                        <i class=\"fas fa-fw fa-tachometer-alt\"></i>\n");
      out.write("                        <span>Menú</span></a>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("                <!-- Divider -->\n");
      out.write("                <hr class=\"sidebar-divider\">\n");
      out.write("\n");
      out.write("                <!-- Heading -->\n");
      out.write("                <div class=\"sidebar-heading\">\n");
      out.write("                    Interfaz\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                ");
  if (usuVO.getUsuRol().equals("1")) { 
      out.write("\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapseTwo\" aria-expanded=\"true\" aria-controls=\"collapseTwo\">\n");
      out.write("                        <i class=\"fas fa-fw fa-cog\"></i>\n");
      out.write("                        <span>Gestiones</span>\n");
      out.write("                    </a>\n");
      out.write("                    <div id=\"collapseTwo\" class=\"collapse\" aria-labelledby=\"headingTwo\" data-parent=\"#accordionSidebar\">\n");
      out.write("                        <div class=\"bg-white py-2 collapse-inner rounded\">\n");
      out.write("                            <h6 class=\"collapse-header\">Gestiones</h6>\n");
      out.write("                            <a class=\"collapse-item\" href=\"GestionUsuario.jsp\">Gestion usuarios</a>\n");
      out.write("                            <a class=\"collapse-item\" href=\"GestionCandidato.jsp\">Gestion candidatos</a>\n");
      out.write("                            <a class=\"collapse-item\" href=\"Propuesta.jsp\">Ver Propuestas</a>\n");
      out.write("                            <a class=\"collapse-item\" href=\"ConteoVotos.jsp\">Conteo Votos</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <!-- Nav Item - Utilities Collapse Menu -->\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapseUtilities\" aria-expanded=\"true\" aria-controls=\"collapseUtilities\">\n");
      out.write("                        <i class=\"fas fa-fw fa-wrench\"></i>\n");
      out.write("                        <span>Utilidades</span>\n");
      out.write("                    </a>\n");
      out.write("                    <div id=\"collapseUtilities\" class=\"collapse\" aria-labelledby=\"headingUtilities\" data-parent=\"#accordionSidebar\">\n");
      out.write("                        <div class=\"bg-white py-2 collapse-inner rounded\">\n");
      out.write("                            <h6 class=\"collapse-header\">Candidatura</h6>\n");
      out.write("                            <a class=\"collapse-item\" href=\"CandidatosElectos.jsp\">Candidatos a elegir</a>\n");
      out.write("                            <h6 class=\"collapse-header\">Votación</h6>\n");
      out.write("                            <a class=\"collapse-item\" href=\"Reporte.jsp\">Reporte Votos</a>\n");
      out.write("                            <a class=\"collapse-item\" href=\"ReporteNoVotos.jsp\">Reporte de Aprendices <br>sin Votos</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("\n");
      out.write("                ");
  if (usuVO.getUsuRol().equals("2") && (usuVO.getEstado_voto().equals("No voto"))) {
      out.write("\n");
      out.write("                <!-- Nav Item - Pages Collapse Menu -->\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapseTwo\" aria-expanded=\"true\" aria-controls=\"collapseTwo\">\n");
      out.write("                        <i class=\"fas fa-fw fa-cog\"></i>\n");
      out.write("                        <span>Gestiones</span>\n");
      out.write("                    </a>\n");
      out.write("                    <div id=\"collapseTwo\" class=\"collapse\" aria-labelledby=\"headingTwo\" data-parent=\"#accordionSidebar\">\n");
      out.write("                        <div class=\"bg-white py-2 collapse-inner rounded\">\n");
      out.write("                            <h6 class=\"collapse-header\">Gestiones</h6>\n");
      out.write("                            <a class=\"collapse-item\" href=\"GestionPropuestas.jsp\">Gestion propuestas</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <!-- Nav Item - Utilities Collapse Menu -->\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapseUtilities\" aria-expanded=\"true\" aria-controls=\"collapseUtilities\">\n");
      out.write("                        <i class=\"fas fa-fw fa-wrench\"></i>\n");
      out.write("                        <span>Utilidades</span>\n");
      out.write("                    </a>\n");
      out.write("                    <div id=\"collapseUtilities\" class=\"collapse\" aria-labelledby=\"headingUtilities\" data-parent=\"#accordionSidebar\">\n");
      out.write("                        <div class=\"bg-white py-2 collapse-inner rounded\">\n");
      out.write("                            <h6 class=\"collapse-header\">Candidatura</h6>\n");
      out.write("                            <a class=\"collapse-item\" href=\"CandidatosElectos.jsp\">Candidatos a elegir</a>\n");
      out.write("                            <h6 class=\"collapse-header\">Votación</h6>\n");
      out.write("                            <a class=\"collapse-item\" href=\"Voto.jsp\">Votar</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("\n");
      out.write("                ");
if (usuVO.getUsuRol().equals("2") && (usuVO.getEstado_voto().equals("Voto"))) {
      out.write("\n");
      out.write("\n");
      out.write("                <!-- Nav Item - Pages Collapse Menu -->\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapseTwo\" aria-expanded=\"true\" aria-controls=\"collapseTwo\">\n");
      out.write("                        <i class=\"fas fa-fw fa-cog\"></i>\n");
      out.write("                        <span>Gestiones</span>\n");
      out.write("                    </a>\n");
      out.write("                    <div id=\"collapseTwo\" class=\"collapse\" aria-labelledby=\"headingTwo\" data-parent=\"#accordionSidebar\">\n");
      out.write("                        <div class=\"bg-white py-2 collapse-inner rounded\">\n");
      out.write("                            <h6 class=\"collapse-header\">Gestiones</h6>\n");
      out.write("                            <a class=\"collapse-item\" href=\"GestionPropuestas.jsp\">Gestion propuestas</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <!-- Nav Item - Utilities Collapse Menu -->\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapseUtilities\" aria-expanded=\"true\" aria-controls=\"collapseUtilities\">\n");
      out.write("                        <i class=\"fas fa-fw fa-wrench\"></i>\n");
      out.write("                        <span>Utilidades</span>\n");
      out.write("                    </a>\n");
      out.write("                    <div id=\"collapseUtilities\" class=\"collapse\" aria-labelledby=\"headingUtilities\" data-parent=\"#accordionSidebar\">\n");
      out.write("                        <div class=\"bg-white py-2 collapse-inner rounded\">\n");
      out.write("                            <h6 class=\"collapse-header\">Candidatura</h6>\n");
      out.write("                            <a class=\"collapse-item\" href=\"CandidatosElectos.jsp\">Candidatos a elegir</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("\n");
      out.write("                ");
  if (usuVO.getUsuRol().equals("3") && (usuVO.getEstado_voto().equals("No voto"))) {
      out.write("\n");
      out.write("\n");
      out.write("                <!-- Nav Item - Utilities Collapse Menu -->\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapseUtilities\" aria-expanded=\"true\" aria-controls=\"collapseUtilities\">\n");
      out.write("                        <i class=\"fas fa-fw fa-wrench\"></i>\n");
      out.write("                        <span>Utilidades</span>\n");
      out.write("                    </a>\n");
      out.write("                    <div id=\"collapseUtilities\" class=\"collapse\" aria-labelledby=\"headingUtilities\" data-parent=\"#accordionSidebar\">\n");
      out.write("                        <div class=\"bg-white py-2 collapse-inner rounded\">\n");
      out.write("                            <h6 class=\"collapse-header\">Candidatura</h6>\n");
      out.write("                            <a class=\"collapse-item\" href=\"CandidatosElectos.jsp\">Candidatos a elegir</a>\n");
      out.write("                            <a class=\"collapse-item\" href=\"LanzarseCandidato.jsp\">Lanzarse candidato</a>\n");
      out.write("                            <h6 class=\"collapse-header\">Votación</h6>\n");
      out.write("                            <a class=\"collapse-item\" href=\"Voto.jsp\">Votar</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("\n");
      out.write("                ");
  if (usuVO.getUsuRol().equals("3") && (usuVO.getEstado_voto().equals("Voto"))) {
      out.write("\n");
      out.write("\n");
      out.write("                <!-- Nav Item - Utilities Collapse Menu -->\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapseUtilities\" aria-expanded=\"true\" aria-controls=\"collapseUtilities\">\n");
      out.write("                        <i class=\"fas fa-fw fa-wrench\"></i>\n");
      out.write("                        <span>Utilidades</span>\n");
      out.write("                    </a>\n");
      out.write("                    <div id=\"collapseUtilities\" class=\"collapse\" aria-labelledby=\"headingUtilities\" data-parent=\"#accordionSidebar\">\n");
      out.write("                        <div class=\"bg-white py-2 collapse-inner rounded\">\n");
      out.write("                            <h6 class=\"collapse-header\">Candidatura</h6>\n");
      out.write("                            <a class=\"collapse-item\" href=\"CandidatosElectos.jsp\">Candidatos a elegir</a>\n");
      out.write("                            <a class=\"collapse-item\" href=\"LanzarseCandidato.jsp\">Lanzarse candidato</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("\n");
      out.write("                <!-- Divider -->\n");
      out.write("                <hr class=\"sidebar-divider d-none d-md-block\">\n");
      out.write("\n");
      out.write("                <!-- Sidebar Toggler (Sidebar) -->\n");
      out.write("                <div class=\"text-center d-none d-md-inline\">\n");
      out.write("                    <button class=\"rounded-circle border-0\" id=\"sidebarToggle\"></button>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </ul>\n");
      out.write("            <!-- End of Sidebar -->\n");
      out.write("\n");
      out.write("\n");
      out.write("            <!-- Content Wrapper -->\n");
      out.write("            <div id=\"content-wrapper\" class=\"d-flex flex-column\">\n");
      out.write("\n");
      out.write("                <!-- Main Content -->\n");
      out.write("                <div id=\"content\">\n");
      out.write("\n");
      out.write("                    <!-- Topbar -->\n");
      out.write("                    <nav class=\"navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow\">\n");
      out.write("\n");
      out.write("                        <!-- Sidebar Toggle (Topbar) -->\n");
      out.write("                        <button id=\"sidebarToggleTop\" class=\"btn btn-link d-md-none rounded-circle mr-3\">\n");
      out.write("                            <i class=\"fa fa-bars\"></i>\n");
      out.write("                        </button>\n");
      out.write("\n");
      out.write("                        <!-- Topbar Search -->\n");
      out.write("                        <!--<form class=\"d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search\">\n");
      out.write("                          <div class=\"input-group\">\n");
      out.write("                            <input type=\"text\" class=\"form-control bg-light border-0 small\" placeholder=\"Search for...\" aria-label=\"Search\" aria-describedby=\"basic-addon2\">\n");
      out.write("                            <div class=\"input-group-append\">\n");
      out.write("                              <button class=\"btn btn-primary\" type=\"button\">\n");
      out.write("                                <i class=\"fas fa-search fa-sm\"></i>\n");
      out.write("                              </button>\n");
      out.write("                            </div>\n");
      out.write("                          </div>\n");
      out.write("                        </form>-->\n");
      out.write("\n");
      out.write("                        <!-- Topbar Navbar -->\n");
      out.write("                        <ul class=\"navbar-nav ml-auto\">\n");
      out.write("\n");
      out.write("                            <!-- Nav Item - Search Dropdown (Visible Only XS) -->\n");
      out.write("                            <li class=\"nav-item dropdown no-arrow d-sm-none\">\n");
      out.write("                                <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"searchDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                                    <i class=\"fas fa-search fa-fw\"></i>\n");
      out.write("                                </a>\n");
      out.write("                                <!-- Dropdown - Messages -->\n");
      out.write("                                <div class=\"dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in\" aria-labelledby=\"searchDropdown\">\n");
      out.write("                                    <form class=\"form-inline mr-auto w-100 navbar-search\">\n");
      out.write("                                        <div class=\"input-group\">\n");
      out.write("                                            <input type=\"text\" class=\"form-control bg-light border-0 small\" placeholder=\"Search for...\" aria-label=\"Search\" aria-describedby=\"basic-addon2\">\n");
      out.write("                                            <div class=\"input-group-append\">\n");
      out.write("                                                <button class=\"btn btn-primary\" type=\"button\">\n");
      out.write("                                                    <i class=\"fas fa-search fa-sm\"></i>\n");
      out.write("                                                </button>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                            </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <div class=\"topbar-divider d-none d-sm-block\"></div>\n");
      out.write("\n");
      out.write("                            <!-- Nav Item - User Information -->\n");
      out.write("                            <li class=\"nav-item dropdown no-arrow\">\n");
      out.write("                                <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"userDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                                    <span class=\"mr-2 d-none d-lg-inline text-gray-600 small\">");
      out.print(usuVO.getNombres_persona());
      out.write(' ');
      out.print(usuVO.getPrimerapellido_persona());
      out.write(' ');
      out.print(usuVO.getSegundoapellido_persona());
      out.write("</span>\n");
      out.write("\n");
      out.write("                                </a>\n");
      out.write("                                <!-- Dropdown - User Information -->\n");
      out.write("                                <div class=\"dropdown-menu dropdown-menu-right shadow animated--grow-in\" aria-labelledby=\"userDropdown\">\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"perfil.jsp\">\n");
      out.write("                                        <i class=\"fas fa-user fa-sm fa-fw mr-2 text-gray-400\"></i>\n");
      out.write("                                        Configuracion del perfil\n");
      out.write("                                    </a>\n");
      out.write("\n");
      out.write("                                    <div class=\"dropdown-divider\"></div>\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"#\" data-toggle=\"modal\" data-target=\"#logoutModal\">\n");
      out.write("                                        <i class=\"fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400\"></i>\n");
      out.write("                                        Cerrar Sesión\n");
      out.write("                                    </a>\n");
      out.write("                                </div>\n");
      out.write("                            </li>\n");
      out.write("\n");
      out.write("                        </ul>\n");
      out.write("\n");
      out.write("                    </nav>\n");
      out.write("                    <!-- End of Topbar -->\n");
      out.write("\n");
      out.write("                    <!-- Begin Page Content -->\n");
      out.write("                    <div class=\"container-fluid\">\n");
      out.write("                        <h1 class=\"h3 mb-1 text-gray-800\">Votaciones</h1>\n");
      out.write("                        ");
                            Date dNow = new Date();
                            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
                            String fecha = ft.format(dNow);

                            VotoVO votoVO = new VotoVO();
                            VotoDAO votoDAO = new VotoDAO();

                            ArrayList<VotoVO> consultaultimaID = votoDAO.consultarultimovoto();
                            for (int b = 0; b < consultaultimaID.size(); b++) {
                                votoVO = consultaultimaID.get(b);
                            }
                            String num1 = votoVO.getId_voto();
                            int id = Integer.parseInt(num1);
                            int num_increid = id + 1;
                            String numero_id = Integer.toString(num_increid);

                            String num2 = votoVO.getNo_voto();
                            int novoto = Integer.parseInt(num2);
                            int num_increvoto = novoto + 1;
                            String numero_voto = Integer.toString(num_increvoto);

                            int id_jornada = Integer.parseInt(usuVO.getId_jornada());
                            ArrayList<VotoVO> listaCandidatos = votoDAO.listarCandidatosvoto(id_jornada);

                            String estado_voto = "Voto";

                            for (int i = 0; i < listaCandidatos.size(); i++) {
                                
                          
                    
                                votoVO = listaCandidatos.get(i);

                        
      out.write("\n");
      out.write("\n");
      out.write("                        <!-- Page Heading -->\n");
      out.write("\n");
      out.write("                        <!-- Content Row -->\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <!-- Grow In Utility -->\n");
      out.write("                        <center>\n");
      out.write("                            <div class=\"col-lg-6\">\n");
      out.write("\n");
      out.write("                                <div class=\"card position-relative\" style=\"width: 50%\">\n");
      out.write("                                    <div class=\"card-header py-3\">\n");
      out.write("                                        <h6 class=\"m-0 font-weight-bold text-primary\">Candidato</h6>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"card-body\" style=\"text-align: center\">\n");
      out.write("                                        <style>\n");
      out.write("                                            .responsive {\n");
      out.write("                                                width: 100%;\n");
      out.write("                                                max-width: 300px;\n");
      out.write("                                                height: auto;\n");
      out.write("                                            }\n");
      out.write("                                        </style>\n");
      out.write("\n");
      out.write("                                        <form method=\"post\" action=\"Voto\">                                                       \n");
      out.write("\n");
      out.write("                                            <input type=\"hidden\" value=\"");
      out.print(estado_voto);
      out.write("\" name=\"textestado_voto\">\n");
      out.write("                                            <input type=\"hidden\" value=\"");
      out.print(fecha);
      out.write("\" name=\"textfecha\">\n");
      out.write("                                            <input type=\"hidden\" value=\"");
      out.print(numero_id);
      out.write("\" name=\"textidvoto\">\n");
      out.write("                                            <input type=\"hidden\" value=\"");
      out.print(numero_voto);
      out.write("\" name=\"textno_voto\">\n");
      out.write("                                            <input type=\"hidden\" value=\"");
      out.print(votoVO.getId_persona());
      out.write("\" name=\"textidpersona\">\n");
      out.write("                                            <input type=\"hidden\" value=\"");
      out.print(usuVO.getId_persona());
      out.write("\" name=\"textidpersonavoto\">\n");
      out.write("                                            <img src=\"img/candidato.jpg\" width=\"300px\" alt=\"\" class=\"responsive\"><br>\n");
      out.write("                                            <label for=\"\" id=\"nom1\" style=\"font-size: 20px\">");
      out.print( votoVO.getNombres_candidato());
      out.write(' ');
      out.print( votoVO.getPrimerapellido_candidato());
      out.write("</label>\n");
      out.write("                                            <button type=\"button\" class=\"form-control bg-warning text-white\" data-toggle=\"modal\" data-target=\"#votoModal");
      out.print(i);
      out.write("\">Votar \n");
      out.write("\n");
      out.write("                                            </button><br>\n");
      out.write("\n");
      out.write("                                            <div class=\"modal fade\" id=\"votoModal");
      out.print(i);
      out.write("\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("                                                <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("                                                    <div class=\"modal-content\">\n");
      out.write("                                                        <div class=\"modal-header\">\n");
      out.write("                                                            <h5 class=\"modal-title\" id=\"exampleModalLabel\">¿Estás seguro?</h5>\n");
      out.write("                                                            <button class=\"close\" type=\"button\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                                                                <span aria-hidden=\"true\">×</span>\n");
      out.write("                                                            </button>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        <div class=\"modal-body\">¿Estás seguro de Votar por este Candidato?</div>\n");
      out.write("                                                        <div class=\"modal-body\">Su sesión sera cerrada si lo hace</div>\n");
      out.write("                                                        <div class=\"modal-footer\">\n");
      out.write("                                                            <button class=\"btn btn-secondary\" type=\"button\" data-dismiss=\"modal\">Cancelar</button>\n");
      out.write("                                                            <button class=\"btn btn-warning\">Votar</button>\n");
      out.write("                                                            <input type=\"hidden\" name=\"opcion\" value=\"1\">\n");
      out.write("\n");
      out.write("                                                        </div>\n");
      out.write("                                                    </div>\n");
      out.write("\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\t\n");
      out.write("                                        </form>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </center>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                        <!-- Fade In Utility -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.container-fluid -->\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <!-- End of Main Content -->\n");
      out.write("\n");
      out.write("                <!-- Footer -->\n");
      out.write("                <footer class=\"sticky-footer bg-white\">\n");
      out.write("                    <div class=\"container my-auto\">\n");
      out.write("                        <div class=\"copyright text-center my-auto\">\n");
      out.write("                            <span>Copyright &copy; Eleccionplus 2019</span>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </footer>\n");
      out.write("                <!-- End of Footer -->\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!-- End of Content Wrapper -->\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!-- End of Page Wrapper -->\n");
      out.write("\n");
      out.write("        <!-- Scroll to Top Button-->\n");
      out.write("        <a class=\"scroll-to-top rounded\" href=\"#page-top\">\n");
      out.write("            <i class=\"fas fa-angle-up\"></i>\n");
      out.write("        </a>\n");
      out.write("\n");
      out.write("        <!-- Logout Modal-->\n");
      out.write("        <div class=\"modal fade\" id=\"logoutModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("            <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <h5 class=\"modal-title\" id=\"exampleModalLabel\">¿Estas seguro?</h5>\n");
      out.write("                        <button class=\"close\" type=\"button\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                            <span aria-hidden=\"true\">×</span>\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">Oprime \"Cerrar Sesion\" si estas de acuerdo con cerrar la sesion actual.</div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button class=\"btn btn-secondary\" type=\"button\" data-dismiss=\"modal\">Cancelar</button>\n");
      out.write("                        <a class=\"btn btn-warning\" href=\"CerrarSesion\">Cerrar sesion</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core JavaScript-->\n");
      out.write("        <script src=\"vendor/jquery/jquery.min.js\"></script>\n");
      out.write("        <script src=\"vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Core plugin JavaScript-->\n");
      out.write("        <script src=\"vendor/jquery-easing/jquery.easing.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Custom scripts for all pages-->\n");
      out.write("        <script src=\"js/sb-admin-2.min.js\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("    ");
 }
      out.write("\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
