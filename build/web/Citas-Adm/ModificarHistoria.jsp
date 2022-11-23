<%-- 
    Document   : ModificarPaciente
    Created on : 28/10/2019, 10:25:23 AM
    Author     : juan
--%>


<%@page import="pe.citas.modelo.vo.HistoriaC"%>
<%@page import="pe.citas.BD.Mysql.MysqlHistoria"%>
<%@page import="pe.citas.BD.Interfaces.InterfaceHistoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    /*InterfaceHistoria DaoHistoria=null;
    
    DaoHistoria=new MysqlHistoria();
    
    HistoriaC h=DaoHistoria.obtenerporId(Integer.parseInt(request.getParameter("id")));*/
    
    InterfaceHistoria DaoHistoria=null;
    
    DaoHistoria=new MysqlHistoria();
    HistoriaC h=null;
    String estado_modificar="false";
    String valor="";
    
    try {
           valor=request.getParameter("update").toString();
    } catch (Exception e) {
        e.getMessage();
    }        
    if(valor.equalsIgnoreCase("true") && estado_modificar.equalsIgnoreCase("false")){
            h=DaoHistoria.obtenerporId(Integer.parseInt(request.getParameter("id")));

    }else{
            h=DaoHistoria.obtenerporId(Integer.parseInt(request.getAttribute("id_hist").toString()));
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
        <title>Modificar Historia</title>
    </head>
    <body>
        <%@include file='../WEB-INF/Partes-estaticas/header.jsp' %> 
       <div class="contenedor">
            <div class="contenedor_citas">
            <h2 align="center">Modificar Historia</h2>
                <form action="../Historia" method="post">
                    ${men}
                   <input type="hidden" name="accion" value="Modificar">

                    <table class="table">
                        
                         <div class="row">
                           <td>Antecedentes familiares: </td>
                           <td><input type="text" class="form-control" name="antecedentes" value="<%= h.getAntecedentes()%>">

                            </td>
                       </div>
                      <tr>
                           <td>Motivo: </td>
                           <td><input type="text" class="form-control" name="motivo" value="<%= h.getMotivo()%>"></td>
                       </tr>

                       <tr>
                         <td>Enfermedad: </td>
                         <td><input type="text" class="form-control" name="enfermedad" value="<%= h.getEnfermedad()%>"> </td>
                       </tr>

                       <tr>
                           <td>Examenes: </td>
                           <td><input type="text" class="form-control"  name="examenes" value="<%= h.getExamenes()%>"> </td>

                       </tr>
                    
                       
                      
                       
                   </table> 
                                                  <input type="hidden" name="txtCodigo" value="<%= h.getIdHistoria()%>" readonly>

                     <div><button class="buttonmodpres" type="submit" name="accion" value="Modificar">Modificar Prescripcion</button></div>  
  
                </form>
                            </div> 
        </div>        
    </body>
</html>
