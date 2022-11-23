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
import pe.citas.BD.Interfaces.InterfaceEspecialidad;
import pe.citas.BD.Mysql.MysqlEspecialidad;
import pe.citas.modelo.vo.Especialidad;

/**
 *
 * @author JUAN
 */
@WebServlet(name = "Especialidad", urlPatterns = {"/Especialidad"})
public class EspecialidadS extends HttpServlet {

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
            String accion=request.getParameter("accion");
            if (accion.equals("Modificar")) {
            this.Modificar(request, response);
            }else if(accion.equals("eliminar")){
                this.Eliminar(request, response);
            }else if(accion.equals("listar")){
                this.listar(request,response);
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

    private void Modificar(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
        Especialidad e=new Especialidad();
        
        e.setIdespecialidad(Integer.parseInt(request.getParameter("txtCodigo")));
        String especialidad=new String (request.getParameter("nomespec").getBytes("ISO-8859-1"),"UTF-8");
        e.setNomEspecialidad(especialidad);
                        
                InterfaceEspecialidad
                DaoEspecialidad=new MysqlEspecialidad();
                int idespecialidad=Integer.parseInt(request.getParameter("txtCodigo"));

                boolean rpta=DaoEspecialidad.actualizarEspecialidad(e);

                if (rpta==true) {
                    try {
                        
                            request.setAttribute("men", "<p style='color:green;font-size:18px'>La especialidad medica se actualizo con exito</p>");
                            request.setAttribute("id_espec", idespecialidad);
                            request.setAttribute("estado_modificar", "true");
                            request.getRequestDispatcher("Citas-Adm/ModificarEspecialidad.jsp").forward(request, response);
                    } catch (IOException ex) {
                        response.sendRedirect("mensaje.jsp?men=No se actualizo la historia");
                    }
                }else{
                    request.setAttribute("men", "<p style='color:red;font-size:18px'>No se pudo actualizar la especialidad medica</p>");
                            request.getRequestDispatcher("Citas-Adm/ModificarEspecialidad.jsp").forward(request, response);
                }
    }

    private void Eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException {
                    HttpSession sesion=request.getSession();
                    
                    //int idEspecialidad=Integer.parseInt(request.getParameter("idespec"));
                    
                    if(request.getParameter("idespec")!=null){
                        int idEspecialidad=Integer.parseInt(request.getParameter("idespec"));

                        try {
                            InterfaceEspecialidad DaoEspecialidad=new MysqlEspecialidad();
                            DaoEspecialidad.eliminar2(idEspecialidad);
                            ArrayList<Especialidad> listaespec = DaoEspecialidad.listar();
                            sesion.setAttribute("listaEspecialidad", listaespec);
                            response.sendRedirect("Citas-Adm/listarEspecialidad.jsp");         


                        } catch (Exception e) {
                             System.out.println("Error:"+e.getMessage());
                        }

                        
                        
                    }

    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws IOException {
                    InterfaceEspecialidad DaoEspecialidad=new MysqlEspecialidad();
                                    HttpSession sesion=request.getSession();

                    
                    ArrayList listaespec = DaoEspecialidad.listar();
                    
                    String delete=request.getParameter("delete");
                   
                    if(delete!=null){
                        request.setAttribute("mensaje","<p style='color:red;font-size:18px'>"+delete+"</p>");     
                    }
                    
                    sesion.setAttribute("listaEspecialidad", listaespec);
                    response.sendRedirect("Citas-Adm/listarEspecialidad.jsp");    
    }

}
