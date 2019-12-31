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
        root.left = new TreeNode(2);

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);

        boolean asdf = isSameTree(root, root2);
        System.out.print("done");
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        //if they are both null then that's fine... parse left and then parse right
        if(p == null && q == null)
            return true;
        
        if(p == null && q != null)
            return false;

        if(p != null && q == null)
            return false;

        if(p.val != q.val)
            return false;

        //move left
        boolean leftTrue = isSameTree(p.left, q.left);

        //move right
        boolean rightTrue = isSameTree(p.right, q.right);

        return (leftTrue && rightTrue);
    }

}
