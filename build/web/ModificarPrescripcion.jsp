<%-- 
    Document   : ModificarHistoria
    Created on : 05/11/2019, 07:54:25 PM
    Author     : juan
--%>

<%@page import="pe.citas.modelo.vo.Prescripcion_C"%>
<%@page import="pe.citas.BD.Mysql.MysqlPrescripcion"%>
<%@page import="pe.citas.BD.Interfaces.InterfacePrescripcion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    InterfacePrescripcion DaoPrescripcion=null;
    
    DaoPrescripcion=new MysqlPrescripcion();
    Prescripcion_C pr=null;
    String valor=request.getParameter("update").toString();
    if(pr!=null || valor=="true"){
            pr=DaoPrescripcion.obtenerporId(Integer.parseInt(request.getParameter("id")));

    }else{
            pr=DaoPrescripcion.obtenerporId(Integer.parseInt(request.getAttribute("id_presc").toString()));

    }
    
%>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Prescripcion</title>
        <link href="CSS/foto.css" rel="stylesheet" type="text/css"/>
         <link href="CSS/galeria.css" rel="stylesheet" type="text/css"/>

        <link href="https://fonts.googleapis.com/css?family=Slabo+27px" rel="stylesheet">
        <link rel="stylesheet" href=https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css>
        <link rel='shortcut icon' type='image/ico' href='imagenes/feet-1459485_1920.ico'/>
        <link href="CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/Citas.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
                <%@include file='WEB-INF/Partes-estaticas/header.jsp' %> 

        <div class="contenedor">
            <div class="contenedor_citas">
            <h2 align="center">Modificar Prescripcion</h2>
                <form action="Prescripcion" method="post">
                    ${men}
                                       <input type="hidden" name="accion" value="Modificar">
                   <div class="columns">
                       <input type="hidden" name="txtCodigo" value="<%= pr.getIdPrescripcion()%>" readonly>
                       
                       <div class="row">
                            <div class="col-sm-12">
                                <label>Receta medica: </label>
                                <textarea class="form-control noresize" maxlength="60" rows="6" type="textarea" name="receta"><%= pr.getReceta()%></textarea>
                            </div> 
                       </div>
                       <div class="row">
                            <div class="col-sm-12">
                                <label>Recomendacion: </label>
                                <textarea class="form-control noresize" maxlength="60" rows="6" type="textarea" name="recomendacion"><%= pr.getRecomendacion()%></textarea>
                            </div> 
                       </div>

                       
                       
                       <input type="hidden" name="fecha" value="<%= pr.getFecha()%>" readonly>
                                              
                       <div><button class="buttonmodpres" type="submit" name="accion" value="Modificar">Modificar Prescripcion</button></div>  
                   </div>    
                   
                          
                </form>
                            </div> 
        </div> 
    </body>
</html>
