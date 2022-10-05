<%-- 
    Document   : doctores
    Created on : 30-oct-2018, 19:43:47
    Author     : casa
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="pe.citas.modelo.vo.Medico"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    ArrayList<Medico> listmedico=null;
    try{
     listmedico=(ArrayList<Medico>)session.getAttribute("alMedicos");
    }catch(Exception e){
        
    }
    
    String mensaje1=request.getParameter("mensaje1");
    if(mensaje1==null)
    mensaje1="";
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Medicos</title>
         <link rel="stylesheet" type="text/css" href="../CSS/estilos.css">
        <link href="../CSS/Citas.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file='../WEB-INF/Partes-estaticas/header.jsp'%> 
        
        <div class="contenedor_citas">
            ${mensaje}
            <table class="table table-striped table-bordered table-hover">
                
                <tr>
                    <th>Nombre</th>
                    <th>Apellido Paterno</th>
                    <th>Apellido Materno</th>
                    <th>Email</th>
                    <th>Numero de telefono</th>
                    <th style="text-align: center" colspan="2">Opciones</th>
                </tr>
               
            <c:forEach items="${alMedicos}" var="medico">
            <c:choose>
                <c:when test="${not empty medico.nombre}">
            <tr>
                <td><c:out value="${medico.nombre}"/></td>
                <td><c:out value="${medico.apellidopat}"/></td>
                <td><c:out value="${medico.apellidomat}"/></td>
                <td><c:out value="${medico.email}"/></td>
                <td><c:out value="${medico.telefono}"/></td>
                <td><a href="../ModificarMedico.jsp?id=<c:out value="${medico.id}"/>">Modificar</a></td>
                <td><a class="boton bg-warning" href="../Medicos?accion=eliminar&idmedico=<c:out value="${medico.id}"/>">Eliminar</a></td>

            </tr>               
                </c:when>
            </c:choose>
        </c:forEach>   
            </table>
        
        </div>
    </body>
</html>
