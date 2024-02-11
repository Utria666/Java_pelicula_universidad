package Logica;

import Datos.Premio;
import Datos.PremioDAO;
import java.util.List;

public class PremioService {
    private PremioDAO premioDAO;

    public PremioService() {
        this.premioDAO = new PremioDAO();
    }

    public boolean registrarPremio(String nombrePremio) {
        Premio Premio = new Premio();
        Premio.setNombre_premio(nombrePremio);
        return premioDAO.insertarPremio(Premio);
    }

    public boolean actualizarPremio(int idPremio, String nombrePremio) {
        Premio Premio = new Premio(idPremio, nombrePremio);
        return premioDAO.actualizarPremio(Premio);
    }

    public boolean eliminarPremio(int idPremio) {
        return premioDAO.eliminarPremio(idPremio);
    }

    public List<Premio> listarPremios() {
        return premioDAO.obtenerPremios();
    }

    public Premio obtenerPremioPorId(int idPremio) {
        return premioDAO.obtenerPremioPorId(idPremio);
    }
}
