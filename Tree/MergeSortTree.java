class MergeSortTree{
	private ArrayList<Integer> tree[];
	MergeSortTree(int arr[]){
		int size=(int )(Math.ceil(Math.log(arr.length)/Math.log(2)));
		size=(int )Math.pow(2,size+1)-1;
		tree=new ArrayList[size];
		build(arr,0,arr.length-1,0);
	}
	private void build(int arr[],int left,int right,int index){
		if(left==right){
			tree[index]=new ArrayList<Integer>();
			tree[index].add(arr[left]);
			return ;
		}
		int mid=left+(right-left)/2;
		build(arr,left,mid,2*index+1);
		build(arr,mid+1,right,2*index+2);
		tree[index]=new ArrayList<>();
		tree[index]=merge(tree[2*index+1],tree[2*index+2] );
	}
	private ArrayList<Integer> merge(ArrayList<> a,ArrayList<> b){
		a.add(Integer.MAX_VALUE);
		b.add(Integer.MAX_VALUE);
		ArrayList<Integer> res=new ArrayList<>(a.size()+b.size());
		int i=j=0;
		int k=0;
		while(k<(a.size()+b.size())){
			if(a.get(i)<=b.get(j)){
				res.add(a.get(i));
				i++;
			}
			else{
				res.add(b.get(j));
				j++;
			}
		}
		a.remove(a.size(-1));
		b.remove(b.size()-1);
		return res;
	}
	// query to find kth smallest element in an subarray 
	/*
	qleft-> left index of subarray in which query is given
	qright-> right index of subarray in which query is given
	k -> kth smallest element
	n-> size of the array


	*/
	public int query(int n,int qleft,int qright,int k){
		if(k<0 || k>(qright-qleft))
			return -1;// if the element is not in the range
		return query(qleft,qright,k,0,n-1,0);
	}
	private int query(int qleft,int qright,int k,int left, int right,int index){
		if(qright<left || qleft >right){
			return 0;
		}
	}
}