package datosPeliculas;

import java.util.List;

import dominio.Pelicula;
//En esta interface principalmente se almacenan las operaciones a ejecutar en el archivo de peliculas
public interface AccesoDatos {//Reminder: todos los metodos de una interface son abstractos
    public abstract boolean existe(String nombreArchivo);
    public abstract List<Pelicula> listar (String nombre);
    public abstract void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar);
    public abstract void buscar (String nombreArchivo, String buscar);
    public abstract void crear (String nombreArchivo);
    public abstract void borrar (String nombreArchivo);
    
}
