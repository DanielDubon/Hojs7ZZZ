package UI;


import java.util.Scanner;

import static Controller.ReadFile.ReadFile;
import static Controller.ReadFile.text2translateReadFile;
import static Controller.TranslateModule.*;

public class DriverProgram {
    private static boolean menu = true;


    public static void main(String[] args) {

        ReadFile();

        System.out.println("--Bienvenido al diccionario traductor (Ingles, Español, Frances)--");
        Scanner scanner = new Scanner(System.in);
        while (menu){
            System.out.println("¿Que desea realizar?");

            System.out.println("1. Traducir texto");
            System.out.println("2. Traducir documento.txt");
            System.out.println("3. Mostrar contenido en base de datos de palabras conocidas");
            System.out.println("4. Salir");
            String opcion = scanner.nextLine();
            switch (opcion){
                case "1":
                    System.out.println( translaterawtext(scanner));
                    break;

                case "2":
                    //C:\Users\danie\Documents\Progra\Hojs7ZZZ\src\texto.txt text path test
                    System.out.println("¿Cual es la direccion del archivo?");
                    String path = scanner.nextLine();
                    text2translateReadFile(path);
                    System.out.println( translateDocumenttext(text2translateReadFile(path),scanner));
                    break;

                case "3":
                    showBSTs();
                    break;

                case "4":
                    menu = false;
                    System.out.println("Adios...");
                    break;

            }

        }
    }



}
