import java.util.*;

public class Playground {

    public void run(){
        System.out.print(myPow(0.00001, 2147483647));
    }

    public double myPow(double x, int n) {

        double orignalNumber = x;
        for(int i = 1; i < Math.abs(n); i++){
            x = x*orignalNumber;
        }

        if(n > 0)
            return x;
        else if(n < 0)
            return (double)1/x;
        else
            return 1;
    }

}
