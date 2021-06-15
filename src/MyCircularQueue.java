public class MyCircularQueue {
    private int data[];
    private int p_start;
    private int p_tail;
    private int length;
    private int size;

    public MyCircularQueue(int k) {
        this.length = k;
        this.data = new int[length];
        this.p_start = 0;
        this.p_tail = 0;
        this.size = 0;
    }

    private int nextIdx(int i) {
        if (i+1 == length)
            return 0;
        else
            return i + 1;
    }

    private int prevIdx(int i) {
        if (i-1 == -1)
            return length - 1;
        else
            return i - 1;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;
        else {
            this.data[p_tail] = value;
            p_tail = nextIdx(p_tail);
            size++;
            return true;
        }
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        else {
            p_start = nextIdx(p_start);
            size--;
            return true;
        }
    }

    public int Front() {
        if (isEmpty())
            return -1;
        else
            return data[p_start];
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        else
            return data[prevIdx(p_tail)];
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean isFull() {
        return (size == length);
    }
}