package estreno;

import Datos.*;
import Logica.PeliculaParticipanteService;
import Logica.PeliculaService;
import Logica.PremioPeliculaService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Estreno {

    public static void main(String[] args) {
//        PeliculaService peliculaService = new PeliculaService();
//
//        try {
//            // Formato de fecha para la entrada
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Date fechaEstreno = sdf.parse("2023-12-25");
////
////            System.out.println("Registrando una nueva película...");
////            boolean registrado = peliculaService.registrarPelicula("Titulo Nueva Película", fechaEstreno, "Ciudad Estreno", 3); // Asumiendo que 1 es un ID de crítica válido
////            if (registrado) {
////                System.out.println("Película registrada con éxito.\n");
////            } else {
////                System.out.println("No se pudo registrar la película.\n");
////            }
//
//            // Listar todas las películas
////            System.out.println("                                                 Listado de películas:");
////            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
////            System.out.println("  Nombre pelicula  //  Fecha estreno  //  Lugar estreno  ///    Nombre medio  //  Fecha publicacion  //  Nombre autor  //  Resumen critica");
////            List<Pelicula> peliculas = peliculaService.listarPeliculas();
////            for (Pelicula pelicula : peliculas) {
////                Critica critica = pelicula.getCritica(); // Obtener la crítica asociada a la película
////                System.out.println(pelicula.getTitulo_pelicula() + " - " + pelicula.getFecha_estreno().toString() + " - " + pelicula.getLugar_estreno() + " - " + critica.getNombre_medio() +  " - " + critica.getNombre_autor() +  " - " + critica.getFecha_publicacion().toString() +  " - " + critica.getResumen_critica());
////            }
//
//            //Listar una pelicula por id
//            System.out.println("                                                 Listado de películas:");
//            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
//            System.out.println("  Nombre pelicula  //  Fecha estreno  //  Lugar estreno  ///    Nombre medio  //  Nombre autor  //  Fecha publicacion  //  Resumen critica");
//            Pelicula pelicula1 = peliculaService.obtenerPeliculaPorId(1);
//            Critica critica = pelicula1.getCritica();
//            System.out.println(pelicula1.getTitulo_pelicula() + " - " + pelicula1.getFecha_estreno().toString() + " - " + pelicula1.getLugar_estreno() + " - " + critica.getNombre_medio() +  " - " + critica.getNombre_autor() +  " - " + critica.getFecha_publicacion().toString() +  " - " + critica.getResumen_critica());
//
//
////            // Actualizar una película
////            // Aquí necesitarías obtener el ID de una película existente para actualizarla
////            System.out.println("\nActualizando una película...");
////            boolean actualizado = peliculaService.actualizarPelicula(1, "Titulo Actualizado", fechaEstreno, "Nuevo Lugar Estreno", 4); // Asumiendo que 1 es un ID de película válido y 2 es otro ID de crítica válido
////            if (actualizado) {
////                System.out.println("Película actualizada con éxito.\n");
////            } else {
////                System.out.println("No se pudo actualizar la película.\n");
////            }
////
////            // Eliminar una película
////            // Nuevamente, asegúrate de que el ID sea de una película que se pueda eliminar
////            System.out.println("Eliminando una película...");
////            boolean eliminado = peliculaService.eliminarPelicula(1); // Asumiendo que 1 es un ID de película válido
////            if (eliminado) {
////                System.out.println("Película eliminada con éxito.\n");
////            } else {
////                System.out.println("No se pudo eliminar la película.\n");
////            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //----------------------------------------------------------------------

//        PremioPeliculaService premioPeliculaService = new PremioPeliculaService();
//
//        try {
//            // Formato de fecha para la entrada
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
////            Date fechaEstreno = sdf.parse("2023-12-25");
//
//
////            System.out.println("Registrando un nuevo premio...");
////            boolean registrado = premioPeliculaService.registrarPremioPelicula(8,2, "Los grammys", "Colombia");
////            if (registrado) {
////                System.out.println("Premio de pelicula registrada con éxito.\n");
////            } else {
////                System.out.println("No se pudo registrar el premio de pelicula.\n");
////            }
////
////             //Listar todos los premios de películas
////            System.out.println("                        Listado de los premios de las películas:");
////            System.out.println("---------------------------------------------------------------------------------");
////            System.out.println("  Nombre pelicula  //  Nombre premio  //  Nombre certamen  //  Ciudad celebracion ");
////            List<PremioPelicula> premioPeliculas = premioPeliculaService.listarPremiosPeliculas();
////            for (PremioPelicula premioPelicula : premioPeliculas) {
////                Premio premio = premioPelicula.getPremio();
////                Pelicula pelicula = premioPelicula.getPelicula();
////                System.out.println(pelicula.getTitulo_pelicula() + " - " + premio.getNombre_premio() + " - " + premioPelicula.getNombre_certamen() + " - " + premioPelicula.getCiudad_celebracion());
////            }
////
//            //Listar un premio de pelicula por id
////            System.out.println("                        Listado de los premios de las películas:");
////            System.out.println("---------------------------------------------------------------------------------");
////            System.out.println("  Nombre pelicula  //  Nombre premio  //  Nombre certamen  //  Ciudad celebracion ");
////            PremioPelicula premioPelicula = premioPeliculaService.obtenerPremioPeliculaPorId(4);
////            Premio premio = premioPelicula.getPremio();
////            Pelicula pelicula = premioPelicula.getPelicula();
////            System.out.println(pelicula.getTitulo_pelicula() + " - " + premio.getNombre_premio() + " - " + premioPelicula.getNombre_certamen() + " - " + premioPelicula.getCiudad_celebracion());
//
////
////            // Actualizar un premio de película
////            System.out.println("\nActualizando datos...");
////            boolean actualizado = premioPeliculaService.actualizarPremioPelicula(8, "Los Oscars", "Estados Unidos",  2);
////            if (actualizado) {
////                System.out.println("Premio de pelicula actualizada con éxito.\n");
////            } else {
////                System.out.println("No se pudo actualizar el premio de pelicula.\n");
////            }
//////
////            // Eliminar un premio de película
////            System.out.println("Eliminando un premio de película...");
////            boolean eliminado = premioPeliculaService.eliminarPremioPelicula(2, 8);
////            if (eliminado) {
////                System.out.println("Premio de pelicula eliminada con éxito.\n");
////            } else {
////                System.out.println("No se pudo eliminar el premio de la pelicula.\n");
////            }
////
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//


        //----------------------------------------------------------------------------

        PeliculaParticipanteService peliculaParticipanteService = new PeliculaParticipanteService();

        try {
            // Formato de fecha para la entrada
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
////            Date fechaEstreno = sdf.parse("2023-12-25");
//
//
//            System.out.println("Registrando un nuevo participante en una pelicula...");
//            boolean registrado = peliculaParticipanteService.registrarPeliculaParticipante(2,2, 4, 7, 62000);
//            if (registrado) {
//                System.out.println("participante en pelicula registrado con éxito.\n");
//            } else {
//                System.out.println("No se pudo registrar el participante en la pelicula.\n");
//            }
////
             //Listar todos los participantes de las películas
            System.out.println("                     Listado de los participantes de las películas:");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("   Nombre pelicula   //   Nombre participante   //   Cargo   //   Papel   //   Sueldo ");
            List<PeliculaParticipante> peliculaParticipantes = peliculaParticipanteService.listarPeliculasParticipantes();
            for (PeliculaParticipante peliculaParticipante : peliculaParticipantes) {
                Pelicula pelicula = peliculaParticipante.getPelicula();
                Participante participante = peliculaParticipante.getParticipante();
                CargoParticipante cargoParticipante = peliculaParticipante.getCargoParticipante();
                TipoPapel tipoPapel = peliculaParticipante.getTipoPapel();
                System.out.println(pelicula.getTitulo_pelicula() + " - " + participante.getNombre_participante() + " - " + cargoParticipante.getNombre_cargo() + " - " + tipoPapel.getNombre_papel() + " - " + peliculaParticipante.getSueldo() );
            }
//
////            Listar los participantes de una pelicula por id
//            System.out.println("                     Listado de los participantes de las películas:");
//            System.out.println("--------------------------------------------------------------------------------------");
//            System.out.println("   Nombre pelicula   //   Nombre participante   //   Cargo   //   Papel   //   Sueldo ");
//            List <PeliculaParticipante> peliculaParticipante = peliculaParticipanteService.obtenerPeliculaParticipantePorId(1);
//            for(PeliculaParticipante peliculaParticipante1: peliculaParticipante){
//                Pelicula pelicula = peliculaParticipante1.getPelicula();
//                Participante participante = peliculaParticipante1.getParticipante();
//                CargoParticipante cargoParticipante = peliculaParticipante1.getCargoParticipante();
//                TipoPapel tipoPapel = peliculaParticipante1.getTipoPapel();
//                System.out.println(pelicula.getTitulo_pelicula() + " - " + participante.getNombre_participante() + " - " + cargoParticipante.getNombre_cargo() + " - " + tipoPapel.getNombre_papel() + " - " + peliculaParticipante1.getSueldo() );
//
//            }

////
//            // Actualizar un premio de película
//            System.out.println("\nActualizando datos...");
//            boolean actualizado = peliculaParticipanteService.actualizarPeliculaParticipante(4, 8, 33000,  1, 2);
//            if (actualizado) {
//                System.out.println("Participante de pelicula actualizado con éxito.\n");
//            } else {
//                System.out.println("No se pudo actualizar el participante de la pelicula.\n");
//            }
//////
//            // Eliminar un participante de película
//            System.out.println("Eliminando un participante de la película...");
//            boolean eliminado = peliculaParticipanteService.eliminarPeliculaParticipante(2, 2);
//            if (eliminado) {
//                System.out.println("Participante de pelicula eliminada con éxito.\n");
//            } else {
//                System.out.println("No se pudo eliminar el participante de la pelicula.\n");
//            }
////
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
