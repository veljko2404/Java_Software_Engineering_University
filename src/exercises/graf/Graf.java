package exercises.graf;

import exercises.zad15.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;


public class Graf {
	
	private int numNodes, numEdges;
	private Vector<LinkedList<Integer>> nodes;
	private Vector<Edge> edges;
	final int beskonacno = 2000000000;
	
	
	public Graf(){
		super();
		nodes = new Vector<LinkedList<Integer>>();
		edges = new Vector<Edge>();
	}
	
	//DFS rekurzivno
	public Vector<Integer> DFSRekurzivno(int cvor){
		Vector<Integer> result = new Vector<Integer>();
		Vector<Boolean> nadjen = new Vector<Boolean>();
		nadjen.setSize(nodes.size());
		for (int i = 0; i < nodes.size(); i++) {
			nadjen.set(i, false);
		}
		DfsPom(cvor, result, nadjen);
		return result;
	}

	private void DfsPom(int cvor, Vector<Integer> result, Vector<Boolean> nadjen) {
		// TODO Auto-generated method stub
		nadjen.setElementAt(true, cvor);
		result.add(cvor);
		for (Iterator<Integer> iterator = nodes.get(cvor).iterator(); iterator.hasNext();) {
			Integer ivicaIndex = (Integer) iterator.next();
			if(!nadjen.get(edges.get(ivicaIndex).kraj))
				DfsPom(edges.get(ivicaIndex).kraj, result, nadjen);
		}
	}
	
	//Dfs nerekurzvino
	public Vector<Integer> DFSNerekurzivno(int cvor){
		Vector<Integer> result = new Vector<Integer>();
		Vector<Iterator<Integer>> itv = new Vector<Iterator<Integer>>(); 
		itv.setSize(nodes.size());
		Vector<Boolean> nadjen = new Vector<Boolean>();
		nadjen.setSize(nodes.size());
		for (int i = 0; i < nodes.size(); i++) {
			nadjen.set(i, false);
			itv.set(i, nodes.get(i).iterator());
		}
		
		DfsNerekurzivnoPomKor(cvor, result, nadjen, itv);
		
		return result;
	}

	void DfsNerekurzivnoPomKor( int  cvor, Vector<Integer> result, Vector<Boolean> nadjen, 
			Vector<Iterator<Integer>> itv){
		Stack<Integer> st = new Stack<Integer>();
		st.push(cvor);
		nadjen.set(cvor, true);
		result.add(cvor);
		
		while(! st.empty())
		{
			int tmp = st.peek();
			// obidji sve susede cvora sa indexom tmp koji nisu obidjeni
			// kad nadjes cvor koji nije obidjen, upisi ga u stek i iskoci iz while petlje i nastavi obradu steka
			while(itv.get(tmp).hasNext())	// obilazak u redosledu kao kod rekurzivne
			{
				Integer grana = (Integer) itv.get(tmp).next();
				Integer kraj = edges.get(grana).kraj; 
				if(! nadjen.get(kraj))
				{
					st.add(kraj);
					nadjen.set(kraj, true);
					result.add(kraj);
					break;
				}
			}
			if(! itv.get(tmp).hasNext())
				st.pop();
		}
	}
	
	
	private void DFSNeRekurzinoPom(int cvor, Vector<Integer> result,
			Vector<Boolean> nadjen) {
		// TODO Auto-generated method stub
		Stack<Integer> st = new Stack<Integer>();
		st.push(cvor);
		nadjen.setElementAt(true, cvor);
		while (!st.empty()) {
			int tmp = st.peek();
			result.add(tmp);
			st.pop();
			
			for (Iterator<Integer> iterator = nodes.get(tmp).iterator(); iterator.hasNext();) {
				Integer grana = (Integer) iterator.next();
				if(!nadjen.get(edges.get(grana).kraj)){
					st.push(edges.get(grana).kraj);
					nadjen.setElementAt(true, edges.get(grana).kraj);
				}
			}
		}
	}
	
	
	
	
	//BFS
	public Vector<Integer> Bfs(int cvor){
		Vector<Integer> result = new Vector<Integer>();
		Vector<Boolean> nadjen = new Vector<Boolean>();
		nadjen.setSize(nodes.size());
		for (int i = 0; i < nodes.size(); i++) {
			nadjen.set(i, false);
		}
		
		BfsPom(cvor, result, nadjen);
		return result;
	}

