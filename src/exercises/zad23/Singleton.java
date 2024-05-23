package exercises.zad23;

public class Singleton {
    private static Singleton instance = null;
    private int[][] matrix;
    private int n, m, i, j;
    Visit visit;

    private Singleton(int[][] matrix, int n, int m, Visit visit) {
        this.matrix = matrix;
        this.n = n;
        this.m = m;
        this.i = 0;
        this.j = 0;
        this.visit = visit;
    }

    public static Singleton getInstance(int[][] matrix, int n, int m, Visit visit) {
        if (instance == null) return new Singleton(matrix, n, m, visit);
        else return instance;
    }

    public void startVisiting() {
        printCurrentPosition("FirstElement");
        int countedOdd = 0;
        int countedEven = 0;
        while (i < n && j < m) {
            if (visit == Visit.Right) {
                i = new VisitRight(n, m).nextI(i, j);
                j = new VisitRight(n, m).nextJ(i, j);
                if (i == n || j == m) break;
                if (matrix[i][j] % 2 == 1) countedOdd++;
                if (countedOdd == 10) {
                    countedOdd = 0;
                    visit = Visit.Down;
                }
                printCurrentPosition("Right");
            } else {
                i = new VisitDown(n, m).nextI(i, j);
                j = new VisitDown(n, m).nextJ(i, j);
                if (i == n || j == m) break;
                if (matrix[i][j] % 2 == 1) countedEven++;
                if (countedEven == 5) {
                    countedEven = 0;
                    visit = Visit.Right;
                }
                printCurrentPosition("Down");
            }

        }
    }

    private void printCurrentPosition(String methodVisiting) {
        System.out.println(STR."(\{i}, \{j}, -> \{matrix[i][j]}, \{methodVisiting})");
    }
}
