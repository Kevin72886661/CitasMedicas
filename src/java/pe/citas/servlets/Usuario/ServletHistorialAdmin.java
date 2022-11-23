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
import pe.citas.BD.Interfaces.InterfaceCita;
import pe.citas.BD.Interfaces.InterfaceEspecialidad;
import pe.citas.BD.Mysql.MysqlCita;
import pe.citas.BD.Mysql.MysqlEspecialidad;
import pe.citas.modelo.vo.Cita;
import pe.citas.modelo.vo.Especialidad;

/**
 *
 * @author JUAN
 */
@WebServlet(name = "ServletHistorialAdmin", urlPatterns = {"/ServletHistorialAdmin"})
public class ServletHistorialAdmin extends HttpServlet {

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
                String accion = request.getParameter("accion");
                
                if (accion == null){
                        accion="";
                }
                
                if(accion.equalsIgnoreCase("listarcitas") ){
                    this.listarCitas(request,response);
                }else if(accion.equalsIgnoreCase("listarespec")){
                    this.listarEspec(request,response);
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

    private void listarEspec(HttpServletRequest request, HttpServletResponse response) throws IOException {
         InterfaceEspecialidad DaoEspecialidad=new MysqlEspecialidad();
        HttpSession sesion=request.getSession();
      
        //int idmedico=((Medico)sesion.getAttribute("Medico")).getId();
         
        ArrayList<Especialidad> listaEspecialidad=DaoEspecialidad.listar();
        
        sesion.setAttribute("listaEspecialidad", listaEspecialidad);

        response.sendRedirect("Citas-Adm/listarEspecialidad.jsp");
    }

    private void listarCitas(HttpServletRequest request, HttpServletResponse response) throws IOException {
        InterfaceCita DaoCita=new MysqlCita();
        HttpSession sesion=request.getSession();
      
        //int idmedico=((Medico)sesion.getAttribute("Medico")).getId();
         
        ArrayList<Cita> listaCita=DaoCita.listar();
        
        sesion.setAttribute("listaPacientes", listaCita);

                    response.sendRedirect("Citas-Adm/listarPacientes.jsp");
    }

}
