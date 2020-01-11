import java.util.*;
import java.util.stream.Collectors;

public class Playground {

    public void run(){
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        /*
            A solution set is:
            [
                [-1, 0, 1],
                [-1, -1, 2]
            ]
        */
    }

    public List<List<Integer>> threeSum(int[] nums) {
        return bruteForce(nums);        
    }

    public List<List<Integer>> bruteForce(int[] nums){

        List<List<Integer>> allLists = new ArrayList<List<Integer>>();
        Map<Integer, Integer> crazyMap = new HashMap<>();

        //initialize map
        for(int i = 0; i < nums.length; i++){
            crazyMap.put(nums[i], i);
        }

        //build map first
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(i != j && i < j){
                    Integer index = crazyMap.get((nums[i]+nums[j])*-1);
                    if(index != null){
                        if(i != index && j != index){
                            List<Integer> tempList = new ArrayList<>();
                            tempList.add(nums[i]); tempList.add(nums[j]); tempList.add(nums[index]);

                            if(!checkAlreadyIn(allLists, tempList))
                                allLists.add(tempList);
                        }
                    }
                }
            }
        }

        return allLists;
    }

    public boolean checkAlreadyIn(List<List<Integer>> allLists, List<Integer> checkList){
        for(List<Integer> currentList : allLists){
            List<Integer> tempList = new ArrayList<>(checkList);
            if(checkSame(currentList, tempList)){
                return true;
            }
        }
        return false;
    }

    public boolean checkSame(List<Integer> list1, List<Integer> list2){
        for(Integer num : list1){
            list2.remove(num);
        }
        return list2.size() == 0;
    }

}
