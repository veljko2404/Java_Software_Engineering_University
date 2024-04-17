package exercises.zad19;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/*
Data je mapa tipa HashMap<Integer, Integer>. Naci sve vrednosti u mapi koji su istovremeno i kljuceni.
*/
public class main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            map.put(random.nextInt(50), random.nextInt(50));
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            int value = map.get(key);
            if (map.containsKey(value)) {
                System.out.println(STR."Value \{value} is both key and value");
            }
        }
        Iterator<Integer> iterator2 = map.keySet().iterator();
        while (iterator2.hasNext()) {
            int key = iterator2.next();
            int value = map.get(key);
            System.out.println(STR."Key = \{key}, value = \{value}");
        }
    }
}
