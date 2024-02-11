package Logica;

import Datos.Critica;
import Datos.CriticaDAO;
import java.util.List;

public class CriticaService {
    private CriticaDAO criticaDAO;

    public CriticaService() {
        this.criticaDAO = new CriticaDAO();
    }

    public boolean registrarCritica(String nombreMedio, java.util.Date fechaPublicacion, String nombreAutor, String resumenCritica) {
        Critica critica = new Critica();
        critica.setNombre_medio(nombreMedio);
        critica.setFecha_publicacion(fechaPublicacion);
        critica.setNombre_autor(nombreAutor);
        critica.setResumen_critica(resumenCritica);
        return criticaDAO.insertarCritica(critica);
    }

    public boolean actualizarCritica(int idCritica, String nombreMedio, java.util.Date fechaPublicacion, String nombreAutor, String resumenCritica) {
        Critica critica = new Critica(idCritica, nombreMedio, fechaPublicacion, nombreAutor, resumenCritica);
        return criticaDAO.actualizarCritica(critica);
    }

    public boolean eliminarCritica(int idCritica) {
        return criticaDAO.eliminarCritica(idCritica);
    }

    public List<Critica> listarCriticas() {
        return criticaDAO.obtenerCriticas();
    }

    public Critica obtenerCriticaPorId(int idCritica) {
        return criticaDAO.obtenerCriticaPorId(idCritica);
    }
}
