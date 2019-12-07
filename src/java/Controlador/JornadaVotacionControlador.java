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
import modeloDAO.JornadaVotacionDAO;
import modeloVO.JornadaVotacionVO;

/**
 *
 * @author migol
 */
@WebServlet(name = "JornadaVotacionControlador", urlPatterns = {"/JornadaVotacion"})
public class JornadaVotacionControlador extends HttpServlet {

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
        String ID_JornadaVotacion = request.getParameter("idjornada");
        String Fecha_JornadaApertura = request.getParameter("textjornadaapertura");
        String Fecha_JornadaCierre = request.getParameter("textjornadacierre");
        String Estado_JornadaVotacion = request.getParameter("textjornadavotacion");
        String Fecha_Jornada = request.getParameter("textjornada");
        String Estado_Voto = request.getParameter("textestadovoto");
        
        String nombres_persona = request.getParameter("");
        String primerapellido_persona = request.getParameter("");
        String segundoapellido_persona = request.getParameter("");
        String tipoid_persona = request.getParameter("");
        String documento_persona = request.getParameter("");
        String genero_persona = request.getParameter("");
        String correo_persona = request.getParameter("");
        String estado_formacion = request.getParameter("");
        String estado_candidato = request.getParameter("");
        String estado_voto = request.getParameter("");
        String id_jornada = request.getParameter("");
        String id_usuario = request.getParameter("");
        String id_persona = request.getParameter("");
        
        String ID_Detallejornada = request.getParameter("");
        
        JornadaVotacionVO jornadaVotacionVO = new JornadaVotacionVO(ID_JornadaVotacion, Fecha_JornadaApertura, Fecha_JornadaCierre, Estado_JornadaVotacion, Fecha_Jornada, Estado_Voto,id_persona, tipoid_persona, documento_persona, nombres_persona, primerapellido_persona, segundoapellido_persona, genero_persona, correo_persona, estado_formacion, estado_candidato, id_usuario, id_jornada, ID_Detallejornada);
        JornadaVotacionDAO jornadaVotacionDAO = new  JornadaVotacionDAO(jornadaVotacionVO);
        
        switch (opcion) {
            case 1: //Agregar Registro
                if (jornadaVotacionDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "¡La Jornada ha sido creada exitosamente!");

                } else {
                    request.setAttribute("mensajeError", "¡La Jornada no pudo ser creada!");
                }

                request.getRequestDispatcher("JornadaVotacion.jsp").forward(request, response);
                break;

            case 2: //Actualizar Registro
                if (jornadaVotacionDAO.insertarpersonasdetalle()) {
                    if(jornadaVotacionDAO.actualizarRegistro()){
                    request.setAttribute("mensajeExito", "¡La Jornada ha sido creada exitosamente!");
                    }
                } else {
                    request.setAttribute("mensajeError", "¡La Jornada no pudo ser creada!");
                }
             
                request.getRequestDispatcher("JornadaVotacion.jsp").forward(request, response);
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
