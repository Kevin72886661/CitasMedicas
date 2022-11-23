<%-- 
    Document   : listarPrescripcion
    Created on : 08/11/2019, 05:59:18 PM
    Author     : LAB-USR-LN6377-B0305
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar prescripcion</title>
        <link href="../CSS/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/Citas.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
     <body>
        <%@include file='../WEB-INF/Partes-estaticas/header.jsp'%> 
        
        
        
            <br>
            ${men}
        <div class="contenedor_citas">
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th width="15%">Paciente</th>
                        <th width="20%">Receta</th>
                        <th width="20%">Recomendacion</th>
                        <th width="15%">Fecha</th>
                        <th width="15%"></th>
                    </tr>
                </thead>
                
            <tbody>
                <c:forEach items="${listapresc}" var="pres">
                    <c:choose>
                        <c:when test="${not empty pres.idPrescripcion}">
                            <tr>
                                <td><c:out value="${pres.paciente.nombre}"/>&nbsp;<c:out value="${pres.paciente.apellidopat}"/></td>
                                <td><c:out value="${pres.receta}"/></td>
                                <td><c:out value="${pres.recomendacion}"/></td>
                                <td><c:out value="${pres.fecha}"/></td>
                                <td><label class="detalles2"><a class="boton" href="../DetPrescripcion.jsp?id=<c:out value="${pres.idPrescripcion}"/>">Ver detalles</a></label></td>

                                <td><label><a class="boton" href="../ModificarPrescripcion.jsp?id=<c:out value="${pres.idPrescripcion}"/>&update=true">Modificar</a></label></td>

                            </tr>
                        </c:when>
                    </c:choose>
                </c:forEach> 
            </tbody>
            
            </table>
                
                
        
        </div>
    </body>
</html>
