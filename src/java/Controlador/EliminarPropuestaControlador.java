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
import modeloDAO.PropuestaDAO;
import modeloVO.PropuestaVO;

/**
 *
 * @author migol
 */
@WebServlet(name = "EliminarPropuestaControlador", urlPatterns = {"/EliminarPropuesta"})
public class EliminarPropuestaControlador extends HttpServlet {

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


        int id_propuesta = Integer.parseInt(request.getParameter("id"));
        String ID_Propuesta = request.getParameter("textIdPropuesta");
        String VideoURL_Propuesta = request.getParameter("textVideoPropuesta");
        String Descripcion_Propuesta = request.getParameter("textDescripcionPropuesta");
        String No_Propuesta = request.getParameter("textnopropuesta");
        String ID_Persona = request.getParameter("textIDPersona");
        String Nombres_persona = "";
        String PrimerApellido_Persona = "";
        String Documento_Persona = "";

        PropuestaVO proVO = new PropuestaVO(ID_Propuesta, VideoURL_Propuesta, Descripcion_Propuesta, No_Propuesta, ID_Persona, Nombres_persona, PrimerApellido_Persona, Documento_Persona);
        PropuestaDAO proDAO = new PropuestaDAO(proVO);

        proDAO.eliminarRegistro(id_propuesta);
        request.getRequestDispatcher("GestionPropuestas.jsp").forward(request, response);
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
