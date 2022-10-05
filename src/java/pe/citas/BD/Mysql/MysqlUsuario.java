package pe.citas.BD.Mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import pe.citas.BD.Interfaces.InterfaceUsuario;
import pe.citas.modelo.vo.Usuario;

public class MysqlUsuario implements InterfaceUsuario{
    
    String INSERTAR="INSERT INTO USUARIO VALUES (null,?,?,?,?,?,?,?,?,?,NOW())";
    String MODIFICAR="UPDATE USUARIO SET DNI=? WHERE id_usuario=? ";
    String OPTENERPORID="SELECT id_usuario,DNI,nombre,apellidopat,apellidomat,email,clave,telefono,direccion,id,fecha_registro,fecha_update from USUARIO WHERE id=?";
    String OBTENER="SELECT id_usuario, DNI, nombre, apellidopat ,apellidomat, email, clave, telefono, direccion, id, fechaRegistro from usuario where id > 1 order by id_usuario asc";
    String VALIDAR="SELECT * FROM USUARIO WHERE email=? AND clave=?";
    String VALIDAR2="SELECT * FROM USUARIO WHERE DNI=?";

    private Connection conexion;
    private PreparedStatement ps;
    private ResultSet resultado;
        private Statement senten;

    
    @Override
    public Usuario validarUsuario(String DNI, String uclave) {
        Usuario usuObj=null;
        try {
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement(VALIDAR);
            
            ps.setString(1, DNI);
            ps.setString(2, uclave);
            
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {                
                usuObj=new Usuario();
                usuObj.setId(rs.getInt(1));
                usuObj.setDNI(rs.getString(2));
                usuObj.setNombre(rs.getString(3));
                usuObj.setApellidopat(rs.getString(4));
                usuObj.setApellidomat(rs.getString(5));
                usuObj.setEmail(rs.getString(6));
                usuObj.setClave(rs.getString(7));
                usuObj.setTelefono(rs.getString(8));
                usuObj.setDireccion(rs.getString(9));
                usuObj.setPerfil_usuario_id(rs.getInt(10));
                
            }
            rs.close();
            CerrarConexiones();
        } catch (Exception e) {
            System.out.println("No se pudo validar las credenciales en la base de datos.Mensaje: " + e.getMessage() );
        }
        return usuObj;
    }
   

    @Override
    public int insertar(Usuario usuario) {
        int result=0;
        try {
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement(INSERTAR);
            
            ps.setString(1, usuario.getDNI());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellidopat());
            ps.setString(4, usuario.getApellidomat());
            ps.setString(5, usuario.getEmail());
            ps.setString(6, usuario.getClave());
            ps.setString(7, usuario.getTelefono());
            ps.setString(8, usuario.getDireccion());
            ps.setInt(9, usuario.getPerfil_usuario_id());
            
            result=ps.executeUpdate();
            CerrarConexiones();
        } catch (Exception e) {
            System.out.println("No se pudo insertar el registro en la base de datos "+e.getMessage());
        }
        return result;
    }
    

    @Override
    public void modificar(Usuario o) {
        try {
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement(MODIFICAR);
            
            ps.setString(1, o.getDNI());
            ps.setString(2, o.getNombre());
            ps.setString(3, o.getApellidopat());
            ps.setString(4, o.getApellidomat());
            ps.setString(5, o.getEmail());
            ps.setString(5, o.getTelefono());
            ps.setString(6, o.getClave());
            ps.setString(7, o.getDireccion());
            ps.setInt(8, o.getId());
            
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("No se pudo modificar el registro de la base de datos"+e.getMessage());
        }
    }

    @Override
    public void eliminar(Usuario o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario obtenerporId(Integer u) {
        Usuario usu = new Usuario();
        try {
           conexion = new MysqlConexion().getConnection();
           senten = conexion.createStatement(); 
           String pedido ="select * from usuario where id_usuario="+u;
           
           resultado = senten.executeQuery(pedido);
           if (resultado.next()) { 
               
                
                usu.setId(resultado.getInt(1));
                usu.setDNI(resultado.getString(2));
                usu.setNombre(resultado.getString(3));
                usu.setApellidopat(resultado.getString(4));
                usu.setApellidomat(resultado.getString(5));
                usu.setEmail(resultado.getString(6));
                usu.setClave(resultado.getString(7));
                usu.setTelefono(resultado.getString(8));
                usu.setDireccion(resultado.getString(9));
                usu.setPerfil_usuario_id(resultado.getInt(10));
                usu.setFecha_registro(resultado.getDate(11));
           
                
           }    
         
           CerrarConexiones();
        } catch (Exception e) {
                System.out.println("No se pudo obtener la historia de la base de datos. Mensaje: "+ e.getMessage());
        }
    
        return usu;
    }

    @Override
    public ArrayList<Usuario> listar() {
        ArrayList<Usuario> listaUsuarios=new ArrayList<>();
        try {
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement(OBTENER);
            resultado=ps.executeQuery();
            
            while (resultado.next()) {                
                Usuario usu=new Usuario();
                
                usu.setId(resultado.getInt(1));
                usu.setDNI(resultado.getString(2));
                usu.setNombre(resultado.getString(3));
                usu.setApellidopat(resultado.getString(4));
                usu.setApellidomat(resultado.getString(5));
                usu.setEmail(resultado.getString(6));
                usu.setClave(resultado.getString(7));
                usu.setTelefono(resultado.getString(8));
                usu.setDireccion(resultado.getString(9));
                usu.setPerfil_usuario_id(resultado.getInt(10));
                usu.setFecha_registro(resultado.getDate(11));
                
                listaUsuarios.add(usu);
            }
            CerrarConexiones();
            
        } catch (Exception e) {
            System.out.println("No se pudo obtener los registros de los usuarios de la base de datos"+e.getMessage());
        }
        return listaUsuarios;
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
    public Usuario valiUsuario(String DNI) {
        Usuario usuObj=null;
        try {
            conexion=new MysqlConexion().getConnection();
            ps=conexion.prepareStatement(VALIDAR2);
            
            ps.setString(1, DNI);
            
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {                
                usuObj=new Usuario();
                usuObj.setId(rs.getInt(1));
                usuObj.setDNI(rs.getString(2));
                usuObj.setNombre(rs.getString(3));
                usuObj.setApellidopat(rs.getString(4));
                usuObj.setApellidomat(rs.getString(5));
                usuObj.setEmail(rs.getString(6));
                usuObj.setClave(rs.getString(7));
                usuObj.setTelefono(rs.getString(8));
                usuObj.setDireccion(rs.getString(9));
                usuObj.setPerfil_usuario_id(rs.getInt(10));
                usuObj.setFecha_registro(rs.getDate(11));
                usuObj.setFecha_update(rs.getDate(12));
                
            }
            rs.close();
            CerrarConexiones();
        } catch (Exception e) {
            System.out.println("No se pudo validar las credenciales en la base de datos.Mensaje: " + e.getMessage() );
        }
        return usuObj;
    }

    @Override
    public boolean actualizarUsuario(Usuario u) {
        boolean rpta=false;
        
        try {
            conexion=new MysqlConexion().getConnection();
            CallableStatement cl=conexion.prepareCall("{call sp_actualizarPac(?,?,?,?,?,?,?,?)}");
            
            cl.setInt(1, u.getId());
            cl.setString(2, u.getDNI());
            cl.setString(3, u.getNombre());
            cl.setString(4, u.getApellidopat());
            cl.setString(5, u.getApellidomat());
            cl.setString(6, u.getTelefono());
            cl.setString(7, u.getEmail());
            cl.setString(8, u.getDireccion());
            
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

