import java.util.*;

public class Playground {

    public void run(){
        lengthOfLastWord("Hello World");
    }

    public int lengthOfLastWord(String s) {
        //separate into strings
        String[] words = s.split(" ");
        if(words.length == 0)
            return 0;
        return words[words.length - 1].length();
    }

}
