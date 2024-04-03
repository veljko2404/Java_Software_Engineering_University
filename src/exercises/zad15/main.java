package exercises.zad15;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Ucitava se niz elemenata iz fajla. Program treba za svaki ucitani element da ispise
koliko je vec jednakih elemenata vec ucitano.

 */
public class main {
    public static void main(String[] args) throws FileNotFoundException {
        URL url = main.class.getResource("elements.txt");
        File file = new File(url.getPath());
        Scanner scanner = new Scanner(file);
        HashMap<Integer, Integer> data = new HashMap<>();
        while (scanner.hasNext()) {
            Integer newElement = scanner.nextInt();
            if (data.containsKey(newElement)) {
                Integer currentCountOfElements = data.get(newElement);
                currentCountOfElements++;
                data.put(newElement, currentCountOfElements);
            } else {
                data.put(newElement, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
            System.out.println(STR."\{entry.getKey()} appears \{entry.getValue()} times");
        }
    }
}
