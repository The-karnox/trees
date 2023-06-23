import java.util.*;
public class trees {
    static class Node{
      int data;
      Node left;
      Node right;

      Node(int data){
         this.data = data;
         this.left = null;
         this.right = null;
      }

     }

     static class BinaryTree{
         static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
             return null;
             }
             Node newNode = new Node(nodes[idx]);
             newNode.left = buildTree(nodes);
             newNode.right = buildTree(nodes);

             return newNode;
        }

        public static void preorder(Node root){
           if(root == null){
               return ;
           }
           System.out.print(root.data+" ");
           preorder(root.left);
           preorder(root.right);
         }

         public static void inorder(Node root){
           if(root == null){
             return;
           }

           inorder(root.left);
           System.out.print(root.data+" ");
           inorder(root.right);
         }

         public static void postorder(Node root){
          if(root == null){
            return;
           }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
         }

         public static void levelOreder(Node root){
           if (root == null){
           return;
         }
         Queue<Node> q = new LinkedList<>();
         q.add(root);
         q.add(null);
       
         while(!q.isEmpty()){
          Node currNode = q.remove();
          if(currNode==null){
            System.out.println();
            if(q.isEmpty()){
             break;
             }else{
               q.add(null);
             }
           }else{
             System.out.print(currNode.data+" ");
             if(currNode.left!=null){
              q.add(currNode.left);
             }
             if(currNode.right!=null){
              q.add(currNode.right);
             }
             }
         }

      }
    }
    public static int height (Node root){
       if(root == null){
        return 0;
       }
       int lh = height(root.left);
       int rh = height(root.right);
       return Math.max(lh,rh)+1;
     }
     public static int count(Node root){
      if(root == null){
        return 0;
       }
       int leftCount = count(root.left);
       int rightCount = count(root.right);
       return leftCount + rightCount + 1;
     }
     public static int sum(Node root){
        if(root == null){
          return 0;
         }
         int leftSum = sum(root.left);
         int rightSum = sum(root.left);
         return leftSum + rightSum + root.data;
     }

     public static int diameter(Node root){
      if(root == null){
        return 0;
       }
       int leftDiam = diameter(root.left);
       int leftHt = height(root.left);
       int rightDiam = diameter(root.right);
       int rightHt = height(root.right);

       int selfDiam = leftHt + rightHt + 1;
       return Math.max( selfDiam,Math.max(rightDiam, leftDiam));
     }

    
       public static int diameter2(Node root){
        if(root == null){
          return 0;
         }
         int leftDiam = diameter2(root.left);
         int leftHt = height(root.left);
         int rightDiam = diameter2(root.right);
         int rightHt = height(root.right);

         int selfDiam = leftHt + rightHt + 1;
         return Math.max( selfDiam,Math.max(rightDiam, leftDiam));
       }
       static class Info {
        int diam;
        int ht;
 
        public Info(int diam, int ht){
         this.diam = diam;
         this.ht = ht;
        }
      }

     public static Info diameterOpt(Node root){
      if(root == null){
        return new Info(0, 0);
       }
      Info leftInfo = diameterOpt(root.left);
      Info rightInfo = diameterOpt(root.right);
      int data = Math.max(Math.max(leftInfo.diam, rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
      int ht = Math.max(leftInfo.ht, rightInfo.ht)+1;

      return new Info(data, ht);
     }
      


     //isIdentical is part of isSubtree
     public static boolean isIdentical(Node node, Node subRoot){
       if(node == null && subRoot == null){
         return true;
       }else if(node == null || subRoot == null || node.data!= subRoot.data){
        return false;
       }
       if(!isIdentical(node.left, subRoot.left)){
         return false;
       }
       if(!isIdentical(node.right, subRoot.right)){
        return false;
       }
       return true;
     }
     public static boolean isSubtree(Node root, Node subRoot){
      if(root == null){
        return false;
       }
      if(root.data == subRoot.data){
        if(isIdentical(root,subRoot)){
          return true;
         }
       }
      
       return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
     }

     static class Info2{
      Node node;
      int hd;
     
     public Info2(Node node, int hd){
       this.node = node;
       this.hd = hd;
     }
    }

   

    public static void main(String[] args) throws Exception {
       //int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
       //BinaryTree tree = new BinaryTree();
       //Node root = tree.buildTree(nodes);

       //tree.preorder(root);
       //System.out.println();
       //tree.inorder(root);
       //System.out.println();
       //tree.postorder(root);
        //System.out.println();
       // tree.levelOreder(root);

        //System.out.println(height(root));
       //System.out.println(count(root));
       // System.out.println(sum(root));
       //System.out.println(diameterOpt(root).diam);

       Node root = new Node(1);
       root.left = new Node(9);
       root.right = new Node(2);
       root.left.left = new Node(3);
       root.left.right = new Node(4);
       root.right.left = new Node(7);
       root.right.right = new Node(8);

       Node subRoot = new Node(9);
       subRoot.left = new Node(3);
       subRoot.right = new Node(4); 
       
        System.out.println(root);
      }
}
