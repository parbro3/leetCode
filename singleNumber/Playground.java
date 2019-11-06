import java.util.*;

public class Playground {

    public int singleNumber(int[] nums) {
        int XORNumber = 0;
        for(int i = 0; i < nums.length; i++){
            XORNumber = XORNumber ^ nums[i];
        }
        return XORNumber;
    }   

        //use bitwise operator XOR
        
        /*

            Given the following array:
            [ 1, 6, 10, 6, 10 ]

            //start with 0

            First:
            0 0 0 0 0 0 0 0
            0 0 0 0 0 0 0 1

            XOR
            0 0 0 0 0 0 0 1

            Second
            0 0 0 0 0 0 0 1
            0 0 0 0 0 1 1 0

            XOR
            0 0 0 0 0 1 1 1

            Third
            0 0 0 0 0 1 1 1
            0 0 0 0 1 0 1 0

            XOR
            0 0 0 0 1 1 0 1

            Fourth
            0 0 0 0 1 1 0 1
            0 0 0 0 0 1 1 0

            XOR
            0 0 0 0 1 0 1 1

            Fifth
            0 0 0 0 1 0 1 1
            0 0 0 0 1 0 1 0

            XOR
            0 0 0 0 0 0 0 1
            
            Answer: 1

        */

}
