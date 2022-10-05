<%-- 
    Document   : doctores
    Created on : 30-oct-2018, 19:43:47
    Author     : casa
--%>

<%@page import="pe.citas.modelo.vo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pe.citas.modelo.vo.Medico"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%

    String mensaje1=request.getParameter("mensaje1");
    if(mensaje1==null)
    mensaje1="";
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de usuarios</title>
         <link rel="stylesheet" type="text/css" href="../CSS/estilos.css">
        <link href="../CSS/Citas.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file='../WEB-INF/Partes-estaticas/header.jsp'%> 
        
        
           
            
        <div class="contenedor">
            <div class="contenedor_citas">
                <table class="table table-striped table-bordered table-hover">

                    <tr>
                        <th>#</th>
                        <th>Nombre</th>
                        <th>Apellido Paterno</th>
                        <th>Apellido Materno</th>
                        <th>Email</th>
                        <th>Numero de telefono</th>
                        <th>Fecha de registro</th>
                    </tr>


                <c:forEach items="${listausu}" var="usuario">
                        <c:choose>
                            <c:when test="${not empty usuario.id}">
                                <tr>
                                    <th scope="row">${usuario.id}</th>
                                    <td><c:out value="${usuario.nombre}"/></td>
                                    <td><c:out value="${usuario.apellidopat}"/></td>
                                    <td><c:out value="${usuario.apellidomat}"/></td>
                                    <td><c:out value="${usuario.email}"/></td>
                                    <td><c:out value="${usuario.telefono}"/></td>
                                    <td><c:out value="${usuario.fecha_registro}"/></td>
                                    <td><a href="ModificarPaciente.jsp?id=<c:out value="${usuario.id}"/>">Modificar</a></td>
                                </tr>
                            </c:when>
                        </c:choose>
                    </c:forEach> 
                </table>

            </div>
                    

            </div>
    </body>
</html>
