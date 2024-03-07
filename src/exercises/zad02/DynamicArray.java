package exercises.zad02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArray<E> {
    private final ArrayList<E> list;

    public DynamicArray() {
        list = new ArrayList<>();
    }

    public int length() {
        return list.size();
    }

    public E element(int i) {
        return list.get(i);
    }

    public void add(E x) {
        list.add(x);
    }

    class ArrIterator implements Iterator<E> {
        int index;

        ArrIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            if (index < list.size()) return true;
            else return false;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            E tmp = list.get(index);
            index++;
            return tmp;
        }
    }

    public Iterator<E> iterator() {
        return new ArrIterator();
    }
}
