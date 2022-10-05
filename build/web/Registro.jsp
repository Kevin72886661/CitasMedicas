<%
    String mensaje1=request.getParameter("mensaje");
    if(mensaje1==null){
       mensaje1="";
    }
    
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
        <link href="CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/login.css" rel="stylesheet" type="text/css"/>
        <script src="JavaScript/login.js" type="text/javascript"></script>
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro" rel="stylesheet">
        
    </head>
    <body>
        
            
        <header>
            <a href="index.jsp"><img src="imagenes/logo2.png" class="logo" alt="logo"></a>            
        </header>
        <section class="fondo main">
            <div class="form-2 form-group">
                
                
            
                
                <form name="form-2" method="post" action="Registro" onsubmit="return validar2()"> 
                    
                    <label style="color: green;">${mensaje}</label>
                    
                      
                    <input type="hidden" name="accion" value = "registrar">
                    <input type="hidden" name="id" value = "2">
                    <br>
                    <br>
                    <label for="nombre" class="control-label col-xs-4">Nombres: </label>
                    <input type="text" name="nombre" placeholder="Nombre: " class="form-control"/>
                    
                    <label for="apellidopat" class="control-label col-xs-4">Apellido Paterno: </label>
                    <input type="text" name="apellidopat" placeholder="Apellido Paterno: " class="form-control"/> 
                    
                    <label for="apellidomat" class="control-label col-xs-4">Apellido Materno: </label>
                    <input type="text" name="apellidomat" placeholder="Apellido Materno: " class="form-control"/>
                    
                    <label for="email" class="control-label col-xs-4">Correo: </label>
                    <input type="text" name="email" placeholder="Ingresa tu correo" class="form-control"/> 
                    
                    <label for="telefono" class="control-label col-xs-4">Teléfono Celular: </label>
                    <input type="text" maxlength="9" name="telefono" placeholder="Ingresa tu telefono" class="form-control"/> 
                    
                    <label for="direccion" class="control-label col-xs-4">Direccion: </label>
                    <input type="text" name="direccion" placeholder="Ingresa tu direccion" class="form-control"/> 
                    
                    <label for="DNI" class="control-label col-xs-4">DNI: </label>
                    <input type="text" maxlength="8" name="DNI" placeholder="Ingresa tu DNI" class="form-control"/> 

                    <label for="password" class="control-label col-xs-4">Contraseña: </label>
                    <input type="password" name="password" placeholder="Ingresa una contraseña" class="form-control"/>

                    <label for="Confpassword" class="control-label col-xs-4">Confirma tu Contraseña: </label>
                    <input type="password" name="Confpassword" placeholder="Cofirma tu contraseña" class="form-control"/>

                    

                    <br>

                    <input type="submit" value="Registrarse" class="btn btn-primary"/><span class="red"></span>
                    <input type="reset" name="limpiar" id="limpiar" value="Limpiar" class="btn btn-primary" />
                </form>
            </div>
        </section>
           
    </body>
</html>
