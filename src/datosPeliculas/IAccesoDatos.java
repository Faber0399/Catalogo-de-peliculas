package datosPeliculas;

import java.util.List;
import dominio.Pelicula;
import paquete_excepciones.AccesoDatosExcepciones;
import paquete_excepciones.EscrituraDatos;
import paquete_excepciones.LecturaDatos;

//En esta interface principalmente se almacenan las operaciones a ejecutar en el archivo de peliculas
public interface IAccesoDatos {// Reminder: todos los metodos de una interface son abstractos
    public abstract boolean existe(String nombreArchivo) throws AccesoDatosExcepciones;

    public abstract List<Pelicula> listar(String nombre) throws LecturaDatos;

    public abstract void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatos;

    public abstract void buscar(String nombreArchivo, String buscar)throws LecturaDatos;

    public abstract void crear(String nombreArchivo) throws AccesoDatosExcepciones;

    public abstract void borrar(String nombreArchivo) throws AccesoDatosExcepciones;

}
