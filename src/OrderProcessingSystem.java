import model.Book;
import model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderProcessingSystem {
    public OrderQueue orderQueue = new OrderQueue(); // Initializing a queue for orders
    public List<Order> orderList = new ArrayList<>(); // For search and sorting

    //Add queue
    public void placeOrder(Order order) {
        orderQueue.enqueue(order);
        orderList.add(order);
    }

    //Dequeue
    public void processOrder() {
        if (!orderQueue.isEmpty()) {
            Order order = orderQueue.dequeue();
            System.out.println("Processing order: \n" + order + "\n");
        } else {
            System.out.println("Nothing to process");
        }
    }

    // Merge method
    private void merge(List<Book> books, int left, int mid, int right, String sortBy) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        List<Book> tempLeftArray = new ArrayList<>(n1);
        List<Book> tempRightArray = new ArrayList<>(n2);

        for (int i = 0; i < n1; i++)
            tempLeftArray.add(books.get(left + i));
        for (int j = 0; j < n2; j++)
            tempRightArray.add(books.get(mid + 1 + j));

        // Initial indexes of left and right arrays
        int i = 0, j = 0;
        int k = left;

        // Merge the temporary arrays back into books based on sort condition
        while (i < n1 && j < n2) {
            boolean condition;
            switch (sortBy) {
                case "title":
                    condition = tempLeftArray.get(i).title.compareTo(tempRightArray.get(j).title) <= 0;
                    break;
                case "author":
                    condition = tempLeftArray.get(i).author.compareTo(tempRightArray.get(j).author) <= 0;
                    break;
                case "quantity":
                    condition = tempLeftArray.get(i).quantity <= tempRightArray.get(j).quantity;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid sort criteria");
            }

            if (condition) {
                books.set(k, tempLeftArray.get(i));
                i++;
            } else {
                books.set(k, tempRightArray.get(j));
                j++;
            }
            k++;
        }

        // Copy remaining elements of tempLeftArray
        while (i < n1) {
            books.set(k, tempLeftArray.get(i));
            i++;
            k++;
        }

        // Copy remaining elements of tempRightArray
        while (j < n2) {
            books.set(k, tempRightArray.get(j));
            j++;
            k++;
        }
    }

    // Merge sort method
    private void mergeSort(List<Book> books, int left, int right, String sortBy) {
        if (left < right) {
            // Find the middle point
            int mid = (left + right) / 2;

            // Sort the first and second halves
            mergeSort(books, left, mid, sortBy);
            mergeSort(books, mid + 1, right, sortBy);

            // Merge the sorted halves
            merge(books, left, mid, right, sortBy);
        }
    }

    // Sorting orders by book title
    public void sortOrdersByBookTitle() {
        for (Order order : orderList) {
            mergeSort(order.books, 0, order.books.size() - 1, "title");
        }
    }

    // Sorting orders by book author
    public void sortOrdersByBookAuthor() {
        for (Order order : orderList) {
            mergeSort(order.books, 0, order.books.size() - 1, "author");
        }
    }

    // Sorting orders by book quantity
    public void sortOrdersByBookQuantity() {
        for (Order order : orderList) {
            mergeSort(order.books, 0, order.books.size() - 1, "quantity");
        }
    }

    // Sorting orders by order number using bubble sort
    public void sortOrdersByOrderNumber() {
        int n = orderList.size();

        // For loop controlling number of passes
        for (int i = 0; i < n - 1; i++) {
            // Inner loop for comparing adjacent orders
            for (int j = 0; j < n - i - 1; j++) {
                if (orderList.get(j).orderNumber > orderList.get(j + 1).orderNumber) {
                    // swap position if current order is greater than the next one
                    Order temp = orderList.get(j);
                    orderList.set(j, orderList.get(j + 1));
                    orderList.set(j + 1, temp);
                }
            }
        }
    }

    // Binary search for an order by order number
    public Order binarySearchOrder(int orderNumber) {
        sortOrdersByOrderNumber(); // Sort order list before binary search

        int left = 0;
        int right = orderList.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Order midOrder = orderList.get(mid);

            // Return if order number matched with
            if (midOrder.orderNumber == orderNumber) {
                return midOrder;
            } else if (midOrder.orderNumber < orderNumber) { // if order number is lower, Ignore left half
                left = mid + 1;
            } else { // if order number is lower, Ignore left half
                right = mid - 1;
            }
        }
        return null; // Order not found
    }

    // Outputting search result
    public void searchOrder(int orderNumber) {
        // Searching for an order using binary search
        Order foundOrder = binarySearchOrder(orderNumber);
        System.out.println("\nSearch result for order number: " + orderNumber);
        if (foundOrder != null) {
            System.out.println(foundOrder);
        } else { // Display message if order not found
            System.out.println("Order not found.");
        }
    }


    // Display all orders
    public void displayAllOrders() {
        orderQueue.displayQueue();
    }
}
