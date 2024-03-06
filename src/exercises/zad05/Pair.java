package exercises.zad05;

import exercises.zad02.DynamicArray;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Pair<T> {
    public DynamicArray<T> n1;
    public DynamicArray<T> n2;

    public Pair(){
        n1 = new DynamicArray<T>();
        n2 = new DynamicArray<T>();
    }
    public void addN1(T x){
        n1.add(x);
    }
    public void addN2(T x){
        n2.add(x);
    }
    class PairIterator implements Iterator<T> {
        int firstOrSecond;
        Iterator<T> it1;
        Iterator<T> it2;
        public PairIterator(){
            it1 = n1.iterator();
            it2 = n2.iterator();
            firstOrSecond = 1;
            if(it1.hasNext()){
                firstOrSecond = 2;
            }
        }

        @Override
        public boolean hasNext() {
            if(it1.hasNext() || it2.hasNext()){
                return true;
            }
            return false;
        }
        @Override
        public T next(){
            if(!hasNext()){
                throw new NoSuchElementException("No more elements");
            }
            if(firstOrSecond==1){
                if(it2.hasNext()){
                    firstOrSecond = 2;
                }
                return it1.next();
            } else {
                if(it1.hasNext()){
                    firstOrSecond = 1;
                }
                return it2.next();
            }
        }
    }
    public Iterator<T> iterator(){
        return new PairIterator();
    }
}
