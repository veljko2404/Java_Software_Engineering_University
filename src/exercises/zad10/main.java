package exercises.zad10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Definisati apstraktnu klasu IMera, sa metodom getMera koja će dati neku meru
objekta tipa double. Napisati generičku klasu Tacka, odredjenu koordinatama,
gde se tip xkoordinate i ykoordinate može zadati. Tačke su iste ako su
na istoj udaljensti od koordinatnog početka.
*/
public class main {
    public static void main(String[] args) {
        Point<Integer> a = new Point<Integer>(1, 2);
        Point<Integer> b = new Point<Integer>(2, 1);
        Point<Integer> c = new Point<Integer>(6, 8);
        ArrayList<Point<Integer>> points = new ArrayList<>();
        points.add(a);
        points.add(b);
        points.add(c);
        HashMap<Double, Point<Integer>> allPoints = new HashMap<>();
        for (int i = 0; i < points.size(); i++) {
            Point<Integer> t = points.get(i);
            if (!allPoints.containsKey(t.getMera())) {
                allPoints.put(t.getMera(), t);
            }
        }
        for (Map.Entry<Double, Point<Integer>> data : allPoints.entrySet()) {
            System.out.println(data.getValue());
        }
    }

}
