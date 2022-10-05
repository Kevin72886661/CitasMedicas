<%@page import="pe.citas.modelo.vo.Horario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pe.citas.modelo.vo.Usuario"%>
<%@page import="pe.citas.modelo.vo.Especialidad"%>
<%@page import="pe.citas.modelo.vo.Medico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Medico medico=null;
    try{
     medico=(Medico)session.getAttribute("Medico");
    }catch(Exception e){
        
    }
    
    Especialidad lisEspecialidad=null;
    try{
     lisEspecialidad=(Especialidad)session.getAttribute("Especialidad");
    }catch(Exception e){
        
    }
    
    ArrayList<Medico> listamedico=null;
    try{
     listamedico=(ArrayList<Medico>)session.getAttribute("listaMedicos");
    }catch(Exception e){
        
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
        <title>JSP Page</title>
        <link href="CSS/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/medicos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="WEB-INF/Partes-estaticas/header.jsp" >
              <jsp:param name="valor" value="<%=usuario.getPerfil_usuario_id()%>"/>
        </jsp:include>
        
         <%
             
                for (int i = 0; i < listamedico.size(); i++) {
          

            %>
        
        <div class="container-medico">
            <div class="imagen-medico">
                
                <img src="imagenes/imagen1.png" alt=""/>
            </div>
            
           <form method="post" action="Horarios">
               <input type="hidden" name="idmedico" value = "<%=listamedico.get(i).getId()%>">
                <div class="row">

                    <div class="col-sm-4" >

                        <h1 class="nombre_medico"><%=listamedico.get(i).getNombre()+"  "%><%=listamedico.get(i).getApellidopat()+"  "%><%=listamedico.get(i).getApellidomat()+"  "%></h1>


                                <div class="contenedor-det">
                                    
                                    <label class="detalles2"></label>
                                </div>
                                    <input type="number" id="deli" value="1" name="num" placeholder="0" required="" style="width:  100%" hidden>
                                    <input type="radio" value="<%=listamedico.get(i).getId()%>" name="Medico_elegido" checked hidden >
        
                    </div>

                    <div class="col-sm-4">

                    </div>
                    <div class="col-sm-4">
                        <input type="submit" class="botonreserva btn btn-success" value="Seleccionar Medico">
                    </div>

                           

                </div>
                                    
           </form>                    
        </div>
 <%
                                    }
                                %>   

        
    </body>
</html>
