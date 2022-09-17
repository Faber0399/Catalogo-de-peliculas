package usuario;

import java.util.Scanner;

import dominio.Pelicula;
import pelicula_negocio.CatalogoPelicula;
import pelicula_negocio.CatalogoPeliculaImp;

public class ClaseUsuario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige la opcion\n 1.- Iniciar catalogo películas \n 2.- Agregar película \n 3.- Listar Películas \n 4.- Buscar Película \n 0.- Salir ");
        System.out.print("-->");
        var eleccion = sc.nextInt();
        sc.nextLine();
        CatalogoPelicula pelicula = new CatalogoPeliculaImp();
        switch(eleccion){
            case 1:
                System.out.print("Por favor digita el nombre de tu futuro catalogo");
                String nombreCatalogo=sc.nextLine();
                pelicula.iniciarArchivo(nombreCatalogo);
                sc.nextLine();
                break;
            case 2:
                System.out.println("Por favor digite el nombre de la pelicula que desea agregar: ");
                String nombrePelicula = sc.nextLine();
                sc.nextLine();
                Pelicula pelicula1= new Pelicula(nombrePelicula);
                pelicula.agregarPelicula(pelicula1, "Catalogo de peliculas de Faber",true);
                break;
            case 3:
                pelicula.listarPeliculas("Catalogo de peliculas de Faber");
                break;
            case 4:
                System.out.print("Por favor digite el nombre de la pelicula que desea buscar en el archivo: ");
                String peliculabuscada=sc.nextLine();
                pelicula.buscarPelicula("Catalogo de peliculas de Faber", peliculabuscada);
                break;
            case 0:
                System.out.println("Muchas gracias por usar nuestros servicios, esperamos verte pronto!");
                break;
        }
    }
}
