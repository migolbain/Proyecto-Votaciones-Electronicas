/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
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
@WebServlet(name = "ReporteControlador", urlPatterns = {"/Reporte"})
public class ReporteControlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();

        VotoVO votoVO = new VotoVO();
        VotoDAO votoDAO = new VotoDAO(votoVO);

        try {
            try {

            } catch (Exception e) {
                e.getMessage();
            }

            try {
                Document documento = new Document();
                PdfWriter.getInstance(documento, out);

                documento.open();

                Image imagenes = Image.getInstance("E:\\Proyecto\\Proyecto SENA\\Proyecto - copia\\web\\img\\Recurso 1Logo.png");
                imagenes.setAlignment(Element.ALIGN_CENTER);
                imagenes.scaleToFit(150, 150);
                documento.add(imagenes);

                Paragraph par1 = new Paragraph();
                par1.add(new Phrase(Chunk.NEWLINE));
                Font fonttitulo = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.GREEN);
                par1.add(new Phrase("Reporte de Votos", fonttitulo));
                par1.setAlignment(Element.ALIGN_CENTER);
                par1.add(new Phrase(Chunk.NEWLINE));
                documento.add(par1);

                Paragraph par2 = new Paragraph();
                par2.add(new Phrase(Chunk.NEWLINE));
                Font fontdescripcion = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK);
                par2.add(new Phrase("Estos son los candidatos electos y los ganadores para representar sus jornadas", fontdescripcion));
                par2.setAlignment(Element.ALIGN_JUSTIFIED);
                par2.add(new Phrase(Chunk.NEWLINE));
                par2.add(new Phrase(Chunk.NEWLINE));
                documento.add(par2);

                PdfPTable tabla = new PdfPTable(5);
                PdfPCell celda1 = new PdfPCell(new Paragraph("Documento Candidato", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.GREEN)));
                PdfPCell celda2 = new PdfPCell(new Paragraph("Nombres", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.GREEN)));
                PdfPCell celda3 = new PdfPCell(new Paragraph("Apellidos", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.GREEN)));
                PdfPCell celda4 = new PdfPCell(new Paragraph("Numero de Votos", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.GREEN)));
                PdfPCell celda5 = new PdfPCell(new Paragraph("Jornada", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.GREEN)));


                tabla.addCell(celda1);
                tabla.addCell(celda2);
                tabla.addCell(celda3);
                tabla.addCell(celda4);
                tabla.addCell(celda5);


                String fecha = (request.getParameter("textfecha"));
                ArrayList<VotoVO> conteovotos = votoDAO.Conteovotosreportes(fecha);
                for (int i = 0; i < conteovotos.size(); i++) {
                    votoVO = conteovotos.get(i);
                    tabla.addCell(votoVO.getDocumento_candidato());
                    tabla.addCell(votoVO.getNombres_candidato());
                    tabla.addCell(votoVO.getPrimerapellido_candidato());
                    tabla.addCell(votoVO.getNo_voto());
                    tabla.addCell(votoVO.getJornada());
                }

                documento.add(tabla);

                documento.close();
            } catch (Exception e) {
            }
        } catch (Exception e) {
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
