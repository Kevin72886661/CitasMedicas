package pe.citas.BD.Mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import pe.citas.BD.Interfaces.InterfaceMedico;
import pe.citas.modelo.vo.Especialidad;
import pe.citas.modelo.vo.Medico;

public class MysqlMedico implements InterfaceMedico{
    
    String OBTENER="SELECT * FROM MEDICO";
    
    String INSERTAR="INSERT INTO MEDICO VALUES (null,?,?,?,?,?,?,?,?)";
    
    String VALIDAR="SELECT * FROM MEDICO WHERE email=? AND clave=?";
    
    String VALIDAR2="SELECT * FROM MEDICO WHERE IDESPECIALIDAD=?";
    
    String OBTENERPORID="SELECT id_medico, Nombre,apepat,apemat,Telefono,Email,idespecialidad FROM medico where id_medico=";
    
    String MODIFICAR = "UPDATE producto set nombre=?, precio=?, stock=? where id=?";
    
    private Connection conexion;
    private PreparedStatement ps;
    private ResultSet resultado;
    private Statement senten;
    
    @Override
    public ArrayList<Medico> listar() {
        ArrayList<Medico> listaMedicos=new ArrayList<>();
        try {
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement(OBTENER);
            resultado=ps.executeQuery();
            
            while (resultado.next()) {                
                Medico objMedico=new Medico();
                Especialidad objEsp=new Especialidad();
                
                objMedico.setId(resultado.getInt(1));
                objMedico.setNombre(resultado.getString(2));
                objMedico.setApellidopat(resultado.getString(3));
                objMedico.setApellidomat(resultado.getString(4));
                objMedico.setTelefono(resultado.getString(5));
                objMedico.setEmail(resultado.getString(6));
                objMedico.setClave(resultado.getString(7));
                objMedico.setPerfil_especialidad(resultado.getInt(8));
                objMedico.setPerfil_usuario_id(resultado.getInt(9));

                
                listaMedicos.add(objMedico);
            }
            CerrarConexiones();
            
        } catch (Exception e) {
            System.out.println("No se pudo obtener los registros de los usuarios de la base de datos"+e.getMessage());
        }
        return listaMedicos;
    }
    @Override
    public int insertar(Medico o) {
        int result=0;
        try {
            String sql="{call sp_registrarMedico(?,?,?,?,?,?,?,?)}";
            conexion=new MysqlConexion().getConnection();
            CallableStatement cl=(CallableStatement)conexion.prepareCall(sql);
            
            cl.setString(1, o.getNombre());
            cl.setString(2, o.getApellidopat());
            cl.setString(3, o.getApellidomat());
            cl.setString(4, o.getTelefono());
            cl.setString(5, o.getEmail());
            cl.setString(6, o.getClave());
            cl.setInt(7, o.getPerfil_especialidad());
            cl.setInt(8, o.getPerfil_usuario_id());
         
                    
            result=cl.executeUpdate();
            CerrarConexiones();
        } catch (Exception e) {
            System.out.println("No se pudo insertar el registro en la base de datos "+e.getMessage());
        }
        return result;
    }

