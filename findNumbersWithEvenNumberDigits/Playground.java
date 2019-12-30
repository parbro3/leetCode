import java.util.*;

public class Playground {

    public void run(){
        findNumbers(new int[] {12,345,2,6,7896});
    }

    public int findNumbers(int[] nums) {
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