	private void BfsPom(int cvor, Vector<Integer> result, Vector<Boolean> nadjen) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(cvor);
		nadjen.setElementAt(true, cvor);
		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			result.add(tmp);
			for (Iterator<Integer> iterator = nodes.get(tmp).iterator(); iterator.hasNext();) {
				Integer grana = (Integer) iterator.next();
				if(!nadjen.get(edges.get(grana).kraj)){
					queue.add(edges.get(grana).kraj);
					nadjen.setElementAt(true, edges.get(grana).kraj);
				}
			}
		}
	}
	
	//Dijkstrin algoritam za nalazenje najkraceg puta u grafu
	public Vector<Integer> Dijkstra(int start){
		Vector<Integer> dist = new Vector<Integer>();
		Vector<Boolean> nadjen = new Vector<Boolean>();
		dist.setSize(nodes.size());
		for (int i = 0; i < nodes.size(); i++) {
			dist.set(i, beskonacno);
		}
		dist.set(start, 0);
		nadjen.setSize(nodes.size());
		for (int i = 0; i < nodes.size(); i++) {
			nadjen.set(i, false);
		}
		
		TreeMap<Integer, TreeSet<Integer>> minHeap = new TreeMap<Integer, TreeSet<Integer>>();
		TreeSet l0 = new TreeSet(), lbeskonacno = new TreeSet();
		for (int i = 1; i < nodes.size(); i++) {
			if(i == start){
				l0.add(start);
				minHeap.put(0, l0);
			}
			else{
				lbeskonacno.add(i);
			}
		}
		minHeap.put(0, l0);
		minHeap.put(beskonacno, lbeskonacno);
		
		while(!minHeap.isEmpty()){
			Entry<Integer, TreeSet<Integer>> entry = minHeap.firstEntry();
			Integer distance = entry.getKey();
			Integer node = entry.getValue().first();
			entry.getValue().remove(node);
			if(entry.getValue().size() == 0)
				minHeap.remove(distance);
			nadjen.set(node, true);//najkraci put
			for (Iterator<Integer> iterator = nodes.get(node).iterator(); iterator.hasNext();) {
				Integer grana = (Integer) iterator.next();
				Edge ivica = edges.get(grana);
				int u = ivica.kraj;
				if(dist.get(u) > dist.get(node) + ivica.weight){
					Integer newDist = dist.get(node) + ivica.weight;
					minHeap.get(dist.get(u)).remove(u);
					if(minHeap.get(dist.get(u)).size() == 0)
						minHeap.remove(dist.get(u));
					dist.set(u, newDist);
					TreeSet newDistSet = minHeap.get(newDist);
					if(newDistSet == null){
						newDistSet = new TreeSet<Integer>();
						newDistSet.add(u);
						minHeap.put(newDist, newDistSet);
					}
					else
						newDistSet.add(u);
				}
			}
		}
		dist.remove(0);
		return dist;
	}
	
	//Kruskalov algoritam za nalazenje minimalnog razapinjuceg stabla
	public Vector<Edge> mstKruskal(){
		Vector<Edge> mst = new Vector<Edge>();
		TreeSet<Edge> minHeapEdges = new TreeSet<Edge>();
		for (Iterator<Edge> iterator = edges.iterator(); iterator.hasNext();) {
			Edge ivica = (Edge) iterator.next();
			minHeapEdges.add(ivica);
		}
		
//		for (int i = 0; i < 22; i++) {
//			minHeapEdges.add(edges.get(i));
//		}
//		UnionFind uf = new UnionFind(nodes.size());
//		while(!minHeapEdges.isEmpty()){
//			Edge e = minHeapEdges.first();
//			minHeapEdges.remove(e);
//			if(!uf.isConnected(e.pocetak, e.kraj)){
//				uf.connect(e.pocetak, e.kraj);
//				mst.add(e);
//			}
//		}
		return mst;
	}
	
	//Primov algoritam za nalazenje minimalnog razapinjuceg stabla
	public Vector<Edge> mstPrim(int start){
		Vector<Boolean> dvaSkupa = new Vector<Boolean>();
		dvaSkupa.setSize(nodes.size());
		Collections.fill(dvaSkupa, false);
		Vector<Edge> mst = new Vector<Edge>();
		TreeSet<Edge> betweenEdges = new TreeSet<Edge>();
		for (Iterator<Integer> iterator = nodes.get(start).iterator(); iterator.hasNext();) {
			Integer ivicaIndex = (Integer) iterator.next();
			betweenEdges.add(edges.get(ivicaIndex));
		}
//		System.out.println(betweenEdges.size());
		dvaSkupa.set(start, true);
		Edge etmp = new Edge();
		while (!betweenEdges.isEmpty()) {
			Edge eBetween = betweenEdges.first();
			mst.add(eBetween);
			dvaSkupa.set(eBetween.kraj, true);
			for (Iterator<Integer> iterator = nodes.get(eBetween.kraj).iterator(); iterator.hasNext();) {
				Integer ivicaIndex = (Integer) iterator.next();
				if (!dvaSkupa.get(edges.get(ivicaIndex).kraj)) {
					betweenEdges.add(edges.get(ivicaIndex));
				} else {
					etmp.pocetak = edges.get(ivicaIndex).kraj;
					etmp.kraj = edges.get(ivicaIndex).pocetak;
					etmp.weight = edges.get(ivicaIndex).weight;
					betweenEdges.remove(etmp);			
				}
			}
		}
		
		return mst;
	}
	
	public void ReadGraphFromFile(String fileName){
		URL url = Graf.class.getResource(fileName);
		File file = new File(url.getPath());
		Scanner inputScan = null;
		try {
			String prva = null, druga = null;
			
			inputScan = new Scanner(file);
		   
			prva = inputScan.next();
			druga = inputScan.next();
		   
			numNodes = inputScan.nextInt();
			numEdges = inputScan.nextInt();
		   
			nodes.setSize(numNodes + 1);
			edges.setSize(numEdges);
		   
			for(int i=0; i<=numNodes; i++)
				nodes.setElementAt(new LinkedList<Integer>(), i);
		   
			int i=0;
			while(inputScan.hasNext() ){
				prva = inputScan.next();
				if(prva.length() > 0)
				{
					Edge e = new Edge();
					e.pocetak = inputScan.nextInt();
					e.kraj = inputScan.nextInt();
					e.weight = inputScan.nextInt();
		     
					edges.add(i, e);
					nodes.get(e.pocetak).add(i);
		     
					i++;
				}
			}
			inputScan.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}	

	//stampanje grafa
	public void printGraph(){
		for(int i = 1; i <= numNodes; i++){
			System.out.println("Node: " + i + " adj: ");
			final Iterator<Integer> iter = nodes.get(i).iterator();
			while (iter.hasNext()) {
				int index = iter.next();
				System.out.print(" Dest: " + edges.get(index).kraj + " W: "
						+ edges.get(index).weight);
			}
			System.out.println();
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
