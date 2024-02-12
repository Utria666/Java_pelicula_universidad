package Datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class PremioPeliculaDAO {

    private  static  final Logger LOGGER = Logger.getLogger(PremioPeliculaDAO.class.getName());

    public boolean insertarPremioPelicula(PremioPelicula premioPelicula){
        String sql = "INSERT INTO premio_pelicula (id_premio, id_pelicula, nombre_certamen, ciudad_celebracion) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, premioPelicula.getId_premio());
            ps.setInt(2, premioPelicula.getId_pelicula());
            ps.setString(3, premioPelicula.getNombre_certamen());
            ps.setString(4, premioPelicula.getCiudad_celebracion());

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                return true;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al insertar un premio-pelicula", ex);
        }
        return  false;
    }


    public boolean actualizarPremioPelicula(PremioPelicula premioPelicula){
        String sql = "UPDATE premio_pelicula SET id_premio = ?, nombre_certamen = ?, ciudad_celebracion = ? WHERE id_pelicula = ?";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, premioPelicula.getId_premio());
            ps.setString(2, premioPelicula.getNombre_certamen() );
            ps.setString(3, premioPelicula.getCiudad_celebracion() );
            ps.setInt(4, premioPelicula.getId_pelicula());

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al actualizar premio-pelicula", ex);
        }
        return false;
    }

    public boolean eliminarPremioPelicula(int id_premio, int id_pelicula){
        String sql = "DELETE FROM premio_pelicula WHERE id_premio = ? AND id_pelicula = ?";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id_premio);
            ps.setInt(2, id_pelicula);

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al eliminar el premio - pelicula", ex);
        }
        return false;
    }


    public List<PremioPelicula> obtenerPremiosPeliculas(){
        List<PremioPelicula> premioPeliculas = new ArrayList<>();
        String sql = "SELECT premio_pelicula.id_premio, premio_pelicula.id_pelicula, pelicula.titulo_pelicula, premio.nombre_premio, premio_pelicula.nombre_certamen, premio_pelicula.ciudad_celebracion \n" +
                "FROM premio_pelicula \n" +
                "JOIN premio ON premio_pelicula.id_premio = premio.id_premio\n" +
                "JOIN pelicula ON premio_pelicula.id_pelicula = pelicula.id_pelicula";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Premio premio = new Premio(
                        rs.getInt("id_premio"),
                        rs.getString("nombre_premio")
                );

                Pelicula pelicula = new Pelicula(
                        rs.getInt("id_pelicula"),
                        rs.getString("titulo_pelicula"),
                        null, // No se necesita fecha_estreno en esta consulta
                        null, // No se necesita lugar_estreno en esta consulta
                        0 // No se necesita id_critica en esta consulta
                );

                PremioPelicula premioPelicula = new PremioPelicula(
                        rs.getInt("id_premio"),
                        rs.getInt("id_pelicula"),
                        rs.getString("nombre_certamen"),
                        rs.getString("ciudad_celebracion"),
                        premio,
                        pelicula
                );

                premioPeliculas.add(premioPelicula);
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al obtener los premios de peliculas", ex);
        }
        return premioPeliculas;
    }


    public PremioPelicula obtenerPremioPeliculaporId(int id_pelicula){
        String sql = "SELECT premio_pelicula.id_premio, premio_pelicula.id_pelicula, pelicula.titulo_pelicula, premio.nombre_premio, premio_pelicula.nombre_certamen, premio_pelicula.ciudad_celebracion\n" +
                "FROM premio_pelicula\n" +
                "JOIN premio ON premio_pelicula.id_premio = premio.id_premio\n" +
                "JOIN pelicula ON premio_pelicula.id_pelicula = pelicula.id_pelicula\n" +
                "WHERE premio_pelicula.id_pelicula = ?";

        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id_pelicula);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Premio premio = new Premio(
                            rs.getInt("id_premio"),
                            rs.getString("nombre_premio")
                    );

                    Pelicula pelicula = new Pelicula(
                            rs.getInt("id_pelicula"),
                            rs.getString("titulo_pelicula"),
                            null, // No se necesita fecha_estreno en esta consulta
                            null, // No se necesita lugar_estreno en esta consulta
                            0 // No se necesita id_critica en esta consulta
                    );

                    PremioPelicula premioPelicula = new PremioPelicula(
                            rs.getInt("id_premio"),
                            rs.getInt("id_pelicula"),
                            rs.getString("nombre_certamen"),
                            rs.getString("ciudad_celebracion"),
                            premio,
                            pelicula
                    );
                    return premioPelicula;
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al obtener el premio de la pelicula por el ID", ex);
        }
        return null;

    }


}
