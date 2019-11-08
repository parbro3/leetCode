import java.util.*;

public class Playground {

    public void run(){
        String asdf = "AB";
        convert(asdf, 1);
    }

    public String convert(String s, int numRows) {
               
        char[][] completedArray = new char[numRows][s.length()];
        boolean levelGoingUp = false;
        int row = 0;
        int column = 0;
        char[] charArray = s.toCharArray();

        if(numRows == 1)
            return s;
        
        for(int i = 0; i < charArray.length; i++){
            completedArray[row][column] = charArray[i];

            if(row == numRows - 1)
                levelGoingUp = true;
            else if(row == 0)
                levelGoingUp = false;

            if(!levelGoingUp)
                row++;
            else{
                row--;
                column++;
            }
        } 

        return convertToString(completedArray);
    }

    public String convertToString(char[][] completedArray){
        StringBuilder sb = new StringBuilder();
        //this will be terrible runtime
        for(int i = 0; i < completedArray.length; i++){
            for(int j = 0; j < completedArray[i].length; j++){
                if(completedArray[i][j] != '\u0000')
                    sb.append(completedArray[i][j]);
            }
        }
        return sb.toString();
    }

}
