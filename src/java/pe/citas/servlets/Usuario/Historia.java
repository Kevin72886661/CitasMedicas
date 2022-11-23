/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.citas.servlets.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.citas.BD.Interfaces.InterfaceHistoria;
import pe.citas.BD.Interfaces.InterfaceUsuario;
import pe.citas.BD.Mysql.MysqlHistoria;
import pe.citas.BD.Mysql.MysqlUsuario;
import pe.citas.modelo.vo.HistoriaC;
import pe.citas.modelo.vo.Medico;
import pe.citas.modelo.vo.Usuario;

/**
 *
 * @author juan
 */
@WebServlet(name = "Historia", urlPatterns = {"/Historia"})
public class Historia extends HttpServlet {

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
        if (accion.equals("insertar")) {
            this.insertar(request,response);
        }if (accion.equals("listar")) {
            this.listar(request,response);
        }
        if (accion.equals("listarAdm")) {
            this.listarAdm(request, response);
        }
        if (accion.equals("detalles")) {
            this.detalles(request, response);
        } 
        if (accion.equals("Modificar")) {
            this.Modificar(request, response);
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

    private void insertar(HttpServletRequest request, HttpServletResponse response) {
                    InterfaceHistoria DAO_historia=new MysqlHistoria();

                    HttpSession sesion=request.getSession();
                    HistoriaC historia= new HistoriaC();

                    historia.setAntecedentes(request.getParameter("antecedentes"));
                    historia.setMotivo(request.getParameter("motivo"));
                    historia.setEnfermedad(request.getParameter("enfermedad"));
                    historia.setExamenes(request.getParameter("examenes"));
                    historia.setIdpaciente(Integer.parseInt(request.getParameter("idpaciente")));
                   
                      
                    try {
                        int valor =DAO_historia.insertar(historia);
                        if(valor>=1){
                            request.setAttribute("mensaje", "<p style='color:green;font-size:18px'>La historia se registro con exito</p>");
                        request.getRequestDispatcher("AgrHistoria.jsp").forward(request, response);
                        }else{
                            request.setAttribute("mensaje", "<p style='color:red;font-size:18px'>No se pudo registrar la historia</p>");
                            request.getRequestDispatcher("AgrHistoria.jsp").forward(request, response);
                        }

                    } catch (Exception ex) {
                        System.out.println("Error:"+ex.getMessage());
                    }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        InterfaceHistoria DaoHistoria=new MysqlHistoria();
        HttpSession sesion=request.getSession();
      
        int idusuario=((Usuario)sesion.getAttribute("Usuario")).getId();
        
        ArrayList<HistoriaC> listahistoria=DaoHistoria.valiHistoria(idusuario);
        
        sesion.setAttribute("listahistoria", listahistoria);

        response.sendRedirect("Citas-Usu/historia.jsp");
    }
    
    private void listarAdm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        InterfaceHistoria DaoHistoria=new MysqlHistoria();
        InterfaceUsuario DaoUsuario=new MysqlUsuario();
        HttpSession sesion=request.getSession();
              
        ArrayList<HistoriaC> listahistoria=DaoHistoria.listar();
        ArrayList<Usuario> listaUsuario=DaoUsuario.listar();
        
        for (HistoriaC objhistoria : listahistoria) {
           int id=objhistoria.getIdpaciente();
             for (Usuario objUsuario : listaUsuario) {
                                     
                        if (objUsuario.getId()==id) {
                        objhistoria.setPaciente(objUsuario); 
                        break;
                        }
                }
                
           }
        
        
        sesion.setAttribute("listahistoria", listahistoria);

        response.sendRedirect("Citas-Adm/listarHistorias.jsp");
    }

    private void detalles(HttpServletRequest request, HttpServletResponse response) throws IOException {
                HttpSession sesion=request.getSession();

                HistoriaC m=new HistoriaC(Integer.parseInt(request.getParameter("idHistoria")),
                        Integer.parseInt(request.getParameter("idpaciente")),
                     request.getParameter("antecedentes"),       
                request.getParameter("Motivo"),
                request.getParameter("enfermedad"),
                            request.getParameter("examenes"),
                            Date.valueOf(request.getParameter("FechCreHist")));

                InterfaceHistoria
                DaoHistoria=new MysqlHistoria();
        
                HistoriaC historia=DaoHistoria.obtenerporId(Integer.parseInt(request.getParameter("id"))); 

                sesion.setAttribute("historia", historia);

                response.sendRedirect("../DetHistoria.jsp");
    }

    private void Modificar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
                HistoriaC h=new HistoriaC(Integer.parseInt(request.getParameter("txtCodigo")),
                         request.getParameter("antecedentes"),
                     request.getParameter("motivo"),       
                request.getParameter("enfermedad"),
                request.getParameter("examenes")
                    );

                InterfaceHistoria
                DaoHistoria=new MysqlHistoria();
                int idhistoria=Integer.parseInt(request.getParameter("txtCodigo"));

                boolean rpta=DaoHistoria.actualizarHistoria(h);

                if (rpta==true) {
                    try {
                        
                            request.setAttribute("men", "<p style='color:green;font-size:18px'>La historia medica se registro con exito</p>");
                            request.setAttribute("id_hist", idhistoria);
                            request.setAttribute("estado_modificar", "true");
                            request.getRequestDispatcher("Citas-Adm/ModificarHistoria.jsp").forward(request, response);
                    } catch (IOException ex) {
                        response.sendRedirect("mensaje.jsp?men=No se actualizo la historia");
                    }
                }else{
                    request.setAttribute("men", "<p style='color:red;font-size:18px'>No se pudo actualizar la historia medica</p>");
                            request.getRequestDispatcher("Citas-Adm/ModificarHistoria.jsp").forward(request, response);
                }
    }

}
