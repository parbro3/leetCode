import java.util.*;

public class Playground {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void run(){

        ListNode root = new ListNode(5);
        /*
        ListNode second = new ListNode(4);
        root.next = second;
        */

        ListNode root1 = new ListNode(5);
        /*
        ListNode second1 = new ListNode(6);
        ListNode third1 = new ListNode(4);
        root1.next = second1;
        second1.next = third1;
        */

        addTwoNumbers(root, root1);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int l1Val = 0;
        int l2Val = 0;
        int total = 0;

        ListNode addedTogether = new ListNode(0);
        ListNode root = null;

        boolean carry1 = false;

        while(!(l1 == null && l2 == null && !carry1)){

            if(l1 != null)
                l1Val = l1.val;
            else
                l1Val = 0;

            if(l2 != null)
                l2Val = l2.val;
            else
                l2Val = 0;
                

            total = l1Val + l2Val;
            if(carry1){
                total+=1;
                carry1 = false;
            }

            if(total >= 10){
                total = total%10;
                carry1 = true;
            }

            if(root == null){
                addedTogether = new ListNode(total);
                root = addedTogether;
            } else {
                addedTogether.next = new ListNode(total);
                addedTogether = addedTogether.next;
            }

            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }

        return root;
    }

}
