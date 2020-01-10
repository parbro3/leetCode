import java.util.*;

public class Playground {

    public void run(){
        twoSum(new int[]{2, 7, 11, 15}, 9);
    }

    public int[] twoSum(int[] nums, int target) {
        return optimized(nums, target);                
    }

    public int[] optimized(int[] nums, int target){
        //probably use a map

        //don't want nested stuff

        //make a map of the index to the difference... then parse through again
        Map<Integer, Integer> indexToDifference = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            indexToDifference.put(target - nums[i], i);
        }

        for(int i = 0; i < nums.length; i++){
            if(indexToDifference.get(nums[i]) != null){
                if(i != indexToDifference.get(nums[i]))
                    return new int[]{i, indexToDifference.get(nums[i])};
            }
        }
        return null;
    }

    public int[] bruteForce(int[] nums, int target){
        //parse through the array
        for(int i = 0; i < nums.length; i++){
            //parse through the array again looking for the other number
            for(int j = 0; j < nums.length; j++){
                if(i != j){
                    int sum = nums[i] + nums[j];
                    if(sum == target)
                        return new int[]{i,j};
                }
            }
        }
        return null;
    }

}
