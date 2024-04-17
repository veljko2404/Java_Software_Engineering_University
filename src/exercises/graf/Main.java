package exercises.graf;

import exercises.graf.Graf;

import java.util.Collections;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		Graf graf = new Graf();
		graf.ReadGraphFromFile("Graph1.gr");
		graf.printGraph();

		Vector<Integer> dfsr = graf.DFSRekurzivno(4);
		System.out.println("DFS Rekurzivno: " + dfsr.toString());
		
		Vector<Integer> dfsnr = graf.DFSNerekurzivno(4);
		System.out.println("DFS Rekurzivno: " + dfsnr.toString());

		//Vector<Integer> bfs = graf.Bfs(1);
		//System.out.println("BFS :" + bfs.toString());

		//Vector<Integer> dijsktra = graf.Dijkstra(1);
		//System.out.println("Dijkstra :" + dijsktra.toString());

		//Vector<Edge> mstK = graf.mstKruskal();
		//System.out.println(mstK);

		//Vector<Edge> mstP = graf.mstPrim(1);
		//System.out.println(mstP);
			
	}

}
