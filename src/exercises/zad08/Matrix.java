package exercises.zad08;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Matrix {
    public ArrayList<ArrayList<Integer>> mat;
    public int n;
    public int m;

    public Matrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        this.mat = mat;
        this.n = n;
        this.m = m;
    }

    class MatrixIterator implements Iterator<Integer> {
        int indexRow;
        int indexColumn;
        boolean firstTimeRunning = true;

        public MatrixIterator() {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (mat.get(i).get(j) != 0) {
                        indexRow = i;
                        indexColumn = j;
                        return;
                    }
                }
            }
            indexRow = n;
            indexColumn = m;
        }

        @Override
        public boolean hasNext() {
            if ((indexRow >= n) || (indexColumn >= m)) {
                return false;
            }
            return true;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("");
            }
            int tmp = mat.get(indexRow).get(indexColumn);
            int minDistance = m + n;
            int closestRow = n;
            int closestColumn = m;
            for (int i = indexRow; i < n; i++) {
                for (int j = indexColumn; j < m; j++) {
                    if (i == indexRow && j == indexColumn && !firstTimeRunning) {
                        continue;
                    }
                    firstTimeRunning = false;
                    if (mat.get(i).get(j) != 0) {
                        int distance = (i - indexRow) + (j - indexColumn);
                        if (distance < minDistance) {
                            minDistance = distance;
                            closestRow = i;
                            closestColumn = j;
                            tmp = mat.get(i).get(j);
                        }
                    }
                }
            }
            indexRow = closestRow;
            indexColumn = closestColumn;
            return tmp;
        }
    }

    public Iterator<Integer> iterator() {
        return new MatrixIterator();
    }
}
