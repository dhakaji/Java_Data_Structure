import java.util.*;

public class SegmentTree{

  private int []tree;
  private int []lazy;

  SegmentTree(int arr[]){
    int size=(int )Math.ceil(Math.log(arr.length)/Math.log(2));
    int size=(int )Math.pow(2,size+1)-1;
    tree=new int[size];
    lazy=new int[size];
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
    // check whether there is any pending update on current index before quering 
    if(lazy[index]!=0){
      tree[index]+=(right-left+1)*lazy[index];
      if(left!=right){
        lazy[2*index+1]=lazy[index];
        lazy[2*index+2]=lazy[index];
      }
      lazy[index]=0;
    }

    if(qright<left || qleft>right)
    return 0;
  
    if(qleft<=left && qright>=right)
      return tree[index];    
  
    int mid=left+(right-left)/2;
    int sum=query(left,mid,qleft,qright,2*index+1)+query(mid+1,right,qleft,qright,2*index+2);
    return sum;
  }
  //update method for point update
  public void update(int arr[],int i,int delta){
    
    if(i<0 || i>arr.length-1)
    return ;    

    arr[i]+=delta;
    update(i,0,arr.length-1,delta,0); // call update method to point update int segment tree    
  }


  private void update(int i,int left,int right,int delta,int index){
  
    if(i<left || i>right)
    return ;
  
    if(left==right)
    {
      tree[index]+=delta;
      return ;
    }

    int mid=l+(r-l)/2;
    update(i,l,mid,delta,2*index+1);
    update(i,mid+1,r,delta,2*index+2);    
    tree[index]=tree[2*index+1]+tree[2*index+2];
  }


  public void updateRange(int arr[],int uleft,int uright,int delta){
  
    for(int i=uleft;i<=uright;i++)
      arr[i]+=delta;
    update(uleft,uright,delta,0,arr.length-1,0);

  }


  private void updateRange(int uleft,int uright,int delta,int left,int right,int index){
  
    if(lazy[index]!=0 ){ // if there is any pending update for current tree node
      tree[index]+=(right-left+1)*lazy[index];
      if(left!=right){
        lazy[2*index+1]+=lazy[index];
        lazy[2*index+2]+=lazy[index];
      }
      lazy[index]=0;
    }

    if(uright<left || uleft>right)
      return;

    if(uleft<=left && uright>=right){
      tree[index]+=(right-left+1)*delta;
      if(left!=right){
        lazy[2*index+1]+=delta;
        lazy[2*index+2]+=delta;
      }
      return;
    }

    int mid=left+(right-left)/2;
    update(uleft,uright,delta,left,mid,2*index+1);
    update(uleft,uright,delta,mid+1,right,2*index+2);
    tree[index]=tree[2*index+1]+tree[2*index+2];
  }


  public String toString(){
    return Arrays.toString(tree);
  }

//   public static void main(String[] args) {
//       int []arr=new int[]{1,3,5,7,9,11};
//       SegmentTree st=new SegmentTree(arr);
//       System.out.println("range 1 to 3"+st.query(1,3,0,arr.length-1,0));
//       st.update(arr,1,10);
//       System.out.println("range 1 to 3"+st.query(1,3,0,arr.length-1,0));

//   }
}
