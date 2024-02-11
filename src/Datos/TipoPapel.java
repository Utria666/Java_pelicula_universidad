package Datos;

public class TipoPapel {
    private int id_papel;
    private String nombre_papel;
    public TipoPapel() {
    }
    public TipoPapel(int id_papel, String nombre_papel) {
        this.id_papel = id_papel;
        this.nombre_papel = nombre_papel;
    }
    public int getId_papel() {
        return id_papel;
    }
    public void setId_papel(int id_papel) {
        this.id_papel = id_papel;
    }
    public String getNombre_papel() {
        return nombre_papel;
    }
    public void setNombre_papel(String nombre_papel) {
        this.nombre_papel = nombre_papel;
    }

}
