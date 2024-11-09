import model.Order;

import java.util.LinkedList;
import java.util.Queue;

public class OrderQueue {
    public Queue<Order> queue = new LinkedList<>();

    public void enqueue(Order order) {
        queue.offer(order);
    }

    public Order dequeue() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void displayQueue() {
        if (!queue.isEmpty()) {
            for (Order order : queue) {
                System.out.println(order + "\n");
            }
        } else { // Display message when order is empty
            System.out.println("There are currently no orders!");
        }
    }
}
