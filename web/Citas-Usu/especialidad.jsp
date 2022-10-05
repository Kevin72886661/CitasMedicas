<%@page import="java.util.ArrayList"%>
<%@page import="pe.citas.modelo.vo.Especialidad"%>
<%@page import="pe.citas.modelo.vo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String mensaje1=request.getParameter("mensaje1");
    if(mensaje1==null)
    mensaje1="";
    Usuario usuario=null;
    try{
     usuario=(Usuario)session.getAttribute("Usuario");
    }catch(Exception e){
        
    }
    
    ArrayList<Especialidad> listaesp=null;
    try{
     listaesp=(ArrayList<Especialidad>)session.getAttribute("listaEspecialidad");
    }catch(Exception e){
        
    }
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Citas</title>
        <link href="../CSS/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="../CSS/Citas.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="../CSS/medicos.css" rel="stylesheet" type="text/css"/>
        <script src="../JavaScript/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script>    
            $(document).ready(function(){
                $('#select1').change(function(){
                    var selected = $('#select1').val();
                    let lista2 = $('#lista2');
                    lista2.empty();
                    lista2.append('<option selected="true" disabled> Seleccione un medico...</option>');
                    lista2.prop('selectIndex',0);

                    $.getJSON("../Lista?selected="+selected,function(result){
                        $.each(result.opciones,function(i,field){
                            lista2.append($('<option value="field.opcion_valor"></option>').attr('value',field.opcion_valor).text(field.opcion_texto));
                        });
                    });
                });
            });
            
            
        </script>    
    </head>
    <body>
        <jsp:include page="../WEB-INF/Partes-estaticas/header.jsp" >
              <jsp:param name="valor" value="<%=usuario.getPerfil_usuario_id()%>"/>
            </jsp:include>
        
        
        <div class="contenedor_citas">
            <table class="table table-striped table-bordered table-hover">
                <tr>
                    <td>DNI:</td>
                    <td><%=usuario.getDNI()%></td>
                </tr>
                <tr>
                    <td>Nombres:</td>
                    <td><%=usuario.getNombre()%></td>
                </tr>
                <tr>
                    <td>Apellido Paterno:</td>
                    <td><%=usuario.getApellidopat()%></td>
                </tr>

                <tr>
                    <td>Apellido Materno: </td>
                    <td><%=usuario.getApellidomat()%></td>
                </tr>

                <tr>
                    <td>Email:</td>
                    <td><%=usuario.getEmail()%></td>
                </tr>
                <tr>
                    <td>Dirección:</td>
                    <td><%=usuario.getDireccion()%></td>
                </tr>
            </table>
            
            <p class="titulocita">Selecciona un Medico</p>
            
             
             <p class="green">Buscar un Medico por: </p>
             
             <form id="form_buscar" method="post" action="../Horarios">
                        <input type="hidden" name="accion" value="consultar">
                        <div class="row">
                            <div class="col-sm-4">
                                <label>Especialidad</label>
                                
 
                                <select id="select1" name="especialidad" class="form-control" required="true">
                                    <option value="">Seleccione una especialidad...</option>
                                    <%for (int i = 0; i < listaesp.size(); i++) {

                                     %>
                                    <option value="<%=listaesp.get(i).getIdespecialidad()%>"><%=listaesp.get(i).getNomEspecialidad()%></option>
                                  <%
                                        }
                                    %> 
                                </select>
                                
                                    
                                
                                
                            </div> 
                            
                            
                        </div> 
                 <br>
                 
                 <div class="row">
                     <div class="col-sm-4">
                         <label>Selecciona tu medico: </label>
                         <br>
                         <select id="lista2" name="lista2" class="form-control">
                            
                        </select>
                     </div>    
                 </div>
                        <br>
                        <input type="submit" class="btn btn-primary botoncita" value="Continuar"></button>
                        <br>
                        <br>
                        <span class="red"><%=mensaje1%></span>
              </form>  
             
        </div>    
    </body>
</html>
