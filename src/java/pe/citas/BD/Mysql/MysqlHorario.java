package pe.citas.BD.Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.citas.BD.Interfaces.InterfaceHorario;
import pe.citas.modelo.vo.Horario;

public class MysqlHorario implements InterfaceHorario{
    String OBTENER="SELECT  * FROM HORARIO";
    
    String VALIDAR2="Select * from horario WHERE idMedico=?";
    
    String INSERTAR="INSERT INTO HORARIO VALUES (null,?,?,?)";
    
    private Connection conexion;
    private PreparedStatement ps;
    private ResultSet resultado;

    @Override
    public int insertar(Horario horario) {
        int result=0;
        try {
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement(INSERTAR);
            
            ps.setString(1, horario.getDia());
            ps.setString(2, horario.getHora());
            ps.setInt(3, horario.getIdMedico());
            
            result=ps.executeUpdate();
            CerrarConexiones();
        } catch (Exception e) {
            System.out.println("No se pudo insertar el registro en la base de datos "+e.getMessage());
        }
        return result;
    }

    @Override
    public void modificar(Horario o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Horario o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Horario obtenerporId(Integer k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ArrayList<Horario> valiHorario(int Medico){
        Horario objHorario=null;
        ArrayList<Horario> listaHorario=new ArrayList<>();
        try {
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement(VALIDAR2);
            
            ps.setInt(1, Medico);
            
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {                
                objHorario=new Horario();
                
                objHorario.setIdHorario(rs.getInt(1));
                objHorario.setDia(rs.getString(2));
                objHorario.setHora(rs.getString(3));
                objHorario.setIdMedico(rs.getInt(4));
                
                listaHorario.add(objHorario);
            }
            rs.close();
            CerrarConexiones();
        } catch (Exception e) {
            System.out.println("No se pudo validar las credenciales en la base de datos.Mensaje: " + e.getMessage() );
        }
        return listaHorario;    
        
    }

    @Override
    public ArrayList<Horario> listar() {
        ArrayList<Horario> listaHorario=new ArrayList<>();
        try {
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement(OBTENER);
            resultado=ps.executeQuery();
            
            while (resultado.next()) {                
                Horario objHorario=new Horario();
                
                objHorario.setIdHorario(resultado.getInt(1));
                objHorario.setDia(resultado.getString(2));  
                objHorario.setHora(resultado.getString(3)); 
                objHorario.setIdMedico(resultado.getInt(4));  
                listaHorario.add(objHorario);
            }
            CerrarConexiones();
            
        } catch (Exception e) {
            System.out.println("No se pudo obtener los registros de los usuarios de la base de datos"+e.getMessage());
        }
        return listaHorario;
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
}
