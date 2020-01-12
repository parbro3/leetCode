import java.util.*;

public class Playground {

    public void run(){
        rotate(new int[][]{new int[] {5, 1, 9,11}, new int[] {2, 4, 8,10}, new int[] {13, 3, 6, 7}, new int[] {15,14,12,16}});
    }

    /*
        [
            [ 5, 1, 9,11],
            [ 2, 4, 8,10],
            [13, 3, 6, 7],
            [15,14,12,16]
        ], 

        becomes

        [
            [15,13, 2, 5],
            [14, 3, 4, 1],
            [12, 6, 8, 9],
            [16, 7,10,11]
        ]
    */

    //[0][0] becomes [last][0]
    //[0][last] becomes [last][last]
    //[last][last] becomes [last][0]
    //[last][0] becomes [0][0]

    public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length/2; i++){
            for(int j = 0; j < matrix[0].length/2; j++){

                //first flip
                //this is 5
                //next j is 1
                int tempFirst = matrix[i][j];
                //change 5 to 15
                //change 1 to 13
                matrix[i][j] = matrix[matrix.length - 1 - j][i];

                //change 15 to 16
                //change 13 to 12
                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];

                //change 16 to 11
                //change 12 to 10
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];

                //change 11 to 5... or saved temp
                //change 10 to saved 1
                matrix[j][matrix.length - 1 - i] = tempFirst;

            }
        }
        System.out.print("asdf");
    }
}
