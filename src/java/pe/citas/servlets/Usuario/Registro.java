/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.citas.servlets.Usuario;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.citas.BD.Interfaces.InterfaceEspecialidad;
import pe.citas.BD.Interfaces.InterfaceUsuario;
import pe.citas.BD.Mysql.MysqlEspecialidad;
import pe.citas.BD.Mysql.MysqlUsuario;
import pe.citas.modelo.vo.Especialidad;
import pe.citas.modelo.vo.Usuario;

/**
 *
 * @author casa
 */
@WebServlet(name = "Registro", urlPatterns = {"/Registro"})
public class Registro extends HttpServlet {

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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/");                
                dispatcher.forward(request, response);
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
                String accion = request.getParameter("accion");
                


                if (accion == null){
                        accion="";
                }
                
                if(accion.equalsIgnoreCase("registrarespec") ){
                    this.insertarEspec(request,response);
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
        response.setCharacterEncoding("UTF-8");
                request.setCharacterEncoding("UTF-8");
                
                String mensaje = "";
                String accion = request.getParameter("accion");

                if (accion == null){
                        accion="";
                    }

                if(accion.equalsIgnoreCase("registrar") ){

                    InterfaceUsuario DAO_usuario=new MysqlUsuario();


                    Usuario usuario= new Usuario();

                    usuario.setDNI(request.getParameter("DNI"));
                    usuario.setNombre(request.getParameter("nombre"));
                    usuario.setApellidopat(request.getParameter("apellidopat"));
                    usuario.setApellidomat(request.getParameter("apellidomat"));
                    usuario.setEmail(request.getParameter("email"));
                    usuario.setClave(request.getParameter("password"));
                    usuario.setTelefono(request.getParameter("telefono"));
                    usuario.setDireccion(request.getParameter("direccion"));
                    usuario.setPerfil_usuario_id(Integer.parseInt(request.getParameter("id")));
                    
                   


                    try {
                        int valor =DAO_usuario.insertar(usuario);
                        if(valor>=1){
                            request.setAttribute("mensaje", "<p style='color:green;font-size:18px'>Su usuario se registro con exito</p>");
                        request.getRequestDispatcher("Registro.jsp").forward(request, response);
                        }else{
                            request.setAttribute("mensaje", "<p style='color:red;font-size:18px'>No se pudo registrar su usuario</p>");
                            request.getRequestDispatcher("Registro.jsp").forward(request, response);
                        }

                    } catch (Exception ex) {
                        System.out.println("Error:"+ex.getMessage());
                    }
                
//                    request.setAttribute("mensaje1", mensaje);            
//                    RequestDispatcher dispatcher = request.getRequestDispatcher("/");                
//                    dispatcher.forward(request, response);

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

    private void insertarEspec(HttpServletRequest request, HttpServletResponse response) {
                    InterfaceEspecialidad DAO_especialidad=new MysqlEspecialidad();


                    Especialidad espec= new Especialidad();

                    espec.setNomEspecialidad(request.getParameter("nombreespec"));

                    try {
                        int valor =DAO_especialidad.insertar(espec);
                        if(valor>=1){
                            request.setAttribute("mensaje", "<p style='color:green;font-size:18px'>La especialidad se registro con exito</p>");
                        request.getRequestDispatcher("Citas-Adm/RegEspecialidad.jsp").forward(request, response);
                        }else{
                            request.setAttribute("mensaje", "<p style='color:red;font-size:18px'>No se pudo registrar la especialidad</p>");
                            request.getRequestDispatcher("Citas-Adm/RegEspecialidad.jsp").forward(request, response);
                        }

                    } catch (Exception ex) {
                        System.out.println("Error:"+ex.getMessage());
                    }
    }

}
