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
import pe.citas.BD.Interfaces.InterfaceMedico;
import pe.citas.BD.Interfaces.InterfacePrescripcion;
import pe.citas.BD.Interfaces.InterfaceUsuario;
import pe.citas.BD.Mysql.MysqlMedico;
import pe.citas.BD.Mysql.MysqlPrescripcion;
import pe.citas.BD.Mysql.MysqlUsuario;
import pe.citas.modelo.vo.Medico;
import pe.citas.modelo.vo.Prescripcion_C;
import pe.citas.modelo.vo.Usuario;

/**
 *
 * @author juan
 */
@WebServlet(name = "Prescripcion", urlPatterns = {"/Prescripcion"})
public class Prescripcion extends HttpServlet {

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
        String accion=request.getParameter("accion");
        if (accion.equals("insertar")) {
            this.insertar(request,response);
        }if(accion.equals("listar")){
            this.listar(request,response);
        }if (accion.equals("listarAdm")) {
            this.listarAdm(request,response);
        }if (accion.equals("Modificar")) {
                this.Modificar(request,response);
        }if (accion.equals("pageModificar")) {
                this.PageModificar(request,response);
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
                    InterfacePrescripcion DAO_prescripcion=new MysqlPrescripcion();


                    Prescripcion_C p= new Prescripcion_C();

                    p.setIdUsuario(Integer.parseInt(request.getParameter("idpaciente")));
                    p.setIdMedico(Integer.parseInt(request.getParameter("medico")));
                    p.setReceta(request.getParameter("receta"));
                    p.setRecomendacion(request.getParameter("recomendaciones"));
                    p.setFecha(request.getParameter("txtfecha"));

                    try {
                        int valor =DAO_prescripcion.insertar(p);
                        if(valor>=1){
                            request.setAttribute("mensaje", "<p style='color:green;font-size:18px'>La prescripcion medica se registro con exito</p>");
                        request.getRequestDispatcher("Citas-Adm/AgrPrescripcion.jsp").forward(request, response);
                        }else{
                            request.setAttribute("mensaje", "<p style='color:red;font-size:18px'>No se pudo registrar la prescripcion medica</p>");
                            request.getRequestDispatcher("Citas-Adm/AgrPrescripcion.jsp").forward(request, response);
                        }

                    } catch (Exception ex) {
                        System.out.println("Error:"+ex.getMessage());
                    }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws IOException {
         InterfacePrescripcion DaoPrescripcion=new MysqlPrescripcion();
        HttpSession sesion=request.getSession();
      
        int idusuario=((Usuario)sesion.getAttribute("Usuario")).getId(); 
           
        ArrayList<Prescripcion_C> listaprescripcion=DaoPrescripcion.valiPrescripcion(idusuario);
        
        sesion.setAttribute("listaPrescripcion", listaprescripcion);

        response.sendRedirect("Citas-Usu/listaPrescripcion.jsp");
    }

    private void listarAdm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        InterfacePrescripcion DaoPrescripcion=new MysqlPrescripcion();
        InterfaceUsuario DaoUsuario=new MysqlUsuario();
        InterfaceMedico DaoMedico=new MysqlMedico();
        HttpSession sesion=request.getSession();
              
        ArrayList<Prescripcion_C> listapresc=DaoPrescripcion.listar();
        ArrayList<Usuario> listaUsuario=DaoUsuario.listar();
        ArrayList<Medico> listaMedico=DaoMedico.listar();
        
        for (Prescripcion_C objprescripcion : listapresc) {
           int id=objprescripcion.getIdUsuario();
             for (Usuario objUsuario : listaUsuario) {
                        for (Medico objMedico : listaMedico) {
                            int idmed=objprescripcion.getIdMedico();
                            if (objUsuario.getId()==id) {
                            objprescripcion.setPaciente(objUsuario); 
                            break;
                            }
                            if (objMedico.getId()==idmed) {
                            objprescripcion.setMedico(objMedico); 
                            break;
                            }
                        }              
                        
                }
                
           }
        
        
        sesion.setAttribute("listapresc", listapresc);

        response.sendRedirect("Citas-Adm/listarPrescripcion.jsp");
    }

    private void Modificar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        Prescripcion_C p=new Prescripcion_C(Integer.parseInt(request.getParameter("txtCodigo")),
                         request.getParameter("receta"),
                     request.getParameter("recomendacion"),       
                request.getParameter("fecha")
                    );

                InterfacePrescripcion
                DaoPrescripcion=new MysqlPrescripcion();
        int idprescripcion=Integer.parseInt(request.getParameter("txtCodigo"));
                boolean rpta=DaoPrescripcion.actualizarPrescr(p);

//                if (rpta==true) {
//                    try {
//                        response.sendRedirect("mensaje.jsp?men=Se actualizo la prescripcion de manera correcta");
//                    } catch (IOException ex) {
//                    response.sendRedirect("mensaje.jsp?men=No se actualizo la prescripcion");
//                    }
//                }
                
                        if(rpta){
                            request.setAttribute("men", "<p style='color:green;font-size:18px'>La prescripcion medica se actualizo con exito</p>");
                            request.setAttribute("id_presc", idprescripcion);
                            request.setAttribute("estado_modificar", "true");
                            request.getRequestDispatcher("ModificarPrescripcion.jsp").forward(request, response);
                        }else{
                            request.setAttribute("men", "<p style='color:red;font-size:18px'>No se pudo actualizar la prescripcion medica</p>");
                            request.getRequestDispatcher("ModificarPrescripcion.jsp").forward(request, response);
                        }  
                
                      
    }

    private void PageModificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InterfacePrescripcion DaoPrescripcion=new MysqlPrescripcion();
        Prescripcion_C pr=null;
        String valor=request.getParameter("update");
        pr=DaoPrescripcion.obtenerporId(Integer.parseInt(request.getParameter("id")));

        
            request.setAttribute("presc", pr);
            request.getRequestDispatcher("ModificarPrescripcion.jsp").forward(request, response);

        

        
    }
    

}
