<%-- 
    Document   : index
    Created on : 12-oct-2018, 9:54:09
    Author     : casa
--%>

<%@page import="pe.citas.modelo.vo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario usuario=null;
    try{
     usuario=(Usuario)session.getAttribute("Usuario");
    }catch(Exception e){
        
    }
%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portal de Citas Medicas</title>
        <link rel="stylesheet" type="text/css" href="CSS/estilos.css">
        <link rel="stylesheet" href="css/normalize.css">
        <link rel='shortcut icon' type='image/ico' href='imagenes/icon.png'/>
    </head>
    <body>
        
        
            <%@include file='WEB-INF/Partes-estaticas/header.jsp'%> 
            
               <div class="hero"></div>
     
        
           <div class="contenedor">
            <section class="fondo mainInicio">
                <section class="posts">
                    <article>
                            
                            <div class="imagen">
                                <p>Red de Hospitales</p>
                                <img class="img" src="imagenes/ambu.jpg">
                            </div>
                    </article>
                </section>
            </section> 
            <section class="fondo mainInicio">
                <section class="posts">
                    <article>
                            
                            <div class="imagen">
                                <p>Servicios</p>
                                <img class="img" src="imagenes/services.jpg">
                            </div>
                    </article>
                </section>
            </section> 
               

            <aside>
                <div class="widget">
                    <h3 class="titulohosp">CLÍNICA D'MARIELLA</h3>
                    <div class="imagen">
                        <center><img class="img" src="imagenes/dmari.PNG" alt="imagen"></center>
                    </div>
                    <br>
                        <p>La Clínica D'Mariella es un centro hospitalario privado
                            peruano administrado por La Doctora Mariella Zavala. Fundado por La Doctora del Perú, 
                            de experiencia ofreciendo un servicio integral y de calidad, con el más destacado staff médico del país, 
                            moderna infraestructura y tecnología al servicio de nuestros pacientes con la confianza y seguridad de siempre.</p>
                        
                   
                </div>

            </aside>   
               
        </div>  
             
            
    </body>
</html>