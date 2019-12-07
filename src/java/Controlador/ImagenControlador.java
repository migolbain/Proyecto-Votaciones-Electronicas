/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modeloDAO.CandidatoDAO;
import modeloVO.CandidatoVO;

/**
 *
 * @author migol
 */
@WebServlet(name = "ImagenControlador", urlPatterns = {"/Imagen"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 15 // 15 MB
)
public class ImagenControlador extends HttpServlet {

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

        String id_candidato = request.getParameter("textid_candidato");
        String nombres_candidato = request.getParameter("textnombres");
        String primerapellido_candidato = request.getParameter("textprimerap");
        String segundoapellido_candidato = request.getParameter("textsegundoap");
        String tipoid_candidato = request.getParameter("texttipoid");
        String documento_candidato = request.getParameter("textdocumento_candidato");
        String genero_candidato = request.getParameter("textgenero");
        String estado_candidato = request.getParameter("textestado");
        String correo_candidato = request.getParameter("textcorreo");
        String id_jornada = request.getParameter("textjornada");

        String usuId = request.getParameter("textusuid");
        String usuLogin = request.getParameter("textusulogin");
        String usuPassword = request.getParameter("textusupassword");
        String usuRol = request.getParameter("textusurol");

        String estado_formacion = request.getParameter("textestado_formacion");
        String estado_voto = request.getParameter("textestado_voto");

        String id_usuario = request.getParameter("textidusuario");

        String no_propuesta = request.getParameter("textno_propuesta");
        String propuesta = request.getParameter("textpropuesta");
        String id_propuesta = request.getParameter("textidpropuesta");
        String videourl = request.getParameter("textvideourl");

        String jornada = request.getParameter("textjornada");
        String rol = request.getParameter("textrol");
        String cargo = request.getParameter("textcargo");
        
        Blob foto1 = null;

        
        
        Part part = request.getPart("filefoto");
        InputStream foto = part.getInputStream();
        String opcion = request.getParameter("opcion");

        CandidatoVO candVO = new CandidatoVO(usuId, usuLogin, usuPassword, usuRol, id_candidato, tipoid_candidato, documento_candidato, nombres_candidato, primerapellido_candidato, segundoapellido_candidato, genero_candidato, correo_candidato, estado_formacion, estado_voto, estado_candidato, id_usuario, id_jornada, jornada, rol, cargo, no_propuesta, id_propuesta, id_propuesta, videourl, foto);
        CandidatoDAO candDAO = new CandidatoDAO(candVO);
        
        
       
        
        switch (opcion) {
            case "Subir": 
                if (candDAO.actualizarimagen()) {

                    request.setAttribute("mensajeExito", "¡El usuario ha sido registrado correctamente!");

                } else {
                    request.setAttribute("mensajeError", "¡El usuario NO pudo ser registrado correctamente!");
                }

                request.getRequestDispatcher("GestionCandidato.jsp").forward(request, response);
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
