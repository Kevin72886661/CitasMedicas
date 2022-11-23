package pe.citas.BD.Interfaces;

import pe.citas.modelo.vo.Especialidad;

public interface InterfaceEspecialidad extends InterfaceGeneral<Integer, Especialidad>{
    public Especialidad valiEspecialidad(String Especialidad);
           public boolean actualizarEspecialidad(Especialidad e );
              public int eliminar2(Integer idmedico);


}
