/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modeloDAO.PerfilDAO;
import modeloVO.PerfilVO;

/**
 *
 * @author MigolBain
 */
@WebServlet(name = "DatosPersonalesControlador", urlPatterns = {"/Perfil"})
public class PerfilControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int opcion = Integer.parseInt(request.getParameter("opcion"));

        String usuId = request.getParameter("textUsuId");
        String usuLogin = request.getParameter("textdocumento_persona");
        String usuPassword = request.getParameter("textUsuPassword");
        String usuRol = request.getParameter("textUsuRol_persona");
        String nombres_persona = request.getParameter("textnombres_persona");
        String primerapellido_persona = request.getParameter("textprimerapellido_persona");
        String segundoapellido_persona = request.getParameter("textsegundoapellido_persona");
        String tipoid_persona = request.getParameter("texttipoid_persona");
        String documento_persona = request.getParameter("textdocumento_persona");
        String genero_persona = request.getParameter("textgenero_persona");
        String correo_persona = request.getParameter("textcorreo");
        String estado_formacion = request.getParameter("textestado_formacion");
        String estado_candidato = request.getParameter("textestado_candidato");
        String estado_voto = request.getParameter("textestado_voto");
        String id_jornada = request.getParameter("textidjornada");
        String id_usuario = request.getParameter("textidusuario");
        String id_persona = request.getParameter("textidpersona");
        String jornada = request.getParameter("textjornada");
        String cargo = request.getParameter("textcargo");
        String rol = request.getParameter("textrol");
        
        
        
          
            Email email = new Email();
            
            String de = request.getParameter("de"); //Correo software
            String clave = request.getParameter("clave"); //Clave Correo software
            String para = request.getParameter("textcorreo"); //Correo
            String mensaje = request.getParameter("mensaje"); //Mensaje Body
            String asunto = request.getParameter("asunto"); // Asunto
            
            
            boolean resultado = email.enviarCorreo(de, clave, para, mensaje, asunto);

        
        PerfilVO datosVO = new PerfilVO(usuId, usuLogin, usuPassword, usuRol, id_persona, tipoid_persona, documento_persona, nombres_persona, primerapellido_persona, segundoapellido_persona, genero_persona, correo_persona, estado_formacion, estado_voto, estado_candidato, id_usuario, id_jornada, jornada, rol, cargo);
        PerfilDAO datosDAO = new PerfilDAO(datosVO);

        switch (opcion) {
            case 1: //Agregar Registro
                if (datosDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "¡El Usuario ha sido registrado correctamente!");

                } else {
                    request.setAttribute("mensajeError", "¡El Usuario NO pudo ser registrado correctamente!");
                }

                request.getRequestDispatcher("GestionUsuario.jsp").forward(request, response);
                break;

            case 2: //Actualizar Registro
                if (datosDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "¡El usuario ha sido actulizado correctamente!");

                } else {
                    request.setAttribute("mensajeError", "¡El usuario NO pudo ser actualizado correctamente!");

                }
                request.getRequestDispatcher("CerrarSesion").forward(request, response);
                break;

            

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
