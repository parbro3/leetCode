import java.util.*;

public class Playground {

    public void run(){
        isPerfectSquare(16);
    }

    public boolean isPerfectSquare(int num) {
        Double checker = 0.0;
        Double squared = 0.0;
        
        while(squared < num){
            checker++;
            squared = checker*checker;
        }
        if(squared == num)
            return true;
        return false;
    }
}
