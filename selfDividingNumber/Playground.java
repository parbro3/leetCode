import java.util.*;

public class Playground {

    public void run(){
        selfDividingNumbers(1, 22);
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
    
        List<Integer> listNumbers = new ArrayList<>();
        
        //loop through numbers
        for(int number = left; number <= right; number++){
            //divide numbers to get each digits
            if(isSelfDividing(number)){
                listNumbers.add(number);
            }
        }

        return listNumbers;
    }

    public boolean isSelfDividing(int number){
        int originalNumber = number;
        while(number > 0){
            int remainder = number%10;
            if(remainder == 0 || originalNumber%remainder != 0)
                return false;
            number = number/10;
        }  
        return true;
    }

}
