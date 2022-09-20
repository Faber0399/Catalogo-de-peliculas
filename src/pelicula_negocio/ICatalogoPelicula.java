package pelicula_negocio;

import dominio.Pelicula;

public interface ICatalogoPelicula {
    String NombreRecurso = "Peliculas_Faber";

    void agregarPelicula(Pelicula pelicula, String nombreArchivo, boolean anexar) ;

    void listarPeliculas(String nombreArchivo);

    void buscarPelicula(String nombreArchivo, String buscar);

    void iniciarArchivo(String nombreArchivo);

}
