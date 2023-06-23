import java.util.*;
public class trees3 {
    static class Node{
      int data;
      Node left,right;
     

       Node(int data){
          this.data = data;
          this.left = null;
          this.right = null;
       }

     }
     public static void kLevel(Node root, int level, int k){
      if(root == null){
      return;
     }
     if(level == k){
       System.out.print(root.data+" ");
       return;
     }
     kLevel(root.left, level+1, k);
     kLevel(root.right, level+1, k);
     }
     public static boolean getPath(Node root, int n, ArrayList<Node>path){
        if(root == null){                                                               //iterative approach
         return false;
         }
      path.add(root);

      if(root.data == n){
      return true;
    }
     boolean foundLeft = getPath(root.left, n, path);
     boolean foundRight = getPath(root.right, n, path);

     if(foundLeft || foundRight){
      return true;
     }
     path.remove(path.size()-1);
     return false;
     }
     public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node>path1 = new ArrayList<>();
        ArrayList<Node>path2 = new ArrayList<>();
        getPath(root, n1, path1 );
        getPath(root, n2, path2 );

        int i = 0;
        for(;i<path1.size() && i<path2.size();i++){
        if(path1.get(i)!= path2.get(i)){
          break;
         }
        }
       Node lca = path1.get(i-1);                                       //tc = O(n)
        return lca;
        
     }
     public static Node lca2(Node root, int n1, int n2) {        //recursive approach


       if(root == null || root.data == n1 || root.data == n2 ){
         return root;
      }
      Node leftLca = lca2(root.left, n1, n2);
      Node rightLca = lca2(root.right , n1 , n2);

      if(rightLca==null){
        return leftLca;
      }
      if(leftLca == null){
        return rightLca;
     }
     return root;
     }
     public static int lcaDistance(Node root, int n){
       if(root == null){
         return -1;
      }
      if(root.data == n){
        return 0;
      }
      int leftDist = lcaDistance(root.left, n);
      int rightDist = lcaDistance(root.right, n);
      if(leftDist == -1 && rightDist == -1){
       return -1;
     } else if(leftDist == -1){
      return rightDist+1;
    }else{
      return leftDist+1;
     }
    }
     public static int minDistance(Node root, int n1, int n2){
        Node lca = lca2(root, n1 , n2);
        int Dist1 = lcaDistance(lca, n1);
        int Dist2 = lcaDistance(lca, n2);
        return Dist1+Dist2;
     }
     public static  int kthAncestor(Node root, int n, int  k){
        if(root == null){
          return -1;
         }
        if(root.data == n){
          return 0;
         } 
         int leftDist = kthAncestor(root.left, n, k);
         int rightDist = kthAncestor(root.right, n, k);
         if(leftDist == -1 && rightDist == -1){
         return -1;
        }
        int max = Math.max(leftDist, rightDist);
        if(max+1 == k){
          System.out.println(root.data);
         }
         return max+1;

        }

        public static int transform(Node root){
           if(root == null){
           return 0;
         }
         int leftChild = transform(root.left);
         int rightChild =transform(root.right);

         int data = root.data;
          int newLeft = root.left == null ? 0 : root.left.data;
          int newRight = root.right == null ? 0 : root.right.data;



         root.data = newLeft+leftChild+newRight+rightChild;
         return data;
         }

        public static void preOrder(Node root){
          if(root == null){
           return;
         }
         System.out.print(root.data+" ");
         preOrder(root.left);
         preOrder(root.right);
         }

    public static void main(String[] args){

        /*       1
         *     /  \ 
         *    9    2
         *   / \  / \
         *  3   4 7  8
         */
        Node root = new Node(1);
         root.left = new Node(9);
         root.right = new Node(2);
         root.left.left = new Node(3);
         root.left.right = new Node(4);
         root.right.left = new Node(7);
         root.right.right = new Node(8);
         transform(root);
         preOrder(root);
            
 }
}
