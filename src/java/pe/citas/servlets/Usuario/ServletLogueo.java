/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.citas.servlets.Usuario;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.citas.BD.Interfaces.InterfaceCita;
import pe.citas.BD.Interfaces.InterfaceEspecialidad;
import pe.citas.BD.Interfaces.InterfaceMedico;
import pe.citas.BD.Interfaces.InterfaceUsuario;
import pe.citas.BD.Mysql.MysqlCita;
import pe.citas.BD.Mysql.MysqlEspecialidad;
import pe.citas.BD.Mysql.MysqlMedico;
import pe.citas.BD.Mysql.MysqlUsuario;
import pe.citas.modelo.vo.Cita;
import pe.citas.modelo.vo.Especialidad;
import pe.citas.modelo.vo.Medico;
import pe.citas.modelo.vo.Usuario;

/**
 *
 * @author juan
 */
@WebServlet(name = "ServletLogueo", urlPatterns = {"/ServletLogueo"})
public class ServletLogueo extends HttpServlet {
     Connection conexion;
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
            
        HttpSession sesion=request.getSession();

        InterfaceUsuario DAO_Usuario=new MysqlUsuario();
        InterfaceEspecialidad DaoEspecialidad=new MysqlEspecialidad();
        InterfaceMedico DaoMedico=new MysqlMedico();
        InterfaceCita DaoCita=new MysqlCita();
        
        String usuario=request.getParameter("usuario");
        String userclave=request.getParameter("clave");
        
        Usuario usuObj=DAO_Usuario.validarUsuario(usuario, userclave);
        
        Medico medObj=DaoMedico.validarMedico(usuario, userclave);
        
        ArrayList<Usuario> listaUsuario=DAO_Usuario.listar();
        ArrayList<Especialidad> listaEspecialidad=DaoEspecialidad.listar();
        ArrayList<Medico> listaMedico=DaoMedico.listar();
        ArrayList<Cita> listacitas=DaoCita.listar();
        
        String accion=request.getParameter("accion");
            if (accion.equals("loguin")) {

                if (usuObj!=null) {
                    HttpSession sesionOk=request.getSession();
                    sesionOk.setAttribute("Usuario", usuObj);
                    sesionOk.setAttribute("nom", usuObj.getNombre());
                    sesionOk.setAttribute("apepat", usuObj.getApellidopat());
                    sesionOk.setAttribute("perfil", usuObj.getPerfil_usuario_id());
                    sesionOk.setAttribute("listaUsuarios", listaUsuario);
                    sesionOk.setAttribute("listaMedicos", listaMedico);
                    sesionOk.setAttribute("listaEspecialidad", listaEspecialidad);
                    sesionOk.setAttribute("listacitas", listacitas);

                    response.sendRedirect("inicio.jsp");
                    
                    }
                }
            
            else if (accion.equals("cerrar")) {
                    HttpSession sesionOk = request.getSession();
                    request.getSession().removeAttribute("perfil");
                    request.getSession().removeAttribute("nom");
                    request.getSession().removeAttribute("apepat");
                    sesionOk.invalidate();
                    request.getRequestDispatcher("inicio.jsp").forward(request, response);
                    
                }else if (accion.equals("eliminar")){
                    this.eliminar(request,response);
                }else if (accion.equals("listar")) {
                      InterfaceUsuario DaoUsuario=new MysqlUsuario();
                    
                      ArrayList<Usuario> listausu = DaoUsuario.listar();
                   
                      sesion.setAttribute("listausu", listausu);

                      response.sendRedirect("Citas-Adm/listapacientes.jsp");
                }else if (accion.equals("Modificar")) {
                  this.Modificar(request,response);
                  
                }else if(accion.equals("loguinmedico")){
                    if (medObj!=null) {
                    HttpSession sesionOk=request.getSession();
                    sesionOk.setAttribute("Medico", medObj);
                    sesionOk.setAttribute("nom", medObj.getNombre());
                    sesionOk.setAttribute("apepat", medObj.getApellidopat());
                    sesionOk.setAttribute("perfil", medObj.getPerfil_usuario_id());
                    sesionOk.setAttribute("listaUsuarios", listaUsuario);
                    sesionOk.setAttribute("listaMedicos", listaMedico);
                    sesionOk.setAttribute("listaEspecialidad", listaEspecialidad);
                    sesionOk.setAttribute("listacitas", listacitas);

                    response.sendRedirect("inicio.jsp");
                    
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

    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
        
    }

    private void Modificar(HttpServletRequest request, HttpServletResponse response) throws IOException {
                 Usuario u=new Usuario(Integer.parseInt(request.getParameter("txtCodigo")),
                         request.getParameter("txtDNI"),
                     request.getParameter("txtNombre"),       
                request.getParameter("txtApepat"),
                request.getParameter("txtApemat"),
                         request.getParameter("txtTelefono"),
                         request.getParameter("txtEmail"),
                         request.getParameter("txtDireccion")
                    );

                InterfaceUsuario
                DaoUsuario=new MysqlUsuario();
        
                boolean rpta=DaoUsuario.actualizarUsuario(u);

                if (rpta==true) {
                    response.sendRedirect("mensaje.jsp?men=Se actualizo el paciente de manera correcta");
                }else{
                    response.sendRedirect("mensaje.jsp?men=No se actualizo el Paciente");
                }
    }

}
