import java.util.*;

public class Playground {

    public void run(){
        twoSum(new int[]{2, 7, 11, 15}, 9);
    }

    public int[] twoSum(int[] nums, int target) {
        return bruteForce(nums, target);                
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
