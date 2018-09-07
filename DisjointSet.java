/*package whatever //do not write package name here */

//import java.io.*;
import java.util.*;
class DisjointSet{
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
    public void union(int x,int y){
        if(size[x]>=size[y]){
            int parent_x=parent(x);
            int parent_y=parent(y);
            parent[x]=parent_y;
            size[y]+=size[x];
        }
        else {
            int parent_x=parent(x);
            int parent_y=parent(y);
            parent[y]=parent_x;
            size[x]+=size[y];
        }
    }
    public int parent(int i){
        while(i!=parent[i]){
            i=parent[i];
        }
        return i;
    }
    public boolean find(int i,int j){
        return parent(i)==parent(j);
    }
}
