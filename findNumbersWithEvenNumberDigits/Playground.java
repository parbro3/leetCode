import java.util.*;

public class Playground {

    public void run(){
        findNumbers(new int[] {12,345,2,6,7896});
    }

    public int findNumbers(int[] nums) {
        return anotherSolution(nums);
    }

    public int anotherSolution(int[] nums){
        Integer totalCounter = 0;
        for(Integer number : nums){

            //turn the number into a string and get the length?
            if((Math.log10(number)+1) % 2 == 0)
                totalCounter++;
        }
        return totalCounter;
    }

    public int betterSolution(int[] nums){
        Integer totalCounter = 0;
        for(Integer number : nums){

            //turn the number into a string and get the length?
            if(String.valueOf(number).length() % 2 == 0)
                totalCounter++;
        }
        return totalCounter;
    }

    public int bruteForce (int[] nums){
        Integer totalCounter = 0;
        for(Integer number : nums){
            Integer digitCounter = 0;
            while(number > 0){
                number = number/10;
                digitCounter++;
            }
            if(digitCounter %2 == 0)
                totalCounter++;
        }
        return totalCounter;
    }

}
