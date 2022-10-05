<%-- 
    Document   : DetHistoria
    Created on : 25/10/2019, 10:12:28 AM
    Author     : juan
--%>

<%@page import="pe.citas.BD.Mysql.MysqlUsuario"%>
<%@page import="pe.citas.BD.Interfaces.InterfaceUsuario"%>
<%@page import="pe.citas.modelo.vo.Usuario"%>
<%@page import="pe.citas.modelo.vo.HistoriaC"%>
<%@page import="pe.citas.servlets.Usuario.Historia"%>
<%@page import="pe.citas.BD.Mysql.MysqlHistoria"%>
<%@page import="pe.citas.BD.Interfaces.InterfaceHistoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    
    InterfaceHistoria DaoHistoria=new MysqlHistoria();
    
    InterfaceUsuario DaoUsuario=new MysqlUsuario();
    
    
    HistoriaC h=DaoHistoria.obtenerporId(Integer.parseInt(request.getParameter("id")));
   
    int idpaciente=h.getIdpaciente();
    
    Usuario u=DaoUsuario.obtenerporId(idpaciente);
%>    
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Historia Clinica</title>
         <link rel="stylesheet" type="text/css" href="CSS/estilos.css">
        <link href="CSS/Citas.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/medicos.css" rel="stylesheet" type="text/css"/>
        <style>
            tr{
                height:  90px;
            }
            
            td{
                text-align: center;
            }
            
            th{
                text-align: center;
                color: #137ff3;
                font-size: 17px;
                font-weight: bold;
            }
                        

        </style>
    </head>
    <body>
        <%@include file='WEB-INF/Partes-estaticas/header.jsp'%> 
        <div class="contenedor">
            <div class="contenedor_citas">
            <h2 align="center">CLÍNICA D'MARIELLA</h2>
                    
            <p style="text-align: center; font-size: 16px; font-weight: lighter;">Avenida San Miguel 848, Cercado de Lima</p>
            <center>
             <img style="width: 200px; margin: auto; margin:5px 0px 5px 0px;"  src="imagenes/12.PNG" alt=""/>
            </center>
            
            <h3 style="text-align: center; font-size: 19px; font-weight: bold; border-bottom: 3px #137ff3 solid">Historia Clinica N° <%= h.getIdHistoria()%></h3>
            <br>
            <div class="row">
                <div class="col-sm-6" >
                    <label style="font-size: 20px; text-align: center;">Datos del Paciente</label>
                </div>
            </div>
                    <div class="row">
                        
                        <div class="col-sm-4" >
                            <label class="control-label align-self-center">Nombre:</label>
                           <%= u.getNombre()%>
                        </div>   
                           <div class="col-sm-4">
                            <label> Medico:</label> 
                            Pedro Altamiza
                           </div>
                        <div class="col-sm-4">
                            <label> Fecha de creacion: </label> 
                            <%= h.getFechCreHist()%>
                           </div>
                    </div>  
                           
                   <div class="row">
                       <div class="col-sm-4">
                        <label> Apellidos:</label> 
                        <%= u.getApellidopat()%> <%= u.getApellidomat()%>
                       </div>
                       <div class="col-sm-4">
                            <label> Especialidad:</label> 
                            Nutricion
                           </div>
                   </div> 
                       <div class="row">
                           <div class="col-sm-6">
                           <label>DNI: </label> 
                           <%= u.getDNI()%>
                           </div>
                       </div>
                       <div class="row">
                           <div class="col-sm-6">
                           <label>Direccion: </label> 
                           <%= u.getDireccion()%>
                           </div>
                       </div>
                       
                       <div class="row">
                           <div class="col-sm-6">
                           <label>Telefono: </label> 
                           <%= u.getTelefono()%>
                            </div>
                       </div>
                       
                       <h3 style="color:#137ff3;text-align: center; font-size: 19px; font-weight: bold; border-bottom: 3px #137ff3 solid">Anamnesis N° <%= u.getId()%></h3>
                       <br>
                       <table class="table table-striped table-hover">
                           <tr>
                               <th>Antecedentes: </th>
                           <td><%= h.getAntecedentes()%></td>
                            </tr>

                       <tr>
                         <th>Enfermedad actual: </th>
                         <td><%= h.getEnfermedad()%></td>
                       </tr>

                       <tr>
                           <th>Motivo de la consulta: </th>
                           <td><%= h.getMotivo()%></td>

                       </tr>
                       
                       <tr>
                           <th>Examenes: </th>
                           <td><%= h.getExamenes()%></td>

                       </tr>
                       </table>
                       
                    <label class="detalles2"><a class="btn btn-primary" href="pdfHist.jsp?idHistoria=<%=h.getIdHistoria()%>">Generar Reporte</a></label>                          
            </div>
               
        </div>         
    </body>
</html>
