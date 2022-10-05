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
import pe.citas.BD.Interfaces.InterfaceEspecialidad;
import pe.citas.BD.Interfaces.InterfaceMedico;
import pe.citas.BD.Mysql.MysqlEspecialidad;
import pe.citas.BD.Mysql.MysqlMedico;
import pe.citas.modelo.vo.Medico;

/**
 *
 * @author casa
 */
@WebServlet(name = "Medicos", urlPatterns = {"/Medicos"})
public class Medicos extends HttpServlet {

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
                String mensaje = "";
                String accion = request.getParameter("accion");
                


                if (accion == null){
                        accion="";
                }
                
                if(accion.equalsIgnoreCase("eliminar") ){
                    this.eliminar(request,response);
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
        InterfaceMedico DAO_Medicos=null;
        InterfaceEspecialidad DaoEspecialidad=null;
        
        
        DAO_Medicos=new MysqlMedico();
        
        DaoEspecialidad=new MysqlEspecialidad();
        
        int Especialidad=Integer.parseInt(request.getParameter("especialidad"));
        
        ArrayList<Medico> objMedico=DAO_Medicos.valiMedico2(Especialidad);
                
        //Especialidad objEspecialidad=DaoEspecialidad.valiEspecialidad(Especialidad);
        
       // ArrayList<Especialidad> listEspecialidad=DaoEspecialidad.listar();
        
       // ArrayList<Medico> listMedicos=DAO_Medicos.obtenerporId2(Especialidad);
        
        //Especialidad objEspecialidad=DaoEspecialidad.obtenerporId(Especialidad);
        
            if (objMedico!=null) {
            
            session.setAttribute("listaMedicos", objMedico);
            
           // session.setAttribute("Especialidad", objEspecialidad);
                        
            //session.setAttribute("listaMedicos", listMedicos);
            
            session.setAttribute("Sesion", true);
            
            response.sendRedirect("Medicos.jsp");
            }
           
           else{
                response.sendRedirect(Clase.especialidad+"?mensaje1=No existe");
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

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException {
                    HttpSession sesion=request.getSession();
                    
                    int idMedico=Integer.parseInt(request.getParameter("idmedico"));

                    InterfaceMedico DaoMedico=new MysqlMedico();
                    
                    try {
                        int valor=DaoMedico.eliminar2(idMedico);
                        ArrayList<Medico> listamedico = DaoMedico.listar();
                        sesion.setAttribute("listaMedicos", listamedico);
                        if(valor>=1){
                            response.sendRedirect("../RegMedico?accion=listar&delete=El medico se elimino correctamente");
                        }else{
                         
                            response.sendRedirect("../RegMedico?accion=listar&delete=No se puede eliminar el medico porque tiene una cita asignada");
                        }
                    } catch (Exception e) {
                        System.out.println("Error:"+e.getMessage());
                    }
                    
                    
                    

                    
    }

}
