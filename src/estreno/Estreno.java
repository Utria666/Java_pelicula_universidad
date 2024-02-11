package estreno;

import Datos.Pelicula;
import Logica.PeliculaService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Estreno {

    public static void main(String[] args) {
        PeliculaService peliculaService = new PeliculaService();

        try {
            // Formato de fecha para la entrada
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaEstreno = sdf.parse("2023-12-25");
//
//            System.out.println("Registrando una nueva película...");
//            boolean registrado = peliculaService.registrarPelicula("Titulo Nueva Película", fechaEstreno, "Ciudad Estreno", 3); // Asumiendo que 1 es un ID de crítica válido
//            if (registrado) {
//                System.out.println("Película registrada con éxito.\n");
//            } else {
//                System.out.println("No se pudo registrar la película.\n");
//            }

            // Listar todas las películas
            System.out.println("Listado de películas:");
            List<Pelicula> peliculas = peliculaService.listarPeliculas();
            for (Pelicula pelicula : peliculas) {
                System.out.println(pelicula.getTitulo_pelicula() + " - " + pelicula.getFecha_estreno().toString() + " - " + pelicula.getLugar_estreno() + " - " + pelicula.getNombreCritica());
            }
//
//            // Actualizar una película
//            // Aquí necesitarías obtener el ID de una película existente para actualizarla
//            System.out.println("\nActualizando una película...");
//            boolean actualizado = peliculaService.actualizarPelicula(1, "Titulo Actualizado", fechaEstreno, "Nuevo Lugar Estreno", 4); // Asumiendo que 1 es un ID de película válido y 2 es otro ID de crítica válido
//            if (actualizado) {
//                System.out.println("Película actualizada con éxito.\n");
//            } else {
//                System.out.println("No se pudo actualizar la película.\n");
//            }
//
//            // Eliminar una película
//            // Nuevamente, asegúrate de que el ID sea de una película que se pueda eliminar
//            System.out.println("Eliminando una película...");
//            boolean eliminado = peliculaService.eliminarPelicula(1); // Asumiendo que 1 es un ID de película válido
//            if (eliminado) {
//                System.out.println("Película eliminada con éxito.\n");
//            } else {
//                System.out.println("No se pudo eliminar la película.\n");
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
