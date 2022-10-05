
package pe.citas.BD.Interfaces;

import java.util.ArrayList;
import pe.citas.modelo.vo.Cita;

public interface InterfaceCita extends InterfaceGeneral<Integer, Cita> {
    public ArrayList<Cita> listarPorusuario(int idusuario);
    public ArrayList<Cita> valiCita(int Usuario);
    public void eliminar(Integer idcita);
    public ArrayList<Cita> valiCitaMedico(int Medico);
}
