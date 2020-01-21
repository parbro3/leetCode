import java.util.*;

public class Playground {

    class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public void run(){

        Node zerothNode = new Node(7);
        Node firstNode = new Node(13);
        Node secondNode = new Node(11);
        Node thirdNode = new Node(10);
        Node fourthNode = new Node(1);

        zerothNode.next = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;

        zerothNode.random = null;
        firstNode.random = zerothNode;
        secondNode.random = fourthNode;
        thirdNode.random = secondNode;
        fourthNode.random = zerothNode;

        copyRandomList(zerothNode);
        System.out.print("asdf");
    }

    Map<Node,Node> oldToNewNode = new HashMap<>();

    public Node copyRandomList(Node head) {

        if(head == null)
            return null;

        //return the new one if you already created it
        if(oldToNewNode.containsKey(head))
            return oldToNewNode.get(head);

        //otherwise make a new one
        Node newNode = new Node(head.val);
        oldToNewNode.put(head, newNode);
        
        //parse in order
        newNode.next = copyRandomList(head.next);

        //parse through randoms
        newNode.random = copyRandomList(head.random);

        return newNode;
    }


}
