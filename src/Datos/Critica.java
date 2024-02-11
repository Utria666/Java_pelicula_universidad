package Datos;

import java.util.Date;
public class Critica {
    private int id_critica;
    private String nombre_medio;
    private Date fecha_publicacion;
    private String nombre_autor;
    private String resumen_critica;

    public Critica() {
    }

    public Critica(int id_critica, String nombre_medio, Date fecha_publicacion, String nombre_autor, String resumen_critica) {
        this.id_critica = id_critica;
        this.nombre_medio = nombre_medio;
        this.fecha_publicacion = fecha_publicacion;
        this.nombre_autor = nombre_autor;
        this.resumen_critica = resumen_critica;
    }

    public int getId_critica() {
        return id_critica;
    }

    public void setId_critica(int id_critica) {
        this.id_critica = id_critica;
    }

    public String getNombre_medio() {
        return nombre_medio;
    }

    public void setNombre_medio(String nombre_medio) {
        this.nombre_medio = nombre_medio;
    }

    public Date getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(Date fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public String getNombre_autor() {
        return nombre_autor;
    }

    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }

    public String getResumen_critica() {
        return resumen_critica;
    }

    public void setResumen_critica(String resumen_critica) {
        this.resumen_critica = resumen_critica;
    }
}
