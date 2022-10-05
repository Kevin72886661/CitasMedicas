<%@page import="pe.citas.BD.Mysql.MysqlUsuario"%>
<%@page import="pe.citas.BD.Interfaces.InterfaceUsuario"%>
<%@page import="pe.citas.modelo.vo.Usuario"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
        HttpSession sesion=request.getSession();
        InterfaceUsuario DaoUsuario=new MysqlUsuario();

        ArrayList<Usuario> listausu = DaoUsuario.listar();

        sesion.setAttribute("listausu", listausu);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Historia</title>
        <link rel="stylesheet" type="text/css" href="CSS/estilos.css">
        <link href="CSS/Citas.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>
    <body>
         <%@include file='WEB-INF/Partes-estaticas/header.jsp'%> 
         <div class="contenedor_citas">
            <div class="centrar">
                ${mensaje}
                <form method="post" action="Historia">
                    <input type="hidden" name="accion" value="insertar">
                    <div class="row">
                        <div class="col-sm-12">
                            <label>Paciente: </label>
                            <select name="idpaciente" class="form-control" required="true">
                                        <option value="0">Seleccione un paciente..</option>
                                        <c:forEach items="${listausu}" var="usuario">
                                            <c:choose>
                                                <c:when test="${not empty usuario.id}">
                                                    <option value="<c:out value="${usuario.id}"/>">
                                                        <c:out value="${usuario.nombre} " /><c:out value="${usuario.apellidopat}"/> <c:out value="${usuario.apellidomat}"/></option>
                                                </c:when>
                                            </c:choose>
                                        </c:forEach>
                                      
                            </select>
                        </div>
                    </div> 
                    <br>
                    
                    <div class="row">
                        <div class="col-sm-12">
                            <label>Antecedentes heredo-familiares: </label>
                            <textarea name="antecedentes" class="form-control noresize" maxlength="60" rows="6"></textarea>
                        </div> 

                    </div>
                    <br>
                    <div class="row">
                        <div class="col-sm-12">
                            <label>Motivo de consulta: </label>
                            <textarea name="motivo" class="form-control noresize" maxlength="60" rows="6"></textarea>
                        </div> 

                    </div>
                    <br>
                    <div class="row">
                        <div class="col-sm-12">
                            <label>Enfermedad: </label>
                                <input name="enfermedad" class="form-control" type="text" required>
                        </div> 

                    </div>
                    <br>
                    <div class="row">
                        <div class="col-sm-12">
                            <label>Examenes: </label>
                            <input name="examenes" class="form-control" type="text" required>
                        </div> 

                    </div>
                    
                    
                    <br>
                    <input type="submit" name="accion" class="btn btn-primary" value="Agregar" style="margin-right: 5px;">
                    
                </form>
            </div>   
        </div>
    </body>
</html>
