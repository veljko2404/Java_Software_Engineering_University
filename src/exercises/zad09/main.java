package exercises.zad09;

import java.util.ArrayList;
import java.util.Iterator;

/*
Teren je opisan matricom A formata m ×n, pri čemu vrednost aij > 0 predstavlja
visinu polja (i, j). Loptica se na početku postavlja na polje (i0, j0) i kreće se na sledeći način:
ukoliko se u nekom trenutku nalazi na polju (i, j), u sledećem prelazi na najniže susedno polje,
ukoliko je ono niže od aij . Pod susednim poljem polja (i, j), podrazumeva se polje sa gornje,
donje, leve i desne strane polja (i, j). Ukoliko nije, ostaje tu. Tada kažemo da se loptica
zaglavila. Potrebno je implementirati iterator koji obilazi matricu kao i loptica.
Ulaz:
3 5
1 7 3 4 5
6 2 0 9 6
1 2 3 7 9
Izlaz:
3 5
2 5
1 5
1 4
1 3
2 3
*/
public class main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        ArrayList<Integer> row;
        row = new ArrayList<Integer>();
        row.add(1);
        row.add(7);
        row.add(3);
        row.add(4);
        row.add(5);
        mat.add(row);
        row = new ArrayList<Integer>();
        row.add(6);
        row.add(2);
        row.add(0);
        row.add(9);
        row.add(6);
        mat.add(row);
        row = new ArrayList<Integer>();
        row.add(1);
        row.add(2);
        row.add(3);
        row.add(7);
        row.add(9);
        mat.add(row);
        Matrix matrix = new Matrix(mat, 3, 5);
        System.out.println(matrix);

        // Starting position: (2,4)
        Iterator iterator = matrix.iterator(2, 4);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
