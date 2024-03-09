package exercises.zad07;

public class Node<T> {
    T element;
    Node<T> next;

    public Node(T x) {
        element = x;
        next = null;
    }
}
