/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pucp.inf.servlets;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Freddy
 */
public class InformacionEstudiante extends HttpServlet {

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
            throws ServletException, IOException, JRException, ClassNotFoundException, SQLException {
        response.setContentType("application/pdf");
        //Referencia a la ruta del reporte Principal
        String rutaReportePrincipal = InformacionEstudiante.class.getResource("/edu/pucp/inf/reportes/reportePrincipal.jasper").getPath();
        //Eliminamos el problema de los espacios en blanco
        rutaReportePrincipal = rutaReportePrincipal.replaceAll("%20"," ");
        JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(rutaReportePrincipal);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://sallka.lab.inf.pucp.edu.pe:3306/inf2820781?autoReconnect=true&useSSL=false", "inf2820781", "Ni6TyI");
        HashMap hm = new HashMap();
        //Enviar la ruta de la "carpeta" donde se encuentra el subreporte
        String rutaSubreporte = InformacionEstudiante.class.getResource("/edu/pucp/inf/reportes/").getPath();
        //Eliminar problema de espacios
        rutaSubreporte = rutaSubreporte.replaceAll("%20", " ");
        hm.put("SUBREPORT_DIR", rutaSubreporte);
        int idStudent = Integer.valueOf(request.getParameter("studentId"));
        hm.put("idStudent",idStudent);
        JasperPrint jp = JasperFillManager.fillReport(reporte,hm,con);
        JasperExportManager.exportReportToPdfStream(jp, response.getOutputStream());
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
        try {
            processRequest(request, response);
        } catch (JRException | ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
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
        try {
            processRequest(request, response);
        } catch (JRException | ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
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
