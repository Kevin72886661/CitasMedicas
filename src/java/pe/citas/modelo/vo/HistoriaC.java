package pe.citas.modelo.vo;

import java.sql.Date;

public class HistoriaC {
    private int idHistoria;
    private int idpaciente;
    private String antecedentes;
    private String Motivo;
    private String enfermedad;
    private String examenes; 
    private Date FechCreHist; 

    public HistoriaC(int idHistoria, String antecedentes, String Motivo, String enfermedad, String examenes) {
        this.idHistoria = idHistoria;
        this.antecedentes = antecedentes;
        this.Motivo = Motivo;
        this.enfermedad = enfermedad;
        this.examenes = examenes;
    }
    private Usuario paciente;

    public HistoriaC() {
    }

    public HistoriaC(int idHistoria, int idpaciente, String antecedentes, String Motivo, String enfermedad, String examenes, Date FechCreHist) {
        this.idHistoria = idHistoria;
        this.idpaciente = idpaciente;
        this.antecedentes = antecedentes;
        this.Motivo = Motivo;
        this.enfermedad = enfermedad;
        this.examenes = examenes;
        this.FechCreHist = FechCreHist;
    }
    

    public int getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(int idHistoria) {
        this.idHistoria = idHistoria;
    }

    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getExamenes() {
        return examenes;
    }

    public void setExamenes(String examenes) {
        this.examenes = examenes;
    }

    public Date getFechCreHist() {
        return FechCreHist;
    }

    public void setFechCreHist(Date FechCreHist) {
        this.FechCreHist = FechCreHist;
    }

    public Usuario getPaciente() {
        return paciente;
    }

    public void setPaciente(Usuario paciente) {
        this.paciente = paciente;
    }

    
    
    
}
