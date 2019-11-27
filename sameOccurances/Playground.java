import java.util.*;

public class Playground {

    public void run(){
        uniqueOccurrences(new int[]{1,2,2,1,1,3});
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();        
        for(int i = 0; i < arr.length; i++){
            Integer count = countMap.get(arr[i]);
            if(count == null){
                countMap.put(arr[i], 1);
            } else {
                countMap.put(arr[i], ++count);
            }
        }
        return countMap.keySet().size() == new HashSet(countMap.values()).size();
    }

}
