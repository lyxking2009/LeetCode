import java.util.List;
import java.util.ArrayList;

public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size || index < 0)
            return -1;
        Node cur = head;
        for (int i=0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newHead = new Node(val);
        if (this.size == 0) {
            this.head = newHead;
            this.tail = newHead;
            this.size = 1;
        } else {
            newHead.next = this.head;
            this.head = newHead;
            this.size++;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newTail = new Node(val);
        if (this.size == 0) {
            addAtHead(val);
        } else {
            this.tail.next = newTail;
            this.tail = newTail;
            this.size++;
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == size)
            addAtTail(val);
        else if (index == 0)
            addAtHead(val);
        else if (index < size) {
            Node cur = this.head;
            for (int i = 0; i < index - 1; i++) {
                    cur = cur.next;
            }
            Node tmp = new Node(val);
            tmp.next = cur.next;
            cur.next = tmp;
            this.size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (this.size > 0) {
            if (index == 0) {
                this.head = this.head.next;
                this.size--;
                if (this.size == 0)
                    this.tail = this.head;
            } else if (index < this.size && index > 0) {
                Node cur = this.head;
                for (int i = 0; i < index - 1; i++) {
                    cur = cur.next;
                }
                if (index == size - 1) {
                    this.tail = cur;
                    cur.next = null;
                } else {
                    cur.next = cur.next.next;
                }
                this.size--;
            }

        }
    }
}

class Node {
    public int val;
    public Node next;

    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
        next = null;
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
        next = null;
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
        next = null;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */