package exercises.zad07;

/*
Napisati generičku klasu Cvor<T> koja sadrži polja
• T element
• Cvor<T> sledeci (kada nema sledećeg cvora onda je sledeci = null)
Napisati generičku klasu Lista<T> koja sadrži polje
• Cvor<T> start
• metodu iterator(k) koja vraća Iterator koji obilazi svaki k-ti element liste počevši od
prvog elementa.
Testirati na nekom primeru
*/

import java.util.Iterator;

public class main {
    public static void main(String[] args) {
        List<Integer> list = new List<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Iterator<Integer> iterator = list.iterator(2);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
