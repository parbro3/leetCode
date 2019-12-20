import java.util.*;

public class Playground {

    public void run(){
        play();
    }

    public void play() {

        uncommonFromSentences("this apple is sweet", "this apple is sour");
    }

    public String[] uncommonFromSentences(String A, String B) {

        Map<String,Integer> countWords = new HashMap<>();
        String[] aWords = A.split(" ");
        String[] bWords = B.split(" ");

        for(String word : aWords){
            addToMap(word, countWords);
        }
        for(String word: bWords){
            addToMap(word, countWords);
        }

        //now build the array of words with only one
        List<String> finalList = new ArrayList<>();
        for(String word : countWords.keySet()){
            if(countWords.get(word) == 1)
                finalList.add(word);
        }

        return finalList.toArray(new String[0]);
    }

    public void addToMap(String word, Map<String,Integer> countWords){
        Integer tempCount = countWords.get(word);
        if(tempCount == null){
            countWords.put(word, 1);
        } else {
            countWords.put(word, ++tempCount);
        }
    }

}
