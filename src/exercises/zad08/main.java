package exercises.zad08;

import java.util.ArrayList;
import java.util.Iterator;

/*
Implementirati generičku klasu koja predstavlja matricu ArrayList<ArrayList<Integer>>.
Kreirati iterator koji obilazi samo ne nula elemente matrice, uvek se kreće dole-desno i uvek
bira najbliži element. Ukoliko ima više mogućnosti iterator obilazi element koji se nalazi u
najmanjoj vrsti. Prvi element je ne nula element u najmanjoj vrsti. Rastojanje od aij do akl
je |k − i| + |l − j|.
0 0 1 0 5 0
2 0 0 3 0 4
6 0 0 0 7 5
0 8 0 9 0 1
0 0 1 0 0 0
1->5->4->5->1
*/
public class main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> m = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row;
        row = new ArrayList<Integer>();
        row.add(0);
        row.add(0);
        row.add(1);
        row.add(0);
        row.add(5);
        row.add(0);
        m.add(row);
        row = new ArrayList<Integer>();
        row.add(2);
        row.add(0);
        row.add(0);
        row.add(3);
        row.add(0);
        row.add(4);
        m.add(row);
        row = new ArrayList<Integer>();
        row.add(6);
        row.add(0);
        row.add(0);
        row.add(0);
        row.add(7);
        row.add(5);
        m.add(row);
        row = new ArrayList<Integer>();
        row.add(0);
        row.add(8);
        row.add(0);
        row.add(9);
        row.add(0);
        row.add(1);
        m.add(row);
        row = new ArrayList<Integer>();
        row.add(0);
        row.add(0);
        row.add(1);
        row.add(0);
        row.add(0);
        row.add(0);
        m.add(row);
        int rows = 5, columns = 6;

        Matrix matrix = new Matrix(m, rows, columns);
        Iterator<Integer> iterator = matrix.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
