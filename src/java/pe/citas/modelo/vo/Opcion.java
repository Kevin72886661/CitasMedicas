package pe.citas.modelo.vo;


public class Opcion {
    int valor;
    String texto;

    public Opcion(int valor, String texto) {
        this.valor = valor;
        this.texto = texto;
    }

    public int getValor() {
        return valor;
    }

    public String getTexto() {
        return texto;
    }
    
    
}
