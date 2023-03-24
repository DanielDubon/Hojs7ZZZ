package Controller;


import Model.BST;
import Model.Node;
import com.sun.nio.sctp.Association;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static Controller.TranslateModule.*;

public class ReadFile {

    public static void ReadFile() {

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("C:\\Users\\danie\\Documents\\Progra\\Hojs7ZZZ\\src\\diccionario.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(",");
                WordAssociation association =
                        new WordAssociation(words[0], words[1] + ", " + words[2]);
                englishTree.insert(association);
                frenchTree.insert(new WordAssociation(words[2], words[0] + ", " + words[1]));
                espTree.insert(new WordAssociation(words[1], words[0] + ", " + words[2]));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }



    }

    public static String text2translateReadFile(String path) {
        String texto = "";
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(path));

                String line = scanner.nextLine();
                String[] words = line.split(" ");
            for (String word: words){
                texto = texto + word+" ";
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

    return texto;

    }
}