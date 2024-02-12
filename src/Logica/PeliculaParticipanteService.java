package Logica;

import Datos.PeliculaParticipante;
import Datos.PeliculaParticipanteDAO;
import java.util.List;

public class PeliculaParticipanteService {

    private PeliculaParticipanteDAO peliculaParticipanteDAO;

    public PeliculaParticipanteService(){
        this.peliculaParticipanteDAO = new PeliculaParticipanteDAO();
    }

    public boolean registrarPeliculaParticipante(int id_pelicula, int id_participante, int id_cargo, int id_papel, double sueldo){
        PeliculaParticipante peliculaParticipante = new PeliculaParticipante(id_pelicula, id_participante, id_cargo, id_papel, sueldo);
        return peliculaParticipanteDAO.insertarPeliculaParticipante(peliculaParticipante);
    }

    public boolean actualizarPeliculaParticipante(int id_cargo, int id_papel, double sueldo, int id_pelicula, int id_participante){
        PeliculaParticipante peliculaParticipante = new PeliculaParticipante(id_pelicula, id_participante, id_cargo, id_papel, sueldo);
        return peliculaParticipanteDAO.actualizarPeliculaParticipante(peliculaParticipante);
    }

    public boolean eliminarPeliculaParticipante(int id_pelicula, int id_participante){
        return peliculaParticipanteDAO.eliminarPeliculaParticipante(id_pelicula, id_participante);
    }

    public List<PeliculaParticipante> listarPeliculasParticipantes(){
        return peliculaParticipanteDAO.obtenerPeliculasParticipantes();
    }


    public List<PeliculaParticipante> obtenerPeliculaParticipantePorId(int id_pelicula){
        return peliculaParticipanteDAO.obtenerPeliculaParticipantePorId(id_pelicula);
    }


}
