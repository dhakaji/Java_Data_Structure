class BIT{
    private int btree[];
    BIT(int arr[]){
        btree=new int[arr.length+1];
        build(arr);
    }
    private void build(int arr[]){
        for(int i=0;i<arr.length;i++){
            update(i+1,arr[i]);
        }
    }
    public void update(int index,int value){
        int i=index+1;
        while(i<=btree.length){
            btree[i]+=value;
            i+=(i&(-i));
        }
    }
    public int query(int left,int right){
        //int sum=0;
        return getSum(right)-getSum(left);
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
