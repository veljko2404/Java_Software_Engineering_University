package exercises.zad20;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/*
Date su dve mapa tipa HashMap<Integer, Integer>. Formirati uniju te dve mape.
*/
public class main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        HashMap<Integer, Integer> union = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            map1.put(random.nextInt(10), random.nextInt(10));
            map2.put(random.nextInt(10), random.nextInt(10));
        }

        System.out.println("Map1:");
        Iterator<Integer> iterator1 = map1.keySet().iterator();
        while (iterator1.hasNext()) {
            int key = iterator1.next();
            int value = map1.get(key);
            union.put(key, value);
            System.out.println(STR."Key: \{key}, value: \{value}");
        }

        System.out.println("Map2:");
        Iterator<Integer> iterator2 = map2.keySet().iterator();
        while (iterator2.hasNext()) {
            int key = iterator2.next();
            int value = map2.get(key);
            union.put(key, value);
            System.out.println(STR."Key: \{key}, value: \{value}");
        }

        System.out.println("Union:");
        Iterator<Integer> iterator3 = union.keySet().iterator();
        while (iterator3.hasNext()) {
            int key = iterator3.next();
            int value = union.get(key);
            System.out.println(STR."Key: \{key}, value: \{value}");
        }
    }
}
