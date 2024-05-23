package exercises.zad23;

public class VisitRight implements Strategy {
    int n, m;

    public VisitRight(int n, int m) {
        this.n = n;
        this.m = m;
    }

    @Override
    public int nextI(int i, int j) {
        if (j == m - 1) return i + 1;
        return i;
    }

    @Override
    public int nextJ(int i, int j) {
        if (j == m - 1) return 0;
        return j + 1;
    }
}
