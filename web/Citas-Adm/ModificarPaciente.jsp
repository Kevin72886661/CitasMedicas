<%-- 
    Document   : ModificarPaciente
    Created on : 28/10/2019, 10:25:23 AM
    Author     : juan
--%>

<%@page import="pe.citas.modelo.vo.Usuario"%>
<%@page import="pe.citas.BD.Mysql.MysqlUsuario"%>
<%@page import="pe.citas.BD.Interfaces.InterfaceUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    InterfaceUsuario DaoUsuario=null;
    
    DaoUsuario=new MysqlUsuario();
    
    Usuario u=DaoUsuario.obtenerporId(Integer.parseInt(request.getParameter("id")));
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../CSS/Citas.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Modificar Paciente</title>
    </head>
    <body>
        <%@include file='../WEB-INF/Partes-estaticas/header.jsp' %> 
       <div class="contenedor">
            <div class="contenedor_citas">
            <h2 align="center">Modificar Paciente</h2>
                <form action="../ServletLogueo" method="post">
                    ${men}
                   <input type="hidden" name="accion" value="Modificar">

                    <table class="table">
                        <tr>
                           <td>Id: </td>
                           <td><input type="text" name="txtCodigo" value="<%= u.getId()%>" readonly></td>
                       </tr>
                        <tr>
                           <td>DNI: </td>
                           <td><input type="text" name="txtDNI" value="<%= u.getDNI()%>" readonly></td>
                       </tr>
                      <tr>
                           <td>Nombre: </td>
                           <td><input type="text" name="txtNombre" value="<%= u.getNombre()%>" ></td>
                       </tr>

                       <tr>
                         <td>Apellido Paterno: </td>
                         <td><input type="text" name="txtApepat" value="<%= u.getApellidopat()%>"> </td>
                       </tr>

                       <tr>
                           <td>Apellido Materno: </td>
                           <td><input type="text"  name="txtApemat" value="<%= u.getApellidomat()%>"> </td>

                       </tr>
                    
                       <tr>
                           <td>Direccion: </td>
                           <td><input type="text"  name="txtDireccion" value="<%= u.getDireccion()%>"> </td>

                       </tr>
                       
                       <tr>
                           <td>Telefono: </td>
                           <td><input type="text"  name="txtTelefono" value="<%= u.getTelefono()%>"> </td>

                       </tr>

                       <tr>
                           <td>Email: </td>
                           <td><input type="text"  name="txtEmail" value="<%= u.getEmail()%>"> </td>

                       </tr>
                       
                       
                       
             
                       <tr>
                           <th colspan="2"><button class="btn btn-primary" type="submit" name="accion" value="ModificarPaciente" />Modificar Paciente</th>
                       </tr>
                       
                   </table> 
                          
                </form>
                            </div> 
        </div>        
    </body>
</html>
