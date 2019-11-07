public class Playground {

    public void run(){
        String asdf = "asdffewragsdf";
        //output should be 49
        betterSolution(asdf);
    }

    public int betterSolution(String s) {

        int currentCount = 0;
        int highestCount = 0;
        int initialIndex = 0;
        char[] charArray = s.toCharArray();
        Map<Character,Integer> charCount = new HashMap<Character,Integer>();

        for(int i = 0; i < charArray.length; i++){
            if(charCount.get(charArray[i]) == null){
                charCount.put(charArray[i], i);
                currentCount++;
                if(currentCount > highestCount)
                    highestCount = currentCount;
            }else{
                currentCount = 0;
                i = charCount.get(charArray[i]);
                charCount = new HashMap<Character,Integer>();
            }
        }
        return highestCount;
    }

}
