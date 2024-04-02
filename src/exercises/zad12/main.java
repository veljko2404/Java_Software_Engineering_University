package exercises.zad12;

import java.io.FileNotFoundException;
import java.util.*;

/*
Napisati funkciju za sortiranje niza pravougaonika koristeci TreeMap.
*/
public class main {
    public static void main(String[] args) throws FileNotFoundException {
        TreeMap<Rectangle, Integer> map = new TreeMap<>();
        ArrayList<Rectangle> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int firstRandom = random.nextInt(20);
            int secondRandom = random.nextInt(20);
            Rectangle p = new Rectangle(firstRandom, secondRandom);
            list.add(p);
            if (map.containsKey(p)) {
                int v = map.get(p);
                map.put(p, v + 1);
            } else {
                map.put(p, 1);
            }
        }

        ArrayList<Rectangle> sortedList = new ArrayList<>();
        Iterator<Rectangle> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            Rectangle p = iterator.next();
            int v = map.get(p);
            for (int i = 0; i < v; i++) {
                sortedList.add(p);
            }
        }

        System.out.println("Not sorted:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("Sorted:");
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.println(sortedList.get(i));
        }
    }
}
