package Controller;

import Model.BST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TranslateModule {


    public static BST<WordAssociation> englishTree = new BST<>();
    public static BST<WordAssociation> frenchTree = new BST<>();
    public static BST<WordAssociation> espTree = new BST<>();



    public static String translaterawtext(Scanner scanner) {
        System.out.println("¿Cual es el texto que deseas traducir?");
        String porTraducir = scanner.nextLine().toLowerCase();
        System.out.println("¿A que idioma desea traducirlo?(Español,Ingles,Frances)");
        String idioma = scanner.nextLine();


        return Translation(TokenMaker(porTraducir),idioma);
    }


    public static ArrayList<String> TokenMaker(String texto) {

        // Separar el texto en tokens usando espacios
        String[] tokenArray = texto.split(" ");

        return new ArrayList<>(Arrays.asList(tokenArray));
    }

    public static String Translation(ArrayList<String> tokens, String idioma){
            ArrayList<String> translatedtokens = new ArrayList<>();
        switch (idioma){
            case "Español":


                for (String palabra: tokens){

                    if (englishTree.contains(new WordAssociation(palabra,""))){
                        WordAssociation result = englishTree.search(new WordAssociation(palabra, ""));
                        String[]  palabras = result.getValue().split(",");
                        String palabraesp = palabras[0];
                          translatedtokens.add(palabraesp);

                    }else if (frenchTree.contains(new WordAssociation(palabra,""))){
                        WordAssociation result = frenchTree.search(new WordAssociation(palabra, ""));
                        String[] palabras = result.getValue().split(",");

                        String palabraesp = palabras[1];
                        translatedtokens.add(palabraesp);

                    }else if (espTree.contains(new WordAssociation(palabra,""))){
                        translatedtokens.add(palabra);
                    }else{
                        translatedtokens.add("*"+palabra+"*");
                    }


                }






                break;
            case "Ingles":

                for (String palabra: tokens){

                    if (espTree.contains(new WordAssociation(palabra,""))){
                        WordAssociation result = espTree.search(new WordAssociation(palabra, ""));
                        String[]  palabras = result.getValue().split(",");
                        String palabraesp = palabras[0];
                        translatedtokens.add(palabraesp);

                    }else if (frenchTree.contains(new WordAssociation(palabra,""))){
                        WordAssociation result = frenchTree.search(new WordAssociation(palabra, ""));
                        String[] palabras = result.getValue().split(",");
                        String palabraesp = palabras[0];
                        translatedtokens.add(palabraesp);

                    }else if (englishTree.contains(new WordAssociation(palabra,""))){
                        translatedtokens.add(palabra);
                    }else{
                        translatedtokens.add("*"+palabra+"*");
                    }


                }


                break;
            case "Frances":

                for (String palabra: tokens){

                    if (espTree.contains(new WordAssociation(palabra,""))){
                        WordAssociation result = espTree.search(new WordAssociation(palabra, ""));
                        String[]  palabras = result.getValue().split(",");
                        String palabraesp = palabras[1];
                        translatedtokens.add(palabraesp);

                    }else if (englishTree.contains(new WordAssociation(palabra,""))){
                        WordAssociation result = englishTree.search(new WordAssociation(palabra, ""));
                        String[] palabras = result.getValue().split(",");
                        String palabraesp = palabras[1];
                        translatedtokens.add(palabraesp);

                    }else if (frenchTree.contains(new WordAssociation(palabra,""))){
                        translatedtokens.add(palabra);
                    }else{
                        translatedtokens.add("*"+palabra+"*");
                    }


                }
                break;

            default:
                System.out.println("No se encontro este idioma... intentalo de nuevo");
        }

        String traduccion = "";
       for (String translatedword: translatedtokens){
           traduccion = traduccion + translatedword+" ";
       }




        return traduccion;
    }

    public static void showBSTs(){
        System.out.println("--------------ENGLISH----------------");
        // Print the English dictionary in order
        englishTree.printTree(englishTree.getRoot());
        System.out.println("--------------FRENCH----------------");
        // Print the French dictionary in order
        frenchTree.printTree(frenchTree.getRoot());
        System.out.println("--------------EESPAÑOL----------------");
        espTree.printTree(espTree.getRoot());
        System.out.println("---------------------------------");
    }


    public static String translateDocumenttext(String texto , Scanner scanner){
        System.out.println("¿A que idioma desea traducirlo?(Español,Ingles,Frances)");
        String idioma = scanner.nextLine();

        return Translation(TokenMaker(texto),idioma);
    }


}
