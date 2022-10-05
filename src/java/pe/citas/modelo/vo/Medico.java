package pe.citas.modelo.vo;

public class Medico{
    private int id;
    private String nombre;
    private String apellidopat;
    private String apellidomat;
    private String Telefono;
    private String Email; 
    private String Clave;   
    private int Perfil_especialidad;
    private int perfil_usuario_id;
    private Especialidad especialidad;

    public Medico(int id, String nombre, String apellidopat, String apellidomat, String Telefono, String Email, String Clave, int Perfil_especialidad, int perfil_usuario_id, Especialidad especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellidopat = apellidopat;
        this.apellidomat = apellidomat;
        this.Telefono = Telefono;
        this.Email = Email;
        this.Clave = Clave;
        this.Perfil_especialidad = Perfil_especialidad;
        this.perfil_usuario_id = perfil_usuario_id;
        this.especialidad = especialidad;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
    
    
    public Medico(int id, String nombre, String apellidopat, String apellidomat, String Telefono, String Email, int Perfil_especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellidopat = apellidopat;
        this.apellidomat = apellidomat;
        this.Telefono = Telefono;
        this.Email = Email;
        this.Perfil_especialidad = Perfil_especialidad;
    }
    

    public Medico() {
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
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public int getPerfil_especialidad() {
        return Perfil_especialidad;
    }

    public void setPerfil_especialidad(int Perfil_especialidad) {
        this.Perfil_especialidad = Perfil_especialidad;
    }

    public int getPerfil_usuario_id() {
        return perfil_usuario_id;
    }

    public void setPerfil_usuario_id(int perfil_usuario_id) {
        this.perfil_usuario_id = perfil_usuario_id;
    }

    
    
    
    
}
