public class Playground {

    public void run(){
        String asdf = "abcabcbb";
        //answer is abc of length 3
        bruteForce(asdf);
    }

    public int betterSolution(String s) {
        //deleted to try again
        return 0;
    }

    public int bruteForce(String s){
        int longestLength = 0;
        int currentLength = 0;
        int firstIndexSB = 0;
        char[] charArray = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < charArray.length; i++){
            if(sb.toString().contains(String.valueOf(charArray[i]))){
                sb = new StringBuilder();
                i = firstIndexSB;
                firstIndexSB = firstIndexSB + 1;
            }
            else{
                sb.append(charArray[i]);
                currentLength = sb.length();
                if(currentLength > longestLength)
                    longestLength = currentLength;
            }
            //but wait... we have to have the ability to go back...
            //maybe we keep track of the index for the first letter of the stringbuilder
        }

        return longestLength;
    }

}
