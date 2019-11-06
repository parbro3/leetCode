import java.util.*;

public class Playground {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void run(){


        /*

                1
            3        6
          2   4    5   7

        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        TreeNode first1 = root.left;
        first1.left = new TreeNode(2);
        first1.right = new TreeNode(4);

        TreeNode first2 = root.right;
        first2.left = new TreeNode(5);
        first2.right = new TreeNode(7); 

        traverse(root);
        System.out.print("done");
    }

    public void traverse(TreeNode root) {

        if(root == null)
            return;

        traverse(root.left);
        traverse(root.right);
        System.out.print(root.val);
    }

}
