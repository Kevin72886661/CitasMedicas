<%-- 
    Document   : doctores
    Created on : 30-oct-2018, 19:43:47
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
        <title>Agregar Medicos</title>
         <link rel="stylesheet" type="text/css" href="CSS/estilos.css">
        <link href="CSS/Citas.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
     
    </head>
    <body>
                
        <%@include file='WEB-INF/Partes-estaticas/header.jsp'%> 

        
        <div class="contenedor_citas">
            <div class="centrar">
                ${mensaje}
                <form method="post" action="RegMedico">
                    <input type="hidden" name="id" value = "3">
                    <div class="row">
                        <div class="col-sm-12">
                            <label>Especialidad medica: </label>
                            <select name="especialidad" class="form-control" required="true">
                                        <option value="0">Seleccionar</option>
                                        <option value="1">Odontologia General</option>
                                        <option value="2">Cirugía oral y maxilofacial</option>
                                        <option value="3">Endodoncia</option>
                                        <option value="4">Odontología estética</option>
                                        <option value="5">Odontopediatría</option>
                                        <option value="6">Ortodoncia</option>
                                        <option value="7">Patología bucal</option>
                                        <option value="8">Periodoncia</option>
                                        <option value="9">Prostodoncia y rehabilitación oral</option>
                                        <option value="10">Radiología oral y maxilofacial</option>
                            </select>
                        </div>
                    </div> 
                    <br>
                    
                    <div class="row">
                        <div class="col-sm-12">
                            <label>Nombres: </label>
                            <input name="NomMedico" class="form-control" type="text" required>
                        </div> 

                    </div>
                    <br>
                    <div class="row">
                        <div class="col-sm-12">
                            <label>Apellido paterno: </label>
                            <input name="apepat" class="form-control" type="text" required>
                        </div> 

                    </div>
                    
                    <br>
                    <div class="row">
                        <div class="col-sm-12">
                            <label>Apellido materno: </label>
                            <input name="apemat" class="form-control" type="text" required>
                        </div> 

                    </div>
                    
                    <br>
                    <div class="row">
                        <div class="col-sm-12">
                            <label>Nro de contacto: </label>
                            <input name="NumeroMed" class="form-control" type="text" maxlength="9" required>
                        </div> 

                    </div>
                    
                    <br>
                    <div class="row">
                        <div class="col-sm-12">
                            <label>Email: </label>
                            <input name="EmailMed" class="form-control" type="email" required>
                        </div> 

                    </div>
                    
                    <br>
                    <div class="row">
                        <div class="col-sm-12">
                            <label>Contraseña: </label>
                            <input name="Contraseña" class="form-control" type="password" required>
                        </div> 

                    </div>
                    
                    <br>
                    <div class="row">
                        <div class="col-sm-12">
                            <label>Confirmar Contraseña: </label>
                            <input name="ConfContraseña" class="form-control" type="password" required>
                        </div> 

                    </div>
                    <br>
                    
                  
                    <br>
                    <input type="submit" name="accion" class="btn btn-primary" value="Agregar" style="margin-right: 5px;">
                    
                </form>
            </div>   
        </div>
        
        
    </body>
</html>
