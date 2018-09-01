class MaxHeap{
     int heapsize,arrsize;
     int arr[];
     public void buildMaxHeap(){
     	//buildMaxHeap method for Heap class array
         arr=new int[arrsize];
         for(int i=(heapsize-1)/2;i>=0;i--){
             heapify(arr,i);
         }
     }
     public int[] buildMaxHeap(int ar[],int n){
     	// builMaxHeap procedure for already given array
     	arr=new int[n];
     	arrsize=heapsize=n;
     	for(int i=0;i<n;i++)
     		arr[i]=ar[i];
     	buildMaxHeap();
     }

     public void heapify(int i){
         int left=i*2+1;
         int right=i*2+2;
         int max=i;
         if(left<heapsize && arr[left]>arr[max])
            max=left;
         if(right<heapsize && arr[right]>arr[max])
            max=right;
         if(max!=i){
             swap(i,max);
             heapify(arr,max);
         }
     }
     public int extractMax(){
         if(heapsize>=0){
             int max=arr[0];
             arr[0]=arr[heapsize-1];
             heapsize--;
             heapify(arr,0,heapsize);
         }
     }
     public void insert(int key){
         heapsize++;
         arr[heapsize-1]=key;
         int i=heapsize-1;
         int p=(i-1)/2;
         while(i>=0 && arr[i]>arr[p] ){
             swap(i,p);
             i=p;
             p=(i-1)/2;
         }
     }
     public void increaseKey(int i,int key){
         arr[i]=arr[key];
         int p=(i-1)/2;
         while(i>=0 && arr[i]>arr[p] )
         {
             swap(i,p);
             i=p;
             p=(i-1)/2;
         }
     }
      public void deletekey(int i){
         increaseKey(i,Integer.MAXVALUE);
         extractMax();
     }
      public int getMax(){
         return arr[0];
         
     }
     public voi heapSort(){
     	int temp=heapsize;
     	heapsize--;
     	while(heapsize>0){
     		swap(heapsize,0);
     		heapsize--;
     		heapify(0);
     	}
     }
     private void swap(int i,int j){
         int temp=arr[i];
         arr[i]=arr[j];
         arr[j]=arr[i];
     }
     
     
}
