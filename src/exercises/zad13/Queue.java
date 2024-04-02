package exercises.zad13;

import java.util.NoSuchElementException;
import java.util.Stack;

public class Queue<T> {
    private Stack<T> s1 = new Stack<>();
    private Stack<T> s2 = new Stack<>();

    public Queue() {}

    public void push(T e) {
        s1.push(e);
    }

    public T pop() {
        if (isEmpty())
            throw new NoSuchElementException("Empty");
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public boolean isEmpty() {
        if (s1.isEmpty() && s2.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
