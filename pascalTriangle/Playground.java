import java.util.*;

public class Playground {

    public void run(){
        generate(5);
    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> masterList = new ArrayList<List<Integer>>();

        if(numRows > 0){
            List<Integer> firstRow = new ArrayList<Integer>();
            firstRow.add(1);
            masterList.add(firstRow);
        }
        if(numRows > 1){
            List<Integer> secondRow = new ArrayList<Integer>();
            secondRow.add(1);
            secondRow.add(1);
            masterList.add(secondRow);
        }

        //start at 2 because first two rows are done
        for(int i = 2; i < numRows; i++){
            masterList.add(generateList(masterList.get(i - 1)));
        }
        return masterList;
    }

    public List<Integer> generateList(List<Integer> priorList){
        List<Integer> newList = new ArrayList<Integer>();
        newList.add(1);

        for(int i = 0; i < priorList.size() - 1; i++){
            newList.add(priorList.get(i) + priorList.get(i+1));
        }

        newList.add(1);
        return newList;
    }

}
