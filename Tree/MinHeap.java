class MinHeap<T>{
	int heapsize,arrsize;
	T arr[]=new T[arrsize];
	public void buildHeap(){
		for(int i=(heapsize-1)/2;i>=0;i--){
			heapify(i);
		}
	}
	public <T>void buildHeap(T ar[],int n){
		heapsize=arrsize=n;
		for(int i=0;i<n;i++){
			arr[i]=ar[i];
		}
		buildHeap();
	}
	public void heapify(int i){
		int left=2*i+1;
		int right=2*i+2;
		int min=i;
		if(left<heapsize && arr[left]<arr[min])
			min=left;
		if(right<heapsize && arr[right]<arr[min])
			min=right;
		if(min!=i){
			swap(i,min);
			heapify(min);
		}
	}
	public T extractMin(){
		T min=arr[0];
		arr[0]=arr[heapsize-1];
		heapsize--;
		heapify(0);
		return min;
	}
	public T getMin(){
		return arr[0];
	}
	public <T>void decreaseKey(int i,T key){
		arr[i]=key;
		int p=(i-1)/2;
		while(i>0 && arr[i]<arr[p]){
			swap(i,p);
			i=p;
			p=(i-1)/2;
		}
	}
	public void deleteKey(int i){
		decreaseKey(i,);
		extaxMin();
	}
}