package exercises.zad10;

public class Point<T extends Number> extends Number implements IMera {
    private T x;
    private T y;

    public Point(T x, T y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double getMera() {
        return Math.sqrt(x.doubleValue()*x.doubleValue() + y.doubleValue() + y.doubleValue());
    }

     @Override public String toString(){
        return STR."(\{x},\{y})" + ", distance: " + getMera();
     }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
}
