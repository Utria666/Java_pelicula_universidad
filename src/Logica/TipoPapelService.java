package Logica;

import Datos.TipoPapel;
import Datos.TipoPapelDAO;
import java.util.List;

public class TipoPapelService {
    private TipoPapelDAO tipoPapelDAO;

    public TipoPapelService() {
        this.tipoPapelDAO = new TipoPapelDAO();
    }

    public boolean registrarTipoPapel(String nombrePapel) {
        TipoPapel tipoPapel = new TipoPapel();
        tipoPapel.setNombre_papel(nombrePapel);
        return tipoPapelDAO.insertarTipoPapel(tipoPapel);
    }

    public boolean actualizarTipoPapel(int idPapel, String nombrePapel) {
        TipoPapel tipoPapel = new TipoPapel(idPapel, nombrePapel);
        return tipoPapelDAO.actualizarTipoPapel(tipoPapel);
    }

    public boolean eliminarTipoPapel(int idPapel) {
        return tipoPapelDAO.eliminarTipoPapel(idPapel);
    }

    public List<TipoPapel> listarTiposPapel() {
        return tipoPapelDAO.obtenerTiposPapel();
    }

    public TipoPapel obtenerTipoPapelPorId(int idPapel) {
        return tipoPapelDAO.obtenerTipoPapelPorId(idPapel);
    }
}
