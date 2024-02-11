package Datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CargoParticipanteDAO {
    private static final Logger LOGGER = Logger.getLogger(CargoParticipanteDAO.class.getName());

    public boolean insertarCargo(CargoParticipante cargo) {
        String sql = "INSERT INTO cargo_participante (nombre_cargo) VALUES (?)";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, cargo.getNombre_cargo());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        cargo.setId_cargo(generatedKeys.getInt(1));
                        return true;
                    }
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al insertar el cargo", ex);
        }
        return false;
    }

    public boolean actualizarCargo(CargoParticipante cargo) {
        String sql = "UPDATE cargo_participante SET nombre_cargo = ? WHERE id_cargo = ?";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cargo.getNombre_cargo());
            ps.setInt(2, cargo.getId_cargo());

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al actualizar el cargo", ex);
            return false;
        }
    }

    public boolean eliminarCargo(int idCargo) {
        String sql = "DELETE FROM cargo_participante WHERE id_cargo = ?";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCargo);

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al eliminar el cargo", ex);
            return false;
        }
    }

    public List<CargoParticipante> obtenerCargos() {
        List<CargoParticipante> cargos = new ArrayList<>();
        String sql = "SELECT * FROM cargo_participante";
        try (Connection con = Conexion.obtenerConexion(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                cargos.add(new CargoParticipante(rs.getInt("id_cargo"), rs.getString("nombre_cargo")));
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al obtener los cargos", ex);
        }
        return cargos;
    }

    public CargoParticipante obtenerCargoPorId(int idCargo) {
        String sql = "SELECT * FROM cargo_participante WHERE id_cargo = ?";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCargo);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new CargoParticipante(rs.getInt("id_cargo"), rs.getString("nombre_cargo"));
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al obtener el cargo", ex);
        }
        return null;
    }
}
