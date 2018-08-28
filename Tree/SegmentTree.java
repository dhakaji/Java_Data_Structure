public class SegmentTree{
  int []tree;
  SegmentTree(int arr[]){
    int n=arr.length;
    int x=(int )Math.ceil(Math.log(n)/Math.log(2));
    int size=2*(int )Math.pow(2,x)-1;
    tree=new int[size];
    buildSegment(arr,0,n-1,0);
  }
  int buildSegment(int arr[],int first,int last,int index){
    if(first==last)
    {
      tree[index]=arr[first];
      return tree[index];
    }
    int mid=first+(last-first)/2;
    tree[index] =buildSegment(arr,first,mid,index*2+1)+buildSegment(arr,mid+1,last,index*2+2);
    return tree[index];
  }
  int query(int first,int last,int l,int r,int index){
    // if(l<first || r>last  || first>last)
    // {
    //   System.out.println("Invalid Input");
    //   return -1;
    // }
    if(first<=l && last>=r)
      return tree[index];
    if(r<first || l>last)
    return 0;
    int mid=l+(r-l)/2;
    int sum=query(first,last,l,mid,index*2+1)+query(first,last,mid+1,r,index*2+2);
    return sum;
  }
  void update(int arr[],int i,int new_value){
    if(i<0 || i>arr.length-1)
    return ;
    int diff= new_value-arr[i];
    arr[i]=new_value;
    updatest(i,0,arr.length-1,diff,0);
  }
  void updatest(int i,int l,int r,int diff,int index){
    if(i<l || i>r)
    return ;
    tree[index] +=diff;
    if(l!=r){
      int mid=l+(r-l)/2;
      updatest(i,l,mid,diff,index*2+1);
      updatest(i,mid+1,r,diff,index*2+2);
    }
  }

  public static void main(String[] args) {
      int []arr=new int[]{1,3,5,7,9,11};
      SegmentTree st=new SegmentTree(arr);
      System.out.println("range 1 to 3"+st.query(1,3,0,arr.length-1,0));
      st.update(arr,1,10);
      System.out.println("range 1 to 3"+st.query(1,3,0,arr.length-1,0));

  }
}
