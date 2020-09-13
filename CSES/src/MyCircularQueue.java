import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class MyCircularQueue {
    List<Integer> q;
    int maxSize;
    int actualSize;
    int tail;
    int head;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        q = new ArrayList<>(k);
        for(int i  = 0; i < k; i++){
            q.add(-1);
        }
        maxSize = k;
        tail = -1;
        head = -1;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if(isFull())
            return false;
        if(isEmpty())
            head = 0;
        tail = (tail + 1) % maxSize;
        actualSize++;
        q.set(tail,value);
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty())
            return false;

        head = (head + 1) % maxSize;

        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        q.set(head, -1);
        actualSize--;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if(isEmpty())
            return -1;
        else
            return q.get(head);
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if(isEmpty())
            return -1;
        else
            return q.get(tail);
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return actualSize == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (actualSize == maxSize);
    }

    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(3);
        boolean bool;
        int integer;
        obj.enQueue(1);
        obj.deQueue();
        obj.deQueue();
        obj.enQueue(4);
        int front = obj.Front();
        int rear = obj.Rear();

//        MyCircularQueue obj = new MyCircularQueue(2);
//        obj.Rear();
//        obj.deQueue();
//        obj.enQueue(4);
//        obj.enQueue(9);
//        obj.Front();
//        obj.Rear();
//        obj.deQueue();
//        obj.Front();
//        obj.deQueue();
//        obj.deQueue();
//        obj.Front();
//        obj.Rear();

    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */