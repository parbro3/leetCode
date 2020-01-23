import java.util.*;

public class Playground {

    public void run(){
        trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }

    public int trap(int[] height) {
        
        return bruteForce(height);

    }

    public int bruteForce(int[] height){

        int highestLeftBoundary = -1;
        int totalVolume = 0;
        int toAdd = 0;

        for(int i = 0; i < height.length; i++){

            if(i != 0 && i != height.length - 1){

                //set left boundary
                if(highestLeftBoundary == -1){
                    highestLeftBoundary = height[i];
                    i++;
                }

                while(i < height.length && height[i] < highestLeftBoundary){
                    toAdd = toAdd + (highestLeftBoundary - height[i]);
                    i++;
                }
                i--;

                if(i< height.length - 1){
                    totalVolume += toAdd;
                    toAdd = 0;
                }

                highestLeftBoundary = -1;
            }

        }

        return totalVolume;
    }

}
