package Logica;

import Datos.PremioPelicula;
import Datos.PremioPeliculaDAO;
import java.util.Date;
import java.util.List;

public class PremioPeliculaService {

    private  PremioPeliculaDAO premioPeliculaDAO;

    public PremioPeliculaService(){
        this.premioPeliculaDAO = new PremioPeliculaDAO();
    }

    public boolean registrarPremioPelicula(int id_premio, int id_pelicula, String nombre_certamen, String ciudad_celebracion){
        PremioPelicula premioPelicula = new PremioPelicula(id_premio, id_pelicula, nombre_certamen, ciudad_celebracion);
        return premioPeliculaDAO.insertarPremioPelicula(premioPelicula);
    }

    public boolean actualizarPremioPelicula(int id_premio, String nombre_certamen, String ciudad_celebracion, int idPelicula){
        PremioPelicula premioPelicula = new PremioPelicula(id_premio, idPelicula, nombre_certamen, ciudad_celebracion );
        return premioPeliculaDAO.actualizarPremioPelicula(premioPelicula);
    }

    public boolean eliminarPremioPelicula(int id_premio, int id_pelicula, String nombre_certamen, String ciudad_celebracion){
        return premioPeliculaDAO.eliminarPremioPeliculaEspecifico(id_premio, id_pelicula,nombre_certamen,ciudad_celebracion);
    }

    public List<PremioPelicula> listarPremiosPeliculas(){
        return premioPeliculaDAO.obtenerPremiosPeliculas();
    }

    public PremioPelicula obtenerPremioPeliculaPorId(int id_pelicula){
        return premioPeliculaDAO.obtenerPremioPeliculaporId(id_pelicula);
    }




}
