import java.util.*;

public class Playground {

    public void run(){
        findTheDifference("a", "aa");
    }

    public char findTheDifference(String s, String t) {

        Map<Character,Integer> sLetters = populateMap(s);
        char[] tLetters = t.toCharArray();

        //loop through one map and check the other one as you go
        for(char character : tLetters){
            //check the s map with the t letters. If you find it. Decrement.
            if(sLetters.get(character) != null && sLetters.get(character) > 0){
                sLetters.put(character, sLetters.get(character) - 1);
            } else {
                return character;
            }

        }
        return 0;
    }
    
    public Map<Character,Integer> populateMap(String s){
        Map<Character,Integer> countLetters = new HashMap<>();
        char[] sCharArray = s.toCharArray();
        
        //populate map
        for(int i = 0; i < sCharArray.length; i++){
            Integer count = countLetters.get(sCharArray[i]);
            if(count == null)
                countLetters.put(sCharArray[i], 1);
            else
                countLetters.put(sCharArray[i], ++count);
        }
        return countLetters;
    }

}
