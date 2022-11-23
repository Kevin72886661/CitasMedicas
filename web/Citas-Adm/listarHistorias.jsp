<%@page import="pe.citas.servlets.Usuario.Historia"%>
<%@page import="pe.citas.modelo.vo.Horario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%  
    
    
    ArrayList<Historia> listaHistoria=(ArrayList<Historia>)session.getAttribute("listahistoria");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Historias Clinicas</title>
        <link href="../CSS/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/Citas.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file='../WEB-INF/Partes-estaticas/header.jsp'%> 
        
        
        
            <br>
            ${mensaje}
        <div class="contenedor_citas">
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th width="15%">Paciente</th>
                        <th width="20%">Motivo de la consulta</th>
                        <th width="15%">Enfermedad</th>
                        <th width="15%">Fecha de creacion</th>
                        <th width="15%"></th>
                        <th width="10%"></th>
                    </tr>
                </thead>
                
            <tbody>
                <c:forEach items="${listahistoria}" var="historia">
                    <c:choose>
                        <c:when test="${not empty historia.idHistoria}">
                            <tr>
                                <td><c:out value="${historia.paciente.nombre}"/>&nbsp;<c:out value="${historia.paciente.apellidopat}"/></td>
                                <td><c:out value="${historia.motivo}"/></td>
                                <td><c:out value="${historia.enfermedad}"/></td>
                                <td><c:out value="${historia.fechCreHist}"/></td>
                                <td><label class="detalles2"><a class="boton" href="../DetHistoria.jsp?id=<c:out value="${historia.idHistoria}"/>">Ver detalles</a></label></td>
                                <td><label><a class="boton" href="ModificarHistoria.jsp?id=<c:out value="${historia.idHistoria}"/>&update=true">Modificar</a></label></td>

                            </tr>
                        </c:when>
                    </c:choose>
                </c:forEach> 
            </tbody>
            
            </table>
                
                
        
        </div>
    </body>
</html>
