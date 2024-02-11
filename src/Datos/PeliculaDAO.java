package Datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PeliculaDAO {
    private static final Logger LOGGER = Logger.getLogger(PeliculaDAO.class.getName());

    public boolean insertarPelicula(Pelicula pelicula) {
        String sql = "INSERT INTO pelicula (titulo_pelicula, fecha_estreno, lugar_estreno, id_critica) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, pelicula.getTitulo_pelicula());
            ps.setDate(2, new java.sql.Date(pelicula.getFecha_estreno().getTime()));
            ps.setString(3, pelicula.getLugar_estreno());
            ps.setInt(4, pelicula.getId_critica());

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        pelicula.setId_pelicula(generatedKeys.getInt(1));
                        return true;
                    }
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al insertar la película", ex);
        }
        return false;
    }

    public boolean actualizarPelicula(Pelicula pelicula) {
        String sql = "UPDATE pelicula SET titulo_pelicula = ?, fecha_estreno = ?, lugar_estreno = ?, id_critica = ? WHERE id_pelicula = ?";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, pelicula.getTitulo_pelicula());
            ps.setDate(2, new java.sql.Date(pelicula.getFecha_estreno().getTime()));
            ps.setString(3, pelicula.getLugar_estreno());
            ps.setInt(4, pelicula.getId_critica());
            ps.setInt(5, pelicula.getId_pelicula());

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al actualizar la película", ex);
        }
        return false;
    }

    public boolean eliminarPelicula(int idPelicula) {
        String sql = "DELETE FROM pelicula WHERE id_pelicula = ?";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPelicula);

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al eliminar la película", ex);
        }
        return false;
    }

    public List<Pelicula> obtenerPeliculas() {
        List<Pelicula> peliculas = new ArrayList<>();
        String sql = "SELECT p.id_pelicula, p.titulo_pelicula, p.fecha_estreno, p.lugar_estreno, p.id_critica, c.nombre_medio AS nombre_critica FROM pelicula p LEFT JOIN critica c ON p.id_critica = c.id_critica";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Pelicula pelicula = new Pelicula(
                        rs.getInt("id_pelicula"),
                        rs.getString("titulo_pelicula"),
                        rs.getDate("fecha_estreno"),
                        rs.getString("lugar_estreno"),
                        rs.getInt("id_critica"),
                        rs.getString("nombre_critica") // Asume que has añadido este campo en tu clase Pelicula
                );
                peliculas.add(pelicula);
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al obtener las películas", ex);
        }
        return peliculas;
    }


    public Pelicula obtenerPeliculaPorId(int idPelicula) {
        String sql = "SELECT p.*, c.nombre_medio AS nombre_critica FROM pelicula p LEFT JOIN critica c ON p.id_critica = c.id_critica WHERE p.id_pelicula = ?";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPelicula);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Pelicula pelicula = new Pelicula(
                            rs.getInt("id_pelicula"),
                            rs.getString("titulo_pelicula"),
                            rs.getDate("fecha_estreno"),
                            rs.getString("lugar_estreno"),
                            rs.getInt("id_critica"),
                            rs.getString("nombre_critica")
                    );
                    return pelicula;
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al obtener la película por ID", ex);
        }
        return null;
    }

}
