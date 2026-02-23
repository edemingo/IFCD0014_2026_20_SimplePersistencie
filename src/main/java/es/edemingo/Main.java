package es.edemingo;

import es.edemingo.modelo.Serie;
import es.edemingo.persistencia.SerieDAOFileImpl;

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

        SerieDAOFileImpl sdf = new SerieDAOFileImpl();
        sdf.create(new Serie(valor1,valor2, 8));

    }
}
