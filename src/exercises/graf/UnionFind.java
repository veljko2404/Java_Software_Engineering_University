package exercises.graf;

import java.util.Collections;
import java.util.Vector;

public class UnionFind {
	
	private Vector<Integer> parent;

	public UnionFind(int n) {
		super();
		this.parent = new Vector<Integer>();
		this.parent.setSize(n);
		Collections.fill(this.parent, -1);
	}
	
	public boolean isConnected(int cvor1, int cvor2){
		int cvor1Component, cvor2Component;
		cvor1Component = findRootOfComponent(cvor1);
		cvor2Component = findRootOfComponent(cvor2);
		return(cvor1Component == cvor2Component);
	}
	
	public void connect(int cvor1, int cvor2){
		int cvor1Component = findRootOfComponent(cvor1);
		int cvor2Component = findRootOfComponent(cvor2);
		parent.set(cvor2Component, cvor1Component);
	}

	private int findRootOfComponent(int cvor) {
		// TODO Auto-generated method stub
		int root = cvor;
		while(parent.get(root) != -1)
			root = parent.get(root);
		return root;
	}
	
	

}
