/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.citas.servlets.Usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.citas.BD.Interfaces.InterfaceCita;
import pe.citas.BD.Interfaces.InterfaceHorario;
import pe.citas.BD.Mysql.MysqlCita;
import pe.citas.modelo.vo.Cita;
import pe.citas.modelo.vo.Especialidad;
import pe.citas.modelo.vo.Horario;
import pe.citas.modelo.vo.Medico;
import pe.citas.modelo.vo.Usuario;


/**
 *
 * @author casa
 */
@WebServlet(name = "Cita", urlPatterns = {"/Cita"})
public class SCita extends HttpServlet {

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
                
                if(accion.equalsIgnoreCase("insertar") ){
                    this.insertar(request,response);
                }
                
                else if(accion.equalsIgnoreCase("listar") ){
                    
                    this.listar(request,response);
                    
                }
                
                else if (accion.equalsIgnoreCase("eliminar")) {
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

    private void insertar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion=request.getSession();
         
         InterfaceHorario DaoHorario=null;
         
         
         InterfaceCita DaoCita=null;
         
         DaoCita=new MysqlCita();

        int id_horario=Integer.parseInt(request.getParameter("id_horario"));
        
        //actualizando codigo//
        
        int id_usuario=Integer.parseInt(request.getParameter("id_usuario"));
        int id_medico=Integer.parseInt(request.getParameter("id_medico"));
        int id_especialidad=Integer.parseInt(request.getParameter("id_especialidad"));
       
        Horario horario=new Horario();
        
        ArrayList<Horario> listaHorario=(ArrayList<Horario>)sesion.getAttribute("listaHorario");
        
        ArrayList<Cita> listaCitas=(ArrayList<Cita>)sesion.getAttribute("listacitas");
        
        
        for (Horario horario1 : listaHorario) {
             if (horario1.getIdHorario()==id_horario) {
                 horario.setDia(horario1.getDia());
                horario.setHora(horario1.getHora());
                break;
            }
        }
        
        Cita cita=new Cita();
        
        cita.setIdMedico(id_medico);
        
        cita.setIdEspecialidad(id_especialidad);
        
        cita.setIdUsuario(id_usuario);
        
        cita.setDia(horario.getDia());
        
        cita.setHora(horario.getHora());

        try {
            int valor=DaoCita.insertar(cita);
            if(valor>=1){
                response.sendRedirect("../ServletHistorial?men=La cita se registro con exito");

            }else{
                request.setAttribute("mensaje", "<p style='color:red;font-size:18px'>No se pudo registrar la cita</p>");
                response.sendRedirect("../ServletHistorial");

            }
        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
        }
        
        
        
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
         
                    HttpSession sesion=request.getSession();
                    
                    int idCita=Integer.parseInt(request.getParameter("idcita"));

                    InterfaceCita DaoCita=new MysqlCita();

                    DaoCita.eliminar(idCita);
                    
                    ArrayList<Cita> listacita = DaoCita.listar();
                    
                    sesion.setAttribute("listaPacientes", listacita);

                    response.sendRedirect("../ServletHistorial?delete=La cita se elimino con exito");              
                
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion=request.getSession();
        InterfaceCita DaoCita=new MysqlCita();
                    
                    ArrayList<Cita> listacita = DaoCita.listar();
                    
                    ArrayList<Medico> listamedico=(ArrayList<Medico>)sesion.getAttribute("listaMedicos");;    
                    ArrayList<Especialidad> listaespec=(ArrayList<Especialidad>)sesion.getAttribute("listaEspecialidad"); 
                    ArrayList<Usuario> listausu=(ArrayList<Usuario>)sesion.getAttribute("listaUsuarios"); 
                    
                    int id;
//                    for (Cita objcita : listacita) {
//                        id=objcita.getIdMedico();
//                        int idusuario=objcita.getIdUsuario();
//                       
//                         for (Medico objmedico : listamedico) {
//                            for (Especialidad especialidad : listaespec) { 
//                             int idespeci=especialidad.getIdespecialidad();
//
//                                for (Usuario usuario : listausu) {
//                                    if (objmedico.getId()==id ) {
//                                    objcita.setMedico(objmedico);
//                                    break;
//                                    
//                                    }
//                                    if (usuario.getId()==idusuario) {
//                                    objcita.setUsuario(usuario); 
//                                    break;
//                                    }
//                                    if (objmedico.getPerfil_especialidad()==idespeci) {
//                                        objcita.setEspecialidad(especialidad);
//                                        break;
//                                    }
////                                    if (especialidad.getIdespecialidad()==idespeci) {
////                                    objcita.setEspecialidad(especialidad); 
////                                    break;
////                                    }
//                                }
//                                
//                            }
//                       }
//                    }
                    
                    sesion.setAttribute("listaPacientes", listacita);

                    response.sendRedirect("Citas-Adm/listarPacientes.jsp");
    }

}
