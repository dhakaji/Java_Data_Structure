class Edge<T>{
  Vertex<T> vertex1;
  Vertex<T> vertex2;
  int weight;
  boolean isDirected=false;
  Edge(Vertex<T> v1,Vertex<T> v2){
    //undirected and unweighted edge
    vertex1=v1;
    vertex2=v2;
  }
  Edge(Vertex<T> v1,Vertex<T> v2,boolean directed){
    //directed and unweighted edge
    vertex1=v1;
    vertex2=v2;
    isDirected=directed;
  }
  Edge(Vertex<T> v1,Vertex<T> v2,int w){
    // undirected and weighted edges
    vertex1=v1;
    vertex2=v2;
    weight=w;
  }
  Edge(Vertex<T> v1,Vertex<T> v2,int w,boolean directed){
    // directed and weighted edges
    vertex1=v1;
    vertex2=v2;
    weight=w;
    isDirected=directed;
  }
  public Vertex<T> getVertex1(){
    return vertex1;
  }
  public Vertex<T> getVertex2(){
    return vertex2;
  }
  public int getWeight(){
    return weight;
  }
  public boolean isDirected(){
    return isDirected;
  }

}
