import java.util.*;

public class Playground {

    List<Integer> postOrder = new ArrayList<Integer>();

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void run(){

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        /*
        TreeNode first2 = root.right;
        first2.left = new TreeNode(3);
        first2.right = null;

        */
        postorderTraversal(root);
        System.out.print("done");
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        helper(root);
        return postOrder;
    }

    public void helper(TreeNode node){

        if(node == null)
            return;
        
        helper(node.left);
        helper(node.right);
        postOrder.add(node.val);
    }

}
