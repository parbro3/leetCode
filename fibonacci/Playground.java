import java.util.*;

public class Playground {

    int countingTotal = 0;

    public void run(){
        fib(4);
    }

    public int fib(int N) {
        helper(1, 0, N);
        return countingTotal;
    }

    public void helper(int previous, int steps, int N){
        if(steps == N)
            return;
        steps += 1;
        int previousTotal = countingTotal;
        countingTotal += previous;
        helper(previousTotal, steps, N);
    }

}
