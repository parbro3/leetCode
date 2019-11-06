import java.util.*;

public class Playground {

    int highestDepth = 0;

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public void run(){

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        TreeNode first1 = root.left;
        first1.left = null;
        first1.right = null;

        TreeNode first2 = root.right;
        first2.left = new TreeNode(15);
        first2.right = new TreeNode(7);

        System.out.print("yeah" + maxDepth(root));
        
    }

    public int maxDepth(TreeNode root) {

        int depth = 0;
        helper(root, depth);

        return highestDepth;
    }

    public void helper(TreeNode node, int depth){

        if(node == null)
            return;

        depth++;
        if(highestDepth < depth)
            highestDepth = depth;

        helper(node.left, depth);
        helper(node.right, depth);
    }

}
