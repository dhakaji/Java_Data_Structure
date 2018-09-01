class Vertex<T>{
  int id;
  T key;
  ArrayList<Edge<T>> allEdges=new ArrayList<>();
  ArrayList<Vertex<T>> nearVertex=new ArrayList<>();
  Vertex(int id){
    this.id=id;
  }
  Vertex(int id,T key){
    this.id=id;
    this.key=key;
  }
  public <T>void setData(T data){
    this.key=data;
  }
  public T getData(){
    return key;
  }
  public void addEdge(Edge<T> edge){
    nearVertex.add(edge.vertex2);
    allEdges.add(edge);
  }
  public List<Edge<T>> getAllEdges(){
    return allEdges;
  }
  public void addAdjacentVertex(Edge<T> edge, Vertex<T> vertex){
    // to add adjacent vertex to the gven vertex
    allEdges.add(edge);
    nearVertex.add(vertex);
  }
  public List<Vertex<T>> getAdjacentVertex(){
    return nearVertex;
  }
  

}
