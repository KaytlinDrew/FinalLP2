package edu.pucp.inf.servlets;

import edu.pucp.inf.dao.DAOStudent;
import edu.pucp.inf.model.Student;
import edu.pucp.inf.mysql.MySQLStudent;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Freddy
 */
public class PaginaInicial extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            DAOStudent daoStudent = new MySQLStudent();
            ArrayList<Student> students = daoStudent.queryAll();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
                out.println("<head>");
                    out.println("<title>Servlet PaginaInicial</title>");
                    out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" />");
                out.println("</head>");
                out.println("<body>");
                    out.println("<div><h1>Formulario para la generacion del reporte</h1></div>");
                    out.println("<div>");
                        out.println("<form action=\"InformacionEstudiante\" method=\"post\">");
                            out.println("<label id=\"lblIdEstudiante\">Seleccione el Estudiante: </label>");
                            out.println("<select name=\"studentId\">");
                                for (Student s : students)
                                    out.println("<option value="+s.getId()+">"+s.getId()+" "+s.getFullName()+"</option>");
                            out.println("</select>");
                            out.println("<input type=\"submit\" value=\"Generar Reporte\"/>");
                        out.println("</form>");
                    out.println("</div>");
                out.println("</body>");
            out.println("</html>");
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
