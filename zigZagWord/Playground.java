import java.util.*;

public class Playground {

    public void run(){
        String asdf = "PAYPALISHIRING";
        convert(asdf, 3);
    }

    public String convert(String s, int numRows){
        List<StringBuilder> allSBs = initializeAllSbs(numRows);
        char[] charArray = s.toCharArray();
        int row = 0;
        boolean levelGoingUp = false;

        if(numRows == 1)
            return s;
        
        for(int i = 0; i < charArray.length; i++){
            StringBuilder sb = allSBs.get(row);
            sb.append(charArray[i]);

            if(row == numRows - 1)
                levelGoingUp = true;
            else if(row == 0)
                levelGoingUp = false;

            if(!levelGoingUp)
                row++;
            else{
                row--;
            }
        } 

        StringBuilder convertedString = new StringBuilder();
        allSBs.forEach((sb) -> convertedString.append(sb.toString()));
        return convertedString.toString();
    }

    public List<StringBuilder> initializeAllSbs(int numRows){
        List<StringBuilder> allSbs = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++){
            StringBuilder tempSB = new StringBuilder();
            allSbs.add(tempSB);
        }
        return allSbs;
    }

    public String convertBruteForce(String s, int numRows) {
               
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
