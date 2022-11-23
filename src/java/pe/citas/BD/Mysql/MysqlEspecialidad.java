package pe.citas.BD.Mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import pe.citas.BD.Interfaces.InterfaceEspecialidad;
import pe.citas.modelo.vo.Especialidad;

public class MysqlEspecialidad implements InterfaceEspecialidad{
    
    String OBTENER="SELECT idespecialidad,NomEspecilidad from ESPECIALIDAD";
    String VALIDAR2="SELECT * FROM ESPECIALIDAD WHERE NomEspecilidad=?";
    String INSERTAR="INSERT INTO ESPECIALIDAD VALUES (null,?)";

            
    private Connection conexion;
    private PreparedStatement ps;
    private ResultSet resultado;
    private Statement senten;
    
    @Override
    public ArrayList<Especialidad> listar() {
        ArrayList<Especialidad> listaMedicos=new ArrayList<>();
        try {
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement(OBTENER);
            resultado=ps.executeQuery();
            
            while (resultado.next()) {                
                Especialidad objEsp=new Especialidad();
                
                objEsp.setIdespecialidad(resultado.getInt(1));
                objEsp.setNomEspecialidad(resultado.getString(2));
           
                listaMedicos.add(objEsp);
            }
            CerrarConexiones();
            
        } catch (Exception e) {
            System.out.println("No se pudo obtener los registros de los usuarios de la base de datos"+e.getMessage());
        }
        return listaMedicos;
    }

    @Override
    public int insertar(Especialidad o) {
        int result=0;
        try {
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement(INSERTAR);
            
            ps.setString(1, o.getNomEspecialidad());
            
            result=ps.executeUpdate();
            CerrarConexiones();
        } catch (Exception e) {
            System.out.println("No se pudo insertar el registro en la base de datos "+e.getMessage());
        }
        return result;
    }

    @Override
    public void modificar(Especialidad o) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void eliminar(Especialidad o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Especialidad obtenerporId(Integer k) {
        Especialidad esp = new Especialidad();
        try {
           conexion = new MysqlConexion().getConnection();
           senten = conexion.createStatement(); 
           String pedido ="select * from especialidad where idespecialidad="+k;
           
           resultado = senten.executeQuery(pedido);
           if (resultado.next()) { 
               
                
                esp.setIdespecialidad(resultado.getInt(1));
                esp.setNomEspecialidad(resultado.getString(2));
           
                
           }    
         
           CerrarConexiones();
        } catch (SQLException e) {
                System.out.println("No se pudo obtener el perfil producto de la base de datos. Mensaje: "+ e.getMessage());
        }
    
        return esp;
    }
  
    
    public void CerrarConexiones(){
        try {
            if (resultado!=null) {
            resultado.close();
            }
            if (ps!=null) {
                ps.close();
            }
            if (conexion!=null) {
                conexion.close();
            }
        } catch (Exception e) {
        }
        
    }

    @Override
    public Especialidad valiEspecialidad(String Especialidad) {
        Especialidad objEsp=null;
        try {
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement(VALIDAR2);
            
            ps.setString(1, Especialidad);
            
            
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {                
                objEsp=new Especialidad();
                
                objEsp.setIdespecialidad(rs.getInt(1));
                objEsp.setNomEspecialidad(rs.getString(2));
               
                
            }
            rs.close();
            CerrarConexiones();
        } catch (Exception e) {
            System.out.println("No se pudo validar las credenciales en la base de datos.Mensaje: " + e.getMessage() );
        }
        return objEsp;    
    }

    @Override
    public boolean actualizarEspecialidad(Especialidad esp) {
        boolean rpta=false;
        
        try {
            conexion=new MysqlConexion().getConnection();
            CallableStatement cl=conexion.prepareCall("{call sp_actualizarEspec(?,?)}");
            
            cl.setInt(1, esp.getIdespecialidad());
            cl.setString(2, esp.getNomEspecialidad());
                       
             int i=cl.executeUpdate();
             
             if (i==1) {
                rpta=true;
            }else{
                 rpta=false;
             }
            
           CerrarConexiones();
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }
        
        return rpta;    
    }

    @Override
    public int eliminar2(Integer idespecialidad) {
        int valor=0;
        try {
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement("DELETE FROM especialidad WHERE idespecialidad ="+idespecialidad);
            valor=ps.executeUpdate();
            
            } catch (SQLException ex) {
            }
            CerrarConexiones();
        return valor;
    }
    
    
}
