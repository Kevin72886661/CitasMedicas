<%@page import="pe.citas.modelo.vo.Horario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pe.citas.modelo.vo.Usuario"%>
<%@page import="pe.citas.modelo.vo.Especialidad"%>
<%@page import="pe.citas.modelo.vo.Medico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Medico medico=null;
    try{
     medico=(Medico)session.getAttribute("medico");
    }catch(Exception e){
        System.out.println("Error"+e.getMessage());
    }
    
    Especialidad especialidad=null;
    try{
     especialidad=(Especialidad)session.getAttribute("espec");
    }catch(Exception e){
        System.out.println("Error"+e.getMessage());
    }
    
    
    ArrayList<Horario> listahorario=null;
    try{
     listahorario=(ArrayList<Horario>)session.getAttribute("listaHorario");
    }catch(Exception e){
        
    }
    
    Usuario usuario=null;
    try{
     usuario=(Usuario)session.getAttribute("Usuario");
    }catch(Exception e){
        
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de horarios</title>
        <link href="CSS/estilos.css" rel="stylesheet" type="text/css"/>
        
        <link href="CSS/Citas.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/medicos.css" rel="stylesheet" type="text/css"/>
        <script src="JavaScript/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="JavaScript/jquery-ui.js" type="text/javascript"></script>
        <link href="CSS/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <style>
            .event a {
                background-color: #5FBA7D !important;
                color: #ffffff !important;
            }
        </style>
        
    </head>
    <body>
        
         <jsp:include page="WEB-INF/Partes-estaticas/header.jsp" >
              <jsp:param name="valor" value="<%=usuario.getPerfil_usuario_id()%>"/>
        </jsp:include>
        
        
        <div class="contenedor_citas">
            
            
           <form method="post" action="Cita">
               
               <input type="hidden" name="accion" value="insertar">
               
                <div class="row">

                    <div class="col-sm-4" >



                                <div class="contenedor-det">
                                    <p class="titulocita">Selecciona un Horario</p>
                                    <p class="green">Horarios disponibles: </p>
                                    <input type="hidden" name="id_especialidad" value ="<%=especialidad.getIdespecialidad()%>">
                                    <input type="hidden" name="id_usuario" value ="<%=usuario.getId()%>">
                                    <input type="hidden" name="id_medico" value ="<%=medico.getId()%>">
                                    <select class="combohorarios" name="id_horario" id="modelo" class="form-control">
                                    <option value="-1">Horarios...</option>
                                    <%
                                    for(Horario horario : listahorario){
                                    %>
                                    <option value="<%=horario.getIdHorario()%>"><%=horario.getDia()%>  <%=horario.getHora()%></option>
                                    
                                    <%
                                    }
                                    %>
                                     
                                    
                                    
                                </select>
                                    <label class="detalles2"></label>
                                </div>
                                    
                                     
                                    
                                <div class="row">
                                    <div class="contenedor-det">
                                    <input type="submit" class="botonreserva btn btn-success" value="Seleccionar Horario">
                                    </div>
                                </div>   
                                    
        
                    </div>

          

                </div>
                                    
                             
                                    
           </form>                    
        </div>
  
    </body>
</html>
