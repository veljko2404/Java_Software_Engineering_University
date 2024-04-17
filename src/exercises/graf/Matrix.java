package exercises.graf;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Matrix {
	
	private Map<Coord, Integer> values = new TreeMap<Coord, Integer>();
	public static final int beskonacno = 2000000000;
	
	public Matrix(int n, int m){
		//super();
		//for (int i = 0; i < n; i++) {
		//	for (int j = 0; j < m; j++) {
		//		values.put(new Coord(i, j), beskonacno);
		//	}
		//}
	}
	
	public Integer get(int x, int y){
		return values.get(new Coord(x, y));
	}
	public boolean contains(int x, int y){
		return	values.containsKey(new Coord(x,y));
	}

	
	public void set(int x, int y, int value){
		values.put(new Coord(x, y), value);
	}

	private static class Coord implements Comparable<Coord>{
		int x, y;

		public Coord(int x, int y) {
		//	super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Coord o) {
			// TODO Auto-generated method stub
			if(this.x < o.x || (this.x == o.x && this.y < o.y ))
				return -1;
			if(this.x > o.x || (this.x == o.x && this.y > o.y ))
				//return -1;
				return 1;
			return 0;
		}
		
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Coord other = (Coord) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "[" + this.x + ", " + this.y +"]";
		}
	
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String matrica = "";
		for(Entry<Coord, Integer> entry : values.entrySet()){
			matrica += entry.getKey().toString() + " = " + entry.getValue() + "\n";
		}
		return matrica;
	}
}
