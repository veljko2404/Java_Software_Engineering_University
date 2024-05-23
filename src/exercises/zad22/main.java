package exercises.zad22;

import java.util.ArrayList;
import java.util.Random;

/*
Na beskonacnoj sahovskoj tabli postoji četiri tipa figura: pijun, konj, kraljica i joker. Pijun
može da se pomeri najviše jedno polje po horizontali, vertikali ili dijagonali, kraljica
najviše p polja, a konj se pomera u Г (dva polja po horizontali i jedno po vertikali ili
obratno). Joker može da se kreće ili kao pijun ili kao kraljica ili kao konj. Kada tabla kreira
novog joker-a on se kreće kao pijun. Može da promeni način kretanja.
Figura se pomera na slucajan nacin ili se pomera najbrze ka nekom ciljnom polju (od svih
mogucih polja pomera se na ono najblize cilju).
Rastojanje izmedju polja (i, j) i (k, l) je |i - k| + |j - l|.
Klase: Figura, Pijun, Konj, Kraljica, Joker, ...
*/
class Coordinate {
    private int i, j;

    public Coordinate(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}

class Figure {
    private Coordinate coordinate;
    PossibleFields strategy1;
    Choose strategy2;

    public Figure(Choose choose, PossibleFields possibleFields) {
        coordinate = new Coordinate(0, 0);
        strategy1 = possibleFields;
        strategy2 = choose;
    }

    public void setStrategy1(PossibleFields strategy1) {
        this.strategy1 = strategy1;
    }

    public void setStrategy2(Choose strategy2) {
        this.strategy2 = strategy2;
    }

    public void move() {
        ArrayList<Coordinate> list = strategy1.fields(coordinate.getI(), coordinate.getJ());
        coordinate = strategy2.choose(list);
    }
}

interface PossibleFields {
    public ArrayList<Coordinate> fields(int i, int j);
}

interface Choose {
    public Coordinate choose(ArrayList<Coordinate> list);
}

class Strategy_Pawn implements PossibleFields {

    @Override
    public ArrayList<Coordinate> fields(int i, int j) {
        ArrayList<Coordinate> list = new ArrayList<>();
        list.add(new Coordinate(i, j));
        list.add(new Coordinate(i + 1, j));
        list.add(new Coordinate(i - 1, j));
        list.add(new Coordinate(i + 1, j + 1));
        list.add(new Coordinate(i + 1, j - 1));
        list.add(new Coordinate(i - 1, j + 1));
        list.add(new Coordinate(i - 1, j - 1));
        list.add(new Coordinate(i, j + 1));
        list.add(new Coordinate(i, j - 1));
        return list;
    }
}

class Strategy_Horse implements PossibleFields {

    @Override
    public ArrayList<Coordinate> fields(int i, int j) {
        ArrayList<Coordinate> list = new ArrayList<>();
        list.add(new Coordinate(i, j));
        list.add(new Coordinate(i + 2, j + 1));
        list.add(new Coordinate(i + 2, j - 1));
        list.add(new Coordinate(i + 1, j + 2));
        list.add(new Coordinate(i + 1, j - 2));
        list.add(new Coordinate(i - 2, j + 1));
        list.add(new Coordinate(i - 2, j - 1));
        list.add(new Coordinate(i - 1, j + 2));
        list.add(new Coordinate(i - 1, j - 2));
        return list;
    }
}

class Strategy_Queen implements PossibleFields {
    private int p;

    public Strategy_Queen(int p) {
        this.p = p;
    }

    @Override
    public ArrayList<Coordinate> fields(int i, int j) {
        ArrayList<Coordinate> list = new ArrayList<>();
        list.add(new Coordinate(i, j));
        for (int k = 1; k <= p; k++) {
            list.add(new Coordinate(i, j + k));
            list.add(new Coordinate(i, j - k));
            list.add(new Coordinate(i + k, j));
            list.add(new Coordinate(i - k, j));
            list.add(new Coordinate(i + k, j + k));
            list.add(new Coordinate(i + k, j - k));
            list.add(new Coordinate(i - k, j + k));
            list.add(new Coordinate(i - k, j - k));
        }

        return list;
    }
}

class StrategyGoal implements Choose {
    private int goal_i, goal_j;

    public StrategyGoal(int goal_i, int goal_j) {
        this.goal_i = goal_i;
        this.goal_j = goal_j;
    }

    @Override
    public Coordinate choose(ArrayList<Coordinate> list) {
        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            Coordinate coordinate = list.get(i);
            int distance = Math.abs(goal_i - coordinate.getI()) + Math.abs(goal_j - coordinate.getJ());
            if (distance < min) {
                min = distance;
                index = i;
            }
        }
        return list.get(index);
    }
}

class Pawn extends Figure {

    public Pawn(Choose choose) {
        super(choose, new Strategy_Pawn());
    }

    @Override
    public void setStrategy1(PossibleFields strategy1) {
    }
}

class Queen extends Figure {

    public Queen(Choose choose, PossibleFields possibleFields, int p) {
        super(choose, new Strategy_Queen(p));
    }

    @Override
    public void setStrategy1(PossibleFields strategy1) {
    }
}

class Horse extends Figure {

    public Horse(Choose choose, PossibleFields possibleFields) {
        super(choose, new Strategy_Horse());
    }

    @Override
    public void setStrategy1(PossibleFields strategy1) {
    }
}

class Joker extends Figure {
    public Joker(Choose choose) {
        super(choose, new Strategy_Pawn());
    }
}

class StrategyRandom implements Choose {

    @Override
    public Coordinate choose(ArrayList<Coordinate> list) {
        int n = list.size();
        Random random = new Random();
        return list.get(random.nextInt(n));
    }
}

public class main {
    public static void main(String[] args) {

    }
}
