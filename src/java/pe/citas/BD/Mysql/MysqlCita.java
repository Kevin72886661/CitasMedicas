package pe.citas.BD.Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pe.citas.BD.Interfaces.InterfaceCita;
import pe.citas.modelo.vo.Cita;
import pe.citas.modelo.vo.Especialidad;
import pe.citas.modelo.vo.Medico;
import pe.citas.modelo.vo.Usuario;


public class MysqlCita implements InterfaceCita{
    
    String INSERTAR="INSERT INTO CITA VALUES (null,?,?,?,?,?,sysdate())";
    
    String SELECCIONARPORID = "SELECT idCita, id_medico, id_especialidad, id_usuario, dia, hora, DiaCrearCita from Cita where id_usuario=?";
    
String SELECCIONARPORIDMEDICO = "SELECT c.idCita,m.id_medico,m.Nombre,e.NomEspecilidad,u.id_usuario,u.nombre, u.apellidopat,u.apellidomat,c.Dia, c.Hora, c.DiaCrearCita FROM cita c INNER JOIN especialidad e ON(e.idespecialidad=c.id_especialidad) INNER JOIN medico m ON(m.id_medico=c.id_medico) INNER JOIN usuario u ON(u.id_usuario=c.id_usuario) where c.id_medico=?";
//    String SELECCIONARPORIDMEDICO ="SELECT idCita, id_medico, id_especialidad, id_usuario, dia, hora, DiaCrearCita from Cita where id_medico=?";
String listar = "SELECT c.idCita,m.id_medico,m.Nombre,m.apepat,e.NomEspecilidad,u.id_usuario,u.DNI,u.nombre, u.apellidopat,u.apellidomat,c.Dia, c.Hora, c.DiaCrearCita FROM cita c INNER JOIN especialidad e ON(e.idespecialidad=c.id_especialidad) INNER JOIN medico m ON(m.id_medico=c.id_medico) INNER JOIN usuario u ON(u.id_usuario=c.id_usuario)";

    
    
    
    private Connection conexion;
    private PreparedStatement ps;
    private ResultSet resultado;
        private Statement senten;

    private PreparedStatement sentencia;


