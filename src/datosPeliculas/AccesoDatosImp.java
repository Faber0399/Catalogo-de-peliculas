package datosPeliculas;

import java.io.*;
import java.util.*;
import dominio.Pelicula;
import paquete_excepciones.*;

public class AccesoDatosImp implements IAccesoDatos {
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatos {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula);
            salida.close();
            System.out.println("Se ha escrito en el archivo: "+pelicula);
        } catch (IOException e) {
            e.printStackTrace();
            throw new EscrituraDatos("No se encontro el archivo, no se pudo escribir en el archivo. Por favor revise el nombre del archivo."+e.getMessage());
        }
    }

    public void crear(String nombreArchivo) throws AccesoDatosExcepciones {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (IOException e) {
            e.printStackTrace(System.out);
            throw new AccesoDatosExcepciones("No se pudo crear el archivo");
        }
    }

    public boolean existe(String nombreArchivo) throws AccesoDatosExcepciones {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    public void buscar(String nombreArchivo, String buscar) throws LecturaDatos{
        var archivo = new File(nombreArchivo);
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            int ind = 1;
            while (lectura != null) {
                if (lectura.contains(buscar)) {
                    System.out.println("Se ha encontrado la pelicula: "+ buscar+" la linea es: "+ ind);
                    break;
                }
                ind++;
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new LecturaDatos("No se encontro el archivo, por favor intente con un nombre de archivo valido"+e.getMessage());

        } catch (IOException e) {
            e.printStackTrace();
            throw new LecturaDatos("No se encontro el archivo, por favor intente con un nombre de archivo valido"+e.getMessage());
        }
    }

    public void borrar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()&&archivo.delete()) {
            System.out.println("El archivo ha sido borrado satisfactoriamente");
        } else
            System.out.println("El archivo no ha sido borrado satisfactoriamente");
    }

    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatos {
        List<Pelicula> arraylist = new ArrayList<>();
        var archivo = new File(nombreArchivo);
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            while (lectura != null) {
                Pelicula pelicula = new Pelicula(lectura);
                arraylist.add(pelicula);
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new LecturaDatos("No se encontro el archivo, por favor intente con un nombre de archivo valido"+e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new LecturaDatos("No se encontro el archivo, por favor intente con un nombre de archivo valido"+e.getMessage());
        }
        System.out.println(arraylist);
        return arraylist;
    }
}
