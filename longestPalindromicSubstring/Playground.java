import java.util.*;

public class Playground {

    public void run(){
        longestPalindrome("jrjnbctoqgzimtoklkxcknwmhiztomaofwwzjnhrijwkgmwwuazcowskjhitejnvtblqyepxispasrgvgzqlvrmvhxusiqqzzibcyhpnruhrgbzsmlsuacwptmzxuewnjzmwxbdzqyvsjzxiecsnkdibudtvthzlizralpaowsbakzconeuwwpsqynaxqmgngzpovauxsqgypinywwtmekzhhlzaeatbzryreuttgwfqmmpeywtvpssznkwhzuqewuqtfuflttjcxrhwexvtxjihunpywerkktbvlsyomkxuwrqqmbmzjbfytdddnkasmdyukawrzrnhdmaefzltddipcrhuchvdcoegamlfifzistnplqabtazunlelslicrkuuhosoyduhootlwsbtxautewkvnvlbtixkmxhngidxecehslqjpcdrtlqswmyghmwlttjecvbueswsixoxmymcepbmuwtzanmvujmalyghzkvtoxynyusbpzpolaplsgrunpfgdbbtvtkahqmmlbxzcfznvhxsiytlsxmmtqiudyjlnbkzvtbqdsknsrknsykqzucevgmmcoanilsyyklpbxqosoquolvytefhvozwtwcrmbnyijbammlzrgalrymyfpysbqpjwzirsfknnyseiujadovngogvptphuyzkrwgjqwdhtvgxnmxuheofplizpxijfytfabx");
    }

    public String longestPalindrome(String s) {
        return bruteForce(s);
    }

    public String bruteForce(String s){
        char[] charArray = s.toCharArray();
        int[] tuple = new int[]{0,-1};

        for(int i = 0; i < charArray.length; i++){
            for(int j = 0; j < charArray.length; j++){
                if(checkPalindrome(charArray, i, j))
                    if((j-i) > tuple[1] - tuple[0]){
                        tuple[0] = i;
                        tuple[1] = j;
                    }
            }
        }

        //build final string
        StringBuilder sb = new StringBuilder();
        for(int k = tuple[0]; k <= tuple[1]; k++)
            sb.append(charArray[k]);
        return sb.toString();
    }

    public boolean checkPalindrome(char[] charArray, int i , int j){
        Stack<Character> stack = new Stack<Character>();
        if(j - i == 0)
            return true;
        
        boolean alreadyMovedBack = false;

        //add first half
        int k = i;
        while(k <= j){
            if(k <= (i+j)/2){
                stack.add(charArray[k]);
            } else {
                if((j-i) % 2 == 0 && !alreadyMovedBack){
                    k--;
                    alreadyMovedBack = true;
                }
                if(stack.peek().equals(charArray[k]))
                    stack.pop();
            }
            k++;
        }
        return stack.empty();
    }

}
