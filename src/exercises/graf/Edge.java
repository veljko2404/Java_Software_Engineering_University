package exercises.graf;

public class Edge implements Comparable<Edge>{
	
	public int pocetak;
	public int kraj;
	public int weight;
	
	public Edge(){
		super();
	}
	
	public Edge(int pocetak, int kraj, int weigth){
		super();
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.weight = weigth;
	}

	public int getPocetak() {
		return pocetak;
	}

	public void setPocetak(int pocetak) {
		this.pocetak = pocetak;
	}

	public int getKraj() {
		return kraj;
	}

	public void setKraj(int kraj) {
		this.kraj = kraj;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge e) {
		// TODO Auto-generated method stub
		if(weight < e.weight || (weight == e.weight && pocetak < e.pocetak)
				|| (weight == e.weight && pocetak == e.pocetak && kraj < e.kraj))
			return -1;
		if(weight > e.weight || (weight == e.weight && pocetak > e.pocetak)
				|| (weight == e.weight && pocetak == e.pocetak && kraj > e.kraj))
			return 1;
		return 0;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + kraj;
		result = prime * result + pocetak;
		result = prime * result + weight;
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
		Edge other = (Edge) obj;
		if (kraj != other.kraj)
			return false;
		if (pocetak != other.pocetak)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "P: " + pocetak + " K: " + kraj + " W: " + weight;
	}

}
