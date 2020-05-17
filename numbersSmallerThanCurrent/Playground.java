import java.util.*;

public class Playground {

    public void run(){
        play();
    }

    public void play() {
        smallerNumbersThanCurrent(new int[]{8,1,2,23});
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        return bruteForce(nums);
    }

    public int[] bruteForce(int[] nums){
        //initialize an array
        int[] counts = new int[nums.length];

        int count = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(i != j){
                    if(nums[i] > nums[j])
                        count++;
                }
            }
            counts[i] = count;
            count = 0;
        }
        return counts;
    }

}
