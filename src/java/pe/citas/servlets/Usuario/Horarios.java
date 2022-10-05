/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.citas.servlets.Usuario;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.citas.BD.Interfaces.InterfaceHorario;
import pe.citas.BD.Mysql.MysqlHorario;
import pe.citas.modelo.vo.Especialidad;
import pe.citas.modelo.vo.Horario;
import pe.citas.modelo.vo.Medico;

@WebServlet(name = "Horarios", urlPatterns = {"/Horarios"})
public class Horarios extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        String accion=request.getParameter("accion");
        if (accion.equals("consultar")) {
            this.consultar(request,response);
        }else if (accion.equals("insertar")) {
            this.insertar(request,response);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Horarios.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException ex) {
            Logger.getLogger(Horarios.class.getName()).log(Level.SEVERE, null, ex);
            
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

    private void consultar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion=request.getSession();
        
        InterfaceHorario DaoHorario=null;
        Medico medico=new Medico();
        Especialidad espec=new Especialidad();
        

     ArrayList<Medico> listamedico=(ArrayList<Medico>)sesion.getAttribute("listaMedicos");
     ArrayList<Especialidad> listaespec=(ArrayList<Especialidad>)sesion.getAttribute("listaEspecialidad");
    
    try{
     
    }catch(Exception e){
        
    }
        int idmedico=Integer.parseInt(request.getParameter("lista2"));
        int idespec=Integer.parseInt(request.getParameter("especialidad"));
        
        for (Medico objmedico : listamedico) {
             if (objmedico.getId()==idmedico) {
                medico=objmedico;
                //break;
            }
        }
        
        for (Especialidad objespe: listaespec){
            if(objespe.getIdespecialidad()==idespec){
                espec=objespe;
                break;
            }
        }
      
        DaoHorario=new MysqlHorario();
        
        ArrayList<Horario> listaHorario=DaoHorario.valiHorario(idmedico);
        
        sesion.setAttribute("listaHorario", listaHorario);
        
        sesion.setAttribute("Sesion", true);
        
        sesion.setAttribute("medico", medico);
        
        sesion.setAttribute("espec", espec);
        
        response.sendRedirect("Horario.jsp");
        
        
    }

    private void insertar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
         HttpSession sesion=request.getSession();         
         
         InterfaceHorario DaoHorario=null;
         
         DaoHorario=new MysqlHorario();

        String dia=request.getParameter("txtfecha");
        
        String hora=request.getParameter("timepicker");   
        
        //actualizando codigo//
        
        
        
        int id_medico=Integer.parseInt(request.getParameter("lista2"));
       
//        Horario horario=new Horario();
//        
//        ArrayList<Horario> listaHorario=(ArrayList<Horario>)sesion.getAttribute("listaHorario");
        
        
        Horario horarios=new Horario();
        
        
        horarios.setDia(dia);
        
        horarios.setHora(hora);
        
        horarios.setIdMedico(id_medico);


        try {
                int valor =DaoHorario.insertar(horarios);;
                if(valor>=1){
                    request.setAttribute("mensaje", "<p style='color:green;font-size:18px'>El horario se registro con exito</p>");
                request.getRequestDispatcher("RegCita.jsp").forward(request, response);
                }else{
                    request.setAttribute("mensaje", "<p style='color:red;font-size:18px'>No se pudo registrar el horario</p>");
                    request.getRequestDispatcher("RegCita.jsp").forward(request, response);
                }

            } catch (Exception ex) {
                System.out.println("Error:"+ex.getMessage());
            }
        
    }

}
