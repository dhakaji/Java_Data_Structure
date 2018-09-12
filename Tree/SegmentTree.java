public class SegmentTree{
  int []tree;
  SegmentTree(int arr[]){
    int size=(int )Math.ceil(Math.log(arr.length)/Math.log(2));
    int size=(int )Math.pow(2,size+1)-1;
    tree=new int[size];
    build(arr,0,arr.length-1,0);
  }
  private void build(int arr[],int left,int right,int index){
    if(left==right)
    {
      tree[index]=arr[left];    
      return ;
    }
    int mid=first+(last-first)/2;
    buildSegment(arr,left,mid,2*index+1);
    buildSegment(arr,mid+1,right,2*index+2);
    tree[index]=tree[2*index+1]+tree[2*index+2];
  }
  public int query(int n,int l,int r){
   return query(0,n-1,l,r,0); 
  }
  private int query(int left,int right,int qleft,int qright,int index){
    if(qright<left || qleft>right)
    return 0;
    if(qleft<=left && qright>=right)
      return tree[index];    
    int mid=left+(right-left)/2;
    int sum=query(left,mid,qleft,qright,2*index+1)+query(mid+1,right,qleft,qright,2*index+2);
    return sum;
  }
  public void update(int arr[],int i,int new_value){
    if(i<0 || i>arr.length-1)
    return ;    
    arr[i]=new_value;
    update(i,0,arr.length-1,new_value,0);
  }
  private void update(int i,int left,int right,int new_value,int index){
    if(i<left || i>right)
    return ;
    if(left==right)
    {
      tree[index]=new_value;
      return ;
    }
    int mid=l+(r-l)/2;
    update(i,l,mid,new_value,2*index+1);
    update(i,mid+1,r,new_value,2*index+2);    
    tree[index]=tree[2*index+1]+tree[2*index+2];
  }

//   public static void main(String[] args) {
//       int []arr=new int[]{1,3,5,7,9,11};
//       SegmentTree st=new SegmentTree(arr);
//       System.out.println("range 1 to 3"+st.query(1,3,0,arr.length-1,0));
//       st.update(arr,1,10);
//       System.out.println("range 1 to 3"+st.query(1,3,0,arr.length-1,0));

//   }
}
