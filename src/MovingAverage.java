public class MovingAverage {
    private MyCircularQueue data;
    private int currentSum;

    public MovingAverage(int size) {
        data = new MyCircularQueue(size);
        currentSum = 0;
    }

    public double next(int val) {
        if (data.isFull()) {
            currentSum -= data.Front();
            data.deQueue();
        }
        data.enQueue(val);
        currentSum += val;
        return Double.valueOf(currentSum) / data.size;
    }
}