    @Override
    public void modificar(Medico o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public boolean actualizarMedico(Medico m){
        boolean rpta=false;
        
        try {
            conexion=new MysqlConexion().getConnection();
            CallableStatement cl=conexion.prepareCall("{call sp_actualizarMed(?,?,?,?,?,?,?)}");
            
            cl.setInt(1, m.getId());
            cl.setString(2, m.getNombre());
            cl.setString(3, m.getApellidopat());
            cl.setString(4, m.getApellidomat());
            cl.setString(5, m.getTelefono());
            cl.setString(6, m.getEmail());
            cl.setInt(7, m.getPerfil_especialidad());
            
             int i=cl.executeUpdate();
             
             if (i==1) {
                rpta=true;
            }else{
                 rpta=false;
             }
            
           CerrarConexiones();
        } catch (SQLException e) {
            System.out.println("Error"+e.getMessage());
        }
        
        return rpta;
    }

    @Override
    public void eliminar(Medico o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Medico obtenerporId(Integer k) {
        Medico pro=new Medico();
        Especialidad esp=new Especialidad();
        try {
            conexion=new MysqlConexion().getConnection();
            senten=conexion.createStatement();
            String pedido=OBTENERPORID+k;
            resultado=senten.executeQuery(pedido);
            
            if (resultado.next()) {  
                pro.setId(resultado.getInt(1));
                pro.setNombre(resultado.getString(2));
                pro.setApellidopat(resultado.getString(3));
                pro.setApellidomat(resultado.getString(4));
                pro.setTelefono(resultado.getString(5));
                pro.setEmail(resultado.getString(6));
                pro.setPerfil_especialidad(resultado.getInt(7));
            }
            
            CerrarConexiones();
        } catch (SQLException e) {
            System.out.println("No se pudo obtener el perfil producto de la base de datos. Mensaje: "+ e.getMessage());

        }
        
        return pro;

    }
     @Override
    public ArrayList<Medico> obtenerporId2(Integer k){
        ArrayList<Medico> listaMedico = new ArrayList<>();
        try {
           conexion = new MysqlConexion().getConnection();
           senten = conexion.createStatement();
           String pedido="select * from Medico WHERE idespecialidad="+k; 
           
           resultado = ps.executeQuery(pedido);
           if (resultado.next()) { 
               
                Medico medico=new Medico();
                Especialidad esp=new Especialidad();
                
                medico.setNombre(resultado.getString(1));
                medico.setApellidopat(resultado.getString(2));
                medico.setApellidomat(resultado.getString(3));
                medico.setPerfil_especialidad(resultado.getInt(4));
                esp.setNomEspecialidad(resultado.getString(5));
                medico.setEspecialidad(esp); 
                
                listaMedico.add(medico);
           
           }    
         
           CerrarConexiones();
        } catch (SQLException e) {
                System.out.println("No se pudo obtener los registros de la base de datos. Mensaje: "+ e.getMessage());
        }
    
        return listaMedico;
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
    public ArrayList<Medico> valiMedico2(int Especialidad) {
        Medico usuMedico=null;
        ArrayList<Medico> listaMedicos=new ArrayList<>();
        try {
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement(VALIDAR2);
            
            ps.setInt(1, Especialidad);
            
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {                
                usuMedico=new Medico();
                
                usuMedico.setId(rs.getInt(1));
                usuMedico.setNombre(rs.getString(2));
                usuMedico.setApellidopat(rs.getString(3));
                usuMedico.setApellidomat(rs.getString(4));
                usuMedico.setPerfil_especialidad(rs.getInt(5));
                
                listaMedicos.add(usuMedico);
            }
            rs.close();
            CerrarConexiones();
        } catch (Exception e) {
            System.out.println("No se pudo validar las credenciales en la base de datos.Mensaje: " + e.getMessage() );
        }
        return listaMedicos;    
    }

    @Override
    public Medico validarMedico(String email, String uclave) {
        Medico medObj=null;
        try {
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement(VALIDAR);
            
            ps.setString(1, email);
            ps.setString(2, uclave);
            
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {                
                medObj=new Medico();
                Especialidad esp=new Especialidad();

                medObj.setId(rs.getInt(1));
                medObj.setNombre(rs.getString(2));
                medObj.setApellidopat(rs.getString(3));
                medObj.setApellidomat(rs.getString(4));
                medObj.setTelefono(rs.getString(5));
                medObj.setEmail(rs.getString(6));
                medObj.setClave(rs.getString(7));
                esp.setNomEspecialidad(rs.getString(8));
                medObj.setEspecialidad(esp); 
                medObj.setPerfil_usuario_id(rs.getInt(9));
            }
            rs.close();
            CerrarConexiones();
        } catch (Exception e) {
            System.out.println("No se pudo validar las credenciales en la base de datos.Mensaje: " + e.getMessage() );
        }
        return medObj;
    }

    @Override
    public void eliminar(Integer idmedico) {
        try {
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement("DELETE FROM medico WHERE id_medico ="+idmedico);
            ps.executeUpdate();
            
            } catch (SQLException ex) {
            }
            CerrarConexiones();
    }

    @Override
    public int eliminar2(Integer idmedico) {
        int valor=0;
        try {
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement("DELETE FROM medico WHERE id_medico ="+idmedico);
            valor=ps.executeUpdate();
            
            } catch (SQLException ex) {
            }
            CerrarConexiones();
        return valor;
    }
    
    


    
}
