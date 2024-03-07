package exercises.zad03;

//Formirati celobrojnu generičku matricu (ArrayList<ArrayList<Integer>>)
//i odštampati je, naći sumu na glavnoj i na sporednoj dijagonali.
//1 2 3
//4 5 6
//7 8 9

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> row = new ArrayList<Integer>();
        row.add(1);
        row.add(2);
        row.add(3);
        matrix.add(row);

        row = new ArrayList<>();
        row.add(4);
        row.add(5);
        row.add(6);
        matrix.add(row);

        row = new ArrayList<>();
        row.add(7);
        row.add(8);
        row.add(9);
        matrix.add(row);

        int n = 3, m = 3;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(STR."\{matrix.get(i).get(j)} ");
            }
            System.out.println();
        }

        int mainSum = 0;
        for (int i = 0; i < n; i++) {
            mainSum += matrix.get(i).get(i);
        }
        System.out.println("Main sum: " + mainSum);

        int secondarySum = 0;
        for (int i = 0; i < n; i++) {
            secondarySum += matrix.get(i).get(m - 1 - i);
        }
        System.out.println("Secondary sum: " + secondarySum);
    }
}
