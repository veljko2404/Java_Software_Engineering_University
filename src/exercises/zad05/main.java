package exercises.zad05;

import exercises.zad02.DynamicArray;

import java.util.Iterator;

//Implementirati generičku klasu koja u sebi ima dva polja MyArray n1, n2. Kreirati
//Iterator koji prolazi naizmenično kroz nizove n1 i n2. Koristitit Iterator.
public class main {
    public static void main(String[] args) {
        Pair<Integer> pair = new Pair<Integer>();
        pair.addN1(5); pair.addN1(3); pair.addN1(2);
        pair.addN2(8); pair.addN2(7); pair.addN2(9); pair.addN2(6);

        Iterator<Integer> iterator = pair.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
