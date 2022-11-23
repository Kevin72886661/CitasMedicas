<%-- 
    Document   : pdfPresc
    Created on : 06/12/2019, 08:34:52 AM
    Author     : juan
--%>

<%@page import="java.sql.Connection"%>
<%@page import="pe.citas.BD.Mysql.MysqlConexion"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>

<%@page import="net.sf.jasperreports.engine.*"%>
<%@page import="net.sf.jasperreports.view.JasperViewer"%>

<%@page import="javax.servlet.ServletResponse"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte de Prescripcion Medica</title>
    </head>
    <body>
         <%
        File reportfile = new File (application.getRealPath("/Reportes2/prescripcion.jasper"));
        
        Map<String,Object> parameter = new HashMap<String,Object>();
        
        int valor=Integer.parseInt(request.getParameter("idPres")); 
        
        parameter.put("idPrescripcion", new Integer(valor));
        
        MysqlConexion DaoConexion=new MysqlConexion();
        
        Connection conn=DaoConexion.getConnection();
        
        //String valor = request.getParameter("txtparametro");
        //parameter.put("mar",new String(valor));
        
        byte[] bytes = JasperRunManager.runReportToPdf(reportfile.getPath(), parameter, conn);
        
        response.setContentType("application/pdf");
        response.setContentLength(bytes.length);
        ServletOutputStream outputstream = response.getOutputStream();
        outputstream.write(bytes,0,bytes.length);
        
        outputstream.flush();
        outputstream.close();
        %>
    </body>
</html>
