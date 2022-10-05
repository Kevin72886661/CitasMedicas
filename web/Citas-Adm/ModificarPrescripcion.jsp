<%-- 
    Document   : ModificarHistoria
    Created on : 05/11/2019, 07:54:25 PM
    Author     : juan
--%>

<%@page import="pe.citas.modelo.vo.Prescripcion_C"%>
<%@page import="pe.citas.BD.Mysql.MysqlPrescripcion"%>
<%@page import="pe.citas.BD.Interfaces.InterfacePrescripcion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    InterfacePrescripcion DaoPrescripcion=null;
    
    DaoPrescripcion=new MysqlPrescripcion();
    
    Prescripcion_C pr=DaoPrescripcion.obtenerporId(Integer.parseInt(request.getParameter("id")));
    
%>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="CSS/foto.css" rel="stylesheet" type="text/css"/>
         <link href="CSS/galeria.css" rel="stylesheet" type="text/css"/>

        <link href="https://fonts.googleapis.com/css?family=Slabo+27px" rel="stylesheet">
        <link rel="stylesheet" href=https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css>
        <link rel='shortcut icon' type='image/ico' href='imagenes/feet-1459485_1920.ico'/>
        <link href="./CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/Citas.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="contenedor">
            <div class="contenedor_citas">
            <h2 align="center">Modificar Medico</h2>
                <form action="RegMedico" method="post">
                    ${men}
                    <table class="table">
                        <tr>
                           <td>Id: </td>
                           <td><input type="text" name="txtCodigo" value="<%= pr.getIdUsuario()%>" readonly></td>
                       </tr>
                      <tr>
                           <td>Receta: </td>
                           <td><input type="text" name="txtNombre" value="<%= pr.getReceta()%>" ></td>
                       </tr>

                       <tr>
                         <td>Recomendacion: </td>
                         <td><input type="text" name="txtApepat" value="<%= pr.getRecomendacion()%>"> </td>
                       </tr>

                       <tr>
                           <td>Fecha: </td>
                           <td><input type="text"  name="txtApemat" value="<%= pr.getFecha()%>"> </td>

                       </tr>
                       
                       
                       <tr>
                           <th colspan="2"><button class="btn btn-primary" type="submit" name="accion" value="ModificarMedico" />ModificarMedico</th>
                       </tr>
                       
                   </table> 
                          
                </form>
                            </div> 
        </div> 
    </body>
</html>
