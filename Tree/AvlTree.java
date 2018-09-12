// import java.util.*;
// import java.io.*;
class tree{
  public static class Node{
    int data,height,bf;
    Node left,right;
    public Node(int item){
      data=item;
      height=1;
      left=right=null;
    }
    public Node(){
      data=0;
      height=1;
      bf=0;
      left=right=null;
    }

  }
  //static Node root;
  static Node rootavl;
//   static void inOrder(){
//     inOrderRec(root);
//     System.out.println();
//   }
//   static void inOrderRec(Node node){
//     if(node!=null){
//       inOrderRec(node.left);
//       System.out.print(node.data+"("+node.height+","+node.bf+")"+"  ");
//       inOrderRec(node.right);
//     }
//   }
  static int height(Node node){
    if(node==null)
    return 0;
    return node.height ;
  }
//   static void insertBst(int data){
//     root=insertBstRec(root,data);
//   }
//   static Node insertBstRec(Node node,int data){
//     if(node==null){
//       node=new Node(data);
//       return node;
//     }
//     if(data < node.data ){
//       node.left=insertBstRec(node.left,data);
//     }
//     else if(data>node.data)
//     node.right=insertBstRec(node.right,data);
//     else
//     return node;
//     node.height=Math.max(height(node.left),height(node.right))+1;
//     node.bf=height(node.left)-height(node.right);
//     return node;
//   }
//   static Node search(Node node,int data){
//     if(node!=null){
//       if(node.data==data)
//       return node;
//       Node temp=search(node.left,data);
//       if(temp==null)
//       temp=search(node.right,data);
//       return temp;
//     }
//     return null ;
//   }
  static Node findInorderSuccessor(Node node){
    if(node!=null){
      while(node.left!=null)
        node=node.left;
        return node;
    }
    return null;
  }
//   static Node deleteBst(Node node,int data){
//     if(node!=null){
//       if(data<node.data)
//       node.left=deleteBst(node.left,data);
//       else if(data>node.data)
//       node.right=deleteBst(node.right,data);
//       else {
//         if(node.left==null)
//           return node.right;
//         else if(node.right==null)
//           return node.left;
//         root.data=findInorderSuccessor(root.right);
//         deleteBst(root.right,root.data);
//       }
//       node.height=Math.max(height(node.left),height(node.right))+1;
//       node.bf=height(node.left)-height(node.right);
//       return node ;
//     }
//     return null;
//   }
  static void insertAvl(int data){
    insertAvlRec(root,data);
  }
  static Node insertAvlRec(Node node,int data){
    if(node==null){
      node=new Node(data);
      return node;
    }
    else if(data<node.data)
      node.left=insertAvlRec(node.left,data);
    else if(data>node.data)
      node.right=insertAvlRec(node.right,data);
    else
      return node;
    node.height=Math.max(height(node.left),height(node.right))+1;
    node.bf=height(node.left)-height(node.right);
    if(bf<-1 && data<node.right.data){
      node.right=rightRotate(node.right);
      node=leftRotate(node);
    }
    else if(bf<-1 && data > node.right.data ){
      node=leftRotate(node);
    }
    else if(bf >1 && data < node.left.data){
      node=rightRotate(node);
    }
    else if(bf >1 && data>node.left.data){
      node.left=leftRotate(node.left);
      node=rightRotate(node);
    }
    return node ;
  }
  static Node leftRotate(Node x){
    Node y=x.right;
    Node t2=y.left;
    x.right=t2;
    y.left=x;
    x.height=Math.max(height(x.left),height(x.right))+1;
    y.height=Math.max(height(y.left),height(y.right))+1;
    return y;
  }
  static Node rightRotate(Node x){
    Node y=x.left;
    Node t2=y.right;
    x.left=t2;
    y.right=x;
    x.height=Math.max(height(x.left),height(x.right))+1;
    y.height=Math.max(height(y.left),height(y.right))+1;
    return y;
  }
  static void deleteAvl(int data){
    deleteAvlRec(root,data);
  }
  static Node deleteAvlRec(Node node,int data){
    if(node!=null){
      if(data<node.data)
        node.left=deleteAvlRec(node.left,data);
      else if(data>node.data)
        node.right=deleteAvlRec(node.right,data);
      else{
          if(node.left==null)
            return node.right;
          if(node.right==null)
            return node.left;
          else{
            node.data=findInorderSuccessor(node.right);
            node.right=deleteAvlRec(node.right,node.data);
          //  return node;
          }
      }
      node.height=Math.max(height(node.left),height(node.right))+1;
      node.bf=height(node.left)-height(node.right);
      if(bf>1 && node.left.bf>=0){
        return rightRotate(node);
      }
      if(bf>1 && node.left.bf<0){
        node.left=leftRotate(node.left);
        return rightRotate(node);
      }
      else if(bf<-1 && node.right.bf<0){
        return leftRotate(node);
      }
      else if(bf<-1 && node.right.bf>=0){
        node.right=rightRotate(node.right);
        return leftRotate(node);
      }
        return node;
      }
      return null;
    }
}
