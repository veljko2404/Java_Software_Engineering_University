package exercises.zad07;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class List<T> implements Iterable<T> {
    Node<T> start;

    public List() {
        start = null;
    }

    public void add(T x) {
        Node<T> newNode = new Node<>(x);
        if (start == null) {
            start = newNode;
        } else {
            Node<T> lastNode = findLastNode();
            lastNode.next = newNode;
        }
    }

    private Node<T> findLastNode() {
        Node<T> current = start;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    public Iterator<T> iterator(final int k) {
        return new Iterator<T>() {
            private Node<T> current = start;
            private int currentCounter = 0;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No element");
                }
                T result = current.element;
                for (int i = 0; i < k; i++) {
                    if (current.next != null) {
                        current = current.next;
                    } else {
                        current = null;
                        break;
                    }
                }
                return result;
            }
        };
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
