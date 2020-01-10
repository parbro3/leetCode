import java.util.*;
import java.util.stream.Collectors;

public class Playground {

    public void run(){
        threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6});
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

        //build crazy map first
        Map<Integer, Integer[]> crazyMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(i != j){
                    if(crazyMap.get(nums[i]+nums[j]) == null)
                        crazyMap.put(nums[i] + nums[j], new Integer[]{i, j});
                }
            }
        }

        //now that we have the crazy map... loop through the array again
        for(int i = 0; i < nums.length; i++){
            Integer[] value = crazyMap.get(nums[i]*-1);
            if(value != null){
                if(i != value[0] && i != value[1]){
                    if(nums[i] + nums[value[0]] + nums[value[1]] == 0){
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(nums[value[0]]); tempList.add(nums[value[1]]); tempList.add(nums[i]);

                        if(!checkAlreadyIn(allLists, tempList))
                            allLists.add(tempList);
                    }
                }
            }
        }

        //holy... this works.. but has duplicates. What if we changed to a set.
        return allLists;
    }

    public boolean checkAlreadyIn(List<List<Integer>> allLists, List<Integer> tempList){
        for(List<Integer> currentList : allLists){
            if(checkSame(currentList, tempList)){
                return true;
            }
        }
        return false;
    }

    public boolean checkSame(List<Integer> list1, List<Integer> list2){
        for(Integer num : list1){
            if(!list2.contains(num))
                return false;
        }
        return true;
    }

}
