import java.util.*;

public class Playground {

    public void run(){


                              //i           j
        int[] first = new int[]{1, 3};

                               //k                    l
        int[] second = new int[]{2};

        findMedianSortedArrays(first, second);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int totalSize = nums1.length + nums2.length;
        int totalTimesMoved = 0;
        int lastNumberMoved = 0;

        //describes what was last moved
        boolean incrementerFirstArray = false;
        boolean decrementerFirstArray = false;

        int i = 0, j = nums1.length - 1, k = 0, l = nums2.length - 1;

        double calculateOneArray = calcOneArray(nums1, nums2);
        if(calculateOneArray != -1)
            return calculateOneArray;

        while(totalTimesMoved < totalSize - 1){
            //either move right in the first array
            //move right in the second array
            if(nums1[i] < nums2[k]){
                i++;
                incrementerFirstArray = true;
                lastNumberMoved = nums1[i];
            } else{
                k++;
                incrementerFirstArray = false;
                lastNumberMoved = nums2[k];
            }
            totalTimesMoved++;

            //move left in the first array
            //move left in the second array
            if(totalTimesMoved >= totalSize - 1)
                break;

            if(nums1[j] > nums2[l]){
                j--;
                decrementerFirstArray = true;
                lastNumberMoved = nums1[j];
            } else {
                l--;
                decrementerFirstArray = false;
                lastNumberMoved = nums2[l];
            }
            totalTimesMoved++;
        }

        //check two cursors
        if(totalSize % 2 == 0){
            double lowerValue = incrementerFirstArray ? nums1[i] : nums2[k];
            double upperValue = decrementerFirstArray ? nums1[j] : nums2[l];
            return (lowerValue + upperValue)/2;
        } else {
            //return the last one moved
            return lastNumberMoved;
        }
        
    }

    public double calcOneArray(int[] nums1, int[] nums2){
        //i can assume one is filled out
        if(nums1.length == 0){
            return calcOneArray(nums2);
        } else if(nums2.length == 0){
            return calcOneArray(nums1);
        }
        return -1;
    }

    public double calcOneArray(int[] nums2){
        if(nums2.length % 2 == 0){
            double first = nums2[(nums2.length/2)-1];
            double second = nums2[(nums2.length/2)];
            return (first + second)/2;
        } else {
            return nums2[(nums2.length/2)];
        }
    }

}
