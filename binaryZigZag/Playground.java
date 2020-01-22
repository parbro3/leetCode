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
            2       3   
        4               5

        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode left = root.left;
        TreeNode right = root.right;

        left.left = new TreeNode(4);

        //right.left = new TreeNode(15);
        right.right = new TreeNode(5);

        zigzagLevelOrder(root);
    }

    Map<Integer, List<Integer>> depthToList = new HashMap<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        //simple level order traversal...
        helper(root, 0);

        List<List<Integer>> masterList = new ArrayList<>();
        for(Integer depth : depthToList.keySet()){
            masterList.add(depthToList.get(depth));
        }
        return masterList;
    }

    public void helper(TreeNode node, int depth){
        if(node == null)
            return;

        //this will be fine if you put it in the right spot
        if(depthToList.get(depth) == null){
            depthToList.put(depth, new ArrayList<Integer>());
        }
        System.out.print(node.val);
        List<Integer> tempList = depthToList.get(depth);
        tempList.add(node.val);

        depth+=1;

        if(depth%2 == 0){
            helper(node.left, depth);
            helper(node.right, depth);
        } else {
            helper(node.right, depth);
            helper(node.left, depth);
        }
    }

}
