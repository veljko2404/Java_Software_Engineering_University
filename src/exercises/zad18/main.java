package exercises.zad18;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/*
Data je mapa tipa HashMap<Integer, Integer>. Formirati dve mape od nje tako da prva sadrzi
samo parne kljuceve a druga samo neparne.
*/
public class main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            map.put(random.nextInt(100), random.nextInt(100));
        }
        HashMap<Integer, Integer> oddKeys = new HashMap<>();
        HashMap<Integer, Integer> evenKeys = new HashMap<>();
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            int value = map.get(key);
            if (key % 2 == 0) {
                evenKeys.put(key, value);
            } else {
                oddKeys.put(key, value);
            }
        }
        System.out.println("Even keys:");
        Iterator<Integer> evenIterator = evenKeys.keySet().iterator();
        while (evenIterator.hasNext()) {
            System.out.println(evenIterator.next());
        }
        System.out.println("Odd keys:");
        Iterator<Integer> oddIterator = oddKeys.keySet().iterator();
        while (oddIterator.hasNext()) {
            System.out.println(oddIterator.next());
        }
    }
}
