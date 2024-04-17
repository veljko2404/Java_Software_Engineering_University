package exercises.zad17;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
Data je mapa tipa HashMap<Integer, Integer>. Koliko ima parova cija suma deli njihov proizvod.
*/
public class main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> mapa = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            mapa.put(random.nextInt(1, 5), random.nextInt(1, 5));
        }
        for (Map.Entry<Integer, Integer> data : mapa.entrySet()) {
            if ((data.getKey() + data.getValue()) % (data.getKey() * data.getValue()) == 0) {
                System.out.println(STR."\{data.getKey()} \{data.getValue()}");
            }
        }
    }
}
