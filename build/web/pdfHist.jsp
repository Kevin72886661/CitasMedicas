<%-- 
    Document   : pdf
    Created on : 23/01/2016, 03:31:22 PM
    Author     : Ingeniero
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
        <title>Reporte de Historias Clinicas</title>
    </head>
    <body>
       
        <%
        File reportfile = new File (application.getRealPath("/Reportes/historia.jasper"));
        
        Map<String,Object> parameter = new HashMap<String,Object>();
        
        int valor=Integer.parseInt(request.getParameter("idHistoria")); 
        
        parameter.put("idhist", new Integer(valor));
        
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
