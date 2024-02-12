package Datos;

public class PremioPelicula {

    private int id_premio;

    private Premio premio;

    private int id_pelicula;

    private Pelicula pelicula;

    private String nombre_certamen;

    private String ciudad_celebracion;

    //Constructor vacio
    public PremioPelicula(){
    }

    //Constructor para insertar, actualizar y eliminar

    public PremioPelicula(int id_premio, int id_pelicula, String nombre_certamen, String ciudad_celebracion){
        this.id_premio = id_premio;
        this.id_pelicula = id_pelicula;
        this.nombre_certamen = nombre_certamen;
        this.ciudad_celebracion = ciudad_celebracion;
    }

    //Constructor para consultar debido a la relacion con otras clases

    public PremioPelicula(int id_premio, int id_pelicula, String nombre_certamen, String ciudad_celebracion, Premio premio, Pelicula pelicula){
        this(id_premio, id_pelicula, nombre_certamen, ciudad_celebracion);
        this.premio = premio;
        this.pelicula = pelicula;
    }

    //Getters y Setters

    public int getId_premio(){ return id_premio; }

    public void setId_premio(int id_premio){ this.id_premio = id_premio; }

    public Premio getPremio(){ return premio; }

    public void setPremio(Premio premio) { this.premio = premio; }

    public int getId_pelicula(){ return id_pelicula; }

    public void setId_pelicula(int idPelicula){ this.id_pelicula = idPelicula; }

    public Pelicula getPelicula(){ return pelicula; }

    public void setPelicula(Pelicula pelicula) { this.pelicula = pelicula; }

    public String getNombre_certamen(){ return nombre_certamen; }

    public void setNombre_certamen(String nombre_certamen){ this.nombre_certamen = nombre_certamen; }

    public String getCiudad_celebracion(){ return ciudad_celebracion; }

    public void setCiudad_celebracion(String ciudad_celebracion){ this.ciudad_celebracion = ciudad_celebracion; }

}
