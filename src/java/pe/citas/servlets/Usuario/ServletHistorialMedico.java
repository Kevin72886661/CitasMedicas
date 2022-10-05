/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.citas.servlets.Usuario;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.citas.BD.Interfaces.InterfaceCita;
import pe.citas.BD.Mysql.MysqlCita;
import pe.citas.modelo.vo.Cita;
import pe.citas.modelo.vo.Especialidad;
import pe.citas.modelo.vo.Medico;
import pe.citas.modelo.vo.Usuario;


@WebServlet(name = "ServletHistorialMedico", urlPatterns = {"/ServletHistorialMedico"})
public class ServletHistorialMedico extends HttpServlet {

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
         InterfaceCita DaoCita=new MysqlCita();;
        HttpSession sesion=request.getSession();
      
        int idmedico=((Medico)sesion.getAttribute("Medico")).getId();
         
        ArrayList<Cita> listaCita=DaoCita.valiCitaMedico(idmedico);
        ArrayList<Medico> listamedico=(ArrayList<Medico>)sesion.getAttribute("listaMedicos"); 
        ArrayList<Usuario> listausuario=(ArrayList<Usuario>)sesion.getAttribute("listaUsuarios"); 
        ArrayList<Especialidad> listaespec=(ArrayList<Especialidad>)sesion.getAttribute("listaEspecialidad");   
        
        int id;
        int idesp;
//        for (Cita objcita : listaCita) {
//            id=objcita.getIdUsuario();
//            idesp=objcita.getIdEspecialidad();
//             for (Usuario objusaurio : listausuario) {
//
////                    int idespe=especialidad.getIdespecialidad();
//                if (objusaurio.getId()==id) {
//                objcita.setUsuario(objusaurio); 
//                
//                break;
//                }
//           }
//        
//            for (Especialidad especialidad : listaespec) {
//                if(especialidad.getIdespecialidad()==idesp){
//                    objcita.setEspecialidad(especialidad); 
//                    break;
//                }
//            }
//        }
   
        sesion.setAttribute("listaSesionMedico", listaCita);

        response.sendRedirect("Citas-Med/listacita.jsp");
        
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
