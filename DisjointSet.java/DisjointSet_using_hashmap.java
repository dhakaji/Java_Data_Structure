import java.util.*;
class DisjointSet{
	HashMap<Long,Node> map=new HashMap<>();
	class Node{
		long data;
		int size;
		Node parent;
		// Node(long id){
		// 	this.id=id;
		// 	this.size=1;
		// 	this.parent=null;
		// }


	}
	public void makeSet(long data){
		Node node=new Node();
		node.data=data;
		node.size=1;
		node.parent=node;
		map.put(data,node);
	}
	public void union(long a,long b){
		Node root_a=find(map.get(a));
		Node root_b=find(map.get(b));
		if(root_a==root_b)
			return false;
		if(root_a.size >= root_b.size){
			root_b.parent=root_a.parent;
			root_a.size+=root_b.size;
		}
		else {
			root_a.parent=root_b.parent;
			root_b.size+=root_a.size;
		}
	}
	private Node root(Node node){
		Node parent=node.parent;
		if(parent==node)
			return parent;		
		node.parent=root(node.parent);					
		return node.parent;
	}
	public boolean find(long a,long b){
		Node node_a=map.get(a);
		Node node_b=map.get(b);
		return root(node_a)==root(node_b);
	}

}