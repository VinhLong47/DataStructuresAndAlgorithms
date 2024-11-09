import model.Book;
import model.Order;

import java.util.*;

public class BookstoreDemo {
    public static void main(String[] args) {
        OrderProcessingSystem bookSystem = new OrderProcessingSystem();

        // Creating some orders and queue them
        List<Book> bookList1 = Arrays.asList(new Book("Whispers of the Forgotten Forest", "Andy James", 2),
                                             new Book("Echoes of the Midnight Sea", "Sophia Bennett", 1),
                                             new Book("The Last Ember of Winter", "Liam Foster", 5),
                                             new Book("Beneath a Broken Sky", "Isabella Murphy", 3),
                                             new Book("Tales from the Wandering Shore", "Noah Grant", 20),
                                             new Book("The Keeper of Lost Memories", "Ava Cooper", 5),
                                             new Book("Beyond the Starlit Veil", "Lucas Ramirez", 14));

        List<Book> bookList2 = Arrays.asList(new Book("Java Basics", "Author A", 2),
                                             new Book("Data Structures", "Author B", 1));


        Order order1 = new Order(101, "Olivier", "123 Somewhere St", bookList1);
        Order order2 = new Order(102, "Kim", "Nowhere Av", bookList2);

        bookSystem.placeOrder(order2);
        bookSystem.placeOrder(order1);

        // ======================== Sorting Book in Orders =============================//
        // Display orders before sorting
        System.out.println(" [ Orders before sorting ] \n");
        bookSystem.displayAllOrders();

        // Sorting orders by book title
        bookSystem.sortOrdersByBookTitle();

        // Display orders after sorting
        System.out.println("\n[ Orders after sorting by book title ]\n");
        bookSystem.displayAllOrders();
        System.out.println("============================================================");



        // ======================== Searching Book in Orders =============================//
        // Search order by order number
        bookSystem.searchOrder(101);
        System.out.println("\n==========================================================");



        // ======================== Processing Orders =============================//
        // Processing orders
        System.out.println("\n[ Processing orders ]\n");
        bookSystem.processOrder();

        // Display order again after processed
        System.out.println("\n [ Displaying Orders again ]");
        bookSystem.displayAllOrders();
        System.out.println("==========================================================");
    }
}
