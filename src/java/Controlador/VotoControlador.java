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
import modeloDAO.VotoDAO;
import modeloVO.VotoVO;

/**
 *
 * @author migol
 */
@WebServlet(name = "VotoControlador", urlPatterns = {"/Voto"})
public class VotoControlador extends HttpServlet {

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

        String usuId = request.getParameter("");
        String usuLogin = request.getParameter("textusulogin");
        String usuPassword = request.getParameter("textusupassword");
        String usuRol = request.getParameter("textusurol");

        String id_voto = request.getParameter("textidvoto");
        String no_voto = request.getParameter("textno_voto");
        String fecha_voto = request.getParameter("textfecha");
        String id_persona = request.getParameter("textidpersona");

        String estado_formacion = request.getParameter("textestado_formacion");
        String estado_voto = request.getParameter("textestado_voto");

        String id_usuario = request.getParameter("textidusuario");

        String no_propuesta = request.getParameter("textno_propuesta");
        String propuesta = request.getParameter("textpropuesta");
        String jornada = request.getParameter("textjornada");
        String rol = request.getParameter("textrol");
        String cargo = request.getParameter("textcargo");

        String id_personavoto = request.getParameter("textidpersonavoto");
        
        String ID_JornadaVotaciones = request.getParameter("textjornadavotaciones");
        String Fecha_Jornada = request.getParameter("");
        String Estado_JornadaVotacion = request.getParameter("");
        

        VotoVO votoVO = new VotoVO(id_voto, no_voto, fecha_voto, id_persona, usuId, usuLogin, usuPassword, usuRol, id_candidato, tipoid_candidato, documento_candidato, nombres_candidato, primerapellido_candidato, segundoapellido_candidato, genero_candidato, correo_candidato, estado_formacion, estado_voto, estado_candidato, id_usuario, id_jornada, jornada, rol, cargo, id_personavoto, no_propuesta, propuesta, ID_JornadaVotaciones, Fecha_Jornada, Estado_JornadaVotacion);
        VotoDAO votoDAO = new VotoDAO(votoVO);

        switch (opcion) {
            case 1: //Agregar Registro
                if (votoDAO.agregarRegistro()) {
                    request.getRequestDispatcher("CerrarSesionVoto").forward(request, response);
                    request.setAttribute("mensajeExito", "<script>alert('¡Gracias por su voto!')</script>");
                      

                } else {
                    request.setAttribute("mensajeError", "¡El usuario NO pudo ser registrado correctamente!");
                }

             
                break;
            case 2: //Consultar por Numero de Tarjeta
                ArrayList<VotoVO> conteovotoVO = votoDAO.Conteovotos(fecha_voto);
                if (conteovotoVO != null) {
                    request.setAttribute("voLleno", conteovotoVO);
                    request.getRequestDispatcher("ConteoVotosReportes.jsp").forward(request, response);

                } else {
                    request.setAttribute("mensajeError", "<script>alert('No se pudo realizar el conteo de votos')</script>");
                    request.getRequestDispatcher("ConteoVotos.jsp").forward(request, response);

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
