import java.util.*;

public class Playground {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public void run(){

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);

        TreeNode first1 = root.left;
        first1.left = new TreeNode(4);
        first1.right = new TreeNode(5);

        TreeNode first2 = root.right;
        first2.left = new TreeNode(5);
        first2.right = new TreeNode(4);


        TreeNode second1 = first1.left;
        second1.left = null;
        second1.right = null;

        TreeNode second2 = first1.right;
        second2.left = new TreeNode(8);
        second2.right = new TreeNode(9); 

        TreeNode second3 = first2.left;
        second3.left = null;
        second3.right = null;

        TreeNode second4 = first2.right;
        second4.left = new TreeNode(9);;
        second4.right = new TreeNode(8);;

        isSymmetric(root);
    }

    public boolean isSymmetric(TreeNode root) {
        
        //somehow gotta keep track of depth
        int depth = 0;
        Map<Integer,List<Integer>> mapDepthToSeries = new HashMap<Integer,List<Integer>>();

        helper(root, depth, mapDepthToSeries);

        return checkMap(mapDepthToSeries);
    }
    
    public void helper(TreeNode node, Integer depth, Map<Integer,List<Integer>> mapDepthToSeries){

        if(node == null)
            return;

        if(mapDepthToSeries.get(depth + 1) == null){
            mapDepthToSeries.put(depth + 1, new ArrayList<Integer>());
        }
        
        List<Integer> leaves = new ArrayList<Integer>();

        if(node.left != null)
            leaves.add(node.left.val);
        else
            leaves.add(null);
        
        if(node.right != null)
            leaves.add(node.right.val);
        else
            leaves.add(null);
        
        mapDepthToSeries.get(depth + 1).addAll(leaves);
        
        depth++;
        if(node.left != null)
            helper(node.left, depth, mapDepthToSeries);
        if(node.right != null)
            helper(node.right, depth, mapDepthToSeries);
    }

    public boolean checkMap(Map<Integer,List<Integer>> mapDepthToSeries){
        for(List<Integer> oneList : mapDepthToSeries.values()){
            if(!checkList(oneList))
                return false;
        }
        return true;
    }

    public boolean checkList(List<Integer> oneList){
        for(int i = 0; i < oneList.size()/2; i++){
            if(!(oneList.get(i) == oneList.get(oneList.size()-1-i)))
                return false;
        }
        return true;
    }
}
