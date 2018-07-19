import java.util.*;

public class GraphAdjacencyList{

  private Map<Integer, ArrayList<Integer>> adjListMap;
  public GraphAdjacencyList(int vertices){
    adjListMap = new HashMap<Integer, ArrayList<Integer>>();
    for(int i = 1; i<=vertices; i++)
    {
      ArrayList<Integer> neighbors = new ArrayList<Integer>();
      adjListMap.put(i, neighbors);
    }
  }
  public void addEdge(int v, int w){
    //if the vertex is not in the scope of the graph
    if(v>adjListMap.size() || w > adjListMap.size()){
      return;
    }
    //directed graph v->w
    (adjListMap.get(v)).add(w);
    //undirected graph v->w w->v
    (adjListMap.get(w)).add(v);

  }

public ArrayList<Integer> getNeighbors(int v){
  if( v>adjListMap.size()){
    return null;
  }
  else
  return new ArrayList<Integer>(adjListMap.get(v));
}

public static void main(String arg[]){
  int count = 1;
  int source;
  int destination;

  System.out.println("Enter the number of vertices and edges");
  Scanner sc = new Scanner(System.in);
  int number_vertices = sc.nextInt();
  int number_edges = sc.nextInt();
  GraphAdjacencyList adj = new GraphAdjacencyList(number_vertices);
  System.out.println("Enter edges in format <source> <destination>");
  while(count<=number_edges){
    source = sc.nextInt();
    destination = sc.nextInt();
    adj.addEdge(source, destination);
    count++;
  }

  System.out.println("The given adjacency list for the graph \n");
  for(int i =1; i<number_vertices; i++){
    System.out.print(i + " : ");
    ArrayList<Integer> edgeList = adj.getNeighbors(i);
    for(int j=1; ; j++){
      if(j!=edgeList.size()){
        System.out.println(edgeList.get(j-1) + " : ");
      }
      else{
        System.out.println(edgeList.get(j-1));
        break;
      }
    }
    System.out.println();
  }
}
}
