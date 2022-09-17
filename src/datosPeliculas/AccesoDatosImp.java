package datosPeliculas;

import java.io.*;
import java.util.*;

import dominio.Pelicula;

public class AccesoDatosImp implements AccesoDatos {
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula);
            salida.close();
            System.out.println("Se ha escrito en el archivo");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void crear(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        }
    }

    public boolean existe(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    public void buscar(String nombreArchivo, String buscar) {
        var archivo = new File(nombreArchivo);
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            while (lectura!=null){
                if (lectura.contains(buscar)) {System.out.println("Se ha encontrado la pelicula en el archivo");break;}
                else System.out.println("No se encontro nada");
                System.out.println();
                lectura=entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void borrar (String nombreArchivo){
        File archivo = new File (nombreArchivo);
        if (archivo.delete()){
            System.out.println("El archivo ha sido borrado satisfactoriamente");
        }
        else
             System.out.println("El archivo no ha sido borrado satisfactoriamente");
    }
    public  List<Pelicula> listar (String nombre){
        List arraylist = new ArrayList();
        var archivo = new File(nombre);
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            while (lectura!=null){
                arraylist.add(lectura);
                lectura=entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(arraylist);
        return arraylist;
    }
}
