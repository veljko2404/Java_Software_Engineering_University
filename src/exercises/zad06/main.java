package exercises.zad06;

import java.util.Iterator;

//Implementirati generičku klasu koja predstavlja niz.
// Kreirati Iterator koji prolazi kroz svaki 5 element niza.
public class main {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<Integer>();
        for (int i = 0; i < 15; i++) {
            arr.add(i);
        }

        Iterator<Integer> iterator = arr.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
