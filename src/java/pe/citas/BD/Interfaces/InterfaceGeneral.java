package pe.citas.BD.Interfaces;

import java.util.ArrayList;

public interface InterfaceGeneral<K,O> {
    
    public int insertar(O o);
    public void modificar(O o);
    public void eliminar(O o);
    public O obtenerporId(K k);
    public ArrayList<O> listar();
    
}

