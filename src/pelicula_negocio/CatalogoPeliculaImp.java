package pelicula_negocio;

import datosPeliculas.*;
import dominio.Pelicula;
import paquete_excepciones.*;

public class CatalogoPeliculaImp implements ICatalogoPelicula {
    private final IAccesoDatos file;

    public CatalogoPeliculaImp() {
        this.file = new AccesoDatosImp();
    }

    public void agregarPelicula(Pelicula pelicula, String nombreArchivo, boolean anexar)  {
        
        try {
            file.escribir(pelicula, nombreArchivo, anexar);
        } catch (EscrituraDatos e) {
            System.out.println("Error al escribir en el archivo");
            e.printStackTrace();
        }
        
    }

    public void iniciarArchivo(String nombreArchivo) {

        try {
            file.crear(nombreArchivo);
        } catch (AccesoDatosExcepciones e) {
            System.out.println("Error al iniciar el archivo");
            e.printStackTrace();
        }
    }

    public void buscarPelicula(String nombreArchivo, String buscar) {

        try {
            file.buscar(nombreArchivo, buscar);
        } catch (LecturaDatos e) {
            System.out.println("Error al buscar en el archivo");
            e.printStackTrace();
        }
    }

    public void listarPeliculas(String nombreArchivo) {

        try {
            file.listar(nombreArchivo);
        } catch (LecturaDatos e) {
            System.out.println("Error al listar las peliculas en el archivo");
            e.printStackTrace();
        }
    }
}
