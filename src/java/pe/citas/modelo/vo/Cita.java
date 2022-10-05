package pe.citas.modelo.vo;

import java.sql.Date;

public class Cita {

    private int idCita;
    private int idMedico;
    private int idEspecialidad;
    private int idUsuario;
    private String Dia;
    private String Hora;
    private Date DiaCrearCita;
    private Medico medico;
    private Especialidad especialidad;
    private Usuario usuario;

    public Cita() {
    }

    public Cita(int idCita, int idMedico, int idEspecialidad, int idUsuario, String Dia, String Hora, Date DiaCrearCita, Medico medico, Especialidad especialidad, Usuario usuario) {
        this.idCita = idCita;
        this.idMedico = idMedico;
        this.idEspecialidad = idEspecialidad;
        this.idUsuario = idUsuario;
        this.Dia = Dia;
        this.Hora = Hora;
        this.DiaCrearCita = DiaCrearCita;
        this.medico = medico;
        this.especialidad = especialidad;
        this.usuario = usuario;
    }


    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }
    
    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDia() {
        return Dia;
    }

    public void setDia(String Dia) {
        this.Dia = Dia;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public Date getDiaCrearCita() {
        return DiaCrearCita;
    }

    public void setDiaCrearCita(Date DiaCrearCita) {
        this.DiaCrearCita = DiaCrearCita;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
    

    

    

    
    

}