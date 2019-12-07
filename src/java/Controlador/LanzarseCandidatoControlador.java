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
import modeloDAO.LanzarseCandidatoDAO;
import modeloVO.LanzarseCandidatoVO;

/**
 *
 * @author migol
 */
@WebServlet(name = "LanzarseCandidatoControlador", urlPatterns = {"/LanzarseCandidato"})
public class LanzarseCandidatoControlador extends HttpServlet {

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
        String ID_Usuario = request.getParameter("textIDUsuario");
        String ID_Persona = request.getParameter("textIDPersona");
        String Estado_Candidato = request.getParameter("textEstado");
        String ID_RolUsu = request.getParameter("textRolUsu");

        LanzarseCandidatoVO lanzarsecandidatoVO = new LanzarseCandidatoVO(ID_Usuario, ID_Persona, Estado_Candidato, ID_RolUsu);
        LanzarseCandidatoDAO lanzarsecandidatoDAO = new LanzarseCandidatoDAO(lanzarsecandidatoVO);
        switch (opcion) {
            case 1: //Agregar Registro
                if (lanzarsecandidatoDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "<script>alert('Su sesión se cerrara automaticamente')</script>");

                } else {
                    request.setAttribute("mensajeError", "¡El Perfil NO pudo ser registrado correctamente!");
                }

                request.getRequestDispatcher("CerrarSesion").forward(request, response);
                break;

            case 2: //Actualizar Registro
                if (lanzarsecandidatoDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "¡El Perfil ha sido actualizado correctamente!");

                } else {
                    request.setAttribute("mensajeError", "¡El Perfil NO pudo ser actualizado correctamente!");
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
