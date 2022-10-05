<%-- 
    Document   : listaPrescripcion
    Created on : 08/11/2019, 05:42:29 PM
    Author     : LAB-USR-LN6377-B0305
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prescripcion Medica</title>
        <link href="../CSS/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/Citas.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file='../WEB-INF/Partes-estaticas/header.jsp'%> 
        
        
        
            <br>      
        <div class="contenedor_citas">
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th width="20%">Receta</th>
                        <th width="20%">Recomendacion</th>
                        <th width="20%">Fecha</th>
                         <th width="20%">Acciones</th>
                    </tr>
                </thead>
                
            <tbody>
                <c:forEach items="${listaPrescripcion}" var="presc">
                    <c:choose>
                        <c:when test="${not empty presc.idPrescripcion}">
                            <tr>
                                <td><c:out value="${presc.receta}"/></td>
                                <td><c:out value="${presc.recomendacion}"/></td>
                                <td><c:out value="${presc.fecha}"/></td>
                                
                                <td><label class="detalles2"><a class="boton" href="../DetPrescripcion.jsp?id=<c:out value="${presc.idPrescripcion}"/>">Ver detalles</a></label></td>
                            </tr>
                        </c:when>
                    </c:choose>
                </c:forEach> 
            </tbody>
            
            </table>
                
                
        
        </div>
    </body>
</html>