    @Override
    public int insertar(Cita cita) {
        int result=0;
        try {
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement(INSERTAR);
            
            ps.setInt(1, cita.getIdMedico());
            ps.setInt(2, cita.getIdEspecialidad());
            ps.setInt(3, cita.getIdUsuario());
            ps.setString(4, cita.getDia());
            ps.setString(5, cita.getHora());
            
            result=ps.executeUpdate();
            CerrarConexiones();
        } catch (Exception e) {
            System.out.println("No se pudo insertar el registro en la base de datos "+e.getMessage());
        }
        return result;
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
    public void modificar(Cita o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Cita o) {
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }
    
    @Override
    public void eliminar(Integer idcita) {
        try {
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement("DELETE FROM cita WHERE idCita ="+idcita);
            ps.executeUpdate();
            
            } catch (SQLException ex) {
            }
            CerrarConexiones();
    }

    @Override
    public Cita obtenerporId(Integer k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cita> listar() {
        ArrayList<Cita> listaCita=new ArrayList<>();
        try {
           
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement(listar);
                      
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {       
//               
            Cita  cita=new Cita();
            Medico m=new Medico();
            Usuario u =new Usuario();
            Especialidad e=new Especialidad();
               
                cita.setIdCita(rs.getInt(1));
                m.setId(rs.getInt(2));
                m.setNombre(rs.getString(3));
                m.setApellidopat(rs.getString(4));
                cita.setMedico(m);
                       
                e.setNomEspecialidad(rs.getString(5));
                cita.setEspecialidad(e);
                         
                u.setId(rs.getInt(6));
                u.setDNI(rs.getString(7));
                u.setNombre(rs.getString(8));
                u.setApellidopat(rs.getString(9));
                u.setApellidomat(rs.getString(10));
                cita.setUsuario(u);
         
                
                cita.setDia(rs.getString(11));
                cita.setHora(rs.getString(12));
               cita.setDiaCrearCita(rs.getDate(13));

//                cita.setIdCita(rs.getInt(1));
//                cita.setIdMedico(rs.getInt(2));
//                cita.setIdEspecialidad(rs.getInt(3));
//                cita.setIdUsuario(rs.getInt(4));
//                cita.setDia(rs.getString(5));
//                cita.setHora(rs.getString(6));
//               cita.setDiaCrearCita(rs.getDate(7));
//                
                listaCita.add(cita);
            }
            rs.close();
            CerrarConexiones();
        } catch (Exception e) {
            System.out.println("No se pudo validar las credenciales en la base de datos.Mensaje: " + e.getMessage() );
        }
            return listaCita;
        }
    
    
    @Override
    public ArrayList<Cita> listarPorusuario(int idusuario){
        ArrayList<Cita> listaCita=new ArrayList<>();
        try {
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement(SELECCIONARPORID);
            resultado=ps.executeQuery();
            
            while (resultado.next()) {                
                Cita objCita=new Cita();
  
                objCita.setIdCita(resultado.getInt(1));
                objCita.setIdMedico(resultado.getInt(2));
                objCita.setIdUsuario(resultado.getInt(3));
                objCita.setDia(resultado.getString(4));
                objCita.setHora(resultado.getString(5));
       
                listaCita.add(objCita);
            }
            CerrarConexiones();
            
        } catch (Exception e) {
            System.out.println("No se pudo obtener los registros de los usuarios de la base de datos"+e.getMessage());
        }
        return listaCita;
    }
    
    @Override
    public ArrayList<Cita> valiCita(int Usuario) {
        
        ArrayList<Cita> listaCita=new ArrayList<>();
        try {
           
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement(SELECCIONARPORID);
          
            ps.setInt(1, Usuario);
            
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {       
               
            Cita  cita=new Cita();
          
               
                cita.setIdCita(rs.getInt(1));
                cita.setIdMedico(rs.getInt(2));
                cita.setIdEspecialidad(rs.getInt(3));
                cita.setIdUsuario(rs.getInt(4));
                cita.setDia(rs.getString(5));
                cita.setHora(rs.getString(6));
               cita.setDiaCrearCita(rs.getDate(7));
                
                listaCita.add(cita);
            }
            rs.close();
            CerrarConexiones();
        } catch (Exception e) {
            System.out.println("No se pudo validar las credenciales en la base de datos.Mensaje: " + e.getMessage() );
        }
        return listaCita;    
    }

    @Override
    public ArrayList<Cita> valiCitaMedico(int Medico) {
        ArrayList<Cita> listaCita=new ArrayList<>();
        try {
           
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement(SELECCIONARPORIDMEDICO);
          
            ps.setInt(1, Medico);
            
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {       
//               
            Cita  cita=new Cita();
            Medico m=new Medico();
            Usuario u =new Usuario();
            Especialidad e=new Especialidad();
               
                cita.setIdCita(rs.getInt(1));
                m.setId(rs.getInt(2));
                m.setNombre(rs.getString(3));

                cita.setMedico(m);
                       
                e.setNomEspecialidad(rs.getString(4));
                cita.setEspecialidad(e);
                         
                u.setId(rs.getInt(5));
                u.setNombre(rs.getString(6));
                u.setApellidopat(rs.getString(7));
                u.setApellidomat(rs.getString(8));
                cita.setUsuario(u);
         
                
                cita.setDia(rs.getString(9));
                cita.setHora(rs.getString(10));
               cita.setDiaCrearCita(rs.getDate(11));

//                cita.setIdCita(rs.getInt(1));
//                cita.setIdMedico(rs.getInt(2));
//                cita.setIdEspecialidad(rs.getInt(3));
//                cita.setIdUsuario(rs.getInt(4));
//                cita.setDia(rs.getString(5));
//                cita.setHora(rs.getString(6));
//               cita.setDiaCrearCita(rs.getDate(7));
//                
                listaCita.add(cita);
            }
            rs.close();
            CerrarConexiones();
        } catch (Exception e) {
            System.out.println("No se pudo validar las credenciales en la base de datos.Mensaje: " + e.getMessage() );
        }
        return listaCita;    
    }
    
    
    

   
    
}
