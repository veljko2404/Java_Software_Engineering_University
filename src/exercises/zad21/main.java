package exercises.zad21;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/*
Data je mapa tipa HashMap<Integer, Integer>. Koliko ima parova razlicite parnosti.
*/
public class main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            map.put(random.nextInt(10), random.nextInt(10));
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            int value = map.get(key);
            if (key % 2 != value % 2) {
                map2.put(key, value);
            }
        }
        Iterator<Integer> iterator2 = map2.keySet().iterator();
        while (iterator2.hasNext()) {
            int key = iterator2.next();
            int value = map2.get(key);
            System.out.println(STR."Key: \{key}, value: \{value}");
        }
    }
}
