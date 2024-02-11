package Datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParticipanteDAO {
    private static final Logger LOGGER = Logger.getLogger(ParticipanteDAO.class.getName());

    public boolean insertarParticipante(Participante participante) {
        String sql = "INSERT INTO participante (nombre_participante, direccion, telefono, fecha_nacimiento, lugar_nacimiento, estado_civil) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) { // Modificado para obtener claves generadas

            ps.setString(1, participante.getNombre_participante());
            ps.setString(2, participante.getDireccion());
            ps.setInt(3, participante.getTelefono());
            ps.setDate(4, new java.sql.Date(participante.getFecha_nacimiento().getTime()));
            ps.setString(5, participante.getLugar_nacimiento());
            ps.setString(6, participante.getEstado_civil());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        participante.setId_participante(generatedKeys.getInt(1)); // Asigna el ID generado al objeto participante
                        return true;
                    }
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al insertar el participante", ex);
        }
        return false;
    }

    public boolean actualizarParticipante(Participante participante) {
        String sql = "UPDATE participante SET nombre_participante = ?, direccion = ?, telefono = ?, fecha_nacimiento = ?, lugar_nacimiento = ?, estado_civil = ? WHERE id_participante = ?";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, participante.getNombre_participante());
            ps.setString(2, participante.getDireccion());
            ps.setInt(3, participante.getTelefono());
            ps.setDate(4, new java.sql.Date(participante.getFecha_nacimiento().getTime()));
            ps.setString(5, participante.getLugar_nacimiento());
            ps.setString(6, participante.getEstado_civil());
            ps.setInt(7, participante.getId_participante());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al actualizar el participante", ex);
            return false;
        }
    }

    public boolean eliminarParticipante(int id_participante) {
        String sql = "DELETE FROM participante WHERE id_participante = ?";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id_participante);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al eliminar el participante", ex);
            return false;
        }
    }

    public List<Participante> obtenerParticipantes() {
        List<Participante> participantes = new ArrayList<>();
        String sql = "SELECT * FROM participante";
        try (Connection con = Conexion.obtenerConexion();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Participante parti = new Participante();
                parti.setId_participante(rs.getInt("id_participante"));
                parti.setNombre_participante(rs.getString("nombre_participante"));
                parti.setDireccion(rs.getString("direccion"));
                parti.setTelefono(rs.getInt("telefono"));
                parti.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                parti.setLugar_nacimiento(rs.getString("lugar_nacimiento"));
                parti.setEstado_civil(rs.getString("estado_civil"));
                participantes.add(parti);
            }
            return participantes;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al obtener los participantes", ex);
            return new ArrayList<>();
        }
    }

        public Participante obtenerParticipantePorId(int id_participante) {
            String sql = "SELECT * FROM participante WHERE id_participante = ?";
            Participante participante = null;

            try (Connection con = Conexion.obtenerConexion();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, id_participante);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    participante = new Participante();
                    participante.setId_participante(rs.getInt("id_participante"));
                    participante.setNombre_participante(rs.getString("nombre_participante"));
                    participante.setDireccion(rs.getString("direccion"));
                    participante.setTelefono(rs.getInt("telefono"));
                    participante.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                    participante.setLugar_nacimiento(rs.getString("lugar_nacimiento"));
                    participante.setEstado_civil(rs.getString("estado_civil"));
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error al obtener el participante", ex);
            }
            return participante;
        }
}