package pe.citas.BD.Interfaces;

import pe.citas.modelo.vo.Usuario;

public interface InterfaceUsuario extends InterfaceGeneral<Integer, Usuario>{
    public Usuario validarUsuario(String DNI, String uclave);
    public Usuario valiUsuario(String DNI);
       public boolean actualizarUsuario(Usuario u);

}
