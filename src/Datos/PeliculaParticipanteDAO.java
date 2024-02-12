package Datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class PeliculaParticipanteDAO {

    private  static  final Logger LOGGER = Logger.getLogger(PremioPeliculaDAO.class.getName());

    public boolean insertarPeliculaParticipante(PeliculaParticipante peliculaParticipante){
        String sql = "INSERT INTO pelicula_participante (id_pelicula, id_participante, id_cargo, id_papel, sueldo) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexion.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, peliculaParticipante.getId_pelicula());
            ps.setInt(2, peliculaParticipante.getId_participante());
            ps.setInt(3, peliculaParticipante.getId_cargo() );
            ps.setInt(4, peliculaParticipante.getId_papel() );
            ps.setDouble(5, peliculaParticipante.getSueldo());

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                return true;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al insertar un participante en una pelicula", ex);
        }
        return  false;
    }

    public boolean actualizarPeliculaParticipante(PeliculaParticipante peliculaParticipante){
        String sql = "UPDATE pelicula_participante SET id_cargo = ?, id_papel = ?, sueldo = ? WHERE id_pelicula = ? AND id_participante = ?";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, peliculaParticipante.getId_cargo() );
            ps.setInt(2, peliculaParticipante.getId_papel() );
            ps.setDouble(3, peliculaParticipante.getSueldo() );
            ps.setInt(4, peliculaParticipante.getId_pelicula() );
            ps.setInt(5, peliculaParticipante.getId_participante() );

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al actualizar el participante de la pelicula", ex);
        }
        return false;
    }


    public boolean eliminarPeliculaParticipante(int id_pelicula, int id_participante){
        String sql = "DELETE FROM pelicula_participante WHERE id_pelicula = ? AND id_participante = ?";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id_pelicula);
            ps.setInt(2, id_participante);

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al eliminar el participante de la pelicula", ex);
        }
        return false;
    }

    public List<PeliculaParticipante> obtenerPeliculasParticipantes(){
        List<PeliculaParticipante> peliculaParticipantes = new ArrayList<>();
        String sql = "SELECT \n" +
                "pelicula_participante.id_pelicula, \n" +
                "pelicula_participante.id_participante, \n" +
                "pelicula_participante.id_cargo, \n" +
                "pelicula_participante.id_papel, \n" +
                "pelicula.titulo_pelicula, \n" +
                "participante.nombre_participante, \n" +
                "cargo_participante.nombre_cargo, \n" +
                "IFNULL(tipo_papel.nombre_papel, 'N/A') AS nombre_papel,\n" +
                "pelicula_participante.sueldo\n" +
                "FROM pelicula_participante\n" +
                "JOIN pelicula ON pelicula_participante.id_pelicula = pelicula.id_pelicula\n" +
                "JOIN participante ON pelicula_participante.id_participante = participante.id_participante\n" +
                "JOIN cargo_participante ON pelicula_participante.id_cargo = cargo_participante.id_cargo\n" +
                "LEFT JOIN tipo_papel ON pelicula_participante.id_papel = tipo_papel.id_papel";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Pelicula pelicula = new Pelicula(
                        rs.getInt("id_pelicula"),
                        rs.getString("titulo_pelicula"),
                        null, // No se necesita fecha_estreno en esta consulta
                        null, // No se necesita lugar_estreno en esta consulta
                        0 // No se necesita id_critica en esta consulta
                );

                Participante participante = new Participante(
                        rs.getInt("id_participante"),
                        rs.getString("nombre_participante"),
                        null,
                        0,
                        null,
                        null,
                        null
                );

                CargoParticipante cargoParticipante = new CargoParticipante(
                        rs.getInt("id_cargo"),
                        rs.getString("nombre_cargo")
                );

                TipoPapel tipoPapel = new TipoPapel(
                        rs.getInt("id_papel"),
                        rs.getString("nombre_papel")
                );

                PeliculaParticipante peliculaParticipante = new PeliculaParticipante(
                        rs.getInt("id_pelicula"),
                        rs.getInt("id_participante"),
                        rs.getInt("id_cargo"),
                        rs.getInt("id_papel"),
                        rs.getDouble("sueldo"),
                        pelicula,
                        participante,
                        cargoParticipante,
                        tipoPapel
                );

                peliculaParticipantes.add(peliculaParticipante);

            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al obtener los participantes de las peliculas", ex);
        }
        return peliculaParticipantes;
    }


    public List<PeliculaParticipante> obtenerPeliculaParticipantePorId(int id_pelicula) {
        List<PeliculaParticipante> peliculaParticipantes = new ArrayList<>();
        String sql = "SELECT \n" +
                "pelicula_participante.id_pelicula, \n" +
                "pelicula_participante.id_participante, \n" +
                "pelicula_participante.id_cargo, \n" +
                "pelicula_participante.id_papel, \n" +
                "pelicula.titulo_pelicula, \n" +
                "participante.nombre_participante, \n" +
                "cargo_participante.nombre_cargo, \n" +
                "IFNULL(tipo_papel.nombre_papel, 'N/A') AS nombre_papel,\n" +
                "pelicula_participante.sueldo\n" +
                "FROM pelicula_participante\n" +
                "JOIN pelicula ON pelicula_participante.id_pelicula = pelicula.id_pelicula\n" +
                "JOIN participante ON pelicula_participante.id_participante = participante.id_participante\n" +
                "JOIN cargo_participante ON pelicula_participante.id_cargo = cargo_participante.id_cargo\n" +
                "LEFT JOIN tipo_papel ON pelicula_participante.id_papel = tipo_papel.id_papel\n" +
                "WHERE pelicula_participante.id_pelicula = ?";

        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id_pelicula);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Pelicula pelicula = new Pelicula(
                            rs.getInt("id_pelicula"),
                            rs.getString("titulo_pelicula"),
                            null, // No se necesita fecha_estreno en esta consulta
                            null, // No se necesita lugar_estreno en esta consulta
                            0 // No se necesita id_critica en esta consulta
                    );

                    Participante participante = new Participante(
                            rs.getInt("id_participante"),
                            rs.getString("nombre_participante"),
                            null,
                            0,
                            null,
                            null,
                            null
                    );

                    CargoParticipante cargoParticipante = new CargoParticipante(
                            rs.getInt("id_cargo"),
                            rs.getString("nombre_cargo")
                    );

                    TipoPapel tipoPapel = new TipoPapel(
                            rs.getInt("id_papel"),
                            rs.getString("nombre_papel")
                    );

                    PeliculaParticipante peliculaParticipante = new PeliculaParticipante(
                            rs.getInt("id_pelicula"),
                            rs.getInt("id_participante"),
                            rs.getInt("id_cargo"),
                            rs.getInt("id_papel"),
                            rs.getDouble("sueldo"),
                            pelicula,
                            participante,
                            cargoParticipante,
                            tipoPapel
                    );
                    peliculaParticipantes.add(peliculaParticipante);
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al obtener los participantes de la película por el ID", ex);
        }
        return peliculaParticipantes;
    }



}
