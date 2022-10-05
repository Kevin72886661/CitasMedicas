package pe.citas.BD.Interfaces;

import java.util.ArrayList;
import pe.citas.modelo.vo.Horario;
import pe.citas.modelo.vo.Medico;

public interface InterfaceHorario extends InterfaceGeneral<Integer, Horario>{
    public ArrayList<Horario> valiHorario(int Horario);
}
