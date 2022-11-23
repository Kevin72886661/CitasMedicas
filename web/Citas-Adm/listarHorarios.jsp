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
<script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
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
                
                        <th scope="col">Medico</th>
                        <th scope="col">Especialidad</th>
                        <th scope="col">Fecha de la cita</th>
                        <th scope="col">Hora de la cita</th>
                        <th scope="col">Opciones</th>
                    </tr>
                </thead>
                
            <tbody>
        
                            <c:forEach items="${listaHorario}" var="horario">
                    <c:choose>
                        <c:when test="${not empty horario.idHorario}">
                            <tr>
                                <td><c:out value="${horario.medico.nombre} ${horario.medico.apellidopat}"/></td>
                                <td><c:out value="${horario.especialidad.nomEspecialidad}"/></td>
                                <td><c:out value="${horario.dia}"/></td>
                                <td><c:out value="${horario.hora}"/></td>
                                <td>
                                
                                <input type="hidden" id="codigo" value="<c:out value="${horario.idHorario}"/>">
                                                <a id="deleteHorario" href="<c:url value="../Horarios" >
                                                       <c:param name="accion" value="eliminar" />
                                                       <c:param name="idHorario" value="${horario.idHorario}" />
                                                   </c:url>"><button type="button" class="btn btn-danger" data-toggle="tooltip"  title="Eliminar" data-original-title="Eliminar">
                                                        <i class="fa fa-trash"></i>Eliminar</button></a>
                                </td>
                            </tr>
                        </c:when>
                    </c:choose>
                </c:forEach> 
            </tbody>
            
            </table>
                
                
        
        </div>
                <script src="https://code.jquery.com/jquery-3.3.1.js"></script>

            <!-- Bootstrap 3.3.7 -->
                        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>


             <script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
             <script src="../JavaScript/funcionesUsuario.js" type="text/javascript" charset="utf-8"></script>
            

    </body>
</html>
