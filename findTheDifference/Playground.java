import java.util.*;

public class Playground {

    public void run(){
        findTheDifference("abcd", "abcde");
    }

    public char findTheDifference(String s, String t) {

        Map<Character,Integer> sLetters = populateMap(s);
        Map<Character,Integer> tLetters = populateMap(t);

        //loop through one map and check the other one as you go
        for(char character : tLetters.keySet()){
            if(sLetters.get(character) == null || !(sLetters.get(character) == tLetters.get(character)))
                return character;
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
                countLetters.put(sCharArray[i], 0);
            else
                countLetters.put(sCharArray[i], ++count);
        }
        return countLetters;
    }

}
