
<%@page import="pe.citas.BD.Mysql.MysqlMedico"%>
<%@page import="pe.citas.BD.Interfaces.InterfaceMedico"%>
<%@page import="pe.citas.modelo.vo.Medico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    InterfaceMedico DaoMedico=null;
    
    DaoMedico=new MysqlMedico();
    
    Medico m=DaoMedico.obtenerporId(Integer.parseInt(request.getParameter("id")));
    
    int e=(int)m.getPerfil_especialidad();
%>    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Medico</title>
        <link rel="stylesheet" type="text/css" href="CSS/estilos.css">
        <link href="CSS/galeria.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/foto.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Slabo+27px" rel="stylesheet">
        <link rel="stylesheet" href=https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css>
        <link rel='shortcut icon' type='image/ico' href='imagenes/feet-1459485_1920.ico'/>
        <link href="./CSS/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/Citas.css" rel="stylesheet" type="text/css"/>
        <script src="JavaScript/jquery-3.3.1.min.js" type="text/javascript"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script>
            $(document).ready(function(){
                $("#especialidad > option[value=<%= e %>]").attr("selected",true);
            });
        </script>
    </head>
    <%@include file='WEB-INF/Partes-estaticas/header.jsp' %>
    <body>
        
        
        <div class="contenedor">
            <div class="contenedor_citas">
            <h2 align="center">Modificar Medico</h2>
                <form action="RegMedico" method="post">
                    ${men}
                    <table class="table">
                        <tr>
                           <td>Id: </td>
                           <td><input type="text" name="txtCodigo" value="<%= m.getId()%>" readonly></td>
                       </tr>
                      <tr>
                           <td>Nombre: </td>
                           <td><input type="text" name="txtNombre" value="<%= m.getNombre()%>" ></td>
                       </tr>

                       <tr>
                         <td>Apellido Paterno: </td>
                         <td><input type="text" name="txtApepat" value="<%= m.getApellidopat()%>"> </td>
                       </tr>

                       <tr>
                           <td>Apellido Materno: </td>
                           <td><input type="text"  name="txtApemat" value="<%= m.getApellidomat()%>"> </td>

                       </tr>
                       
                       <tr>
                           <td>Especialidad: </td>
                           <td><select name="especialidad" id="especialidad" class="form-control" required="true">
                                        <option value="0">Seleccionar</option>
                                        <option value="4">Cardiologia</option>
                                        <option value="2">Dermatología</option>
                                        <option value="3">Gastroenterología</option>
                                        <option value="1">Nutrición</option>
                            </select>
                           </td>   
                       </tr>
                       
                       <tr>
                           <td>Telefono: </td>
                           <td><input type="text"  name="txtTelefono" value="<%= m.getTelefono()%>"> </td>

                       </tr>

                       <tr>
                           <td>Email: </td>
                           <td><input type="text"  name="txtEmail" value="<%= m.getEmail()%>"> </td>

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
