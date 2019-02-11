package exo2.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SeLit {
    void lecture(Scanner source) {

        while(source.hasNextLine()) {
            System.out.println("Indiquer un fichier à lire :");
            String s = source.nextLine();

            File file = new File(s);

            if(!file.exists() || file.isDirectory()) {
                System.out.println("Le fichier n'existe pas ou est un dossier");
                return;
            }

            

        }
    }

    static public void main(String[] args) {
        SeLit seLit = new SeLit();
        seLit.lecture(new Scanner(System.in));
    }
}