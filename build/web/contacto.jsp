<%-- 
    Document   : contacto
    Created on : 12-oct-2018, 9:58:06
    Author     : casa
--%>
<%@page import="pe.citas.modelo.vo.Usuario"%>
<%
    Usuario usuario=null;
    try{
     usuario=(Usuario)session.getAttribute("Usuario");
    }catch(Exception e){
        
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aplicacion</title>
        <link rel="stylesheet" type="text/css" href="CSS/estilos.css">
        <link rel="stylesheet" type="text/css" href="CSS/contact.css">
        <link href="CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        
            <%@include file='WEB-INF/Partes-estaticas/header.jsp'%> 
        
        <div class="container">
        <section class="mainmap">  
            <section class="mapa">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3900.9818343784395!2d-77.03035028507001!3d-12.113395346441928!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x9105c814026bad6f%3A0xca7e38f063046d29!2sHospital+EsSalud+Angamos!5e0!3m2!1ses-419!2spe!4v1539714625206" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
            </section> 
            
        </section>
            
            
                <div class="contenedorfooter">
                    <section class="contacto">
                        <h3>Titulo</h3>
                        <form class="formulario">
                            <input type="text" placeholder="Nombre" name="nombre" required>
                            <input type="email" placeholder="Correo" name="correo" required>
                            <textarea name="mensaje" placeholder="Mensaje: "></textarea>
                            <input class="boton" type="submit" value="Enviar">
                        </form>
                    </section>
                </div>
              <%@include file="WEB-INF/Partes-estaticas/footer.jsp" %> 
        </div>   
        
            
    </body>
</html>

