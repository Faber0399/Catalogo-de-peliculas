package usuario;

import java.util.Scanner;

import dominio.Pelicula;
import pelicula_negocio.*;

public class ClaseUsuario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ICatalogoPelicula pelicula = new CatalogoPeliculaImp();
        var eleccion= -2;
        String nombreCatalogo;
        while(eleccion !=0){ 
            System.out.println("Elige la opcion\n 1.- Iniciar catalogo películas \n 2.- Agregar película \n 3.- Listar Películas \n 4.- Buscar Película \n 0.- Salir ");
            System.out.print("-->");
            eleccion = sc.nextInt();
            sc.nextLine();    
            switch(eleccion){
                case 1:
                    System.out.print("Por favor digita el nombre que deseas para tu catalogo: ");
                    nombreCatalogo=sc.nextLine();
                    pelicula.iniciarArchivo(nombreCatalogo);
                    break;
                case 2:
                    System.out.print("Por favor digita el nombre del catalogo donde desea agregar su pelicula: ");
                    nombreCatalogo=sc.nextLine();
                    System.out.println("Por favor digite el nombre de la pelicula que desea agregar: ");
                    String nombrePelicula = sc.nextLine();
                    Pelicula pelicula1= new Pelicula(nombrePelicula);
                    pelicula.agregarPelicula(pelicula1, nombreCatalogo,true);
                    break;
                case 3:
                    System.out.print("Por favor digita el nombre del catalogo que desea listar: ");
                    nombreCatalogo=sc.nextLine();
                    pelicula.listarPeliculas(nombreCatalogo);
                    break;
                case 4:
                   System.out.print("Por favor digita el nombre del catalogo donde desea buscar su pelicula: ");
                    nombreCatalogo=sc.nextLine();
                    System.out.print("Por favor digite el nombre de la pelicula que desea buscar en el archivo: ");
                    String peliculabuscada=sc.nextLine();
                    pelicula.buscarPelicula(nombreCatalogo, peliculabuscada);
                    break;
                case 0:
                    System.out.println("Muchas gracias por usar nuestros servicios, esperamos verte pronto!");
                    break;
            }
            } sc.close();
    }
}
