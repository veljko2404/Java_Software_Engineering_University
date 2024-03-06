package exercises.zad02;

import java.util.Iterator;

//Implementirati generičku klasu koja predstavlja niz.
//Koristiti ArrayList i Iterator.
public class main {
    public static void main(String[] args) {
        DynamicArray<Integer> arr = new DynamicArray<Integer>();
        arr.add(5); arr.add(7); arr.add(1);

        Iterator<Integer> iterator = arr.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
