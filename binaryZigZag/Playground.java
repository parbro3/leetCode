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

        //level order traversal using queue
        Queue<TreeNode> masterQueue = new LinkedList<>();
        masterQueue.add(root);

        int depth = 0;
        Map<Integer, List<Integer>> depthToList = new HashMap<>();
        List<List<Integer>> masterList = new ArrayList<>();
        
        //while the queue is not empty
        while(!masterQueue.isEmpty()){

            //get node from queue
            TreeNode node = masterQueue.poll();
            if(depthToList.get(depth) == null)
                depthToList.put(depth, new ArrayList<Integer>());
            else{
                List<Integer> tempList = depthToList.get(depth);
                tempList.add(node.val);
            }

            //do whatever with the node... keep track of depth?

            depth++;
            if(node.left != null)
                masterQueue.add(node.left);
            if(node.right != null)
                masterQueue.add(node.right);
        }

        //now i should have a queue in the right order
        for(Integer index : depthToList.keySet()){
            masterList.add(depthToList.get(index));
        }

        return masterList;

    }


}
