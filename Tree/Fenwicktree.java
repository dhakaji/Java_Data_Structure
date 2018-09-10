class BIT{
    private int btree[];
    BIT(int arr[]){
        //Assuming the array as 1-based indexing
        btree=new int[arr.length];
        build(arr);
    }
    private void build(int arr[]){
        for(int i=1;i<arr.length;i++){
            update(i,arr[i]);
        }
    }
    public void update(int index,int value){
        while(index<=btree.length){
            btree[index]+=value;
            index+=(index&(-index));
        }
    }
    public int query(int left,int right){
        return getSum(right)-getSum(left-1);
    }
    public int query(int index){
        return getSum(index);
    }
    private int getSum(int index){
        int sum=0;
        while(index>0){
            sum+=btree[index];
            index-=(index&(-index));
        }
        return sum;
    }
    public String toString(){
        return Arrays.toString(btree);
    }
}
