package pe.citas.modelo.vo;

import java.util.Date;

public class Usuario {
    private int id;
    private String DNI;
    private String nombre;
    private String apellidopat;
    private String apellidomat;
    private String telefono;
    private String email;
    private String clave;      
    private String direccion;
    private int perfil_usuario_id;
    private Date fecha_registro;
    private Date fecha_update; 

    public Usuario() {
    }

     

    public Usuario(int id, String DNI, String nombre, String apellidopat, String apellidomat, String telefono, String email, String direccion) {
        this.id = id;
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidopat = apellidopat;
        this.apellidomat = apellidomat;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidopat() {
        return apellidopat;
    }

    public void setApellidopat(String apellidopat) {
        this.apellidopat = apellidopat;
    }

    public String getApellidomat() {
        return apellidomat;
    }

    public void setApellidomat(String apellidomat) {
        this.apellidomat = apellidomat;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getPerfil_usuario_id() {
        return perfil_usuario_id;
    }

    public void setPerfil_usuario_id(int perfil_usuario_id) {
        this.perfil_usuario_id = perfil_usuario_id;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Date getFecha_update() {
        return fecha_update;
    }

    public void setFecha_update(Date fecha_update) {
        this.fecha_update = fecha_update;
    }

    
    
}
