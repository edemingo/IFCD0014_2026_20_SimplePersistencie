package es.edemingo;

import es.edemingo.modelo.Serie;
import es.edemingo.persistencia.interfaces.ISeriesDAO;
import es.edemingo.persistencia.factory.SerieDATOFactory;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        Scanner scanner = new Scanner(System.in);
        crearSerie(scanner);
        scanner.close();
        */

        ISeriesDAO sdf = SerieDATOFactory.getSerieDAOImpl();
        sdf.create(new Serie("Superman", "Ciencia Ficcion",2));

    }


    public static void selectorSerie(){

        int action;
        boolean salir = false;

        Scanner scanner = new Scanner(System.in);

        while (!salir) {

            System.out.println("Selecciona una opcion: ");
            System.out.println("1 - Buscar Serie ");
            System.out.println("2 - Crear Serie ");
            System.out.println("3 - Borrar Serie ");
            System.out.println("4 - Listar Series ");
            System.out.println("5 - Salir");

            int opcionSelected = scanner.nextInt();
            //scanner.nextLine(); // limpiar buffer

            System.out.println("PASO 0");

            switch (opcionSelected) {

                case 1:
                    buscarSerie(scanner);
                    break;
                case 2:
                    crearSerie(scanner);
                    break;
                case 3:
                    borrarSerie(scanner);
                    break;
                case 4:
                    listarSeries();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");

            }


            if (opcionSelected == 1) {
                buscarSerie(scanner);

            } else if (opcionSelected == 2) {
                crearSerie(scanner);


            } else if (opcionSelected == 3) {
                borrarSerie(scanner);

            } else {
                //No hacemos nada
            }

        }

        scanner.close();
        System.out.println("Programa finalizado.");

    }

    public static void buscarSerie(Scanner scanner){


        System.out.println("PASO POR buscarSerie");
        System.out.print("Introduzca el Título de la serie: ");
        String valor1 = scanner.nextLine();

        ISeriesDAO sdf = SerieDATOFactory.getSerieDAOImpl();
        Serie serie = sdf.read(valor1);
        System.out.println(serie);


    }

    public static void crearSerie(Scanner scanner){

            System.out.println("PASO POR crearSerie");
            System.out.print("Introduzca el Título de la serie: ");
            String valor1 = scanner.nextLine();

            System.out.print("Indique el género de la serie: ");
            String valor2 = scanner.nextLine();

            System.out.print("Indique en numero de temporadas: ");
            Integer valor3 = scanner.nextInt();

            System.out.println("Título ingresado: " + valor1);
            System.out.println("Género ingresado: " + valor2);
            System.out.println("Número de temporadas: " + valor3);

            ISeriesDAO sdf = SerieDATOFactory.getSerieDAOImpl();
            sdf.create(new Serie(valor1,valor2, 8));
    }

    public static void borrarSerie(Scanner scanner){


        System.out.println("PASO POR borrarSerie");
        System.out.print("Introduzca el Título de la serie a eliminar: ");
        String valor1 = scanner.nextLine();

        ISeriesDAO sdf = SerieDATOFactory.getSerieDAOImpl();
        sdf.delete(valor1);

        System.out.println("Serie eliminada.");

    }

    public static void listarSeries(){

        ISeriesDAO sdf = SerieDATOFactory.getSerieDAOImpl();
        List<Serie> resultado = sdf.readAll();

        System.out.println(resultado);

    }
}


