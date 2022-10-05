
package pe.citas.BD.Mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import pe.citas.BD.Interfaces.InterfaceHistoria;
import pe.citas.modelo.vo.HistoriaC;
import pe.citas.modelo.vo.Horario;

public class MysqlHistoria implements InterfaceHistoria {
    
    String INSERTAR="INSERT INTO HISTORIA VALUES (null,?,?,?,?,?,NOW())";
    
    String SELECCIONAR = "SELECT * from Historia";
    
    String SELECCIONARPORID = "SELECT * from Historia where id_usuario=?";
    
    //String SELECCIONARPORIDMEDICO = "SELECT * from Historia where id_medico=?";
    
    String OBTENERPORID = "SELECT * from Historia where id_horario=?";

    private Connection conexion;
    private PreparedStatement ps;
    private ResultSet resultado;
    private Statement senten;
    
    @Override
    public int insertar(HistoriaC historia) {
        int result=0;
        try {
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement(INSERTAR);
            
            ps.setInt(1, historia.getIdpaciente());
            ps.setString(2, historia.getAntecedentes());
            ps.setString(3, historia.getMotivo());
            ps.setString(4, historia.getEnfermedad());
            ps.setString(5, historia.getExamenes());
            
            
            
            result=ps.executeUpdate();
            CerrarConexiones();
        } catch (Exception e) {
            System.out.println("No se pudo insertar el registro en la base de datos "+e.getMessage());
        }
        return result;
    }

    @Override
    public void modificar(HistoriaC o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(HistoriaC o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HistoriaC obtenerporId(Integer h) {
        HistoriaC historia = new HistoriaC();
        try {
           conexion = new MysqlConexion().getConnection();
           senten = conexion.createStatement(); 
           String pedido ="select idHistoria,id_usuario,antecedente,Motivo_consulta,Enfermedad,Examenes,FechCreHist from historia where idHistoria="+h;
           
           resultado = senten.executeQuery(pedido);
           if (resultado.next()) { 
               
                
                historia.setIdHistoria(resultado.getInt(1));
                historia.setIdpaciente(resultado.getInt(2));
                historia.setAntecedentes(resultado.getString(3));
                historia.setMotivo(resultado.getString(4));
                historia.setEnfermedad(resultado.getString(5));
                historia.setExamenes(resultado.getString(6));
                historia.setFechCreHist(resultado.getDate(7));
           
                
           }    
         
           CerrarConexiones();
        } catch (Exception e) {
                System.out.println("No se pudo obtener la historia de la base de datos. Mensaje: "+ e.getMessage());
        }
    
        return historia;
    }

    @Override
    public ArrayList<HistoriaC> listar() {
        ArrayList<HistoriaC> listahistoriaC=new ArrayList<>();
        try {
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement(SELECCIONAR);
            resultado=ps.executeQuery();
            
                while (resultado.next()) {
                    HistoriaC historia=new HistoriaC();
                    
                    historia.setIdHistoria(resultado.getInt(1));
                    historia.setIdpaciente(resultado.getInt(2));
                    historia.setAntecedentes(resultado.getString(3));
                    historia.setMotivo(resultado.getString(4));
                    historia.setEnfermedad(resultado.getString(5));
                    historia.setExamenes(resultado.getString(6));
                    historia.setFechCreHist(resultado.getDate(7));
                    
                    listahistoriaC.add(historia);
                }
            } catch (Exception ex) {
            }
            CerrarConexiones();
            
            return listahistoriaC;
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
    public ArrayList<HistoriaC> valiHistoria(int Usuario) {
        ArrayList<HistoriaC> listaHistoria=new ArrayList<>();
        try {
           
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement(SELECCIONARPORID);
          
            ps.setInt(1, Usuario);
            
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {       
               
            HistoriaC  historia=new HistoriaC();
          
               
                historia.setIdHistoria(rs.getInt(1));
                historia.setIdpaciente(rs.getInt(2));
                historia.setAntecedentes(rs.getString(3));
                historia.setMotivo(rs.getString(4));
                historia.setEnfermedad(rs.getString(5));
                historia.setExamenes(rs.getString(6));
                historia.setFechCreHist(rs.getDate(7));
                
                listaHistoria.add(historia);
            }
            rs.close();
            CerrarConexiones();
        } catch (Exception e) {
            System.out.println("No se pudo validar las credenciales en la base de datos.Mensaje: " + e.getMessage() );
        }
        return listaHistoria;    
    }
    

    @Override
    public boolean actualizarHistoria(HistoriaC h) {
        boolean rpta=false;
        
        try {
            conexion=new MysqlConexion().getConnection();
            CallableStatement cl=conexion.prepareCall("{call sp_actualizarHist(?,?,?,?,?)}");
            
            cl.setInt(1, h.getIdHistoria());
            cl.setString(2, h.getAntecedentes());
            cl.setString(3, h.getMotivo());
            cl.setString(4, h.getEnfermedad());
            cl.setString(5, h.getExamenes());
            
            
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
