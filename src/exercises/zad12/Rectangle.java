package exercises.zad12;

public class Rectangle implements Comparable<Rectangle> {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle() {
        this.width = 0;
        this.height = 0;
    }

    @Override
    public String toString() {
        return STR."Width: \{width}, height; \{height}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle rectangle)) return false;
        return width == rectangle.width && height == rectangle.height;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + width;
        result = prime * result + height;
        return result;
    }

    @Override
    public int compareTo(Rectangle o) {
        if (width * height < o.width * o.height) {
            return -1;
        } else if (width * height == o.width * o.height){
            return 0;
        } else {
            return 1;
        }
    }
}
