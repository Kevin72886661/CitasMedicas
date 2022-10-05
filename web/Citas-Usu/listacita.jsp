<%-- 
    Document   : listacita
    Created on : 07-dic-2018, 11:13:13
    Author     : casa
--%>
<%@page import="pe.citas.modelo.vo.Cita"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="java.util.ArrayList"%>
<%@page import="pe.citas.modelo.vo.Usuario"%>
<%  
    
    
    ArrayList<Cita> listaCita=(ArrayList<Cita>)session.getAttribute("listaSesionUsuario");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de citas</title>
        <link href="../CSS/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/Citas.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <style>
            
 
a.boton {
  text-decoration: none;
  background: #222;
  color: #eee;
  border: 1px outset #CCC;
  padding: 8px;
}
 
a.boton:hover {
  background: #B1B4BF;
}
 
a.boton:active {
  border: 1px inset #000;
}
        </style>
    </head>
    <body>
        <%@include file='../WEB-INF/Partes-estaticas/header.jsp'%> 
        
        
        
            <br>      
        <div class="contenedor_citas">
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th width="5%">#</th>
                        <th width="20%">Medico</th>
                        <th width="15%">Especialidad</th>
                        <th width="20%">Fecha de la cita</th>
                        <th width="15%">Hora de la cita</th>
                        <th width="15%">Fecha de creacion</th>
                    </tr>
                </thead>
                
            <tbody>
                ${mensaje}
                <c:forEach items="${listaSesionUsuario}" var="cita">
                    <c:choose>
                        <c:when test="${not empty cita.idCita}">
                            <tr>
                                <th scope="row">${cita.idCita}</th>
                                <td><c:out value="${cita.medico.nombre}"/>&nbsp;<c:out value="${cita.medico.apellidopat}"/>&nbsp;<c:out value="${cita.medico.apellidomat}"/></td>
                                <td><c:out value="${cita.especialidad.nomEspecialidad}"/></td>
                                <td><c:out value="${cita.dia}"/></td>
                                <td><c:out value="${cita.hora}"/></td>
                                <td><c:out value="${cita.diaCrearCita}"/></td>
                                <td><a class="boton bg-warning" href="Cita?accion=eliminar&idcita=<c:out value="${cita.idCita}"/>">Eliminar</a></td>
                            </tr>
                        </c:when>
                    </c:choose>
                </c:forEach> 
            </tbody>
            
            </table>
                
                
        
        </div>
 
    </body>
</html>
