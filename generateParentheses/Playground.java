import java.util.*;

public class Playground {

    public void run(){
        generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        
        int currentLeftNumber = 0;
        int currentRightNumber = 0;
        
        StringBuilder sb = new StringBuilder();
        String parenthesis = "(";
        
        List<String> totalList = new ArrayList<String>();
        
        helper(n, currentLeftNumber, currentRightNumber, parenthesis, sb, totalList);
        return totalList;
    }
    
    public void helper(int max, int currentLeft, int currentRight, String parenthesis, StringBuilder sb, List<String> totalList){

        if(parenthesis.equals("("))
            currentLeft++;
        else
            currentRight++;
        
        sb.append(parenthesis);
        
        if(currentLeft < max){
            helper(max, currentLeft, currentRight, "(", sb, totalList);
        }
        if(currentRight < currentLeft){
            if(currentRight < max){
                helper(max, currentLeft, currentRight, ")", sb, totalList);
            }
        }

        if(sb.length() == max*2){
            totalList.add(sb.toString());
        }
        sb.setLength(sb.length() - 1);
    }

}
