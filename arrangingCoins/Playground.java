import java.util.*;

public class Playground {

    public void run(){
        arrangeCoins(5);
    }

    public int arrangeCoins(int n) {

        //just have to return the row of the n that it fails on
        
        //sum of (n+1) from 0 to k... and returning k essentially.
        return bruteForce(n);

    }

    public int bruteForce(int n){
        int counter = 0;
        while(n >= 0){
            counter += 1;
            n -= counter;
        }
        return --counter;
    }

}
