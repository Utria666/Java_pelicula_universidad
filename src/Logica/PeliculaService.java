package Logica;

import Datos.Pelicula;
import Datos.PeliculaDAO;
import java.util.Date;
import java.util.List;

public class PeliculaService {
    private PeliculaDAO peliculaDAO;

    public PeliculaService() {
        this.peliculaDAO = new PeliculaDAO();
    }

    public boolean registrarPelicula(String titulo, Date fechaEstreno, String lugarEstreno, int idCritica) {
        Pelicula pelicula = new Pelicula(0, titulo, fechaEstreno, lugarEstreno, idCritica);
        return peliculaDAO.insertarPelicula(pelicula);
    }

    public boolean actualizarPelicula(int idPelicula, String titulo, Date fechaEstreno, String lugarEstreno, int idCritica) {
        Pelicula pelicula = new Pelicula(idPelicula, titulo, fechaEstreno, lugarEstreno, idCritica);
        return peliculaDAO.actualizarPelicula(pelicula);
    }

    public boolean eliminarPelicula(int idPelicula) {
        return peliculaDAO.eliminarPelicula(idPelicula);
    }

    public List<Pelicula> listarPeliculas() {
        return peliculaDAO.obtenerPeliculas();
    }

    public Pelicula obtenerPeliculaPorId(int idPelicula) {
        return peliculaDAO.obtenerPeliculaPorId(idPelicula);
    }
}
