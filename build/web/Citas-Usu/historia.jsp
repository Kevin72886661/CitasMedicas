<%@page import="pe.citas.modelo.vo.Horario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%  
    
    
    ArrayList<Horario> listahorario=(ArrayList<Horario>)session.getAttribute("listahorario");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                        <th width="20%">Antecedente</th>
                        <th width="15%">Motivo de la consulta</th>
                        <th width="20%">Enfermedad</th>
                        <th width="15%">Examenes</th>
                        <th width="15%">Fecha de creacion</th>
                    </tr>
                </thead>
                
            <tbody>
                <c:forEach items="${listahistoria}" var="historia">
                    <c:choose>
                        <c:when test="${not empty historia.idHistoria}">
                            <tr>
                                <td><c:out value="${historia.antecedentes}"/></td>
                                <td><c:out value="${historia.motivo}"/></td>
                                <td><c:out value="${historia.enfermedad}"/></td>
                                <td><c:out value="${historia.examenes}"/></td>
                                <td><c:out value="${historia.fechCreHist}"/></td>
                                <td><label class="detalles2"><a class="boton" href="../DetHistoria.jsp?id=<c:out value="${historia.idHistoria}"/>">Ver detalles</a></label></td>
                            </tr>
                        </c:when>
                    </c:choose>
                </c:forEach> 
            </tbody>
            
            </table>
                
                
        
        </div>
    </body>
</html>
