package exercises.zad23;

public class VisitDown implements Strategy {
    int n, m;

    public VisitDown(int n, int m) {
        this.n = n;
        this.m = m;
    }

    @Override
    public int nextI(int i, int j) {
        if (i == n - 1) return 0;
        return i + 1;
    }

    @Override
    public int nextJ(int i, int j) {
        if (i == n - 1) return j + 1;
        return j;
    }
}
