package pe.citas.BD.Interfaces;

import java.util.ArrayList;
import pe.citas.modelo.vo.Medico;

public interface InterfaceMedico extends InterfaceGeneral<Integer, Medico>{
    public Medico validarMedico(String email, String uclave);
   public ArrayList<Medico> obtenerporId2(Integer k);
   public ArrayList<Medico> valiMedico2(int Especialidad);
   public boolean actualizarMedico(Medico m);
   public void eliminar(Integer idmedico);
   public int eliminar2(Integer idmedico);
}
