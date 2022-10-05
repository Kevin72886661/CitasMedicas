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
        <title>Registro de Pacientes</title>
        <link rel="stylesheet" type="text/css" href="CSS/estilos.css">
        <link href="CSS/Citas.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file='WEB-INF/Partes-estaticas/header.jsp'%>
        
        <div class="contenedor_citas">
            <div class="centrar">
                
                <form name="form-2" method="post" action="Registro" onsubmit="return validar2()"> 
                    
                    <label style="color: green;">${mensaje}</label>
                    
                      
                    <input type="hidden" name="accion" value = "registrar">
                    <input type="hidden" name="id" value = "2">
                    <br>
                    <br>
                    <div class="row">
                        <div class="col-sm-12">
                            <label for="nombre" class="control-label col-xs-4">Nombres: </label>
                            <input type="text" class="form-control" name="nombre" placeholder="Nombre: " class="form-control"/>
                        </div>    
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-sm-12">
                            <label for="apellidopat" class="control-label col-xs-12">Apellido Paterno: </label>
                            <input type="text" class="form-control" name="apellidopat" placeholder="Apellido Paterno: " class="form-control"/> 
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-sm-12">
                            <label for="apellidomat" class="control-label col-xs-12">Apellido Materno: </label>
                            <input type="text" class="form-control" name="apellidomat" placeholder="Apellido Materno: " class="form-control"/>
                        </div>
                    </div>    
                       <br> 
                    <div class="row">
                        <div class="col-sm-12">
                            <label for="email" class="control-label col-xs-4">Correo: </label>
                            <input type="text" class="form-control" name="email" placeholder="Ingresa tu correo" class="form-control"/> 
                        </div>
                    </div>    
                    <br>
                    <div class="row">
                        <div class="col-sm-12">
                            <label for="telefono" class="control-label col-xs-12">Teléfono Celular: </label>
                            <input type="text" class="form-control" maxlength="9" name="telefono" placeholder="Ingresa tu telefono" class="form-control"/> 
                        </div>
                    </div>
                     <br>   
                    <div class="row">
                        <div class="col-sm-12">
                            <label for="direccion" class="control-label col-xs-4">Direccion: </label>
                            <input type="text" class="form-control" name="direccion" placeholder="Ingresa tu direccion" class="form-control"/> 
                        </div>
                    </div>    
                    <br>
                    <div class="row">
                        <div class="col-sm-12">
                            <label for="DNI" class="control-label col-xs-4">DNI: </label>
                            <input type="text" class="form-control" maxlength="8" name="DNI" placeholder="Ingresa tu DNI" class="form-control"/> 
                        </div>
                    </div>    
                    <br>
                    <div class="row">
                        <div class="col-sm-12">
                            <label for="password" class="control-label col-xs-12">Contraseña: </label>
                            <input type="password" class="form-control" name="password" placeholder="Ingresa una contraseña" class="form-control"/>
                        </div>
                    </div>    
                    <br>
                    <div class="row">
                        <div class="col-sm-12">
                            <label for="Confpassword" class="control-label col-xs-12">Confirma tu Contraseña: </label>
                            <input type="password" class="form-control" name="Confpassword" placeholder="Cofirma tu contraseña" class="form-control"/>
                        </div>
                    </div>    
                    <br>

                    <input type="submit" value="Registrarse" class="btn btn-primary"/><span class="red"></span>
                    <input type="reset" name="limpiar" id="limpiar" value="Limpiar" class="btn btn-primary" />
                </form>
            </div>   
        </div>
    </body>
</html>
