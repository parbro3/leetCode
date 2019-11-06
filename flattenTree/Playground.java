import java.util.*;

public class Playground {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void run(){

        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);

        TreeNode first2 = root.right;
        first2.left = null;
        first2.right = new TreeNode(3);


        flatten(root);
        System.out.print("done");
    }

    public void flatten(TreeNode root) {
        helper(root);
    }

    public void helper(TreeNode node){

        if(node == null)
            return;

        //save right subtree first
        TreeNode rightSubTree = node.right;

        //move left subtree to right
        node.right = node.left;

        //traverse left
        helper(node.left);

        //now that you've traversed left, you can set left to null
        node.left = null;

        //append subtree to bottom
        if(rightSubTree != null)
            appendToBottom(node, rightSubTree);
        
        //traverse right
        helper(node.right);
    }

    public void appendToBottom(TreeNode node, TreeNode subTree){
        System.out.print("appending");
        while(node.right != null)
            node = node.right; 
        node.right = subTree;
    }


}
