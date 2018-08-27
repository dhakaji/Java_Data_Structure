import java.util.*;
class MinHeap{
  int heapsize;
  void createMinHeap(Node arr[]){
    heapsize=arr.length;
    for(int i=(heapsize-1)/2;i>0;i--){
      heapify(arr,i);
    }
  }
  void heapify(Node arr[],int pos){
    if(pos<heapsize){
      int l=2*pos+1;
      int r=2*pos+2;
      int min=pos;
      if(l<heapsize && arr[l].distance<arr[pos].distance)
      min=l;
      if(r<heapsize && arr[r].distance<arr[min].distance)
      min=r;
      swap(Node arr,pos,min);
      heapify(arr,min);
    }
  }
  void swap(Node arr[],int i,int j){
    Node temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
  }
  Node extractMin(Node arr){
    if(heapsize==0)
    return -1;
    Node min=arr[0];
    arr[0]=arr[heapsize-1];
    heapsize--;
    heapify(arr,0);
    return min;
  }
  void decreaseKey(Node arr[],int pos,int decrease){
    arr[pos].distance=decrease;
    while(pos>0 && arr[pos].distance<arr[(pos-1)/2].distance){
      swap(arr,pos,(pos-1)/2);
      pos =(pos-1)/2;
    }
  }

}
class Node{
  int data;
  int distance;
  Node(int data,int distance){
    this.data=data;
    this.distance=distance;
  }
}
public class Dijkstra{
  final static int infinity=10000;
  static class Graph{
    int v;
    LinkedList<LinkedList<Node>> adjList;
    Graph(int size){
      v=size;
      adjList=new LinkedList<>();
      for(int i=0;i<size;i++){
        adjList.add(new LinkedList<Node>());
      }
    }
  }
  static void insert(Graph graph,int src,int dest,int distance){
    graph.adjList.get(src).addFirst(new Node(dest,distance));
  }
  static void printGraph(Graph graph){
    for(int i=0;i<graph.v;i++){
      //System.out.println();
      for(Node node : graph.adjList.get(i)){
        System.out.println(i+"->"+node.data+"   "+node.distance);
      }
      System.out.println();
    }
  }
  static void sinSrcSrtPathDijkstra(Graph graph,int src){
    int size=graph.adjList.get(src).size();
    Node distance[]=new Node[graph.v];
    for(int i=0;i<distance.length;i++)
    {
      distance[i].data=i;
      distance[i].distance=infinity;
    }
    for(Node node : graph.adjList.get(src)){
      distance[node.data].distance=node.distance;
    }
    distance[src].distance=0;
    MinHeap heap=new MinHeap();
    heap.createMinHeap(distance);
    HashSet<Node> h=new HashSet<>();
    while(heap.heapsize!=0){
      Node ele=heap.extractMin(distance);
      h.add(ele);
      for(Node node : graph.adjList.get(ele.data)){
        //relax(graph,h,src,node,distance);
        if( > (ele.distance+node.distance))
      }
    }
  }
  //static void relax(Graph graph, HashSet<Node> h)
}
