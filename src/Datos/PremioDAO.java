package Datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PremioDAO {
    private static final Logger LOGGER = Logger.getLogger(PremioDAO.class.getName());

    public boolean insertarPremio(Premio Premio) {
        String sql = "INSERT INTO premio (nombre_premio) VALUES (?)";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, Premio.getNombre_premio());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        Premio.setId_premio(generatedKeys.getInt(1));
                        return true;
                    }
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al insertar el premio", ex);
        }
        return false;
    }

    public boolean actualizarPremio(Premio Premio) {
        String sql = "UPDATE premio SET nombre_premio = ? WHERE id_premio = ?";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, Premio.getNombre_premio());
            ps.setInt(2, Premio.getId_premio());

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al actualizar el premio", ex);
            return false;
        }
    }

    public boolean eliminarPremio(int idPremio) {
        String sql = "DELETE FROM premio WHERE id_premio = ?";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPremio);

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al eliminar el premio", ex);
            return false;
        }
    }

    public List<Premio> obtenerPremios() {
        List<Premio> premios = new ArrayList<>();
        String sql = "SELECT * FROM premio";
        try (Connection con = Conexion.obtenerConexion(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                premios.add(new Premio(rs.getInt("id_premio"), rs.getString("nombre_premio")));
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al obtener los premios", ex);
        }
        return premios;
    }

    public Premio obtenerPremioPorId(int idPremio) {
        String sql = "SELECT * FROM premio WHERE id_premio = ?";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPremio);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Premio(rs.getInt("id_premio"), rs.getString("nombre_premio"));
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al obtener el premio", ex);
        }
        return null;
    }
}
