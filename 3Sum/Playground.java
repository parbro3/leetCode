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
                if(i < j){
                    Integer index = crazyMap.get((nums[i]+nums[j])*-1);
                    if(index != null && j < index){

                        List<Integer> tempList = addInOrder(nums[i], nums[j], nums[index]);

                        if(!checkAlreadyIn(allLists, tempList))
                            allLists.add(tempList);
                    }
                }
            }
        }

        return allLists;
    }

    public List<Integer> addInOrder(int i, int j, int k){
        List<Integer> finalList = new ArrayList<>();
        finalList.add(i);
        if(i <= j)
            finalList.add(j);
        else
            finalList.add(0,j);
        
        if(k >= i && k >= j){
            finalList.add(k);
        } else if(k <= i && k <= j){
            finalList.add(0,k);
        } else if((i >= k && j <= k) || (i <= k && j >= k)){
            finalList.add(1,k);
        }
        return finalList;
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
        return list1.get(0) == list2.get(0) && list1.get(1) == list2.get(1) && list1.get(2) == list2.get(2);
    }

}
