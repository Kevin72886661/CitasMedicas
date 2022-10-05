<%-- 
    Document   : citas
    Created on : 20-oct-2018, 11:56:17
    Author     : casa
--%>
<%
    
    Usuario usuario=(Usuario)session.getAttribute("Usuario");
    
%>
<%@page import="pe.citas.modelo.vo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Citas</title>
        <link href="../CSS/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/Citas.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <body>
        <%@include file='../WEB-INF/Partes-estaticas/header.jsp'%> 
        
        
            
                <div class="contenedor_citas">
                    <p class="titulocita">Pide tu cita</p>
                    
                    <form id="form_buscar" method="post" action="../Consulta">
                        <div class="row">
                            <div class="col-sm-5">
                                <label>Cita para: </label>
                                <select class="form-control" name="paciente">
                                    <option value="<%=usuario.getDNI()%>"><%=usuario.getNombre()%> <%=usuario.getApellidopat()%> <%=usuario.getApellidomat()%></option>
                                </select>
                            </div>
                            
                        </div> 
                        <br>
                        <input type="submit" class="btn btn-primary botoncita" value="Continuar">
                    </form> 
                    <br>
                      
                </div>    
           
        
    </body>
</html>
