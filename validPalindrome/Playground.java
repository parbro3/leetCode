import java.util.*;

public class Playground {

    public void run(){
        isPalindrome("0P");
    }

    public boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int i = 0;
        int j = charArray.length - 1;

        while(i <= j){
            while(!Character.isLetterOrDigit(charArray[i])){
                i++;
                if(i >= j)
                    return true;
            }
            while(!Character.isLetterOrDigit(charArray[j])){
                j--;
                if(i >= j)
                    return true;
            }

            //compare i and j
            Character iChar = Character.toLowerCase(charArray[i]);
            Character jChar = Character.toLowerCase(charArray[j]);

            if(!iChar.equals(jChar))
                return false;
            i++;
            j--;
        }

        return true;
    }

}
