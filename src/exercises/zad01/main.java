package exercises.zad01;

import java.util.*;

//Formirati genericku listu (ArrayList) celih brojeva i
//naci sumu njenih elemenata. Koristiti Iterator.
public class main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(6);
        list.add(3);
        list.add(8);
        int sum = 0;

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int element = iterator.next();
            sum += element;
        }
        System.out.println(sum);
    }
}
