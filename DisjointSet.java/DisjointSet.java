class DisjointSet{
	// static class Node{
	// 	int key;
	// 	Node parent;
	// 	int 
	// }
	int parent[];
	int size[];
	DisjointSet(int n){
		parent=new int[n];
		size=new int[n];
		for(int i=0;i<n;i++){
			parent[i]=i;
			size[i]=1;
		}		
	}
	public void union(int a,int b){
		int root_a=root(a);
		int root_b=root(b);
		if(size[root_a]<=size[root_b]){			
			parent[root_a]=parent[root_b];
			size[root_b]+=size[root_a];
		}
		else {
			parent[root_b]=parent[root_a];
			size[root_a]+=size[root_b];
		}
	}
	public int root(int element){
		while(element!=parent[element]){
			parent[element]=parent[parent[element]];
			element=parent[element];
		}
		return element;
	}
	public boolean find(int a, int b){
		if(root(a)==root(b))
			return true;
		return false;
	}
	
}