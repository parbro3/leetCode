import java.util.*;

public class Playground {

    public void run(){
        rotate(new int[][]{new int[] {1,2,3}, new int[] {4,5,6}, new int[] {7,8,9}});
    }


    /*

    [
        [1,2,3],
        [4,5,6],
        [7,8,9]
    ],

    [
        [7,4,1],
        [8,5,2],
        [9,6,3]
    ]

    */


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

        int ending = matrix.length/2;
        if(matrix.length%2 == 1)
            ending+=1;

        for(int i = 0; i < ending; i++){
            for(int j = 0; j < matrix.length/2; j++){

                int tempFirst = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
                matrix[j][matrix.length - 1 - i] = tempFirst;
            }
        }
    }
}
