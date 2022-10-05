<%@page import="pe.citas.BD.Mysql.MysqlEspecialidad"%>
<%@page import="pe.citas.BD.Interfaces.InterfaceEspecialidad"%>
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
    
   
    HttpSession sesion=request.getSession();
    InterfaceEspecialidad DaoEspeci=new MysqlEspecialidad();

    ArrayList<Especialidad> listaesp = DaoEspeci.listar();

    sesion.setAttribute("listaesp", listaesp);
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Citas</title>
        <link href="CSS/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/Citas.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="CSS/medicos.css" rel="stylesheet" type="text/css"/>

        <link href="CSS/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <script src="JavaScript/jquery-3.3.1.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">

<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
        <script src="JavaScript/jquery-ui.js" type="text/javascript"></script>

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
            $(document).ready(function(){
                $('#hora').timepicker({
                    timeFormat: 'HH:mm',
                    interval: 60,
                    minTime: '7',
                    maxTime: '6:00pm',
                    defaultTime: '11',
                    startTime: '7:00',
                    use24hours: true,
                    dynamic: false,
                    dropdown: true,
                    scrollbar: true
                });
            });
            
        </script>    
    </head>
    <body>
                <%@include file='WEB-INF/Partes-estaticas/header.jsp'%> 

        

        <div class="contenedor_citas">
            <div class="centrar">
            <p class="titulocita">Registrar Cita</p>
            
             <form id="form_buscar" method="post" action="Horarios">
                     <input type="hidden" name="accion" value="insertar">
                        ${mensaje}
                       <div class="row">
                            <div class="col-sm-10">
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
                     <div class="col-sm-10">
                         <label>Medico</label>
                         <br>
                         <select id="lista2" name="lista2" class="form-control">
                            
                        </select>
                     </div>    
                 </div>
                 <br>
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
                     <div class="col-sm-10">
                        <center>
                           <label>Seleccionar Hora: </label>
                           <input type="text" name="timepicker" id="hora"/>
                        </center>
                     </div>
                 </div>
                        <br>
                        <input type="submit" class="btn btn-primary botoncita" value="Registrar"></button>
                        <br>
                        <br>
                        <span class="red"><%=mensaje1%></span>
                        
              </form>  
            </div>
        </div>    
    </body>
</html>
