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
import javax.servlet.http.HttpSession;
import modeloDAO.PropuestaDAO;
import modeloVO.PropuestaVO;

/**
 *
 * @author APRENDIZ
 */
@WebServlet(name = "PropuestaControlador", urlPatterns = {"/Propuesta"})
public class PropuestaControlador extends HttpServlet {

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

        switch (opcion) {
            case 1://agregar Registro
                if (proDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "Propuesta registrada correctamente");
                } else {
                    request.setAttribute("mensajeError", "la propuesta no se pudo registrar");
                }
                request.getRequestDispatcher("GestionPropuestas.jsp").forward(request, response);
                break;
            case 2://Actualizar Registro
                if (proDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "La propuesta se actualizo correctamente");
                } else {
                    request.setAttribute("mensajeError", "la propuesta no se pudo actualizar");
                }
                request.getRequestDispatcher("GestionPropuestas.jsp").forward(request, response);
                break;
            
            /*case 3://Consultar por id candidato
                PropuestaVO propuestaVO = PropuestaDAO.consultarId(ID_Candidato);
                if (propuestaVO != null) {
                    request.setAttribute("voLleno", propuestaVO);
                    request.getRequestDispatcher("actualizar_propuesta.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El vheiculo no existe!");
                    request.getRequestDispatcher("consultar_propuesta.jsp").forward(request, response);
                }
                break;*/
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
