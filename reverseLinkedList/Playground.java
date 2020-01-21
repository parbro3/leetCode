import java.util.*;

public class Playground {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void run(){
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        ListNode next = root.next;
        next.next = new ListNode(3);
        next = next.next;
        next.next = new ListNode(4);
        next = next.next;
        next.next = new ListNode(5);

        reverseList(root);
    }

    public ListNode reverseList(ListNode head) {
        return recursive(head);
    }

    public ListNode recursive(ListNode head){
        return helper(head);
    }

    public ListNode helper(ListNode node){

        if(node.next == null || node == null)
            return node;
        else{
            ListNode temp = helper(node.next);
            node.next.next = node;
            node.next = null;
            return temp;
        }

    }

    public ListNode iterativeInPlace(ListNode node){
        ListNode rightNode = null;
        ListNode currentNode = node;
        while(currentNode != null){

            ListNode copyRest = currentNode.next;
            currentNode.next = rightNode;
            rightNode = currentNode;

            //iterate through them
            currentNode = copyRest;
        }
        return currentNode;
    }


    //this is like copying the linked list
    //maybe first put them into an arraylist of nodes.. then work backward
    public ListNode iterative(ListNode node){

        if(node == null)
            return node;

        ListNode head = node;
        List<ListNode> listNodes = new ArrayList<ListNode>();
        while(node != null){
            listNodes.add(node);
            node = node.next;
        }

        //now that we have the arraylist of nodes iterate through backward
        ListNode currentNode = null;
        for(int i = listNodes.size() - 1; i >= 0; i--){

            if(currentNode == null){
                currentNode = listNodes.get(i);
                head = currentNode;
            } else{
                currentNode.next = listNodes.get(i);
                currentNode = currentNode.next;
            }
        }
        currentNode.next = null;
        return head;
    }

}
