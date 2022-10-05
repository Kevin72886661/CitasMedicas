package pe.citas.BD.Mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import pe.citas.BD.Interfaces.InterfacePrescripcion;
import pe.citas.modelo.vo.Prescripcion_C;

public class MysqlPrescripcion implements InterfacePrescripcion{

    String INSERTAR="INSERT INTO Prescripcion VALUES (null,?,?,?,?,?)";
    String SELECCIONARPORID = "SELECT idPrescripcion,idPaciente,Receta,Recomendacion,Fecha from prescripcion where idPaciente=?";
        String SELECCIONAR = "SELECT idPrescripcion,Receta,Recomendacion,Fecha,idPaciente from prescripcion";

    
    private Connection conexion;
    private PreparedStatement ps;
    private ResultSet resultado;
    private Statement senten;
    
    @Override
    public ArrayList<Prescripcion_C> valiPrescripcion(int Usuario) {
        ArrayList<Prescripcion_C> listaprescripcion=new ArrayList<>();
        try {
           
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement(SELECCIONARPORID);
          
            ps.setInt(1, Usuario);
            
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {       
               
            Prescripcion_C  presc=new Prescripcion_C();
          
               
                presc.setIdPrescripcion(rs.getInt(1));
                presc.setIdUsuario(rs.getInt(2));
                presc.setReceta(rs.getString(3));
                presc.setRecomendacion(rs.getString(4));
                presc.setFecha(rs.getString(5));
                
                listaprescripcion.add(presc);
            }
            rs.close();
            CerrarConexiones();
        } catch (Exception e) {
            System.out.println("No se pudo validar las credenciales en la base de datos.Mensaje: " + e.getMessage() );
        }
        return listaprescripcion;    
    }

    @Override
    public int insertar(Prescripcion_C p) {
        int result=0;
        try {
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement(INSERTAR);
            
            ps.setInt(1, p.getIdUsuario());
            ps.setInt(2, p.getIdMedico());
            ps.setString(3, p.getReceta());
            ps.setString(4, p.getRecomendacion());
            ps.setString(5, p.getFecha());
            
            
            result=ps.executeUpdate();
            CerrarConexiones();
        } catch (Exception e) {
            System.out.println("No se pudo insertar el registro en la base de datos "+e.getMessage());
        }
        return result;
    }

    @Override
    public void modificar(Prescripcion_C o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Prescripcion_C o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Prescripcion_C obtenerporId(Integer k) {
        Prescripcion_C p = new Prescripcion_C();
        try {
           conexion = new MysqlConexion().getConnection();
           senten = conexion.createStatement(); 
           String pedido ="select idPrescripcion,idPaciente,Receta,Recomendacion,Fecha from prescripcion where idPrescripcion="+k;
           
           resultado = senten.executeQuery(pedido);
           if (resultado.next()) { 
               
                p.setIdPrescripcion(resultado.getInt(1));
                p.setIdUsuario(resultado.getInt(2));
                p.setReceta(resultado.getString(3));
                p.setRecomendacion(resultado.getString(4));
                p.setFecha(resultado.getString(5));
                
           
                
           }    
         
           CerrarConexiones();
        } catch (Exception e) {
                System.out.println("No se pudo obtener la historia de la base de datos. Mensaje: "+ e.getMessage());
        }
    
        return p;
    }

    @Override
    public ArrayList<Prescripcion_C> listar() {
        ArrayList<Prescripcion_C> listaPrescripcion=new ArrayList<>();
        try {
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement(SELECCIONAR);
            resultado=ps.executeQuery();
            
                while (resultado.next()) {
                    Prescripcion_C presc=new Prescripcion_C();
                    
                    presc.setIdPrescripcion(resultado.getInt(1));
                    presc.setReceta(resultado.getString(2));
                    presc.setRecomendacion(resultado.getString(3));
                    presc.setFecha(resultado.getString(4));
                    presc.setIdUsuario(resultado.getInt(5));
                    
                    listaPrescripcion.add(presc);
                }
            } catch (Exception ex) {
            }
            CerrarConexiones();
            
            return listaPrescripcion;
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
    public boolean actualizarPrescr(Prescripcion_C p) {
        boolean rpta=false;
        
        try {
            conexion=new MysqlConexion().getConnection();
            CallableStatement cl=conexion.prepareCall("{call sp_actualizarPresc(?,?,?,?)}");
            
            cl.setInt(1, p.getIdPrescripcion());
            cl.setString(2, p.getReceta());
            cl.setString(3, p.getRecomendacion());
            cl.setString(4, p.getFecha());
            
            
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
}
