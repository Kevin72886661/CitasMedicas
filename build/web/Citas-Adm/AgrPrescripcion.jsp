<%@page import="pe.citas.modelo.vo.Medico"%>
<%@page import="pe.citas.modelo.vo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
ArrayList<Usuario> listapaciente=null;
    try{
     listapaciente=(ArrayList<Usuario>)session.getAttribute("listaUsuarios");
    }catch(Exception e){
        
    }
    
ArrayList<Medico> listamedico=null;

try{
     listamedico=(ArrayList<Medico>)session.getAttribute("listaMedicos");
    }catch(Exception e){
        
    }
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Prescripcion</title>
        <link rel="stylesheet" type="text/css" href="../CSS/estilos.css">
        <link href="../CSS/Citas.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href="../CSS/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <script src="../JavaScript/jquery-3.3.1.min.js" type="text/javascript"></script>
                <script src="../JavaScript/jquery-ui.js" type="text/javascript"></script>

<script>    
            
            $.datepicker.regional['es'] = {
            closeText: 'Cerrar',
            prevText: '< Ant',
            nextText: 'Sig >',
            currentText: 'Hoy',
            monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
            monthNamesShort: ['Ene','Feb','Mar','Abr', 'May','Jun','Jul','Ago','Sep', 'Oct','Nov','Dic'],
            dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
            dayNamesShort: ['Dom','Lun','Mar','Mié','Juv','Vie','Sáb'],
            dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','Sá'],
            weekHeader: 'Sm',
            dateFormat: 'dd/mm/yy',
            firstDay: 1,
            isRTL: false,
            showMonthAfterYear: false,
            yearSuffix: ''
            };
 $.datepicker.setDefaults($.datepicker.regional['es']);
            
            $(function () {
                $("#txtfecha").datepicker()({
                    changeMonth: true,
                    changeYear: true
                });
            });
            
            
            
        </script> 
    </head>
    <body>
         <%@include file='../WEB-INF/Partes-estaticas/header.jsp'%> 
         <div class="contenedor_citas">
            <div class="centrar">
                ${mensaje}
                <form method="post" action="../Prescripcion">
                    <input type="hidden" name="accion" value="insertar">
                    
                    <div class="row">
                     <div class="col-sm-10">
                        <center>
                           <label>Seleccionar Fecha: </label>
                           <input type="text" name="txtfecha" id="txtfecha"/>
                        </center>
                     </div>
                 </div>   
                    <br>
                    <div class="row">
                        <div class="col-sm-12">
                            <label>Paciente: </label>
                            <select name="idpaciente" class="form-control" required="true">
                                        <option value="0">Seleccione un paciente..</option>
                                        <%for (int i = 0; i < listapaciente.size(); i++) {

                                        %>
                                        <option value="<%=listapaciente.get(i).getId()%>"><%=listapaciente.get(i).getNombre()%> <%=listapaciente.get(i).getApellidopat()%> <%=listapaciente.get(i).getApellidomat()%></option>
                                  <%
                                        }
                                    %> 
                            </select>
                        </div>
                    </div> 
                    <br>
                    
                    <div class="row">
                        <div class="col-sm-12">
                            <label>Medico: </label>
                            <select id="lista2" name="medico" class="form-control">
                                <option value="0">Seleccione un medico..</option>
                                <%for (int i = 0; i < listamedico.size(); i++) {

                                        %>
                                        <option value="<%=listamedico.get(i).getId()%>"><%=listamedico.get(i).getNombre()%> <%=listamedico.get(i).getApellidopat()%> <%=listamedico.get(i).getApellidomat()%></option>
                                  <%
                                        }
                                    %> 
                            </select>
                        </div> 

                    </div>
                            
                            <br>
                    
                    <div class="row">
                        <div class="col-sm-12">
                            <label>Receta medica: </label>
                            <textarea name="receta" class="form-control noresize" maxlength="60" rows="6"></textarea>
                        </div> 

                    </div>
                    <br>
                    <div class="row">
                        <div class="col-sm-12">
                            <label>Recomendaciones del Medico: </label>
                            <textarea name="recomendaciones" class="form-control noresize" maxlength="60" rows="6"></textarea>
                        </div> 

                    </div>
                    <br>
                    <input type="submit" name="accion" class="btn btn-primary" value="Agregar prescripcion" style="margin-right: 5px;">
                    
                </form>
            </div>   
        </div>
    </body>
</html>
