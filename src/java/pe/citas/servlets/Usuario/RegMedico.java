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
import pe.citas.BD.Interfaces.InterfaceMedico;
import pe.citas.BD.Mysql.MysqlMedico;
import pe.citas.modelo.vo.Medico;
/**
 *
 * @author casa
 */
@WebServlet(name = "RegMedico", urlPatterns = {"/RegMedico"})
public class RegMedico extends HttpServlet {

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
                response.setCharacterEncoding("UTF-8");
                request.setCharacterEncoding("UTF-8");
                
                HttpSession sesion=request.getSession();
                
                String mensaje = "";
                String accion = request.getParameter("accion");
                

                if (accion == null){
                        accion="";
                    }

                if(accion.equalsIgnoreCase("Agregar") ){
                    
                    Medico medico= new Medico();
                
                    medico.setNombre(request.getParameter("NomMedico"));
                    medico.setApellidopat(request.getParameter("apepat"));
                    medico.setApellidomat(request.getParameter("apemat"));
                    medico.setTelefono(request.getParameter("NumeroMed"));
                    medico.setEmail(request.getParameter("EmailMed"));
                    medico.setClave(request.getParameter("Contraseña"));
                    medico.setPerfil_especialidad(Integer.parseInt(request.getParameter("especialidad")));
                    medico.setPerfil_usuario_id(Integer.parseInt(request.getParameter("id")));

                    InterfaceMedico DaoMedico=new MysqlMedico();
                    int valor =DaoMedico.insertar(medico);
                    if(valor>=1){
                        request.setAttribute("mensaje", "<p style='color:green;font-size:18px'>Medico Registrado</p>");
                        request.getRequestDispatcher("AgregarMed.jsp").forward(request, response);
                    } else{
                        request.setAttribute("mensaje", "<p style='color:red;font-size:18px'>Medico No Registrado</p>");
                        request.getRequestDispatcher("AgregarMed.jsp").forward(request, response);
                    }   
                    
                }
                else if (accion.equalsIgnoreCase("listar")) {
                    
                    InterfaceMedico DaoMedico=new MysqlMedico();
                    
                    ArrayList listamed = DaoMedico.listar();
                    
                    String delete=request.getParameter("delete");
                   
                    if(delete!=null){
                        request.setAttribute("mensaje","<p style='color:red;font-size:18px'>"+delete+"</p>");     
                    }
                    
                    sesion.setAttribute("alMedicos", listamed);
                    request.getRequestDispatcher("Citas-Adm/listamedicos.jsp").forward(request, response);
                    //response.sendRedirect("Citas-Adm/listamedicos.jsp");
            
                }else if (accion.equals("ModificarMedico")) {
//                    ArrayList<Medico> listamedico=(ArrayList<Medico>)sesion.getAttribute("listaMedicos"); 
//                            ArrayList<Especialidad> listaespec=(ArrayList<Especialidad>)sesion.getAttribute("listaEspecialidad");   
//
//                    for (Medico objmedico : listamedico) {
//                    int idespe=objmedico.getPerfil_especialidad();
//                    
//                    for (Especialidad especialidad : listaespec) {
//                        
//    //                    int idespe=especialidad.getIdespecialidad();
//                            if (especialidad.getIdespecialidad()==idespe) {
//                            objmedico.setEspecialidad(especialidad); 
//                            break;
//                            }
//
//                        }
//                
//                     }
                    Medico m=new Medico(Integer.parseInt(request.getParameter("txtCodigo")),
                     request.getParameter("txtNombre"),       
                request.getParameter("txtApepat"),
                request.getParameter("txtApemat"),
                            request.getParameter("txtTelefono"),
                            request.getParameter("txtEmail"),
                    Integer.parseInt(request.getParameter("especialidad")));

                InterfaceMedico
                DaoMedico=new MysqlMedico();
        
                boolean rpta=DaoMedico.actualizarMedico(m);

                if (rpta==true) {
                    response.sendRedirect("mensaje.jsp?men=Se actualizo el medico de manera correcta");
                }else{
                    response.sendRedirect("mensaje.jsp?men=No se actualizo el medico");
                }
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
              
//                   try {
//                        int valor =DaoMedico.insertar(medico);
//                        if(valor>=1){
//                            request.setAttribute("mensaje", "<p style='color:green;font-size:18px'>Medico Registrado</p>");
//                            request.getRequestDispatcher("AgregarMed.jsp").forward(request, response);
//                        } else{
//                            request.setAttribute("mensaje", "<p style='color:red;font-size:18px'>Medico No Registrado</p>");
//                        }
//                    } catch (Exception ex) {
//                        System.out.println("Error al registrar al agregar el medico"+ex.getMessage());
//                    }

//                    ArrayList alMedicos = DaoMedico.listar();
//                    request.setAttribute("alMedicos", alMedicos);
//                
//                    RequestDispatcher dispatcher = request.getRequestDispatcher("doctores.jsp");                
//                    dispatcher.forward(request, response);

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
