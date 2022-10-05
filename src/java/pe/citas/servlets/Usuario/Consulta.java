/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.citas.servlets.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.citas.BD.Interfaces.Clase;
import pe.citas.BD.Interfaces.InterfaceUsuario;
import pe.citas.BD.Mysql.MysqlUsuario;
import pe.citas.modelo.vo.Usuario;

/**
 *
 * @author casa
 */
@WebServlet(name = "Consulta", urlPatterns = {"/Consulta"})
public class Consulta extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Consulta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Consulta at " + request.getContextPath() + "</h1>");
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
        HttpSession session=request.getSession();
        InterfaceUsuario DAO_Usuario=null;
        
        DAO_Usuario=new MysqlUsuario();
        
        String DNI=request.getParameter("paciente");
        
        
        Usuario usuObj=DAO_Usuario.valiUsuario(DNI);
        
        ArrayList<Usuario> listaUsuario=DAO_Usuario.listar();
        
        if (usuObj!=null && usuObj.getPerfil_usuario_id()==2) {
            
            session.setAttribute("Usuario", usuObj);
            session.setAttribute("Sesion", true);
            
            response.sendRedirect("Citas-Usu/especialidad.jsp");
        }else{
            if (usuObj!=null && usuObj.getPerfil_usuario_id()==1) {
                session.setAttribute("Usuario",usuObj);
                session.setAttribute("listaUsuarios", listaUsuario);
                session.setAttribute("Sesion", true);
                
                response.sendRedirect("Citas-Usu/especialidad.jsp");
            }else{
                response.sendRedirect(Clase.registro+"?mensaje1=El DNI ingresado no se encuentra registrado en la base de datos. Por favor llene el siguiente formulario.");
            }
        }
        
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
