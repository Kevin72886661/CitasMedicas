
<%@page contentType="text/html" pageEncoding="UTF-8"%>
   <%
   
    
    HttpSession sesionOK=request.getSession();
    String nom="";    
if(sesionOK.getAttribute("perfil")!=null)
    nom=(String)sesionOK.getAttribute("nom")+" "+(String)sesionOK.getAttribute("ape");
    %>
    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loguin Medico</title>
        
        <link rel="stylesheet" type="text/css" href="CSS/login.css"  />
        <link href="CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/style.css" rel="stylesheet" type="text/css"/>
        <link rel='shortcut icon' type='image/ico' href='imagenes/icon.png'/>
        <script src="JavaScript/login.js" type="text/javascript"></script>
        <script src="JavaScript/bootstrap.min.js" type="text/javascript"></script>
        <script src="JavaScript/jquery.js" type="text/javascript"></script>
        <script src="JavaScript/main.js"></script>
    </head>
    <body>
            
            <header>
                <img src="imagenes/logo2.png" class="logo" alt="logo">     
            </header>
    
            
                <div class="form-group">
                    <h2 style="text-align: center ;color:#fff;">Loguin Medico</h2>
                    <form name="form1" method="post" action="ServletLogueo" onsubmit="return validar()">
                        <input type="hidden" name="accion" value="loguinmedico">
                        <label for="usuario" class="control-label col-xs-4">Usuario: </label>
                        <input type="text" name="usuario" placeholder="Usuario" class="form-control"/>
                        <br>
                        <label for="Clave" class="control-label col-xs-4">Contraseña: </label>
                        <input type="password" name="clave" placeholder="Contraseña" class="form-control"/>

                        <br>
                        <%
                        if(request.getAttribute("msg")!=null){

                       %>
                        <span class="red"><%out.println(request.getAttribute("msg"));%></span>
                        
                         <%
                            }
                            %>
                        <input type="submit" value="Entrar" class="btn btn-primary"/>
                        <br>
                        <br>
                        <input type="reset" name="limpiar" id="limpiar" value="Limpiar" class="btn btn-primary"/>
                        <div class="texto">¿Primera vez en la pagina? <a href="Registro.jsp" class="enlaceRojo">Registrate</a></div>
                    </form>
                </div>

    </body>
</html>
