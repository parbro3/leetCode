import java.util.*;

public class Playground {

    int highestDepth = 0;

     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public ListNode createList(int a){
        ListNode root = new ListNode(a);
        return root;
    }

    public void run(){

        ListNode root = createList(2);
        ListNode root2 = createList(1);
        mergeTwoLists(root, root2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //figure out which should be l1
        if((l1 == null && l2 != null) || (l1 != null && l2 != null && l2.val < l1.val)){
            ListNode tempL1 = l1;
            l1 = l2;
            l2 = tempL1;
        }

        ListNode root = l1;

        while(l1 != null){
            //check if l2 has a node to insert
            while(l1.next != null && l2 != null && l2.val <= l1.next.val){
                l2 = insert(l1, l2);
                l1 = l1.next;
            }
            l1 = l1.next;
        }

        if(l2 != null)
            l1.next = l2;

        return root;
    }

    public ListNode insert(ListNode l1, ListNode l2){
        ListNode remainingL1 = l1.next;
        ListNode remainingL2 = l2.next;
        l1.next = l2;
        l2.next = remainingL1;
        return remainingL2;
    }

}
