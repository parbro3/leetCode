public class Playground {

    int firstIndex;
    int secondIndex;

    public void run(){
        int [] data = {1,8,6,2,5,4,8,3,7};
        //output should be 49
        betterSolution(data);
    }

    public int bruteForce(int[] data){
        int highestArea = 0;
        int tempArea = 0;
        for(int i = 0; i < data.length; i++){
            for(int j = 0; j < data.length; j++){
                if(j > i){
                    tempArea = computeArea(data, i, j);
                    if(tempArea > highestArea)
                        highestArea = tempArea;
                }
            }
        }
        return highestArea;
    }

    public int betterSolution(int[] data){
        int highestArea = 0;
        int tempArea = 0;

        firstIndex = 0;
        secondIndex = data.length - 1;

        //stop when you get together
        while(firstIndex < secondIndex){
            tempArea = computeArea(data, firstIndex, secondIndex);
            if(tempArea > highestArea)
                highestArea = tempArea;
            
            moveIndices(data);
        }
        return highestArea;
    }

    public void moveIndices(int[] data){
        if(data[firstIndex] < data[secondIndex])
            firstIndex += 1;
        else if(data[firstIndex] > data[secondIndex])
            secondIndex -= 1;
        else{
            firstIndex += 1;
        }
    }

    public int computeArea(int[] data, int indexOne, int indexTwo){
        int xValue = (Math.abs(indexOne - indexTwo));
        if(data[indexOne] <= data[indexTwo])
            return data[indexOne]*xValue;
        else
            return  data[indexTwo]*xValue;
    }
}
