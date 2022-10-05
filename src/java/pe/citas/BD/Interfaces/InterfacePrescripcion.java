package pe.citas.BD.Interfaces;

import java.util.ArrayList;
import pe.citas.modelo.vo.Prescripcion_C;

public interface InterfacePrescripcion extends InterfaceGeneral<Integer, Prescripcion_C>{
    public ArrayList<Prescripcion_C> valiPrescripcion(int Usuario);
    public boolean actualizarPrescr(Prescripcion_C p);
}
