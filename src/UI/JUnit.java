package UI;
import Controller.ReadFile;
import com.sun.java.accessibility.util.Translator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import Controller.WordAssociation;
import Model.BST;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static Controller.TranslateModule.*;
import static org.junit.Assert.assertEquals;

public class JUnit {

    public static BST<WordAssociation> englishTree = new BST<>();
    public static BST<WordAssociation> frenchTree = new BST<>();
    public static BST<WordAssociation> espTree = new BST<>();



    @Test
    public void testTranslationToSpanish() {
        ReadFile.ReadFile();
        ArrayList<String> tokens = new ArrayList<>(Arrays.asList("house","dog","town"));
        String translatedText = Translation(tokens, "Español");
        assertEquals("casa perro pueblo ", translatedText);
    }

    @Test
    public void testTranslationToEnglish() {
        ReadFile.ReadFile();
        ArrayList<String> tokens = new ArrayList<>(Arrays.asList("casa", "perro", "pueblo"));
        String translatedText = Translation(tokens, "Ingles");
        assertEquals("house dog town ", translatedText);
    }

    @Test
    public void testTranslationToFrench() {
        ReadFile.ReadFile();
        ArrayList<String> tokens = new ArrayList<>(Arrays.asList("casa", "perro", "pueblo"));
        String translatedText = Translation(tokens, "Frances");
        assertEquals(" loger  chien  ville ", translatedText);
    }

}
