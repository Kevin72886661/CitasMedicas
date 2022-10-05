package pe.citas.modelo.vo;

public class Horario {
    private int idHorario;
    private String Dia; 
    private String Hora;
    private int idMedico;

    public Horario(int idHorario, String Dia) {
        this.idHorario = idHorario;
        this.Dia = Dia;
    }

    public Horario(int idHorario, String Dia, String Hora, int idMedico) {
        this.idHorario = idHorario;
        this.Dia = Dia;
        this.Hora = Hora;
        this.idMedico = idMedico;
    }

    
    public Horario() {
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
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

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    

    

   

   
    

    
   
    
    
}
