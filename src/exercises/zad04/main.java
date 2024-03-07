package exercises.zad04;

//Odštampati svaki element liste stringova.
//Izbrisati string Test ako postoji iz liste. Koristiti Iterator.

import java.util.ArrayList;
import java.util.Iterator;

public class main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("test1");
        list.add("test2");
        list.add("test3");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            if (element.equals("test2")) {
                iterator.remove();
            }
        }
        iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
