package pe.citas.BD.Mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.citas.modelo.vo.Medico;

public class MedicoCad {
    public static boolean registrarMedico(Medico m){
        try {
            String sql="{call sp_registrarMedico(?,?,?,?,?,?,?,?)}";
            Connection conexion=new MysqlConexion().getConnection();
            CallableStatement cl=(CallableStatement)conexion.prepareCall(sql);
            
            cl.setString(1, m.getNombre());
            cl.setString(2, m.getApellidopat());
            cl.setString(3, m.getApellidomat());
            cl.setString(4, m.getTelefono());
            cl.setString(5, m.getEmail());
            cl.setString(6, m.getClave());
            cl.setInt(7, m.getPerfil_especialidad());
            cl.setInt(8, m.getPerfil_usuario_id());
            
            
            return cl.executeUpdate()>0;
            
        } catch (Exception e) {
            return false;
        }
    }
    
    public static ArrayList<Medico> listarMedicos(Medico m){
        try {
            String sql="{call sp_listarMedicos()}";
            Connection conexion=new MysqlConexion().getConnection();
            CallableStatement sentencia=(CallableStatement)conexion.prepareCall(sql);
          
            ResultSet resultado=sentencia.executeQuery();
            
            ArrayList<Medico> lista=new ArrayList<>();
            
            while (resultado.next()) {                
                Medico med=new Medico();
                med.setId(resultado.getInt(1));
                med.setNombre(resultado.getString(2));
                med.setApellidopat(resultado.getString(3));
                med.setApellidomat(resultado.getString(4));
                med.setTelefono(resultado.getString(5));
                med.setEmail(resultado.getString(6));
                med.setClave(resultado.getString(7));
                med.setPerfil_especialidad(resultado.getInt(8));
                med.setPerfil_usuario_id(resultado.getInt(9));
                lista.add(med);
            }
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }
}
