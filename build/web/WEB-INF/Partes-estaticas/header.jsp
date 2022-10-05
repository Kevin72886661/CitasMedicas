<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
   
  
    String nom="";
    HttpSession sesionOK=request.getSession();
    
if(sesionOK.getAttribute("perfil")!=null){
    nom=(String)sesionOK.getAttribute("nom")+" "+(String)sesionOK.getAttribute("apepat");
}
    %>


<style>
    
    .sesion{
        text-decoration: none;
        color:#fff;
        font-size: 18px;
        float: right;
        margin:20px 20px 0px 0px;
    }
    
    .sesion:hover{
        text-decoration: none;
        cursor: pointer;
    }
</style>
<!DOCTYPE html>

        <header class="encabezado">
            
                        <div class="wrapper">

                            <nav>
                                <ul class="menu">
                                    <li><a href="../inicio.jsp">Inicio</a></li>
                                    <%if(sesionOK.getAttribute("perfil")!=null && sesionOK.getAttribute("perfil").equals(1)){
                                        %>                                    
                                  <li><a href="#">Medicos</a>
                                    
                                    <ul class="submenu">
                                        <li><a href="../AgregarMed.jsp">Agregar Medicos</a></li>
                                        <li><a href="../RegMedico?accion=listar">Ver Medicos</a></li>
                                    </ul>
                                    </li>
                                    
                                    <li><a href="#">Pacientes</a>
                                    
                                    <ul class="submenu">
                                        <li><a href="../RegistroA.jsp">Agregar pacientes</a></li>
                                        <li><a href="../ServletLogueo?accion=listar">Ver pacientes</a></li>
                                    </ul>
                                    </li>
                                    
                                    <li><a href="#">Citas</a>
                                    
                                    <ul class="submenu">
                                        <li><a href="../RegCita.jsp">Agregar citas</a></li>
                                        <li><a href="../Cita?accion=listar">Historial de citas</a></li>
                                    </ul>
                                    </li>
                                    
                                    <li><a href="#">Historia</a>
                                    
                                    <ul class="submenu">
                                        <li><a href="../AgrHistoria.jsp">Agregar Historia</a></li>
                                        
                                        <li><a href="../Historia?accion=listarAdm">Ver Historias</a></li>
                                    </ul>
                                    </li>
                                    
                                    <li><a href="#">Prescripcion</a>
                                        <ul class="submenu">
                                    <li><a href="../Citas-Adm/AgrPrescripcion.jsp">Agregar Prescripcion</a></li>
                                    <li><a href="../Prescripcion?accion=listarAdm">Ver Prescripcion</a></li>
                                    </ul>
                                    </li>
                                       
                                       <a style="float: right;margin:20px 0px 0px 0px;color: #fff;" href="../ServletLogueo?accion=cerrar">Cerrar Sesion</a>
                                    <%
                                        }
                                        %>
                                    
                                    <%if(sesionOK.getAttribute("perfil")!=null && sesionOK.getAttribute("perfil").equals(2)){
                                        %>
                                        <li><a href="#">Citas</a>
                                        <ul class="submenu">
                                                <li><a href="../Citas-Usu/citas.jsp">Reserva tu Cita</a></li>
                                                 <li><a href="../ServletHistorial">Ver Citas</a></li>
                                         </ul>
                                       </li>
                                       <li><a href="#">Documentos</a>
                                    
                                    <ul class="submenu">
                                        <li><a href="../Historia?accion=listar">Ver Historia Clinica</a></li>
                                        <li><a href="../Prescripcion?accion=listar">Ver Prescripcion Medica</a></li>
                                    </ul>
                                    </li>
                                       
                                       
                                       
                                       <li style=" color: #fff;font-size: 15px;margin:20px 0px 0px 0px;"><%out.println("Bienvenido : "+nom);%></li>
                                       
                                       <a style="float: right;margin:20px 0px 0px 0px;color: #fff;" href="../ServletLogueo?accion=cerrar">Cerrar Sesion</a>

                                    <%
                                        }
                                    %>
                                    
                                    <%if(sesionOK.getAttribute("perfil")!=null && sesionOK.getAttribute("perfil").equals(3)){
                                        %>
                                        <li><a href="#">Citas</a>
                                        <ul class="submenu">
                                                 <li><a href="../ServletHistorialMedico">Ver Citas</a></li>
                                         </ul>
                                       </li>
                                       
                                        <li><a href="#">Prescripcion</a>
                                            <ul class="submenu">
                                            <li><a href="../Citas-Adm/AgrPrescripcion.jsp">Agregar Prescripcion</a></li>
                                            <li><a href="../Prescripcion?accion=listarAdm">Ver Prescripcion</a></li>
                                            </ul>
                                        </li>
                                        
                                        <li><a href="#">Documentos</a>
                                    
                                    <ul class="submenu">
                                        <li><a href="../Historia?accion=listarAdm">Ver Historia Clinica</a></li>
                                    </ul>
                                    </li>
                                       
                                       
                                       
                                       <li style=" color: #fff;font-size: 15px;margin:20px 0px 0px 0px;"><%out.println("Bienvenido : "+nom);%></li>
                                       
                                       <a style="float: right;margin:20px 0px 0px 0px;color: #fff;" href="../ServletLogueo?accion=cerrar">Cerrar Sesion</a>

                                    <%
                                        }
                                    %>
                                      
         <%
               if(sesionOK.getAttribute("perfil")==null){
               %>
                                    <a class="sesion" href="index.jsp">Iniciar Sesion</a> 
                            <% } %>        
                                </ul>
                              
                            </nav>    
                        </div>   
                             
        </header>
 
