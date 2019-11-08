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

        play(root);
        System.out.print("done");
    }

    public void play(TreeNode root) {
        helper(root);
    }

    public void helper(TreeNode node){

    }

}
