package exercises.zad09;

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

    public class MatrixIterator implements Iterator<Integer> {
        int currentRow;
        int currentColumn;
        boolean stuck;

        public MatrixIterator(int currRow, int currColumn) {
            currentRow = currRow;
            currentColumn = currColumn;
            stuck = false;
        }

        @Override
        public boolean hasNext() {
            if (currentRow >= n || currentColumn >= m || stuck) {
                return false;
            }
            return true;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("");
            }
            int top = Integer.MAX_VALUE, bottom = Integer.MAX_VALUE, left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
            if (currentRow > 0) top = mat.get(currentRow - 1).get(currentColumn);
            if (currentRow < n - 1) bottom = mat.get(currentRow + 1).get(currentColumn);
            if (currentColumn > 0) left = mat.get(currentRow).get(currentColumn - 1);
            if (currentRow > m - 1) right = mat.get(currentRow).get(currentColumn + 1);
            int minValue = Integer.min(left, Integer.min(bottom, Integer.min(right, top)));
            if (minValue >= mat.get(currentRow).get(currentColumn)) {
                stuck = true;
                throw new RuntimeException("Ball got stuck!");
            }
            if (top == minValue) {
                currentRow--;
                return top;
            } else if (right == minValue) {
                currentColumn++;
                return right;
            } else if (bottom == minValue) {
                currentRow++;
                return bottom;
            } else {
                currentColumn--;
                return left;
            }
        }
    }

    public Iterator<Integer> iterator(int currRow, int currColumn) {
        return new MatrixIterator(currRow, currColumn);
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result += STR."\{mat.get(i).get(j)} ";
            }
            result += "\n";
        }
        return result;
    }
}