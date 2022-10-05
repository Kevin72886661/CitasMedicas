
package pe.citas.modelo.vo;

public class Prescripcion_C {
    private int idPrescripcion;
    private int idUsuario;
    private int idMedico;
    private String receta;
    private String recomendacion;
    private String Fecha;
    private Usuario paciente;
    private Medico medico;

    public Prescripcion_C(int idPrescripcion, int idUsuario, int idMedico, String receta, String recomendacion, String Fecha) {
        this.idPrescripcion = idPrescripcion;
        this.idUsuario = idUsuario;
        this.idMedico = idMedico;
        this.receta = receta;
        this.recomendacion = recomendacion;
        this.Fecha = Fecha;
    }

    public Prescripcion_C(int idPrescripcion, String receta, String recomendacion, String Fecha) {
        this.idPrescripcion = idPrescripcion;
        this.receta = receta;
        this.recomendacion = recomendacion;
        this.Fecha = Fecha;
    }
    
    

    public Prescripcion_C() {
    }


    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    public int getIdPrescripcion() {
        return idPrescripcion;
    }

    public void setIdPrescripcion(int idPrescripcion) {
        this.idPrescripcion = idPrescripcion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public Usuario getPaciente() {
        return paciente;
    }

    public void setPaciente(Usuario paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    
}
