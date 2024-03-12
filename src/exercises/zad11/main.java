package exercises.zad11;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;

/*
Implementurati klasu Pravougaonik (Tacka a, Tacka b).
Učitavati sekvencu pravougaonika iz fajla ”ulaz.txt”
sve dok se ne pojavi pravougaonik koji je već učitan.
*/
public class main {
    public static void main(String[] args) throws FileNotFoundException {
        URL url = main.class.getResource("rectangles.txt");
        File file = new File(url.getPath());
        Scanner scanner = new Scanner(file);
        HashSet<Rectangle> rectangles = new HashSet<>();
        while (true) {
            Rectangle r = new Rectangle(scanner.nextInt(), scanner.nextInt());
            if (!rectangles.contains(r)) {
                rectangles.add(r);
            } else {
                break;
            }
        }
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }
    }
}
