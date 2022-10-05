/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.citas.BD.Mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class MysqlConexion {
    
    String url="jdbc:mysql://localhost:3306/bdcitas";
    String user="root";
    String contra="";
    
    public Connection getConnection(){
        
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, contra);
            
            
            conn.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println("No se pudo generar la conexión. Mensaje: " + e.getMessage());
        }
        return conn;
    }    
}
