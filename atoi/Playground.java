import java.util.*;

public class Playground {

    public void run(){
        myAtoi("9223372036854775808");
    }

    public int myAtoi(String str) {

        char[] charArray = str.toCharArray();
        if(charArray.length == 0)
            return 0;

        int index = 0;
        int negative = 1;

        //trim white space
        while(index < charArray.length && charArray[index] == ' ')
            index++;
        
        if(index >= charArray.length)
            return 0;

        //check negative
        if(charArray[index] == '-'){
            negative = -1;
            index++;
        } else if(charArray[index] == '+'){
            index++;
        }
        
        //make sure they are numbers
        double result = 0;
        int digits = 0;
        while(index < charArray.length && Character.isDigit(charArray[index])){
            //multiply by 10 and add the new char
            result = (result*10) + (charArray[index] - '0');
            index++;
            digits++;
        }

        result = result*negative;

        if(result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if(result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return digits > 0 ? (int)result : 0;
    }

}
