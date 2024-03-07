package exercises.zad06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Array<T> {
    ArrayList<T> arr;
    public Array() {
        arr = new ArrayList<T>();
    }
    public void add(T x){
        arr.add(x);
    }
    public class ArrayIterator implements Iterator<T> {
        Iterator<T> iterator;
        public ArrayIterator(){
            iterator = arr.iterator();
        }
        @Override
        public boolean hasNext() {
            if(iterator.hasNext()){
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            if(iterator.hasNext()){
                iterator.next();
                if(iterator.hasNext()){
                    iterator.next();
                    if(iterator.hasNext()){
                        iterator.next();
                        if(iterator.hasNext()){
                            iterator.next();
                            if(iterator.hasNext()){
                                return iterator.next();
                            }
                        }
                    }
                }
            }
            throw new NoSuchElementException("No more elements");
        }
    }
    public Iterator<T> iterator(){
        return new ArrayIterator();
    }
}
