package Datos;

import java.util.Date;

public class Pelicula {
    private int id_pelicula;
    private String titulo_pelicula;
    private Date fecha_estreno;
    private String lugar_estreno;
    private int id_critica; // ID de la crítica asociada
    private String nombreCritica; // Nombre de la crítica asociada

    // Constructor vacío
    public Pelicula() {
    }

    // Constructor completo
    // Constructor para inserción y actualización sin nombreCritica
    public Pelicula(int id_pelicula, String titulo_pelicula, Date fecha_estreno, String lugar_estreno, int id_critica) {
        this.id_pelicula = id_pelicula;
        this.titulo_pelicula = titulo_pelicula;
        this.fecha_estreno = fecha_estreno;
        this.lugar_estreno = lugar_estreno;
        this.id_critica = id_critica;
    }

    // Constructor para recuperación que incluye nombreCritica
    public Pelicula(int id_pelicula, String titulo_pelicula, Date fecha_estreno, String lugar_estreno, int id_critica, String nombreCritica) {
        this(id_pelicula, titulo_pelicula, fecha_estreno, lugar_estreno, id_critica); // Llama al constructor base
        this.nombreCritica = nombreCritica; // Asigna el valor adicional
    }

    // Getters y setters para todos los campos
    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getTitulo_pelicula() {
        return titulo_pelicula;
    }

    public void setTitulo_pelicula(String titulo_pelicula) {
        this.titulo_pelicula = titulo_pelicula;
    }

    public Date getFecha_estreno() {
        return fecha_estreno;
    }

    public void setFecha_estreno(Date fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }

    public String getLugar_estreno() {
        return lugar_estreno;
    }

    public void setLugar_estreno(String lugar_estreno) {
        this.lugar_estreno = lugar_estreno;
    }

    public int getId_critica() {
        return id_critica;
    }

    public void setId_critica(int id_critica) {
        this.id_critica = id_critica;
    }

    public String getNombreCritica() {
        return nombreCritica;
    }

    public void setNombreCritica(String nombreCritica) {
        this.nombreCritica = nombreCritica;
    }
}
