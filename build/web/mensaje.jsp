<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>

<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pet Lovers Creaciones</title>
        <link rel="stylesheet" type="text/css" href="CSS/estilos.css">
        <link rel='shortcut icon' type='image/ico' href='imagenes/feet-1459485_1920.ico'/>
        <link href="./CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    </head>
    <body>
        
        <%@include file='WEB-INF/Partes-estaticas/header.jsp' %>
        
        <div class="container">
            <h2 align="center">
             <%
                 if(request.getParameter("men")!=null){                               
                    out.println(request.getParameter("men"));
                  }
             %>
            </h2>
            <h3 align="center">
                <a href="inicio.jsp">Volver a Principal</a>
            </h3>


        </div>
    </body>
</html>
