package Datos;

public class Premio {
    private int id_premio;
    private String nombre_premio;

    public Premio() {
    }

    public Premio(int id_premio, String nombre_premio) {
        this.id_premio = id_premio;
        this.nombre_premio = nombre_premio;
    }

    public int getId_premio() {
        return id_premio;
    }

    public void setId_premio(int id_premio) {
        this.id_premio = id_premio;
    }

    public String getNombre_premio() {
        return nombre_premio;
    }

    public void setNombre_premio(String nombre_premio) {
        this.nombre_premio = nombre_premio;
    }
}
