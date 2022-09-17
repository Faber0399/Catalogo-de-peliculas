package pelicula_negocio;

import datosPeliculas.AccesoDatos;
import datosPeliculas.AccesoDatosImp;
import dominio.Pelicula;

public class CatalogoPeliculaImp implements CatalogoPelicula{
    public void agregarPelicula(Pelicula pelicula, String nombreArchivo, boolean anexar){
        AccesoDatos file = new AccesoDatosImp();
        file.escribir(pelicula,nombreArchivo,anexar);
    }
    public void iniciarArchivo(String nombreArchivo){
        AccesoDatos file = new AccesoDatosImp();
        file.crear(nombreArchivo);
    }
    public void buscarPelicula (String nombreArchivo, String buscar){
        AccesoDatos file = new AccesoDatosImp();
        file.buscar(nombreArchivo, buscar);
    }
    public void listarPeliculas (String nombreArchivo){
        AccesoDatos file = new AccesoDatosImp();
        file.listar(nombreArchivo);
    }
}
