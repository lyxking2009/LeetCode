public class MyDoublyLinkedList {
    private DoubleNode head;
    private DoubleNode tail;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Get the value of the index-th DoubleNode in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= size || index < 0)
            return -1;
        DoubleNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /**
     * Add a DoubleNode of value val before the first element of the linked list. After the insertion, the new DoubleNode will be the first DoubleNode of the linked list.
     */
    public void addAtHead(int val) {
        DoubleNode newHead = new DoubleNode(val);
        if (this.size == 0) {
            this.head = newHead;
            this.tail = newHead;
            this.size = 1;
        } else {
            newHead.next = this.head;
            this.head.prev = newHead;
            this.head = newHead;
            this.size++;
        }
    }

    /**
     * Append a DoubleNode of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        DoubleNode newTail = new DoubleNode(val);
        if (this.size == 0) {
            addAtHead(val);
        } else {
            this.tail.next = newTail;
            newTail.prev = this.tail;
            this.tail = newTail;
            this.size++;
        }
    }

    /**
     * Add a DoubleNode of value val before the index-th DoubleNode in the linked list. If index equals to the length of linked list, the DoubleNode will be appended to the end of linked list. If index is greater than the length, the DoubleNode will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == size)
            addAtTail(val);
        else if (index == 0)
            addAtHead(val);
        else if (index < size) {
            DoubleNode cur = this.head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            DoubleNode tmp = new DoubleNode(val);
            tmp.next = cur.next;
            tmp.prev = cur;
            cur.next.prev = tmp;
            cur.next = tmp;
            this.size++;
        }
    }

    /**
     * Delete the index-th DoubleNode in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (this.size > 0) {
            if (index == 0) {
                this.head = this.head.next;
                this.head.prev = null;
                this.size--;
                if (this.size == 0)
                    this.tail = this.head;
            } else if (index < this.size && index > 0) {
                DoubleNode cur = this.head;
                for (int i = 0; i < index - 1; i++) {
                    cur = cur.next;
                }
                if (index == size - 1) {
                    this.tail = cur;
                    cur.next = null;
                } else {
                    cur.next = cur.next.next;
                    cur.next.prev = cur;
                }
                this.size--;
            }

        }
    }
}

class DoubleNode {
    public int val;
    public DoubleNode next;
    public DoubleNode prev;

    public DoubleNode(int x) {
        this.val = x;
        this.next = null;
        this.prev = null;
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
