package es.edemingo;

import es.edemingo.modelo.Serie;
import es.edemingo.persistencia.interfaces.ISeriesDAO;
import es.edemingo.persistencia.factory.SerieDATOFactory;

import java.util.Scanner;

public class Main {
    static void main() {

        int action;

        Scanner scanner = new Scanner(System.in);

            System.out.println("Selecciona una opcion: ");
            System.out.println("1 - Buscar Serie ");
            System.out.println("2 - Crear Serie ");
            System.out.print("3 - Borrar Serie: ");

            int opcionSelected = scanner.nextInt();

            if (opcionSelected == 1){
                buscarSerie();

            } else if (opcionSelected == 2) {
                crearSerie();


            } else if (opcionSelected == 3){
                borrarSerie();

            }
            else {
                //No hacemos nada
            }


        scanner.close();

    }

    public static void buscarSerie(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca el Título de la serie: ");
        String valor1 = scanner.nextLine();

        ISeriesDAO sdf = SerieDATOFactory.getSerieDAOImpl();
        Serie serie = sdf.read(valor1);
        System.out.println(serie);

        scanner.close();
    }

    public static void crearSerie(){

        Scanner scanner = new Scanner(System.in);

            System.out.print("Introduzca el Título de la serie: ");
            String valor1 = scanner.nextLine();

            System.out.print("Indique el género de la serie: ");
            String valor2 = scanner.nextLine();

            System.out.print("Indique en numero de temporadas: ");
            Integer valor3 = scanner.nextInt();

        scanner.close();

            System.out.println("Título ingresado: " + valor1);
            System.out.println("Género ingresado: " + valor2);
            System.out.println("Número de temporadas: " + valor3);

            ISeriesDAO sdf = SerieDATOFactory.getSerieDAOImpl();
            sdf.create(new Serie(valor1,valor2, 8));
    }

    public static void borrarSerie(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca el Título de la serie a eliminar: ");
        String valor1 = scanner.nextLine();
        scanner.close();

        ISeriesDAO sdf = SerieDATOFactory.getSerieDAOImpl();
        sdf.delete(valor1);

    }
}


