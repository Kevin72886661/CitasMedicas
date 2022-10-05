package pe.citas.BD.Interfaces;

import java.util.ArrayList;
import pe.citas.modelo.vo.HistoriaC;

public interface InterfaceHistoria extends InterfaceGeneral<Integer, HistoriaC>{
    public ArrayList<HistoriaC> valiHistoria(int Usuario);
       public boolean actualizarHistoria(HistoriaC h);

}
