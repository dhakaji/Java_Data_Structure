import java.util.*;
class SegmentTreeRangeMinQuery{
	static int []tree;
	SegmentTreeRangeMinQuery(int arr[],int n){
		int size=(int )(Math.ceil(Math.log(n)/Math.log(2)));
		size=(int )Math.pow(2,size+1)-1;
		tree=new int[size];
		build(arr,0,n-1,0);
	}
	private void build(int arr[],int left,int right,int index){
		if(left==right){
			tree[index]=arr[left];
			return ;
		}
		int mid=left+(right-left)/2;
		build(arr,left,mid,2*index+1);
		build(arr,mid+1,right,2*index+2);
		tree[index]=Math.min(tree[2*index+1],tree[2*index+2]);
	}
	public void update(int arr[],int index,int delta){
		arr[index]+=delta;
		update(arr,index,delta,0,arr.length-1);		
	}
	private void update(int arr_index,int delta,int left,int right,int index){
		if(left==right){
			tree[index]+=delta;
			return ;
		}
		int mid=left+(right-left)/2;
		if(arr_index>=left && arr_index<=mid){
			update(arr_index,delta,left,mid,2*index+1);
		}
		if(arr_index>mid && arr_index<=right){
			update(arr_index,delta,mid+1,right,2*index+2);
		}
		tree[index]=Math.min(tree(2*index+1),tree(2*index+2));
	}
	public int query(int arr[],int qleft,int qright){
		return query(0,arr.length-1,qleft,qright,0);
	}
	private int query(int left,int right,int qleft,int qright,int index){
		if(qright<left || qleft>right)
			return Integer.MAX_VALUE;
		if(qleft<=left && qright>=right)
			return tree[index];			
		int mid=left+(right-left)/2;
		return Math.min(query(left,mid,qleft,qright,2*index+1),query(mid+1,right,qleft,qright,2*index+2));
	}

	public String toString(){
		return Arrays.toString(tree);
	}
}