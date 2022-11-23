<%-- 
    Document   : ModificarPaciente
    Created on : 28/10/2019, 10:25:23 AM
    Author     : juan
--%>


<%@page import="pe.citas.modelo.vo.Especialidad"%>
<%@page import="pe.citas.BD.Mysql.MysqlEspecialidad"%>
<%@page import="pe.citas.BD.Interfaces.InterfaceEspecialidad"%>
<%@page import="pe.citas.BD.Interfaces.InterfaceEspecialidad"%>
<%@page import="pe.citas.modelo.vo.HistoriaC"%>
<%@page import="pe.citas.BD.Mysql.MysqlHistoria"%>
<%@page import="pe.citas.BD.Interfaces.InterfaceHistoria"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    /*InterfaceHistoria DaoHistoria=null;
    
    DaoHistoria=new MysqlHistoria();
    
    HistoriaC h=DaoHistoria.obtenerporId(Integer.parseInt(request.getParameter("id")));*/
    
    InterfaceEspecialidad DaoEspecialidad=null;
    
    DaoEspecialidad=new MysqlEspecialidad();
    Especialidad esp=null;
    String estado_modificar="false";
    String valor="";
    
    try {
           valor=request.getParameter("update").toString();
    } catch (Exception e) {
        e.getMessage();
    }        
    if(valor.equalsIgnoreCase("true") && estado_modificar.equalsIgnoreCase("false")){
            esp=DaoEspecialidad.obtenerporId(Integer.parseInt(request.getParameter("id")));

    }else{
            esp=DaoEspecialidad.obtenerporId(Integer.parseInt(request.getAttribute("id_espec").toString()));
            estado_modificar=request.getAttribute("estado_modificar").toString();

    }
    
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../CSS/Citas.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Modificar Especialidad</title>
    </head>
    <body>
        <%@include file='../WEB-INF/Partes-estaticas/header.jsp' %> 
       <div class="contenedor">
            <div class="contenedor_citas">
            <h2 align="center">Modificar Especialidad</h2>
                <form action="../Especialidad" method="post">
                    ${men}
                   <input type="hidden" name="accion" value="Modificar">

                    <table class="table">
                        
                         
                      <tr>
                           <td>Especialidad: </td>
                           <td><input type="text" class="form-control" name="nomespec" value="<%= esp.getNomEspecialidad()%>"></td>
                       </tr>

                      
                   </table> 
                      <input type="hidden" name="txtCodigo" value="<%= esp.getIdespecialidad()%>" readonly>

                     <div><button class="buttonmodpres" type="submit" name="accion" value="Modificar">Modificar Prescripcion</button></div>  
  
                </form>
                            </div> 
        </div>        
    </body>
</html>
