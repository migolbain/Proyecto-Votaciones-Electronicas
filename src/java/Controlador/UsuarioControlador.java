/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modeloDAO.UsuarioDAO;
import modeloVO.UsuarioVO;

/**
 *
 * @author APRENDIZ
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/Usuario"})
public class UsuarioControlador extends HttpServlet {

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
        byte[] archivoimg = null;

        Email email = new Email();

        String de = request.getParameter("de"); //Correo software
        String clave = request.getParameter("clave"); //Clave Correo software
        String para = request.getParameter("textcorreo"); //Correo
        String mensaje = request.getParameter("mensaje"); //Mensaje Body
        String asunto = request.getParameter("asunto"); // Asunto

        boolean resultado = email.enviarCorreo(de, clave, para, mensaje, asunto);

        UsuarioVO usuVO = new UsuarioVO(usuId, usuLogin, usuPassword, usuRol, id_persona, tipoid_persona, documento_persona, nombres_persona, primerapellido_persona, segundoapellido_persona, genero_persona, correo_persona, estado_formacion, estado_voto, estado_candidato, id_usuario, id_jornada, jornada, rol, cargo, archivoimg);
        UsuarioDAO usuDAO = new UsuarioDAO(usuVO);

        switch (opcion) {
            case 1: //Agregar Registro
                if (usuDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "¡El usuario ha sido registrado correctamente!");

                } else {
                    request.setAttribute("mensajeError", "¡El usuario NO pudo ser registrado correctamente!");
                }

                request.getRequestDispatcher("GestionUsuario.jsp").forward(request, response);
                break;

            case 2: //Actualizar Registro

                if (usuDAO.actualizarRegistro()) {

                    request.setAttribute("mensajeExito", "¡El usuario ha sido actulizado correctamente!");

                } else {
                    request.setAttribute("mensajeError", "¡El usuario NO pudo ser actualizado correctamente!");

                }
                request.setAttribute("mensajeExito", "¡El Usuario ha sido actualizado correctamente!");
                request.getRequestDispatcher("GestionUsuario.jsp").forward(request, response);
                break;

            case 3: //Validar Login

                if (usuDAO.validarLogin(usuLogin, usuPassword)) {

                    ArrayList<UsuarioVO> lista = usuDAO.IniciarSesion(usuLogin, usuPassword);
                    if (lista == null) {
                        request.setAttribute("mensajeError", "<script>alert('Usuario y/o Contraseña incorrectos')</script>");
                        HttpSession miSesion = request.getSession(false);
                    } else {
                        UsuarioVO usuVO2 = lista.get(0);
                        HttpSession miSesion = request.getSession(true);
                        miSesion.setAttribute("usuario", usuVO2);
                        if (usuVO2.getUsuRol().equals("1")) {
                            request.getRequestDispatcher("menuAdmin.jsp").forward(request, response);
                        } else if (usuVO2.getUsuRol().equals("2")) {
                            request.getRequestDispatcher("menuAdmin.jsp").forward(request, response);
                        } else if (usuVO2.getUsuRol().equals("3")) {
                            request.getRequestDispatcher("menuAdmin.jsp").forward(request, response);
                        }
                    }

                } else {

                    request.setAttribute("mensajeError", "Usuario y/o Contraseña incorrectos");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }

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
