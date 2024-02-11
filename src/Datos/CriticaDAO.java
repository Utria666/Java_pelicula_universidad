package Datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CriticaDAO {
    private static final Logger LOGGER = Logger.getLogger(CriticaDAO.class.getName());

    public boolean insertarCritica(Critica critica) {
        String sql = "INSERT INTO critica (nombre_medio, fecha_publicacion, nombre_autor, resumen_critica) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, critica.getNombre_medio());
            ps.setDate(2, new java.sql.Date(critica.getFecha_publicacion().getTime()));
            ps.setString(3, critica.getNombre_autor());
            ps.setString(4, critica.getResumen_critica());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        critica.setId_critica(generatedKeys.getInt(1));
                        return true;
                    }
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al insertar la crítica", ex);
        }
        return false;
    }

    public boolean actualizarCritica(Critica critica) {
        String sql = "UPDATE critica SET nombre_medio = ?, fecha_publicacion = ?, nombre_autor = ?, resumen_critica = ? WHERE id_critica = ?";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, critica.getNombre_medio());
            ps.setDate(2, new java.sql.Date(critica.getFecha_publicacion().getTime()));
            ps.setString(3, critica.getNombre_autor());
            ps.setString(4, critica.getResumen_critica());
            ps.setInt(5, critica.getId_critica());

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al actualizar la crítica", ex);
            return false;
        }
    }

    public boolean eliminarCritica(int idCritica) {
        String sql = "DELETE FROM critica WHERE id_critica = ?";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCritica);

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al eliminar la crítica", ex);
            return false;
        }
    }

    public List<Critica> obtenerCriticas() {
        List<Critica> criticas = new ArrayList<>();
        String sql = "SELECT * FROM critica";
        try (Connection con = Conexion.obtenerConexion(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                criticas.add(new Critica(
                        rs.getInt("id_critica"),
                        rs.getString("nombre_medio"),
                        rs.getDate("fecha_publicacion"),
                        rs.getString("nombre_autor"),
                        rs.getString("resumen_critica")
                ));
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al obtener las críticas", ex);
        }
        return criticas;
    }

    public Critica obtenerCriticaPorId(int idCritica) {
        String sql = "SELECT * FROM critica WHERE id_critica = ?";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCritica);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Critica(
                            rs.getInt("id_critica"),
                            rs.getString("nombre_medio"),
                            rs.getDate("fecha_publicacion"),
                            rs.getString("nombre_autor"),
                            rs.getString("resumen_critica")
                    );
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al obtener la crítica", ex);
        }
        return null;
    }
}
