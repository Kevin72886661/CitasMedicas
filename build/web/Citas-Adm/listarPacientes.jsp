<%-- 
    Document   : listarUsuarios
    Created on : 21/10/2019, 10:43:57 AM
    Author     : juan
--%>

<%@page import="pe.citas.modelo.vo.Cita"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="java.util.ArrayList"%>
<%@page import="pe.citas.modelo.vo.Cita"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Citas</title>
        <link href="../CSS/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/Citas.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>
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
    <body>
        <%@include file='../WEB-INF/Partes-estaticas/header.jsp'%> 
        
        
        
            <br>      
        <div class="contenedor_citas">
            <table class="table table-bordered">
                <thead class="thead-light">
                    <tr>
                        <th scope="col">DNI</th>
                        <th scope="col">Paciente</th>
                        <th scope="col">Medico</th>
                        <th scope="col">Especialidad</th>

                        <th scope="col">Fecha de la cita</th>
                        <th scope="col">Hora de la cita</th>
                        <th scope="col">Opciones</th>
                    </tr>
                </thead>
                
            <tbody>
        
                            <c:forEach items="${listaPacientes}" var="cita">
                    <c:choose>
                        <c:when test="${not empty cita.idCita}">
                            <tr>
                              <td><c:out value="${cita.usuario.DNI}"/></td>

                                <td><c:out value="${cita.usuario.nombre}"/>&nbsp;<c:out value="${cita.usuario.apellidopat}"/>&nbsp;<c:out value="${cita.usuario.apellidomat}"/></td>
                                <td><c:out value="${cita.medico.nombre}"/>&nbsp;<c:out value="${cita.medico.apellidopat}"/></td>

                                <td><c:out value="${cita.especialidad.nomEspecialidad}"/></td>
                                <td><c:out value="${cita.dia}"/></td>
                                <td><c:out value="${cita.hora}"/></td>
                                <td><label class="detalles2"><a class="boton" href="ServletControlador?accion=eliminar & id=<c:out value="${cita.idCita}"/>">Cancelar</a></label></td>
                            </tr>
                        </c:when>
                    </c:choose>
                </c:forEach> 
            </tbody>
            
            </table>
                
                
        
        </div>
    </body>
</html>
