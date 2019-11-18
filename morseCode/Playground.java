import java.util.*;

public class Playground {

    public void run(){
        play();
    }

    public Map<Character,String> createMap(){
        Map<Character,String> morseMap = new HashMap();
        morseMap.put('a',".-"); morseMap.put('b',"-..."); morseMap.put('c',"-.-."); morseMap.put('d',"-.."); morseMap.put('e',"."); morseMap.put('f',"..-.");
        morseMap.put('g',"--."); morseMap.put('h',"...."); morseMap.put('i',".."); morseMap.put('j',".---"); morseMap.put('k',"-.-"); morseMap.put('l',".-..");
        morseMap.put('m',"--"); morseMap.put('n',"-."); morseMap.put('o',"---"); morseMap.put('p',".--."); morseMap.put('q',"--.-"); morseMap.put('r',".-.");
        morseMap.put('s',"..."); morseMap.put('t',"-"); morseMap.put('u',"..-"); morseMap.put('v',"...-"); morseMap.put('w',".--"); morseMap.put('x',"-..-");
        morseMap.put('y',"-.--"); morseMap.put('z',"--..");
        return morseMap;
    }

    public int uniqueMorseRepresentations(String[] words) {

        Map<Character,String> morseMap = createMap();
        Set<String> allWords = new HashSet();

        for(String word : words){
            char[] charArray = word.toCharArray();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < charArray.length; i++){
                String encodedString = morseMap.get(charArray[i]);
                sb.append(encodedString);
            }
            allWords.add(sb.toString());
            sb = new StringBuilder();
        }
        return allWords.size();
    }

}
