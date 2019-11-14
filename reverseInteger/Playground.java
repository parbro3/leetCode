import java.util.*;

public class Playground {

    public void run(){
        reverse(1534236469);
    }

    public int reverse(int x) {

        boolean negative = false;
        if(x < 0)
            negative = true;

        x = Math.abs(x);

        int length = String.valueOf(x).length();
        double newNumber = 0;

        while(x > 0){
            int digit = x % 10;
            x = x / 10;
            newNumber = newNumber + (digit * Math.pow(10, length - 1));
            length--;
        }

        if (newNumber > Integer.MAX_VALUE)
            return 0;

        return negative ? (int)newNumber*-1 : (int)newNumber;
    }

}
