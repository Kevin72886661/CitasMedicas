<%-- 
    Document   : RegistroA
    Created on : 16/09/2019, 06:37:11 PM
    Author     : juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Especialidad</title>
        <link rel="stylesheet" type="text/css" href="../CSS/estilos.css">
        <link href="../CSS/Citas.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file='../WEB-INF/Partes-estaticas/header.jsp'%>
        
        <div class="contenedor_citas">
            <div class="centrar">
                
                <form name="form-2" action="../Registro" onsubmit="return validar2()"> 
                    
                    <label style="color: green;">${mensaje}</label>
                    
                      
                    <input type="hidden" name="accion" value = "registrarespec">
                    <input type="hidden" name="id" value = "2">
                    <br>
                    <br>
                    <div class="row">
                        <div class="col-sm-12">
                            <label for="nombre" class="control-label col-xs-4">Especialidad: </label>
                            <input type="text" class="form-control" name="nombreespec" placeholder="Nombre: " class="form-control"/>
                        </div>    
                    </div>
                    
                    <br>
                    <input type="submit" value="Registrar" class="btn btn-primary"/><span class="red"></span>
                    <input type="reset" name="limpiar" id="limpiar" value="Limpiar" class="btn btn-primary" />
                </form>
            </div>   
        </div>
    </body>
</html>
