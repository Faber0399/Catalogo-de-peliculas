package pelicula_negocio;

import dominio.Pelicula;

public interface CatalogoPelicula {
    void agregarPelicula(Pelicula pelicula, String nombreArchivo, boolean anexar);
    void listarPeliculas (String nombreArchivo);
    void buscarPelicula (String nombreArchivo, String buscar);
    void iniciarArchivo(String nombreArchivo);

}
