package Datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TipoPapelDAO {
    private static final Logger LOGGER = Logger.getLogger(TipoPapelDAO.class.getName());

    public boolean insertarTipoPapel(TipoPapel tipoPapel) {
        String sql = "INSERT INTO tipo_papel (nombre_papel) VALUES (?)";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, tipoPapel.getNombre_papel());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        tipoPapel.setId_papel(generatedKeys.getInt(1));
                        return true;
                    }
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al insertar el tipo de papel", ex);
        }
        return false;
    }

    public boolean actualizarTipoPapel(TipoPapel tipoPapel) {
        String sql = "UPDATE tipo_papel SET nombre_papel = ? WHERE id_papel = ?";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, tipoPapel.getNombre_papel());
            ps.setInt(2, tipoPapel.getId_papel());

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al actualizar el tipo de papel", ex);
            return false;
        }
    }

    public boolean eliminarTipoPapel(int idPapel) {
        String sql = "DELETE FROM tipo_papel WHERE id_papel = ?";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPapel);

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al eliminar el tipo de papel", ex);
            return false;
        }
    }

    public List<TipoPapel> obtenerTiposPapel() {
        List<TipoPapel> tiposPapel = new ArrayList<>();
        String sql = "SELECT * FROM tipo_papel";
        try (Connection con = Conexion.obtenerConexion(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                tiposPapel.add(new TipoPapel(rs.getInt("id_papel"), rs.getString("nombre_papel")));
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al obtener los tipos de papel", ex);
        }
        return tiposPapel;
    }

    public TipoPapel obtenerTipoPapelPorId(int idPapel) {
        String sql = "SELECT * FROM tipo_papel WHERE id_papel = ?";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPapel);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new TipoPapel(rs.getInt("id_papel"), rs.getString("nombre_papel"));
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al obtener el tipo de papel", ex);
        }
        return null;
    }
}
