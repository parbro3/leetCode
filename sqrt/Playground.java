import java.util.*;

public class Playground {

    public void run(){
        mySqrt(2147395599);
    }

    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        long middle;        

        if(x == 1)
            return 1;
        
        //not sure if this should be the condition
        while(Math.abs(left - right) > 1){

            middle = (left + right)/2;

            //correct base case
            //if 49, middle is 24
            long squaredNumber = middle*middle;
            if(squaredNumber == x)
                return (int)middle;
            
            if(squaredNumber < x)
                left = (int)middle;
            else
                right = (int)middle;
        }
        return left;
    }

}
