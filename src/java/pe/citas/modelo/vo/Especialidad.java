
package pe.citas.modelo.vo;

public class Especialidad {
    private int idespecialidad;
    private String nomEspecialidad;

    public Especialidad(int idespecialidad, String nomEspecialidad) {
        this.idespecialidad = idespecialidad;
        this.nomEspecialidad = nomEspecialidad;
    }

    public Especialidad() {
    }

    public int getIdespecialidad() {
        return idespecialidad;
    }

    public void setIdespecialidad(int idespecialidad) {
        this.idespecialidad = idespecialidad;
    }

    public String getNomEspecialidad() {
        return nomEspecialidad;
    }

    public void setNomEspecialidad(String nomEspecialidad) {
        this.nomEspecialidad = nomEspecialidad;
    }
    
    
}
