import java.util.*;

public class Playground {

    public void run(){
        String s = "({[]})";
        isValid(s);
    }

    public boolean isValid(String s){

        Map<Character,Integer> charToIntMap = new HashMap<Character,Integer>();
        charToIntMap.put('(',1);
        charToIntMap.put('[',2);
        charToIntMap.put('{',3);
        charToIntMap.put(')',4);
        charToIntMap.put(']',5);
        charToIntMap.put('}',6);

        //integer mod 3 will tell me what type of parentheses

        char[] charArray = s.toCharArray();   

        Stack<Character> stackChars = new Stack<Character>();

        for(Character character : charArray){
            if(stackChars.isEmpty()){
                stackChars.add(character);
            } else {
                //check if we should pop or not
                if(charToIntMap.get(character) % 3 == charToIntMap.get(stackChars.peek()) % 3){
                    //if they are of the same parentheses type
                    if(character.equals(stackChars.peek())){
                        //if they're the same character add to stack
                        stackChars.add(character);
                    } else {
                        stackChars.pop();
                    }
                } else {
                    //not the same parentheses type
                    if(charToIntMap.get(character) < 4){
                        //if it's an open parentheses, this is fine... because we just add it to the stack
                        stackChars.add(character);
                    } else {
                        return false;
                    }
                }
            }
        }

        if(!stackChars.isEmpty())
            return false;
        
        return true;
    }

}
