import java.util.*;

public class Playground {

    public void run(){
        arrangeCoins(5);
    }

    public int arrangeCoins(int n) {

        //just have to return the row of the n that it fails on
        //sum of (n+1) from 0 to k... and returning k essentially.
        return faster(n);
    }

    public int faster(int n){

        /*
             k
             ∑ (n+1)  can be written as n*(n+1)/2
            n=0

            This confused me for a bit until I found a good youtube video to explain it.
            https://www.youtube.com/watch?v=tpkzn2e5mtI

            Then set this equal to the total which is technically n.. but we're going to call it N

            N = n*(n+1)/2

            Then make it a quadratic formula
            0 = n^2 + n - 2N    where N is the number given to you as the input

            then solve the quadratic formula with  ...   (-b +- sqrt(b^2 - 4ac) ) /2a

            which becomes ....      (-1 +- sqrt( 1 - 4*1*(-2*N))) / 2

            casting it as an int will give you the last full row
        */

        return (int)(-1 + Math.sqrt( 1 + 8*(long)n)) / 2;
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
