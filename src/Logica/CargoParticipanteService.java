package Logica;

import Datos.CargoParticipante;
import Datos.CargoParticipanteDAO;
import java.util.List;

public class CargoParticipanteService {
    private CargoParticipanteDAO cargoDAO;

    public CargoParticipanteService() {
        this.cargoDAO = new CargoParticipanteDAO();
    }

    public boolean registrarCargo(String nombreCargo) {
        CargoParticipante cargo = new CargoParticipante();
        cargo.setNombre_cargo(nombreCargo);
        return cargoDAO.insertarCargo(cargo);
    }

    public boolean actualizarCargo(int idCargo, String nombreCargo) {
        CargoParticipante cargo = new CargoParticipante(idCargo, nombreCargo);
        return cargoDAO.actualizarCargo(cargo);
    }

    public boolean eliminarCargo(int idCargo) {
        return cargoDAO.eliminarCargo(idCargo);
    }

    public List<CargoParticipante> listarCargos() {
        return cargoDAO.obtenerCargos();
    }

    public CargoParticipante obtenerCargoPorId(int idCargo) {
        return cargoDAO.obtenerCargoPorId(idCargo);
    }
}
