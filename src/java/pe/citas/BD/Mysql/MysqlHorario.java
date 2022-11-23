package pe.citas.BD.Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.citas.BD.Interfaces.InterfaceHorario;
import pe.citas.modelo.vo.Especialidad;
import pe.citas.modelo.vo.Horario;
import pe.citas.modelo.vo.Medico;

public class MysqlHorario implements InterfaceHorario{
    String OBTENER="SELECT  * FROM HORARIO";
    
    String VALIDAR2="Select * from horario WHERE idMedico=?";
    
    String INSERTAR="INSERT INTO HORARIO VALUES (null,?,?,?)";
    
    String listar = "select h.idHorario, m.id_medico, m.Nombre,m.apepat,e.NomEspecilidad, h.Dia, h.Hora FROM horario h INNER JOIN medico m on(h.idMedico= m.id_medico) INNER JOIN especialidad e on(m.idespecialidad=e.idespecialidad)";

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

    @Override
    public ArrayList<Horario> listar2() {
        ArrayList<Horario> listaHorario=new ArrayList<>();
        try {
           
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement(listar);
                      
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {       
//               
            Horario  horario=new Horario();
            Medico m=new Medico();
            Especialidad e=new Especialidad();
               
                horario.setIdHorario(rs.getInt(1));
                m.setId(rs.getInt(2));
                m.setNombre(rs.getString(3));
                m.setApellidopat(rs.getString(4));
                horario.setMedico(m);
                       
                e.setNomEspecialidad(rs.getString(5));
                horario.setEspecialidad(e);
                         
                horario.setDia(rs.getString(6));
                horario.setHora(rs.getString(7));

//                cita.setIdCita(rs.getInt(1));
//                cita.setIdMedico(rs.getInt(2));
//                cita.setIdEspecialidad(rs.getInt(3));
//                cita.setIdUsuario(rs.getInt(4));
//                cita.setDia(rs.getString(5));
//                cita.setHora(rs.getString(6));
//               cita.setDiaCrearCita(rs.getDate(7));
//                
                listaHorario.add(horario);
            }
            rs.close();
            CerrarConexiones();
        } catch (Exception e) {
            System.out.println("No se pudo validar las credenciales en la base de datos.Mensaje: " + e.getMessage() );
        }
            return listaHorario;
    }

    @Override
    public void eliminar(Integer idhorario) {
        try {
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement("DELETE FROM horario WHERE idHorario ="+idhorario);
            ps.executeUpdate();
            
            } catch (SQLException ex) {
            }
            CerrarConexiones();
    }
}
