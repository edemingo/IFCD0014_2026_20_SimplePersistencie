package es.edemingo;

import es.edemingo.modelo.Serie;
import es.edemingo.persistencia.ISeriesDAO;
import es.edemingo.persistencia.SerieDAOFileImpl;
import es.edemingo.util.SerieDATOFactory;

import java.util.Scanner;

public class Main {
    static void main() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca el Título de la serie: ");
        String valor1 = scanner.nextLine();

        System.out.print("Indique el género de la serie: ");
        String valor2 = scanner.nextLine();

        System.out.println("Título ingresado: " + valor1);
        System.out.println("Género ingresado: " + valor2);

        scanner.close();

        ISeriesDAO sdf = SerieDATOFactory.getSerieDAOImpl();
        /*
        //SerieDAOFileImpl sdf = new SerieDAOFileImpl();
        //sdf.create(new Serie(valor1,valor2, 8));
        */
        Serie serie = sdf.read("Juego de Tronos");
        System.out.println(serie);

    }
}
